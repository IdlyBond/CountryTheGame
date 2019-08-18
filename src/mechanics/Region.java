package mechanics;

public abstract class Region extends Structure implements HasStatistics{
    private Statistic statistic = new Statistic();

    @Override
    public Statistic getStatistics() {
        return statistic;
    }

    @Override
    public void clearBudget(){
        statistic.changeBudget(-statistic.getBudgetValue());
    }



    public Region(String name) {
        super(name);
    }

    protected abstract boolean checkSize();
}
