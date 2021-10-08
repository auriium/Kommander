package xyz.auriium.kommander.command.fork;

import xyz.auriium.kommander.CommandException;

import java.util.List;
import java.util.Optional;
import java.util.Queue;

/**
 * Priority based fork chain
 * @param <T>
 */
public class FkChain<T> implements Fork<T> {

    private final List<Fork<T>> forks;

    public FkChain(List<Fork<T>> forks) {
        this.forks = forks;
    }

    @Override
    public boolean handle(T sender, String alias, Queue<String> arguments) throws CommandException {

        boolean handle = false;

        for (Fork<T> fork : forks) {
            boolean opt = fork.handle(sender, alias, arguments);

            if (opt) {
                handle = true;
                break;
            }
        }

        return handle;

    }

    @Override
    public Optional<List<String>> handleSuggestion(T sender, String alias, Queue<String> arguments) throws CommandException {
        Optional<List<String>> strings = Optional.empty();

        for (Fork<T> fork : forks) {
            var opt = fork.handleSuggestion(sender, alias, arguments);

            if (opt.isPresent()) {
                strings = opt;
                break;
            }
        }



        return strings;
    }
}
