package com.javarush.caesarcipher;

import java.util.*;

public class CaesarHacker {

    public static String bruteForce(char[] chars) {
        List<Integer> list = new ArrayList<>();
        for (int shift = 0; shift < ApplicationConstant.ALPHABET.size(); shift++) {
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
