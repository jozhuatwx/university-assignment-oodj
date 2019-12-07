package productmanagement;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Print {
  // Keeps all the Pages in the Catalogue information
  public static ArrayList<ProductCataloguePage> pages = new ArrayList<>();
  public static ArrayList<JPanel> printPages = new ArrayList<>();

  public static void printCatalogue(ProductCatalogue catalogue) {
    // Clear the array
    pages.clear();
    printPages.clear();

    // Get pages in Catalogue
    ArrayList<String> pageArray = ReadObject.readArray(ProductCataloguePage.FILE_NAME);

    // Iterate through the Page array
    for (String pageDetails : pageArray) {
      // Split line into array
      String[] details = pageDetails.split(";");
      // Create a Product Catalogue Page object with the details
      ProductCataloguePage page = new ProductCataloguePage(details);
      // Find the Pages with the matching Product Catalogue Id and is active
      if (page.getPageCatalogueId().equalsIgnoreCase(catalogue.getCatalogueId()) && page.getPageStatus().equalsIgnoreCase(ProductCataloguePage.ACTIVE)) {
        pages.add(page);
      }
    }

    // Sort the Pages
    Collections.sort(pages, ProductCataloguePage.pageComparator);

    for (int i = 0; i < pages.size(); i++) {
      // Create a Panel object
      JPanel panel = new JPanel();
      panel.setBackground(new Color(255, 255, 255));
      panel.setSize(new Dimension(420, 610));
      panel.setLayout(new java.awt.BorderLayout());

      // Set New Page Number
      pages.get(i).setPageNumber(i + 1);
      
      // Convert Page to JPanel and add it to the Pages array list
      if (i >= 1) {
        ProductCatalogueTemplate template = new ProductCatalogueTemplate(catalogue, pages.get(i));
        template.setSize(template.getPreferredSize());
        panel.add(template);
        printPages.add(panel);
      } else {
        ProductCatalogueFirstPageTemplate template = new ProductCatalogueFirstPageTemplate(catalogue, pages.get(i));
        template.setSize(template.getPreferredSize());
        panel.add(template);
        printPages.add(panel);
      }
    }

    printCataloguePage(printPages, catalogue);
  }

  private static void printCataloguePage(ArrayList<JPanel> panels, ProductCatalogue catalogue) {
    // Create PrinterJob
    PrinterJob printerJob = PrinterJob.getPrinterJob();
    // Set PrinterJob name
    printerJob.setJobName("Printing " + catalogue.getCatalogueTitle() + " (" + catalogue.getCatalogueId() + ")");
    // Set printable
    printerJob.setPrintable(new Printable() {
      @Override
      public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex < panels.size()) {
          // graphics.drawImage(panels.get(pageIndex), 0, 0, null);

          // Make 2D graphics to map content
          Graphics2D graphics2d = (Graphics2D)graphics;
          // Set graphics translation
          graphics2d.translate(pageFormat.getImageableX() * 2, pageFormat.getImageableY() * 2);
          // Scales the page
          graphics2d.scale(pageFormat.getWidth() / panels.get(pageIndex).getWidth(), pageFormat.getHeight() / panels.get(pageIndex).getHeight());

          // Paint panel as graphics2d
          panels.get(pageIndex).paint(graphics2d);

          // Return if page exists
          return Printable.PAGE_EXISTS;
        } else {
        return Printable.NO_SUCH_PAGE;
        }
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
        JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
      }
    }
  }
}
