package mechanics.consts;

public enum BuildingPerks {
    HOSPITAL_HAPPINESS(1),
    HOSPITAL_BUDGET(-15),
    HOSPITAL_ECOLOGY(-0.2),
    HOSPITAL_TOURISM(0.2),

    SCHOOL_HAPPINESS(1),
    SCHOOL_BUDGET(-10),
    SCHOOL_ECOLOGY(-0.4),
    SCHOOL_TOURISM(0.2),

    MONUMENT_HAPPINESS(2),
    MONUMENT_BUDGET(-20),
    MONUMENT_ECOLOGY(2),
    MONUMENT_TOURISM(4),

    FACTORY_HAPPINESS(-2),
    FACTORY_BUDGET(80),
    FACTORY_ECOLOGY(-4),
    FACTORY_TOURISM(-2),


    ;

    private double number;

    BuildingPerks(double number) {
        this.number = number;
    }

    public double get() {
        return number;
    }
}
