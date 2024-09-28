# Tarea08DWCS

## Comando para crear el proyecto de Symfony:
`composer create-project symfony/skeleton:"7.0.*" tarea08:`

## Nombre de usuario:
`nombre usuario a20abelmc`

## comando para crear Base de Datos:
`php bin/console doctrine:database:create`

## Url del repositorio:
`https://github.com/Amahoncortes/Tarea08DWCS.git`

## URL con información  para obtener el usuario autenticado:
`https://symfony.com/doc/current/security.html#access-control-authorization`

## Validación personalizada:
`Introduzco 2 validaciones personalizadas, una para validar que el nombre no tenga más de 20 caracteres
y otra pedida por la profesora en el ejercicio para que no se introduzca un producto (entidad) con el mismo nombre
(atributo String) que uno ya existente.
La validacion consiste en que, al llamar al validador, se comprueba la condición de si hay algún producto
en la base de datos con el mismo nombre que el que se está validando, pero un id diferente.
Si encuentra uno de esas características, implica que ya hay un producto con ese nombre en la BD, por tanto se activa la violacion de la validación
y no permite guardar el producto, mostrando un mensaje de error.`


## Añade en el README por qué dos propiedades ordenas:
`Ordeno primero por nombre del producto en orden ascendente (A-Z) y después por fechaCreacion en orden
descendente (de más reciente a menos).`


## Fuerza que, tras el registro de usuario, se redirija a la página de login. Indica en el README, qué cambiaste y dónde
`En src/Controller/RegistrationController.php, adición de la línea return $this->redirectToRoute('app_login')
justo después de añadir al usuario en la base de datos.`

## Fuerza que, tras el login exitoso, se redirija al listado de entidades del apartado 3. Indica en el README, qué cambiaste y dónde
`En el directorio de carpetas config/packages/security.yaml, bajo la categoría de form_login: añadimos
la línea default_target_path: app_producto_list, para especificar la ruta
a la que se redirige a un usuario tras un login exitoso. Le ponemos la lista de productos en dicha ruta.
Fuente de la que obtuve la información: https://symfony.com/doc/current/security/form_login.html#changing-the-default-page`