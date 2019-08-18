package mechanics;

import mechanics.consts.BuildingPerks;

public class Monument extends Building{

    public Monument(String name) {
        super(name);
        happiness = BuildingPerks.MONUMENT_HAPPINESS.get();
        budget = BuildingPerks.MONUMENT_BUDGET.get();
        ecology = BuildingPerks.MONUMENT_ECOLOGY.get();
        tourism = BuildingPerks.MONUMENT_TOURISM.get();
    }
}
