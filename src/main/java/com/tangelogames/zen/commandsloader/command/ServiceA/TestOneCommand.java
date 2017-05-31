package com.tangelogames.zen.commandsloader.command.ServiceA;

import com.tangelogames.zen.commandsloader.core.command.annotation.CommandHandler;
import com.tangelogames.zen.commandsloader.core.container.Container;
import com.tangelogames.zen.commandsloader.service.ServicePim;
import com.tangelogames.zen.commandsloader.core.command.Command;

public class TestOneCommand implements Command {

    public static final String COMMAND_NAME = "com.tangelogames.ServiceA.TestOneCommand";

    @Override
    public String getName() {
        return COMMAND_NAME;
    }

    @Override
    @CommandHandler(name = COMMAND_NAME)
    public String execute(String message) {

        System.out.printf(" * ServiceA.TestOneCommand.execute(%s)\n", message);

        ((ServicePim) Container.getContainer().get("service.pim")).doSomething();

        return "OK";
    }
}
