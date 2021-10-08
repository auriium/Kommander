package xyz.auriium.kommander.command.fork;

import xyz.auriium.kommander.CommandException;

import java.util.List;
import java.util.Optional;
import java.util.Queue;

public interface Fork<T> {

    boolean handle(T sender, String alias, Queue<String> arguments) throws CommandException;
    Optional<List<String>> handleSuggestion(T sender, String alias, Queue<String> arguments) throws CommandException;

}
