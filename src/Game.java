import mechanics.consts.Lines;
import mechanics.utils.Printer;
import mechanics.consts.Values;
import mechanics.Country;


public class Game {
    private Country country;
    private Menu menu;


    public Game() {
        System.out.println(Lines.WELCOME);
        initialization();
        setStartBudget();
        this.menu = new Menu(country);
    }

    public Game(Country country) {
        this.country = country;
        this.menu = new Menu(country);
    }

    public void mainMenu() {
        while (true) {
            System.out.println(Printer.createFrame(country.getName().toUpperCase() + " THE GAME"));
            System.out.println("1) Игра\n" + "2) Титры\n" + "0) Выйти без сохранения");
            switch (Printer.printNumber(0, 2)) {
                case 1:
                    menu.menu();
                    if (menu.isGameOver()) {
                        gameOver();
                        return;
                    }
                    break;
                case 2:
                    credits();
                    break;
                case 0:
                    return;
            }
        }
    }

    private void credits() {
        for (int i = 0; i < 100; i++) {
            System.out.print(country.getName());
        }
        System.out.println();
    }

    private void gameOver() {
        System.out.println(Printer.createFrame("ВЫ ОБАНКРОТИЛИСЬ"));
        System.out.println(Printer.createFrame("Ваша статистика: \n" + Printer.getStatistic(country)));
    }

    private void initialization() {
        this.country = Worker.getCountry();
        System.out.println(Lines.NAME_FIRST_TOWN);
        this.country.addTown(Printer.printLine());
        System.out.println(Lines.NAME_FIRST_STREET);
        this.country.getTown(0).addStreet(Printer.printLine());
    }

    private void setStartBudget() {
        country.getStatistics().changeBudget(Values.START_BUDGET.get());
    }


}
