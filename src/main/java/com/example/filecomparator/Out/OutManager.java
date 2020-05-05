package com.example.filecomparator.Out;

import com.example.filecomparator.Model.FileData;

import java.io.PrintStream;

public class OutManager {
    public static void out(FileData file, PrintStream destination) {
        file.pairs().stream().forEach(pair->destination.println(file.fullPath() + " <=> " + pair.fullPath()));
    }
}

