package mechanics;

import mechanics.consts.Values;

public abstract class Statistics {
    protected double value;

    public double get() {
        return value;
    }

    public abstract void change(double value);

    protected Statistics() {
        this.value = Values.MAX_DEFAULT_VALUE.get();
    }
}
