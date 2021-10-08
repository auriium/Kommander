package xyz.auriium.kommander.command;

import xyz.auriium.kommander.Command;
import xyz.auriium.kommander.CommandException;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CmdIndividual<T> implements Command<T> {

    private final Individual<T> individual;

    public CmdIndividual(Individual<T> individual) {
        this.individual = individual;
    }

    @Override
    public void execution(T sender, String alias, Queue<String> arguments) throws CommandException {

        if (!arguments.isEmpty()) throw new TooManyArgsException();

        individual.execution(sender, alias);
    }

    @Override
    public List<String> suggestion(T sender, String alias, Queue<String> arguments) throws CommandException {
        return new ArrayList<>();
    }


}
