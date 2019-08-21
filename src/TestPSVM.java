import mechanics.Country;

public class TestPSVM {

    public static void main(String[] args) {
        Country country = new Country("ValeriyLand Republic of Len");
        country.addTown("Радужный");
        country.addTown("NEWРадужный");
        country.getTown(0).addStreet("Love mechanics.Street");
        country.getTown(0).addStreet("Penny Lane");
        country.getTown(0).getStreet(0).addFactory("Fucktory");
        country.getTown(0).getStreet(0).addMonument("St. Marie Monument");
        Game game = new Game(country);
        game.mainMenu();
    }
}
