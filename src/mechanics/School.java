package mechanics;

import mechanics.consts.BuildingPerks;

public class School extends Building{

    public School(String name) {
        super(name);
        happiness = BuildingPerks.SCHOOL_HAPPINESS.get();
        budget = BuildingPerks.SCHOOL_BUDGET.get();
        ecology = BuildingPerks.SCHOOL_ECOLOGY.get();
        tourism = BuildingPerks.SCHOOL_TOURISM.get();
    }
}
