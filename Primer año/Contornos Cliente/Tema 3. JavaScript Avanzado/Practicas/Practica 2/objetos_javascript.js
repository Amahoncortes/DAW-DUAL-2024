//Clase rectangulo
class Rectangulo { constructor(alto, ancho) { this.alto = alto; this.ancho = ancho; } }

//anonima
/*let Rectangulo = class { constructor(alto, ancho) { this.alto = alto; this.ancho = ancho; } };
console.log(Rectangulo.name); // output: "Rectangulo"*/

//Nombrada
/*let Rectangulo = class Rectangulo2 { constructor(alto, ancho) { this.alto = alto; this.ancho = ancho; } };
console.log(Rectangulo.name); // output: "Rectangulo2"*/



//HERENCIA

/**
 * La herencia significa que cuando se crea un objeto a partir de otro (el constructor),
 * este objeto puede acceder a las propiedades y métodos de la clase que lo ha creado.
 */


/*El objeto prototype no es más que un objeto básico de un constructor
que contiene todos los métodos y propiedades que serán accesibles a los objetos
 basados en ese constructor.*/

//Como funciona?

/**
 * Si desde un objeto se invoca un método
 * o una propiedad el intérprete de javascript
 * busca entre sus métodos o propiedades.
 *  Si no lo encuentra, busca en el prototype del objeto constructor.
 *  Si está se ejecuta.
 *  Si tampoco está repite el proceso:
 *  va al constructor de este objeto y busca en su prototype.
 */

//La palabra clave super es usada para llamar funciones del objeto padre.

/**EJEMPLO:
 * 
 * class Gato {
 *   constructor(nombre) {
 *     this.nombre = nombre;
 *   }  
 * 
 * hablar() { 
 *    console.log(this.nombre + ' hace ruido.');
 *   }
 *  } 
 * 
 * class Leon extends Gato {
 *   hablar() { 
 *    super.hablar(); 
 *    console.log(this.nombre + ' maulla.');
 *   }
 *  }
 * 
 * 
 */

/**¿Qué es el local Storage?
 * 
 * Cuando construimos una app, normalmente trabajamos con algún tipo de información
 * Pero si no almacenamos esa información en algún sitio,
 * ésta se perderá cuando recarguemos la página.
 * 
 * Una de las maneras de solucionarlo es utilizando local storage:
 * La información queda almacenada en el navegador del usuario.
 * 
 * La local storage API nos la proporciona el navegador directamente,
 *  así que podemos acceder a esa a través del window object.
 *  Si vamos a la consola y escribimos window,
 *  verás que una de las propiedades es localStorage.
 * 
 * Dentro de ella verás que hay una propiedad llamada length,
 *  que representa el número de elementos que tenemos almacenados
 *  en localStorage actualmente.
 */

/**
 * Hemos dicho entonces que en localStorage almacenamos datos.
 * Cada dato será un item que tendrá una key y un value,
 * muy parecido a la estructura de un objeto en JavaScript (JS).
 * Con la particularidad de que un item debe ser siempre un string.
 * Eso no significa que no podamos crear arrays, objetos, o cualquier otro data type.
 * Simplemente significa que cualquier data type debe ir entre comillas como un string
 * para poder ser almacenado en local storage.
 * Por lo tanto para almacenar datos en el localStorage lo que haremos es
 * convertir los objetos de tipo JavaScript en objetos JSON (JSON.stringify())
 */

/**
 * Cómo almacenar y obtener datos 
 * ▪Para almacenar datos en local storage,
 * usamos el método setItem.
 *  Sintaxis: localStorage.setItem('key name', 'value name');
 *  Para obtener datos almacenados en local storage,
 * utilizamos el método llamado getItem
 * y le pasamos como argumento el key name del item que queremos obtener.
 *  ▪También podemos actualizar información,
 *  simplemente usamos el método setItem de nuevo y sobrescribimos los valores.
 */

/**
 * Cómo borrar datos:
 * Existen dos posibilidades:
 *  borrar un solo item de local storage o borrarlos todos.
 *  ▪Para borrar un solo item, usamos el método remove
 *  y le pasamos por parámetro el key name del item que queremos borrar.
 *  ▪Si lo que queremos es borrar todos los datos que tenemos en local storage,
 * usamos el método clear().
 */


/**
 * Cómo convertir datos a formato JSON / desde formato JSON:
 *  Hasta ahora hemos trabajado con datos sencillos, como strings y números.
 *  Es momento de trabajar con estructuras más complejas,
 *  como arrays u objetos.
 *  Recuerda que los datos que guardamos en local storage
 *  deben de tener el formato de string.
 *  Así que, guardemos lo que guardemos,
 *  la local storage API lo convertirá en un string. 
 * 
 * Para guardar esta estructura compleja en local storage,
 * primero debemos convertir esos datos a un JSON string.
 * Para eso, usamos un método del JSON object llamado stringify
 * y le pasamos la variable como argumento.
 * 
 * localStorage.setItem('toDosList', JSON.stringify(toDos));
 * 
 * Los siguientes pasos serían obtener esos datos (retrieve)
 * y convertirlos de nuevo en un array para poder manipularlo.
 * Para ello, creamos una variable llamada storedToDos,
 * y usamos el método getItem para obtener los datos.
 * Esto nos seguiría dando un JSON string, 
 * así que usamos el  método parse sobre los datos.  
 * 
 * • const storedToDos = localStorage.getItem('toDosList');
 * • console.log(JSON.parse(storedToDos));
 */

/**
 * Buscar una clave en el localStorage:
 * Para ello debemos recorrer todas las claves del almacenamiento local
 * para comprobar la existencia o no de una clave.
 * A veces debemos leer los datos que están almacenados en el localStorage,
 * pero no conocemos las claves exactas.
 * Podemos obtener el nombre de la clave utilizando el método key().
 * Dicho método acepta un índice como argumento
 * y devuelve el nombre de la clave que coincide con el índice.
 * Podemos recorrer el el localStorage con un bucle 
 * y leer los datos sin conocer las claves exactas
 * 
 *  let nextValue;
 *  for (let i = 0; i < localStorage.length; i++){
 *     nextValue = localStorage.getItem(localStorage.key(i));
 *    //Do something with nextValue..
 * }
 * 
 */