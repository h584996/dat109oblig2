package rental_company_1stIt;

/**
 * Defines a car
 *
 * @author Sebastian Misje Jonassen
 */
public class Car {
    private final String BRAND;
    private final String MODEL;
    private final Character GROUP;
    private final String REG_NR;

    private Integer mileage;

    private String color;
    private Boolean available;

    /**
     * Creates a new car
     *
     * @param brand  The brand of the car
     * @param model  The model of the car
     * @param color  The color of the car
     * @param group  The price group the car belongs to
     * @param reg_nr The registration number
     */
    public Car(String brand, String model, String color, Character group, String reg_nr) {
        BRAND = brand;
        MODEL = model;
        this.color = color;
        GROUP = group;
        REG_NR = reg_nr;
        this.available = true;
        mileage = (int) (Math.random() * 10000);
    }

    /**
     * If the car is available set it to unavailable
     * else it does nothing
     *
     */
    public void rent() {
        if (available) {
            available = false;
        }
    }

    /**
     * Makes the car available to be rented again
     * if the car was unavailable
     *
     * @return True if the car was unavailable, false if not
     */
    public Boolean makeAvailable() {
        if (!available) {
            available = true;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds the given amount of distance to the mileage
     *
     * @param distance Amount driven
     */
    public void addMileage(Integer distance){
        mileage += distance;
    }

    @Override
    public String toString() {
        return "Car{" +
                "BRAND='" + BRAND + '\'' +
                ", MODEL='" + MODEL + '\'' +
                ", GROUP=" + GROUP +
                ", REG_NR='" + REG_NR + '\'' +
                ", mileage=" + mileage +
                ", color='" + color + '\'' +
                ", available=" + available +
                '}';
    }

    public String getBRAND() {
        return BRAND;
    }

    public String getMODEL() {
        return MODEL;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public Character getGROUP() {
        return GROUP;
    }

    public String getREG_NR() {
        return REG_NR;
    }

    public Boolean getAvailable() {
        return available;
    }
}
