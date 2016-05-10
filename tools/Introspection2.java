package tools;

import org.apache.commons.lang3.reflect.ConstructorUtils;

import java.util.Arrays;

public abstract class Introspection2 {

    public static Object newInstance(String className, final Object... args) throws InstantiationException {
        try {
            Class c = Class.forName(className);
            return ConstructorUtils.invokeConstructor(c, args);
        } catch (Exception ex) {
            throw new InstantiationException(
                    "Type '" + className +
                            "' with arguments " + Arrays.asList(args) +
                            " could not be instantiated: " + ex.getMessage());
        }
    }
}
