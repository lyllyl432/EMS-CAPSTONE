/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package General;

import java.util.Date;
import java.sql.Time;


/**
 *
 * @author HP
 */
public class AttendanceList {
    private Date date;
    private Time time_in;
    private Time time_out;
    private String employee_name;
    private int attendance_id;
    public AttendanceList(Date date, Time time_in, Time time_out){
        this.date = date;
        this.time_in = time_in;
        this.time_out = time_out;
    }
    //method overloading for attendance records 
    public AttendanceList(Date date, Time time_in, Time time_out,String employee_name, int attendance_id){
        this.date = date;
        this.time_in = time_in;
        this.time_out = time_out;
        this.employee_name = employee_name;
        this.attendance_id = attendance_id;
    }
    public Date getDate(){
        return this.date;
    }
    public Time getTimeIn(){
        return this.time_in;
    }
    public Time getTimeOut(){
        return this.time_out;
    }
    public String getEmployeeName(){
        return this.employee_name;
    }
    public int getAttendanceId(){
        return this.attendance_id;
    }
}
