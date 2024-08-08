package org.example.test.threads.simulacao.model.filesClass;

import java.io.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FilesUtil {

    private static String fileName = "/home/joao.siqueira/IdeaProjects/threadsTest/src/main/java/org/example/test/threads/simulacao/model/filesClass/filesSaved/newFile.txt";

    public static boolean createFile(){
        File file = new File(fileName);
        try {
            boolean isCreated = file.createNewFile();
            FilesSaved.saveFile(file);
            return isCreated;
        } catch (IOException e) {
            throw new RuntimeException("Error trying create new file.");
        }
    }

    public static boolean saveContent(String content){
        try(  BufferedWriter bw = new BufferedWriter( new FileWriter(fileName, true)) ) {

            String dateTime = dateFormated();
            bw.write(content+" : "+dateTime+"\n");
            bw.flush();

            if(!fileName.isEmpty()){
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            throw new RuntimeException("Error trying saving content.");
        }
    }

    public static void readFile(List<File> files){

        for(File file : files){
            try(
                    BufferedReader bf = new BufferedReader(new FileReader(file))
            ){
                String line;
                while ((line = bf.readLine()) != null){
                    System.out.println(line);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }






    }


    private static String dateFormated(){
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return localDateTime.format(formatter);
    }

}
