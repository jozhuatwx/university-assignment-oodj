package productmanagement;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ProductCataloguePageForm extends javax.swing.JFrame {
    MainForm main;
    ProductCataloguePanel cataloguePanel;

    // Keeps the Catalogue information
    private ProductCatalogue catalogue;
    // Keeps all the Pages in the Catalogue information
    private ArrayList<ProductCataloguePage> pages = new ArrayList<>();

    // Keeps track of the Page Number
    private int pageNumber = 1;

    // Keeps track of modification
    private boolean modified = false;

    private ProductCataloguePage getCurrentPage() {
        return pages.get(pageNumber - 1);
    }

    private int xMouse, yMouse;

    public ProductCataloguePageForm(MainForm main, ProductCataloguePanel cataloguePanel, ProductCatalogue catalogue) {
        initComponents();
        this.main = main;
        this.cataloguePanel = cataloguePanel;
        this.catalogue = catalogue;
        getPages();

        resetPageNumbers();
        resetItem();
        resetFields();
        resetNumOfCombobox(getCurrentPage().getPageNumberOfItems());
        resetPagination();
        resetPreview();

        enableListeners();
    }

    public void getPages() {
        ArrayList<String> pageArray = ReadObject.readArray(ProductCataloguePage.FILE_NAME);
        // Iterate through the Page array
        for (String pageDetails : pageArray) {
            // Split line into array
            String[] details = pageDetails.split(";");
            // Create a Product Catalogue Page object with the details
            ProductCataloguePage page = new ProductCataloguePage(details);
            // Find the Pages with the matching Product Catalogue Id
            if (page.getPageCatalogueId().equalsIgnoreCase(catalogue.getCatalogueId())) {
                // Add the page to the array list of Pages
                pages.add(page);
            }
        }

        if (pages.size() <= 0) {
            String[] pageItemIds = {};
            ProductCataloguePage page = new ProductCataloguePage(ProductCataloguePage.generatePageId(), 1, 1, pageItemIds, catalogue.getCatalogueId(), ProductCatalogue.ACTIVE);
            if (ProductCataloguePage.register(page)) {
                String[] tempPageItemIds = { " ", " ", " ", " " };
                page.setPageItemIds(tempPageItemIds);
                pages.add(page);
            }
        } else {
            // Sort the Pages
            Collections.sort(pages, ProductCataloguePage.pageComparator);
        }
    }

    private void resetPageNumbers() {
        // Clear exisiting page numbers
        cmbPageNum.removeAllItems();

        for (int i = 1; i <= pages.size(); i++) {
            cmbPageNum.addItem(String.valueOf(i));
        }
    }

    private void resetItem() {
        // Remove existing items
        cmbItem1.removeAllItems();
        cmbItem2.removeAllItems();
        cmbItem3.removeAllItems();
        cmbItem4.removeAllItems();

        cmbItem1.addItem("None");
        cmbItem2.addItem("None");
        cmbItem3.addItem("None");
        cmbItem4.addItem("None");

        boolean foundItem1 = false;
        boolean foundItem2 = false;
        boolean foundItem3 = false;
        boolean foundItem4 = false;

        String[] pageItemIds = getCurrentPage().getPageItemIds();
        ArrayList<String> itemArray = ReadObject.readArray(ProductItem.FILE_NAME);
        // Iterate through Item array
        for (String itemDetails : itemArray) {
            // Split the line into an array
            String[] details = itemDetails.split(";");
            String comboItem = details[0] + ": " + details[1];
            if (details[8].equalsIgnoreCase(ProductItem.ACTIVE) || pageItemIds[0].equalsIgnoreCase(details[0])) {
                // Add the Item into the combobox
                cmbItem1.addItem(comboItem);
                // Set selected Product Item
                if (pageItemIds[0].equalsIgnoreCase(details[0])) {
                    cmbItem1.setSelectedItem(comboItem);
                    foundItem1 = true;
                    if (details[8].equalsIgnoreCase(ProductItem.INACTIVE)) {
                        lblItem1Error.setText("Item selected is inactive");
                    } else {
                        lblItem1Error.setText(" ");
                        validateSupplierId(details[6], lblItem1Error);
                        validateCategoryId(details[7], lblItem1Error);
                    }
                }
            }
            if (details[8].equalsIgnoreCase(ProductItem.ACTIVE) || pageItemIds[1].equalsIgnoreCase(details[0])) {
                // Add the Item into the combobox
                cmbItem2.addItem(comboItem);
                // Set selected Product Item
                if (pageItemIds[1].equalsIgnoreCase(details[0])) {
                    cmbItem2.setSelectedItem(comboItem);
                    foundItem2 = true;
                    if (details[8].equalsIgnoreCase(ProductItem.INACTIVE)) {
                        lblItem2Error.setText("Item selected is inactive");
                    } else {
                        lblItem2Error.setText(" ");
                        validateSupplierId(details[6], lblItem2Error);
                        validateCategoryId(details[7], lblItem2Error);
                    }
                }
            }
            if (details[8].equalsIgnoreCase(ProductItem.ACTIVE) || pageItemIds[2].equalsIgnoreCase(details[0])) {
                // Add the Item into the combobox
                cmbItem3.addItem(comboItem);
                // Set selected Product Item
                if (pageItemIds[2].equalsIgnoreCase(details[0])) {
                    cmbItem3.setSelectedItem(comboItem);
                    foundItem3 = true;
                    if (details[8].equalsIgnoreCase(ProductItem.INACTIVE)) {
                        lblItem3Error.setText("Item selected is inactive");
                    } else {
                        lblItem3Error.setText(" ");
                        validateSupplierId(details[6], lblItem3Error);
                        validateCategoryId(details[7], lblItem3Error);
                    }
                }
            }
            if (details[8].equalsIgnoreCase(ProductItem.ACTIVE) || pageItemIds[3].equalsIgnoreCase(details[0])) {
                // Add the Item into the combobox
                cmbItem4.addItem(comboItem);
                // Set selected Product Item
                if (pageItemIds[3].equalsIgnoreCase(details[0])) {
                    cmbItem4.setSelectedItem(comboItem);
                    foundItem4 = true;
                    if (details[8].equalsIgnoreCase(ProductItem.INACTIVE)) {
                        lblItem4Error.setText("Item selected is inactive");
                    } else {
                        lblItem4Error.setText(" ");
                        validateSupplierId(details[6], lblItem4Error);
                        validateCategoryId(details[7], lblItem4Error);
                    }
                }
            }
        }

        if (!foundItem1) {
            cmbItem1.setSelectedItem("None");
        }
        if (!foundItem2) {
            cmbItem2.setSelectedItem("None");
        }
        if (!foundItem3) {
            cmbItem3.setSelectedItem("None");
        }
        if (!foundItem4) {
            cmbItem4.setSelectedItem("None");
        }
    }

    private void resetFields() {
        // Fill the fields with Product Catalogue Page information
        lblCatalogueTitle.setText(catalogue.getCatalogueTitle());
        cmbPageNum.setSelectedIndex(pageNumber - 1);
        lblTotalPages.setText("/" + String.valueOf(pages.size()));
        if (getCurrentPage().getPageNumberOfItems() == 0) {
            cmbNumOfItem.setSelectedIndex(0);
        } else {
            cmbNumOfItem.setSelectedIndex(getCurrentPage().getPageNumberOfItems() - 1);
        }
        switch (getCurrentPage().getPageStatus()) {
            case ProductCataloguePage.ACTIVE:
                btnStatus.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/switch-on.png")));
                cmbNumOfItem.setEnabled(true);
                cmbItem1.setEnabled(true);
                cmbItem2.setEnabled(true);
                cmbItem3.setEnabled(true);
                cmbItem4.setEnabled(true);
                break;
        
            case ProductCataloguePage.INACTIVE:
                btnStatus.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/switch-off.png")));
                cmbNumOfItem.setEnabled(false);
                cmbItem1.setEnabled(false);
                cmbItem2.setEnabled(false);
                cmbItem3.setEnabled(false);
                cmbItem4.setEnabled(false);
                break;
        }
    }

    private void resetNumOfCombobox(int numOfItem) {
        numOfItem = numOfItem > 0 ? numOfItem : 1;

        switch (numOfItem) {
        case 4:
            lblItem4.setVisible(true);
            cmbItem4.setVisible(true);
            lblItem4Error.setVisible(true);
        case 3:
            lblItem3.setVisible(true);
            cmbItem3.setVisible(true);
            lblItem3Error.setVisible(true);
        case 2:
            lblItem2.setVisible(true);
            cmbItem2.setVisible(true);
            lblItem2Error.setVisible(true);
        default:
            lblItem1.setVisible(true);
            cmbItem1.setVisible(true);
            lblItem1Error.setVisible(true);
            break;
        }

        switch (numOfItem) {
        case 4:
            break;
        case 1:
            lblItem2.setVisible(false);
            cmbItem2.setVisible(false);
            lblItem2Error.setVisible(false);
            cmbItem2.setSelectedIndex(0);
        case 2:
            lblItem3.setVisible(false);
            cmbItem3.setVisible(false);
            lblItem3Error.setVisible(false);
            cmbItem3.setSelectedIndex(0);
        default:
            lblItem4.setVisible(false);
            cmbItem4.setVisible(false);
            lblItem4Error.setVisible(false);
            cmbItem4.setSelectedIndex(0);
            break;
        }
    }

    private void resetPagination() {
        if (pageNumber > 1) {
            btnBack.setEnabled(true);
        } else {
            btnBack.setEnabled(false);
        }

        if (pageNumber < pages.size()) {
            btnNext.setEnabled(true);
        } else {
            btnNext.setEnabled(false);
        }
    }

    private void resetPreview() {
        // Clear the preview
        pnlCatalogue.removeAll();

        if (pageNumber > 1) {
            pnlCatalogue.add(new ProductCatalogueTemplate(catalogue, getCurrentPage()));
        } else {
            pnlCatalogue.add(new ProductCatalogueFirstPageTemplate(catalogue, getCurrentPage()));
        }
        pnlCatalogue.revalidate();
        pnlCatalogue.repaint();
    }

    // Page Navigation
    private void navigatePage(int navigatePageNumber) {
        disableListeners();
        pageNumber = navigatePageNumber;

        resetItem();
        resetFields();
        resetNumOfCombobox(getCurrentPage().getPageNumberOfItems());
        resetPagination();
        resetPreview();

        enableListeners();
    }

    // Validation
    private boolean validateItemStatus(String itemId, JLabel lblError) {
        boolean warning = false;
        boolean validated = true;
        
        ArrayList<String> itemArray = ReadObject.readArray(ProductItem.FILE_NAME);
        // Iterate through the Item array
        for (String itemDetails : itemArray) {
            // Split the line into details
            String[] item = itemDetails.split(";");
            // Find the line has matching Id
            if (item[0].equals(itemId)) {
                // Show error if the Item is inactive
                if (item[8].equalsIgnoreCase(ProductItem.INACTIVE)) {
                    lblError.setText("Item selected is inactive");
                    validated = false;
                    break;
                } else if (!validateSupplierId(item[6], lblError)) {
                    // Does not prevent user from saving or printing
                    warning = true;
                    break;
                } else if (!validateCategoryId(item[7], lblError)) {
                    // Does not prevent user from saving or printing
                    warning = true;
                    break;
                }
            }
        }

        if (validated && !warning) {
            lblError.setText(" ");
        }
        return validated;
    }

    private boolean validateSupplierId(String itemSupplierId, JLabel lblError) {
        boolean validated = true;

        ArrayList<String> supplierArray = ReadObject.readArray(Supplier.FILE_NAME);
        // Iterate through the Supplier array
        for (String supplierDetails : supplierArray) {
            // Split the line into details
            String[] supplier = supplierDetails.split(";");
            // Show error if the Supplier is inactive
            if (supplier[0].equalsIgnoreCase(itemSupplierId)) {
                if ((supplier[5].equalsIgnoreCase(Supplier.INACTIVE))) {
                    lblError.setText("Supplier of Item selected is inactive");
                    validated = false;
                }
                break;
            }
        }
        return validated;
    }

    private boolean validateCategoryId(String itemCategoryId, JLabel lblError) {
        boolean validated = true;

        ArrayList<String> categoryArray = ReadObject.readArray(ProductCategory.FILE_NAME);
        // Iterate through the Category array
        for (String categoryDetails : categoryArray) {
            // Split the line into details
            String[] category = categoryDetails.split(";");
            // Show error iff the Category is inactive
            if (category[0].equalsIgnoreCase(itemCategoryId)) {
                if (category[3].equalsIgnoreCase(ProductCategory.INACTIVE)) {
                    lblError.setText("Category selected is inactive");
                    validated = false;
                }
                break;
            }
        }
        return validated;
    }

    private boolean validateAllPages() {
        ArrayList<String> itemArray = ReadObject.readArray(ProductItem.FILE_NAME);
        ArrayList<String> inactiveItems = new ArrayList<>();
        
        // Iterate through the Item array
        for (String itemDetails : itemArray) {
            // Split the line into details
            String[] item = itemDetails.split(";");
            // Find the line has matching Id
            if (item[8].equalsIgnoreCase(ProductItem.INACTIVE)) {
                inactiveItems.add(item[0]);
            }
        }

        ArrayList<ProductCataloguePage> errorPages = new ArrayList<>();
        // Iterate through the Pages array
        for (ProductCataloguePage page : pages) {
            if (page.getPageStatus().equalsIgnoreCase(ProductCataloguePage.ACTIVE)) {
                // Iterate through the Item Ids in each Page
                for (int i = 0; i < page.getPageNumberOfItems(); i++) {
                    if (inactiveItems.contains(page.getPageItemIds()[i])) {
                        errorPages.add(page);
                        break;
                    }
                }
            }
        }

        if (errorPages.isEmpty()) {
            return true;
        } else {
            String errorString = "Inactive item(s) in page";
            errorString += " " + errorPages.get(0).getPageNumber();
            for (int i = 1; i < errorPages.size(); i++) {
                errorString += ", " + errorPages.get(i).getPageNumber();
            }
            // Display the error message
            JOptionPane.showMessageDialog(new JFrame(), errorString, "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFrameBar = new javax.swing.JPanel();
        lblClose = new javax.swing.JLabel();
        lblMinimize = new javax.swing.JLabel();
        pnlBackground = new javax.swing.JPanel();
        pnlCatalogue = new javax.swing.JPanel();
        pnlOption = new javax.swing.JPanel();
        lblCatalogueTitle = new javax.swing.JLabel();
        lblPageNum = new javax.swing.JLabel();
        cmbPageNum = new javax.swing.JComboBox<>();
        lblTotalPages = new javax.swing.JLabel();
        lblAddPages = new javax.swing.JLabel();
        lblNumOfItem = new javax.swing.JLabel();
        cmbNumOfItem = new javax.swing.JComboBox<>();
        lblItem1 = new javax.swing.JLabel();
        cmbItem1 = new javax.swing.JComboBox<>();
        lblItem1Error = new javax.swing.JLabel();
        lblItem2 = new javax.swing.JLabel();
        cmbItem2 = new javax.swing.JComboBox<>();
        lblItem2Error = new javax.swing.JLabel();
        lblItem3 = new javax.swing.JLabel();
        cmbItem3 = new javax.swing.JComboBox<>();
        lblItem3Error = new javax.swing.JLabel();
        lblItem4 = new javax.swing.JLabel();
        cmbItem4 = new javax.swing.JComboBox<>();
        lblItem4Error = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblPrint = new javax.swing.JLabel();
        btnStatus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AddProductCatalogueForm");
        setMinimumSize(new java.awt.Dimension(820, 641));
        setName("AddProductCatalogueForm"); // NOI18N
        setUndecorated(true);

        pnlFrameBar.setBackground(new java.awt.Color(0, 0, 51));
        pnlFrameBar.setPreferredSize(new java.awt.Dimension(820, 25));
        pnlFrameBar.setRequestFocusEnabled(false);
        pnlFrameBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlFrameBarMouseDragged(evt);
            }
        });
        pnlFrameBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlFrameBarMousePressed(evt);
            }
        });

        lblClose.setBackground(new java.awt.Color(0, 0, 51));
        lblClose.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        lblClose.setForeground(new java.awt.Color(255, 255, 255));
        lblClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClose.setText("X");
        lblClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClose.setMaximumSize(new java.awt.Dimension(45, 25));
        lblClose.setMinimumSize(new java.awt.Dimension(45, 25));
        lblClose.setName("lblClose"); // NOI18N
        lblClose.setOpaque(true);
        lblClose.setPreferredSize(new java.awt.Dimension(45, 25));
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCloseMouseExited(evt);
            }
        });

        lblMinimize.setBackground(new java.awt.Color(0, 0, 51));
        lblMinimize.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        lblMinimize.setForeground(new java.awt.Color(255, 255, 255));
        lblMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMinimize.setText("-");
        lblMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMinimize.setMaximumSize(new java.awt.Dimension(45, 25));
        lblMinimize.setMinimumSize(new java.awt.Dimension(45, 25));
        lblMinimize.setName("lblMinimize"); // NOI18N
        lblMinimize.setOpaque(true);
        lblMinimize.setPreferredSize(new java.awt.Dimension(45, 25));
        lblMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblMinimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMinimizeMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlFrameBarLayout = new javax.swing.GroupLayout(pnlFrameBar);
        pnlFrameBar.setLayout(pnlFrameBarLayout);
        pnlFrameBarLayout.setHorizontalGroup(
            pnlFrameBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFrameBarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlFrameBarLayout.setVerticalGroup(
            pnlFrameBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFrameBarLayout.createSequentialGroup()
                .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlBackground.setBackground(new java.awt.Color(18, 22, 31));

        pnlCatalogue.setBackground(new java.awt.Color(255, 255, 255));
        pnlCatalogue.setPreferredSize(new java.awt.Dimension(420, 594));
        pnlCatalogue.setLayout(new java.awt.BorderLayout());

        pnlOption.setBackground(new java.awt.Color(46, 52, 66));
        pnlOption.setMinimumSize(new java.awt.Dimension(370, 594));
        pnlOption.setPreferredSize(new java.awt.Dimension(370, 594));

        lblCatalogueTitle.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblCatalogueTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblCatalogueTitle.setText("Catalogue Title");
        lblCatalogueTitle.setPreferredSize(new java.awt.Dimension(130, 30));

        lblPageNum.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblPageNum.setForeground(new java.awt.Color(255, 255, 255));
        lblPageNum.setText("Page Number :");
        lblPageNum.setPreferredSize(new java.awt.Dimension(130, 30));

        cmbPageNum.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        cmbPageNum.setPreferredSize(new java.awt.Dimension(100, 30));

        lblTotalPages.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lblTotalPages.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalPages.setText("/ 1000");
        lblTotalPages.setPreferredSize(new java.awt.Dimension(42, 30));

        lblAddPages.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddPages.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productmanagement/img/InsertImage.png"))); // NOI18N
        lblAddPages.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAddPages.setPreferredSize(new java.awt.Dimension(32, 30));
        lblAddPages.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAddPagesMouseClicked(evt);
            }
        });

        lblNumOfItem.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblNumOfItem.setForeground(new java.awt.Color(255, 255, 255));
        lblNumOfItem.setText("Number of Items :");
        lblNumOfItem.setPreferredSize(new java.awt.Dimension(130, 30));

        cmbNumOfItem.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        cmbNumOfItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        cmbNumOfItem.setPreferredSize(new java.awt.Dimension(200, 30));

        lblItem1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblItem1.setForeground(new java.awt.Color(255, 255, 255));
        lblItem1.setText("Item 1 :");
        lblItem1.setPreferredSize(new java.awt.Dimension(130, 30));

        cmbItem1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        cmbItem1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        cmbItem1.setPreferredSize(new java.awt.Dimension(200, 30));

        lblItem1Error.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblItem1Error.setForeground(new java.awt.Color(255, 0, 0));
        lblItem1Error.setText(" ");

        lblItem2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblItem2.setForeground(new java.awt.Color(255, 255, 255));
        lblItem2.setText("Item 2 :");
        lblItem2.setPreferredSize(new java.awt.Dimension(130, 30));

        cmbItem2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        cmbItem2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        cmbItem2.setPreferredSize(new java.awt.Dimension(200, 30));

        lblItem2Error.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblItem2Error.setForeground(new java.awt.Color(255, 0, 0));
        lblItem2Error.setText(" ");

        lblItem3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblItem3.setForeground(new java.awt.Color(255, 255, 255));
        lblItem3.setText("Item 3 :");
        lblItem3.setPreferredSize(new java.awt.Dimension(130, 30));

        cmbItem3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        cmbItem3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        cmbItem3.setPreferredSize(new java.awt.Dimension(200, 30));

        lblItem3Error.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblItem3Error.setForeground(new java.awt.Color(255, 0, 0));
        lblItem3Error.setText(" ");

        lblItem4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblItem4.setForeground(new java.awt.Color(255, 255, 255));
        lblItem4.setText("Item 4 :");
        lblItem4.setPreferredSize(new java.awt.Dimension(130, 30));

        cmbItem4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        cmbItem4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        cmbItem4.setPreferredSize(new java.awt.Dimension(200, 30));

        lblItem4Error.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblItem4Error.setForeground(new java.awt.Color(255, 0, 0));
        lblItem4Error.setText(" ");

        btnSubmit.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnSubmit.setText("Save Catalogue");
        btnSubmit.setBorder(null);
        btnSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSubmit.setPreferredSize(new java.awt.Dimension(150, 40));
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnNext.setBackground(new java.awt.Color(46, 52, 66));
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productmanagement/img/arrow-right.png"))); // NOI18N
        btnNext.setBorder(null);
        btnNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNext.setPreferredSize(new java.awt.Dimension(30, 40));
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(46, 52, 66));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productmanagement/img/arrow-left.png"))); // NOI18N
        btnBack.setBorder(null);
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.setPreferredSize(new java.awt.Dimension(30, 40));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblPrint.setForeground(new java.awt.Color(255, 255, 255));
        lblPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productmanagement/img/white-print.png"))); // NOI18N
        lblPrint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblPrint.setPreferredSize(new java.awt.Dimension(30, 30));
        lblPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPrintMouseClicked(evt);
            }
        });

        btnStatus.setBackground(new java.awt.Color(46, 52, 66));
        btnStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productmanagement/img/switch-on.png"))); // NOI18N
        btnStatus.setBorder(null);
        btnStatus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStatus.setMaximumSize(new java.awt.Dimension(30, 30));
        btnStatus.setMinimumSize(new java.awt.Dimension(30, 30));
        btnStatus.setPreferredSize(new java.awt.Dimension(30, 30));
        btnStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStatusMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlOptionLayout = new javax.swing.GroupLayout(pnlOption);
        pnlOption.setLayout(pnlOptionLayout);
        pnlOptionLayout.setHorizontalGroup(
            pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOptionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOptionLayout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlOptionLayout.createSequentialGroup()
                        .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlOptionLayout.createSequentialGroup()
                                .addComponent(lblNumOfItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbNumOfItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlOptionLayout.createSequentialGroup()
                                        .addComponent(cmbPageNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblTotalPages, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblPrint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblAddPages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(pnlOptionLayout.createSequentialGroup()
                                .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCatalogueTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPageNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblItem1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbItem1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblItem1Error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(pnlOptionLayout.createSequentialGroup()
                                .addComponent(lblItem3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmbItem3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addGroup(pnlOptionLayout.createSequentialGroup()
                        .addComponent(lblItem2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlOptionLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cmbItem2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOptionLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblItem2Error, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlOptionLayout.createSequentialGroup()
                        .addComponent(lblItem4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbItem4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOptionLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblItem3Error, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblItem4Error, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        pnlOptionLayout.setVerticalGroup(
            pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOptionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblPrint, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCatalogueTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTotalPages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbPageNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPageNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblAddPages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumOfItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbNumOfItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblItem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbItem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblItem1Error)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblItem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlOptionLayout.createSequentialGroup()
                        .addComponent(cmbItem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblItem2Error)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblItem3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbItem3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblItem3Error)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblItem4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbItem4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblItem4Error)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCatalogue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(pnlOption, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlCatalogue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlOption, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFrameBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnlFrameBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(820, 641));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pnlFrameBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlFrameBarMousePressed
        // To get the x,y relative to the source component
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_pnlFrameBarMousePressed

    private void pnlFrameBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlFrameBarMouseDragged
        // To get the absolute x,y on the screen when being dragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        // Set the form to the location of (x,y)
        this.setLocation(x - xMouse,y - yMouse);
    }//GEN-LAST:event_pnlFrameBarMouseDragged

    private void lblMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseExited
        // To change the background colour back to its original colour
        lblMinimize.setBackground(new Color(0,0,51));
    }//GEN-LAST:event_lblMinimizeMouseExited

    private void lblMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseEntered
        // To change the background colour to light gray colour
        lblMinimize.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_lblMinimizeMouseEntered

    private void lblMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseClicked
        // Minimize the form
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_lblMinimizeMouseClicked

    private void lblCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseExited
        // To change the background colour back to its original colour
        lblClose.setBackground(new Color(0,0,51));
    }//GEN-LAST:event_lblCloseMouseExited

    private void lblCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseEntered
        // To change the background colour to red colour
        lblClose.setBackground(Color.RED);
    }//GEN-LAST:event_lblCloseMouseEntered

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        int opt = 1;
        if (modified) {
            // Create a confirmation box
            opt = JOptionPane.showConfirmDialog(null, "You have unsaved work. Would you like to save it?", "Warning", JOptionPane.YES_NO_CANCEL_OPTION);            
        }
            
        if (opt == 0) {
            if (ProductCataloguePage.modify(pages)) {
                // Display success message
                JOptionPane.showMessageDialog(new JFrame(), "Updated product catalogue pages in " + catalogue.getCatalogueId(), "Success", JOptionPane.INFORMATION_MESSAGE);
                main.setVisible(true);
                cataloguePanel.repopulateCatalogueList();
                main.isEditing = false;
                this.dispose();
            }
        } else if (opt == 1) {
            main.setVisible(true);
            main.isEditing = false;
            this.dispose();
        }
    }//GEN-LAST:event_lblCloseMouseClicked

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        if (ProductCataloguePage.modify(pages)) {
            // Display success message
            JOptionPane.showMessageDialog(new JFrame(), "Updated product catalogue pages in " + catalogue.getCatalogueId(), "Success", JOptionPane.INFORMATION_MESSAGE);
            main.setVisible(true);
            cataloguePanel.repopulateCatalogueList();
            main.isEditing = false;
            this.dispose();
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void lblPrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPrintMouseClicked
        if (modified) {
            // Ask to save the changes
            int opt = JOptionPane.showConfirmDialog(null, "Would you like to save the updates? Note: Only saved pages are printed", "Save Changes", JOptionPane.YES_NO_OPTION);
            
            if (opt == 0) {
                ProductCataloguePage.modify(pages);
            }
        }
        if (validateAllPages()) {
            Print.printCatalogue(catalogue);
        }
    }//GEN-LAST:event_lblPrintMouseClicked

    private void lblAddPagesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddPagesMouseClicked
        int newPageNumber = pageNumber + 1;
        String[] pageItemIds = {};
        ProductCataloguePage page = new ProductCataloguePage(ProductCataloguePage.generatePageId(), newPageNumber, 1, pageItemIds, catalogue.getCatalogueId(), ProductCatalogue.ACTIVE);
        if (ProductCataloguePage.register(page)) {
            disableListeners();
            // Increment all Page numbers after the new Page by one
            for (ProductCataloguePage pageDetails : pages) {
                if (pageDetails.getPageNumber() >= newPageNumber) {
                    pageDetails.setPageNumber(pageDetails.getPageNumber() + 1);
                }
            }
            // Create a placeholder of Item Ids
            String[] tempPageItemIds = {" "," "," "," "};
            page.setPageItemIds(tempPageItemIds);
            // Add the new Page into the index
            pages.add(newPageNumber - 1, page);
            resetPageNumbers();
            navigatePage(newPageNumber);
            modified = true;
        }
    }//GEN-LAST:event_lblAddPagesMouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        if (pageNumber > 1) {
            navigatePage(pageNumber - 1);
        }
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        if (pageNumber < pages.size()) {
            navigatePage(pageNumber + 1);
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnStatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStatusMouseClicked
        String pageStatus = ProductCataloguePage.ACTIVE;
        // Set new Page status as active or inactive
        switch (getCurrentPage().getPageStatus()) {
            case ProductCataloguePage.ACTIVE:
                pageStatus = ProductCataloguePage.INACTIVE;
                btnStatus.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/switch-off.png")));
                cmbNumOfItem.setEnabled(false);
                cmbItem1.setEnabled(false);
                cmbItem2.setEnabled(false);
                cmbItem3.setEnabled(false);
                cmbItem4.setEnabled(false);
                break;
        
            case ProductCataloguePage.INACTIVE:
                pageStatus = ProductCataloguePage.ACTIVE;
                btnStatus.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/switch-on.png")));
                cmbNumOfItem.setEnabled(true);
                cmbItem1.setEnabled(true);
                cmbItem2.setEnabled(true);
                cmbItem3.setEnabled(true);
                cmbItem4.setEnabled(true);
                break;
        }

        // Update the Page status
        // Create a Product Catalogue Page object
        ProductCataloguePage modifiedPage = new ProductCataloguePage(getCurrentPage().getPageId(), pageNumber, getCurrentPage().getPageNumberOfItems(), getCurrentPage().getPageItemIds(), getCurrentPage().getPageCatalogueId(), pageStatus);
        // Get the index using page number
        int index = pageNumber - 1;
        // Edit the ArrayList
        pages.set(index, modifiedPage);
        modified = true;
    }//GEN-LAST:event_btnStatusMouseClicked


    // EVENT LISTENERS
    private void enableListeners() {
        cmbPageNum.addActionListener(cmbPageNumListener);
        cmbNumOfItem.addActionListener(cmbNumOfItemListener);
        cmbItem1.addActionListener(cmbItem1Listener);
        cmbItem2.addActionListener(cmbItem2Listener);
        cmbItem3.addActionListener(cmbItem3Listener);
        cmbItem4.addActionListener(cmbItem4Listener);
    }

    private void disableListeners() {
        cmbPageNum.removeActionListener(cmbPageNumListener);
        cmbNumOfItem.removeActionListener(cmbNumOfItemListener);
        cmbItem1.removeActionListener(cmbItem1Listener);
        cmbItem2.removeActionListener(cmbItem2Listener);
        cmbItem3.removeActionListener(cmbItem3Listener);
        cmbItem4.removeActionListener(cmbItem4Listener);
    }

    ActionListener cmbPageNumListener = new ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            navigatePage(cmbPageNum.getSelectedIndex() + 1);
        }
    };

    ActionListener cmbNumOfItemListener = new ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            resetNumOfCombobox(cmbNumOfItem.getSelectedIndex() + 1);
            // Edit Product Item Ids
            String[] pageItemIds = getCurrentPage().getPageItemIds();
            int pageNumberOfItems = cmbNumOfItem.getSelectedIndex() + 1;
            // Create a Product Catalogue Page object
            ProductCataloguePage modifiedPage = new ProductCataloguePage(getCurrentPage().getPageId(), pageNumber, pageNumberOfItems, pageItemIds, getCurrentPage().getPageCatalogueId(), ProductCataloguePage.ACTIVE);
            // Get the index using page number
            int index = pageNumber - 1;
            // Edit the ArrayList
            pages.set(index, modifiedPage);
            resetPreview();
            modified = true;
        }
    };

    ActionListener cmbItem1Listener = new ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            // Edit Product Item Ids
            String[] pageItemIds = getCurrentPage().getPageItemIds();
            int pageNumberOfItems = cmbNumOfItem.getSelectedIndex() + 1;
            String itemId = String.valueOf(cmbItem1.getSelectedItem());
            if (itemId.equalsIgnoreCase("None")) {
                itemId = " ";
            } else {
                itemId = itemId.substring(0, 10);
            }
            pageItemIds[0] = itemId;
            // Create a Product Catalogue Page object
            ProductCataloguePage modifiedPage = new ProductCataloguePage(getCurrentPage().getPageId(), pageNumber, pageNumberOfItems, pageItemIds, getCurrentPage().getPageCatalogueId(), ProductCataloguePage.ACTIVE);
            // Get the index using page number
            int index = pageNumber - 1;
            // Edit the ArrayList
            pages.set(index, modifiedPage);
            resetPreview();
            validateItemStatus(itemId, lblItem1Error);
            modified = true;
        }
    };

    ActionListener cmbItem2Listener = new ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            // Edit Product Item Ids
            String[] pageItemIds = getCurrentPage().getPageItemIds();
            int pageNumberOfItems = cmbNumOfItem.getSelectedIndex() + 1;
            String itemId = String.valueOf(cmbItem2.getSelectedItem());
            if (itemId.equalsIgnoreCase("None")) {
                itemId = " ";
            } else {
                itemId = itemId.substring(0, 10);
            }
            pageItemIds[1] = itemId;
            // Create a Product Catalogue Page object
            ProductCataloguePage modifiedPage = new ProductCataloguePage(getCurrentPage().getPageId(), pageNumber, pageNumberOfItems, pageItemIds, getCurrentPage().getPageCatalogueId(), ProductCataloguePage.ACTIVE);
            // Get the index using page number
            int index = pageNumber - 1;
            // Edit the ArrayList
            pages.set(index, modifiedPage);
            resetPreview();
            validateItemStatus(itemId, lblItem2Error);
            modified = true;
        }
    };

    ActionListener cmbItem3Listener = new ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            // Edit Product Item Ids
            String[] pageItemIds = getCurrentPage().getPageItemIds();
            int pageNumberOfItems = cmbNumOfItem.getSelectedIndex() + 1;
            String itemId = String.valueOf(cmbItem3.getSelectedItem());
            if (itemId.equalsIgnoreCase("None")) {
                itemId = " ";
            } else {
                itemId = itemId.substring(0, 10);
            }
            pageItemIds[2] = itemId;
            // Create a Product Catalogue Page object
            ProductCataloguePage modifiedPage = new ProductCataloguePage(getCurrentPage().getPageId(), pageNumber, pageNumberOfItems, pageItemIds, getCurrentPage().getPageCatalogueId(), ProductCataloguePage.ACTIVE);
            // Get the index using page number
            int index = pageNumber - 1;
            // Edit the ArrayList
            pages.set(index, modifiedPage);
            resetPreview();
            validateItemStatus(itemId, lblItem3Error);
            modified = true;
        }
    };

    ActionListener cmbItem4Listener = new ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            // Edit Product Item Ids
            String[] pageItemIds = getCurrentPage().getPageItemIds();
            int pageNumberOfItems = cmbNumOfItem.getSelectedIndex() + 1;
            String itemId = String.valueOf(cmbItem4.getSelectedItem());
            if (itemId.equalsIgnoreCase("None")) {
                itemId = " ";
            } else {
                itemId = itemId.substring(0, 10);
            }
            pageItemIds[3] = itemId;
            // Create a Product Catalogue Page object
            ProductCataloguePage modifiedPage = new ProductCataloguePage(getCurrentPage().getPageId(), pageNumber, pageNumberOfItems, pageItemIds, getCurrentPage().getPageCatalogueId(), ProductCataloguePage.ACTIVE);
            // Get the index using page number
            int index = pageNumber - 1;
            // Edit the ArrayList
            pages.set(index, modifiedPage);
            resetPreview();
            validateItemStatus(itemId, lblItem4Error);
            modified = true;
        }
    };

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProductCataloguePageForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductCataloguePageForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductCataloguePageForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductCataloguePageForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        /*
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductCataloguePageForm().setVisible(true);
            }
        });
        */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnStatus;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> cmbItem1;
    private javax.swing.JComboBox<String> cmbItem2;
    private javax.swing.JComboBox<String> cmbItem3;
    private javax.swing.JComboBox<String> cmbItem4;
    private javax.swing.JComboBox<String> cmbNumOfItem;
    private javax.swing.JComboBox<String> cmbPageNum;
    private javax.swing.JLabel lblAddPages;
    private javax.swing.JLabel lblCatalogueTitle;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblItem1;
    private javax.swing.JLabel lblItem1Error;
    private javax.swing.JLabel lblItem2;
    private javax.swing.JLabel lblItem2Error;
    private javax.swing.JLabel lblItem3;
    private javax.swing.JLabel lblItem3Error;
    private javax.swing.JLabel lblItem4;
    private javax.swing.JLabel lblItem4Error;
    private javax.swing.JLabel lblMinimize;
    private javax.swing.JLabel lblNumOfItem;
    private javax.swing.JLabel lblPageNum;
    private javax.swing.JLabel lblPrint;
    private javax.swing.JLabel lblTotalPages;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlCatalogue;
    private javax.swing.JPanel pnlFrameBar;
    private javax.swing.JPanel pnlOption;
    // End of variables declaration//GEN-END:variables
}
