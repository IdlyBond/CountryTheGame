package mechanics.buildings;

import mechanics.Statistic;
import mechanics.buildings.buildingConsts.BuildingPerks;

public class School extends Building{

    public School(String name) {
        super(name);
    }

    @Override
    public void doWork(Statistic statistic) {
        super.work(statistic,
                BuildingPerks.SCHOOL_HAPPINESS.get(),
                BuildingPerks.SCHOOL_BUDGET.get(),
                BuildingPerks.SCHOOL_ECOLOGY.get(),
                BuildingPerks.SCHOOL_TOURISM.get());
    }
}
