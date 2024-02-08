package ru.job4j.cast;

public class VehicleMain {
    public static void main(String[] args) {
        Vehicle bus = new Bus();
        Vehicle airplane = new Airplane();
        Vehicle train = new Train();

        Vehicle[] vehicles = {bus, airplane, train};
        for (Vehicle vehicle: vehicles) {
            vehicle.move();
        }
    }
}
