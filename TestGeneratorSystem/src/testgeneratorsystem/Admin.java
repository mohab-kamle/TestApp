package testgeneratorsystem;
import java.util.*;
/**
 *
 * @author mohab
 */

public class Admin{
    private Date dateAppointed;
    private String contactNumber;
    private String department;
    private ArrayList<Integer> ownedBanks;

    public Admin(Date dateAppointed, String contactNumber, String department, ArrayList<Integer> ownedBanks) {
        this.dateAppointed = dateAppointed;
        this.contactNumber = contactNumber;
        this.department = department;
        this.ownedBanks = ownedBanks;
    }

    public void setDateAppointed(Date dateAppointed) {
        this.dateAppointed = dateAppointed;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setOwnedBanks(ArrayList<Integer> ownedBanks) {
        this.ownedBanks = ownedBanks;
    }

    public Date getDateAppointed() {
        return dateAppointed;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getDepartment() {
        return department;
    }

    public ArrayList<Integer> getOwnedBanks() {
        return ownedBanks;
    }
    
    public boolean createCategory(){
        return false;
    }
    public boolean modifyCategory(){
        return false;
    }
    public boolean deleteCategory(){
        return false;
    }
    public boolean addQuestionToQuestionBank(){
        return false;
    }
    public boolean updateQuestioninQuestionBank(){
        return false;
    }
    public boolean deleteQuestionFromQuestionBank(){
        return false;
    }
    
    
}
