package mechanics.buildings;

import mechanics.Statistic;
import mechanics.consts.BuildingPerks;

public class Monument extends Building{

    public Monument(String name) {
        super(name);
    }

    @Override
    public void doWork(Statistic statistic) {
        super.work(statistic,
                BuildingPerks.MONUMENT_HAPPINESS.get(),
                BuildingPerks.MONUMENT_BUDGET.get(),
                BuildingPerks.MONUMENT_ECOLOGY.get(),
                BuildingPerks.MONUMENT_TOURISM.get());
    }
}
