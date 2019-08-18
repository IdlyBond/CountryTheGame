package mechanics;

public interface HasStatistics {
    Statistic getStatistics();
    void countStatistics();
    void clearBudget();
}
