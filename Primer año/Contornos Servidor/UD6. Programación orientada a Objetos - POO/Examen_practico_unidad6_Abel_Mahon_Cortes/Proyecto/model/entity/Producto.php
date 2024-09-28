<?php

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Scripting/PHPClass.php to edit this template
 */

/**
 * * Ej. 2 Crea una clase Producto que corresponda con la 
 * estructura que hemos visto de MVC
 * y sus propiedades privadas.
 * @author Abel 
 */

class Producto implements JsonSerializable
{

    //Haz que la clase Producto utilice el trait ViewData 
    use ViewData;

    //id (int nullable)
    private ?int $id = null;

    //nombre (string)
    private string $nombre = "";

    //nombre_corto (string)
    private string $nombreCorto = "";

    //descripcion (string)
    private string $descripcion = "";

    //pvp (float)
    private ?float $pvp = null;

    //familia (string)
    private string $familia = "";


    /*GETTERS Y SETTERS*/

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getNombre(): string
    {
        return $this->nombre;
    }

    public function getNombreCorto(): string
    {
        return $this->nombreCorto;
    }

    public function getDescripcion(): string
    {
        return $this->descripcion;
    }

    public function getPVP(): float
    {
        return $this->pvp;
    }

    public function getFamilia(): string
    {
        return $this->familia;
    }

    public function setId(?int $id): void
    {
        $this->id = $id;
    }

    public function setNombre(string $nombre): void
    {
        $this->nombre = $nombre;
    }

    public function setNombreCorto(string $nombreCorto): void
    {
        $this->nombreCorto = $nombreCorto;
    }

    public function setPVP(?float $pvp)
    {
        $this->pvp = $pvp;
    }

    public function setFamilia(string $familia)
    {
        $this->familia = $familia;
    }



    public function jsonSerialize()
    {
        //Especificamos qué propiedades no públicas queremos que pasen a formar parte del objeto JSON
        return array(
            'id' => $this->id,
            'titulo' => $this->nombre,
            'contenido' => $this->nombreCorto,
        );
    }



}
