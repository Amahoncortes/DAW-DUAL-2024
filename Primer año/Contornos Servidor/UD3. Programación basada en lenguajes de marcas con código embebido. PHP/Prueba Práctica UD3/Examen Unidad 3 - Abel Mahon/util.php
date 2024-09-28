<?php

// Función para comprobar si el usuario existe en el array de usuarios
function checkUserExists($user, $usuarios)
{

    if (array_key_exists($user, $usuarios)) {
        return true;
    } else {
        return false;
    }
}

// Función para comprobar si la contraseña actual es correcta para el usuario dado
function checkCurrentPassword($user, $pwd, $usuarios)
{

    if ($usuarios[$user]['pwd'] == $pwd) {
        return true;
    } else {
        return false;
    }
}

//3. Las nuevas contraseñas coinciden
function checkPasswordMatch($pwd1, $pwd2)
{

    if ($pwd1 == $pwd2) {
        return true;
    } else {
        return false;
    }
}

//4. La longitud mínima de las nuevas contraseñas
function checkMinLength($pwd, $minLength)
{

    if (strlen($pwd) >= $minLength) {
        return true;
    } else {
        return false;
    }
}

//5. La nueva contraseña no es una de las dos últimas
function checkPasswordUsed($pwd, $lastPasswords)
{

    if (!in_array($pwd, $lastPasswords)) {
        return true;
    } else {
        return false;
    }
}

// 6. La nueva contraseña contiene al menos una letra mayúscula
function checkUpperCase($pwd)
{

    if (preg_match('/[A-Z]/', $pwd)) {
        return true;
    } else {
        return false;
    }
}

// 7. La nueva contraseña contiene al menos un número
function checkNumber($pwd)
{

    if (preg_match('/[0-9]/', $pwd)) {
        return true;
    } else {
        return false;
    }
}

// 8. nueva contraseña contiene al menos un símbolo de los proporcionados
function checkSymbol($pwd, $allowedSymbols)
{

    foreach ($allowedSymbols as $symbol) {
        if (strpos($pwd, $symbol) !== false) {
            return true;
        }
    }
    return false;
}

?>