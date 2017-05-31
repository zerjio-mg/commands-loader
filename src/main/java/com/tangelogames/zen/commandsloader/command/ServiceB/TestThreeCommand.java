package com.tangelogames.zen.commandsloader.command.ServiceB;

import com.tangelogames.zen.commandsloader.core.command.annotation.CommandHandler;
import com.tangelogames.zen.commandsloader.core.command.Command;
import com.tangelogames.zen.commandsloader.core.container.Container;
import com.tangelogames.zen.commandsloader.service.ServicePim;
import com.tangelogames.zen.commandsloader.service.ServicePam;

public class TestThreeCommand implements Command {

    public static final String TOPIC = "com.tangelogames.ServiceB.TestThreeCommand";

    @Override
    public String getName() {
        return TOPIC;
    }

    @Override
    @CommandHandler(name = TOPIC)
    public String execute(String message) {

        System.out.printf(" * ServiceB.TestThreeCommand.execute(%s)\n", message);

        ((ServicePim)Container.getContainer().get("service.pim")).doSomething();
        ((ServicePam)Container.getContainer().get("service.pam")).doWhatever();

        return "ERROR";
    }
}
