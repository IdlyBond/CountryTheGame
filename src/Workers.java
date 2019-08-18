import mechanics.Building;
import mechanics.Country;
import mechanics.Region;
import mechanics.consts.Lines;
import mechanics.consts.Values;

import java.util.List;

public class Workers {

    public static boolean checkEmptyTowns(final List<Region> list) {
        if (list.isEmpty()) {
            System.out.println(Lines.NO_TOWN);
            return true;
        }
        return false;
    }

    public static boolean checkEmptyStreets(final List<Region> list) {
        if (list.isEmpty()) {
            System.out.println(Lines.NO_STREET);
            return true;
        }
        return false;
    }

    public static boolean checkEmptyBuildings(final List<Building> list) {
        if (list.isEmpty()) {
            System.out.println(Lines.NO_BUILDING);
            return true;
        }
        return false;
    }

    public static boolean checkIsBuilt(boolean isBuilt) {
        if (isBuilt) {
            System.out.println(Lines.STRUCTURE_ALREADY_CREATED);
            return true;
        }
        return false;
    }

    public static boolean checkSizeTowns(final List<Region> list) {
        if (list.size() >= Values.MAX_TOWNS.get()) {
            System.out.println(Lines.MAX_TOWN);
            return true;
        }
        return false;
    }

    public static boolean checkSizeStreets(final List<Region> list) {
        if (list.size() >= Values.MAX_STREETS_IN_TOWN.get()) {
            System.out.println(Lines.MAX_STREET);
            return true;
        }
        return false;
    }

    public static boolean checkSizeBuildings(final List<Building> list) {
        if (list.size() >= Values.MAX_BUILDINGS_ON_STREET.get()) {
            System.out.println(Lines.MAX_BUILDING);
            return true;
        }
        return false;
    }

    public static boolean offPriceTown(Country country) {
        if (country.getStatistics().getBudgetValue() <= country.getTownCost()) {
            System.out.println(Lines.NOT_ENOUGH_MONEY);
            return true;
        }
        return false;
    }

    public static boolean offPriceStreet(Country country) {
        if (country.getStatistics().getBudgetValue() <= country.getStreetCost()) {
            System.out.println(Lines.NOT_ENOUGH_MONEY);
            return true;
        }
        return false;
    }

    public static boolean offPriceBuilding(Country country) {
        if (country.getStatistics().getBudgetValue() <= country.getBuildingCost()) {
            System.out.println(Lines.NOT_ENOUGH_MONEY);
            return true;
        }
        return false;
    }
}
