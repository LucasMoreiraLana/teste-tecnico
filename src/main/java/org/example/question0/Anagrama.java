package org.example.question0;

import java.util.ArrayList;
import java.util.List;


public class Anagrama {

    public List<String> geradorAnagrama(String input) {

        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }
        if (!input.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Input must contain only letters");
        }

        return geradorHelper(input.toCharArray(), 0);
    }

    private List<String> geradorHelper(char[] chars, int start) {
        List<String> result = new ArrayList<>();

        if (start == chars.length - 1) {
            result.add(String.valueOf(chars[start]));
            return result;
        }

        for (int i = start; i < chars.length; i++) {
            // Swap characters
            swap(chars, start, i);

            List<String> subAnagrams = geradorHelper(chars, start + 1);

            for (String subAnagram : subAnagrams) {
                result.add(chars[start] + subAnagram);
            }

            swap(chars, start, i);
        }

        return result;
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}