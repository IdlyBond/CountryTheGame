package mechanics.buildings;

import mechanics.Statistic;
import mechanics.consts.BuildingPerks;

public class Hospital extends Building{

    public Hospital(String name) {
        super(name);
    }

    @Override
    public void doWork(Statistic statistic) {
        super.work(statistic,
                BuildingPerks.HOSPITAL_HAPPINESS.get(),
                BuildingPerks.HOSPITAL_BUDGET.get(),
                BuildingPerks.HOSPITAL_ECOLOGY.get(),
                BuildingPerks.HOSPITAL_TOURISM.get());
    }
}
