/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI;

import BLL.ThanhVienBLL;
import BLL.ThietBiBLL;
import BLL.ThongTinSDBLL;
import DAL.TTSD;
import DAL.ThanhVien;
import DAL.ThietBi;
import DAL.ThongTinSD;
import com.google.protobuf.Timestamp;
import java.util.List;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import javax.swing.JOptionPane;
/**
 *
 * @author ADMIN
 */
public class ThongTinSuDungUI extends javax.swing.JPanel {
    private ThongTinSDBLL tt;
    private ThietBiBLL tb;
    DefaultTableModel dtm;
    public ThongTinSuDungUI() {
        tt=new ThongTinSDBLL();
        tb=new ThietBiBLL();
        initComponents();
        onload();
    }
     public DefaultTableModel loadTable(){
    List listThongTin = tt.loadTTSD();
    Object[][] datamodel;
    datamodel = tt.convertList(listThongTin);
    
    // Chuyển đổi java.sql.Timestamp thành chuỗi String
    for (int i = 0; i < datamodel.length; i++) {
        for (int j = 3; j < datamodel[i].length; j++) {
            if (datamodel[i][j] instanceof Timestamp) {
                Timestamp timestamp = (Timestamp) datamodel[i][j];
                datamodel[i][j] = timestamp.toString();
            }
        }
    }
    
    // Loại bỏ ".0" từ các thành phần cuối cùng của datamodel
    for (int i = 0; i < datamodel.length; i++) {
        for (int j = 3; j < datamodel[i].length; j++) {
            if (datamodel[i][j] instanceof String) {
                String timeString = (String) datamodel[i][j];
                if (timeString.endsWith(".0")) {
                    datamodel[i][j] = timeString.substring(0, timeString.length() - 2);
                }
            }
        }
    }
    
    String[] title = {"Mã thông tin", "Mã thành viên", "Mã thiết bị","Thời gian đặt chỗ","Thời gian vào","Thời gian mượn","Thời gian trả"};
    DefaultTableModel model = new DefaultTableModel(datamodel, title){
        public boolean isCellEditable(int row, int column)
            {
              return false;
            }
   };	
    return model;
}

    public void onload(){
        dtm=loadTable();	
        jTable.setAutoCreateRowSorter(true);
        jTable.setModel(dtm);
        
        for (int i = 0; i < jTable.getColumnCount(); i++) {
        TableColumn column = jTable.getColumnModel().getColumn(i);
        column.setCellEditor(null);
        txtMaTT.setEditable(false);
        txtDatcho.setEditable(false);
        txtVao.setEditable(false);
        txtMuon.setEditable(false);
        txtTra.setEditable(false);
        txtMaTB.setEditable(false);
        txtMaTT.setEnabled(false);
        txtMaTV.setEditable(false);
        txtMaTV.setEnabled(false);
        txtMaTB.setEnabled(false);
        txtDatcho.setEnabled(false);
        txtVao.setEnabled(false);
        txtMuon.setEnabled(false);
        txtTra.setEnabled(false);
    }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtDatcho = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtVao = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtMuon = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtTra = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtFindTV = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtMaTV = new javax.swing.JTextField();
        txtMaTB = new javax.swing.JTextField();
        txtMaTT = new javax.swing.JTextField();

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Chi tiết thông tin sử dụng");

        jLabel2.setText("Mã TT :");

        jLabel14.setText("Mã TB:");

        jLabel16.setText("Tgian Đặt  : ");

        jLabel17.setText("Tgian Vào: ");

        jLabel18.setText("Tgian mượn :");

        jLabel19.setText("Tgian trả :");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Thông tin sử dụng");

        jButton2.setText("Thêm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Sửa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Xóa");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Tìm kiếm");

        jButton1.setText("Tìm ");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Chức năng");

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable);

        jLabel3.setText("Mã TV :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMuon)
                            .addComponent(txtTra)
                            .addComponent(txtDatcho)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtMaTT, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtMaTB, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtVao, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                                    .addComponent(txtMaTV))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jButton2))
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtFindTV, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(72, 72, 72))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(289, 289, 289))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel14)
                            .addComponent(txtMaTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtMaTV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtDatcho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtVao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(txtMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFindTV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        String query = txtFindTV.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dtm);
        jTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        int i = jTable.getSelectedRow();
        if(i>=0){
           txtMaTT.setText(jTable.getModel().getValueAt(i, 0) != null ? jTable.getModel().getValueAt(i, 0).toString() : "null");
    txtMaTV.setText(jTable.getModel().getValueAt(i, 1) != null ? jTable.getModel().getValueAt(i, 1).toString() : "null");
    txtMaTB.setText(jTable.getModel().getValueAt(i, 2) != null ? jTable.getModel().getValueAt(i, 2).toString() : "null");
    txtDatcho.setText(jTable.getModel().getValueAt(i, 3) != null ? jTable.getModel().getValueAt(i, 3).toString() : "null");
    txtVao.setText(jTable.getModel().getValueAt(i, 4) != null ? jTable.getModel().getValueAt(i, 4).toString() : "null");
    txtMuon.setText(jTable.getModel().getValueAt(i, 5) != null ? jTable.getModel().getValueAt(i, 5).toString() : "null");
    txtTra.setText(jTable.getModel().getValueAt(i, 6) != null ? jTable.getModel().getValueAt(i, 6).toString() : "null");
    
        }
    }//GEN-LAST:event_jTableMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jButton2.getText().equals("Thêm")) {
            jButton2.setText("Lưu");
            jButton3.setEnabled(false);
            jButton4.setEnabled(false);
//            lblchitiet.setText("Thêm thông tin");
            txtMaTT.setText("");
            txtMaTV.setText("");
            txtDatcho.setText("");
            txtVao.setText("");
            txtMuon.setText("");
            txtTra.setText("");
            txtMaTB.setText("");  
            txtMaTT.setEditable(true);
            txtMaTB.setEditable(true);
            txtMaTV.setEditable(true);
            txtDatcho.setEditable(true);
            txtVao.setEditable(true);
            txtMuon.setEditable(true);
            txtTra.setEditable(true);
            txtMaTT.setEnabled(true);
            txtMaTB.setEnabled(true);
            txtMaTV.setEnabled(true);
            txtDatcho.setEnabled(true);
            txtVao.setEnabled(true);
            txtMuon.setEnabled(true);
            txtTra.setEnabled(true);
    }//GEN-LAST:event_jButton2ActionPerformed
 else {
            int MaTV;
            String text = txtMaTV.getText();
            if (text.matches(".*[a-zA-Z].*")) {
                JOptionPane.showMessageDialog(this, "Mã thành viên chỉ được chứa các chữ số.");
                return;
            }
            long textTV = Long.parseLong(text);
            if (textTV > 2147483647) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập một số nhỏ hơn 2147483647");
                return;
            }
            if (text != null && !text.isEmpty()) {
                if (text.matches("\\d+")) {
                    MaTV = Integer.parseInt(text);
                } else {
                    JOptionPane.showMessageDialog(this, "Mã thành viên không hợp lệ.");
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập mã thành viên.");
                return;
            }
            String maTB = txtMaTB.getText();
            if (!isValidMaTB(maTB)) {
            JOptionPane.showMessageDialog(this, "Mã thiết bị không hợp lệ. Vui lòng nhập 7 chữ số và chỉ chứa số 0 và 1.");
            return;
            }
            String Vao = txtVao.getText();
            if (!isValidDateFormat(Vao)) {
            JOptionPane.showMessageDialog(this, "Thời gian Vào không hợp lệ. Vui lòng nhập theo định dạng YYYY-MM-DD HH:mm:ss.");
            return;
            }
            String Muon = txtMuon.getText();
            if (!isValidDateFormat(Muon)) {
            JOptionPane.showMessageDialog(this, "Thời gian Mượn không hợp lệ. Vui lòng nhập theo định dạng YYYY-MM-DD HH:mm:ss.");
            return;
            }
            String Tra = txtTra.getText();
            if (!isValidDateFormat(Tra)) {
            JOptionPane.showMessageDialog(this, "Thời gian Trả không hợp lệ. Vui lòng nhập theo định dạng YYYY-MM-DD HH:mm:ss.");
            return;
            }
            String Dat = txtDatcho.getText();
            if (!isValidDateFormat(Dat)) {
            JOptionPane.showMessageDialog(this, "Thời gian Đặt chỗ tháng không hợp lệ. Vui lòng nhập theo định dạng YYYY-MM-DD HH:mm:ss.");
            return;
            }
            if (Vao == "" || Muon == "" || Tra== "" || Dat == "") {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin.");
                return;
            } 
        }
    }
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    if (txtMaTT.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chọn thông tin cần xóa.");
            return;
        } else {
             int confirmation = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa thông tin này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
    if (confirmation == JOptionPane.YES_OPTION) {
        if (tt.deleteThongTin(Integer.parseInt(txtMaTT.getText()))) {
            JOptionPane.showMessageDialog(this, "Xóa thông tin thành công.");
        } else {
            JOptionPane.showMessageDialog(this, "Xóa thông tin thất bại vì có liên kết với khóa ngoại.");
            return;
        }
    } else {
        return;
    }  
    }// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (txtMaTT.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chọn thông tin cần sửa.");
            return;
        }    // TODO add your handling code here:  if (txtMaTV.getText().isEmpty()) {
        if (jButton3.getText().equals("Sửa")) {
            jButton3.setText("Lưu");
            jButton2.setEnabled(false);
            jButton4.setEnabled(false);
            txtMaTT.setEditable(false);
            txtMaTV.setEditable(true);
            txtMaTB.setEditable(true);
            txtVao.setEditable(true);
            txtMuon.setEditable(true);
            txtTra.setEditable(true);
            txtDatcho.setEditable(true);
            txtMaTT.setEnabled(false);
            txtMaTV.setEnabled(true);
            txtMaTB.setEnabled(true);
            txtVao.setEnabled(true);
            txtMuon.setEnabled(true);
            txtTra.setEnabled(true);
            txtDatcho.setEnabled(true);
        } else {

            int MaTV;
            String text = txtMaTV.getText();
            if (text.matches(".*[a-zA-Z].*")) {
                JOptionPane.showMessageDialog(this, "Mã thành viên chỉ được chứa các chữ số.");
                return;
            }
            long textTV = Long.parseLong(text);
            if (textTV > 2147483647) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập một số nhỏ hơn 2147483647");
                return;
            }
            if (text != null && !text.isEmpty()) {
                if (text.matches("\\d+")) {
                    MaTV = Integer.parseInt(text);
                } else {
                    JOptionPane.showMessageDialog(this, "Mã thành viên không hợp lệ.");
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập mã thành viên.");
                return;
            }
            String maTB = txtMaTB.getText();
            if (!maTB.equals("null")){
                if (!isValidMaTB(maTB)) {
                    JOptionPane.showMessageDialog(this, "Mã thiết bị không hợp lệ. Vui lòng chỉ nhập các ký tự số 0 và 1.");
                return;
                }}
             String Vao = txtVao.getText();
             if (!Vao.equals("null")){
            if (!isValidDateFormat(Vao)) {
            JOptionPane.showMessageDialog(this, "Thời gian Vào không hợp lệ. Vui lòng nhập theo định dạng YYYY-MM-DD HH:mm:ss.");
            return;
            }}
            String Muon = txtMuon.getText();
            if (!Muon.equals("null")){
            if (!isValidDateFormat(Muon)) {
            JOptionPane.showMessageDialog(this, "Thời gian Mượn không hợp lệ. Vui lòng nhập theo định dạng YYYY-MM-DD HH:mm:ss.");
            return;
            }}
            String Tra = txtTra.getText();
            if (!Tra.equals("null")){
            if (!isValidDateFormat(Tra)) {
            JOptionPane.showMessageDialog(this, "Thời gian Trả không hợp lệ. Vui lòng nhập theo định dạng YYYY-MM-DD HH:mm:ss.");
            return;
            }}
            String Dat = txtDatcho.getText();
            if (!Dat.equals("null")){
            if (!isValidDateFormat(Dat)) {
            JOptionPane.showMessageDialog(this, "Thời gian Đặt chỗ không hợp lệ. Vui lòng nhập theo định dạng YYYY-MM-DD HH:mm:ss.");
            return;
            }}
    }//GEN-LAST:event_jButton3ActionPerformed
    }
    private boolean isValidMaTV(String maTV) {
        // Kiểm tra xem maTV có 10 ký tự không
        if (maTV.length() != 10) {
            return false;
        }

        // Kiểm tra xem maTV chỉ chứa số không
        if (!maTV.matches("[0-9]+")) {
            return false;
        }

        return true;
    }
    
    private boolean isValidMaTB(String maTT) {
    // Kiểm tra xem maTT có đúng độ dài là 7 ký tự không
        if (maTT.length() != 7) {
            return false;
        }
    return true;
    }

    
     private boolean isExistMaTT(int maTT) {
        List<TTSD> listTTSD = tt.loadThongTin();
        for (TTSD thongTinSD : listTTSD) {
            if (thongTinSD.getMaTT() == maTT) {

                return true;
            }
        }
        return false;
    }
    private boolean isValidDateFormat(String input) {
    String dateFormatRegex = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}.\\d{1}";
    return input.matches(dateFormatRegex);
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField txtDatcho;
    private javax.swing.JTextField txtFindTV;
    private javax.swing.JTextField txtMaTB;
    private javax.swing.JTextField txtMaTT;
    private javax.swing.JTextField txtMaTV;
    private javax.swing.JTextField txtMuon;
    private javax.swing.JTextField txtTra;
    private javax.swing.JTextField txtVao;
    // End of variables declaration//GEN-END:variables
}
