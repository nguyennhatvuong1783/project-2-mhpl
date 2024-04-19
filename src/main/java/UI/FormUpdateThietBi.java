/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import BLL.ThietBiBLL;
import DAL.ThietBi;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author Tran Nhat Qui
 */
public class FormUpdateThietBi extends JFrame {
      private JTextField txtMaTB;
    private JTextField txtTenTB;
    private JTextField txtMoTa;
    private ThietBiBLL thietBiBLL;
    public FormUpdateThietBi(int id,String tenTB, String motaTB){
        init(id,tenTB,motaTB);
    }
    
    public void init(int id,String tenTB, String motaTB){
        thietBiBLL = new ThietBiBLL();
        JPanel inforPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(inforPanel, BoxLayout.X_AXIS);	
        inforPanel.setLayout(boxLayout);
        this.setLayout(new BorderLayout());
        this.setSize(550, 400);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        
	JLabel lblMaTB = new JLabel("     Mã thiết bị");
	JLabel lblTenTB = new JLabel("     Tên thiết bị");
	JLabel lblMoTa = new JLabel("     Mô tả");
        
        lblMaTB.setFont(new Font("Times New Roman", Font.BOLD, 16));
	lblTenTB.setFont(new Font("Times New Roman", Font.BOLD, 16));
	lblMoTa.setFont(new Font("Times New Roman", Font.BOLD, 16));
        
        JPanel pnlInfo = new JPanel(new GridBagLayout());
	GridBagConstraints gbclbl = new GridBagConstraints();
	GridBagConstraints gbctxt = new GridBagConstraints();
        
        txtMaTB = new JTextField();
	txtMaTB.setEditable(false);
        txtMaTB.setText(String.valueOf(id));
	txtTenTB = new JTextField();
        txtTenTB.setText(tenTB);
	txtMoTa = new JTextField();
        txtMoTa.setText(motaTB);
        
        gbclbl.ipadx = 9;
	gbclbl.ipady = 5;
        pnlInfo.add(lblMaTB, gbclbl);
	gbctxt.ipadx = 450;
	gbctxt.ipady = 10;
	gbctxt.gridx = 1;
	pnlInfo.add(txtMaTB, gbctxt);
	gbclbl.ipadx = 5;
	gbclbl.gridx = 0;
	gbclbl.gridy = 1;
	pnlInfo.add(lblTenTB, gbclbl);
	gbctxt.gridx = 1;
	pnlInfo.add(txtTenTB, gbctxt);
	gbclbl.ipadx = 21;
	gbclbl.gridx = 0;
	gbclbl.gridy = 2;
	pnlInfo.add(lblMoTa, gbclbl);
	gbctxt.gridx = 1;
	pnlInfo.add(txtMoTa, gbctxt);
	gbclbl.ipadx = 6;
	gbclbl.gridx = 0;
	gbclbl.gridy = 3;
        
        pnlInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        inforPanel.add(pnlInfo);
        
        JPanel panelChucNang = new JPanel(new FlowLayout(FlowLayout.CENTER,6,0));
	JButton btnThem = new JButton("Thêm");
	JButton btnHuy = new JButton("Hủy");
	panelChucNang.add(btnThem);
	panelChucNang.add(btnHuy);
        
        btnHuy.addActionListener(new ActionListener() {		
		@Override
		public void actionPerformed(ActionEvent e) {
		   	mouseClickHuy();
		}
	});
        
        btnThem.addActionListener(new ActionListener() {		
		@Override
		public void actionPerformed(ActionEvent e) {
		   	mouseClickThem();
		}
	});
        
        this.add(inforPanel,BorderLayout.CENTER);
	this.add(panelChucNang,BorderLayout.SOUTH);
	this.setVisible(true);
    }
    
    private void mouseClickHuy(){
        this.dispose();
    }
    
    private void mouseClickThem(){
        if(checkData()==true){
            ThietBi tb = new ThietBi(Integer.parseInt(txtMaTB.getText()),txtTenTB.getText(),txtMoTa.getText());
            thietBiBLL.updateCategory(tb);
            this.dispose();
        }
    }
    
    private Boolean checkData(){
        String tenTB = txtTenTB.getText();
	String moTa = txtMoTa.getText();
	if (moTa.trim().equals("")) {
		return showErr(txtTenTB, "Tên thiết bị không được để trống");	
	}else if (checkKyTuDacBiet(tenTB)== false) {
		return showErr(txtTenTB, "Tên thiết bị không được chứa ký tự đặc biệt");	
	}
        return true;
    }
        
    
    private Boolean checkKyTuDacBiet(String tenMA) {
	Pattern pattern = Pattern.compile("^.*[#?!@$%^&*-]+.*$");
	for(int i=0; i<tenMA.length(); i++) {
        	if (pattern.matcher(tenMA).find()) {
			return false;
		}
	}
	return true;
    }
    
    private Boolean showErr(JTextField tx, String erorr) {
	JOptionPane.showMessageDialog(tx, erorr);
	tx.requestFocus();
	return false;
    }
    
}
