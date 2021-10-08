package xyz.auriium.kommander.command;

public interface Individual<T> {

    void execution(T sender, String alias);

}
