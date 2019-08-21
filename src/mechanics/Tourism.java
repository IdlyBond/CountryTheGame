package mechanics;

import mechanics.consts.Values;

public class Tourism extends Statistics {

    @Override
    public void change(double value) {
        if(this.value + value <= 0) this.value = 0;
        else if(this.value + value >= Values.MAX_TOURISM.get()) this.value = Values.MAX_TOURISM.get();
        else this.value += value;
    }

    public Tourism() {
        this.value = Values.START_TOURISM.get();
    }
}
