package rental_company;

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

    public Office search(){
        return offices.get(0);
    }


}
