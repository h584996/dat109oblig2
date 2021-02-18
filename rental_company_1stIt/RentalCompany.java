package rental_company_1stIt;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines a rental company
 *
 * @author Sebastian Misje Jonassen
 */
public class RentalCompany {
    private String name;
    private Integer phoneNumber;
    private Address address;
    private Integer officeNumber;

    private List<Office> offices;

    public RentalCompany(String name, Integer phoneNumber, Address address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        officeNumber = 0;
        offices = new ArrayList<>();
    }

    public void createOffices(Integer numOfOffices) {
        for (int i = 0; i < numOfOffices; i++) {
            Office o = new Office(officeNumber,
                    new Address(
                            "Test" + (int) ((Math.random() * 10) + 1),
                            (int) (Math.random() * 1000),
                            "Test" + (int) (Math.random() * 10)),
                    (int) (Math.random() * 10_000_000)
            );

            o.createRandomCars(numOfOffices);
            offices.add(o);
            officeNumber++;
        }
    }

    public Office search() {
        return offices.get(0);
    }
    
    public List<Office> getAllOffices(){
    	
    	return offices;
    }

    @Override
    public String toString() {
        return "RentalCompany{" +
                "name='" + name + "'" +
                ", phoneNumber=" + phoneNumber +
                ", address=" + address +
                ", officeNumber=" + officeNumber +
                ",\n offices=" + offices.stream().map(Office::toString).reduce("", (a, b) -> a + "\n\t" + b) + "\n" +
                '}';
    }
}
