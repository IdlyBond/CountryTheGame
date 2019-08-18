import mechanics.Country;
import mechanics.Street;
import mechanics.consts.BuildingTypes;
import mechanics.consts.Values;
import mechanics.consts.Lines;
import mechanics.utils.Printer;

public class Worker {

    private Country country;
    private boolean isBuilt = false;

    public Worker(Country country) {
        this.country = country;
    }

    //Отдает страну для начала игры
    public static Country getCountry() {
        System.out.println(Lines.ENTER_COUNTRY_NAME);
        return new Country(Printer.printLine());
    }

    private int chooseTownIndex() {
        if (Workers.checkEmptyTowns(country.getTowns())) return Values.ERROR_NUMBER.get();
        System.out.println(Lines.CHOOSE_TOWN);
        System.out.println(Printer.getTownList(country));
        return Printer.printNumber(Values.START_MENU.get(), country.getTowns().size()) - 1;
    }

    private int chooseStreetIndex(int townIndex) {
        if (Workers.checkEmptyStreets(country.getTown(townIndex).getStreets())) return Values.ERROR_NUMBER.get();
        System.out.println(Lines.CHOOSE_STREET);
        System.out.println(Printer.getStreetList(country.getTown(townIndex)));
        return Printer.printNumber(Values.START_MENU.get(), country.getTown(townIndex).getStreets().size()) - 1;
    }

    //для удаления
    private int chooseBuildingIndex() {
        int townIndex = chooseTownIndex();
        if (townIndex == Values.ERROR_NUMBER.get()) return Values.ERROR_NUMBER.get();
        int streetIndex = chooseStreetIndex(townIndex);
        if (streetIndex == Values.ERROR_NUMBER.get()) return Values.ERROR_NUMBER.get();
        if (Workers.checkEmptyBuildings(country.getTown(townIndex).getStreet(streetIndex).getBuildings()))
            return Values.ERROR_NUMBER.get();
        System.out.println(Lines.CHOOSE_BUILDING);
        System.out.println(Printer.getStreetPicture(country.getTown(townIndex).getStreet(streetIndex)));
        return Printer.printNumber(Values.START_MENU.get(), country.getTown(townIndex).getStreet(streetIndex).getBuildings().size() - 1);
    }

    public void createTown() {
        if (Workers.checkIsBuilt(isBuilt)) return;
        if (Workers.checkSizeTowns(country.getTowns())) return;
        System.out.println(Lines.ENTER_TOWN_NAME);
        String name = Printer.printLine();
        if (country.getTowns().isEmpty()) {
            country.addTown(name);
            isBuilt = true;
        } else {
            if (Workers.offPriceTown(country)) return;
            country.addTown(name);
            country.getStatistics().changeBudget(-country.getTownCost());
            country.changeTownCost();
            isBuilt = true;
        }
    }

    public void createStreet() {
        if (Workers.checkIsBuilt(isBuilt)) return;
        int townIndex = chooseTownIndex();
        if (townIndex == Values.ERROR_NUMBER.get()) return;
        if (Workers.checkSizeStreets(country.getTown(townIndex).getStreets())) return;
        System.out.println(Lines.ENTER_STREET_NAME);
        String name = Printer.printLine();
        if (country.getTown(townIndex).getStreets().isEmpty()) {
            country.getTown(townIndex).addStreet(name);
            isBuilt = true;
        } else {
            if (Workers.offPriceStreet(country)) return;
            country.getTown(townIndex).addStreet(name);
            country.getStatistics().changeBudget(-country.getStreetCost());
            country.changeStreetCost();
            isBuilt = true;
        }
    }

    public void createBuilding() {
        if (Workers.checkIsBuilt(isBuilt)) return;
        int townIndex = chooseTownIndex();
        if (townIndex == Values.ERROR_NUMBER.get()) return;
        int streetIndex = chooseStreetIndex(townIndex);
        if (streetIndex == Values.ERROR_NUMBER.get()) return;
        Street street = country.getTown(townIndex).getStreet(streetIndex);
        if (Workers.checkSizeBuildings(street.getBuildings())) return;
        if (Workers.offPriceBuilding(country)) return;
        System.out.println(Lines.CHOOSE_BUILDING_TYPE);
        System.out.println(Printer.getBuildingTypesList());
        switch (Printer.printNumber(Values.START_MENU.get(), BuildingTypes.values().length)) {
            case 1:
                System.out.println(Lines.ENTER_HOSPITAL_NAME);
                street.addHospital(Printer.printLine());
                break;
            case 2:
                System.out.println(Lines.ENTER_SCHOOL_NAME);
                street.addSchool(Printer.printLine());
                break;
            case 3:
                System.out.println(Lines.ENTER_FACTORY_NAME);
                street.addFactory(Printer.printLine());
                break;
            case 4:
                System.out.println(Lines.ENTER_MONUMENT_NAME);
                street.addMonument(Printer.printLine());
                break;
        }
        country.getStatistics().changeBudget(-country.getBuildingCost());
        country.changeBuildingCost();
        isBuilt = true;
    }

    public void resetBuilt() {
        isBuilt = false;
    }
}
