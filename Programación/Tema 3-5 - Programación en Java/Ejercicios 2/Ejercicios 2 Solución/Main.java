package org.example;

public class Main {
    public static void main(String[] args) {
    }

    public static int checkWordLength(String word){
        return word.length();
    }

    public static int NumOfVowels(String word){
        char[] chars = word.toLowerCase().toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if((chars[i] == 'a') || (chars[i] == 'e') || (chars[i] == 'i') || (chars[i] == 'o') || (chars[i] == 'u')){
                count++;
            }
        }
        return count;
    }

    public static int checkNumberOfPrimes(int[] numbers){
        int count = 0;
        for (int num: numbers) {
            if(isPrime(num)){
                count++;
            }
        }
        return count;
    }

    public static boolean isPrime(int num){
        for (int i = 2; i < num ; i++) {
            if(num%i == 0){
                return false;
            }
        }
        if(num <= 1){
            return false;
        }
        return true;
    }

    public static boolean isIdentityMatrix(int[][] matrix){

        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix.length ; j++) {
                if (i == j && matrix[i][j] != 1) {
                    return false;
                } else if (i != j &&matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

}