package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void checkWordLength() {
        assertEquals(Main.checkWordLength("Caracol"), 7);
        assertEquals(Main.checkWordLength("Miscelanea"), 10);
        assertEquals(Main.checkWordLength("NotBad"), 6);
        assertEquals(Main.checkWordLength(""), 0);
        assertEquals(Main.checkWordLength("Raul"), 4);
    }

    @Test
    void NumOfVowels() {
        assertEquals(Main.NumOfVowels("Caracol"), 3);
        assertEquals(Main.NumOfVowels("Miscelanea"), 5);
        assertEquals(Main.NumOfVowels("Raul"), 2);
        assertEquals(Main.NumOfVowels("Alberto"), 3);
    }


    @Test
    void isPrime() {
        assertTrue(Main.isPrime(2));
        assertTrue(Main.isPrime(3));
        assertTrue(Main.isPrime(7));
        assertTrue(Main.isPrime(11));
        assertFalse(Main.isPrime(12));
        assertFalse(Main.isPrime(16));
        assertTrue(Main.isPrime(79));
        assertTrue(Main.isPrime(43));
        assertFalse(Main.isPrime(88));
        assertFalse(Main.isPrime(87));

    }

    @Test
    void checkNumberOfPrimes() {
        int[] numbers = {2,3,4,5,6,7,8,9,88,87,43};
        assertEquals(Main.checkNumberOfPrimes(numbers), 5);
        int[] numbers2 = {79,16,2,7,1};
        assertEquals(Main.checkNumberOfPrimes(numbers2), 3);
        int[] numbers3 = {19,0,-2,7,1};
        assertEquals(Main.checkNumberOfPrimes(numbers3), 2);
    }

    @Test
    void isIdentityMatrix() {
        int[][] IdentityMatrix2x2 = {{1,0},{0,1}};
        assertTrue(Main.isIdentityMatrix(IdentityMatrix2x2));
        int[][] IdentityMatrix3x3 = {{1,0,0},{0,1,0},{0,0,1}};
        assertTrue(Main.isIdentityMatrix(IdentityMatrix3x3));
        int[][] IdentityMatrix4x4 = {{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}};
        assertTrue(Main.isIdentityMatrix(IdentityMatrix4x4));
        int[][] NotIdentityMatrix3x3 = {{1,0,2},{0,1,0},{0,0,1},{0,0,0}};
        assertFalse(Main.isIdentityMatrix(NotIdentityMatrix3x3));
        int[][] NotIdentityMatrix2x2 = {{1,0},{0,0}};
        assertFalse(Main.isIdentityMatrix(NotIdentityMatrix2x2));

    }

}