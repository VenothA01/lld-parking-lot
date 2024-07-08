package com.dailycoder.parkinglot.mode;

import com.dailycoder.parkinglot.Printer;
import com.dailycoder.parkinglot.commands.CommandExecutor;
import com.dailycoder.parkinglot.commands.CommandExecutorFactory;
import com.dailycoder.parkinglot.exception.InvalidCommandException;
import com.dailycoder.parkinglot.model.Command;

import java.io.IOException;

public abstract class Mode {

    private CommandExecutorFactory commandExecutorFactory;
    protected Printer outputPrinter;

    public Mode(
            final CommandExecutorFactory commandExecutorFactory, final Printer outputPrinter) {
        this.commandExecutorFactory = commandExecutorFactory;
        this.outputPrinter = outputPrinter;
    }

    /**
     * Helper method to process a command. It basically uses {@link CommandExecutor} to run the given
     * command.
     *
     * @param command Command to be processed.
     */
    protected void processCommand(final Command command) {
        final CommandExecutor commandExecutor = commandExecutorFactory.getCommandExecutor(command);
        if (commandExecutor.validate(command)) {
            commandExecutor.execute(command);
        } else {
            throw new InvalidCommandException("Invalid command");
        }
    }

    /**
     * Abstract method to process the mode. Each mode will process in its own way.
     *
     * @throws IOException
     */
    public abstract void process() throws IOException;

}