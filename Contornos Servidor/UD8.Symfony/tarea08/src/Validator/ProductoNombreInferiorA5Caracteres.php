<?php

namespace App\Validator;

use Symfony\Component\Validator\Constraint;

/**
 * @Annotation
 *
 * @Target({"PROPERTY", "METHOD", "ANNOTATION"})
 */
#[\Attribute]
class ProductoNombreInferiorA5Caracteres extends Constraint
{
    /*
    Incorpora una validación básica previa a la creación de una entidad de forma que no se puedan crear nuevas entidades si no se cumplen determinadas reglas.
    Por ejemplo, que la propiedad de tipo String deba tener menos de 5 caracteres.
    Añade mensajes flash para informar al usuario del éxito o fracaso de la operación.
     */
    public $message = 'The value "{{ value }}" is not valid.';

    public function getTargets(): string
    {
        //para que se pueda utilizar a nivel de clase y el validador reciba un objeto como el primer parámetro en validate()
        return self::CLASS_CONSTRAINT;
    }
}
