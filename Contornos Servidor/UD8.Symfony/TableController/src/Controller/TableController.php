<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Attribute\Route;

class TableController extends AbstractController
{
    #[Route('/table/{filas?}/{cols?}', name: 'app_table', methods: ['GET', 'HEAD'], defaults: ['filas' => 4, 'cols' => 4], requirements: ['filas' => '\d+', 'cols' => '\d+'])]

    public function index(int $filas, int $cols): Response
    {
        //f) Crea un array bidimensional de números enteros aleatorios entre 0 y 100 de tantas filas y columnas como se indique en la URL (o por su valor por defecto).
        //g) Muestra en la plantilla correspondiente:
        //El número de filas, número de columnas y una tabla con los valores generados en el array bidimensional.

        //Crear un array bidimensional
        $array_bidimensional = [];
        //Iterar sobre las filas
        for ($i = 0; $i < $filas; $i++) {
            //Crear un array para almacenar los números de cada fila
            $fila = [];
            //Iterar sobre las columnas
            for ($j = 0; $j < $cols; $j++) {
                $fila[] = rand(0, 100);
            }
            //Agregar la fila completa al array bidimensional
            $array_bidimensional[] = $fila;
        }

        return $this->render('table/index.html.twig', [
            'controller_name' => 'TableController',
            'table' => $array_bidimensional,
        ]);
    }
}
