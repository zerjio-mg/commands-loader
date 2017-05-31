package com.tangelogames.zen.commandsloader.core.eventdispatcher;

public class SimpleEvent implements Event {

    private String name;

    private Object data;

    public SimpleEvent(String name, Object data) {

        this.name = name;
        this.data = data;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Object getData() {
        return this.data;
    }
}
