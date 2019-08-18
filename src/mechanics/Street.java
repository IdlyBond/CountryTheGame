package mechanics;

import mechanics.utils.Printer;
import mechanics.consts.Values;

import java.util.ArrayList;
import java.util.List;

public class Street extends Region {
    private List<Building> buildings = new ArrayList<>();

    public Street(String name) {
        super(name);
    }

    public void addHospital(String name){
        if(checkSize()) return;
        buildings.add(new Hospital(name));
    }

    public void addSchool(String name){
        if(checkSize()) return;
        buildings.add(new School(name));
    }

    public void addMonument(String name){
        if(checkSize()) return;
        buildings.add(new Monument(name));
    }

    public void addFactory(String name){
        if(checkSize()) return;
        buildings.add(new Factory(name));
    }

    public Building getBuilding(int number){
        return buildings.get(number);
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    @Override
    public void countStatistics() {
        if(getBuildings().isEmpty()) return;
        for (Building building : buildings) {
            building.work(getStatistics());
        }
    }

    @Override
    protected boolean checkSize() {
        return buildings.size() == Values.MAX_BUILDINGS_ON_STREET.get();
    }

    @Override
    public String toString() {
        return Printer.getStreetPicture(this);
    }
}
