import mechanics.Country;
import mechanics.utils.Printer;

public class TestPSVM {

    public static void main(String[] args) {
        Country country = new Country("ValeriyLand Republic of Len");
        country.addTown("Радужный");
        country.addTown("NEWРадужный");
        country.getTown(0).addStreet("Love mechanics.Street");
        country.getTown(0).addStreet("Penny Lane");
        country.getTown(0).getStreet(0).addHospital("St. Marie mechanics.Hospital");
        country.getTown(0).getStreet(0).addFactory("Fucktory");
        country.getTown(0).getStreet(0).addFactory("Fucktory2");
        Game game = new Game(country);
        game.mainMenu();
    }
}