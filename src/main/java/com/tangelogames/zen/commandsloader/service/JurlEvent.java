package com.tangelogames.zen.commandsloader.service;

import com.tangelogames.zen.commandsloader.core.eventdispatcher.SimpleEvent;

public class JurlEvent extends SimpleEvent {

    public JurlEvent(String message) {

        super("event.jurl", String.format("Event JURL from %s", message));
    }
}
