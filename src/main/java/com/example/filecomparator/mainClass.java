package com.example.filecomparator;

import com.example.filecomparator.Comparing.CompareManager;
import com.example.filecomparator.File.FileManager;
import com.example.filecomparator.Model.FileData;
import com.example.filecomparator.Out.OutManager;
import com.example.filecomparator.Properties.Properties;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class mainClass {

    public static void start(String path, Boolean ignoreName) {
        Properties.getInstance().setComparingFolder(path);
        Properties.getInstance().setIgnoreName(ignoreName);
        try {
            ArrayList<FileData> files = FileManager.getFiles(Properties.getInstance().comparingFolder());
            HashMap<String, FileData> mapFiles = new HashMap<>();
            files.stream().forEach(entry->mapFiles.put(entry.fullPath(), entry));
            HashSet<FileData> matchingFiles = CompareManager.getMatchingFiles(mapFiles);
            if (!matchingFiles.isEmpty()) {
                System.out.println("Matching pairs ==============");
            }
            for(FileData file:matchingFiles) {
                OutManager.out(file, System.out);
            }
        }
    catch (IOException e) {
            e.printStackTrace();
        }
    }

}
