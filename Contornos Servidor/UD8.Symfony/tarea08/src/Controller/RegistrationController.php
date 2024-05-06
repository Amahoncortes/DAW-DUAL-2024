<?php

namespace App\Controller;

use App\Entity\User;
use App\Form\RegistrationFormType;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\PasswordHasher\Hasher\UserPasswordHasherInterface;
use Symfony\Component\Routing\Attribute\Route;

class RegistrationController extends AbstractController
{
    #[Route('/register', name: 'app_register')]
    public function register(Request $request, UserPasswordHasherInterface $userPasswordHasher, EntityManagerInterface $entityManager): Response
    {
        // Crea una nueva instancia de User
        $user = new User();

        // Crear un formulario basado en RegistrationFormType para el usuario.
        $form = $this->createForm(RegistrationFormType::class, $user);

        // Maneja el envio de formulario. Se obtienen los datos de la petición.
        $form->handleRequest($request);

        // Comprueba si el form ha sido enviado y si es valido.
        if ($form->isSubmitted() && $form->isValid()) {
            // Codifica la contraseña usando el UserPasswordHasher.
            $user->setPassword(
                $userPasswordHasher->hashPassword(
                    $user,
                    $form->get('plainPassword')->getData()
                )
            );

            // Persiste la instancia de User en la base de datos.
            $entityManager->persist($user);
            $entityManager->flush();

            // Redirige a la lista de productos después de registrar un nuevo usuario.
            return $this->redirectToRoute('app_login');
        }

        // Si el envío del formulario no es válido, renderiza el formulario de registro
        return $this->render('registration/register.html.twig', [
            'registrationForm' => $form,
        ]);
    }
}
