package rental_company_1stIt;

/**
 * Defines an address
 *
 * @author Sebastian Misje Jonassen
 */
public class Address {
    private String streetAddress;
    private Integer postNumber;
    private String postLocation;

    /**
     * Creates a new address
     *
     * @param streetAddress The street address
     * @param postNumber    The post number
     * @param postLocation  The post location
     */
    public Address(String streetAddress, Integer postNumber, String postLocation) {
        this.streetAddress = streetAddress;
        this.postNumber = postNumber;
        this.postLocation = postLocation;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetAddress='" + streetAddress + '\'' +
                ", postNumber=" + postNumber +
                ", postLocation='" + postLocation + '\'' +
                '}';
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public Integer getPostNumber() {
        return postNumber;
    }

    public void setPostNumber(Integer postNumber) {
        this.postNumber = postNumber;
    }

    public String getPostLocation() {
        return postLocation;
    }

    public void setPostLocation(String postLocation) {
        this.postLocation = postLocation;
    }
}
