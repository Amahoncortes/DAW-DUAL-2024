
function validarTitulo() {
    //TODO: 2- Completa la función validarTitulo() ya proporcionada en el archivo crear.js dentro de la carpeta js para que devuelva true solo cuando el valor del input del formulario que alberga el título de la nota en  index.php  sea igual a la constante TITULO_PERMITIDO y false en caso contrario. (1 punto)
    
    let titulo = document.getElementById('title').value;
    if (titulo == TITULO_PERMITIDO) {
        return true;
    } else {
        return false;
    }


}

function crearNotaApiRemota() {
    //TODO: 3- Completa la función crearNotaApiRemota() ya proporcionada en el archivo crear.js  de la carpeta js   para que, utilizando el API de Fetch, realice una petición POST con el título introducido en el formulario  enviando a REMOTE_API_URL un objeto JSON: 
}

function confirmCrearNotaLocal(data) {
    //TODO: 4- Completa la función  confirmCrearNotaLocal(data) ya proporcionada en crear.js para que muestre un diálogo modal preguntando al usuario si quiere crear una nota en el servidor local, mediante NotaController y su método create. Si el usuario confirma su voluntad de crear una nota en el servidor local, deberá llamarse a crearNotaLocal(data), enviando los datos que se recibieron originalmente de la Api remota. (2 puntos)
}

function crearNotaLocal(nota) {

    //TODO:  6-  Completa la función crearNotaLocal(nota) ya proporcionada en el archivo crear.js para que cree una variable con los datos title, createdAt, updatedAt y completed (todos salvo el id) de la nota creada en la Api remota y se reciban en NotaController.php en el array superglobal $_POST como si fueran enviados en un formulario html (no se enviarán como objeto JSON). (2 puntos)


    fetch(request)
        .then(response => response.json())
        .then(data => {

            if (data.id) {
                showMsg("<br/> Se ha creado localmente la nota : " + JSON.stringify(data, null, 10), true, "div-msg", true);
            }
            else {
                showMsg("<br/> Ha habido un error creando la nota localmente: " + data.error, true, "div-msg", true);
            }

        })
        .catch(error => console.error("Ha ocurrido un error" + error));

}