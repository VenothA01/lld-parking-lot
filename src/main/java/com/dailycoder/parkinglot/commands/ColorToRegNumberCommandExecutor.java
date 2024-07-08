package com.dailycoder.parkinglot.commands;

import com.dailycoder.parkinglot.Printer;
import com.dailycoder.parkinglot.model.Command;
import com.dailycoder.parkinglot.model.Slot;
import com.dailycoder.parkinglot.service.ParkingLotService;

import java.util.List;
import java.util.stream.Collectors;

public class ColorToRegNumberCommandExecutor  extends CommandExecutor{

    public static String COMMAND_NAME = "registration_numbers_for_cars_with_colour";

    public ColorToRegNumberCommandExecutor(ParkingLotService parkingLotService, final Printer printer) {
        super(parkingLotService,printer);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().size()==1;
    }

    @Override
    public void execute(Command command) {
        final List<Slot> slotsForColor = parkingLotService.getSlotsForColor(command.getParams().get(0));
        if (slotsForColor.isEmpty()) {
            outputPrinter.print("Not found");
        } else {
            final String result =
                    slotsForColor.stream()
                            .map(slot -> slot.getParkedCar().getRegistrationNumber())
                            .collect(Collectors.joining(", "));
            outputPrinter.print(result);
        }
    }
}
