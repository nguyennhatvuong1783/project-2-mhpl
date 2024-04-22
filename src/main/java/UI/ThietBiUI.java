/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import BLL.ThietBiBLL;
import DAL.ThietBi;
import UI.FormAddThietBi;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Nguyen Nhat Vuong
 */
public class ThietBiUI extends JPanel{
    private ThietBiBLL thietBiBLL;
    
    List list, insList, courseList;
    DefaultTableModel dtm;
    private TableRowSorter<TableModel> rowSorter;
    
    private JPanel pnlControl, pnlSearch, pnlContent, pnlButton;
    private JTable tb;
    private JScrollPane sp;
    private JTextField txtSearch;
    private JButton btnAdd, btnUpdate, btnDelete, btnReset, btnSearch, btnImport;
    
    public ThietBiUI() {
        thietBiBLL = new ThietBiBLL();
        initComponents();
    }
    
    public void initComponents() {
        pnlControl = new JPanel();
        pnlSearch = new JPanel();
        txtSearch = new JTextField();
        btnSearch = new JButton();
        pnlContent = new JPanel();
        pnlButton = new JPanel();
        btnAdd = new JButton();
        btnUpdate = new JButton();
        btnDelete = new JButton();
        btnReset = new JButton();
        btnImport = new JButton();
        sp = new JScrollPane();
        tb = new JTable();
        
        this.setLayout(new BorderLayout());

        pnlControl.setLayout(new GridLayout(3, 1));

        pnlSearch.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        txtSearch.setPreferredSize(new Dimension(300, 30));
        pnlSearch.add(txtSearch);

        btnSearch.setText("Search");
        btnSearch.setPreferredSize(new Dimension(100, 30));
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventSearch();
            }
        });
        pnlSearch.add(btnSearch);

        pnlControl.add(pnlSearch);

        pnlContent.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));

      
        pnlControl.add(pnlContent);

        pnlButton.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));

        btnAdd.setText("Add");
        btnAdd.setPreferredSize(new Dimension(100, 30));
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               FormAddThietBi fat = new FormAddThietBi();
            }
        });
        pnlButton.add(btnAdd);

        btnUpdate.setText("Update");
        btnUpdate.setPreferredSize(new Dimension(100, 30));
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventUpdate();
            }
        });
        pnlButton.add(btnUpdate);

        btnDelete.setText("Delete");
        btnDelete.setPreferredSize(new Dimension(100, 30));
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               eventDelete();
            }
        });
        pnlButton.add(btnDelete);

        btnReset.setText("Reset");
        btnReset.setPreferredSize(new Dimension(100, 30));
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dtm.setRowCount(0);
                dtm = loadCategoryTable();
                tb.setModel(dtm);
            }
        });
        pnlButton.add(btnReset);
        
        btnImport.setText("Import");
        btnImport.setPreferredSize(new Dimension(100, 30));
        btnImport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        pnlButton.add(btnImport);

        pnlControl.add(pnlButton);

        add(pnlControl, BorderLayout.NORTH);

        dtm = loadCategoryTable();
        tb.setAutoCreateRowSorter(true);
        tb.setModel(dtm);
        tb.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tb.getTableHeader().setPreferredSize(new Dimension(sp.getWidth(), 25));
        tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tb.setRowHeight(20);
        
        rowSorter = new TableRowSorter<>(tb.getModel());
        tb.setRowSorter(rowSorter);
        sp.setViewportView(tb);
        add(sp, BorderLayout.CENTER);
    }

    public DefaultTableModel loadCategoryTable() {
        List listThietBi = thietBiBLL.loadThietBi();
        Object[][] datamodel;
        datamodel = thietBiBLL.convertList(listThietBi);
        String[] title = {"Mã thiết bị", "Tên thiết bị", "Mô tả"};
        DefaultTableModel model = new DefaultTableModel(datamodel, title);
        return model;
    }
    
    private void eventDelete(){
         int index = tb.getSelectedRow();
         if(index == -1){
             JOptionPane.showMessageDialog(this, "Vui lòng chọn thiết bị cần xóa");
         }else{
             if(JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa thiết bị", "Chú ý", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
                 int maTb = Integer.parseInt(String.valueOf(tb.getValueAt(index, 0)));
                 ThietBi t = thietBiBLL.getCategory(maTb);
                 thietBiBLL.deleteCategory(t);
                 JOptionPane.showMessageDialog(this, "Xóa thành công");
                 dtm.setRowCount(0);
                 dtm = loadCategoryTable();
                 tb.setModel(dtm);
             }
         }      
    }
    
    private void eventUpdate(){
         int index = tb.getSelectedRow();
         if(index == -1){
             JOptionPane.showMessageDialog(this, "Vui lòng chọn thiết bị cần sửa");
         }else{
             if(JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn sửa thiết bị", "Chú ý", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
                int maTb = Integer.parseInt(String.valueOf(tb.getValueAt(index, 0)));
                String tenTb = String.valueOf( tb.getValueAt(index, 1));
                String motaTb = String.valueOf( tb.getValueAt(index, 2));
                FormUpdateThietBi t = new FormUpdateThietBi(maTb,tenTb, motaTb);
             }
         }      
    }
    
    private void eventSearch(){
        String input = txtSearch.getText();
        dtm.setRowCount(0);
        dtm = loadCategorySearch(input);
        tb.setModel(dtm);
    }
    
      public DefaultTableModel loadCategorySearch(String input) {
        List listThietBi = thietBiBLL.searchCategory(input);
        Object[][] datamodel;
        datamodel = thietBiBLL.convertList(listThietBi);
        String[] title = {"Mã thiết bị", "Tên thiết bị", "Mô tả"};
        DefaultTableModel model = new DefaultTableModel(datamodel, title);
        return model;
    }
    

  

}
