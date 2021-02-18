package rental_company_1stIt;

import javax.swing.JOptionPane;

public class User {
    public static void main(String[] args) {
    	
        RentalCompany rentalCompany = new RentalCompany("TestRentals",
                (int) (Math.random() * 10_000_000),
                new Address("Test street 1", 5363, "Somewhere"));

        
        //reate an pick out offices for the user to pick between
        
        rentalCompany.createOffices(2);
        Office o1 = rentalCompany.getAllOffices().get(0);
        Office o2 = rentalCompany.getAllOffices().get(1);
        
        
        
        int chosenOffice = Integer.parseInt(JOptionPane.showInputDialog(null,"These are the awailable office locations:\n"
        			+ o1.getAddress() + "\n"+ o2.getAddress()
        			+ "\nEnter 1 or 2 to chose one of the offices: "
        		));
        
        if(chosenOffice < 3 && chosenOffice > 0) {
        	if(chosenOffice == 1) {
        		//Rent out car form office 1
        		helpRent(o1);
        		JOptionPane.showMessageDialog(null, "Car rented from office 1");
        		
        	} else {
        		//Rent out car from office 2
        		helpRent(o2);
        		JOptionPane.showMessageDialog(null, "Car rented from office 2");
        	}
        }else {
        	JOptionPane.showInputDialog(null,"Wrong input... Try again!");
        }
        
        
        
        

//        Office o = rentalCompany.search();
//
//        System.out.println(rentalCompany);
//
//        o.rentCar("Sebastian", "Jonassen", "Somewhere 1", 5363, "Ågotnes", 47933066, 123456789);
//        o.rentCar("Test", "Testen", "Somewhere 2", 4534, "Et sted", 12312332, 987654321);
//
//        System.out.println(rentalCompany);
//
//        o.returnedCar(47933066, 10000);
//
//        System.out.println(rentalCompany);
    }
    
    public static void helpRent(Office o) {
    	
        String firstname = null;
        String lastname = null;
        String streetAddress = null;
        Integer phoneNumber = null;
       	Integer postNumber = null;
    	String postLocation = null;
    	Integer creditCardNumber = null;
    	
    	String s = "Enter credentials";
    	
    	JOptionPane.showMessageDialog(null, s);
    	
    	firstname = JOptionPane.showInputDialog("Type in Firstname");
    		
    	lastname= JOptionPane.showInputDialog("Type in Lasttname");
    		
    	streetAddress = JOptionPane.showInputDialog("Type in StreetAddress: ");
    		
    	postNumber = Integer.parseInt(JOptionPane.showInputDialog("Type in Post number: "));
    		
    	postLocation = JOptionPane.showInputDialog("Type in postLocation: ");
    		
    	phoneNumber = Integer.parseInt(JOptionPane.showInputDialog("Type in Phone number: "));
    		
    	creditCardNumber = Integer.parseInt(JOptionPane.showInputDialog("Type in Creditcard number: "));
    		
    		
    	o.rentCar(firstname, lastname, streetAddress, postNumber, postLocation, phoneNumber, creditCardNumber);

    }
  
}
