<?php

//Inicio de sesion
session_start();

require_once 'util_cookies.php';

//Verificamos si el usuario está almacenado en la sesion. Si no lo está, lo redirigimos a dicha página.

if (!isset($_SESSION['nombre'])) {
    header('Location:login.php');
}

//Datos de conexión a BBDD
require_once 'conexion.php';

//Consulta a BBDD
$consulta = "select id, nombre, pvp from productos order by nombre";
$stmt = $conProyecto->prepare($consulta);

//Manejo de excepciones PDO durante la consulta
try {
    $stmt->execute();
} catch (PDOException $ex) {
    cerrarTodo($conProyecto, $stmt);
    die("Error al recuperar los productos " . $ex->getMessage());
}
?>

<!--HTML-->
<!doctype html>
<html lang="es">

<head>
    <!--   metadatos y hojas de estilo -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <!-- css para usar Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <!-- css Fontawesome CDN-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <title>Cesta de la compra</title>
</head>

<!--Si pulsamos el botón vaciar carro, se elimina la variable de sesion de la cesta-->
<?php
if (isset($_POST['vaciar'])) {
    unset($_SESSION['cesta']);
}
if (isset($_POST['comprar']) && isset($_POST["unidad"])) {
    $datos = consultarProducto($_POST['id']);
    if ($datos !== false) {

        if (!isset($_SESSION['cesta'][$datos->id])) {
            $_SESSION['cesta'][$datos->id] = $_POST["unidad"];
        } else {
            $_SESSION['cesta'][$datos->id] += $_POST["unidad"];
        }

        gestionar_cookie_familia($datos->familia);
    }
}
?>

<body style="background: gray">
    <?php require_once 'header_view.php' ?>
    <br>
    <h4 class="container text-center mt-4 font-weight-bold">Tienda onLine</h4>
    <div class="container mt-3">
        <form class="form-inline" name="vaciar" method="POST" action='<?php echo $_SERVER['PHP_SELF']; ?>'>
            <a href="cesta.php" class="btn btn-success mr-2">Ir a Cesta</a>
            <input type='submit' value='Vaciar Carro' class="btn btn-danger" name="vaciar">
        </form>
        <table class="table table-striped table-dark mt-3">
            <thead>
                <tr class="text-center">
                    <th scope="col">Añadir</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Unidades</th>
                    <th scope="col">Añadido</th>
                </tr>
            </thead>
            <tbody>
                <?php
                /*Recorre cada fila de resultados obtenidos de la consulta. fetch(PDO::FETCH_OBJ) recupera la siguiente fila como un objeto.*/
                while ($filas = $stmt->fetch(PDO::FETCH_OBJ)) {
                    echo "<tr>";
                    // BOTON AÑADIR e atributo ID
                    echo "<th scope='row' class='text-center'>";
                    echo  "<form id ='addProductForm{$filas->id}' action='{$_SERVER['PHP_SELF']}' method='POST'>";
                    echo "<input type='hidden' name='id' value='{$filas->id}'>";
                    echo "<input type='submit' class='btn btn-primary' name='comprar' value='Añadir'>";
                    echo "</form>";
                    echo "</th>";

                    //NOMBRE 
                    echo "<td class='text-center'>{$filas->nombre}, Precio: {$filas->pvp} (€)</td>";

                    // UNIDADES 
                    echo "<td class='text-center'>";
                    echo "<input form='addProductForm{$filas->id}' type='number' name='unidad' value='1' min='1' max='3'>";
                    echo "</td>";

                    // ICONO
                    echo "<td class='text-center'>";
                    if (isset($_SESSION['cesta'][$filas->id])) {
                        echo "<i class='fas fa-check fa-2x'></i>";
                    } else {
                        echo "<i class='far fa-times-circle fa-2x'></i>";
                    }
                    echo "</td>";
                    echo "</tr>";
                }

                /* Después de completar el bucle, se llama a cerrarTodo() para cerrar la conexión a la base de datos y liberar recursos del statement*/
                cerrarTodo($conProyecto, $stmt);
                ?>
            </tbody>
        </table>

    </div>
</body>

</html>