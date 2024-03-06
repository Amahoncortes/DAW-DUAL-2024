<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Change password</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>

<body>

    <div class="container-fluid">
        <h1>Cambio de contraseña</h1>
        <div class="row justify-content-center">
            <div class="col-sm-12 col-md-6">
                <form method="post">
                    <!-- Email input -->
                    <div class="form-group mb-4 ">
                        <label class="form-label" for="email">Email address</label>
                        <input type="email" id="email" class="form-control" name="email" required />
                    </div>

                    <!-- Current Password input -->
                    <div class="form-group mb-4">
                        <label class="form-label" for="currentPwd">Contraseña actual</label>
                        <input type="password" id="currentPwd" class="form-control" name="currentPwd" required />
                    </div>

                    <!-- New Password input 1-->
                    <div class="form-group mb-4">
                        <label class="form-label" for="newPwd1">Nueva contraseña</label>
                        <input type="password" id="newPwd1" class="form-control" name="newPwd1" required />
                    </div>

                    <!-- New Password input 2-->
                    <div class="form-group mb-4">
                        <label class="form-label" for="newPwd2">Repita nueva contraseña</label>
                        <input type="password" id="newPwd2" class="form-control" name="newPwd2" required />
                    </div>

                    <!-- Submit button -->
                    <input type="submit" class="btn btn-primary btn-block mb-4" value="Cambiar contraseña"></button>
                </form>

                <?php
                const MIN_LENGTH = 6;
                $usuarios = array(
                    "user1@edu.es" => array("pwd" => "Abc123.", "pwd-1" => "aBc123.", "pwd-2" => "abC123."),
                    "user2@edu.es" => array("pwd" => "123Abc.", "pwd-1" => "123aBc.", "pwd-2" => "123abC.")
                );
                $simbolos = array(".", "?", "@");


                //Constante con mensaje a añadir a $errors en caso de incumplimiento
                
                const USER_DOES_NOT_EXIST = "No existe usuario";
                const PWD_INCORRECT = "La contraseña no es correcta";
                const PWD_MISMATCH = "Las contraseñas no coinciden";
                const MIN_LENGTH_ERROR = "La longitud mínima es " . MIN_LENGTH;
                const PWD_USED = "La contraseña es una de las 2 últimas utilizadas";
                const UPPER_CASE_NEEDED = "La nueva contraseña debe contener al menos una letra mayúscula";
                const NUMBER_NEEDED = "La nueva contraseña debe contener al menos un número";
                const SYMBOL_NEEDED = "La nueva contraseña debe contener al menos un símbolo: ";

                // Guardamos los errores en un array
                $errors = [];

                // Procesamos el envío del formulario
                if ($_SERVER['REQUEST_METHOD'] == 'POST') {
                    $email = $_POST['email'];
                    $currentPwd = $_POST['currentPwd'];
                    $newPwd1 = $_POST['newPwd1'];
                    $newPwd2 = $_POST['newPwd2'];

                    // Comprobación a realizar
                
                    //1 - El usuario introducido es uno de los registrados en $usuarios? 
                    if (!array_key_exists($email, $usuarios)) {
                        $errors[] = USER_DOES_NOT_EXIST;
                    } else {
                        // La contraseña actual es la que corresponde al usuario introducido?
                        if ($usuarios[$email]['pwd'] !== $currentPwd) {
                            $errors[] = PWD_INCORRECT;
                        }

                        // Las nuevas contraseñas coinciden?
                        if ($newPwd1 !== $newPwd2) {
                            $errors[] = PWD_MISMATCH;
                        }

                        // La longitud mínima de las nuevas contraseñas coincide con la longitud mínima?
                        if (strlen($newPwd1) < MIN_LENGTH) {
                            $errors[] = MIN_LENGTH_ERROR;
                        }

                        // La nueva contraseña es una de las 2 ultimas ya utilizadas?
                        if (in_array($newPwd1, array($usuarios[$email]['pwd-1'], $usuarios[$email]['pwd-2']))) {
                            $errors[] = PWD_USED;
                        }

                        // La nueva contraseña contiene al menos una letra mayúscula?
                
                        //preg_match: toma la contraseña como input y la compara con una expresión
                        if (!preg_match('/[A-Z]/', $newPwd1)) {
                            $errors[] = UPPER_CASE_NEEDED;
                        }

                        // La nueva contraseña tiene al menos un numero?
                        if (!preg_match('/[0-9]/', $newPwd1)) {
                            $errors[] = NUMBER_NEEDED;
                        }

                        // La nueva contraseña tiene al menos uno de los simbolos de $simbolos?
                        $symbolCheck = false;
                        foreach ($simbolos as $symbol) {
                            if (strpos($newPwd1, $symbol) !== false) {
                                $symbolCheck = true;
                                break;
                            }
                        }
                        if (!$symbolCheck) {
                            $errors[] = SYMBOL_NEEDED . implode(', ', $simbolos);
                        }
                    }

                    // Si no hay errores, actualiza la contraseña y muestra el mensaje de éxito
                    if (empty($errors)) {
                        $usuarios[$email]['pwd-2'] = $usuarios[$email]['pwd-1'];
                        $usuarios[$email]['pwd-1'] = $usuarios[$email]['pwd'];
                        $usuarios[$email]['pwd'] = $newPwd1;
                        echo '<div class="alert alert-success" role="alert">';
                        echo 'Contraseña cambiada con éxito. Nuevos detalles del usuario:';
                        echo '<pre>';
                        print_r($usuarios);
                        echo '</pre>';
                        echo '</div>';
                    }
                }
                ?>

                <!-- Muestra mensajes de error -->
                <?php
                if (!empty($errors)):
                    ?>
                    <div class="alert alert-danger" role="alert">
                        <?php
                        foreach ($errors as $error):
                            ?>
                            <?php echo $error; ?><br>
                        <?php endforeach; ?>
                    </div>
                <?php endif;
                ?>
            </div>
        </div>
    </div>


    <!-- Si no hay errores, actualiza la contraseña y muestra el mensaje de éxito -->
    <?php
     if (empty($errors)):
      ?>
        <div class="alert alert-success" role="alert">
            Contraseña cambiada con éxito. Nuevos detalles del usuario:
            <pre>
                <?php print_r($usuarios); ?>
            </pre>
        </div>
    <?php endif; 
    ?>


</body>

</html>