package mechanics.utils;

import mechanics.Country;
import mechanics.Street;
import mechanics.Town;
import mechanics.buildings.buildingConsts.BuildingPerks;
import mechanics.buildings.buildingConsts.BuildingTypes;
import mechanics.consts.Icons;
import mechanics.consts.Values;

import java.util.Objects;
import java.util.Scanner;

public class Printer {
    private final static char upBorder = '_';
    private final static char sideBorder = '|';
    private final static char downBorder = '-';
    private final static String spaces = "  ";
    public static String printMenuWindow(Country country, String lines){
        if(Objects.isNull(lines) || Objects.isNull(country)) return null;
        return "\n День " + country.getSteps() + "\n " + createFrame(getMenuText(country, lines));
    }

    private static String getMenuText(Country country, String lines){
        return lines +
                getBlankLines(Values.PRINT_MENU_HEIGHT_ADD.get()) +
                Printer.getStatistic(country);
    }

    private static String getBlankLines(int times){
        if(times < 0) return null;
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < times; i++) {
            out.append("\n");
        }
        return out.toString();
    }

    public static String createFrame(String picture){
        return createUpBorder() +
                createMiddleWithBorders(makeLineArray(fitLineToMenu(picture))) +
                createDownBorder();
    }

    private static String getSymbols(int addLength, String symbol){
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < addLength; i++) out.append(symbol);
        return out.toString();
    }

    private static String createUpBorder(){
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < Values.PRINT_MENU_LENGTH.get(); i++) out.append(upBorder);
        return out.toString();
    }

    private static String createDownBorder(){
        StringBuilder out = new StringBuilder("\n");
        for (int i = 0; i < Values.PRINT_MENU_LENGTH.get(); i++) out.append(downBorder);
        return out.toString();
    }

    private static String createMiddleWithBorders(String[] lines){
        StringBuilder out = new StringBuilder();
        for(String line:lines) {
            out.append("\n").append(sideBorder).append(spaces)
                    .append(line).append(getSymbols(Values.PRINT_MENU_LENGTH.get() - (sideBorder + spaces + line).length(), " "))
                    .append(sideBorder);
        }
        return out.toString();
    }

    public static String getTownList(Country country){
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < country.getTowns().size(); i++) {
            out.append((i + 1)).append(") ").append(country.getTown(i).getName())
                    .append(" (").append(country.getTown(i).getStreets().size()).append(")\n");
        }
        return createFrame(out.toString());
    }

/*    public static String getStreetList(Town town){
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < town.getStreets().size(); i++) {
            out.append(i + 1).append(") ").append(town.getStreet(i).getName())
                    .append(" (").append(town.getStreet(i).getBuildings().size()).append(")").append("\n");
        }
        return out.toString();
    }*/

    public static String getStreetList(Town town){
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < town.getStreets().size(); i++){
            out.append(getStreetPicture(town.getStreet(i), i)).append("\n");
        }
        return out.toString();
    }

    public static String getStreetPicture(Street street){
        if(street.getBuildings().isEmpty()) return getRoadPicture(street, Values.STANDARD_ROAD_LENGTH.get());
        StringBuilder out = new StringBuilder();
        out.append(getBuildings(street));
        out.append(getRoadPicture(street, makeLineArray(out.toString())[0].length()));
        return out.toString();
    }

    public static String getStreetPicture(Street street, int index){
        if(street.getBuildings().isEmpty()) return getRoadPicture(street, Values.STANDARD_ROAD_LENGTH.get(), index + 1);
        StringBuilder out = new StringBuilder();
        out.append(getBuildings(street));
        out.append(getRoadPicture(street, makeLineArray(out.toString())[0].length(),index+ 1));
        return out.toString();
    }


    private static String getBuildings(Street street){
        if(street.getBuildings().isEmpty()) return "\n\n\n";
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < street.getBuildings().size(); i++) {
            String name = street.getBuilding(i).getName();
            String picture = getSymbols(name.length() + 2, "_") + "  \n" +
                    "#" + getSymbols((int)Math.floor(((double)name.length())/ 2), " ") + (i + 1) +
                    getSymbols((int)Math.ceil(((double)name.length())/ 2) - 1, " ")+ "#  \n" +
                    "#" + name + "#  ";
            String buildingImage = alignPicture(out.toString(), picture);
            if(out.length() != 0) out.delete(0, out.length());
            out.append(buildingImage);
        }
        return out.toString();
    }

    private static String getRoadPicture(Street street, int length){
        StringBuilder out = new StringBuilder();
        out.append(getSymbols(length, "_")).append("\n");
        out.append(getSymbols(length, "-")).append("\n");
        out.append("___").append(street.getName()).append(getSymbols(length - street.getName().length() - 2, "_")).append("\n");
        return out.toString();
    }

    private static String getRoadPicture(Street street, int length, int index){
        StringBuilder out = new StringBuilder();
        out.append(getSymbols(length, "_")).append("\n");
        out.append(getSymbols(length, "-")).append("\n");
        out.append("___").append(street.getName()).append("(").append(index).append(")").append(getSymbols(length - street.getName().length() - 6, "_")).append("\n");
        return out.toString();
    }



    private static String alignPicture(String first, String second){
        String[] firsts = makeLineArray(first);
        String[] seconds = makeLineArray(second);
        StringBuilder out = new StringBuilder();
        int length = firsts.length > seconds.length ? firsts.length: seconds.length;
        for (int i = 0; i < length; i++) {
            if (i >= seconds.length) out.append(firsts[i]).append("\n");
            else if (i >= firsts.length) out.append(seconds[i]).append("\n");
            else out.append(firsts[i]).append(seconds[i]).append("\n");
        }
        return out.toString();
    }

    private static String[] makeLineArray(String line){
        return line.split("\\r?\\n");
    }

    private static String fitLineToMenu(String line){
        StringBuilder out = new StringBuilder();
        while (line.length() > Values.PRINT_MENU_LENGTH.get() - 5){
            if(line.contains("\n") && line.substring(0, line.indexOf("\n")).length() > Values.PRINT_MENU_LENGTH.get() - 5){
                out.append(line, 0, Values.PRINT_MENU_LENGTH.get() - 4).append("\n");
                line = line.replace(line.substring(0, Values.PRINT_MENU_LENGTH.get() - 4), "");
            }
            else if(line.contains("\n")){
                out.append(line, 0, line.indexOf("\n") + 1);
                line = line.replace(line.substring(0, line.indexOf("\n") + 1), "");
            }
            else {
                out.append(line, 0, Values.PRINT_MENU_LENGTH.get() - 4).append("\n");
                line = line.replace(line.substring(0, Values.PRINT_MENU_LENGTH.get() - 4), "");
            }
        }
        out.append(line);
        return out.toString();
    }

    public static String printLine(){
        return new Scanner(System.in).nextLine();
    }

    public static int printNumber(int from, int to){
        while(true) {
            Scanner scr = new Scanner(System.in);
            Integer number = null;
            if (scr.hasNextInt()) number = scr.nextInt();
            if (Objects.nonNull(number) && number >= from && number <= to) return number;
            System.out.println("* Попробуйте еще раз.");
        }
    }

    public static int printNumber(){
        while(true) {
            Scanner scr = new Scanner(System.in);
            if (scr.hasNextInt()) return scr.nextInt();
            System.out.println("* Попробуйте еще раз.");

        }
    }

    public static String getBuildingTypesList(){
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < BuildingTypes.values().length; i++) {
            out.append(i + 1).append(") ").append(BuildingTypes.values()[i].get())
                    .append(" (").append(getStatistic(BuildingTypes.values()[i])).append(")").append("\n");
        }
        return out.toString();
    }


    public static String getStatistic(double budget, double happiness, double ecology, double tourism){
        return " " + Icons.BUDGET_ICON.get() + ":" + Math.round(budget)  +
                " " + Icons.HAPPINESS_ICON.get() + ":" + Math.round(happiness) +
                " " + Icons.ECOLOGY_ICON.get() + ":" + Math.round(ecology) +
                " " + Icons.TOURISM_ICON.get() + ":" + Math.round(tourism);
    }

    public static String getStatistic(Country country){
        return getStatistic(country.getStatistics().getBudgetValue(),
                country.getStatistics().getHappinessValue(),
                country.getStatistics().getEcologyValue(),
                country.getStatistics().getTourismValue());
    }

    public static String getStatistic(BuildingTypes type){
        double budget, happiness, ecology, tourism;
        if(type == BuildingTypes.HOSPITAL){
            happiness = BuildingPerks.HOSPITAL_HAPPINESS.get();
            budget = BuildingPerks.HOSPITAL_BUDGET.get();
            ecology = BuildingPerks.HOSPITAL_ECOLOGY.get();
            tourism = BuildingPerks.HOSPITAL_TOURISM.get();
        }
        else if(type == BuildingTypes.SCHOOL) {
            happiness = BuildingPerks.HOSPITAL_HAPPINESS.get();
            budget = BuildingPerks.SCHOOL_BUDGET.get();
            ecology = BuildingPerks.SCHOOL_ECOLOGY.get();
            tourism = BuildingPerks.SCHOOL_TOURISM.get();
        }
        else if(type == BuildingTypes.FACTORY) {
            happiness = BuildingPerks.FACTORY_HAPPINESS.get();
            budget = BuildingPerks.FACTORY_BUDGET.get();
            ecology = BuildingPerks.FACTORY_ECOLOGY.get();
            tourism = BuildingPerks.FACTORY_TOURISM.get();
        }
        else if(type == BuildingTypes.MONUMENT) {
            happiness = BuildingPerks.MONUMENT_HAPPINESS.get();
            budget = BuildingPerks.MONUMENT_BUDGET.get();
            ecology = BuildingPerks.MONUMENT_ECOLOGY.get();
            tourism = BuildingPerks.MONUMENT_TOURISM.get();
        }
        else{
            happiness = budget = ecology = tourism = 0;
        }
        return getStatistic(budget, happiness, ecology, tourism);
    }

}
