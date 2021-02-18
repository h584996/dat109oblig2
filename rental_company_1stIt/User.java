package rental_company_1stIt;

public class User {
    public static void main(String[] args) {
        RentalCompany rentalCompany = new RentalCompany("TestRentals",
                (int) (Math.random() * 10_000_000),
                new Address("Test street 1", 5363, "Somewhere")
        );

        rentalCompany.createOffices(2);

        Office o = rentalCompany.search();

        System.out.println(rentalCompany);

        o.rentCar("Sebastian", "Jonassen", "Somewhere 1", 5363, "Ågotnes", 47933066, 123456789);
        o.rentCar("Test", "Testen", "Somewhere 2", 4534, "Et sted", 12312332, 987654321);

        System.out.println(rentalCompany);

        o.returnedCar(47933066, 10000);

        System.out.println(rentalCompany);
    }
}
