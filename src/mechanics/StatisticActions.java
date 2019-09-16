package mechanics;


import mechanics.utils.Printer;
import mechanics.utils.UtilsExp;

public class StatisticActions {

    public static void doActions(Country country){
        for (Region town: country.getTowns()){
            for (Region street: ((Town)town).getStreets()){
                doHappinessAction(street);
                doEcologyAction(street);
                doTourismAction(street);
            }
        }
    }

    private static void doHappinessAction(Region region){
        if(region.statistic.getHappinessValue() < 20 && UtilsExp.randomPercent() < 20) {
            System.out.println(Printer.createFrame(region.getName() + " был заброшен из за недовольства"));
            if (region instanceof Street) ((Street)region).getBuildings().removeAll(((Street)region).getBuildings());
            if (region instanceof Town) ((Town)region).getStreets().removeAll(((Town)region).getStreets());
        }
        else if (region.statistic.getHappinessValue() < 40 && UtilsExp.randomPercent() < 50){
            System.out.println(Printer.createFrame("В " + region.getName() + " прошли массовые протесты из за недовольства"));
            region.statistic.changeBudget(-200);
        }
        else if(region.statistic.getHappinessValue() < 90 && UtilsExp.randomPercent() < 20){
            System.out.println(Printer.createFrame("В " + region.getName() + " прошел праздник радости"));
            region.statistic.changeHappiness(20);
        }
    }

    private static void doEcologyAction(Region region){
        if(region.statistic.getEcologyValue() < 20 && UtilsExp.randomPercent() < 20) {
            System.out.println(Printer.createFrame(region.getName() + " был заброшен из за массового вымирания"));
            if (region instanceof Street) ((Street)region).getBuildings().removeAll(((Street)region).getBuildings());
            if (region instanceof Town) ((Town)region).getStreets().removeAll(((Town)region).getStreets());
        }
        else if (region.statistic.getEcologyValue() < 40 && UtilsExp.randomPercent() < 50){
            System.out.println(Printer.createFrame("В " + region.getName() + " прошли массовые протесты из загрязнения"));
            region.statistic.changeBudget(-200);
        }
        else if(region.statistic.getEcologyValue() < 90 && UtilsExp.randomPercent() < 20){
            System.out.println(Printer.createFrame("В " + region.getName() + " прошел праздник любви к миру"));
            region.statistic.changeHappiness(20);
        }
    }

    private static void doTourismAction(Region region){
        if(region.statistic.getTourismValue() < 25 && UtilsExp.randomPercent() <= 2){
            System.out.println(Printer.createFrame("В " + region.getName() + " урезали финансирование из за отсутствия туризма"));
            region.statistic.clearBudget();
        }
    }
}
