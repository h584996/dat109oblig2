package rental_company_1stIt;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Defines an office
 *
 * @author Sebastian Misje Jonassen
 */
public class Office {
    private Integer officeNr;
    private Address address;
    private Integer phoneNumber;
    private List<Car> cars;
    private List<Client> clients;
    //private List<Reservation> reservations;

    /**
     * Creates an new office without available cars
     *
     * @param officeNr    The number this office has
     * @param address     The address of this office
     * @param phoneNumber The phone number this office has
     */
    public Office(Integer officeNr, Address address, Integer phoneNumber) {
        this.officeNr = officeNr;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.cars = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    /**
     * Creates an new office with available cars
     *
     * @param officeNr    The number this office has
     * @param address     The address of this office
     * @param phoneNumber The phone number this office has
     * @param cars        List of cars available to be rented out
     */
    public Office(Integer officeNr, Address address, Integer phoneNumber, List<Car> cars) {
        this(officeNr, address, phoneNumber);
        this.cars = cars;
    }

    /**
     * Emtpy constructor used for testing
     */
    public Office() {

    }

    /**
     * Adds a client to the list of clients
     *
     * @param client The client
     */
    public void addClient(Client client) {
        clients.add(client);
    }

    /**
     * Attempts to rent a car to a client
     * <p>
     * Getting the date as a parameter might be necessary (Testing without for now)
     *
     * @param phoneNumber      The phone number of the client
     * @param creditCardNumber Credit card number of the client
     */
    public Boolean rentCar(String firstname, String lastname, String streetAddress, Integer postNumber, String postLocation, Integer phoneNumber, Integer creditCardNumber) {
        Car car = cars.stream().filter(Car::getAvailable).findFirst().orElse(null);

        if (car != null) {
            Client client = new Client(firstname, lastname, new Address(streetAddress, postNumber, postLocation), phoneNumber);
            addClient(client);
            car.rent();
            client.addStartRentalInfo(creditCardNumber, car.getREG_NR(), car.getMileage(), LocalDate.now());

            return true;
        }

        System.out.println("There is no cars available at the moment");
        return false;
    }

    /**
     * Attempts to return the car of the client with the given phone number
     * <p>
     * If there does not exist a client with the given phone number or the car allocated to the client is available,
     * this method does nothing
     *
     * <p>
     * Getting the date as a parameter might be necessary (Testing without for now)
     *
     * @param phoneNumber The phone number of the client
     */
    public void returnedCar(Integer phoneNumber, Integer distance) {
        Client client = clients.stream()
                .filter(p -> p.getPhoneNumber().equals(phoneNumber))
                .findFirst().orElse(null);

        if (client != null) {
            String regNum = client.getRentalInfo().getRegistrationNumber();
            Car car = cars.stream().filter(p -> p.getREG_NR().equals(regNum)).findFirst().orElse(null);

            if (car != null) {
                car.addMileage(distance);
                if (car.makeAvailable())
                    client.addEndRentalInfo(car.getMileage(), LocalDate.now());
                else
                    System.out.println("Car is not being rented");

            }
        }
    }

    /**
     * Creates the given number of random cars
     *
     * @param numOfCars Number of cars created
     */
    public void createRandomCars(Integer numOfCars) {
        String[][] car = {
                {"Ford", "F150", "GT", "Mondeo", "Ka"},
                {"Chevrolet", "Camaro", "Stingray", "Chevelle", "Impala"},
                {"Toyota", "Supra", "GT86", "Prius"},
                {"Hyundai", "i40", "IONIQ", "KONA"},
                {"Ferrari", "F50", "F40", "LaFerrari", "Fxx", "599xx"},
                {"Lamborghini", "Gallardo", "Murcielago", "Diablo", "Miura", "Sesto Elemento"},
                {"Nissan", "R35", "R34", "R33", "R32"}
        };

        Character[] groups = {'A', 'B', 'C', 'D'};

        String[] colors = {"Red", "Blue", "Yellow", "Black", "White"};

        String[] regL = {"SV", "SU", "BS", "KZ"};

        Random r = new Random();
        for (int i = 0; i < numOfCars; i++) {
            int carI = r.nextInt(car.length);
            cars.add(new Car(car[carI][0],
                    car[carI][(int) ((Math.random() * (car[carI].length - 1)) + 1)],
                    colors[r.nextInt(colors.length)],
                    groups[r.nextInt(groups.length)],
                    regL[r.nextInt(regL.length)] + (r.nextInt(90000) + 10000) + ""));
        }
    }

    @Override
    public String toString() {
        return "Office{" +
                "officeNr=" + officeNr +
                ", address=" + address +
                ", phoneNumber=" + phoneNumber +
            ",\n cars=" + cars.stream().map(Car::toString).reduce("", (a,b) -> a + "\n\t\t" + b) +
                ",\n clients=" + clients.stream().map(Client::toString).reduce("", (a,b) -> a + "\n\t\t" + b) +
                "}\n";
    }

    public Integer getOfficeNr() {
        return officeNr;
    }

    public Address getAddress() {
        return address;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Client> getClients() {
        return clients;
    }
}
