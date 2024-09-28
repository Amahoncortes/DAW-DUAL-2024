<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>formulario_get</title>
</head>

<h1>Tienda de moda</h1>
<form method="get" name="formulario-get" action="form.php">
    <p>
        <label for="cloth-select">Seleccione tipo de prenda:</label>
        <select name="prendas[]" id="prendas-id" multiple>
            <option value="">--Por favor, elige una opción--</option>
            <option value="coat">Abrigos</option>
            <option value="top">Tops</option>
            <option value="shirt">Camisas</option>
        </select>
    </p>

    <label for="fecha">Fecha: </label>

    <input type="color" name="color" value="#000000">

    <input type="submit" value="Enviar">

</form>
</body>

</html>