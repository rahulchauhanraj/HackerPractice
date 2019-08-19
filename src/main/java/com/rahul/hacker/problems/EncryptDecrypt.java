package com.rahul.hacker.problems;

import org.apache.commons.lang3.StringUtils;
import org.jasypt.util.text.BasicTextEncryptor;

public final class EncryptDecrypt {
    private static final String ENCRYPTION_PWD = "ec0mm3rce";

    public EncryptDecrypt() {
    }

    public static String decrypt(String encryptedString) {
        String decryptedString = null;
        if (StringUtils.isNotBlank(encryptedString)) {
            BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
            textEncryptor.setPassword("ec0mm3rce");
            decryptedString = textEncryptor.decrypt(encryptedString);
        }

        return decryptedString;
    }

    public static String encrypt(String string) {
        String encryptedString = null;
        if (StringUtils.isNotBlank(string)) {
            BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
            textEncryptor.setPassword("ec0mm3rce");
            encryptedString = textEncryptor.encrypt(string);
        }

        return encryptedString;
    }

    public static void main (String[] args) {
        System.out.println(decrypt("F9rL/EI2fS4exFZISMSDsLLjD2Y+9vhO"));
    }
}
