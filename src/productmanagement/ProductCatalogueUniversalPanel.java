package productmanagement;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ProductCatalogueUniversalPanel extends javax.swing.JPanel {
    // Constant fields
    public static final int MAIN_MAX_HEIGHT = 269;
    public static final int MAIN_MIN_HEIGHT = 77;
    public static final int MAIN_WIDTH = 755;
    public static final int PANEL_MAX_HEIGHT = 251;
    public static final int PANEL_MIN_HEIGHT = 55;
    public static final int PANEL_WIDTH = 735;

    MainForm main;
    ProductCataloguePanel cataloguePanel;

    // Product Catalogue information
    ProductCatalogue catalogue;

    // Keeps track of temporary image file path
    String imageFilePath, latestImageTempPath;

    // Create a variable to check the panel is closed or opened
    boolean isClosed;
    
    // Create a variable to check the textbox is enabled or disabled 
    boolean isEditing = false;
    
    // Create a variable to check the catalogueStatus is activated or deactivated
    boolean isActivated;
    
    public ProductCatalogueUniversalPanel(MainForm main, ProductCataloguePanel cataloguePanel, ProductCatalogue catalogue, int i) {
        initComponents();
        this.main = main;
        this.cataloguePanel = cataloguePanel;
        // Hide edit button and disable status button for Administrator
        if (Administrator.isAdministrator()) {
            pnlEditDropDownList.setVisible(false);
            btnStatus.setEnabled(false);
        }
        // Hide the Panel
        hidePanel();
        // Set the Product Catalogue
        this.catalogue = catalogue;
        imageFilePath = catalogue.getCatalogueBannerPath();
        // Set the list number
        lblNum.setText(String.valueOf(i) + ".");
        resetFields();
    }
    
    private void hidePanel(){
        // Resize the Panel and hide the components inside
        pnlBox.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_MIN_HEIGHT));
        pnlBox.revalidate();
        pnlBox.repaint();

        setPreferredSize(new Dimension(MAIN_WIDTH, MAIN_MIN_HEIGHT));
        revalidate();
        repaint();
        
        // Resize the size of the edit drop down list
        pnlEditDropDownList.setPreferredSize(new Dimension(78, 33));
        pnlEditDropDownList.revalidate();
        pnlEditDropDownList.repaint();
        lblSaveIcon.setVisible(false);

        // When the panel is closed, set the boolean variable to true.
        isClosed = true;    
    }
    
    private void showPanel(){
        // Resize the Panel and show the components inside
        pnlBox.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_MAX_HEIGHT));
        pnlBox.revalidate();
        pnlBox.repaint();

        setPreferredSize(new Dimension(MAIN_WIDTH, MAIN_MAX_HEIGHT));
        revalidate();
        repaint();
           
        // When the panel is opened, set the boolean variable to false.
        isClosed = false;
    }
    
    private Date convertToDate(LocalDate dateToConvert) {
        return java.util.Date.from(dateToConvert.atStartOfDay()
            .atZone(ZoneId.systemDefault())
            .toInstant());
    }

    private void resetFields() {
        // Fill the fields with Product Catalogue information
        txtTitle.setText(catalogue.getCatalogueTitle());
        txaDescription.setText(catalogue.getCatalogueDescription());
        ftxStartDate.setValue(convertToDate(catalogue.getCatalogueStartDate()));
        ftxEndDate.setValue(convertToDate(catalogue.getCatalogueEndDate()));
        lblImage.setIcon(resizeImage(Paths.get("").toAbsolutePath().toString() + "/src" + catalogue.getCatalogueBannerPath()));
        lblUserId.setText(catalogue.getCatalogueUserId());

        switch (catalogue.getCatalogueStatus()) {
            case ProductCatalogue.ACTIVE:
                btnStatus.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/switch-on.png")));
                lblPrint.setEnabled(true);
                lblPrint.setCursor(new Cursor(Cursor.HAND_CURSOR));
                lblEditIcon.setEnabled(true);
                isActivated = true;
                break;
        
            case ProductCatalogue.INACTIVE:
                btnStatus.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/switch-off.png")));
                lblPrint.setEnabled(false);
                lblPrint.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                lblEditIcon.setEnabled(false);
                isActivated = false;
                break;
        }

        // Calculate the number of pages
        int numberOfPages = 0;
        ArrayList<String> pageArray = ReadObject.readArray(ProductCataloguePage.FILE_NAME);
        for (int i = 0; i < pageArray.size(); i++) {
            // Split the line into an array
            String[] details = pageArray.get(i).split(";");
            // Create a Product Catalogue Page object with the details
            ProductCataloguePage pcp = new ProductCataloguePage(details);
            // Check if the Page is part of this catalogue
            if (pcp.getPageCatalogueId().equalsIgnoreCase(catalogue.getCatalogueId()) && pcp.getPageStatus().equalsIgnoreCase(ProductCataloguePage.ACTIVE)) {
                numberOfPages++;
            }
        }
        lblPageNumbers.setText(String.valueOf(numberOfPages));
    }
    
    // Create a method to resize the image and label
    private ImageIcon resizeImage(String imagePath) {
        // Get the imageicon
        ImageIcon MyImage = new ImageIcon(imagePath);
        
        // Resize the image to the size of the label
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance((int) lblImage.getPreferredSize().getWidth(),(int) lblImage.getPreferredSize().getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    // Validation
    private boolean validateTitle(String catalogueTitle) {
        boolean validated = true;

        if (catalogueTitle.length() <= 0 || catalogueTitle.equalsIgnoreCase("Title")) {
            lblTitleError.setText("Cannot be empty");
            validated = false;
        } else if (catalogueTitle.contains(";")) {
            lblTitleError.setText("Cannot contain semi-colons");
            validated = false;
        }

        if (validated) {
            lblTitleError.setText(" ");
        }
        return validated;
    }

    private boolean validateDescription(String catalogueDescription) {
        boolean validated = true;

        if (catalogueDescription.length() <= 0 || catalogueDescription.equalsIgnoreCase("Description")) {
            lblDescriptionError.setText("Cannot be empty");
            validated = false;
        } else if (catalogueDescription.contains(";")) {
            lblDescriptionError.setText("Cannot contain semi-colons");
            validated = false;
        }

        if (validated) {
            lblDescriptionError.setText(" ");
        }

        return validated;
    }

    private boolean validateStartDate(String catalogueStartDateString) {
        boolean validated = true;
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);

        try {
            if (catalogueStartDateString.length() <= 0) {
                lblStartDateError.setText("Cannot be empty");
                validated = false;
            } else {
                LocalDate startDate = LocalDate.parse(catalogueStartDateString, formatter);
                if (startDate.isBefore(LocalDate.now())) {
                    lblStartDateError.setText("Cannot be before today");
                    validated = false;
                }
            }
        } catch (Exception e) {
            lblStartDateError.setText("Please enter a valid date");
            validated = false;
        }

        if (validated) {
            lblStartDateError.setText(" ");
        }
        return validated;
    }

    private boolean validateEndDate(String catalogueStartDateString, String catalogueEndDateString) {
        boolean validated = true;
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);

        try {
            if (catalogueEndDateString.length() <= 0) {
                lblEndDateError.setText("Cannot be empty");
                validated = false;
            } else {
                LocalDate endDate = LocalDate.parse(catalogueEndDateString, formatter);
                if (validateStartDate(catalogueStartDateString)) {
                    LocalDate startDate = LocalDate.parse(catalogueStartDateString, formatter);
                    if (endDate.isBefore(startDate)) {
                        lblEndDateError.setText("Cannot be before start date");
                        validated = false;
                    }
                }
            }
        } catch (Exception e) {
            lblEndDateError.setText("Please enter a valid date");
            validated = false;
        }

        if (validated) {
            lblEndDateError.setText(" ");
        }
        return validated;
    }

    private boolean validateImagePath(String catalogueImageTempPath) {
        boolean validated = true;

        if (catalogueImageTempPath.length() <= 0) {
            lblImageError.setText("Cannot be empty");
            validated = false;
        }

        if (validated) {
            lblImageError.setText(" ");
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

        ArrayList<String> pageArray = ReadObject.readArray(ProductCataloguePage.FILE_NAME);
        ArrayList<ProductCataloguePage> errorPages = new ArrayList<>();
        // Iterate through the Pages array
        for (String pageDetails : pageArray) {
            // Split the line into details
            String[] details = pageDetails.split(";");
            ProductCataloguePage page = new ProductCataloguePage(details);
            if (page.getPageCatalogueId().equalsIgnoreCase(catalogue.getCatalogueId()) && page.getPageStatus().equalsIgnoreCase(ProductCataloguePage.ACTIVE)) {
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBox = new javax.swing.JPanel();
        pnlBackground = new javax.swing.JPanel();
        lblNum = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        lblTitleError = new javax.swing.JLabel();
        ftxStartDate = new javax.swing.JFormattedTextField();
        lblStartDateError = new javax.swing.JLabel();
        lblDash = new javax.swing.JLabel();
        ftxEndDate = new javax.swing.JFormattedTextField();
        lblEndDateError = new javax.swing.JLabel();
        scrDescription = new javax.swing.JScrollPane();
        txaDescription = new javax.swing.JTextArea();
        lblDescriptionError = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();
        lblImageError = new javax.swing.JLabel();
        lblNumberofPages = new javax.swing.JLabel();
        lblPageNumbers = new javax.swing.JLabel();
        lblCreatedBy = new javax.swing.JLabel();
        lblUserId = new javax.swing.JLabel();
        btnStatus = new javax.swing.JButton();
        lblControl = new javax.swing.JLabel();
        lblPrint = new javax.swing.JLabel();
        pnlEditDropDownList = new javax.swing.JPanel();
        lblEditIcon = new javax.swing.JLabel();
        lblEditCatalogue = new javax.swing.JLabel();
        lblEditPage = new javax.swing.JLabel();
        lblSaveIcon = new javax.swing.JLabel();

        setBackground(new java.awt.Color(46, 52, 66));
        setPreferredSize(new java.awt.Dimension(755, 269));

        pnlBox.setPreferredSize(new java.awt.Dimension(735, 251));
        pnlBox.setLayout(new javax.swing.BoxLayout(pnlBox, javax.swing.BoxLayout.LINE_AXIS));

        pnlBackground.setBackground(new java.awt.Color(255, 255, 255));
        pnlBackground.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlBackground.setPreferredSize(new java.awt.Dimension(735, 179));

        lblNum.setBackground(new java.awt.Color(0, 0, 0));
        lblNum.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNum.setText("1.");
        lblNum.setPreferredSize(new java.awt.Dimension(40, 30));

        txtTitle.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtTitle.setText("Title");
        txtTitle.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtTitle.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTitle.setEnabled(false);
        txtTitle.setPreferredSize(new java.awt.Dimension(200, 30));
        txtTitle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTitleFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTitleFocusLost(evt);
            }
        });
        txtTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTitleKeyReleased(evt);
            }
        });

        lblTitleError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblTitleError.setForeground(new java.awt.Color(255, 0, 0));
        lblTitleError.setText(" ");

        ftxStartDate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ftxStartDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        ftxStartDate.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        ftxStartDate.setEnabled(false);
        ftxStartDate.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        ftxStartDate.setPreferredSize(new java.awt.Dimension(150, 30));
        ftxStartDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ftxStartDateKeyReleased(evt);
            }
        });

        lblStartDateError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblStartDateError.setForeground(new java.awt.Color(255, 0, 0));
        lblStartDateError.setText(" ");

        lblDash.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        lblDash.setText(" - ");
        lblDash.setPreferredSize(new java.awt.Dimension(13, 30));

        ftxEndDate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ftxEndDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        ftxEndDate.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        ftxEndDate.setEnabled(false);
        ftxEndDate.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        ftxEndDate.setPreferredSize(new java.awt.Dimension(150, 30));
        ftxEndDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ftxEndDateKeyReleased(evt);
            }
        });

        lblEndDateError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblEndDateError.setForeground(new java.awt.Color(255, 0, 0));
        lblEndDateError.setText(" ");

        txaDescription.setColumns(17);
        txaDescription.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txaDescription.setRows(4);
        txaDescription.setText("Description");
        txaDescription.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txaDescription.setEnabled(false);
        txaDescription.setLineWrap(true);
        txaDescription.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txaDescriptionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txaDescriptionFocusLost(evt);
            }
        });
        txaDescription.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaDescriptionKeyReleased(evt);
            }
        });
        scrDescription.setViewportView(txaDescription);

        lblDescriptionError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblDescriptionError.setForeground(new java.awt.Color(255, 0, 0));
        lblDescriptionError.setText(" ");

        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblImage.setEnabled(false);
        lblImage.setPreferredSize(new java.awt.Dimension(325, 60));
        lblImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImageMouseClicked(evt);
            }
        });

        lblImageError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblImageError.setForeground(new java.awt.Color(255, 0, 0));
        lblImageError.setText(" ");

        lblNumberofPages.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblNumberofPages.setText("Number of Pages :");
        lblNumberofPages.setPreferredSize(new java.awt.Dimension(84, 30));

        lblPageNumbers.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblPageNumbers.setText(" ");

        lblCreatedBy.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblCreatedBy.setText("Created By :");
        lblCreatedBy.setPreferredSize(new java.awt.Dimension(84, 30));

        lblUserId.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblUserId.setText(" ");

        btnStatus.setBackground(new java.awt.Color(255, 255, 255));
        btnStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productmanagement/img/switch-on.png"))); // NOI18N
        btnStatus.setBorder(null);
        btnStatus.setDisabledIcon(null);
        btnStatus.setMaximumSize(new java.awt.Dimension(30, 30));
        btnStatus.setMinimumSize(new java.awt.Dimension(30, 30));
        btnStatus.setPreferredSize(new java.awt.Dimension(30, 30));
        btnStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatusActionPerformed(evt);
            }
        });

        lblControl.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblControl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblControl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productmanagement/img/Black-arrow-down.png"))); // NOI18N
        lblControl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblControl.setMaximumSize(new java.awt.Dimension(30, 30));
        lblControl.setMinimumSize(new java.awt.Dimension(30, 30));
        lblControl.setPreferredSize(new java.awt.Dimension(30, 30));
        lblControl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblControlMouseClicked(evt);
            }
        });

        lblPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productmanagement/img/Print.png"))); // NOI18N
        lblPrint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblPrint.setMaximumSize(new java.awt.Dimension(30, 30));
        lblPrint.setMinimumSize(new java.awt.Dimension(30, 30));
        lblPrint.setPreferredSize(new java.awt.Dimension(30, 30));
        lblPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPrintMouseClicked(evt);
            }
        });

        pnlEditDropDownList.setBackground(new java.awt.Color(255, 255, 255));

        lblEditIcon.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEditIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productmanagement/img/Edit.png"))); // NOI18N
        lblEditIcon.setToolTipText("");
        lblEditIcon.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblEditIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEditIcon.setMaximumSize(new java.awt.Dimension(30, 30));
        lblEditIcon.setMinimumSize(new java.awt.Dimension(30, 30));
        lblEditIcon.setPreferredSize(new java.awt.Dimension(30, 30));
        lblEditIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblEditIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblEditIconMouseExited(evt);
            }
        });

        lblEditCatalogue.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lblEditCatalogue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEditCatalogue.setText("Catalogue");
        lblEditCatalogue.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEditCatalogue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEditCatalogueMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblEditCatalogueMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblEditCatalogueMouseExited(evt);
            }
        });

        lblEditPage.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lblEditPage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEditPage.setText("Page");
        lblEditPage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEditPage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEditPageMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblEditPageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblEditPageMouseExited(evt);
            }
        });

        lblSaveIcon.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSaveIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productmanagement/img/Save.png"))); // NOI18N
        lblSaveIcon.setToolTipText("");
        lblSaveIcon.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblSaveIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSaveIcon.setMaximumSize(new java.awt.Dimension(30, 30));
        lblSaveIcon.setMinimumSize(new java.awt.Dimension(30, 30));
        lblSaveIcon.setPreferredSize(new java.awt.Dimension(30, 30));
        lblSaveIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSaveIconMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlEditDropDownListLayout = new javax.swing.GroupLayout(pnlEditDropDownList);
        pnlEditDropDownList.setLayout(pnlEditDropDownListLayout);
        pnlEditDropDownListLayout.setHorizontalGroup(
            pnlEditDropDownListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblEditPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEditDropDownListLayout.createSequentialGroup()
                .addComponent(lblSaveIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblEditIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(lblEditCatalogue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlEditDropDownListLayout.setVerticalGroup(
            pnlEditDropDownListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEditDropDownListLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(pnlEditDropDownListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEditIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSaveIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(lblEditCatalogue, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblEditPage, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(scrDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(lblDescriptionError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(lblNumberofPages, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPageNumbers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(25, 25, 25)
                        .addComponent(lblCreatedBy, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 117, Short.MAX_VALUE))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTitleError, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                        .addComponent(lblImageError, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                                        .addGap(0, 4, Short.MAX_VALUE)
                                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)))
                                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pnlEditDropDownList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPrint, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ftxStartDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblStartDateError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblEndDateError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ftxEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTitleError))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lblNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ftxStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblStartDateError))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(ftxEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEndDateError)))
                .addGap(21, 21, 21)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(lblPrint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlEditDropDownList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblImageError))
                            .addComponent(scrDescription))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDescriptionError)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblCreatedBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPageNumbers, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblNumberofPages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pnlBox.add(pnlBackground);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblControlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblControlMouseClicked
        if (isClosed && !isEditing){
            showPanel();
            
            // Change the icon from down to up
            lblControl.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/Black-arrow-up.png")));

        } else if (!isClosed && !isEditing){
            hidePanel();

            // Change the icon from up to down
            lblControl.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/Black-arrow-down.png")));
        }
    }//GEN-LAST:event_lblControlMouseClicked

    private void lblImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImageMouseClicked
        if (isEditing) {
            // To let the user insert the image after pressed the label
            // Set the home directory of the filechooser to user
            JFileChooser file = new JFileChooser();
            file.setCurrentDirectory(new File(System.getProperty("user.home")));
            
            // Create a new file name extension which including .jpg and .png file
            FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","png");
            file.addChoosableFileFilter(filter);
            int result = file.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION){
                File selectedFile = file.getSelectedFile();
                String path = selectedFile.getAbsolutePath();
                lblImage.setIcon(resizeImage(path));
                latestImageTempPath = path;
                imageFilePath = path;
            } else if (result == JFileChooser.CANCEL_OPTION){
                if(latestImageTempPath == null){
                    lblImage.setIcon(resizeImage(Paths.get("").toAbsolutePath().toString() + "/src" + catalogue.getCatalogueBannerPath()));
                }else{
                    lblImage.setIcon(resizeImage(latestImageTempPath));
                }
            }
        }
    }//GEN-LAST:event_lblImageMouseClicked

    private void lblEditCatalogueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditCatalogueMouseClicked
        if (!main.isEditing) {
            // Enable editing of fields
            txtTitle.setEnabled(true);
            ftxStartDate.setEnabled(true);
            ftxEndDate.setEnabled(true);
            scrDescription.setEnabled(true);
            txaDescription.setEnabled(true);
            lblImage.setEnabled(true);
            lblControl.setEnabled(false);
            // Disable editing of btnStatus
            btnStatus.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btnStatus.setEnabled(false);

            lblSaveIcon.setVisible(true);
            lblEditIcon.setVisible(false);
            lblEditCatalogue.setVisible(false);
            lblEditPage.setVisible(false);

            // When the textbox is enabled, set the boolean variable to true.
            isEditing = true;
            main.isEditing = true;
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "You have unsaved work. Please save it first.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_lblEditCatalogueMouseClicked

    private void lblEditIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditIconMouseEntered
        if (isActivated) {
            // Resize the size of the edit drop down list
            pnlEditDropDownList.setPreferredSize(new Dimension(78, 90));
            pnlEditDropDownList.revalidate();
            pnlEditDropDownList.repaint();
        }
    }//GEN-LAST:event_lblEditIconMouseEntered

    private void lblEditIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditIconMouseExited
        //Resize the size of the edit drop down list
        pnlEditDropDownList.setPreferredSize(new Dimension(78, 33));
        pnlEditDropDownList.revalidate();
        pnlEditDropDownList.repaint();
    }//GEN-LAST:event_lblEditIconMouseExited

    private void lblEditCatalogueMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditCatalogueMouseEntered
        if (isActivated) {
            // Resize the size of the edit drop down list
            pnlEditDropDownList.setPreferredSize(new Dimension(78, 90));
            pnlEditDropDownList.revalidate();
            pnlEditDropDownList.repaint();
        }
    }//GEN-LAST:event_lblEditCatalogueMouseEntered

    private void lblEditCatalogueMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditCatalogueMouseExited
        // Resize the size of the edit drop down list
        pnlEditDropDownList.setPreferredSize(new Dimension(78, 33));
        pnlEditDropDownList.revalidate();
        pnlEditDropDownList.repaint();
    }//GEN-LAST:event_lblEditCatalogueMouseExited

    private void lblEditPageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditPageMouseEntered
        if (isActivated) {
            //Resize the size of the edit drop down list
            pnlEditDropDownList.setPreferredSize(new Dimension(78, 90));
            pnlEditDropDownList.revalidate();
            pnlEditDropDownList.repaint();
        }
    }//GEN-LAST:event_lblEditPageMouseEntered

    private void lblEditPageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditPageMouseExited
        // Resize the size of the edit drop down list
        pnlEditDropDownList.setPreferredSize(new Dimension(78, 33));
        pnlEditDropDownList.revalidate();
        pnlEditDropDownList.repaint();
    }//GEN-LAST:event_lblEditPageMouseExited

    private void lblSaveIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSaveIconMouseClicked
        boolean validated = true;

        String catalogueTitle = txtTitle.getText().trim();
        String catalogueDescription = txaDescription.getText().trim();
        String catalogueStartDateString = ftxStartDate.getText().trim();
        String catalogueEndDateString = ftxEndDate.getText().trim();
        String catalogueImageTempPath = imageFilePath;

        try {
            // Validation
            if (!validateTitle(catalogueTitle)) {
                validated = false;
            }

            if (!validateDescription(catalogueDescription)) {
                validated = false;
            }

            if (!validateStartDate(catalogueStartDateString)) {
                validated = false;
            }

            if (!validateEndDate(catalogueStartDateString, catalogueEndDateString)) {
                validated = false;
            }

            if (!validateImagePath(catalogueImageTempPath)) {
                validated = false;
            }

            if (validated) {
                // Convert String to LocalDate
                DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
                LocalDate catalogueStartDate = LocalDate.parse(catalogueStartDateString, formatter);
                LocalDate catalogueEndDate = LocalDate.parse(catalogueEndDateString, formatter);

                // Generate Catalogue Id
                String catalogueId = catalogue.getCatalogueId();

                // Copy image file to system
                Path tempPath = Path.of(catalogueImageTempPath);
                String newPathString = "/productmanagement/img/productcatalogue/";
                String fileName = catalogueId + catalogueImageTempPath.substring(catalogueImageTempPath.lastIndexOf("."));
                String catalogueBannerPath = newPathString + fileName;
                if (!catalogueImageTempPath.equalsIgnoreCase(catalogueBannerPath)) {
                    WriteObject.saveImage(tempPath, newPathString, fileName);
                }

                ProductCatalogue modifiedCatalogue = new ProductCatalogue(catalogueId, catalogueTitle, catalogueBannerPath, catalogueDescription, catalogueStartDate, catalogueEndDate, LocalDateTime.now(), User.myUser.getUserId(), ProductCatalogue.ACTIVE);
                if (ProductCatalogue.modify(modifiedCatalogue, catalogue.getCatalogueStatus())) {
                    catalogue = modifiedCatalogue;
                    resetFields();

                    // Disable the editing of fields
                    txtTitle.setEnabled(false);
                    ftxStartDate.setEnabled(false);
                    ftxEndDate.setEnabled(false);
                    scrDescription.setEnabled(false);
                    txaDescription.setEnabled(false);
                    lblImage.setEnabled(false);
                    lblControl.setEnabled(true);
                    // Enable the editing of btnStatus
                    btnStatus.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    btnStatus.setEnabled(true);

                    lblSaveIcon.setVisible(false);
                    lblEditIcon.setVisible(true);
                    lblEditCatalogue.setVisible(true);
                    lblEditPage.setVisible(true);
                    
                    // When the textbox is enabled, set the boolean variable to true.
                    isEditing = false;
                    main.isEditing = false;
                }
            }
        } catch (Exception e) {
                // Display the error message
                JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_lblSaveIconMouseClicked

    private void lblEditPageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditPageMouseClicked
        if (!main.isEditing) {
            ProductCataloguePageForm apcp = new ProductCataloguePageForm(main, cataloguePanel, catalogue);
            apcp.setVisible(true);
            main.setVisible(false);
            main.isEditing = true;
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "You have unsaved work. Please save it first.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_lblEditPageMouseClicked

    private void txtTitleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTitleFocusGained
        if (txtTitle.getText().trim().equalsIgnoreCase("Title")) {
            txtTitle.setText("");
        }
    }//GEN-LAST:event_txtTitleFocusGained

    private void txtTitleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTitleFocusLost
        String catalogueTitle = txtTitle.getText().trim();
        validateTitle(catalogueTitle);
        
        if (txtTitle.getText().trim().equalsIgnoreCase("")) {
            txtTitle.setText("Title");
        }
    }//GEN-LAST:event_txtTitleFocusLost

    private void txaDescriptionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txaDescriptionFocusGained
        if (txaDescription.getText().trim().equalsIgnoreCase("Description")) {
            txaDescription.setText("");
        }
    }//GEN-LAST:event_txaDescriptionFocusGained

    private void txaDescriptionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txaDescriptionFocusLost
        String catalogueDescription = txaDescription.getText().trim();
        validateDescription(catalogueDescription);
        
        if (txaDescription.getText().trim().equalsIgnoreCase("")) {
            txaDescription.setText("Description");
        }
    }//GEN-LAST:event_txaDescriptionFocusLost

    private void lblPrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPrintMouseClicked
        if(isActivated){
            if (validateAllPages()) {
                Print.printCatalogue(catalogue);
            }
        }
    }//GEN-LAST:event_lblPrintMouseClicked

    private void ftxStartDateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftxStartDateKeyReleased
        String catalogueStartDateString = ftxStartDate.getText().trim();
        validateStartDate(catalogueStartDateString);
    }//GEN-LAST:event_ftxStartDateKeyReleased

    private void ftxEndDateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftxEndDateKeyReleased
        String catalogueStartDateString = ftxStartDate.getText().trim();
        String catalogueEndDateString = ftxEndDate.getText().trim();
        validateEndDate(catalogueStartDateString, catalogueEndDateString);
    }//GEN-LAST:event_ftxEndDateKeyReleased

    private void btnStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatusActionPerformed
            String catalogueStatus = ProductCatalogue.ACTIVE;
            // Set new Product Catalogue status as active or inactive
            switch (catalogue.getCatalogueStatus()) {
                case ProductCatalogue.ACTIVE:
                    catalogueStatus = ProductCatalogue.INACTIVE;
                    lblEditIcon.setEnabled(false);
                    isActivated = false;
                    break;
            
                case ProductCatalogue.INACTIVE:
                    catalogueStatus = ProductCatalogue.ACTIVE;
                    lblEditIcon.setEnabled(true);
                    isActivated = true;
                    break;
            }

            // Update the Product Catalogue information
            ProductCatalogue modifiedCatalogue = new ProductCatalogue(catalogue.getCatalogueId(), catalogue.getCatalogueTitle(), catalogue.getCatalogueBannerPath(), catalogue.getCatalogueDescription(), catalogue.getCatalogueStartDate(), catalogue.getCatalogueEndDate(), catalogue.getCatalogueGeneratedDateTime(), catalogue.getCatalogueUserId(), catalogueStatus);
            if (ProductCatalogue.modify(modifiedCatalogue, catalogue.getCatalogueStatus())) {
                catalogue = modifiedCatalogue;
                resetFields();
            }
        
    }//GEN-LAST:event_btnStatusActionPerformed

    private void txtTitleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTitleKeyReleased
        String catalogueTitle = txtTitle.getText().trim();
        validateTitle(catalogueTitle);
    }//GEN-LAST:event_txtTitleKeyReleased

    private void txaDescriptionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaDescriptionKeyReleased
        String catalogueDescription = txaDescription.getText().trim();
        validateDescription(catalogueDescription);
    }//GEN-LAST:event_txaDescriptionKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStatus;
    private javax.swing.JFormattedTextField ftxEndDate;
    private javax.swing.JFormattedTextField ftxStartDate;
    private javax.swing.JLabel lblControl;
    private javax.swing.JLabel lblCreatedBy;
    private javax.swing.JLabel lblDash;
    private javax.swing.JLabel lblDescriptionError;
    private javax.swing.JLabel lblEditCatalogue;
    private javax.swing.JLabel lblEditIcon;
    private javax.swing.JLabel lblEditPage;
    private javax.swing.JLabel lblEndDateError;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblImageError;
    private javax.swing.JLabel lblNum;
    private javax.swing.JLabel lblNumberofPages;
    private javax.swing.JLabel lblPageNumbers;
    private javax.swing.JLabel lblPrint;
    private javax.swing.JLabel lblSaveIcon;
    private javax.swing.JLabel lblStartDateError;
    private javax.swing.JLabel lblTitleError;
    private javax.swing.JLabel lblUserId;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlBox;
    private javax.swing.JPanel pnlEditDropDownList;
    private javax.swing.JScrollPane scrDescription;
    private javax.swing.JTextArea txaDescription;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
