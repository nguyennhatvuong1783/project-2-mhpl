package UI;

import javax.swing.*;
import java.awt.*;

public class ThongKeUI extends JPanel {
    
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelb;
    private javax.swing.JPanel jPanela;
    private javax.swing.JPanel jPanelc;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    
    QuanLyThongKeController controller = new QuanLyThongKeController();

    public ThongKeUI() {
        initComponents();
        
        controller.setDataToChart1(jPanel1);
        controller.setDataToChart4(jPanel2);     
        controller.setDataToChart6(jPanel3);
    }
    
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        Object selectedItem = jComboBox1.getSelectedItem();
        if (selectedItem != null) {
            String selectedOption = selectedItem.toString();
            if (selectedOption.equals("Đang xử lý")) {
                jPanel3.removeAll();
                jPanel4.removeAll();
                jPanel4.revalidate(); 
                jPanel4.repaint();

                controller.setDataToChart6(jPanel3);

            } else if (selectedOption.equals("Đã xử lý")) {
                jPanel3.removeAll();
                jPanel4.removeAll();
                jPanel4.revalidate(); 
                jPanel4.repaint();    

                controller.setDataToChart7(jPanel3);
                controller.setDataToChart8(jPanel4);
            }
        }
    }

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {       
        Object selectedItem = jComboBox2.getSelectedItem();
        if (selectedItem != null) {
            String selectedOption = selectedItem.toString();
            if (selectedOption.equals("Thời gian mượn")) {
                jPanel2.removeAll();
                jPanel2.revalidate(); 
                jPanel2.repaint();
                controller.setDataToChart4(jPanel2);

            } else if (selectedOption.equals("Loại thiết bị")) {
                jPanel2.removeAll();
                jPanel2.revalidate(); 
                jPanel2.repaint();
                controller.setDataToChart5(jPanel2);
            }
        }
    }                                          

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {   
        Object selectedItem = jComboBox3.getSelectedItem();
        if (selectedItem != null) {
            String selectedOption = selectedItem.toString();
            if (selectedOption.equals("Thời gian vào")) {
                jPanel1.removeAll();
                jPanel1.revalidate(); 
                jPanel1.repaint();
                controller.setDataToChart1(jPanel1);

            } else if (selectedOption.equals("Khoa")) {
                jPanel1.removeAll();
                jPanel1.revalidate(); 
                jPanel1.repaint();
                controller.setDataToChart2(jPanel1);
            }
            else if (selectedOption.equals("Ngành")){
                jPanel1.removeAll();
                jPanel1.revalidate(); 
                jPanel1.repaint();
                controller.setDataToChart3(jPanel1);
            }
        }
    }                       

     
    
    public void initComponents() {
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanelc = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanelb = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jPanela = new javax.swing.JPanel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();


        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang xử lý", "Đã xử lý" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jPanel3.setPreferredSize(new java.awt.Dimension(726, 273));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 740, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 273, Short.MAX_VALUE)
        );

        jPanel4.setPreferredSize(new java.awt.Dimension(726, 273));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 738, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 273, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelcLayout = new javax.swing.GroupLayout(jPanelc);
        jPanelc.setLayout(jPanelcLayout);
        jPanelcLayout.setHorizontalGroup(
            jPanelcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelcLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelcLayout.createSequentialGroup()
                .addGroup(jPanelcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 123, Short.MAX_VALUE))
        );
        jPanelcLayout.setVerticalGroup(
            jPanelcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelcLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(420, Short.MAX_VALUE))
        );

        jScrollPane4.setViewportView(jPanelc);

        jTabbedPane1.addTab("Xử lý vi phạm", jScrollPane4);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thời gian mượn", "Loại thiết bị" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jPanel2.setPreferredSize(new java.awt.Dimension(726, 273));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 273, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanelb);
        jPanelb.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(563, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(352, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thiết bị", jPanelb);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thời gian vào", "Khoa", "Ngành" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(726, 273));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 273, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanela);
        jPanela.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(563, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(352, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thành viên", jPanela);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
        );
    }                       
}

