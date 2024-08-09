package org.example.test.threads.simulacao.model.filesClass;

import java.io.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Optional;



public class FilesUtil {

    private static int idFile=0;
    private static String fileName = "src/main/java/org/example/test/threads/simulacao/model/filesClass/filesSaved/"+(idFile++)+".txt";

    public static boolean createFile(){
        File optionalFile = new File(fileName);

        if(optionalFile.exists()){
            fileName = "src/main/java/org/example/test/threads/simulacao/model/filesClass/filesSaved/"+(idFile++)+".txt";
            File file = new File(fileName);
            try {
                boolean isCreated = file.createNewFile();
                FilesSaved.saveFile(file);
                return isCreated;
            } catch (IOException e) {
                throw new RuntimeException("Error trying create new file.");
            }
        }

        return false;
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

    public static void readAllFiles(){

        File[] files =  FilesSaved.getFiles();
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

    public static void readFile(String fileName){

        File[] files = FilesSaved.getFiles();
        Optional<File> optionalFile = Arrays.stream(files).filter(file -> file.getName().equals(fileName)).findFirst();
        


    }




    private static String dateFormated(){
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return localDateTime.format(formatter);
    }

}
