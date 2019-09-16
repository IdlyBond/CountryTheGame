package mechanics.buildings.buildingConsts;


public enum BuildingTypes {
    HOSPITAL("Больница"),
    SCHOOL("Школа"),
    FACTORY("Фабрика"),
    MONUMENT("Достопримечательность"),

    ;

    private String name;

    BuildingTypes(String name) {
        this.name = name;
    }

    public String get() {
        return name;
    }

    @Override
    public String toString() {
        return get();
    }
}
