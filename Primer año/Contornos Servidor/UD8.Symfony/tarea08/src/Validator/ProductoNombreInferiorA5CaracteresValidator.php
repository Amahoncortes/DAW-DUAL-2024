<?php

namespace App\Validator;

use App\Repository\ProductoRepository;
use Symfony\Component\Validator\Constraint;
use Symfony\Component\Validator\ConstraintValidator;

class ProductoNombreInferiorA5CaracteresValidator extends ConstraintValidator
{

    public function __construct(protected ProductoRepository $repository){
        
    }

    public function validate($value, Constraint $constraint)
    {
        /** @var ProductoNombreInferiorA5Caracteres $constraint */

        if (null === $value || '' === $value) {
            return;
        }

        // TODO: implement the validation here
        $this->context->buildViolation($constraint->message)
            ->setParameter('{{ value }}', $value)
            ->addViolation();
    }
}
