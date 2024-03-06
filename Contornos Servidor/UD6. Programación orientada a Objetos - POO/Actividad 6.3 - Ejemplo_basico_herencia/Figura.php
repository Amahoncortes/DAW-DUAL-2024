<?php
class Figura
{
    protected int $num_lados;
    protected string $nombre;


    //getters y setters
    function set_nombre($nombre)
    {
        $this->nombre = $nombre;
    }

    function get_nombre()
    {
        return $this->nombre;
    }

    function set_numeroLados($num_lados)
    {
        $this->num_lados = $num_lados;
    }

    function get_numeroLados()
    {
        return $this->num_lados;
    }



    public function calcularArea()
    {
        echo "<p> Calculando el área de $this->nombre</p>";
    }

    public function __construct(string $nombre, int $num_lados = 0)
    {
        $this->nombre = $nombre;
        $this->num_lados = $num_lados;
    }

    public function verInformacion()
    {
        echo "Nombre: $this->nombre. Numero de lados: $this->num_lados";
    }






}