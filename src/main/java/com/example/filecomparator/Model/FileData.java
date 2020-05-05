package com.example.filecomparator.Model;

import com.example.filecomparator.Hash.HashManager;
import com.example.filecomparator.Properties.Properties;

import java.io.File;
import java.util.ArrayList;

public class FileData {
    private String fullPath;
    private File file;
    private String name;
    private Long size;
    private long crc32;
    private String md5;
    private String sha1;
    private ArrayList<FileData> pairs;
    private boolean paired;


    public long crc32() {
        if (crc32==0){
            crc32 = HashManager.generateCRC32(file);
        }
        return crc32;
    }

    private String md5() {
        if (md5 == null){
            md5 = HashManager.generateMD5(file);
        }
        return md5;
    }

    private String sha1() {
        if (sha1 == null){
            sha1 = HashManager.generateSHA1(file);
        }
        return sha1;
    }

    private String name() {
        return name;
    }

    private Long size() {
        return size;
    }

    public ArrayList<FileData> pairs() {
        return pairs;
    }

    public void addPair(FileData file) {
        this.pairs.add(file);
    }

    public String fullPath() {
        return fullPath;
    }

    public void setPaired() {
        paired = true;
    }

    public Boolean paired() {
        return paired;
    }

    public FileData(File file) {
        this.fullPath = file.getAbsolutePath();
        this.name = file.getName();
        this.size = file.length();
        this.pairs = new ArrayList<>();
        this.file = file;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FileData)) return false;

        FileData fileData = (FileData) o;

        // Check for simple fields
        if ((!Properties.getInstance().ignoreName()) && (!name.equalsIgnoreCase(fileData.name))) return false;
        if (!size.equals(fileData.size)) return false;

        // Check for long time executing operations(CRC, MD5, SHA)
        if (crc32() != 0 ? !(crc32() == (fileData.crc32())) : fileData.crc32() != 0) return false;
        if (md5() != "" ? !(md5().equals(fileData.md5())) : fileData.md5() != "") return false;
        if (sha1() !="" ? !(sha1().equals(fileData.sha1())) : fileData.sha1() != "") return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fullPath.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + size.hashCode();
        return result;
    }
}
