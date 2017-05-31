package com.tangelogames.zen.commandsloader.service;

public class ServicePam {

    static private int counter = 0;

    public void doWhatever() {
        System.out.printf(" ! ServicePam.doWhatever(%d)\n", ++ ServicePam.counter);
    }
}
