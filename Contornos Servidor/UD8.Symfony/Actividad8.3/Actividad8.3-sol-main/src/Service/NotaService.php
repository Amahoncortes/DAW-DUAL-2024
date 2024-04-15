<?php
namespace App\Service;

use App\Entity\Nota;
use Doctrine\ORM\EntityManagerInterface;

class NotaService 
{

 
    // Constructor promotion
    //https://www.php.net/manual/en/language.oop5.decon.php#language.oop5.decon.constructor.promotion

    //$entityManager es una propiedad privada de la clase
    public function __construct( private EntityManagerInterface $entityManager) {
       
       
    }
    public function create (Nota $nota)
    {
        $this->entityManager->persist($nota);
        $this->entityManager->flush();
    }
}
