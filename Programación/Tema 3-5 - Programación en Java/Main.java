public class Main {
    public static void main(String[] args) {
        if (checkWordLength("Holaquetal") == 10)
            System.out.println("True");
        else
            System.out.println("Error");

        if (NumOfVowels("aeortUdfhc3O") == 5)
            System.out.println("True");
        else
            System.out.println("Error");

        int[] num = {2, 3, 5, 7, 11, 8, 13,};
        if (checkNumberOfPrimes(num) == 6)
            System.out.println("True");
        else
            System.out.println("Error");

        int[][] mat = {{1, 0, 0, 0},
                    {0, 1, 0, 0},
                    {0, 0, 1, 0},
                    {0, 0, 0, 1}};
        if (isIdentityMatrix(mat))
            System.out.println("True");
        else
            System.out.println("Error");
    }
    public static int checkWordLength(String word){
        return word.length();
    }

    public static int NumOfVowels(String word){
        char[] wordIntoChars = word.toCharArray();
        int cont = 0;
        for (int i = 0; i < wordIntoChars.length; i++) {
            if ("AEIOUaeiou".indexOf(wordIntoChars[i]) != -1)
                cont++;
        }
        return cont;
    }

    public static int checkNumberOfPrimes(int[] numbers){
        int cont = 0;

        for (int i = 0; i < numbers.length; i++){
            if (isPrime(numbers[i]))
                cont++;
        }
        return cont;
    }

    public static boolean isPrime(int i){
        for (int j = i - 1; j > 1; j--){
            if (i % j == 0){
                return false;
            }
        }
        return true;
    }

    public static boolean isIdentityMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == i && matrix[i][j] != 1)
                    return false;
                else if (j != i && matrix[i][j] != 0)
                    return false;
            }
        }
        return true;
    }
}
