package com.dailycoder.parkinglot;

import com.dailycoder.parkinglot.commands.CommandExecutorFactory;
import com.dailycoder.parkinglot.exception.InvalidModeException;
import com.dailycoder.parkinglot.mode.FileMode;
import com.dailycoder.parkinglot.mode.InteractiveMode;
import com.dailycoder.parkinglot.service.ParkingLotService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ParkingLotApplication {

    public static void main(String[] args) throws IOException {

        final Printer printer = new ConsolePrinter();
        final ParkingLotService parkingLotService = new ParkingLotService();
        final CommandExecutorFactory commandExecutorFactory = new CommandExecutorFactory(parkingLotService);

        if (isInteractiveMode(args)) {
            new InteractiveMode(commandExecutorFactory, printer).process();
        } else if (isFileInputMode(args)) {
            new FileMode(commandExecutorFactory, printer, args[0]).process();
        } else {
            throw new InvalidModeException();
        }
    }

    /**
     * Checks whether the program is running using file input mode.
     *
     * @param args Command line arguments.
     * @return Boolean indicating whether in file input mode.
     */
    private static boolean isFileInputMode(final String[] args) {
        return args.length == 1;
    }

    /**
     * Checks whether the program is running using interactive shell mode.
     *
     * @param args Command line arguments.
     * @return Boolean indicating whether in interactive shell mode.
     */
    private static boolean isInteractiveMode(final String[] args) {
        return args.length == 0;
    }


}


