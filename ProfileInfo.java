
/**
 * Write a description of class UserInfo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProfileInfo {
    String email;
    String addressStreet;
    int contactNumber;
    String postCode;
    int houseNumber;

    /**
     * Constructor for objects of class ProfileInfo
     */
    public ProfileInfo(String email, String addressStreet, int houseNumber, String postCode, int contactNumber) {
        this.email = email;
        this.addressStreet = addressStreet;
        this.houseNumber = houseNumber;
        this.postCode = postCode;
        this.contactNumber = contactNumber;
    }

    
}
