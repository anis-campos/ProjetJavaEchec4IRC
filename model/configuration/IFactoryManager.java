package model.configuration;

/**
 * Created by Anis on 11/05/2016.
 */
public interface IFactoryManager {


    <T extends IFactory> void bind(final Class<? extends T> type, final Class<? extends T> implType);

    <T extends IFactory> T getFactory(final Class<T> type, final Object... args);


}
