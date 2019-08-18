package mechanics;

import mechanics.consts.Values;

public abstract class Statistics {
    protected int value;

    public int get() {
        return value;
    }

    public abstract void change(int value);

    protected Statistics() {
        this.value = Values.MAX_DEFAULT_VALUE.get();
    }
}
