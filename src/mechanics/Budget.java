package mechanics;

public class Budget extends Statistics {
    @Override
    public void change(double value) {
        this.value += value;
    }

    public Budget() {
        this.value = 0;
    }
}
