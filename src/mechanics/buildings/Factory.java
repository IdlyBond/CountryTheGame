package mechanics.buildings;

import mechanics.Statistic;
import mechanics.consts.BuildingPerks;

public class Factory extends Building{

    public Factory(String name) {
        super(name);
    }

    @Override
    public void doWork(Statistic statistic) {
        super.work(statistic,
                BuildingPerks.FACTORY_HAPPINESS.get(),
                BuildingPerks.FACTORY_BUDGET.get(),
                BuildingPerks.FACTORY_ECOLOGY.get(),
                BuildingPerks.FACTORY_TOURISM.get());
    }
}
