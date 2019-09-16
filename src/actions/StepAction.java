package actions;

import mechanics.Country;
import mechanics.utils.Printer;

public class StepAction extends BoolAction {

    protected int step;
    protected int failChance;
    protected String goodOutcome;
    protected String badOutcome;
    protected boolean denied;

    public StepAction(double price, double goodHappiness, double goodBudget, double goodEcology, double goodTourism,
                      double badHappiness, double badBudget, double badEcology, double badTourism,
                      boolean isRepeatable, String personName, String storyName, String actionText,
                      String questionTextPlayer, String acceptTextPlayer, String denyText, String acceptAnswer,
                      String denyAnswer, int step, int failChance, String goodOutcome, String badOutcome) {
        super(price, goodHappiness, goodBudget, goodEcology, goodTourism, badHappiness, badBudget, badEcology, badTourism,
                isRepeatable, personName, storyName, actionText, questionTextPlayer, acceptTextPlayer,
                denyText, acceptAnswer, denyAnswer);
        this.step = step;
        this.failChance = failChance;
        this.goodOutcome = goodOutcome;
        this.badOutcome = badOutcome;
        this.denied = false;
    }

    @Override
    public void start(Country country) {
        super.start(country);
        step = country.getSteps() + step;
        switch (Printer.printNumber(0, 1)) {
            case 1:
                System.out.println(acceptAnswer);
                country.getStatistics().changeBudget(-price);
                break;
            case 0:
                System.out.println(denyAnswer);
                denied = true;
                break;
        }
    }

    public void checkSteps(Country country) {
        if (!isCompleted || denied) return;
        if (step > country.getSteps()) return;
        if (step == country.getSteps()) {
            if (Math.random() * 100 <= failChance) {
                System.out.println(Printer.createFrame(badOutcome));
                changeStatistic(country, badHappiness, badBudget, badEcology, badTourism);
            } else {
                System.out.println(Printer.createFrame(goodOutcome));
                changeStatistic(country, goodHappiness, goodBudget, goodEcology, goodTourism);
            }
        }
    }

    public int getStep() {
        return step;
    }
}
