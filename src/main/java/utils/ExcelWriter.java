package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;

public class ExcelWriter {

    public static void writePriceReport(String product, int amazon, int flipkart, int croma, int lowest) {

        try (Workbook workbook = new XSSFWorkbook()) {

            Sheet sheet = workbook.createSheet("Price Report");

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Website");
            header.createCell(1).setCellValue("Price");

            Row row1 = sheet.createRow(1);
            row1.createCell(0).setCellValue("Amazon");
            row1.createCell(1).setCellValue(amazon);

            Row row2 = sheet.createRow(2);
            row2.createCell(0).setCellValue("Flipkart");
            row2.createCell(1).setCellValue(flipkart);

            Row row3 = sheet.createRow(3);
            row3.createCell(0).setCellValue("Croma");
            row3.createCell(1).setCellValue(croma);

            Row lowestRow = sheet.createRow(5);
            lowestRow.createCell(0).setCellValue("Lowest Price");
            lowestRow.createCell(1).setCellValue(lowest);

            FileOutputStream out = new FileOutputStream("PriceComparisonReport.xlsx");
            workbook.write(out);
            out.close();

            System.out.println("Excel Report Generated Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
