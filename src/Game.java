import mechanics.consts.Lines;
import mechanics.utils.Printer;
import mechanics.consts.Values;
import mechanics.Country;


public class Game {
    private Country country;
    private Menu menu;


    public Game() {
        System.out.println(Lines.WELCOME);
        this.country = Worker.getCountry();
        this.menu = new Menu(country);
        setStartBudget();
    }

    public Game(Country country) {
        this.country = country;
        this.menu = new Menu(country);
    }

    public void mainMenu(){
        while (true) {
            System.out.println(Printer.createFrame(country.getName().toUpperCase() +" THE GAME"));
            System.out.println("1) Игра\n" + "2) Титры\n" + "0) Выйти без сохранения");
            switch (Printer.printNumber(0, 2)) {
                case 1:
                    menu.menu();
                    break;
                case 2:
                    break;
                case 0:
                    return;
            }
        }
    }

    private void setStartBudget(){
        country.getStatistics().changeBudget(Values.START_BUDGET.get());
    }


}
