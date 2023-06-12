package com.javarush.caesarcipher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CaesarHacker {

    private static final List<Character> ALPHABET = new ArrayList<>(Arrays.asList('А', 'Б', 'В', 'Г', 'Д', 'Е',
            'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П',
            'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ',
            'Ы', 'Ь', 'Э', 'Ю', 'Я', 'а', 'б', 'в', 'г', 'д', 'е',
            'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п',
            'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ',
            'ы', 'ь', 'э', 'ю', 'я', '.', ',', '"', ':', '-', '!', '?', ' '));

    public static void bruteForce(char[] chars) {
        for (int i = 0; i < ALPHABET.size(); i++) {
            int shift = ALPHABET.size() - i;
            System.out.println(CaesarCipher.encrypt(chars, shift));
        }
    }

    private static void checkLine(String line) {

    }

}
