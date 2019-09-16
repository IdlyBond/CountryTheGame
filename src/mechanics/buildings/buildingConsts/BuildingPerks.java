package mechanics.buildings.buildingConsts;

public enum BuildingPerks {
    HOSPITAL_HAPPINESS(1),
    HOSPITAL_BUDGET(-10),
    HOSPITAL_ECOLOGY(0.3),
    HOSPITAL_TOURISM(0.2),

    SCHOOL_HAPPINESS(1),
    SCHOOL_BUDGET(-10),
    SCHOOL_ECOLOGY(1),
    SCHOOL_TOURISM(0.2),

    MONUMENT_HAPPINESS(1.5),
    MONUMENT_BUDGET(-25),
    MONUMENT_ECOLOGY(1),
    MONUMENT_TOURISM(3),

    FACTORY_HAPPINESS(-1.5),
    FACTORY_BUDGET(100),
    FACTORY_ECOLOGY(-3),
    FACTORY_TOURISM(-1.5),


    ;

    private double number;

    BuildingPerks(double number) {
        this.number = number;
    }

    public double get() {
        return number;
    }
}
