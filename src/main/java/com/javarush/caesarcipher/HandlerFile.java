package com.javarush.caesarcipher;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

class HandlerFile {
    private String src;
    private String dest;
    private int shift;

    public HandlerFile(String src, String dest, int shift) {
        this.src = src;
        this.dest = dest;
        this.shift = shift;
    }

    public void cipher() {
        try (BufferedReader br = new BufferedReader(new FileReader(this.src));
             BufferedWriter bw = new BufferedWriter(new FileWriter(this.dest))) {
            while (br.ready()) {
                String str = br.readLine();
                bw.write(CaesarCipher.encrypt(str.toCharArray(), this.shift));
                if (br.ready()) {
                    bw.write('\n');
                }
            }
            bw.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void decipher() {
        try (BufferedReader br = new BufferedReader(new FileReader(this.src));
             BufferedWriter bw = new BufferedWriter(new FileWriter(this.dest))) {
            while (br.ready()) {
                String str = br.readLine();
                bw.write(CaesarCipher.decipher(str.toCharArray(), this.shift));
                if (br.ready()) {
                    bw.write('\n');
                }
            }
            bw.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
