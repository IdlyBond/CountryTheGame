package actions;


import mechanics.Country;
import mechanics.utils.Printer;

public abstract class BoolAction extends Action{
    protected double price;
    protected String questionTextPlayer;
    protected String acceptTextPlayer;
    protected String denyText;
    protected String acceptAnswer;
    protected String denyAnswer;

    public BoolAction(double price, double goodHappiness, double goodBudget, double goodEcology, double goodTourism,
                      double badHappiness, double badBudget, double badEcology, double badTourism, boolean isRepeatable,
                      String personName, String storyName, String actionText, String questionTextPlayer,
                      String acceptTextPlayer, String denyText, String acceptAnswer, String denyAnswer) {
        super(goodHappiness, goodBudget, goodEcology, goodTourism,
                badHappiness, badBudget, badEcology, badTourism, isRepeatable,
                personName, storyName, actionText);
        this.price = price;
        this.questionTextPlayer = questionTextPlayer;
        this.acceptTextPlayer = acceptTextPlayer;
        this.denyText = denyText;
        this.acceptAnswer = acceptAnswer;
        this.denyAnswer = denyAnswer;
    }

    @Override
    public void start(Country country) {
        if(!isRepeatable) toComplete();
        System.out.println("  " + personName + " «" + storyName + "»");
        if(price <= 0) System.out.println(Printer.createFrame("* " + actionText));
        else System.out.println(Printer.createFrame("* " + actionText + "($: " + price + ")"));
        System.out.println(Printer.createFrame(questionTextPlayer + "\n1) " + acceptTextPlayer + "\n0) " + denyText));
    }
}
