<?php
final class Profesor extends Persoa
{
    //Propiedades
    //NIF
    private $nif;
    const IMPORTE_HORA = 16;

    //Array de bailes
    private $bailes = [];

    //Métodos
    public function __construct(
        string $nome,
        string $apelidos,
        string $mobil,
        string $nif
    ) {
        parent::__construct($nome, $apelidos, $mobil);
        $this->nif = $nif;
    }

    function calcularSoldo(
        float $numHoras,
        float $importe_hora = self::IMPORTE_HORA
    ): float {
        return $numHoras * $importe_hora;
    }

    /*O profesor terá 3 métodos para engadir os Bailes que imparte, eliminar un baile cando deixe de impartilo e para devolver os bailes que imparte da forma:
       HIP HOP (idade min: 8 anos)
       Antes de engadir un baile debe comprobar se xa está dado de alta para ese profesor.*/

    public function engadirBaile(Baile $baile): bool
    {
        $engadido = false;
        if (!in_array($baile, $this->bailes)) {
            $this->bailes[] = $baile;
        }
        return $engadido;
    }

    function eliminarBaile(Baile $baile): bool
    {
        $eliminado = false;
        if (in_array($baile, $this->bailes)) {
            unset($this->bailes[array_search($baile, $this->bailes)]);
            $eliminado = true;
        }
        return $eliminado;
    }

    function devolverBailes()
    {

    }

}
?>