package mechanics;

public interface HasStatistics {
    // Интерфейс для обьектом, что имеют в себе статистику
    Statistic getStatistics();
    void countStatistics();
    void clearBudget();
}
