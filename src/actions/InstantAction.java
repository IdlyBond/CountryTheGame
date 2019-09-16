package actions;

import mechanics.Country;
import mechanics.utils.Printer;

public class InstantAction extends BoolAction{
    // Разовый квест, с моментальным исходом
    public InstantAction(double price, double goodHappiness, double goodBudget, double goodEcology, double goodTourism,
                         double badHappiness, double badBudget, double badEcology, double badTourism, boolean isRepeatable,
                         String personName, String storyName, String actionText, String questionTextPlayer,
                         String acceptTextPlayer, String denyText, String acceptAnswer, String denyAnswer) {
        super(price, goodHappiness, goodBudget, goodEcology, goodTourism, badHappiness, badBudget, badEcology, badTourism, isRepeatable,
                personName, storyName, actionText, questionTextPlayer, acceptTextPlayer, denyText, acceptAnswer, denyAnswer);
    }

    @Override
    public void start(Country country) {
        super.start(country);
        switch (Printer.printNumber(0, 1)){
            case 1:
                System.out.println(Printer.createFrame(acceptAnswer));
                country.getStatistics().changeBudget(-price);
                changeStatistic(country, goodHappiness, goodBudget, goodEcology, goodTourism);
                break;
            case 0:
                System.out.println(Printer.createFrame(denyAnswer));
                changeStatistic(country, badHappiness, badBudget, badEcology, badTourism);
                break;
        }
    }
}
