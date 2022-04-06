package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 * Purpose: Class for Address Book .
 *
 * @author Aniket Kumbhar
 * @version 1.0
 * @since 05-03-2022
 *
 */

public class AddressBookSystemDetails {
    static AddressBookSystemDetails details = new AddressBookSystemDetails();
    ArrayList<Contact> personDetails = new ArrayList<Contact>();
    Contact contacts = new Contact(null, null, null, null, null, null, 0, 0);
    static HashMap<String, ArrayList<Contact>> hashmap = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    /*
    This method is used to add details to address book
    * */
    public void addDetails() {

        System.out.println("Enter the first name");
        String firstName = sc.next();
        System.out.println("Enter the last name");
        String lastName = sc.next();
        System.out.println("Enter the address");
        String address = sc.next();
        System.out.println("Enter the city");
        String city = sc.next();
        System.out.println("Enter the state");
        String state = sc.next();
        System.out.println("Enter the email");
        String emailId = sc.next();
        System.out.println("Enter the zip code");
        int zip = sc.nextInt();
        System.out.println("Enter the phone number");
        long phoneNumber = sc.nextLong();

        contacts = new Contact(firstName, lastName, address, city, state, emailId, zip, phoneNumber);
        personDetails.add(contacts);
        sc.close();
    }

    /*
    This method is used to edit the details in address book
     */
    public void editDetails() {
        System.out.println("Confirm your first name to edit details: ");
        String confirmName = sc.next();

        for (int i = 0; i < personDetails.size(); i++) {
            if (personDetails.get(i).getFirstName().equals(confirmName)) {
                System.out.println("Select mentioned detail to edit: ");
                System.out.println("\n1.First Name\n2.Last Name\n3.Address\n4.city\n5.State\n6.Zip\n7.Mobile number\n8.Email");
                int edit = sc.nextInt();

                switch (edit) {
                    case 1:
                        System.out.println("Enter first name: ");
                        personDetails.get(i).setFirstName(sc.next());
                        break;
                    case 2:
                        System.out.println("Enter Last name: ");
                        personDetails.get(i).setLastName(sc.next());
                        break;
                    case 3:
                        System.out.println("Enter Address: ");
                        personDetails.get(i).setAddress(sc.next());
                        break;
                    case 4:
                        System.out.println("Enter City: ");
                        personDetails.get(i).setCity(sc.next());
                        break;
                    case 5:
                        System.out.println("Enter State: ");
                        personDetails.get(i).setState(sc.next());
                        break;
                    case 6:
                        System.out.println("Enter Zip: ");
                        personDetails.get(i).setZip(sc.nextInt());
                        break;
                    case 7:
                        System.out.println("Enter Mobile number: ");
                        personDetails.get(i).setPhoneNumber(sc.nextLong());
                        break;
                    case 8:
                        System.out.println("Enter new E-mail: ");
                        personDetails.get(i).setEmailId(sc.next());
                        break;
                }
                System.out.println("Edited list is: ");
                System.out.println(personDetails);
            } else
                System.out.println("Enter a valid First name");
        }
    }
    /*
    This method is used to delete the contact details
     */
    public void deleteDetails() {
        System.out.println("Confirm first name to delete contact details");
        String confirmName = sc.next();
        for (int i = 0; i < personDetails.size(); i++) {

            if (personDetails.get(i).getFirstName().equals(confirmName)) {
                personDetails.remove(i);
            } else {
                System.out.println("Enter valid first name");
            }
        }
    }
    /*
    This Method is used to create, edit And Manage Multiple AddressBook
     */
    public void createAddressBook() {
        int option = 1;
        while (option == 1) {
            System.out.println("Choose an Option According To Your Preference: ");
            System.out.println("1.Create new address book.\n2.Edit existing address book.\n3.Display all address books.\n4.exit");

            switch (sc.nextInt()) {
                //Switch Case For Creating New Address Book
                case 1:
                    System.out.println("Enter the name of address book: ");
                    String address_name = sc.next();

                    // condition to check for uniqueness of address book.
                    if (hashmap.containsKey(address_name)) {
                        System.out.println("Address book name exits, enter different name");
                        break;
                    }

                    ArrayList<Contact> newAddressBook = new ArrayList<>();
                    personDetails = newAddressBook;
                    int choice = 1;
                    while (choice == 1) {
                        System.out.println("Choose an Option According To Your Preference: ");
                        System.out.println("1.Add details.\n2.Edit details.\n3.Delete contact. \n4.Display Contact\n5.Exit");

                        switch (sc.nextInt()) {
                            case 1:
                                details.addDetails();
                                break;
                            case 2:
                                details.editDetails();
                                break;
                            case 3:
                                details.deleteDetails();
                                break;
                            case 4:
                                details.display();
                                break;
                            default:
                                System.out.println("Exited From Address Book");
                                break;
                        }
                        hashmap.put(address_name, personDetails);
                        System.out.println(hashmap);
                        choice = 0;
                    }
                    break;

                //Switch Case For Editing Existing Address Book
                case 2:
                    System.out.println("Enter the name of address book: ");
                    String oldAddressBook = sc.next();

                    // condition to check whether address book exists or no.
                    if (hashmap.containsKey(oldAddressBook)) {

                        ArrayList<Contact> old_address_book = new ArrayList<>();
                        personDetails = old_address_book;
                        personDetails = hashmap.get(oldAddressBook);
                        int choice1 = 1;
                        while (choice1 == 1) {
                            System.out.println("Choose an Option According To Your Preference: ");
                            System.out.println("1.Add details.\n2.Edit details.\n3.Delete contact. \n4.Display contact.\n5.Exit");
                            switch (sc.nextInt()) {
                                case 1:
                                    details.addDetails();
                                    break;
                                case 2:
                                    details.editDetails();
                                    break;
                                case 3:
                                    details.deleteDetails();
                                    break;
                                case 4:
                                    details.display();
                                    break;
                                default:
                                    System.out.println("Exited From Address Book");
                                    break;
                            }
                            hashmap.put(oldAddressBook, personDetails);
                            System.out.println(hashmap);
                            choice1 = 0;
                        }
                    } else {
                        System.out.println("Enter valid address book name");
                    }
                    break;

                //Switch Case For Displaying All Address Book
                case 3:
                    System.out.println(hashmap);
                    break;

                default:
                    System.out.println("Exited From Address Book Management System");
                    option = 0;
            }
        }
    }

    /*
    This method is used to display the added information
     */
    public void display() {
        System.out.println(personDetails);
    }
}
