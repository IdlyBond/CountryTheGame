package mechanics;

import mechanics.utils.Printer;

import java.util.ArrayList;

public abstract class Building extends Structure{
    protected static double happiness;
    protected static double budget;
    protected static double ecology;
    protected static double tourism;

    public void work(Statistic statistic) {
        statistic.changeHappiness(happiness);
        statistic.changeBudget(budget);
        statistic.changeEcology(ecology);
        statistic.changeTourism(tourism);
    }

    public Building(String name) {
        super(name);
    }

    public double getHappiness() {
        return happiness;
    }

    public double getBudget() {
        return budget;
    }

    public double getEcology() {
        return ecology;
    }

    public double getTourism() {
        return tourism;
    }

    public String getPerks(){
        return Printer.getStatistic(budget, happiness, ecology, tourism);
    }
}
