<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Attribute\Route;

class TestController extends AbstractController
{
    #[Route('/test', name: 'app_test')]
    public function index(): Response
    {
        return $this->render('test/index.html.twig', [
            'controller_name' => 'TestController',
        ]);
    }

    #[Route('/test/number/{!max<\d+>}', name: 'app_test_number', methods:['GET', 'HEAD'])]
    public function number(int $max): Response
    {
        $number = random_int(0, $max);
        return new Response(
            '<html><body>Numero de la suerte: ' . $number . '</body></html>'
        );
    }
}
