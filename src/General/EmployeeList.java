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
   
    private String name, address, phoneNumber, gender, idNumber;
    public EmployeeList(String idNumber, String name, String address, String phoneNumber, String gender){
        this.idNumber = idNumber;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.address = address;
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
}
