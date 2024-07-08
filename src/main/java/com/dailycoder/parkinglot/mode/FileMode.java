package com.dailycoder.parkinglot.mode;

import com.dailycoder.parkinglot.Printer;
import com.dailycoder.parkinglot.commands.CommandExecutorFactory;
import com.dailycoder.parkinglot.model.Command;

import java.io.*;

public class FileMode extends Mode{

    private String fileName;

    public FileMode(
            final CommandExecutorFactory commandExecutorFactory,
            final Printer outputPrinter,
            final String fileName) {
        super(commandExecutorFactory, outputPrinter);
        this.fileName = fileName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void process() throws IOException {
        final File file = new File(fileName);
        final BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            outputPrinter.print("invalidFile");
            return;
        }

        String input = reader.readLine();
        while (input != null) {
            final Command command = new Command(input);
            processCommand(command);
            input = reader.readLine();
        }
    }
}
