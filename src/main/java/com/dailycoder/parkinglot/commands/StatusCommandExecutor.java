package com.dailycoder.parkinglot.commands;

import com.dailycoder.parkinglot.Printer;
import com.dailycoder.parkinglot.model.Car;
import com.dailycoder.parkinglot.model.Command;
import com.dailycoder.parkinglot.model.Slot;
import com.dailycoder.parkinglot.service.ParkingLotService;

import java.util.List;

/**
 * Executor to handle command of fetching the current status of the parking lot. It gives which
 * slot has which car. Car details will have both its registration number and its color.
 */
public class StatusCommandExecutor extends CommandExecutor {
    public static String COMMAND_NAME = "status";

    public StatusCommandExecutor(final ParkingLotService parkingLotService,
                                 final Printer outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean validate(final Command command) {
        return command.getParams().isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(Command command) {
        final List<Slot> occupiedSlots = parkingLotService.getOccupiedSlots();

        if (occupiedSlots.isEmpty()) {
            outputPrinter.print("parkingLotEmpty");
            return;
        }

        outputPrinter.print("statusHeader");
        for (Slot slot : occupiedSlots) {
            final Car parkedCar = slot.getParkedCar();
            final String slotNumber = slot.getSlotNumber().toString();

            outputPrinter.print(padString(slotNumber, 12)
                    + padString(parkedCar.getRegistrationNumber(), 19) + parkedCar.getColor());
        }
    }

    private static String padString(final String word, final int length) {
        String newWord = word;
        for(int count = word.length(); count < length; count++) {
            newWord = newWord + " ";
        }
        return newWord;
    }
}
