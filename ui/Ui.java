package org.example.test.threads.simulacao.ui;

import org.example.test.threads.simulacao.model.filesClass.FilesUtil;
import org.example.test.threads.simulacao.model.threadsClass.Download;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Ui {

    private final Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    public void init() throws Exception {
        menu();
    }

    private void menu() throws Exception {

        boolean loop = true;
        int choose = 0;
        while (loop){
            try {
                System.out.println("\nEnter your Option: ");
                System.out.println("1-Create file\n2-Edit file\n3-Download file\n4-Get file\n5-Get all files");
                choose = scanner.nextInt();

                Thread tDownload = new Thread(new Download());

                switch (choose){
                    case 1 -> {
                        String content = "Hello World";
                        boolean isCreated = FilesUtil.createFile();
                        boolean isSaved =  FilesUtil.saveContent(content);

                        if(isCreated && isSaved){
                            System.out.println("File created and content saved");
                        } else if(isSaved){
                            System.out.println("content saved");
                        } else {
                            System.out.println("everything is update!");
                        }
                    }
                    case 2 -> {
                        String content = "Hello World [edited]";
                        boolean isEdited = FilesUtil.saveContent(content);
                        if(isEdited){
                            System.out.println("content saved");
                        } else {
                            System.out.println("your content wasn't saved");
                        }
                    }
                    case 3 -> {
                        tDownload.start();
                    }
                    case 4 -> {
                        // fazer dps do id completo
                    }
                    case 5 -> {
                        System.out.println("Reading file...");
                        FilesUtil.readAllFiles();
                    }
                    default -> {
                        throw new Exception("Invalid option! Try using 1,2,3 or 4.");
                    }
                }

            } catch (InputMismatchException e){
                throw new InputMismatchException("Value not valid, use only Integer value!");
            } catch (Exception e){
                throw new Exception("Error in menu.");
            }

            // parar loop
        }
    }

}
