package com.tangelogames.zen.commandsloader.command.ServiceA;

import com.tangelogames.zen.commandsloader.core.command.annotation.CommandHandler;
import com.tangelogames.zen.commandsloader.core.command.Command;

public class TestTwoCommand implements Command {

    public static final String TOPIC = "com.tangelogames.ServiceA.TestTwoCommand";

    @Override
    public String getName() {
        return TOPIC;
    }

    @Override
    @CommandHandler(name = TOPIC)
    public String execute(String message) {

        System.out.printf(" * ServiceA.TestTwoCommand.execute(%s)\n", message);

        return "OK";
    }
}
