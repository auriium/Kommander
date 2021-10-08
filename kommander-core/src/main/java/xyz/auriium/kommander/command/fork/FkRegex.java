package xyz.auriium.kommander.command.fork;

import xyz.auriium.kommander.Command;
import xyz.auriium.kommander.CommandException;

import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.regex.Pattern;

public class FkRegex<T> implements Fork<T> {

    private final Pattern pattern;
    private final Command<T> target;

    public FkRegex(Pattern pattern, Command<T> target) {
        this.pattern = pattern;
        this.target = target;
    }

    public FkRegex(String regex, Command<T> target) {
        this.pattern = Pattern.compile(regex);
        this.target = target;
    }


    @Override
    public boolean handle(T sender, String alias, Queue<String> arguments) throws CommandException {

        String value;
        if ((value = arguments.peek()) == null || pattern.matcher(value).matches()) {
            return false;
        }

        arguments.remove();
        target.execution(sender, alias, arguments);

        return true;
    }

    @Override
    public Optional<List<String>> handleSuggestion(T sender, String alias, Queue<String> arguments) throws CommandException {
        String value;
        if ((value = arguments.peek()) == null || pattern.matcher(value).matches()) {
            return Optional.empty();
        }

        arguments.remove();
        return Optional.of(target.suggestion(sender, alias, arguments));
    }
}
