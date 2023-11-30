/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package General;

/**
 *
 * @author shand
 */
public class EmployeeList {
   
    private String name, address, phoneNumber, gender, idNumber, department, profile_picture;
    public EmployeeList(String idNumber, String name, String address, String phoneNumber, String gender, String department){
        this.idNumber = idNumber;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.address = address;
        this.department = department;
    }
    
    public EmployeeList(String idNumber, String name, String address, String phoneNumber, String gender, String department, String profile_picture){
        this.idNumber = idNumber;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.profile_picture = profile_picture;
    }
    public String getIdNumber(){
        return idNumber;
    }
    public String getName(){
        return name;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public String getAddress(){
        return address;
    }
    public String getGender(){
        return gender;
    }
    public String getDepartment(){
        return department;
    }
    public String getProfilePicture(){
        return profile_picture;
    }
}
