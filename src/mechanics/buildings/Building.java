package mechanics.buildings;

import mechanics.Statistic;
import mechanics.Structure;


public abstract class Building extends Structure {
    // Класс здания для наследования
    public abstract void doWork(Statistic statistic);

    protected void work(Statistic statistic, double happiness, double budget, double ecology, double tourism) {
        statistic.changeStatistic(happiness, budget, ecology, tourism);
    }

    public Building(String name) {
        super(name);
    }
}
