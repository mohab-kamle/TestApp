/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import EndUser.Admin;
import EndUser.Student;
import EndUser.User;

/**
 *
 * @author Zeyad
 */
public class UpdateProfilePanel {

    public UpdateProfilePanel(User user) {
        if (user instanceof Admin){
            Admin admin = (Admin)user ;
        }
        else if (user instanceof Student){
            Student student = (Student)user ;
        }
    }
    
    
}
