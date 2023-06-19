package com.javarush.caesarcipher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CaesarCipher {

    public static String encrypt(char[] chars, int shift) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char aChar : chars
        ) {
            if (ApplicationConstant.ALPHABET.contains(aChar)) {
                int srcValue = ApplicationConstant.ALPHABET.indexOf(aChar);
                int destValue = (srcValue + shift) % (ApplicationConstant.ALPHABET.size());
                stringBuilder.append(ApplicationConstant.ALPHABET.get(destValue));
            } else {
                stringBuilder.append(aChar);
            }
        }
        return stringBuilder.toString();
    }

    public static String decipher(char[] chars, int shift) {
        shift = ApplicationConstant.ALPHABET.size() - (shift % ApplicationConstant.ALPHABET.size());
        return encrypt(chars, shift);
    }
}
