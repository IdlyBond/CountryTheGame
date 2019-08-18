package mechanics;

import mechanics.utils.Printer;

import java.util.ArrayList;

public abstract class Building extends Structure{
    protected static int happiness;
    protected static int budget;
    protected static int ecology;
    protected static int tourism;

    public void work(Statistic statistic) {
        statistic.changeHappiness(happiness);
        statistic.changeBudget(budget);
        statistic.changeEcology(ecology);
        statistic.changeTourism(tourism);
    }

    public Building(String name) {
        super(name);
    }

    public int getHappiness() {
        return happiness;
    }

    public int getBudget() {
        return budget;
    }

    public int getEcology() {
        return ecology;
    }

    public int getTourism() {
        return tourism;
    }

    public String getPerks(){
        return Printer.getStatistic(budget, happiness, ecology, tourism);

    }
}
