package actions;

import mechanics.Country;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Action action = (Action) o;
        return Double.compare(action.goodHappiness, goodHappiness) == 0 &&
                Double.compare(action.goodBudget, goodBudget) == 0 &&
                Double.compare(action.goodEcology, goodEcology) == 0 &&
                Double.compare(action.goodTourism, goodTourism) == 0 &&
                Double.compare(action.badHappiness, badHappiness) == 0 &&
                Double.compare(action.badBudget, badBudget) == 0 &&
                Double.compare(action.badEcology, badEcology) == 0 &&
                Double.compare(action.badTourism, badTourism) == 0 &&
                isCompleted == action.isCompleted &&
                isRepeatable == action.isRepeatable &&
                Objects.equals(personName, action.personName) &&
                Objects.equals(storyName, action.storyName) &&
                Objects.equals(actionText, action.actionText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personName, storyName, actionText, goodHappiness, goodBudget, goodEcology, goodTourism, badHappiness, badBudget, badEcology, badTourism, isCompleted, isRepeatable);
    }
}
