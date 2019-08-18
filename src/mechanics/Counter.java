package mechanics;

import java.util.List;

public class Counter {

    public static void countStatistics(List<Region> objects, Statistic statistic){
        if(objects.isEmpty()) return;
        int happiness = 0, ecology = 0, tourism = 0, budget = 0;

        // Считает общее
        for (Region object: objects){
            happiness += object.getStatistics().getHappinessValue();
            ecology += object.getStatistics().getEcologyValue();
            tourism += object.getStatistics().getTourismValue();
            budget += object.getStatistics().getBudgetValue();
        }

        // Находит среднее
        happiness = happiness/objects.size();
        ecology = ecology/objects.size();
        tourism = tourism/objects.size();

        // Добавляет разницу обьекту
        statistic.changeHappiness(happiness - statistic.getHappinessValue());
        statistic.changeEcology(ecology - statistic.getEcologyValue());
        statistic.changeTourism(tourism - statistic.getTourismValue());
        statistic.changeBudget(budget);
    }
}
