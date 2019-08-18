package mechanics;

public class Budget extends Statistics {
    @Override
    public void change(int value) {
        if(this.value + value <= 0) this.value = 0;
        this.value += value;
    }

    public Budget() {
        this.value = 0;
    }
}