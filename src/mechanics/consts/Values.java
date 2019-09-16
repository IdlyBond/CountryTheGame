package mechanics.consts;

public enum Values {
    START_BUDGET(1000),
    START_BUILDING_COST(100),
    START_STREET_COST(700),
    START_TOWN_COST(1000),
    BUILDING_COST_CHANGE(20),
    STREET_COST_CHANGE(200),
    TOWN_COST_CHANGE(2000),
    MAX_DEFAULT_VALUE(100),
    MAX_HAPPINESS(100),
    MAX_ECOLOGY(100),
    MAX_TOURISM(100),
    START_HAPPINESS(50),
    START_ECOLOGY(50),
    START_TOURISM(50),
    MAX_STREETS_IN_TOWN(5),
    MAX_BUILDINGS_ON_STREET(5),
    MAX_TOWNS(5),
    PRINT_MENU_LENGTH(60),
    PRINT_MENU_HEIGHT_ADD(2),
    ERROR_NUMBER(-1),
    START_MENU(1),
    STANDARD_ROAD_LENGTH(20),
    GAME_OVER(-1),

    ;

    private int number;

    Values(int number) {
        this.number = number;
    }

    public int get() {
        return number;
    }
}
