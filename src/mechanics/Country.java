package mechanics;

import mechanics.utils.Printer;
import mechanics.consts.Values;

import java.util.ArrayList;
import java.util.List;

public class Country extends Region {
    private List<Region> towns = new ArrayList<>();
    private int buildingCost = Values.START_BUILDING_COST.get();
    private int streetCost = Values.START_STREET_COST.get();
    private int townCost = Values.START_TOWN_COST.get();
    private int steps;

    public Country(String name) {
        super(name);
    }

    public void addTown(String name){
        if(checkSize()) return;
        towns.add(new Town(name));
    }

    public Town getTown(int number){
        return (Town)towns.get(number);
    }

    public List<Region> getTowns() {
        return towns;
    }

    public int getSteps() {
        return steps;
    }

    public int getBuildingCost() {
        return buildingCost;
    }

    public int getStreetCost() {
        return streetCost;
    }

    public int getTownCost() {
        return townCost;
    }

    public void changeBuildingCost(){
        buildingCost += Values.BUILDING_COST_CHANGE.get();
    }

    public void changeStreetCost(){
        buildingCost += Values.STREET_COST_CHANGE.get();
    }

    public void changeTownCost(){
        buildingCost += Values.TOWN_COST_CHANGE.get();
    }

    @Override
    public void countStatistics(){
        if(getTowns().isEmpty()) return;
        for (Region town: towns) town.countStatistics();
        Counter.countStatistics(towns, getStatistics());
        for(Region town: towns) town.clearBudget();
        ++steps;
    }

    @Override
    protected boolean checkSize() {
        return towns.size() == Values.MAX_TOWNS.get();
    }

    @Override
    public String toString() {
        return Printer.getTownList(this);
    }
}
