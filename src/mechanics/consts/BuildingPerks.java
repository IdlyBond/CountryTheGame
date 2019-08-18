package mechanics.consts;

public enum BuildingPerks {
    HOSPITAL_HAPPINESS(5),
    HOSPITAL_BUDGET(-5),
    HOSPITAL_ECOLOGY(0),
    HOSPITAL_TOURISM(0),

    SCHOOL_HAPPINESS(0),
    SCHOOL_BUDGET(0),
    SCHOOL_ECOLOGY(0),
    SCHOOL_TOURISM(0),

    MONUMENT_HAPPINESS(0),
    MONUMENT_BUDGET(0),
    MONUMENT_ECOLOGY(0),
    MONUMENT_TOURISM(0),

    FACTORY_HAPPINESS(-5),
    FACTORY_BUDGET(5),
    FACTORY_ECOLOGY(0),
    FACTORY_TOURISM(0),


    ;

    private int number;

    BuildingPerks(int number) {
        this.number = number;
    }

    public int get() {
        return number;
    }
}
