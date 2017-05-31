package com.tangelogames.zen.commandsloader.core.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandsManager {

    static final String COMMANDS_NAMESPACE = "com.tangelogames.zen";

    static private CommandsManager manager;

    private List<Command> commandsList;

    private Map<String, Command> commandsMap;

    /**
     *
     * @return
     */
    public static CommandsManager getManager() {

        if (CommandsManager.manager == null) {
            CommandsManager.manager = new CommandsManager();
        }

        return CommandsManager.manager;
    }

    /**
     *
     */
    private CommandsManager() {
        this.init();
    }

    /**
     *
     */
    private void init() {

        this.commandsMap = new HashMap();

        CommandsLoader commandsLoader = new CommandsLoader(COMMANDS_NAMESPACE);

        this.commandsList = commandsLoader.loadCommandsByAnnotation();
//        this.commandsList = commandsLoader.loadCommandsByInterface();

        for (Command command : this.commandsList) {
            this.commandsMap.put(command.getName(), command);
        }

    }

    /**
     *
     * @return
     */
    public List<Command> getCommands() {
        return this.commandsList;
    }

    /**
     *
     * @param name
     *
     * @return
     *
     * @throws Exception
     */
    public Command lookupCommand(String name) throws Exception {

        Command command = this.commandsMap.get(name);

        if (command == null) {
            throw new Exception(String.format("Command '%s' not found", name));
        }

        return command;
    }
}
