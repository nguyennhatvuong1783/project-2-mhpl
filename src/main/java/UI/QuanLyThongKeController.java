package UI;
/**
 *
 * @author Tran Duc Thanh
 * MSSV 3121410451
 */
import java.awt.CardLayout;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone; 
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import BLL.ThongKeBLL;
import BLL.ThongKeBLLImpl;
import DAL.HibernateUtil;
import DAL.ThongKeDALImpl;
import DAL.ThongTinSD;
import DAL.XuLy;
import java.awt.Font;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;

public class QuanLyThongKeController {
    private ThongKeBLL tkBLL = null;
    private ThongKeDALImpl tkDALImpl = null;

    public QuanLyThongKeController() {
        this.tkDALImpl = new ThongKeDALImpl(HibernateUtil.getSessionFactory().openSession());
        this.tkBLL = new ThongKeBLLImpl(tkDALImpl);
    }

    //==========================================================================
    
    public void setDataToChart_ThanhVien_TGVao(JPanel jpnItem) {
        List<ThongTinSD> listItem = tkBLL.getListByThanhVien_TGVao();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (listItem != null) {
            for (ThongTinSD item : listItem) {
                SimpleDateFormat chartDateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");
                chartDateFormat.setTimeZone(TimeZone.getTimeZone("GMT")); 
                String chartDateTime = chartDateFormat.format(item.getTgVao());
                
                dataset.addValue(item.getSoluong(), "Thành viên", chartDateTime);
            }
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ thống kê số lượng thành viên vào khu học tập theo thời gian".toUpperCase(),
                "Thời gian", "Số lượng",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        barChart.getTitle().setFont(new Font("Arial", Font.BOLD, 20));
        CategoryPlot plot = barChart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setMaximumBarWidth(0.2);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 400));

        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }
    
    //==========================================================================
    
    public void setDataToChart_ThanhVien_Khoa(JPanel jpnItem) {
        List<ThongTinSD> listItem = tkBLL.getListByThanhVien_Khoa();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (listItem != null) {
            for (ThongTinSD item : listItem) {
                dataset.addValue(item.getSoluong(), "Thành viên", item.getKhoa());
            }
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ thống kê số lượng thành viên vào khu học tập theo khoa".toUpperCase(),
                "Khoa", "Số lượng",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        barChart.getTitle().setFont(new Font("Arial", Font.BOLD, 20));
        CategoryPlot plot = barChart.getCategoryPlot();
            BarRenderer renderer = (BarRenderer) plot.getRenderer();
            renderer.setMaximumBarWidth(0.2);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 400));

        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }

    //==========================================================================
    
    public void setDataToChart_ThanhVien_Nganh(JPanel jpnItem) {
        List<ThongTinSD> listItem = tkBLL.getListByThanhVien_Nganh();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (listItem != null) {
            for (ThongTinSD item : listItem) {
                dataset.addValue(item.getSoluong(), "Thành viên", item.getNganh());
            }
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ thống kê số lượng thành viên vào khu học tập theo ngành".toUpperCase(),
                "Ngành", "Số lượng",
                dataset, PlotOrientation.VERTICAL, false, true, false);
        
        barChart.getTitle().setFont(new Font("Arial", Font.BOLD, 20));
        CategoryPlot plot = barChart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setMaximumBarWidth(0.2);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 400));

        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }
    
    //==========================================================================
    
    public void setDataToChart_ThietBi_TGMuon(JPanel jpnItem) {
        List<ThongTinSD> listItem = tkBLL.getListByThietBi_TGMuon();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (listItem != null) {
            for (ThongTinSD item : listItem) {
                SimpleDateFormat chartDateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");
                chartDateFormat.setTimeZone(TimeZone.getTimeZone("GMT")); 
                String chartDateTime = chartDateFormat.format(item.getTgMuon());
                
                dataset.addValue(item.getSoluong(), "Thiết bị", chartDateTime);
            }
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ thống kê số lượng thiết bị đã được mượn theo thời gian".toUpperCase(),
                "Thời gian", "Số lượng",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        barChart.getTitle().setFont(new Font("Arial", Font.BOLD, 20));
        CategoryPlot plot = barChart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setMaximumBarWidth(0.2);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 400));

        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }
    
    //==========================================================================
    
    public void setDataToChart_ThietBi_LoaiTB(JPanel jpnItem) {
        List<ThongTinSD> listItem = tkBLL.getListByThietBi_Ten();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (listItem != null) {
            for (ThongTinSD item : listItem) {
                dataset.addValue(item.getSoluong(), "Thiết bị", item.getMoTaTB());
            }
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ thống kê số lượng thiết bị đã được mượn theo loại".toUpperCase(),
                "Loại thiết bị", "Số lượng",
                dataset, PlotOrientation.VERTICAL, false, true, false);
        
        barChart.getTitle().setFont(new Font("Arial", Font.BOLD, 20));
        CategoryPlot plot = barChart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setMaximumBarWidth(0.2);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 400));

        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }
    
    //==========================================================================
    
    public void setDataToChart_ViPham_DangXuLy(JPanel jpnItem) {
        List<XuLy> listItem = tkBLL.getListByViPham_DangXuLy();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (listItem != null) {
            for (XuLy item : listItem) {                
                dataset.addValue(item.getSoluong(), "Hình thức", item.getHinhThucXL());
            }
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ thống kê số lượng vi phạm đang xử lý theo hình thức".toUpperCase(),
                "Hình thức", "Số lượng",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        barChart.getTitle().setFont(new Font("Arial", Font.BOLD, 20));
        CategoryPlot plot = barChart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setMaximumBarWidth(0.2);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 400));

        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }
    
    //==========================================================================
    
    public void setDataToChart_ViPham_DaXuLy(JPanel jpnItem) {
        List<XuLy> listItem = tkBLL.getListByViPham_DaXuLy();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (listItem != null) {
            for (XuLy item : listItem) {                
                dataset.addValue(item.getSoluong(), "Hình thức", item.getHinhThucXL());
            }
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ thống kê số lượng vi phạm đã được xử lý theo hình thức".toUpperCase(),
                "Hình thức", "Số lượng",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        barChart.getTitle().setFont(new Font("Arial", Font.BOLD, 20));
        CategoryPlot plot = barChart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setMaximumBarWidth(0.2);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 400));

        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }
    
    //==========================================================================
    
    public void setDataToChart_ViPham_Tien(JPanel jpnItem) {
        List<XuLy> listItem = tkBLL.getListByViPham_Tien();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (listItem != null) {
            for (XuLy item : listItem) {                
                dataset.addValue(item.getSoTien(), "Số tiền", item.getHinhThucXL());
            }
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ thống kê số tiền bồi thường sau khi đã xử lý vi phạm".toUpperCase(),
                "Hình thức", "Số tiền",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        barChart.getTitle().setFont(new Font("Arial", Font.BOLD, 20));
        
        CategoryPlot plot = barChart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setMaximumBarWidth(0.2);
        
    
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 400));

        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }
}