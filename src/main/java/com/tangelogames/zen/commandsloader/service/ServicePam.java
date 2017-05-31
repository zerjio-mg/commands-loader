package com.tangelogames.zen.commandsloader.service;

import com.tangelogames.zen.commandsloader.core.eventdispatcher.Event;
import com.tangelogames.zen.commandsloader.core.eventdispatcher.EventDispatcherService;
import com.tangelogames.zen.commandsloader.core.eventdispatcher.EventSubscriber;
import com.tangelogames.zen.commandsloader.core.eventdispatcher.SimpleEvent;

public class ServicePam implements EventSubscriber {

    static private int counter = 0;

    public ServicePam() {

        EventDispatcherService.get().subscribe("event.tran", this);
    }

    @Override
    public void notifyEvent(Event event) {

        System.out.printf(" > ServicePam.notifyEvent(%s) > %s\n", event.getName(), event.getData());
    }

    public void doWhatever() {

        System.out.printf(" ! ServicePam.doWhatever(%d)\n", ++ ServicePam.counter);

        EventDispatcherService.get().publish(new JurlEvent("ServicePam"));
    }
}
