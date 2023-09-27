# JavaRush-Cryptanalyzer
**Task:** <br>
Write a program that works with Caesar cipher.

**Mandatory requirements**<br>
The program must have 2 modes:
  1. Encryption / decryption.
  The program must encrypt and decrypt the text using the given cryptographic key.
  The program must get the path to the text file with the source text and create a file with the encrypted text based on it.
  
  2. Cryptanalysis by brute force method.
  The program must brute force the ciphertext passed as a text file.
  If the user chooses brute force, the program must independently, by brute force, find the key and decrypt the text.

## Note:
* The cryptographic alphabet is based on all uppercase and capital letters of the Russian alphabet and punctuation marks (. , "" : - ! ! ? SPACE).
If there are characters that are not included in the cryptographic alphabet, such characters are simply skipped and are not encrypted.

* P.S. The program has a graphical interface implemented using JavaFX. JavaFX can build artifact only Java 8.
