package patrons;

public class Patron {

    private int patronId;
    private String patronName;
    private String phoneNumber;
    private String email;

    public Patron(int patronId, String patronName, String phoneNumber, String email) {
        this.patronId = patronId;
        this.patronName = patronName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getPatronId() {
        return patronId;
    }

    public String getPatronName() {
        return patronName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setPatronName(String patronName) {
        this.patronName = patronName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
