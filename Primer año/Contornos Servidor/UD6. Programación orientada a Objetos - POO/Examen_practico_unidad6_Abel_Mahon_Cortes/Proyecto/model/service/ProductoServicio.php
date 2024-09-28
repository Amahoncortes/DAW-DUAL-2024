<?php

class ProductoServicio
{
    const RUTA_FICHEROS_CONST = DIRECTORY_SEPARATOR . IMAGES_FOLDER . DIRECTORY_SEPARATOR;
    const SEPARADOR_NOMBRE_FICHERO = "_";

    private IProductoRepository $repository;

    public function __construct()
    {
        $this->repository = new ProductoRepository();
    }

    /* obtenemos todos los productos */

    public function getAllProducts(): array
    {
        $productos = $this->repository->findAll();
        return $productos;
    }

    /* 5- Crea una clase ProductoServicio con el método list() que recupere, a través de ProductoRepository, un array con objetos de la clase Producto con los productos ordenados por nombre. Deberá devolver dicho array. (1 punto) */

    public function list($nombre)
    {
        if (is_null($nombre)) {
            return false;
        }
        return $this->repository->read($nombre);
    }

    /* Save note */

    //Se usa para crear una nueva nota y para editar una ya existente
    public function save(Producto $producto, array $fileInfoArray = null)
    {

        $imgOld = "";
        $exists = false;
        if (!is_null($id = $producto->getId())) {
            $exists = true;
        }
        if ($exists) {



            if ($this->repository->update($producto)) {
                $notaToVista = $producto;
            } else {
                $notaToVista = new Producto();
                $notaToVista->setStatus(Util::OPERATION_NOK);
            }
        } else {
            $notaToVista = $this->repository->create($producto);
        }
    }
}

?>