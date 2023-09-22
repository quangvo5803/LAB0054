package Controller;

import java.util.ArrayList;

import Common.Validation;
import Model.Contact;
import View.Menu;

public class Program extends Menu<String> {
    static String[] mainChoice = { "Add a Contact", "Display all Contact", "Delete a Contact", "Exit" };
    ArrayList<Contact> contacts;

    public Program() {
        super("========== Contact Program ==========", mainChoice);
        contacts = new ArrayList<>();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1: {
                addContact();
                break;
            }
            case 2: {
                displayContact();
                break;
            }
            case 3: {
                deleteContactByID();
                break;
            }
            case 4: {
                System.exit(0);
            }
        }
    }

    public void addContact() {
        while (true) {
            System.out.println();
            int contactID = contacts.size() + 1;
            String firstName = Validation.getString("Enter first name: ");
            String lastName = Validation.getString("Enter last name: ");
            String group = Validation.getString("Enter group: ");
            String address = Validation.getString("Enter address: ");
            String phone = Validation.getPhone();
            contacts.add(
                    new Contact(contactID, firstName + " " + lastName, group, address, phone, firstName, lastName));
            System.out.println("Add successful");
            System.out.println();
            if(!Validation.getYesNo("Do you want to continue (Y/N): ").equalsIgnoreCase("Y")){
                System.out.println();
                return;
            }
        }
    }

    public void displayContact() {
        System.out.println("--------------------------------- Display All Contact ----------------------------");
        System.out.printf("%-5s%-25s%-20s%-20s%-20s%-20s%-20s\n", "Id", "Name",
                "First name", "Last name", "Group", "Address", "Phone");
        for (Contact contact : contacts) {
            System.out.printf("%-5d%-25s%-20s%-20s%-20s%-20s%-20s\n",
                    contact.getContactID(), contact.getFullName(),
                    contact.getFirstName(), contact.getLastName(),
                    contact.getGroup(), contact.getAddress(), contact.getPhone());
        }
        System.out.println();
    }

    public void deleteContactByID() {
        System.out.println();
        System.out.println("--------------------------------- Delete Contact By ID ----------------------------");
        Contact deleteContact = getContactbyID(Validation.getInt("Enter ID want to delete: ", 1, contacts.size()));
        if (deleteContact == null) {
            System.out.println("Not found");
            return;
        } else {
            contacts.remove(deleteContact);
        }
        System.out.println("Delete successful");
        System.out.println();

    }

    public Contact getContactbyID(int ID) {
        for (Contact c : contacts) {
            if (c.getContactID() == ID) {
                return c;
            }
        }
        return null;
    }
}
