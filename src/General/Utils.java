/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package General;

import java.awt.print.PrinterException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.sql.*;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
/**
 *
 * @author HP
 */
public class Utils {
    private static  TableRowSorter sorter;
    private static DefaultTableModel model;
      private static Connection con;
      private static ResultSet rs;
    private static ArrayList<EmployeeList> employeeArrayList;
    //make the time as a readable string time format
    public static String convertTimeToReadable(Date time){
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
        return sdf.format(time);
    }
    //filter search for table
    public static void filterSearch(String query, JTable table, int column){
          model = (DefaultTableModel)table.getModel();
          sorter = new TableRowSorter<>(model);
          table.setRowSorter(sorter);
          if(query.isEmpty()){
              sorter.setRowFilter(null);
          }else{
              RowFilter<TableModel, Object> filter = RowFilter.regexFilter(query, column); // Adjust the column index as needed
              sorter.setRowFilter(filter);
          }
    }
    //get employee list object
      public static ArrayList<EmployeeList> getEmployeeList() throws SQLException {
      
          
        try {
            employeeArrayList = new ArrayList<>();
            EmployeeList employee_list;
            
            // Create the SQL query without placeholders
            String selectQuery = "SELECT * FROM employee";
            
            // Create a connection
            ConnectionProvider dbc = new ConnectionProvider();
            String jdbcDriver = dbc.getJdbcDriver();
            String dbConnectionURL = dbc.getDbConnectionURL();
            String dbUsername = dbc.getDbUsername();
            String dbPassword = dbc.getDbPassword();
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection(dbConnectionURL, dbUsername, dbPassword);
            
            // Create the Statement
            Statement statement = con.createStatement();
            
            // Execute the query
            ResultSet rs = statement.executeQuery(selectQuery);
            
            while (rs.next()) {
                employee_list = new EmployeeList(rs.getString("id_number"), rs.getString("full_name"), rs.getString("address"),rs.getString("phone_number"), rs.getString("gender"), rs.getString("department"), rs.getString("profile_picture"),rs.getString("email"));
                employeeArrayList.add(employee_list);
            }
            
            // Close resources
            statement.close();
            con.close();
            
            return employeeArrayList;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
          return null;   
          } 
          
          //set specified table column to zero
    public static void  setColumnWidthZero(TableColumnModel column_model, int row){
      TableColumn column = column_model.getColumn(row);
     column.setMinWidth(0);
     column.setMaxWidth(0);
     column.setPreferredWidth(0);
     column.setWidth(0);
    }
    public static void printTable(JTable table) throws PrinterException {
        // Create a MessageFormat for the header and footer
        MessageFormat header = new MessageFormat("Attendance Record");
        MessageFormat footer = new MessageFormat("Page {0}");

        // Print the table
        boolean complete = table.print(JTable.PrintMode.FIT_WIDTH, header, footer);

        if (complete) {
            System.out.println("Printing Complete");
        } else {
            System.out.println("Printing Cancelled");
        }
    }
    //field characters authentication
        public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }

        // Regular expression for a simple email validation
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
         // Make the date as a readable string date format
    public static String convertDateToReadable(String date_string){
        LocalDate date = LocalDate.parse(date_string);
             DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
             return date.format(formatter);
    }
}

