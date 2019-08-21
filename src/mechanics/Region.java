package mechanics;

public abstract class Region extends Structure implements HasStatistics{
    protected Statistic statistic = new Statistic();

    @Override
    public Statistic getStatistics() {
        return statistic;
    }

    @Override
    public void clearBudget(){
        statistic.clearBudget();
    }



    public Region(String name) {
        super(name);
    }

    protected abstract boolean checkSize();
}
