import mechanics.buildings.Building;
import mechanics.Country;
import mechanics.Street;
import mechanics.Town;
import mechanics.consts.Lines;
import mechanics.consts.Values;
import mechanics.utils.Printer;

import java.util.Objects;


public class Searcher {

    public static int chooseTownIndex(final Country country) {
        if (Checker.checkEmptyTowns(country.getTowns())) return Values.ERROR_NUMBER.get();
        System.out.println(Lines.CHOOSE_TOWN);
        System.out.println(Printer.getTownList(country));
        return Printer.printNumber(Values.START_MENU.get(), country.getTowns().size()) -1;
    }

    public static int chooseStreetIndex(final Town town) {
        if (Checker.checkEmptyStreets(town.getStreets())) return Values.ERROR_NUMBER.get();
        System.out.println(Lines.CHOOSE_STREET);
        System.out.println(Printer.getStreetList(town));
        return Printer.printNumber(Values.START_MENU.get(), town.getStreets().size()) -1;
    }

    //для удаления
    public static int chooseBuildingIndex(final Street street) {
        if (Checker.checkEmptyBuildings(street.getBuildings())) return Values.ERROR_NUMBER.get();
        System.out.println(Lines.CHOOSE_BUILDING);
        System.out.println(Printer.getStreetPicture(street));
        return Printer.printNumber(Values.START_MENU.get(), street.getBuildings().size()) -1;
    }

    public static Town findTown(final Country country){
        int townIndex = Searcher.chooseTownIndex(country);
        if (townIndex == Values.ERROR_NUMBER.get()) return null;
        return country.getTown(townIndex);
    }

    public static Street findStreet(final Country country){
        Town town = findTown(country);
        if(Objects.isNull(town)) return null;
        int streetIndex = Searcher.chooseStreetIndex(town);
        if (streetIndex == Values.ERROR_NUMBER.get()) return null;
        return town.getStreet(streetIndex);
    }

    public static Building findBuilding(final Country country){
        Street street = findStreet(country);
        if(Objects.isNull(street)) return null;
        int buildingIndex = Searcher.chooseBuildingIndex(street);
        if (buildingIndex == Values.ERROR_NUMBER.get()) return null;
        return street.getBuilding(buildingIndex);
    }
}
