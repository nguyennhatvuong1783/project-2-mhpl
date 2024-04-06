package UI;

import javax.swing.*;
import java.awt.*;

public class ThongKeUI extends JPanel {
    
    private javax.swing.JComboBox<String> XuLyCbx;
    private javax.swing.JComboBox<String> ThietBiCbx;
    private javax.swing.JComboBox<String> ThanhVienCbx;
    private javax.swing.JPanel TGVao_Khoa_Nganh_Pnl;
    private javax.swing.JPanel TGMuon_LoaiTB_Pnl;
    private javax.swing.JPanel DangXL_DaXL_Pnl;
    private javax.swing.JPanel SoTienViPham_Pnl;
    private javax.swing.JPanel ThietBiPnl;
    private javax.swing.JPanel ThanhVienPnl;
    private javax.swing.JPanel XuLyPnl;
    private javax.swing.JScrollPane XuLyScrollPane;
    private javax.swing.JTabbedPane ThongKeTabbedPane1;
    
    QuanLyThongKeController controller = new QuanLyThongKeController();

    public ThongKeUI() {
        initComponents();
        
        controller.setDataToChart_ThanhVien_TGVao(TGVao_Khoa_Nganh_Pnl);
        controller.setDataToChart_ThietBi_TGMuon(TGMuon_LoaiTB_Pnl);     
        controller.setDataToChart_ViPham_DangXuLy(DangXL_DaXL_Pnl);
    }
    
    //==========================================================================
    
    private void XuLyCbxActionPerformed(java.awt.event.ActionEvent evt) {                                           
        Object selectedItem = XuLyCbx.getSelectedItem();
        if (selectedItem != null) {
            String selectedOption = selectedItem.toString();
            if (selectedOption.equals("Đang xử lý")) {
                DangXL_DaXL_Pnl.removeAll();
                SoTienViPham_Pnl.removeAll();
                SoTienViPham_Pnl.revalidate(); 
                SoTienViPham_Pnl.repaint();

                controller.setDataToChart_ViPham_DangXuLy(DangXL_DaXL_Pnl);

            } else if (selectedOption.equals("Đã xử lý")) {
                DangXL_DaXL_Pnl.removeAll();
                SoTienViPham_Pnl.removeAll();
                SoTienViPham_Pnl.revalidate(); 
                SoTienViPham_Pnl.repaint();    

                controller.setDataToChart_ViPham_DaXuLy(DangXL_DaXL_Pnl);
                controller.setDataToChart_ViPham_Tien(SoTienViPham_Pnl);
            }
        }
    }

    //==========================================================================
    
    private void ThietBiCbxActionPerformed(java.awt.event.ActionEvent evt) {       
        Object selectedItem = ThietBiCbx.getSelectedItem();
        if (selectedItem != null) {
            String selectedOption = selectedItem.toString();
            if (selectedOption.equals("Thời gian mượn")) {
                TGMuon_LoaiTB_Pnl.removeAll();
                TGMuon_LoaiTB_Pnl.revalidate(); 
                TGMuon_LoaiTB_Pnl.repaint();
                controller.setDataToChart_ThietBi_TGMuon(TGMuon_LoaiTB_Pnl);

            } else if (selectedOption.equals("Loại thiết bị")) {
                TGMuon_LoaiTB_Pnl.removeAll();
                TGMuon_LoaiTB_Pnl.revalidate(); 
                TGMuon_LoaiTB_Pnl.repaint();
                controller.setDataToChart_ThietBi_LoaiTB(TGMuon_LoaiTB_Pnl);
            }
        }
    }                                          

    //==========================================================================
    
    private void ThanhVienCbxActionPerformed(java.awt.event.ActionEvent evt) {   
        Object selectedItem = ThanhVienCbx.getSelectedItem();
        if (selectedItem != null) {
            String selectedOption = selectedItem.toString();
            if (selectedOption.equals("Thời gian vào")) {
                TGVao_Khoa_Nganh_Pnl.removeAll();
                TGVao_Khoa_Nganh_Pnl.revalidate(); 
                TGVao_Khoa_Nganh_Pnl.repaint();
                controller.setDataToChart_ThanhVien_TGVao(TGVao_Khoa_Nganh_Pnl);

            } else if (selectedOption.equals("Khoa")) {
                TGVao_Khoa_Nganh_Pnl.removeAll();
                TGVao_Khoa_Nganh_Pnl.revalidate(); 
                TGVao_Khoa_Nganh_Pnl.repaint();
                controller.setDataToChart_ThanhVien_Khoa(TGVao_Khoa_Nganh_Pnl);
            }
            else if (selectedOption.equals("Ngành")){
                TGVao_Khoa_Nganh_Pnl.removeAll();
                TGVao_Khoa_Nganh_Pnl.revalidate(); 
                TGVao_Khoa_Nganh_Pnl.repaint();
                controller.setDataToChart_ThanhVien_Nganh(TGVao_Khoa_Nganh_Pnl);
            }
        }
    }                       

     
    //==========================================================================
    
    
    public void initComponents() {
        
        ThongKeTabbedPane1 = new javax.swing.JTabbedPane();
        XuLyScrollPane = new javax.swing.JScrollPane();
        
        XuLyPnl = new javax.swing.JPanel();
        XuLyCbx = new javax.swing.JComboBox<>();
        DangXL_DaXL_Pnl = new javax.swing.JPanel();
        SoTienViPham_Pnl = new javax.swing.JPanel();
        
        ThietBiPnl = new javax.swing.JPanel();
        ThietBiCbx = new javax.swing.JComboBox<>();
        TGMuon_LoaiTB_Pnl = new javax.swing.JPanel();
        
        ThanhVienPnl = new javax.swing.JPanel();
        ThanhVienCbx = new javax.swing.JComboBox<>();
        TGVao_Khoa_Nganh_Pnl = new javax.swing.JPanel();
        
        
    //==========================================================================
    
        ThanhVienCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thời gian vào", "Khoa", "Ngành" }));
        ThanhVienCbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThanhVienCbxActionPerformed(evt);
            }
        });

        TGVao_Khoa_Nganh_Pnl.setPreferredSize(new java.awt.Dimension(726, 273));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(TGVao_Khoa_Nganh_Pnl);
        TGVao_Khoa_Nganh_Pnl.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 273, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(ThanhVienPnl);
        ThanhVienPnl.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ThanhVienCbx, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(563, Short.MAX_VALUE))
            .addComponent(TGVao_Khoa_Nganh_Pnl, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(ThanhVienCbx, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(TGVao_Khoa_Nganh_Pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(352, Short.MAX_VALUE))
        );

        ThongKeTabbedPane1.addTab("Thành viên", ThanhVienPnl);

    //==========================================================================
    
        ThietBiCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thời gian mượn", "Loại thiết bị" }));
        ThietBiCbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThietBiCbxActionPerformed(evt);
            }
        });

        TGMuon_LoaiTB_Pnl.setPreferredSize(new java.awt.Dimension(726, 273));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(TGMuon_LoaiTB_Pnl);
        TGMuon_LoaiTB_Pnl.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 273, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(ThietBiPnl);
        ThietBiPnl.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ThietBiCbx, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(563, Short.MAX_VALUE))
            .addComponent(TGMuon_LoaiTB_Pnl, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(ThietBiCbx, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(TGMuon_LoaiTB_Pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(352, Short.MAX_VALUE))
        );

        ThongKeTabbedPane1.addTab("Thiết bị", ThietBiPnl);

    //==========================================================================
    
        XuLyScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        XuLyCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang xử lý", "Đã xử lý" }));
        XuLyCbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XuLyCbxActionPerformed(evt);
            }
        });

        DangXL_DaXL_Pnl.setPreferredSize(new java.awt.Dimension(726, 273));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(DangXL_DaXL_Pnl);
        DangXL_DaXL_Pnl.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 740, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 273, Short.MAX_VALUE)
        );

        DangXL_DaXL_Pnl.setPreferredSize(new java.awt.Dimension(726, 273));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(SoTienViPham_Pnl);
        SoTienViPham_Pnl.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 738, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 273, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelcLayout = new javax.swing.GroupLayout(XuLyPnl);
        XuLyPnl.setLayout(jPanelcLayout);
        jPanelcLayout.setHorizontalGroup(
            jPanelcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelcLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(XuLyCbx, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelcLayout.createSequentialGroup()
                .addGroup(jPanelcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DangXL_DaXL_Pnl, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SoTienViPham_Pnl, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 123, Short.MAX_VALUE))
        );
        jPanelcLayout.setVerticalGroup(
            jPanelcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelcLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(XuLyCbx, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(DangXL_DaXL_Pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SoTienViPham_Pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(420, Short.MAX_VALUE))
        );

        XuLyScrollPane.setViewportView(XuLyPnl);

        ThongKeTabbedPane1.addTab("Xử lý vi phạm", XuLyScrollPane);

    //==========================================================================
    
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ThongKeTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ThongKeTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
        );
    }                       
}

