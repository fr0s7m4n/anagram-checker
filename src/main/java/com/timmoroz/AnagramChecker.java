package com.timmoroz;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/**
 * Check if the two strings are anagrams of each other.
 * Case-insensitive; ignores non-alphabet characters.
 */
public final class AnagramChecker {

    private AnagramChecker() {}

    /**
     * Checks if two strings are anagrams of each other.
     *
     * @param string1 string one
     * @param string2 string two
     * @return whether strings are anagrams
     */
    public static boolean isLetterBasedAnagram(String string1, String string2) {
        if (string1 == null || string1.isBlank() || string2 == null || string2.isBlank()) {
            throw new IllegalArgumentException("Parameters cannot be null or blank");
        }

        return isAnagram(reduceToLowerCaseLetters(string1), reduceToLowerCaseLetters(string2));
    }

    /**
     * Reduce the given text to lower case letters by removing all non-alphabet characters
     * and then converting all character to lower case.
     *
     * @param text original text
     * @return text reduced to lower case letters
     */
    public static String reduceToLowerCaseLetters(String text) {
        return text.replaceAll("[^a-zA-Z]", "").toLowerCase();
    }

    private static boolean isAnagram(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }
        Multiset<Character> multiset1 = HashMultiset.create();
        Multiset<Character> multiset2 = HashMultiset.create();
        for (int i = 0; i < string1.length(); i++) {
            multiset1.add(string1.charAt(i));
            multiset2.add(string2.charAt(i));
        }
        return multiset1.equals(multiset2);
    }
}
