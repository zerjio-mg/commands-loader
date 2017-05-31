package com.tangelogames.zen.commandsloader.core.eventdispatcher;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SimpleEventDispatcher implements EventDispatcher {

    private Map<String, List<EventSubscriber>> eventSubscribers;

    public SimpleEventDispatcher() {

        this.eventSubscribers = new HashMap();
    }

    @Override
    public void subscribe(String eventName, EventSubscriber eventListener) {

        List subscribers = this.lookupSubscribersByEventName(eventName);

        if (subscribers.contains(eventListener)) {
            return;
        }

        subscribers.add(eventListener);
    }

    @Override
    public void publish(Event event) {

        List<EventSubscriber> subscribers = this.lookupSubscribersByEventName(event.getName());

        for (EventSubscriber subscriber : subscribers) {
            subscriber.notifyEvent(event);
        }
    }

    private List<EventSubscriber> lookupSubscribersByEventName(String eventName) {

        List<EventSubscriber> subscribers = this.eventSubscribers.get(eventName);

        if (subscribers == null) {
            subscribers = new ArrayList();
            this.eventSubscribers.put(eventName, subscribers);
        }

        return subscribers;
    }
}
