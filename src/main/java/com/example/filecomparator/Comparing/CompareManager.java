package com.example.filecomparator.Comparing;

import com.example.filecomparator.Model.FileData;

import java.util.*;

public class CompareManager {

    private static void addMatchingFile(FileData source, Map.Entry<String, FileData> pair, HashSet<FileData> matchingFiles, HashMap<String, FileData> sourceFiles) {
        FileData obj = pair.getValue();
        source.addPair(obj);
        matchingFiles.add(source);
        obj.setPaired();
    }

    public static HashSet<FileData> getMatchingFiles(HashMap<String, FileData> sources) {
        HashMap<String, FileData> sourceFiles = (HashMap) sources.clone();
        HashSet<FileData> matchingFiles = new HashSet<>();
        Set<String> paths = sources.keySet();
        for (String sourcePath : paths) {
            FileData source = sourceFiles.get(sourcePath);
            if (source==null) {
                continue;
            }
            sourceFiles.remove(sourcePath);
            sourceFiles.entrySet().stream().filter(pair->(!source.paired() && source.equals(pair.getValue()))).forEach(pair->addMatchingFile(source, pair, matchingFiles, sourceFiles));
        }
        return matchingFiles;
    }
}
