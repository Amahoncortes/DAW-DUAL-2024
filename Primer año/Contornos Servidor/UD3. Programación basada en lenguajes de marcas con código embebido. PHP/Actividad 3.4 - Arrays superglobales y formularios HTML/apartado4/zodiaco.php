<!DOCTYPE html>

<html>

<head>
    <meta charset="UTF-8">
    <title>Zodiaco</title>
</head>

<body>
    <?php
    const DIA_MIN = 1;
    const DIA_MAX = 31;
    const CAPRICORNIO = "Capricornio";
    const ACUARIO = "Acuario";
    const PISCIS = "Piscis";
    const ARIES = "Aries";
    const TAURO = "Tauro";
    const GEMINIS = "Géminis";
    const CANCER = "Cáncer";
    const LEO = "Leo";
    const VIRGO = "Virgo";
    const LIBRA = "Libra";
    const ESCORPIO = "Escorpio";
    const SAGITARIO = "Sagitario";

    //Formas de crear un array
    $meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];
    //$meses = array( "Enero", "Febrero"); 
    
    //Las claves del día de corte van incluídas. Por ejemplo: los nacidos hasta el 20/01 son capricornio
    $zodiaco = array(
        //enero  
        1 => array(
            20 => CAPRICORNIO,
            "else" => ACUARIO
        ),
        //febrero
        2 => array(
            19 => ACUARIO,
            "else" => PISCIS
        ),
        //marzo
        3 => array(
            20 => PISCIS,
            "else" => ARIES
        ),
        //abril
        4 => array(
            19 => ARIES,
            "else" => TAURO
        ),
        //mayo
        5 => array(
            20 => TAURO,
            "else" => GEMINIS
        ),
        //junio
        6 => array(
            20 => GEMINIS,
            "else" => CANCER
        ),
        //julio
        7 => array(
            22 => CANCER,
            "else" => LEO
        ),
        //agosto
        8 => array(
            22 => LEO,
            "else" => VIRGO
        ),
        //septiembre
        9 => array(
            22 => VIRGO,
            "else" => LIBRA
        ),
        //octubre
        10 => array(
            22 => LIBRA,
            "else" => ESCORPIO
        ),
        //completar aquí...
    );
    ?>
    <form method="post">

        Selecciona tu día y mes de nacimiento:

        <p>
            <label for="dia">Día:</label>
            <select name="dia" id="dia" required>

                <?php

                for ($i = DIA_MIN; $i <= DIA_MAX; $i++) {
                    echo "<option value =\"$i\">$i</option>";
                }

                ?>
            </select>

        </p>

        <label for="mes">Mes</label>
        <select name="mes" id="mes" required>
            <?php
            for ($i = 0; $i < sizeof($meses); $i++) {
                $k = $i + 1;
                echo "<option value=\"$k\">$meses[$i]</option>";
            }
            ?>

        </select>
        </p>

        <p>
            <input type="submit" value="Enviar" />
        </p>

    </form>

    <?php
    if (isset($_POST["dia"]) && isset($_POST["mes"])) {
        $dia = $_POST["dia"];
        $mes = $_POST["mes"];
        echo "Día marcado: $dia, mes marcado: $mes";
        echo "<pre>";
        $array_mes = $zodiaco[$mes];
        echo "</pre>";

        echo "<pre>";
        print_r($array_mes);
        echo "</pre>";
    }


    //Recorrer array de meses con un foreach y que te diga el signo que tienes en relación con el dia y el mes que le has metido
    
    foreach ($array_mes as $key => $value) {
        if ($dia <= $key) {
            $signo = $value;
        } else {
            $signo = $value;
        }
    }

    echo "<p>signo $signo</p>"
    ?>
    
</body>

</html>