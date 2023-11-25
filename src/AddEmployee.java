
import General.ConnectionProvider;
import General.EmployeeList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author shand
 */
public class AddEmployee extends javax.swing.JFrame {

    /**
     * Creates new form AddEmployee
     */
      private String fullName;
      private String idNumber;
      private String Address;
      private String phoneNumber;
      private String Gender;
    public AddEmployee() {
        initComponents();
        showEmployeeItem();
    }
    
     /*====================================================== function ==============================================*/
    public void showEmployeeItem(){
     try {
            // Create the SQL query with placeholders
            String selectQuery = "SELECT * FROM employee";       


            // Create a connection
            ConnectionProvider dbc = new ConnectionProvider();
            String jdbcDriver = dbc.getJdbcDriver();
            String dbConnectionURL = dbc.getDbConnectionURL();
            String dbUsername = dbc.getDbUsername();
            String dbPassword = dbc.getDbPassword();
            Class.forName(jdbcDriver);
            Connection connection = DriverManager.getConnection(dbConnectionURL, dbUsername, dbPassword);

            // Create the PreparedStatement
            
            PreparedStatement statement = connection.prepareStatement(selectQuery);
              // Create the PreparedStatement
          
           statement.executeQuery();
           ResultSet resultSet = statement.executeQuery();
           if (resultSet.next()) {
        this.fullName = resultSet.getString("full_name");
        this.idNumber = resultSet.getString("id_number");
        this.Address = resultSet.getString("address");
        this.phoneNumber = resultSet.getString("phone_number");
       this.Gender = resultSet.getString("gender");

        // Display the retrieved data
//        System.out.println("full_name: " + this.fullName);
//        System.out.println("id_number: " + this.idNumber);
//        System.out.println("address: " + this.Address);
//        System.out.println("phone_number: " + this.phoneNumber);
//          System.out.println("gender: " + this.Gender);
       

         DefaultTableModel tableModel = (DefaultTableModel) this.employeeListTable.getModel();
         tableModel.setRowCount(0);

            // Override isCellEditable method to make all cells non-editable
            tableModel = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    // Make all cells non-editable
                    return false;
                }
            };
            // Set the modified model back to the JTable
            this.employeeListTable.setModel(tableModel);
             // Set the row height
            int rowHeight = 30; // Set your desired row height
            this.employeeListTable.setRowHeight(rowHeight);


        // Get column names and add them to the table model
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = metaData.getColumnName(i);
            if (columnName.equals("full_name") || columnName.equals("id_number") ||
                    columnName.equals("address") || columnName.equals("phone_number") || columnName.equals("gender")) {
               String[] newColumnNames = {"ID Number", "Name", "Phone Number","Address", "Gender"};
                tableModel.setColumnIdentifiers(newColumnNames);
            }
        }

        // Add rows to the table model
        do {
            Object[] rowData = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                rowData[i - 1] = resultSet.getObject(i);
            }
            tableModel.addRow(rowData);
        } while (resultSet.next());

    } else {
        System.out.println("No matching records found.");
        JOptionPane.showMessageDialog(null, "No record found!");
    }
    // Close resources
    resultSet.close();
    statement.close();
    connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    
    }
    
    
    /* ======================================================End ============================================*/


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        employeeListTable = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(77, 114, 152));
        jPanel1.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        employeeListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "ID Number", "Address", "Phone Number", "Gender"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        employeeListTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeeListTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(employeeListTable);
        if (employeeListTable.getColumnModel().getColumnCount() > 0) {
            employeeListTable.getColumnModel().getColumn(0).setResizable(false);
            employeeListTable.getColumnModel().getColumn(1).setResizable(false);
            employeeListTable.getColumnModel().getColumn(2).setResizable(false);
            employeeListTable.getColumnModel().getColumn(3).setResizable(false);
            employeeListTable.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 680, 340));

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setText("Remove Employee");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, -1, 40));

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(51, 51, 51));
        jButton4.setText("Add Employee");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, 40));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Update Employee");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, 40));

        jPanel2.setBackground(new java.awt.Color(119, 166, 182));

        jButton2.setBackground(new java.awt.Color(208, 239, 177));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N
        jLabel1.setText("EMPLOYEE MANAGEMENT SYSTEM");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jLabel1))
                .addGap(33, 33, 33))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 110));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        editemployee employee = new editemployee();
        employee.pack();
        employee.setLocationRelativeTo(null);
        employee.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
//remove employee list specified by id number
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int deleteItem;
        DefaultTableModel RecordTable = (DefaultTableModel) this.employeeListTable.getModel();
        int selectedRow = this.employeeListTable.getSelectedRow();
         String idNumber= this.employeeListTable.getValueAt(selectedRow, 0).toString();

        try {
            deleteItem = JOptionPane.showConfirmDialog(null, "Confirm if you want to delete item ", "warning", JOptionPane.YES_NO_OPTION);

            if (deleteItem == JOptionPane.YES_OPTION) {

                // Create the SQL query with placeholders
                String deleteQuery = "DELETE FROM employee WHERE id_number = ?";

                // Create a connection
                ConnectionProvider dbc = new ConnectionProvider();
                String jdbcDriver = dbc.getJdbcDriver();
                String dbConnectionURL = dbc.getDbConnectionURL();
                String dbUsername = dbc.getDbUsername();
                String dbPassword = dbc.getDbPassword();
                Class.forName(jdbcDriver);
                Connection connection = DriverManager.getConnection(dbConnectionURL, dbUsername, dbPassword);

                // Create the PreparedStatement
                PreparedStatement statement = connection.prepareStatement(deleteQuery);
                statement.setInt(1, Integer.parseInt(idNumber));

                // Execute the DELETE query
                int rowsAffected = statement.executeUpdate();

                if (rowsAffected > 0) {
                    // Refresh the table with updated data
                    DefaultTableModel tableModel = new DefaultTableModel();
                    this.employeeListTable.setModel(tableModel);
                    showEmployeeItem();
                } else {
                    System.out.println("No record found with the given id_number.");
                }

                
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void employeeListTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeListTableMouseClicked
//         DefaultTableModel RecordTable = (DefaultTableModel) this.employeeListTable.getModel();
//    int SelectedRows = this.employeeListTable.getSelectedRow();
//    employee_id_field.setText(RecordTable.getValueAt(SelectedRows, 0).toString());
//     name_field.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
//    address_field.setText(RecordTable.getValueAt(SelectedRows, 2).toString());
//    phone_field.setText(RecordTable.getValueAt(SelectedRows, 3).toString());
//    gender_combo_box.setSelectedItem(RecordTable.getValueAt(SelectedRows, 4).toString());
        
    }//GEN-LAST:event_employeeListTableMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new AddEmployeeForm(this).setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         int selectedRow = this.employeeListTable.getSelectedRow();
        if (selectedRow != -1) {
                    // Get values from the selected row
                    String idNumber= this.employeeListTable.getValueAt(selectedRow, 0).toString();
                    String name = this.employeeListTable.getValueAt(selectedRow, 1).toString();
                    String address = this.employeeListTable.getValueAt(selectedRow, 3).toString();
                    String phoneNumber = this.employeeListTable.getValueAt(selectedRow, 2).toString();
                    System.out.println(this.employeeListTable.getValueAt(selectedRow, 2).toString());
                    String gender = this.employeeListTable.getValueAt(selectedRow, 4).toString();
                    
                    EmployeeList employeeList = new EmployeeList(idNumber, name, address, phoneNumber, gender);
                    new UpdatePatientForm(this, employeeList).setVisible(true);
                } else {
                    System.out.println("No row selected.");
                }  
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddEmployee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable employeeListTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
