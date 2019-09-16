import mechanics.Country;

public class TestPSVM {

    public static void main(String[] args) {
        Country country = new Country("Land Republic");
        country.addTown("Town1");
        country.addTown("Town2");
        country.getTown(0).addStreet("Love Street");
        country.getTown(0).addStreet("Penny Lane");
        country.getTown(0).getStreet(0).addFactory("Factory");
        country.getTown(0).getStreet(0).addMonument("St. Marie Monument");
        country.countStatistics();
        Game game = new Game(country);
        game.mainMenu();
        country.countStatistics();
        country.countStatistics();

    }
}
