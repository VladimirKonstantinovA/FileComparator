package com.example.filecomparator.File;

import com.example.filecomparator.Model.FileData;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileManager {
    public static ArrayList<FileData> getFiles(String folder) throws IOException {
        Stream<Path> filesInFolder = Files.walk(Paths.get(folder), Integer.MAX_VALUE);
        ArrayList<FileData> files = filesInFolder.map(path->new File(String.valueOf(path))).filter(file->file.isFile()).map(FileData::new).collect(Collectors.toCollection(ArrayList::new));
        return files;
    }
}
