package xyz.auriium.kommander;

import xyz.auriium.kommander.command.CmdForking;
import xyz.auriium.kommander.command.CmdIndividual;
import xyz.auriium.kommander.command.Individual;
import xyz.auriium.kommander.command.fork.FkChain;
import xyz.auriium.kommander.command.fork.FkString;

import java.util.List;
import java.util.Queue;

public class KommanderIT {

    public void test() {
        new CmdForking<>(
                new FkChain<>(List.of(
                        new FkString<>("somecommand", new SomeCommand()),
                        new FkString<>("othercommand", new CmdIndividual<>(new OtherIndividual()))
                ))
        );
    }

    public static class SomeCommand implements Command<String> {

        @Override
        public void execution(String sender, String alias, Queue<String> arguments) throws CommandException {
            System.out.println("Username: " + sender + " Alias: " + alias);
        }

        @Override
        public List<String> suggestion(String sender, String alias, Queue<String> arguments) throws CommandException {
            return List.of();
        }
    }

    public static class OtherIndividual implements Individual<String> {

        @Override
        public void execution(String sender, String alias) {
            System.out.println("Some other command by: " + sender);
        }
    }

}
