package mechanics;

public abstract class Structure {
    // Базовый наследуемый класс для любой структкры
    protected String name;

    public Structure(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
