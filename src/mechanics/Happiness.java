package mechanics;

import mechanics.consts.Values;

public class Happiness extends Statistics {
    @Override
    public void change(double value) {
        if(this.value + value <= 0) this.value = 0;
        else if(this.value + value >= Values.MAX_HAPPINESS.get()) this.value = Values.MAX_HAPPINESS.get();
        else this.value += value;
    }

    public Happiness() {
        this.value = Values.START_HAPPINESS.get();
    }
}
