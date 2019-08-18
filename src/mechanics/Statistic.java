package mechanics;

import mechanics.consts.Icons;
import mechanics.utils.Printer;

public class Statistic {
    private Happiness happiness = new Happiness();
    private Budget budget = new Budget();
    private Ecology ecology = new Ecology();
    private Tourism tourism = new Tourism();

    public int getHappinessValue() {
        return happiness.get();
    }

    public void changeHappiness(int value){
        happiness.change(value);
    }

    public int getBudgetValue() {
        return budget.get();
    }

    public void changeBudget(int value){
        budget.change(value);
    }

    public int getEcologyValue() {
        return ecology.get();
    }

    public void changeEcology(int value){
        ecology.change(value);
    }

    public int getTourismValue() {
        return tourism.get();
    }

    public void changeTourism(int value){
        tourism.change(value);
    }

    public String toString(){
        return Printer.getStatistic(budget.get(), happiness.get(), ecology.get(), tourism.get());
    }
}
