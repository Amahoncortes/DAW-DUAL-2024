<?php
/*
     A clase Academia: almacenará o seu nome nunha constante e debe permitir engadir Profesores e Alumnos.

Para probalo debes facer o seguinte:
– Engade á academia un profesor que imparte 4 bailes (entre eles AFRO, e un deles duplicado) e 2 alumnos.
– Mostra información do profesores (incluíndo o soldo e os bailes que imparte) e dos alumnos incluíndo a cota que deberá pagar.
– O profesor deixa de dar clase de AFRO. Actualiza a información da academia e volve a mostrar a información do profesor.

    Impide a herdanza das clases Alumno e Profesor.
*/

final class Alumno extends Persoa
{

    private $numClases;

    function __construct(string $nome, string $apelidos, string $mobil, int $numClases)
    {
        parent::__construct($nome, $apelidos, $mobil);
    }


    public function setNumClases(int $numClases)
    {
        $this->numClases = $numClases;
    }

    public function aPagar()
    {
        if ($this->numClases === null) {
            echo "Debe indicar previamente o número de clases";
        } else {
            $importe = 0;
            switch ($this->numClases) {

                case 1:
                    $importe = 20;
                    break;

                case 2:
                    $importe = 32;
                    break;

                default:
                    if ($this->numClases >= 3) {
                        $importe = 40;
                    }
                    break;
            }
            echo "Importe: " . $importe . " €";
        }
    }
}
?>