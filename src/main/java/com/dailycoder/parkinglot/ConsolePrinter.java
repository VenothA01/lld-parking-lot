package com.dailycoder.parkinglot;

public class ConsolePrinter implements Printer {

    public void welcome() {
        print("Welcome to Go-Jek Parking lot.");
    }

    public void end() {
        print("Thanks for using Go-Jek Parking lot service.");
    }

    public void notFound() {
        print("Not found");
    }

    public void statusHeader() {
        print("Slot No.    Registration No    Colour");
    }

    public void parkingLotFull() {
        print("Sorry, parking lot is full");
    }

    public void parkingLotEmpty() {
        print("Parking lot is empty");
    }

    public void invalidFile() {
        print("Invalid file given.");
    }

    @Override
    public  void print(String msg) {
        System.out.println(msg);
    }
}
