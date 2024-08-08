package org.example.test.threads.simulacao.model.threadsClass;

public class Download implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("\nDownloading file...");
            Thread.sleep(10000);
            System.out.println("\nDownload completed!");
        } catch (InterruptedException e) {
            throw new RuntimeException("Error trying download file.");
        }
    }
}
