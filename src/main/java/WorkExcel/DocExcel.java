package WorkExcel;

import DAL.ThietBi;
import java.awt.FileDialog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import BLL.ThietBiBLL;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class DocExcel {
    FileDialog fd = new FileDialog(new JFrame(),"Đọc excel", FileDialog.LOAD );
    public DocExcel() {
    }

    private String getFile() {
            fd.setFile("*.xlsx");
            fd.setVisible(true);
            String url = fd.getDirectory() + fd.getFile();
        if (url.equals("nullnull")) {
           return null;
        }
        return url;
    }

    // Đọc file excel món ăn
    public void docFileExcelMonAn(ThietBiBLL tbBll) {
        fd.setTitle("Nhập dữ liệu thiết bị");
        String url = getFile();
        if (url == null) {
                return;
        }

        FileInputStream inputStream = null;
        try {
                inputStream = new FileInputStream(new File(url));

                Workbook workbook = new XSSFWorkbook(inputStream);
                Sheet sheet = workbook.getSheetAt(0);
                Iterator<Row> rowIterator = sheet.iterator();
                Row row1 = rowIterator.next();

                String hanhDongKhiTrung = "";
                int countThem = 0;
                int countGhiDe = 0;
                int countBoQua = 0;

        while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
        Iterator<Cell> cellIterator = row.cellIterator();

        while (cellIterator.hasNext()) {
             int maTB =  (int) cellIterator.next().getNumericCellValue();
             String tenTB = cellIterator.next().getStringCellValue();
             String moTa = cellIterator.next().getStringCellValue();
     
             DefaultTableModel defaultTableModel = new DefaultTableModel();
             ThietBi thietbiOld = tbBll.getCategory(maTB);
             if (thietbiOld != null) {
                if (!hanhDongKhiTrung.contains("Tất cả")) {
                    JTable table = new JTable();
                    String[] title = {" ","Mã thiết bị","Tên thiết bị","Mô tả"};
                    defaultTableModel.addRow(new String[] {
                        "Cũ",
                        String.valueOf(thietbiOld.getMaTB()),
                        thietbiOld.getTenTB(),
                        thietbiOld.getMoTaTB()
                        });
                    defaultTableModel.addRow(new String[] {
                        "Mới",
                        String.valueOf(maTB),
                        tenTB,
                        moTa
                         });
              resizeColumnWidth(table);

            MyJOptionPane mop = new MyJOptionPane(table, hanhDongKhiTrung);
            hanhDongKhiTrung = mop.getAnswer();
               }
                if (hanhDongKhiTrung.contains("Ghi đè")) {
                    ThietBi thietBiNew = new ThietBi(maTB, tenTB, moTa);
                    tbBll.updateCategory(thietBiNew);
                    countGhiDe++;
                }else {
                    countBoQua++;
                }
         }else {
             ThietBi thietBiNew = new ThietBi(maTB, tenTB, moTa);
             tbBll.createCategory(thietBiNew);
            countThem++;
          }

     }

}
        JOptionPane.showMessageDialog(null, "Đọc thành công, "
            + "Thêm " + countThem
            + "; Ghi đè " + countGhiDe
            + "; Bỏ qua " + countBoQua
            + ". Vui lòng làm mới để thấy kết quả");

        } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Lỗi khi nhập dữ liệu từ file: " + e.getMessage());
        }finally {
    try {
        if (inputStream != null) {
            inputStream.close();
        }
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, "Lỗi khi đóng inputstream: " + ex.getMessage());
    }
}
}
    
    public void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }

            width += 15;
            columnModel.getColumn(column).setPreferredWidth(width);
        }
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }

    
}
