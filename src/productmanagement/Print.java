package productmanagement;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Print {
  public static void printPanel(JPanel panel) {
    // Create PrinterJob
    PrinterJob printerJob = PrinterJob.getPrinterJob();
    // Set PrinterJob name
    printerJob.setJobName("Print panel");
    // Set printable
    printerJob.setPrintable(new Printable() {
      @Override
      public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        // Check if there is printable content
        if (pageIndex > 0) {
          return Printable.NO_SUCH_PAGE;
        }

        // Make 2D graphics to map content
        Graphics2D graphics2d = (Graphics2D)graphics;
        // Set graphics translation
        graphics2d.translate(pageFormat.getImageableX() * 2, pageFormat.getImageableY() * 2);
        // Scales the page
        graphics2d.scale(0.5, 0.5);

        // Paint panel as graphics2d
        panel.paint(graphics2d);

        // Return if page exists
        return Printable.PAGE_EXISTS;
      }
    });
    // Store printerDialog
    boolean printResults = printerJob.printDialog();
    // Check if dialog is showing
    if (printResults) {
      try {
        // Call the print method
        printerJob.print();
      } catch (PrinterException e) {
        JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Alert", JOptionPane.WARNING_MESSAGE);
      }
    }
  }
}
