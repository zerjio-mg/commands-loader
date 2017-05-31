package com.tangelogames.zen.commandsloader.core.container;

import java.util.HashMap;
import java.util.Map;

public class Container {

    static private Container container;

    private Map<String, Object> services;

    /**
     *
     * @return
     */
    public static Container getContainer() {

        if (Container.container == null) {
            Container.container = new Container();
        }

        return Container.container;
    }

    /**
     *
     */
    private Container() {
        this.services = new HashMap();
    }

    /**
     *
     * @param name
     * @param object
     */
    public void registre(String name, Object object) {
        this.services.put(name, object);
    }

    public Object get(String name) {
        return this.services.get(name);
    }
}
