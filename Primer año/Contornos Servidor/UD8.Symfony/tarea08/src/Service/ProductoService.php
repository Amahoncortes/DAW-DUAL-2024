<?php

namespace App\Service;

use App\Entity\Producto;
use App\Repository\ProductoRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Component\Validator\Validator\ValidatorInterface;


class ProductoService
{

    private EntityManagerInterface $entityManager;
    private ProductoRepository $productoRepository;
    private ValidatorInterface $validator;

    public function __construct(EntityManagerInterface $entityManager, ProductoRepository $productoRepository, ValidatorInterface $validator)
    {
        $this->entityManager = $entityManager;
        $this->productoRepository = $productoRepository;
        $this->validator = $validator;
    }

    public function create(Producto $producto): void
    {
        // Make the Producto object managed by the EntityManager
        $this->entityManager->persist($producto);

        // Persist the changes made to the Producto object to the database
        $this->entityManager->flush();
    }

    public function delete(Producto $producto): void
    {
        $this->entityManager->remove($producto);
        $this->entityManager->flush();
    }


    public function list(): array
    {
        return $this->entityManager->getRepository(Producto::class)->findAll();
    }

    public function findByUser($user): array
    {
        //Modificamos la consulta para que solo traiga los productos del usuario actualmente autenticado
        //return $this->entityManager->getRepository(Producto::class)->findBy(['user' => $user]);

        //Filtramos por el usuario actual autenticado y ordenamos por nombre y fecha de creacion
        return $this->entityManager->getRepository(Producto::class)
            ->findBy(
                ['user' => $user],
                ['nombre' => 'ASC', 'fechaCreacion' => 'DESC']
            );
    }

    public function findProductById($id)
    {
       return $this->entityManager->getRepository(Producto::class)->find($id);
    }
}
