package org.example.test.threads.simulacao.model.filesClass;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FilesSaved {

    private static List<File> files = new ArrayList<>();

    public static List<File> getFiles() {
        return files;
    }

    public static void saveFile(File file){
        files.add(file);
        System.out.println("files saved");
    }

}
