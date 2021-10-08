package xyz.auriium.kommander.command;

import xyz.auriium.kommander.CommandException;

public class TooFewArgsException extends CommandException {

    public TooFewArgsException() {
        super("No default command provided for a forking command!");
    }
}
