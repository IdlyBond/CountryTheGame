package actions;

import mechanics.Country;

public abstract class Action {
    // Класс события для создания квестов
    protected String personName;
    protected String storyName;
    protected String actionText;

    protected double goodHappiness;
    protected double goodBudget;
    protected double goodEcology;
    protected double goodTourism;

    protected double badHappiness;
    protected double badBudget;
    protected double badEcology;
    protected double badTourism;

    public Action(double goodHappiness, double goodBudget, double goodEcology, double goodTourism, double badHappiness,
                  double badBudget, double badEcology, double badTourism, boolean isRepeatable, String personName, String storyName, String actionText) {
        this.personName = personName;
        this.storyName = storyName;
        this.actionText = actionText;
        this.isRepeatable = isRepeatable;
        this.goodHappiness = goodHappiness;
        this.goodBudget = goodBudget;
        this.goodEcology = goodEcology;
        this.goodTourism = goodTourism;
        this.badHappiness = badHappiness;
        this.badBudget = badBudget;
        this.badEcology = badEcology;
        this.badTourism = badTourism;
    }

    protected boolean isCompleted = false;
    protected boolean isRepeatable;

    public abstract void start(Country country);

    protected void changeStatistic(Country country, double happiness, double budget, double ecology, double tourism) {
        country.getStatistics().changeStatistic(happiness, budget, ecology, tourism);
    }

    protected void toComplete() {
        isCompleted = true;
    }

    public boolean getComplete() {
        return isCompleted;
    }

    public String getStoryName() {
        return storyName;
    }
}
