<?php

namespace App\Validator;

use Symfony\Component\Validator\Constraint;

/**
 * ProductoNombreUnico es un constraint de validacion de Symfony.

 * Este constraint se utiliza en la clase Producto para validar que el nombre de un producto sea unico en la base de datos. 
 * Este código define una nueva clase llamada ProductoNombreUnico que extiende la clase Symfony Validator Constraint.
 * La sintaxis de #[\Attribute] indica que esta clase es un atributo de la clase, lo que significa que puede ser usado
 * como un atributo para otras clases o métodos. La clase tiene un solo atributo llamado $message que es una cadena
 * que se muestra cuando la validación falla. El método getTargets() devuelve la cadena "CLASS_CONSTRAINT" que indica
 * que este constraint se aplica a la clase, no a una propiedad de la clase.
 */
#[\Attribute]
class ProductoNombreUnico extends Constraint
{
    /**
     * La propiedad $message es una cadena que se muestra cuando la validación falla.
     * El string "El nombre {{ value }} ya está en uso." es una cadena que se muestra cuando la validación falla,
     * porque el nombre ya existe en la base de datos.
     * 
     * @var string
     */
    public string $message = 'El nombre "{{ value }}" ya está en uso.';

    /**
     * El método getTargets() devuelve la cadena "CLASS_CONSTRAINT" que indica que este constraint se aplica a la clase,
     * no a una propiedad de la clase.
     * 
     * @return string
     */
    public function getTargets(): string
    {
        return self::CLASS_CONSTRAINT;
    }
}

