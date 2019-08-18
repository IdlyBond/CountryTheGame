package mechanics;

import mechanics.consts.BuildingPerks;

public class Factory extends Building{

    public Factory(String name) {
        super(name);
        happiness = BuildingPerks.FACTORY_HAPPINESS.get();
        budget = BuildingPerks.FACTORY_BUDGET.get();
        ecology = BuildingPerks.FACTORY_ECOLOGY.get();
        tourism = BuildingPerks.FACTORY_TOURISM.get();
    }
}
