<div class="float float-right d-inline-flex mt-2">
    <!-- Icono de carrito de compras -->
    <i class="fa fa-shopping-cart mr-2 fa-2x"></i>

    <?php
    // Función para contar elementos en la cesta de compras (carrito)
    function count_cart_elements()
    {
        // Suma los valores de la cesta de compras
        return array_sum($_SESSION["cesta"]);
    }

    // Verifica si existe la sesión 'cesta'
    if (isset($_SESSION['cesta'])) {
        // Obtiene la cantidad de elementos en la cesta utilizando la función
        $cantidad = count_cart_elements();

        // Muestra el número de elementos en la cesta en un campo de texto deshabilitado
        echo "<input type='text' disabled class='form-control mr-2 bg-transparent text-white' value='$cantidad' size='2px'>";
    } else {
        // Si no hay sesión 'cesta', muestra 0 en el campo de texto deshabilitado
        echo "<input type='text' disabled class='form-control mr-2 bg-transparent text-white' value='0' size='2px'>";
    }
    ?>

    <!-- Icono de usuario -->
    <i class="fas fa-user mr-3 fa-2x"></i>

    <!-- Muestra el nombre de usuario en un campo de texto deshabilitado -->
    <input type="text" size='10px' value="<?php echo $_SESSION['nombre']; ?>"
        class="form-control mr-2 bg-transparent text-white" disabled>

    <!-- Enlace para cerrar sesión -->
    <a href="cerrar.php" class="btn btn-warning mr-2">Salir</a>
</div>