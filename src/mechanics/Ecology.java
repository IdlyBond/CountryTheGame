package mechanics;

import mechanics.consts.Values;

public class Ecology extends Statistics {
    @Override
    public void change(double value) {
        if(this.value + value <= 0) this.value = 0;
        if(this.value + value <= Values.MAX_ECOLOGY.get()) this.value += value;
    }

    public Ecology() {
        this.value = Values.MAX_ECOLOGY.get();
    }
}
