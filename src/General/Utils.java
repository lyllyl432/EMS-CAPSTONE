/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package General;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                employee_list = new EmployeeList(rs.getString("id_number"), rs.getString("full_name"), rs.getString("address"),rs.getString("phone_number"), rs.getString("gender"), rs.getString("department"), rs.getString("profile_picture"));
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
}

