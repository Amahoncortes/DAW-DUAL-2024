<!doctype html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-
scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- css para usar Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Acceso a MongoDB</title>
</head>

<body>
    <h3 class="text-center mt-2 font-weight-bold">Acceso a MongoDB</h3>
    <div class="container mt-3">

        <?php

  
        if (isset($_GET["oid"])) {
            $oid = $_GET["oid"];
         
           

            if (isset($document)) {
                //mostrar el contenido del $document
                echo "<pre>";
                var_dump($document);
                echo "</pre>";
            } else { ?>
                <div class="alert alert-danger" role="alert">
                    No se ha encontrado el documento
                </div>
            <?php
            }
        } else {
            ?>
            <div class="alert alert-danger" role="alert">
                <p>
                    No se ha encontrado el argumento oid en la URL.
                    
                </p>
                <p>Pruebe con un oid de un documento de sample restaurants, por ejemplo:</p>
                     <p> localhost:3000/restaurant.php?oid=5eb3d668b31de5d588f4298f</p>
            </div>
        <?php   }
        ?>
    </div>
</body>

</html>