package mechanics.buildings;

import mechanics.Statistic;
import mechanics.Structure;
import mechanics.utils.Printer;

import java.util.ArrayList;

public abstract class Building extends Structure {

    public abstract void doWork(Statistic statistic);

    protected void work(Statistic statistic, double happiness, double budget, double ecology, double tourism) {
        statistic.changeHappiness(happiness);
        statistic.changeBudget(budget);
        statistic.changeEcology(ecology);
        statistic.changeTourism(tourism);
    }

    public Building(String name) {
        super(name);
    }
}
