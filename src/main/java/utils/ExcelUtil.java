package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;

public class ExcelUtil {

    private static Workbook workbook;
    private static Sheet sheet;
    private static int rowNumber = 0;

    static {
        try {
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet("Price Comparison");

            new File("reports").mkdirs();

            Row header = sheet.createRow(rowNumber++);
            header.createCell(0).setCellValue("Product");
            header.createCell(1).setCellValue("Flipkart");
            header.createCell(2).setCellValue("Amazon");
            header.createCell(3).setCellValue("Croma");
            header.createCell(4).setCellValue("Status");
            header.createCell(5).setCellValue("Screenshot");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveToExcel(String product,
                                   int flipkart,
                                   int amazon,
                                   int croma,
                                   String screenshot) {

        Row row = sheet.createRow(rowNumber++);

        row.createCell(0).setCellValue(product);
        row.createCell(1).setCellValue(flipkart == -1 ? "NA" : String.valueOf(flipkart));
        row.createCell(2).setCellValue(amazon == -1 ? "NA" : String.valueOf(amazon));
        row.createCell(3).setCellValue(croma == -1 ? "NA" : String.valueOf(croma));

        String status;
        if (flipkart == -1 && amazon == -1 && croma == -1) {
            status = "FAIL";
        } else if (flipkart == -1 || amazon == -1 || croma == -1) {
            status = "PARTIAL";
        } else {
            status = "PASS";
        }

        row.createCell(4).setCellValue(status);
        row.createCell(5).setCellValue(screenshot == null ? "NA" : screenshot);

        try (FileOutputStream fos =
                     new FileOutputStream("reports/PriceComparisonReport.xlsx")) {
            workbook.write(fos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}