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
import java.awt.FileDialog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Nguyen Nhat Vuong
 */
public class ThanhVienUI extends JPanel {

    private ThanhVienBLL thanhVienBLL;
    private ThongTinSDBLL thongTinBLL;
    private ThietBiBLL thietbiBLL;
    DefaultTableModel dtm;

    public ThanhVienUI() {
        thanhVienBLL = new ThanhVienBLL();
        thongTinBLL = new ThongTinSDBLL();
        initComponents();
        onload();
    }
    public DefaultTableModel loadTable() {
        List listThanhVien = thanhVienBLL.loadThanhVien();
        Object[][] datamodel;
        datamodel = thanhVienBLL.convertList(listThanhVien);
        String[] title = {"Mã thành viên", "Tên thành viên", "Password", "Email", "Số điện thoại", "Khoa", "Ngành"};
        DefaultTableModel model = new DefaultTableModel(datamodel, title) {
            public boolean isCellEditable(int row, int column) {return false;}};return model;}
    public void onload() {
        dtm = loadTable();
        jTable.setAutoCreateRowSorter(true);
        jTable.setModel(dtm);
        for (int i = 0; i < jTable.getColumnCount(); i++) {
            TableColumn column = jTable.getColumnModel().getColumn(i);
            column.setCellEditor(null);
            txtMaTV.setEditable(false);
            txtTenTV.setEditable(false);
            txtPassTV.setEditable(false);
            txtEmailTV.setEditable(false);
            txtKhoaTV.setEditable(false);
            txtNganhTV.setEditable(false);
            txtSdtTV.setEditable(false);
            txtMaTV.setEnabled(false);
            txtTenTV.setEnabled(false);
            txtPassTV.setEnabled(false);
            txtEmailTV.setEnabled(false);
            txtKhoaTV.setEnabled(false);
            txtNganhTV.setEnabled(false);
            txtSdtTV.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFindTV = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lblchitiet = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaTV = new javax.swing.JTextField();
        txtTenTV = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPassTV = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEmailTV = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtKhoaTV = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtNganhTV = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtSdtTV = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setPreferredSize(new java.awt.Dimension(779, 580));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Thành viên");

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

        lblchitiet.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblchitiet.setText("Chi tiết thành viên");

        jLabel4.setText("Mã :");

        jLabel5.setText("Họ tên:");

        txtMaTV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaTVActionPerformed(evt);
            }
        });

        txtTenTV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenTVActionPerformed(evt);
            }
        });

        jLabel6.setText("Password:");

        jLabel7.setText("Email:");

        jLabel8.setText("Khoa:");

        txtKhoaTV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKhoaTVActionPerformed(evt);
            }
        });

        jLabel9.setText("Ngành:");

        jLabel10.setText("SĐT:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Chức năng");

        jButton2.setText("Thêm");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Sửa");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
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

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Tìm kiếm");

        jButton5.setText("Reset");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Import");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblchitiet)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtMaTV, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTenTV, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtKhoaTV, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNganhTV, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(40, 40, 40)
                        .addComponent(txtSdtTV, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassTV)
                            .addComponent(txtEmailTV))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtFindTV, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(63, 63, 63))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(317, 317, 317)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblchitiet)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSdtTV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtMaTV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtTenTV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtPassTV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtFindTV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtEmailTV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtKhoaTV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtNganhTV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4)
                            .addComponent(jButton5)
                            .addComponent(jButton6))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtMaTVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaTVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaTVActionPerformed

    private void txtTenTVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenTVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenTVActionPerformed

    private void txtKhoaTVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKhoaTVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKhoaTVActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        int i = jTable.getSelectedRow();
        if (i >= 0) {
            txtMaTV.setText(jTable.getModel().getValueAt(i, 0).toString());
            txtTenTV.setText(jTable.getModel().getValueAt(i, 1).toString());
            txtPassTV.setText(jTable.getModel().getValueAt(i, 2).toString());
            txtEmailTV.setText(jTable.getModel().getValueAt(i, 3).toString());
            txtSdtTV.setText(jTable.getModel().getValueAt(i, 4).toString());
            txtKhoaTV.setText(jTable.getModel().getValueAt(i, 5).toString());
            txtNganhTV.setText(jTable.getModel().getValueAt(i, 6).toString());
            TTSD tt = thongTinBLL.getTTSDByMaTV(Integer.parseInt(txtMaTV.getText()));
            if (tt == null) {

            }
        }
    }//GEN-LAST:event_jTableMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        String query = txtFindTV.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dtm);
        jTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked

    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        jButton2.setText("Thêm");
        jButton3.setText("Sửa");
        jButton3.setEnabled(true);
        jButton4.setEnabled(true);
        jButton2.setEnabled(true);
        txtMaTV.setText("");
        txtTenTV.setText("");
        txtPassTV.setText("");
        txtEmailTV.setText("");
        txtSdtTV.setText("");
        txtKhoaTV.setText("");
        txtNganhTV.setText("");
        txtMaTV.setEditable(false);
        txtTenTV.setEditable(false);
        txtPassTV.setEditable(false);
        txtEmailTV.setEditable(false);
        txtKhoaTV.setEditable(false);
        txtNganhTV.setEditable(false);
        txtSdtTV.setEditable(false);
        txtMaTV.setEnabled(false);
        txtTenTV.setEnabled(false);
        txtPassTV.setEnabled(false);
        txtEmailTV.setEnabled(false);
        txtKhoaTV.setEnabled(false);
        txtNganhTV.setEnabled(false);
        txtSdtTV.setEnabled(false);
        onload();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5MouseClicked
    public void reset() {
        jButton2.setText("Thêm");
        jButton3.setText("Sửa");
        jButton3.setEnabled(true);
        txtMaTV.setText("");
        txtTenTV.setText("");
        txtPassTV.setText("");
        txtEmailTV.setText("");
        txtSdtTV.setText("");
        txtKhoaTV.setText("");
        txtNganhTV.setText("");
        txtMaTV.setEditable(false);
        txtTenTV.setEditable(false);
        txtPassTV.setEditable(false);
        txtEmailTV.setEditable(false);
        txtKhoaTV.setEditable(false);
        txtNganhTV.setEditable(false);
        txtSdtTV.setEditable(false);
        txtMaTV.setEnabled(false);
        txtTenTV.setEnabled(false);
        txtPassTV.setEnabled(false);
        txtEmailTV.setEnabled(false);
        txtKhoaTV.setEnabled(false);
        txtNganhTV.setEnabled(false);
        txtSdtTV.setEnabled(false);
        onload();
    }
    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked

    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (txtMaTV.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chọn thành viên cần sửa.");
            return;
        }
        if (jButton3.getText().equals("Sửa")) {
            jButton3.setText("Lưu");
            jButton2.setEnabled(false);
            jButton4.setEnabled(false);
            txtMaTV.setEditable(false);
            txtTenTV.setEditable(true);
            txtPassTV.setEditable(true);
            txtEmailTV.setEditable(true);
            txtKhoaTV.setEditable(true);
            txtNganhTV.setEditable(true);
            txtSdtTV.setEditable(true);
            txtMaTV.setEnabled(false);
            txtTenTV.setEnabled(true);
            txtPassTV.setEnabled(true);
            txtEmailTV.setEnabled(true);
            txtKhoaTV.setEnabled(true);
            txtNganhTV.setEnabled(true);
            txtSdtTV.setEnabled(true);
        } else {

            int MaTV;
            String text = txtMaTV.getText();
            MaTV = Integer.parseInt(text);
            String Hoten = txtTenTV.getText();
            if (!Hoten.matches("[\\p{L} ]+")) {
                JOptionPane.showMessageDialog(this, "Tên thành viên chỉ được chứa các ký tự chữ cái.");
                return;
            }
            String Pass = txtPassTV.getText();
            String Email = txtEmailTV.getText();
            if (!isValidEmail(Email)) {
                JOptionPane.showMessageDialog(this, "Email không hợp lệ.");
                return;
            }
            if (isExistEmailEdit(Email, MaTV)) {
                JOptionPane.showMessageDialog(this, "Email đã tồn tại.");
                return;
            }

            String Khoa = txtKhoaTV.getText();
            String Nganh = txtNganhTV.getText();
            if (!Khoa.matches("[\\p{L} ]+")) {
                JOptionPane.showMessageDialog(this, "Khoa chỉ được chứa các ký tự chữ cái.");
                return;
            }

            if (!Nganh.matches("[\\p{L} ]+")) {
                JOptionPane.showMessageDialog(this, "Ngành chỉ được chứa các ký tự chữ cái.");
                return;
            }
            String sdt;
            String sdttext = txtSdtTV.getText();
            if (sdttext != null && !sdttext.isEmpty()) {
                if (sdttext.matches("(09|03|08|01)\\d{8}")) {
                    if (sdttext.matches("\\d{10}")) {
                        sdt = sdttext;

                        if (isExistPhoneNumberEdit(sdt, MaTV)) {
                            JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại.");
                            return;
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Số điện thoại phải có đúng 10 số.");
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ.");
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại.");
                return;
            }
            if (Hoten == "" || Pass == "" || Email == "" || Khoa == "" || Nganh == "") {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin.");
                return;
            } else {

                ThanhVien tv = new ThanhVien(MaTV, Pass, Hoten, Khoa, Nganh, Email, String.valueOf(sdt));
                thanhVienBLL.updateThanhVien(MaTV, tv);
                jButton3.setText("Sửa");
                jButton2.setEnabled(true);
                jButton4.setEnabled(true);
                JOptionPane.showMessageDialog(this, "Sửa thành công!");
                reset();

            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jButton2.getText().equals("Thêm")) {
            jButton2.setText("Lưu");
            jButton3.setEnabled(false);
            jButton4.setEnabled(false);
            lblchitiet.setText("Thêm thành viên");
            txtMaTV.setText("");
            txtTenTV.setText("");
            txtPassTV.setText("");
            txtEmailTV.setText("");
            txtSdtTV.setText("");
            txtKhoaTV.setText("");
            txtNganhTV.setText("");
            txtMaTV.setEditable(true);
            txtTenTV.setEditable(true);
            txtPassTV.setEditable(true);
            txtEmailTV.setEditable(true);
            txtKhoaTV.setEditable(true);
            txtNganhTV.setEditable(true);
            txtSdtTV.setEditable(true);
            txtMaTV.setEnabled(true);
            txtTenTV.setEnabled(true);
            txtPassTV.setEnabled(true);
            txtEmailTV.setEnabled(true);
            txtKhoaTV.setEnabled(true);
            txtNganhTV.setEnabled(true);
            txtSdtTV.setEnabled(true);
        } else {
            long MaTV;
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
                    MaTV = Long.parseLong(text);
                } else {
                    JOptionPane.showMessageDialog(this, "Mã thành viên không hợp lệ.");
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập mã thành viên.");
                return;
            }
            String Hoten = txtTenTV.getText();
            if (!Hoten.matches("[\\p{L} ]+")) {
                JOptionPane.showMessageDialog(this, "Tên thành viên chỉ được chứa các ký tự chữ cái.");
                return;
            }
            String Pass = txtPassTV.getText();
            String Email = txtEmailTV.getText();
            if (!isValidEmail(Email)) {
                JOptionPane.showMessageDialog(this, "Email không hợp lệ.");
                return;
            }
            if (isExistEmail(Email)) {
                JOptionPane.showMessageDialog(this, "Email đã tồn tại.");
                return;
            }
            String Khoa = txtKhoaTV.getText();
            String Nganh = txtNganhTV.getText();
            if (!Khoa.matches("[\\p{L} ]+")) {
                JOptionPane.showMessageDialog(this, "Khoa chỉ được chứa các ký tự chữ cái.");
                return;
            }

            if (!Nganh.matches("[\\p{L} ]+")) {
                JOptionPane.showMessageDialog(this, "Ngành chỉ được chứa các ký tự chữ cái.");
                return;
            }

            String sdt;
            String sdttext = txtSdtTV.getText();
            if (sdttext != null && !sdttext.isEmpty()) {
                if (sdttext.matches("(09|03|08|01)\\d{8}")) {
                    if (sdttext.matches("\\d{10}")) {
                        sdt = sdttext;

                        if (isExistPhoneNumber(sdt)) {
                            JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại.");
                            return;
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Số điện thoại phải có đúng 10 số.");
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ.");
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại.");
                return;
            }
            if (Hoten == "" || Pass == "" || Email == "" || Khoa == "" || Nganh == "") {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin.");
                return;
            } else {
                if (isValidMaTV(String.valueOf(MaTV))) {
                    if (!isExistMaTV(MaTV)) {
                        ThanhVien tv = new ThanhVien(MaTV, Pass, Hoten, Khoa, Nganh, Email, sdt);
                        thanhVienBLL.createUser(tv);
                        jButton2.setText("Thêm");
                        jButton3.setEnabled(true);
                        jButton4.setEnabled(true);
                        JOptionPane.showMessageDialog(this, "Thêm thành công!");
                        reset();
                    } else {
                        JOptionPane.showMessageDialog(this, "Mã thành viên đã tồn tại.");
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại!");
                    return;
                }
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (txtMaTV.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chọn thành viên cần xóa.");
            return;
        } else {
             int confirmation = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa thành viên này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
    if (confirmation == JOptionPane.YES_OPTION) {
        if (thanhVienBLL.deleteThanhVien(Integer.parseInt(txtMaTV.getText()))) {
            JOptionPane.showMessageDialog(this, "Xóa thành viên thành công.");
            reset();
        } else {
            JOptionPane.showMessageDialog(this, "Xóa thành viên thất bại vì có liên kết với khóa ngoại.");
            return;
        }
    } else {
        return;
    }
}
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    JFileChooser fileChooser = new JFileChooser();
fileChooser.setDialogTitle("Chọn file Excel");
FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files", "xlsx");
fileChooser.setFileFilter(filter);
int result = fileChooser.showOpenDialog(null);
if (result == JFileChooser.APPROVE_OPTION) {
    File selectedFile = fileChooser.getSelectedFile();
    String filePath = selectedFile.getAbsolutePath();
    System.out.println("Đường dẫn file đã chọn: " + filePath);

    List<ThanhVien> thanhVienList = new ArrayList<>();

    try (FileInputStream fileInputStream = new FileInputStream(filePath);
         Workbook workbook = new XSSFWorkbook(fileInputStream)) {

        Sheet sheet = workbook.getSheetAt(0);
        for (Row row : sheet) {
            Cell firstCell = row.getCell(0);
             if (firstCell == null || firstCell.getCellType() == CellType.BLANK) {
        continue; // Bỏ qua dòng nếu ô đầu tiên trong dòng là null hoặc trống
    }

    // Kiểm tra nếu MaTV = 0, bỏ qua dòng đó và tiếp tục với dòng tiếp theo
    if (firstCell.getCellType() == CellType.NUMERIC && firstCell.getNumericCellValue() == 0) {
        continue;
    }
            ThanhVien thanhVien = new ThanhVien(); // Khai báo biến thanhVien ở đây
            int cellIndex = 0;
            for (Cell cell : row) {
                if (row.getRowNum() == 0) {
                    continue;
                }
                switch (cellIndex) {
                    case 0:
                        thanhVien.setMaTV(Long.parseLong(getCellValueAsString(cell)));  
                        break;
                    case 1:
                        thanhVien.setHoTen(getCellValueAsString(cell));
                        break;
                    case 2:
                        thanhVien.setKhoa(getCellValueAsString(cell));
                        break;
                    case 3:
                        thanhVien.setNganh(getCellValueAsString(cell));
                        break;
                    case 4:
                        thanhVien.setSdt(getCellValueAsString(cell));
                        break;
                    case 5:
                        thanhVien.setPassword(getCellValueAsString(cell));
                        break;
                    case 6:
                        thanhVien.setEmail(getCellValueAsString(cell));
                        break;
                    default:
                        break;
                }
                cellIndex++;
            }
            thanhVienList.add(thanhVien);
        }
         thanhVienList.remove(0);
       for (ThanhVien thanhVien : thanhVienList) {
    System.out.println(thanhVien.toString());
}

        List listThanhVien = thanhVienBLL.loadThanhVien();
        Object[][] data = thanhVienBLL.convertList(listThanhVien);
        for (ThanhVien existing : thanhVienList) {
            boolean existed = false;
            for (int i=0 ;i<data.length;i++) { 
                if (existing.getMaTV() == (long)data[i][0]) {
                    existed = true;
                    break;
                }
            }

            if (existed) {
                int choice = JOptionPane.showConfirmDialog(null, "Mã thành viên: "+existing.getMaTV()+" đã tồn tại. Bạn muốn ghi đè không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    // Thêm thành viên mới vào danh sách
                    thanhVienBLL.updateThanhVien(existing.getMaTV(), existing);
                } else {
                    continue;
                }
            } else{
                thanhVienBLL.createUser(existing);
            } 
        }
      JOptionPane.showMessageDialog(this, "import thành viên thành công.");      
     
        
    } catch (IOException e) {
        e.printStackTrace();
    }
} else {
    System.out.println("Không có file được chọn.");
}

    }//GEN-LAST:event_jButton6ActionPerformed
    private String getCellValueAsString(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf((long) cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }
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

    private boolean isExistMaTV(long maTV) {
        List<ThanhVien> listThanhVien = thanhVienBLL.loadThanhVien();
        for (ThanhVien thanhVien : listThanhVien) {
            if (thanhVien.getMaTV() == maTV) {

                return true;
            }
        }
        return false;
    }

    private boolean isExistEmail(String email) {
        List<ThanhVien> listThanhVien = thanhVienBLL.loadThanhVien();
        for (ThanhVien thanhVien : listThanhVien) {
            if (thanhVien.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    private boolean isExistEmailEdit(String email, int maTV) {
        List<ThanhVien> listThanhVien = thanhVienBLL.loadThanhVien();
        for (ThanhVien thanhVien : listThanhVien) {
            if (thanhVien.getMaTV() != maTV && thanhVien.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    private boolean isExistPhoneNumber(String phoneNumber) {
        List<ThanhVien> listThanhVien = thanhVienBLL.loadThanhVien();
        for (ThanhVien thanhVien : listThanhVien) {
            if (thanhVien.getSdt().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    private boolean isExistPhoneNumberEdit(String phoneNumber, int maTV) {
        List<ThanhVien> listThanhVien = thanhVienBLL.loadThanhVien();
        for (ThanhVien thanhVien : listThanhVien) {
            if (thanhVien.getMaTV() != maTV && thanhVien.getSdt().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidEmail(String email) {
        // Biểu thức chính quy để kiểm tra định dạng email
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        // Kiểm tra sự trùng khớp với biểu thức chính quy
        return email.matches(regex);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblchitiet;
    private javax.swing.JTextField txtEmailTV;
    private javax.swing.JTextField txtFindTV;
    private javax.swing.JTextField txtKhoaTV;
    private javax.swing.JTextField txtMaTV;
    private javax.swing.JTextField txtNganhTV;
    private javax.swing.JTextField txtPassTV;
    private javax.swing.JTextField txtSdtTV;
    private javax.swing.JTextField txtTenTV;
    // End of variables declaration//GEN-END:variables
}
