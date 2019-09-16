package mechanics;

import mechanics.utils.Printer;

public class Statistic {
    private Happiness happiness = new Happiness();
    private Budget budget = new Budget();
    private Ecology ecology = new Ecology();
    private Tourism tourism = new Tourism();
    // Класс обертка для всей статистики

    public double getHappinessValue() {
        return happiness.get();
    }

    public void changeHappiness(double value){
        happiness.change(value);
    }

    public double getBudgetValue() {
        return budget.get();
    }

    public void changeBudget(double value){
        budget.change(value);
    }

    public void clearBudget(){
        budget.value = 0;
    }

    public double getEcologyValue() {
        return ecology.get();
    }

    public void changeEcology(double value){
        ecology.change(value);
    }

    public double getTourismValue() {
        return tourism.get();
    }

    public void changeTourism(double value){
        tourism.change(value);
    }

    public void changeStatistic(double happiness, double budget, double ecology, double tourism){
        this.happiness.change(happiness);
        this.budget.change(budget);
        this.ecology.change(ecology);
        this.tourism.change(tourism);
    }

    public String toString(){
        return Printer.getStatistic(budget.get(), happiness.get(), ecology.get(), tourism.get());
    }
}
