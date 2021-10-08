package xyz.auriium.kommander.command.fork;

import xyz.auriium.kommander.Command;

import java.util.regex.Pattern;

/**
 * Default spigot style fork
 * @param <T>
 */
public class FkString<T> extends FkRegex<T> {

    public FkString(String pattern, Command<T> target) {
        super(Pattern.compile(pattern, Pattern.CASE_INSENSITIVE), target);
    }
}
