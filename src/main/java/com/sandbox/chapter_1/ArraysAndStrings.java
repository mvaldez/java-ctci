package com.sandbox.chapter_1;

import java.util.*;

public class ArraysAndStrings {
    public static void main(String[] args) {
        // nothing here
    }

    // 1.9 String Rotation
    // time complexity O(n) where n is the string length
    // space complexiy O(1)
    static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return false;
        return isSubstring(s1, s2+s2);
    }

    static boolean isSubstring(String s1, String s2) {
        if (s1.length() == s2.length())
            return s1.equals(s2);
        else if (s1.length() > s2.length())
            return s1.contains(s2);
        else
            return s2.contains(s1);

    }

    // 1.8 Zero Matrix
    // time complexity O(n^2)
    // space complexity O(n^2)
    static int[][] zeroMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 0) {
                    map.put(row, col);
                }
            }
        }

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (map.containsKey(row)) {
                    matrix[row][col] = 0;
                }
                if (map.containsValue(col)) {
                    matrix[row][col] = 0;
                }
            }
        }

        return matrix;
    }

    // 1.7 Rotate Matrix
    // time complexity O(n^2)
    // space complexity O(n) where n is the number of elements in the matrix
    static char[][] rotateMatrix(char[][] matrix) {
        char[][] rotated = new char[matrix.length][matrix.length];
        for (int col=0; col<matrix.length; col++) {
            int index = 0;
            for (int row=matrix.length-1; row>-1; row--) {
                rotated[col][index++] = matrix[row][col];
            }
        }
        return rotated;
    }


    // 1.6 String Compression
    // time complexity O(n) where n is the length of the string
    // space complexity O(n) where n is the length of the string
    static String compress(String s) {
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        Character current = s.charAt(0);
        for (Character c : s.toCharArray()) {
            if (c == current) {
                counter++;
            } else {
                sb.append(current);
                sb.append(counter);
                current = c;
                counter = 1;
            }
        }
        // capture the last results
        sb.append(current);
        sb.append(counter);
        if (sb.length() >= s.length()) {
            return s;
        } else {
            return sb.toString();
        }
    }

    // 1.5 One Way
    // time complexity O(n) where n = shortest string
    // space complexity O(n) where n = max(s1.len, s2.len)
    static boolean hasEdit(String s1, String s2) {
        if (Math.abs(s1.length() - s2.length()) > 1) {
            return false;
        }
        Set<Character> s = new HashSet<>();
        for (int i=0; i<s1.length(); i++) {
            s.add(s1.charAt(i));
        }
        for (int j=0; j<s2.length(); j++) {
            if (s.contains(s2.charAt(j))) {
                s.remove(s2.charAt(j));
            } else {
                s.add(s2.charAt(j));
            }
        }
        return s.size() < 3;
    }

    // 1.4 palindrome permutation
    // time complexity O(n)
    // space complexity O(n/2)
    static boolean hasPalindrome(String orig) {
        int num = 0;
        String str = orig.toLowerCase();  // optimize by inline operation using ascii codes
        Set<Character> set = new HashSet<>();
        for (int i=0; i<orig.length(); i++) {
            if (str.charAt(i) == ' ') continue;  // skip spaces
            num++; // count characters
            if (set.contains(str.charAt(i))) {
                set.remove(str.charAt(i));
            } else {
                set.add(str.charAt(i));
            }
        }

        // even length palindrome strings have n/2 pairs of characters
        // odd length palindrome strings have (n-1)/2 pairs of characters
        if (num % 2 == 0) {
            return set.size() == 0;
        } else {
            return set.size() == 1;
        }
    }


    // 1.3 Urlify
    // O(n) time complexity
    static String replaceWithSpaces(String s, int n) {
        int end = s.length() -1;
        char[] c_string = s.toCharArray(); // can be skipped if input arg is char[] instead
        for (int i = n-1; i > -1; i--) {
            if (c_string[i] == ' ') {
                c_string[end] = '0';
                end--;
                c_string[end] = '2';
                end--;
                c_string[end] = '%';
                end--;
            } else if (c_string[i] != ' ') {
                c_string[end] = c_string[i];
                end--;
            }
        }
        return Arrays.toString(c_string);
    }

    // 1.2 Check Permutation
    // O(n^2) with no binary search else O(n log n)
    static boolean isPerm(String s1, String s2) {
        System.out.println("Comparing "  + s1 + " and " + s2);

        if (s1.length() != s2.length()) {   // O(1)
            return false;
        }

        // this depends on the definition of permutation
        if (s1.equals(s2)) {   // O(1)
            return false;
        }

        for (int i=0; i<s1.length(); i++) {    // O(n)
            if (!contains(s1.charAt(i), s2)) {   // if this was binary search then O(log n) else O(n)
                return false;
            }
        }
        return true;
    }

    // 1.2 Check Permutation (faster)
    // solution is O(n) time complexity; O(n) space complexity
    static boolean isPermFast(String s1, String s2) {
        System.out.println("Comparing "  + s1 + " and " + s2);

        Set<Character> m = new HashSet<>();

        if (s1.length() != s2.length()) {  // O(1)
            return false;
        }

        int count = 0;
        for (int i=0; i<s1.length(); i++) {  // O(n)
            if (!m.contains(s1.charAt(i))) {
                m.add(s1.charAt(i));
                count++;
            } else {
                m.add(s1.charAt(i));
                count++;
            }
            if (!m.contains(s2.charAt(i))) {
                m.add(s2.charAt(i));
                count++;
            } else {
                m.add(s2.charAt(i));
                count--;
            }
        }
        System.out.println("Size=" + m.size());
        System.out.println("Count=" + count);
        return m.size() == s1.length() && count > 0;  // O(1)
    }

    // if you make this a binary search then O(log n)
    // else O(n) where n is the length of s
    static boolean contains(char c, String s) {
        for (int j=0; j<s.length(); j++) {
            if (s.charAt(j) == c) {
                return true;
            }
        }
        return false;
    }
}
