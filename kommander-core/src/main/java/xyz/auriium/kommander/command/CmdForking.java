package xyz.auriium.kommander.command;

import xyz.auriium.kommander.Command;
import xyz.auriium.kommander.CommandException;
import xyz.auriium.kommander.command.fork.Fork;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CmdForking<T> implements Command<T> {

    private final Fork<T> fork;

    public CmdForking(Fork<T> fork) {
        this.fork = fork;
    }


    @Override
    public void execution(T sender, String alias, Queue<String> arguments) throws CommandException {
        boolean optional = fork.handle(sender, alias, arguments);

        if (!optional) {
            throw new TooFewArgsException();
        }
    }

    @Override
    public List<String> suggestion(T sender, String alias, Queue<String> arguments) throws CommandException {
        var optional = fork.handleSuggestion(sender, alias, arguments);

        if (optional.isEmpty()) {
            return new ArrayList<>();
        }

        return optional.get();
    }
}
