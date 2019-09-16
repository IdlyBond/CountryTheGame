import mechanics.Country;
import mechanics.Street;
import mechanics.Town;
import mechanics.buildings.buildingConsts.BuildingTypes;
import mechanics.consts.Values;
import mechanics.consts.Lines;
import mechanics.utils.Printer;

import java.util.Objects;

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

    public void createTown() {
        if (Checker.checkIsBuilt(isBuilt)) return;
        if (Checker.checkMaxSizeTowns(country.getTowns())) return;
        System.out.println(Lines.ENTER_TOWN_NAME);
        String name = Printer.printLine();
        if (country.getTowns().isEmpty()) {
            country.addTown(name);
            isBuilt = true;
        } else {
            if (Checker.offPriceTown(country)) return;
            country.addTown(name);
            country.getStatistics().changeBudget(-country.getTownCost());
            country.changeTownCost();
            isBuilt = true;
        }
    }

    public void createStreet() {
        if (Checker.checkIsBuilt(isBuilt)) return;
        Town town = Searcher.findTown(country);
        if (Objects.isNull(town)) return;
        if (Checker.checkMaxSizeStreets(town.getStreets())) return;
        System.out.println(Lines.ENTER_STREET_NAME);
        String name = Printer.printLine();
        if (town.getStreets().isEmpty()) {
            town.addStreet(name);
            isBuilt = true;
        } else {
            if (Checker.offPriceStreet(country)) return;
            town.addStreet(name);
            country.getStatistics().changeBudget(-country.getStreetCost());
            country.changeStreetCost();
            isBuilt = true;
        }
    }

    public void createBuilding() {
        if (Checker.checkIsBuilt(isBuilt)) return;
        Street street = Searcher.findStreet(country);
        if (Objects.isNull(street)) return;
        if (Checker.checkMaxSizeBuildings(street.getBuildings())) return;
        if (Checker.offPriceBuilding(country)) return;
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

    public void removeBuilding() {
        Street street = Searcher.findStreet(country);
        if (Objects.isNull(street)) return;
        if (Checker.checkEmptyBuildings(street.getBuildings())) return;
        street.getBuildings().remove(Searcher.chooseBuildingIndex(street));
        isBuilt = true;
    }

    public void resetBuilt() {
        isBuilt = false;
    }
}
