<?php

class ProductoRepository extends BaseRepository implements IProductoRepository
{

    public function __construct()
    {
        parent::__construct();
        $this->table_name = "productos";
        $this->pk_name = "id";
        $this->class_name = "Producto";
        $this->default_order_column = "nombre";
    }



    /**
     *Deja los metodos create y update sin implementacion (con un return del tipo adecuado)
     */

    public function create($object): null
    {
        /*$stmt = $this->conn->prepare("UPDATE $this->table_name set titulo =?, contenido = ?, imagePath=? WHERE $this->pk_name = ?");
        $stmt->bindValue(1, $object->getTitulo());
        $stmt->bindValue(2, $object->getContenido());
        $stmt->bindValue(3, $object->getImagePath());
        $stmt->bindValue(4, $object->getId());
        $exito = $stmt->execute();
        //$stmt->debugDumpParams();
        return $exito;
        */
        return null;
    }

    public function update($object): null
    {

        /* Devuelve null
        $stmt = $this->conn->prepare("UPDATE $this->table_name set titulo =?, contenido = ?, imagePath=? WHERE $this->pk_name = ?");
        $stmt->bindValue(1, $object->getTitulo());
        $stmt->bindValue(2, $object->getContenido());
        $stmt->bindValue(3, $object->getImagePath());
        $stmt->bindValue(4, $object->getId());
        $exito = $stmt->execute();
        //$stmt->debugDumpParams();
        return $exito;
*/
        return null;
    }







}
