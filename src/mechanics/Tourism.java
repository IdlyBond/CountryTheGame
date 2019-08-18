package mechanics;

import mechanics.consts.Values;

public class Tourism extends Statistics {

    @Override
    public void change(int value) {
        if(this.value + value <= 0) this.value = 0;
        if(this.value + value <= Values.MAX_TOURISM.get()) this.value += value;
    }

    public Tourism() {
        this.value = Values.MAX_TOURISM.get();
    }
}
