package com.dailycoder.parkinglot.mode;

import com.dailycoder.parkinglot.Printer;
import com.dailycoder.parkinglot.commands.CommandExecutorFactory;
import com.dailycoder.parkinglot.commands.ExitCommandExecutor;
import com.dailycoder.parkinglot.model.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InteractiveMode extends Mode{

    public InteractiveMode(
            final CommandExecutorFactory commandExecutorFactory, final Printer outputPrinter) {
        super(commandExecutorFactory, outputPrinter);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void process() throws IOException {
        outputPrinter.print("welcome");
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            final String input = reader.readLine();
            final Command command = new Command(input);
            processCommand(command);
            if (command.getCommandName().equals(ExitCommandExecutor.COMMAND_NAME)) {
                break;
            }
        }
    }
}

