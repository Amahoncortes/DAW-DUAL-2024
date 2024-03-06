<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>A2.2 Alg 5.8</title>
</head>

<body>
    <?php
   

    $n = 5;

    $suma = 1;
    $ter = 1;

    //posiblidad 1
    // $k = 1;
    // while ($k++ <= $n) {

    //posibilidad 2
    $k = 0;
    while (++$k <= $n) {
        //for ($k = 1; $k <= $n; $k++) {        
        $ter = $ter / 2;
        echo "<p>Sumando $suma + $ter </p>";
        $suma += $ter;
    }
    echo "<p> La suma vale $suma </p>";


    ?>



</body>

</html>