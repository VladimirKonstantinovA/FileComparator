package com.example.filecomparator.Hash;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.*;
import java.util.zip.CRC32;

public class HashManager {
    public static long generateCRC32(File file) {
        CRC32 crc32 = new CRC32();
        try {
            InputStream inputStream = new FileInputStream(file);
            crc32.update(inputStream.readAllBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }

        return crc32.getValue();
    }

    private static byte[] getBytes(File file) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        try {
            return inputStream.readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String generateHash(File file, HashAlgorithm algorithm) {
        byte[] bytes = getBytes(file);
        switch (algorithm) {
            case MD5: return DigestUtils.md5Hex(bytes);
            case SHA1: return DigestUtils.sha1Hex(bytes);
            default: return "";
        }
    }

    public static String generateMD5(File file) {
        return generateHash(file, HashAlgorithm.MD5);
    }

    public static String generateSHA1(File file) {
        return generateHash(file, HashAlgorithm.SHA1);
    }
}
