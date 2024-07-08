package com.dailycoder.parkinglot.commands;

import com.dailycoder.parkinglot.Printer;
import com.dailycoder.parkinglot.model.Command;
import com.dailycoder.parkinglot.model.Parking.Strategy.NaturalOrderingParkingStrategy;
import com.dailycoder.parkinglot.model.ParkingLot;
import com.dailycoder.parkinglot.service.ParkingLotService;
import com.dailycoder.parkinglot.validator.IntegerValidator;

import java.util.List;

/**
 * Executor to handle command of creating the initial parking lot.
 */
public class CreateParkingLotCommandExecutor extends CommandExecutor {
    public static String COMMAND_NAME = "create_parking_lot";

    public CreateParkingLotCommandExecutor(
            final ParkingLotService parkingLotService, final Printer outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean validate(final Command command) {
        final List<String> params = command.getParams();
        if (params.size() != 1) {
            return false;
        }
        return IntegerValidator.isInteger(params.get(0));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(final Command command) {
        final int parkingLotCapacity = Integer.parseInt(command.getParams().get(0));
        final ParkingLot parkingLot = new ParkingLot(parkingLotCapacity);
        parkingLotService.createParkingLot(parkingLot, new NaturalOrderingParkingStrategy());
        outputPrinter.print(
                "Created a parking lot with " + parkingLot.getCapacity() + " slots");
    }
}

