package com.tangelogames.zen.commandsloader.command.ServiceC;

import com.tangelogames.zen.commandsloader.core.command.Command;

public class TestFourCommand implements Command {

    public static final String TOPIC = "com.tangelogames.ServiceC.TestFourCommand";

    @Override
    public String getName() {
        return TOPIC;
    }

    @Override
/* * /
    @CommandHandler(name = TOPIC)
/* */
    public String execute(String message) {

        System.out.printf(" * ServiceC.TestFourCommand.execute(%s)\n", message);

        return "ERROR";
    }
}
