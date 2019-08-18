package mechanics;

import mechanics.utils.Printer;
import mechanics.consts.Values;

import java.util.ArrayList;
import java.util.List;

public class Town extends Region {
    private List<Region> streets = new ArrayList<>();

    public Town(String name) {
        super(name);
    }

    public void addStreet(String name){
        if(checkSize()) return;
        streets.add(new Street(name));
    }

    public Street getStreet(int number){
        return (Street)streets.get(number);
    }

    public List<Region> getStreets() {
        return streets;
    }

    @Override
    public void countStatistics(){
        if(getStreets().isEmpty()) return;
        for(Region street: streets) street.countStatistics();
        Counter.countStatistics(streets, getStatistics());
        for(Region street: streets) street.clearBudget();
    }

    @Override
    protected boolean checkSize() {
        return streets.size() == Values.MAX_STREETS_IN_TOWN.get();
    }

    @Override
    public String toString() {
        return getName() + "\n" + Printer.getStreetList(this);
    }
}
