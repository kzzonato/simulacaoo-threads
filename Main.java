package org.example.test.threads.simulacao;

import org.example.test.threads.simulacao.ui.Ui;

public class Main {
    public static void main(String[] args) throws Exception {
        Ui ui = new Ui();
        ui.init();
        Thread.sleep(1000);
    }
}
