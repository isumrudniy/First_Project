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

    public static String bruteForce(char[] chars) {
        List<Integer> list = new ArrayList<>();
        for (int shift = 0; shift < ALPHABET.size(); shift++) {
            list.add(checkLine(CaesarCipher.decipher(chars, shift)));
        }
        int shiftBruteForce = list.indexOf(Collections.max(list));
        return "Ключ шифра Цезаря " + shiftBruteForce + "\n" + CaesarCipher.decipher(chars, shiftBruteForce);
    }

    private static int checkLine(String decipherLine) {
        int maxRank = 0;
        String[] Strings = decipherLine.split("[\n ]");
        for (String value : Strings
        ) {
            if (value.matches("[А-Яа-яёA-Za-z]+[.,;:!\"](?=\\\\s|$)")) {
                maxRank++;
            }
        }
        return maxRank;
    }

}
