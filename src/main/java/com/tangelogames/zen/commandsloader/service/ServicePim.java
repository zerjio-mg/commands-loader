package com.tangelogames.zen.commandsloader.service;

import com.tangelogames.zen.commandsloader.core.eventdispatcher.Event;
import com.tangelogames.zen.commandsloader.core.eventdispatcher.EventDispatcherFactory;
import com.tangelogames.zen.commandsloader.core.eventdispatcher.EventSubscriber;
import com.tangelogames.zen.commandsloader.core.eventdispatcher.SimpleEvent;

public class ServicePim implements EventSubscriber {

    static private int counter = 0;

    public ServicePim() {

        EventDispatcherFactory.get().subscribe("event.jurl", this);
    }

    @Override
    public void notifyEvent(Event event) {

        System.out.printf(" > ServicePim.notifyEvent(%s) > %s\n", event.getName(), event.getData());
    }

    public void doSomething() {

        System.out.printf(" ! ServicePim.doSomething(%d)\n", ++ ServicePim.counter);

        EventDispatcherFactory.get().publish(new SimpleEvent("event.tran", "Event TRAN from ServicePim"));
    }
}
