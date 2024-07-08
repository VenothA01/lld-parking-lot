package com.dailycoder.parkinglot.commands;

import com.dailycoder.parkinglot.ConsolePrinter;
import com.dailycoder.parkinglot.Printer;
import com.dailycoder.parkinglot.model.Command;
import com.dailycoder.parkinglot.service.ParkingLotService;

public  abstract class CommandExecutor {

    protected ParkingLotService parkingLotService;
    protected Printer outputPrinter;

    public CommandExecutor(final ParkingLotService parkingLotService,Printer outputPrinter){
        this.parkingLotService = parkingLotService;
        this.outputPrinter = outputPrinter;
    }

    /**
     * Validates that whether a command is valid to be executed or not.
     *
     * @param command Command to be validated.
     * @return Boolean indicating whether command is valid or not.
     */
    public abstract boolean validate(Command command);

    /**
     * Executes the command.
     *
     * @param command Command to be executed.
     */
    public abstract void execute(Command command);
}
