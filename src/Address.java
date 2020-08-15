import java.util.HashMap;

public class Address {
    private int addressID;
    private String street;
    private int zip;
    private String city;
    private String country;

    public static HashMap<Integer, Address> addressList = new HashMap<>();

    public Address(int addressID, String street, int zip, String city, String country) {
        this.addressID = addressID;
        this.street = street;
        this.zip = zip;
        this.city = city;
        this.country = country;
        addressList.put(this.getAddressID(), this);
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
