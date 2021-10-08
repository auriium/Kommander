package xyz.auriium.kommander.command;

import xyz.auriium.kommander.CommandException;

public class TooManyArgsException extends CommandException {

    public TooManyArgsException() {
        super("Too many command arguments provided");
    }
}
