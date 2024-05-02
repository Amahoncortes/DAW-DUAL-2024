<?php

namespace App\Controller;

use App\Entity\Producto;
use App\Service\ProductoService;
use DateTime;
use App\Repository\ProductoRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Attribute\Route;
use Symfony\Component\Validator\Validator\ValidatorInterface;
use Symfony\Component\HttpKernel\Exception\NotFoundHttpException;
use Throwable;

class ProductoController extends AbstractController
{
    #[Route('/producto/new', name: 'app_producto_new')]
    # Este método maneja la creación de una nueva entidad Producto.
    public function new(Request $request, ProductoService $productoService, ValidatorInterface $validator): Response
    {
        if (!$this->isGranted('ROLE_USER')) {
            $this->addFlash("danger", "Debes iniciar sesión para acceder a esta página.");
            $this->denyAccessUnlessGranted('ROLE_USER');
        }

        # Crea una nueva instancia de la clase Producto.
        $producto = new Producto();

        if ($request->getMethod() == 'POST') {
            $nombre = $request->request->get('nombre');
            $precio = $request->request->get('precio');
            //$fecha = date_create_from_format('Y-m-d H:i', $request->request->get('fechaCreacion'));
            $fecha = date_create_from_format('Y-m-d H:i', str_replace('T', ' ', $request->request->get('fechaCreacion')));
            $producto->setNombre($nombre);
            $producto->setPrecio($precio);
            $producto->setFechaCreacion($fecha);
            $producto->setUser($this->getUser());


            $errores = $validator->validate($producto);

            if (count($errores) > 0) {
                foreach ($errores as $error) {
                    $this->addFlash("danger", "Se ha producido un error: " . $error->getMessage());
                }
                return $this->redirectToRoute('app_producto_new');
            } else {
                try {
                    $productoService->create($producto);
                    $this->addFlash("success", "Se ha registrado el producto correctamente.");
                    return $this->redirectToRoute('app_producto_list');
                } catch (\Exception | Throwable $e) {
                    $this->addFlash("danger", "Error al crear el producto");
                }
            }
        }
        return $this->render('producto/crear.html.twig', [
            'producto' => $producto,
        ]);
    }


    #[Route('/productos', name: 'app_producto_list')]
    public function listProductos(ProductoService $productoService): Response
    {
        $productos = $productoService->list() ?: [];

        return $this->render('producto/list.html.twig', ['productos' => $productos]);
    }


    #[Route('/producto/{id}', name: 'app_producto_show')]
    public function showProduct(ProductoRepository $repository, int $id): Response
    {
        $producto = $repository->find($id);

        if (!$producto) {
            throw new NotFoundHttpException(sprintf('No se encontró el producto con la id "%s"', $id));
        }

        return $this->render(
            'producto/detail.html.twig',
            ['producto' => $producto]
        );
    }
}
