package com.tangelogames.zen.commandsloader.core.eventdispatcher;

public class EventDispatcherFactory {

    static private EventDispatcher eventDispatcher;

    public static EventDispatcher get() {

        if (EventDispatcherFactory.eventDispatcher == null) {
            EventDispatcherFactory.eventDispatcher = new SimpleEventDispatcher();
        }

        return EventDispatcherFactory.eventDispatcher;
    }

}
