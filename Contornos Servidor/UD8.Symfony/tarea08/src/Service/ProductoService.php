<?php

namespace App\Service;
use App\Entity\Producto;
use App\Repository\ProductoRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Component\Validator\Validator\ValidatorInterface;


class ProductoService{

    private $entityManager;
    private $productoRepository;
    private $validator;

    public function __construct(EntityManagerInterface $entityManager, ProductoRepository $productoRepository, ValidatorInterface $validator)
    {
        $this->entityManager = $entityManager;
        $this->productoRepository = $productoRepository;
        $this->validator = $validator;
    }

    public function create(Producto $producto)
    {
        // Make the Producto object managed by the EntityManager
        $this->entityManager->persist($producto);

        // Persist the changes made to the Producto object to the database
        $this->entityManager->flush();
    }

    public function list()
    {
        return $this->entityManager->getRepository(Producto::class)->findAll();
    }
}

