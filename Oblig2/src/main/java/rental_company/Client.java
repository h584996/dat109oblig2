package rental_company;

import java.time.LocalDate;

/**
 * Defines a client
 *
 * @author Sebastian Misje Jonassen
 */
public class Client {
    private String firstname;
    private String lastname;
    private Address address;
    private Integer phoneNumber;

    private RentalInfo rentalInfo;

    /**
     * Creates a new client
     *
     * @param firstname   The firstname of the client
     * @param lastname    The lastname of the client
     * @param address     The address of the client
     * @param phoneNumber The phone number of the client
     */
    public Client(String firstname, String lastname, Address address, Integer phoneNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        rentalInfo = null;
    }

    /**
     * Adds the rental info for when the rental is started
     *
     * @param creditCardNumber   Credit card number of the client
     * @param registrationNumber Registration number of the car
     * @param mileageBefore      Mileage on the car when it was rented out
     * @param dateStart          The date when the rental started
     */
    public void addStartRentalInfo(Integer creditCardNumber, String registrationNumber, Integer mileageBefore, LocalDate dateStart) {
        rentalInfo = new RentalInfo(creditCardNumber, registrationNumber, mileageBefore, dateStart);
    }

    /**
     * Adds the rental info for when the rental is ended
     *
     * @param mileageEnd The mileage on the car when it was returned
     * @param dateEnd    The date when the rental ended
     */
    public void addEndRentalInfo(Integer mileageEnd, LocalDate dateEnd) {
        rentalInfo.endOfRentalPeriod(mileageEnd, dateEnd);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public RentalInfo getRentalInfo() {
        return rentalInfo;
    }
}
