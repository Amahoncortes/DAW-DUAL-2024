<?php
class Baile
{
    //Propiedades
    //Nome
    private $nome;
    private $idadeMinima = 8;

    public function __construct(string $nome, int $idadeMinima){
        $this->nome = $nome;
        $this->idadeMinima = $idadeMinima;
    }
}
    
?>