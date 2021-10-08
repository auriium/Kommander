package xyz.auriium.kommander;

import java.util.List;
import java.util.Queue;

public interface Command<T> {

    void execution(T sender, String alias, Queue<String> arguments) throws CommandException;
    List<String> suggestion(T sender, String alias, Queue<String> arguments) throws CommandException;


}
