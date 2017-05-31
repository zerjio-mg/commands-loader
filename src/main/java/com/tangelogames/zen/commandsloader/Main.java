package com.tangelogames.zen.commandsloader;

import com.tangelogames.zen.commandsloader.core.command.CommandsManager;
import com.tangelogames.zen.commandsloader.core.container.Container;
import com.tangelogames.zen.commandsloader.core.command.Command;
import com.tangelogames.zen.commandsloader.service.ServicePim;
import com.tangelogames.zen.commandsloader.service.ServicePam;
import com.tangelogames.zen.commandsloader.service.ServicePum;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Container.getContainer().registre("service.pim", new ServicePim());
        Container.getContainer().registre("service.pam", new ServicePam());
/* */
        Container.getContainer().registre("service.pum", new ServicePum());
/* */

        CommandsManager commandsManager = CommandsManager.getManager();

        listCommands(commandsManager.getCommands());

        executeCommand(commandsManager, "com.tangelogames.ServiceA.TestOneCommand", "one");
        executeCommand(commandsManager, "com.tangelogames.ServiceA.TestTwoCommand", "two");
        executeCommand(commandsManager, "com.tangelogames.ServiceB.TestThreeCommand", "three");
        executeCommand(commandsManager, "com.tangelogames.ServiceC.TestFourCommand", "four");
        executeCommand(commandsManager, "com.tangelogames.ServiceC.TestFiveCommand", "five");
    }

    private static void listCommands(List<Command> commands) {

        System.out.printf("\n\nCommands loaded:\n");

        commands.stream()
            .map(s -> s.getName())
            .sorted()
            .forEach(s -> System.out.printf("  - %s\n", s));
    }

    private static void executeCommand(CommandsManager commandsManager, String name, String value) {

        System.out.printf("\nExecute command [%s]\n", name);
        try {
            Command command = commandsManager.lookupCommand(name);
            String result = command.execute(value);
            System.out.printf(" - ret : [%s]\n", result);
        } catch (Exception ex) {
            System.out.printf("ERROR : %s\n", ex.getMessage());
        }
    }
}
