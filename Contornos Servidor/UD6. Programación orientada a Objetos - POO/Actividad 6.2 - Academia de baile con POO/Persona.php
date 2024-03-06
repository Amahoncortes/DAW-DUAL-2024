<?php
class Persoa
{

    //Declaracion de propiedades 
    //nome
    private $nome;

    //apelidos
    private $apelidos;

    //mobil
    private $mobil;

    //

     function __construct(string $nome, string $apelidos, string $mobil)
    {
        $this->nome = $nome;
        $this->apelidos = $apelidos;
        $this->mobil = $mobil;

    }

    public function verInformación($nome, $apelidos, $mobil)
    {
        echo "$nome $apelidos $mobil";
    }
}
?>