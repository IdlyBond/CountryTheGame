import mechanics.Country;
import mechanics.utils.Printer;

import static mechanics.utils.Printer.printNumber;

public class Menu {
    private Country country;

    private Worker worker;

    public Menu(Country country) {
        this.country = country;
        this.worker = new Worker(country);
    }

    public void menu() {
        while (true) {
            System.out.println(getMenuLine());
            switch (printNumber(0, 2)) {
                case 1:
                    buildMenu();
                    break;
                case 2:
                    doStep();
                    break;
                case 0:
                    return;
            }
        }
    }

    private void buildMenu() {
        System.out.println(getSearchMenuLine());
        switch (printNumber(0, 3)) {
            case 1:
                worker.createBuilding();
                break;
            case 2:
                worker.createStreet();
                break;
            case 3:
                worker.createTown();
                break;
            case 0:
        }
    }

    private void doStep() {
        country.countStatistics();
        worker.resetBuilt();
    }

    private String getMenuLine() {
        return Printer.printMenuWindow(country,
                "Выберите действие: \n" +
                        "1) Построить сооружение.\n" +
                        "2) Пойти спать. \n" +
                        "0) Назад. ");
    }

    private String getSearchMenuLine() {
        return Printer.printMenuWindow(country,
                "Выберите действие: \n" +
                        "1) Построить здание. (" + country.getBuildingCost() + ")\n" +
                        "2) Построить улицу. (" + country.getStreetCost() + ")\n" +
                        "3) Построить город. (" + country.getTownCost() + ")\n" +
                        "0) Назад. ");
    }
}