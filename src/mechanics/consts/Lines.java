package mechanics.consts;

public enum Lines {
    WELCOME("Добро пожадлвать в игру!"),
    ENTER_COUNTRY_NAME("Введите название страны:"),
    ENTER_TOWN_NAME("Введите название города:"),
    ENTER_STREET_NAME("Введите название улицы:"),
    ENTER_HOSPITAL_NAME("Именуйте больницу:"),
    ENTER_SCHOOL_NAME("Именуйте школу:"),
    ENTER_FACTORY_NAME("Именуйте фабрику:"),
    ENTER_MONUMENT_NAME("Именуйте достопримечательность:"),
    CHOOSE_TOWN("Выберите город:"),
    CHOOSE_STREET("Выберите улицу:"),
    CHOOSE_BUILDING("Выберите здание:"),
    CHOOSE_BUILDING_TYPE("Выберите тип строения:"),
    NO_TOWN("У вас нет городов! Вам даже негде спать!"),
    NO_STREET("У вас нет улиц!"),
    NO_BUILDING("У вас нет ни одной постройки!"),
    MAX_BUILDING("На этой улице не помещаются здания!"),
    MAX_STREET("В этом городе слишком много улиц!"),
    MAX_TOWN("У вас слишком много городов!"),
    NAME_FIRST_TOWN("Дайте назание своему первому городу!"),
    NAME_FIRST_STREET("Дайте назание своей первой улице!"),
    NOT_ENOUGH_HAPPINESS_FOR_ACTION("Горожане так несчастны, что даже не хотят вас видеть"),
    DO_SOMETHING("Вы не можете бездействовать. Вас же уволят!"),
    STRUCTURE_ALREADY_CREATED("Вы уже строили на этом ходу!"),
    NOT_ENOUGH_MONEY("Недостаточно денег!"),
    DID_ACTION("Вы уже собирали граждан!"),



    ;


    private String line;

    Lines(String line) {
        this.line = line;
    }

    public String get() {
        return line;
    }

    @Override
    public String toString() {
        return get();
    }
}
