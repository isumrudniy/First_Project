package com.javarush.caesarcipher;

import java.util.*;

public class CaesarHacker {

    private static final List<Character> ALPHABET = new ArrayList<>(Arrays.asList('А', 'Б', 'В', 'Г', 'Д', 'Е',
            'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П',
            'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ',
            'Ы', 'Ь', 'Э', 'Ю', 'Я', 'а', 'б', 'в', 'г', 'д', 'е',
            'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п',
            'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ',
            'ы', 'ь', 'э', 'ю', 'я', '.', ',', '"', ':', '-', '!', '?', ' '));

    public static void bruteForce(char[] chars) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int shift = 2; shift < ALPHABET.size() - 1; shift++) {
            StringBuilder line = new StringBuilder();
            int maxRank = 0;
            line.append(CaesarCipher.decipher(chars, shift));
            String[] Strings = line.toString().split(" ");
            for (String value : Strings
            ) {
                if (value.matches("\\w+[.,;:](?=\\s|$)")) {
                    maxRank++;
                }
            }
            map.put(shift, maxRank);
        }
        int i = 3;
    }

    private static void checkLine(String line) {

    }

}
