package actions;

import mechanics.Country;
import mechanics.utils.Printer;

public class InvestAction extends StepAction {
    // Инвестиционный квест

    protected String howMuchText;
    protected int lowPrice;
    protected int mediumPrice;
    protected int highPrice;
    protected boolean isLowPrice = false;
    protected boolean isMediumPrice = false;
    protected boolean isHighPrice = false;


    public InvestAction(double price, double goodHappiness, double goodBudget, double goodEcology, double goodTourism,
                        double badHappiness, double badBudget, double badEcology, double badTourism,
                        boolean isRepeatable, String personName, String storyName, String actionText,
                        String questionTextPlayer, String acceptTextPlayer, String denyText, String acceptAnswer,
                        String denyAnswer, int step, int failChance, String goodOutcome,
                        String badOutcome, int lowPrice, int mediumPrice, int highPrice, String howMuchText) {
        super(price, goodHappiness, goodBudget, goodEcology, goodTourism, badHappiness, badBudget, badEcology, badTourism,
                isRepeatable, personName, storyName, actionText, questionTextPlayer, acceptTextPlayer, denyText,
                acceptAnswer, denyAnswer, step, failChance, goodOutcome, badOutcome);
        this.howMuchText = howMuchText;
        this.lowPrice = lowPrice;
        this.mediumPrice = mediumPrice;
        this.highPrice = highPrice;
    }

    @Override
    public void start(Country country) {
        super.start(country);
        if(denied) return;
        System.out.println(Printer.createFrame(howMuchText + "\n" + "1)" + lowPrice + "  2)" + mediumPrice + "  3)" + highPrice));
        switch (Printer.printNumber(1, 3)){
            case 1:
                isLowPrice = true;
                country.getStatistics().changeBudget(-lowPrice);
                break;
            case 2:
                isMediumPrice = true;
                country.getStatistics().changeBudget(-mediumPrice);
                break;
            case 3:
                isHighPrice = true;
                country.getStatistics().changeBudget(-highPrice);
                break;
        }
    }

    @Override
    public void checkSteps(Country country) {
        if (!isCompleted || denied) return;
        if (step > country.getSteps()) return;
        if (step == country.getSteps()) {
            if (Math.random() * 100 <= failChance) {
                System.out.println(Printer.createFrame(badOutcome));
            } else if (isHighPrice){
                System.out.println(Printer.createFrame(goodOutcome));
                changeStatistic(country, goodHappiness * 3, highPrice, goodEcology * 3, goodTourism * 3);
            }else if (isMediumPrice){
                System.out.println(Printer.createFrame(goodOutcome));
                changeStatistic(country, goodHappiness * 2, mediumPrice, goodEcology * 2, goodTourism * 2);
            }else if (isLowPrice){
                System.out.println(Printer.createFrame(goodOutcome));
                changeStatistic(country, goodHappiness, lowPrice, goodEcology, goodTourism);
            }
        }
    }
}
