package org.example.test.threads.simulacao.model.filesClass;

import java.io.File;

public class FilesSaved {

    private static String filePath = "/src/main/java/org/example/test/threads/simulacao/model/filesClass/filesSaved";
    private static File folder = new File(filePath);
    private static File[] listOfFiles = folder.listFiles((dir, name) -> name.endsWith(".txt"));

    public static File[] getFiles() {
        return listOfFiles;
    }

    public static void saveFile(File file){
        System.out.println("files saved");
    }

}
