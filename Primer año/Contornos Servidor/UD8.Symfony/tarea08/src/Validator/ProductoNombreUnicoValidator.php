<?php

namespace App\Validator;

use App\Entity\Producto;
use App\Repository\ProductoRepository;
use Symfony\Component\Validator\Constraint;
use Symfony\Component\Validator\ConstraintValidator;
use Symfony\Component\Validator\Exception\UnexpectedTypeException;

/**
 * Esta clase es un validador personalizado que se asegura de que la propiedad nombre de la entidad Producto sea único.
 * Extiende el validador Symfony\Component\Validator\ConstraintValidator e implementa el método validate().
 * El método validate() se llama por el validador Symfony cuando se realiza la validación.
 * El método validate() comprueba si la propiedad nombre de la entidad Producto es único consultando la base de datos.
 */
class ProductoNombreUnicoValidator extends ConstraintValidator
{
    /**
     * La instancia de ProductoRepository
     * @var ProductoRepository
     */
    private ProductoRepository $productoRepository;

    /**
     * Constructor que inicializa la instancia de ProductoRepository.
     * @param ProductoRepository $productoRepository
     */
    public function __construct(ProductoRepository $productoRepository)
    {
        $this->productoRepository = $productoRepository;
    }

    /**
     * Valida el objeto de la clase Producto.
     * @param mixed $producto el objeto producto a validar.
     * @param Constraint $constraint El objeto constraint
     * @throws UnexpectedTypeException Si el objeto $producto no es del tipo esperado.
     */
    public function validate($producto, Constraint $constraint)
    {
        // Comprueba si el objeto constraint es una instancia de la clase ProductoNombreUnico. 
        if (!$constraint instanceof ProductoNombreUnico) {
            throw new UnexpectedTypeException($constraint, ProductoNombreUnico::class);
        }

        // Comprueba si el objeto producto es una instancia de la clase Producto.
        if (!$producto instanceof Producto) {
            throw new UnexpectedTypeException($producto, Producto::class);
        }

        // Obtiene el valor de la propiedad "nombre" del objeto Producto.
        $nombre = $producto->getNombre();

        // Si el valor de la propiedad "nombre" es nulo o vacío, no se realiza la validación. 
        if (null === $nombre || '' === $nombre) {
            return;
        }

        // Hace una consulta a la base de datos para obtener todos los objetos de la clase Producto que tengan el mismo valor de la propiedad "nombre".
        $productoConMismoNombre = $this->productoRepository->findOneBy(['nombre' => $nombre]);
        
        // Verifica si hay algún producto en la base de datos con el mismo nombre que el producto que se está validando.
        // Si se encuentra otro producto con el mismo nombre, se lanza una excepción con el mensaje definido en la restricción.
        
        // Comprueba si el objeto $productoConMismoNombre es distinto de null.
        // Si es distinto de null, significa que se encontró un producto con el mismo nombre en la base de datos.
        if ($productoConMismoNombre !== null) {
            
            // Ahora verifica si el ID del producto que se está validando es diferente al ID del producto encontrado en la base de datos.
            // Esto es necesario para evitar que la validación falle cuando se está actualizando un producto y su nombre no ha cambiado.
            if ($producto->getId() !== $productoConMismoNombre->getId()) {
                
                // Se llama al método buildViolation del objeto $this->context.
                // Este método se encarga de construir una nueva violación de validación.
                // El mensaje de la violación será el mensaje definido en la restricción.
                $this->context->buildViolation($constraint->message)
                    
                    // Se establece el parámetro "{{ value }}" con el nombre del producto que se está validando.
                    // Este parámetro se puede utilizar en el mensaje de la violación para mostrar el nombre del producto en el mensaje final.
                    ->setParameter('{{ value }}', $nombre)
                    
                    // Se agrega la violación al contexto de validación.
                    ->addViolation();
            }
        }
    }
}

