public class Main {
    public static void main(String[] args) {
        String word = "murcielago";
        int[] numbers = {3, 9, 4, 5, 7, 10};
        int[][] matrix = {{}};

        System.out.println(checkWordLength(word));
        System.out.println(numOfVowels(word));
        System.out.println(checkNumberOfPrimes(numbers));
        //isIdentityMatrix(matrix);


    }

    /*1. Crea una función que sea checkWordLength(String word)
     que devuelva la longitud de cada palabra que se le envíe como parámetro.*/
    static int checkWordLength(String word) {
        return word.trim().length();
    }

    /*2. Crea una función NumOfVowels(String word) que devuelva el número de vocales que contiene esa palabra.
     Para poder realizar este ejercicio, deberás descomponer el String
      en un array de char[] con la función: toCharArray();
     */
    static int numOfVowels(String word) {
        int count = 0;
        //Convertimos el string en un array de chars
        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (isVowel(charArray[i])) {
                count++;
            }
        }
        return count;
    }

    static boolean isVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }

    /*3. Crea una función llamada checkNumberOfPrimes(int[] numbers) la cual se le envíe como parámetro un array de
     números y nos devuelva cuantos números primos hay.
     Crea otra función que sea isPrime(int i) que devuelva un boolean.
     Úsala en la primera función.
     */
    static int checkNumberOfPrimes(int[] numbers) {
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (isPrime(numbers[i])) {
                count++;
            }
        }
        return count;
    }

    static boolean isPrime(int i) {
        if (i <= 1) {
            return false;
        }
        for (int j = 2; j * j <= i; j++) { //Empezamos en el 2 hasta el cuadrado del numero , que debe ser el maximo al que puede llegar i.
            //Por qué? porque por ejemplo, si queremos determinar si 7 es un numero primo:
            //7*7 = 49
            //Si i fuera por ejemplo 50, habría numeros mas pequeños que 7 que serían divisores de i, con lo cual, ya no sería primo.
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    /*4: Crea una función llamada isIdentityMatrix(int[][] matrix)
      que devuelva un booleano conforme si una matriz es identidad o no.
       Recuerda que una matriz identidad es aquella que su diagonal de izquierda a derecha
        son todos 1 y el resto son todos 0.
      */
    static boolean isIdentityMatrix(int[][] matrix) {
        return true;
    }
}




