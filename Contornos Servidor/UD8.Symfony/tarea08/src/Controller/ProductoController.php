<?php

namespace App\Controller;

use App\Entity\Producto;
use App\Service\ProductoService;
use Exception;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Attribute\Route;
use Symfony\Component\Validator\Validator\ValidatorInterface;
use Throwable;

/**
 * Esta clase maneja la lógica del controlador para la Entidad Producto.
 * Incluye métodos para crear nuevos productos, listar productos, y mostrar detalles de productos.
 */
class ProductoController extends AbstractController
{
    /**
     * Este método maneja la creación de un nuevo producto.
     * El método comprueba si el usuario está autenticado y si la petición es POST.
     * Si la petición es correcta, crea una nueva entidad de producto y la almacena en la base de datos.
     * Si hay errores de validación, muestra mensajes de error.
     *
     * @param Request $request El objeto de petición.
     * @param ProductoService $productoService El servicio de producto.
     * @param ValidatorInterface $validator La interfaz de validación.
     * @return Response El objeto de respuesta.
     */
    #[Route('/producto/new', name: 'app_producto_new')]
    public function new(Request $request, ProductoService $productoService, ValidatorInterface $validator): Response
    {
        // Comprueba si el usuario está autenticado 
        if (!$this->isGranted('ROLE_USER')) {
            // Si no lo está, añade un mensaje flash de error 
            $this->addFlash("danger", "Debes iniciar sesión para acceder a esta página.");
            // Deniega acceso a usuarios no autenticados 
            $this->denyAccessUnlessGranted('ROLE_USER');
        }

        // Crea una nueva entidad Producto
        $producto = new Producto();

        // Comprueba si el método de request es POST 
        if ($request->getMethod() == 'POST') {
            // Si lo es, obtiene el nombre del producto y el precio a partir de la petición
            $nombre = $request->request->get('nombre');
            $precio = $request->request->get('precio');
            // Hace un parse de la fecha de creacion a partir de la petición y la establece en la entidad producto.
            $fecha = date_create_from_format('Y-m-d H:i', str_replace('T', ' ', $request->request->get('fechaCreacion')));
            $producto->setNombre($nombre);
            $producto->setPrecio($precio);
            $producto->setFechaCreacion($fecha);
            // Establece el usuario asociado con el producto
            $producto->setUser($this->getUser());

            // Valida la entidad de producto.
            $errores = $validator->validate($producto);

            // Si hay errores de validación, muestra mensajes de error.
            if (count($errores) > 0) {
                foreach ($errores as $error) {
                    $this->addFlash("danger", "Se ha producido un error: " . $error->getMessage());
                }

                return $this->redirectToRoute('app_producto_new');
            } else {
                // Si no hay errores de validación, crea una nueva entidad de producto y la almacena en la base de datos.
                try {
                    // Crea el producto en la base de datos
                    $productoService->create($producto);
                    // Añade un mensaje flash para mostrar que se ha registrado el producto correctamente.
                    $this->addFlash("success", "Validación correcta. Se ha registrado el producto correctamente.");
                    // Redirige a la lista de productos.
                    return $this->redirectToRoute('app_producto_list');
                } catch (Exception|Throwable $e) {
                    // Añade un mensaje flash para mostrar un mensaje de error. Add a flash message to display an error message
                    $this->addFlash("danger", "Error al crear el producto");
                }
            }
        }
        // Renderiza la plantilla de nuevo producto.
        return $this->render('producto/crear.html.twig', [
            'producto' => $producto,
        ]);
    }

    /**
     * Este método maneja el listado de los productos.
     * Le hace una consulta a la base de datos para obtener una lista de productos y renderiza la plantilla de listado de productos.
     * @param ProductoService $productoService EL servicio de producto.
     * @return Response El objeto de respuesta.
     */
    #[Route('/productos', name: 'app_producto_list')]
    public function listProductos(ProductoService $productoService): Response
    {
        // Comprueba si el usuario está autenticado
        if (!$this->isGranted('ROLE_USER')) {
            // Si no lo está, añade un mensaje flash de error
            $this->addFlash("danger", "Debes iniciar sesión para acceder a esta página.");
            // Deniega acceso a usuarios no autenticados
            $this->denyAccessUnlessGranted('ROLE_USER');
        }

        // Obtenemos el usuario autenticado actualmente
        $usuario = $this->getUser();

        // Obtiene la lista de todos los productos de la base de datos.
        //$productos = $productoService->list() ?: [];

        //modificamos la consulta para que solo traiga los productos del usuario actualmente autenticado
        $productos = $productoService->findByUser($usuario) ?: [];

        // Renderiza la plantilla de listado de productos.
        return $this->render('producto/list.html.twig', ['productos' => $productos]);
    }


    /**
     * Este método maneja el borrado de un producto
     * Recibe la ID del producto para borrar como parámetro
     * y utiliza el ProductoService para encontrar y borrar el producto
     * Si el producto no se encuentra, lanza una excepción
     * Si hay un error durante el borrado, añade un mensaje de error.
     * Finalmente, redirige al usuario a la lista de Productos.
     *
     * @param Request $request
     * @param ProductoService $productoService El ProductoService para encontrar y borrar el Producto.
     * @return Response El objeto de respuesta que redirige al usuario a la lista de Productos.
     */
    #[Route('/producto/delete', name: 'app_producto_delete')]
    public function deleteProduct(Request $request, ProductoService $productoService): Response
    {
        try {
            if ($request->getMethod() == 'POST') {
                $idProducto = $request->request->get('idProducto');

                // Intenta encontrar el producto con la ID dada usando el ProductoService.
                $producto = $productoService->findProductById($idProducto);

                // Si no encuentra el producto, lanza una excepción.
                if (!$producto) {
                    $this->addFlash('danger', 'Producto no encontrado');
                    return $this->redirectToRoute('app_producto_list');
                }

                //Si el id no se corresponde con ninguna entidad existente,
                //deberá mostrar un mensaje flash significativo y redirigir al listado
                if ($producto->getId() != $idProducto) {
                    $this->addFlash('danger', 'Producto no encontrado');
                    return $this->redirectToRoute('app_producto_list');
                }

                // Si el usuario relacionado con la entidad a eliminar no es el usuario autenticado,
                // deberá mostrar un mensaje flash significativo y redirigir al listado

                if ($producto->getUser() !== $this->getUser()) {
                    $this->addFlash('danger', 'No puedes borrar este producto');
                    return $this->redirectToRoute('app_producto_list');
                }
                // Intenta borrar el producto usando el ProductoService.
                $productoService->delete($producto);

                // Si se cumplen los requisitos, se eliminará la entidad, se mostrará un mensaje flash de éxito y se redirigirá al listado.
                $this->addFlash('success', 'El producto fue eliminado correctamente');
                return $this->redirectToRoute('app_producto_list');
            }
        } catch (Exception|Throwable $e) {
            // Añade un mensaje flash para mostrar un mensaje de error.
            $this->addFlash("danger", "Error al borrar el producto");
        }
        // Redirección Redirect the user to the 'app_cuadros_creados' route
        return $this->redirectToRoute('app_producto_list');
    }
}
