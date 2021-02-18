package rental_company;

import java.time.LocalDate;

/**
 * Defines a class for storing info about the rental
 *
 * @author Sebastian Misje Jonassen
 */
public class RentalInfo {
    private final Integer CREDIT_CARD_NUMBER;
    private final String REGISTRATION_NUMBER;
    private final Integer MILEAGE_BEFORE;
    private Integer mileageAfter;
    private final LocalDate DATE_START;
    private LocalDate dateEnd;

    /**
     * Creates a new rental info object for storing info about a rental
     *
     * @param creditCardNumber   The credit card number of the client
     * @param registrationNumber The registration number for the car
     * @param mileageBefore      Mileage before the car has been driven
     * @param dateStart          The date when the rental started
     */
    public RentalInfo(Integer creditCardNumber, String registrationNumber, Integer mileageBefore, LocalDate dateStart) {
        CREDIT_CARD_NUMBER = creditCardNumber;
        REGISTRATION_NUMBER = registrationNumber;
        MILEAGE_BEFORE = mileageBefore;
        DATE_START = dateStart;
        mileageAfter = 0;
        dateEnd = null;
    }

    /**
     * Stores the info for when the rental is ended
     *
     * @param mileageAfter Mileage when the car was returned
     * @param dateEnd      Date when the car was returned
     */
    public void endOfRentalPeriod(Integer mileageAfter, LocalDate dateEnd) {
        this.mileageAfter = mileageAfter;
        this.dateEnd = dateEnd;
    }

    public Integer getCreditCardNumber() {
        return CREDIT_CARD_NUMBER;
    }

    public String getRegistrationNumber() {
        return REGISTRATION_NUMBER;
    }

    public Integer getMileageBefore() {
        return MILEAGE_BEFORE;
    }

    public Integer getMileageAfter() {
        return mileageAfter;
    }

    public LocalDate getDateStart() {
        return DATE_START;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }
}
