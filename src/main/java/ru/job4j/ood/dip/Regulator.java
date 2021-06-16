package ru.job4j.ood.dip;

public class Regulator {

    public void regulate(int maxTemp, int minTemp, IThermo thermometer, IHeat burner) {
        System.out.println();
        double existTemp = thermometer.read();
        if (existTemp > maxTemp) {
            burner.disengage();
        }
        if (existTemp < minTemp) {
            burner.engage();
        }
    }
}

