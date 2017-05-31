package com.tangelogames.zen.commandsloader.service;

import com.tangelogames.zen.commandsloader.core.eventdispatcher.Event;
import com.tangelogames.zen.commandsloader.core.eventdispatcher.EventDispatcherService;

public class ServicePum {

    static private int counter = 0;

    public ServicePum() {

        EventDispatcherService.get().subscribe("event.jurl", this::notifyEventJurl);
        EventDispatcherService.get().subscribe("event.tran", this::notifyEventTran);
    }

    private void notifyEventJurl(Event event) {

        System.out.printf(" > ServicePum.notifyEventJurl() > %s\n", event.getData());
    }

    private void notifyEventTran(Event event) {

        System.out.printf(" > ServicePum.notifyEventTran() > %s\n", event.getData());
    }

    public void doBiDoBiDu() {

        System.out.printf(" ! ServicePum.doBiDoBiDu(%d)\n", ++ ServicePum.counter);
    }
}
