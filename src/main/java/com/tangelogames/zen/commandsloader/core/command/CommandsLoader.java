package com.tangelogames.zen.commandsloader.core.command;

import com.tangelogames.zen.commandsloader.core.command.annotation.CommandHandler;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.reflections.Reflections;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.ClasspathHelper;
import org.reflections.scanners.MethodAnnotationsScanner;

public class CommandsLoader {

    private String namespace;

    /**
     *
     * @param namespace
     */
    public CommandsLoader(String namespace) {
        this.namespace = namespace;
    }

    /**
     *
     * @return
     */
    public List<Command> loadCommandsByInterface() {

        Reflections reflections = new Reflections(this.namespace);

        List<String> classNameList = new ArrayList();

        for (Class cl : reflections.getSubTypesOf(Command.class)) {
            classNameList.add(cl.getCanonicalName());
        }

        return newObjectsFromClassNameList(classNameList);
    }

    /**
     *
     * @return
     */
    public List<Command> loadCommandsByAnnotation() {

        Reflections reflections = new Reflections(
            new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forPackage(this.namespace))
                .setScanners(new MethodAnnotationsScanner())
        );

        List<String> classNameList = new ArrayList();

        for (Method method : reflections.getMethodsAnnotatedWith(CommandHandler.class)) {
            classNameList.add(method.getDeclaringClass().getCanonicalName());
        }

        return newObjectsFromClassNameList(classNameList);
    }

    /**
     *
     * @param classNameList
     *
     * @return
     */
    private List<Command> newObjectsFromClassNameList(List<String> classNameList) {

        List<Command> commands = new ArrayList();

        for (String className : classNameList) {
            try {
                Class cls = Class.forName(className);
                commands.add((Command)cls.newInstance());
            } catch (Exception ex) {
                System.out.printf("ERROR creating command '%s' : %s\n", className, ex.getMessage());
            }
        }

        return commands;
    }
}
