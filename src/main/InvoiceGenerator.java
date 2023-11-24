package main;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.awt.Desktop;
import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;

public class InvoiceGenerator {

    public static void main(String[] args) {
        generateInvoice();
    }

    private static void generateInvoice() {
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);

        try {
            PdfWriter.getInstance(document, new FileOutputStream("src/image/hoadonmoi.pdf"));
            document.open();

            // Tiêu đề Hóa đơn
            Paragraph title = new Paragraph("HOA DON", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18));
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            // Thông tin khách hàng
            addCustomerInfo(document);

            // Thêm một đối tượng LineSeparator để phân chia thông tin khách hàng và thông tin hóa đơn
            LineSeparator line = new LineSeparator();
            line.setLineColor(new BaseColor(0, 0, 0, 68));
            document.add(new Chunk(line));

            // Thông tin hóa đơn
            addInvoiceInfo(document);

            // Cuối cùng, thêm một đối tượng LineSeparator để kết thúc hóa đơn
            document.add(new Chunk(line));

            // Thêm lời cảm ơn
            Paragraph thankYou = new Paragraph("Cam on quy khach!", FontFactory.getFont(FontFactory.HELVETICA, 12));
            thankYou.setAlignment(Element.ALIGN_CENTER);
            document.add(thankYou);

            document.close();

            // Mở hóa đơn đã tạo
            openGeneratedInvoice();
        } catch (DocumentException | IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void addCustomerInfo(Document document) throws DocumentException {
        PdfPTable customerTable = new PdfPTable(2);
        customerTable.setWidthPercentage(100);
        customerTable.setSpacingBefore(20);
        customerTable.setSpacingAfter(20);

        PdfPCell cell;

        cell = new PdfPCell(new Paragraph("Ten khach hang:", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
        customerTable.addCell(cell);
        cell = new PdfPCell(new Paragraph("John Doe"));  // Thay "John Doe" bằng tên khách hàng thực tế
        customerTable.addCell(cell);

        cell = new PdfPCell(new Paragraph("Phone:", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
        customerTable.addCell(cell);
        cell = new PdfPCell(new Paragraph("123456789"));  // Thay "123456789" bằng số điện thoại thực tế
        customerTable.addCell(cell);

        cell = new PdfPCell(new Paragraph("Address:", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
        customerTable.addCell(cell);
        cell = new PdfPCell(new Paragraph("123 Main St, City"));  // Thay "123 Main St, City" bằng địa chỉ thực tế
        customerTable.addCell(cell);

        document.add(customerTable);
    }

    private static void addInvoiceInfo(Document document) throws DocumentException {
        PdfPTable invoiceTable = new PdfPTable(3);
        invoiceTable.setWidthPercentage(100);
        invoiceTable.setSpacingBefore(20);
        invoiceTable.setSpacingAfter(20);

        PdfPCell cell;

        cell = new PdfPCell(new Paragraph("Ten san pham", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
        invoiceTable.addCell(cell);

        cell = new PdfPCell(new Paragraph("So luong", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
        invoiceTable.addCell(cell);

        cell = new PdfPCell(new Paragraph("Gia", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
        invoiceTable.addCell(cell);

        // Thêm dữ liệu sản phẩm (ví dụ)
        addProductRow(invoiceTable, "Sản phẩm 1", 2, 50.0);
        addProductRow(invoiceTable, "Sản phẩm 2", 1, 30.0);

        document.add(invoiceTable);
    }

    private static void addProductRow(PdfPTable table, String productName, int quantity, double price) {
        table.addCell(productName);
        table.addCell(String.valueOf(quantity));
        table.addCell(String.valueOf(price));
    }

    private static void openGeneratedInvoice() {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().open(new File("src/image/hoadonmoi.pdf"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
