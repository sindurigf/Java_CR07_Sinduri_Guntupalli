import java.util.ArrayList;
import java.util.List;

public class Contact {
    private int contactID;
    private String phoneNumber;
    private String emailID;

    public static List<Contact> contactList = new ArrayList<>();

    public Contact(int contactID, String phoneNumber, String emailID) {
        this.contactID = contactID;
        this.phoneNumber = phoneNumber;
        this.emailID = emailID;
        contactList.add(this);
    }

    public int getContactID() {
        return contactID;
    }

    public void setContactID(int contactID) {
        this.contactID = contactID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }
}
