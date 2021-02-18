package rental_company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    private List<Reservation> reservations;

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
     * @param firstname   The firstname of the client
     * @param lastname    The lastname of the client
     * @param address     The address of the client
     * @param phoneNumber The phone number of the client
     */
    public void addClient(String firstname, String lastname, Address address, Integer phoneNumber) {
        clients.add(new Client(firstname, lastname, address, phoneNumber));
    }

    /**
     * Attempts to rent a car with the given registration number to client with the given phone number
     * <p>
     * If there does not exist a client with the given phone number
     * or if there does not exist a car with the given registration number
     * this method will do nothing
     *
     * <p>
     * Getting the date as a parameter might be necessary (Testing without for now)
     *
     * @param phoneNumber        The phone number of the client
     * @param creditCardNumber   Credit card number of the client
     * @param registrationNumber Registration number of the car that is being rented
     */
    public void rentCar(Integer phoneNumber, Integer creditCardNumber, String registrationNumber) {
        Client client = clients.stream()
                .filter(p -> p.getPhoneNumber().equals(phoneNumber))
                .findFirst().orElse(null);

        if (client != null) {
            Car car = cars.stream().filter(p -> p.getREG_NR().equals(registrationNumber)).findFirst().orElse(null);

            if (car != null) {
                if (car.rent())
                    client.addStartRentalInfo(creditCardNumber, registrationNumber, car.getMileage(), LocalDate.now());
                else
                    System.out.println("Car is already rented");

            } else {
                System.out.println("There is no car with the registration number: " + registrationNumber);
            }
        } else {
            System.out.println("There is no client with the phone number: " + phoneNumber);
        }
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
    public void returnedCar(Integer phoneNumber) {
        Client client = clients.stream()
                .filter(p -> p.getPhoneNumber().equals(phoneNumber))
                .findFirst().orElse(null);

        if (client != null) {
            String regNum = client.getRentalInfo().getRegistrationNumber();
            Car car = cars.stream().filter(p -> p.getREG_NR().equals(regNum)).findFirst().orElse(null);

            if (car != null) {

                if (car.makeAvailable())
                    client.addEndRentalInfo(car.getMileage(), LocalDate.now());
                else
                    System.out.println("Car is not being rented");

            }
        }
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
