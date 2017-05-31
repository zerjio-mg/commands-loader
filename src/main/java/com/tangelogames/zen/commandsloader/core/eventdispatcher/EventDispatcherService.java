package com.tangelogames.zen.commandsloader.core.eventdispatcher;

public class EventDispatcherService {

    static private EventDispatcher eventDispatcher;

    public static EventDispatcher get() {

        if (EventDispatcherService.eventDispatcher == null) {
            EventDispatcherService.eventDispatcher = new SimpleEventDispatcher();
        }

        return EventDispatcherService.eventDispatcher;
    }

}
