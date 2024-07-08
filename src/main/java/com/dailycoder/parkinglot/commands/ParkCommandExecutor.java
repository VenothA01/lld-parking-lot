package com.dailycoder.parkinglot.commands;

import com.dailycoder.parkinglot.Printer;
import com.dailycoder.parkinglot.exception.NoFreeSlotAvailableException;
import com.dailycoder.parkinglot.model.Car;
import com.dailycoder.parkinglot.model.Command;
import com.dailycoder.parkinglot.service.ParkingLotService;

/**
 * Executor to handle command of parking a car into the parking lot. This outputs the alloted slot
 * in which the car is parked.
 */
public class ParkCommandExecutor extends CommandExecutor {
    public static String COMMAND_NAME = "park";

    public ParkCommandExecutor(
            final ParkingLotService parkingLotService, final Printer outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean validate(final Command command) {
        return command.getParams().size() == 2;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(final Command command) {
        final Car car = new Car(command.getParams().get(0), command.getParams().get(1));
        try {
            final Integer slot = parkingLotService.park(car);
            outputPrinter.print("Allocated slot number: " + slot);
        } catch (NoFreeSlotAvailableException exception) {
            outputPrinter.print("Parking full");
        }
    }
}

