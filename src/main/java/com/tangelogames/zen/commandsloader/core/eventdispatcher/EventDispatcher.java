package com.tangelogames.zen.commandsloader.core.eventdispatcher;

public interface EventDispatcher {

    void subscribe(String eventName, EventSubscriber eventListener);

    void publish(Event event);
}
