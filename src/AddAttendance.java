
import General.ConnectionProvider;
import General.EmployeeList;
import General.Utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author HP
 */
public class AddAttendance extends javax.swing.JFrame {

    /**
     * Creates new form AddAttendance
     */
    private DefaultTableModel model;
    private ArrayList<EmployeeList> employeeArrayList; 
    public AddAttendance() {
        initComponents();
        try {
            this.showEmployeeItem();
        } catch (SQLException ex) {
            Logger.getLogger(AddAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        search_field = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(77, 114, 152));
        jPanel1.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        employeeListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Number", "Name", "Address", "Phone Number", "Gender", "Department", "Profile Picture", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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
            employeeListTable.getColumnModel().getColumn(5).setResizable(false);
            employeeListTable.getColumnModel().getColumn(6).setResizable(false);
            employeeListTable.getColumnModel().getColumn(7).setResizable(false);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 680, 340));

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(51, 51, 51));
        jButton4.setText("Attendance");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, 40));

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

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Search Employee :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, -1, -1));

        search_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_fieldKeyReleased(evt);
            }
        });
        jPanel1.add(search_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, 120, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public void showEmployeeItem() throws SQLException{
    employeeArrayList = Utils.getEmployeeList();
        model = (DefaultTableModel)this.employeeListTable.getModel();
         Object[] row = new Object[8];
         
         model.setRowCount(0);
          for(int i = 0; i < employeeArrayList.size(); i++){
             
//            System.out.println(pendingArrayList.get(i).getTime());
            row[0] = employeeArrayList.get(i).getIdNumber();
            row[1] = employeeArrayList.get(i).getName();
            row[2] = employeeArrayList.get(i).getAddress();
            row[3] = employeeArrayList.get(i).getPhoneNumber();
            row[4] = employeeArrayList.get(i).getGender();
            row[5] = employeeArrayList.get(i).getDepartment();
            row[6] = employeeArrayList.get(i).getProfilePicture();
            row[7] = employeeArrayList.get(i).getEmail();

            model.addRow(row);
        }
                this.employeeListTable.getColumnModel().getColumn(1).setPreferredWidth(150);
                this.employeeListTable.getColumnModel().getColumn(2).setPreferredWidth(150);
                this.employeeListTable.getColumnModel().getColumn(3).setPreferredWidth(100);

          TableColumnModel columnModel = this.employeeListTable.getColumnModel();
          Utils.setColumnWidthZero(columnModel, 6);
          Utils.setColumnWidthZero(columnModel, 7);

    }
    
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
          int selectedRow = this.employeeListTable.getSelectedRow();
        if (selectedRow != -1) {
                    // Get values from the selected row
                    String idNumber= this.employeeListTable.getValueAt(selectedRow, 0).toString();
                    String name = this.employeeListTable.getValueAt(selectedRow, 1).toString();
                    String address = this.employeeListTable.getValueAt(selectedRow, 2).toString();
//                    System.out.println(address);
                    String phoneNumber = this.employeeListTable.getValueAt(selectedRow, 3).toString();
//                    System.out.println(this.employeeListTable.getValueAt(selectedRow, 3).toString());
                    String gender = this.employeeListTable.getValueAt(selectedRow, 4).toString();
                    String department = this.employeeListTable.getValueAt(selectedRow, 5).toString();
                    String profile_picture = this.employeeListTable.getValueAt(selectedRow, 6).toString();
                    String email = this.employeeListTable.getValueAt(selectedRow, 7).toString();

                    EmployeeList employeeList = new EmployeeList(idNumber, name, address, phoneNumber, gender,department, profile_picture,email);
              try {
                  new EmployeeAttendance(employeeList).setVisible(true);
              } catch (SQLException ex) {
                  Logger.getLogger(AddAttendance.class.getName()).log(Level.SEVERE, null, ex);
              }
                } else {
                    JOptionPane.showMessageDialog(this, "No row selected.", "Error", JOptionPane.INFORMATION_MESSAGE);

                }  
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Home().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void search_fieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_fieldKeyReleased
        Utils.filterSearch(this.search_field.getText(), employeeListTable, 1);
    }//GEN-LAST:event_search_fieldKeyReleased

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
            java.util.logging.Logger.getLogger(AddAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddAttendance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable employeeListTable;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField search_field;
    // End of variables declaration//GEN-END:variables
}
