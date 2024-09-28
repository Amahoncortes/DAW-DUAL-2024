<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>formulario_get</title>
</head>

<h1>Reservas lunch</h1>
<form method="get" name="formulario-get" action="form.php">
    <p>
        <label for="Reservas">Introduzca si es alérgico a alguno de los siguientes elementos:</label>
        <select name="prendas[]" id="prendas-id" multiple>
            <option value="">--</option>
            <option value="coat">Leche</option>
            <option value="top">Huevo</option>
            <option value="shirt">Gluten</option>
        </select>
    </p>

    <input type="submit" value="Enviar">


</form>
</body>

</html>