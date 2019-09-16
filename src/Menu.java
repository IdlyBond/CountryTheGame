import mechanics.Country;
import mechanics.consts.Lines;
import mechanics.utils.Printer;

import static mechanics.utils.Printer.printNumber;

public class Menu {
    private Country country;
    private Worker worker;
    private int doingSteps;
    private boolean didAction = false;

    public Menu(Country country) {
        this.country = country;
        this.worker = new Worker(country);
    }

    public void menu() {
        while (true) {
            if(isGameOver()) return;
            System.out.println(getMenuLine());
            switch (printNumber(0, 4)) {
                case 1:
                    buildMenu();
                    break;
                case 2:
                    removeBuilding();
                    break;
                case 3:
                    if (didAction) System.out.println(Lines.DID_ACTION);
                    else if(country.getStatistics().getHappinessValue() < 50){
                        System.out.println(Lines.NOT_ENOUGH_HAPPINESS_FOR_ACTION);
                    }
                    else doAction();
                    break;
                case 4:
                    if(stepNotPossible()){
                        System.out.println(Printer.createFrame(Lines.DO_SOMETHING.get()));
                    }
                    else doStep();
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
                doingSteps = country.getSteps();
                break;
            case 2:
                worker.createStreet();
                doingSteps = country.getSteps();
                break;
            case 3:
                worker.createTown();
                doingSteps = country.getSteps();
                break;
            case 0:
        }
    }

    private boolean stepNotPossible(){
        return doingSteps < country.getSteps() - 1;
    }

    public boolean isGameOver(){
        return (country.getStatistics().getBudgetValue() < country.getBuildingCost() && stepNotPossible());
    }

    private void doStep() {
        didAction = false;
        country.countStatistics();
        worker.resetBuilt();
    }

    private void doAction(){
        didAction = true;
        doingSteps = country.getSteps();
        country.startAction();
    }

    private void removeBuilding(){
        doingSteps = country.getSteps();
        worker.removeBuilding();
    }

    private String getMenuLine() {
        return Printer.printMenuWindow(country,
                "Выберите действие: \n" +
                        "1) Построить.\n" +
                        "2) Удалить здание. \n" +
                        "3) Устроить прием граждан. \n" +
                        "4) Пойти спать. \n" +
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
