package com.tangelogames.zen.commandsloader.core.command;

public interface Command {

    String getName();

    String execute(String message);
}
