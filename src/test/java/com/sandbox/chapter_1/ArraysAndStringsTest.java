package com.sandbox.chapter_1;

import org.junit.Assert;
import org.junit.Test;

import static com.sandbox.chapter_1.ArraysAndStrings.*;

public class ArraysAndStringsTest {

    @Test
    public void  checkPermutationTest() {
        // 1.2 - Check Permutation
        Assert.assertFalse(isPermFast("abc", "cbag"));
        Assert.assertTrue(isPermFast("abc", "cab"));
        Assert.assertFalse(isPermFast("abc", "abc"));
        Assert.assertFalse(isPermFast("abc", "aba"));
        Assert.assertFalse(isPermFast("abc", "bag"));
    }

    @Test
    public void urlIfyTest() {
        // 1.3 - URLify
        String orig = "Mr John Smith    ";
        Assert.assertEquals("[M, r, %, 2, 0, J, o, h, n, %, 2, 0, S, m, i, t, h]",
                replaceWithSpaces(orig, 13));
        Assert.assertEquals("[M, a, r, k, %, 2, 0, V, a, l, d, e, z]",
                replaceWithSpaces("Mark Valdez  ", 11));

    }

    @Test
    public void palindromePermTest() {
        // 1.4 - palindrome permutation
        Assert.assertTrue(hasPalindrome("Tact Coa"));
        Assert.assertTrue(hasPalindrome("car race "));
        Assert.assertTrue(hasPalindrome("No x in Ni x on"));
        Assert.assertTrue(hasPalindrome("Was it a car or a cat I saw"));

        Assert.assertFalse(hasPalindrome("ABac"));
        Assert.assertFalse(hasPalindrome("Mark Valdez"));
        Assert.assertFalse(hasPalindrome("This is not a palindrome"));
    }

    @Test
    public void oneWayEditTest() {
        // 1.5 One Way
        Assert.assertTrue(hasEdit("pale", "ple"));
        Assert.assertTrue(hasEdit("pales", "pale"));
        Assert.assertTrue(hasEdit("pale", "bale"));
        Assert.assertTrue(hasEdit("mark", "bark"));

        Assert.assertFalse(hasEdit("pale", "bake"));
    }

    @Test
    public void stringCompressionTest() {
        // 1.6 String Compression
        String uncompress_0 = "aabcccccaaa";
        String uncompress_1 = "aabccccca";
        String uncompress_2 = "abc";

        Assert.assertEquals("a2b1c5a3", compress(uncompress_0));
        Assert.assertEquals("a2b1c5a1", compress(uncompress_1));
        Assert.assertEquals("abc", compress(uncompress_2));
    }

    @Test
    public void rotateMatrixTest() {
        // 1.7 Rotate Matrix
        char[][] matrix3 = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}};
        char[][] expected3 = {{'g', 'd', 'a'}, {'h', 'e', 'b'}, {'i', 'f', 'c'}};

        char[][] matrix2 = {{'a', 'b'}, {'c', 'd'}};
        char[][] expected2 = {{'c', 'a'}, {'d', 'b'}};


        Assert.assertArrayEquals(expected3, rotateMatrix(matrix3));
        Assert.assertArrayEquals(expected2, rotateMatrix(matrix2));
    }

    @Test
    public void zeroMatrixTest() {
        // 1.8 Zero Matrix
        int[][] matrix1 = {{1, 2}, {3, 0}, {4, 5}};
        int[][] expected1 = {{1, 0}, {0, 0}, {4, 0}};

        int[][] matrix2 = {{1, 2, 3}, {0, 3, 2}};
        int[][] expected2 = {{0, 2, 3}, {0, 0, 0}};

        Assert.assertArrayEquals(expected1, zeroMatrix(matrix1));
        Assert.assertArrayEquals(expected2, zeroMatrix(matrix2));
    }

    @Test
    public void isRotationTest() {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";

        String s3 = "mark";
        String s4 = "arkb";

        String s5 = "mavi";
        String s6 = "mark";

        String s7 = "mark";
        String s8 = "arkm";

        String s9 =  "racecar";
        String s10 = "carrace";

        Assert.assertTrue(isRotation(s1, s2));
        Assert.assertFalse(isRotation(s3, s4));
        Assert.assertFalse(isRotation(s5, s6));
        Assert.assertTrue(isRotation(s7, s8));
        Assert.assertTrue(isRotation(s9, s10));
    }
}