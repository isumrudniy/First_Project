package com.javarush.caesarcipher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CaesarCipher {
    private static final List<Character> ALPHABET = new ArrayList<>(Arrays.asList('А', 'Б', 'В', 'Г', 'Д', 'Е',
            'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П',
            'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ',
            'Ы', 'Ь', 'Э', 'Ю', 'Я', 'а', 'б', 'в', 'г', 'д', 'е',
            'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п',
            'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ',
            'ы', 'ь', 'э', 'ю', 'я', '.', ',', '"', ':', '-', '!', '?', ' '));

    public static String encrypt(char[] chars, int shift) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char aChar : chars
        ) {
            if (ALPHABET.contains(aChar)) {
                int srcValue = ALPHABET.indexOf(aChar);
                int destValue = (srcValue + shift) % (ALPHABET.size());
                stringBuilder.append(ALPHABET.get(destValue));
            } else {
                stringBuilder.append(aChar);
            }
        }
        return stringBuilder.toString();
    }

    public static String decipher(char[] chars, int shift) {
        shift = ALPHABET.size() - (shift % ALPHABET.size());
        return encrypt(chars, shift);
    }
}
