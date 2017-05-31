package com.tangelogames.zen.commandsloader.service;

public class ServicePim {

    static private int counter = 0;

    public void doSomething() {
        System.out.printf(" ! ServicePim.doSomething(%d)\n", ++ ServicePim.counter);
    }
}
