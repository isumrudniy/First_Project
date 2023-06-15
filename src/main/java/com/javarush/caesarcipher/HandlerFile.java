package com.javarush.caesarcipher;

import java.io.*;

class HandlerFile {
    private String src;
    private String dest;
    private int shift;

    public HandlerFile(String src, String dest, int shift) {
        this.src = src;
        this.dest = dest;
        this.shift = shift;
    }

    public HandlerFile(String src, String dest) {
        this.src = src;
        this.dest = dest;
    }

    public void cipher() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(this.src), "UTF-8"));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.dest), "UTF-8"))) {
            StringBuilder str = new StringBuilder();
            while (br.ready()) {
                str.append(CaesarCipher.encrypt(br.readLine().toCharArray(), this.shift));
                if (br.ready()) {
                    str.append('\n');
                }
            }
            bw.write(str.toString());
            bw.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void decipher() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(this.src), "UTF-8"));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.dest), "UTF-8"))) {
            StringBuilder str = new StringBuilder();
            while (br.ready()) {
                str.append(CaesarCipher.decipher(br.readLine().toCharArray(), this.shift));
                if (br.ready()) {
                    str.append('\n');
                }
            }
            bw.write(str.toString());
            bw.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void hacker() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(this.src), "UTF-8"));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.dest), "UTF-8"))) {
            StringBuilder str = new StringBuilder();
            while (br.ready()) {
                str.append(br.readLine());
                if (br.ready()) {
                    str.append('\n');
                }
            }
            bw.write(CaesarHacker.bruteForce(str.toString().toCharArray()));
            bw.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
