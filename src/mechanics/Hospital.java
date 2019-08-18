package mechanics;

import mechanics.consts.BuildingPerks;

public class Hospital extends Building{

    static {
        happiness = BuildingPerks.HOSPITAL_HAPPINESS.get();
        budget = BuildingPerks.HOSPITAL_BUDGET.get();
        ecology = BuildingPerks.HOSPITAL_ECOLOGY.get();
        tourism = BuildingPerks.HOSPITAL_TOURISM.get();
    }

    public Hospital(String name) {
        super(name);
    }
}
