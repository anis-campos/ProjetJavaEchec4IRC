package model.configuration;

import tools.Introspection2;

import java.util.HashMap;

/**
 * Created by Anis on 10/05/2016.
 */
public class FactoryManager implements IFactoryManager {

    private static FactoryManager instance;
    HashMap<Class<?>, Class<?>> map;

    private FactoryManager() {
    	map = new HashMap<>();
    }

    public static FactoryManager getInstance() {
        if (instance == null) {
            instance = new FactoryManager();
        }

        return instance;
    }


    @Override
    public <T extends IFactory> void bind(Class<? extends T> type, Class<? extends T> implType) {
        if (type == null || implType == null) throw new IllegalArgumentException();

        map.put(type, implType);
    }

    @Override
    public <T extends IFactory> T getNewInstance(Class<T> type, Object... args) {
        if (type == null || !map.containsKey(type)) throw new IllegalArgumentException();

        final Class<T> implType = (Class<T>) map.get(type);

        String nomClasse = implType.getName();

        try {
            return (T) Introspection2.newInstance(nomClasse, args);
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        }
    }
}
