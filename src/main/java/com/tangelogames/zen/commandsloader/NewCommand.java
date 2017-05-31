package com.tangelogames.zen.commandsloader;

/* * /
public class NewCommand implements Command {
/* */
public class NewCommand {
/* */

    public static final String TOPIC = "com.tangelogames.ServiceC.TestFiveCommand";

    public String getName() {
        return TOPIC;
    }

/* * /
    @CommandHandler(name = TOPIC)
/* */
    public String execute(String message) {

        System.out.printf(" * ServiceC.TestFiveCommand.execute(%s)\n", message);

        return "JURL !!!";
    }
}
