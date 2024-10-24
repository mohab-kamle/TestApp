package testgeneratorsystem;

import java.util.Date;

/**
 *
 * @author mohab
 */

public class User {

    protected int userId;
    protected String email;
    protected String password;
    protected String address;
    protected String firstName;
    protected String lastName;
    protected Date lastLoginDate;

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public int getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }
    public void signUp(){
        
    }
    public boolean login(){
        
        return false;
        
    }
    public void updateProfile(){
        
    }
    public boolean changePassword(){
        return false;
    }
    public boolean resetPassword(){
        return false;
    }
    public String getProfile(){
        return "";
    }
    public void removeAccount(){
        
    }
    public boolean createQuestionBank(){
        return false;
    }
    public boolean deleteQuestionBank(){
        return false;
    }
    
}
