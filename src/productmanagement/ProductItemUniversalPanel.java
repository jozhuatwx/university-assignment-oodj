package productmanagement;

import java.awt.Cursor;
import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ProductItemUniversalPanel extends javax.swing.JPanel {
    // Constant fields
    public static final int MAIN_HEIGHT = 260;
    public static final int MAIN_WIDTH = 755;
    public static final int PANEL_HEIGHT = 238;
    public static final int PANEL_WIDTH = 735;

    // Product Item information
    ProductItem item;
    int itemQuantity;

    // Keeps track of temporary image file path
    String imageFilePath;

    // Create a variable to check the textbox is enabled or disabled 
    boolean isEditing = false;

    public ProductItemUniversalPanel(ProductItem item, int i) {
        initComponents();
        // Set the Product Item information
        this.item = item;
        imageFilePath = item.getItemImagePath();
        // Set the list number
        lblNum.setText(String.valueOf(i) + ".");
        resetFields();
        resetCategory();
        resetSupplier();
    }

    private void resetFields() {
        // Fill the fields with Product Item information
        txtName.setText(item.getItemName());
        txtBrand.setText(item.getItemBrand());
        txtSellingPrice.setText(String.valueOf(Math.round(item.getItemPrice())));
        txaDescription.setText(item.getItemDescription());
        lblInsertImage.setIcon(new ImageIcon(getClass().getResource(item.getItemImagePath())));

        switch (item.getItemStatus()) {
            case ProductItem.ACTIVE:
                btnStatus.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/switch-on.png")));
                break;
        
            case ProductItem.INACTIVE:
                btnStatus.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/switch-off.png")));
                break;
        }

        // Get the Item quantity from Inventory Transaction
        itemQuantity = InventoryTransaction.getItemQuantity(item.getItemId());
        txtQuantity.setText(String.valueOf(itemQuantity));
    }

    private void resetCategory() {
        // Remove existing Categories
        cmbCategory.removeAll();

        ArrayList<String> categoryArray = ReadObject.readArray(ProductCategory.FILE_NAME);
        // Iterate through the Category array
        for (String category : categoryArray) {
            // Split the line into an array
            String[] details = category.split(";");
            String comboItem = details[0] + ": " + details[1];
            // Add the item into the combobox
            cmbCategory.addItem(comboItem);
            // Set selected Category
            if (details[0].equals(item.getItemCategoryId())) {
                cmbCategory.setSelectedItem(comboItem);
            }
        }
    }

    private void resetSupplier() {
        // Remove existing Suppliers
        cmbSupplier.removeAll();

        ArrayList<String> supplierArray = ReadObject.readArray(Supplier.FILE_NAME);
        // Iterate through the Supplier array
        for (String supplier : supplierArray) {
            // Split the line into an array
            String[] details = supplier.split(";");
            String comboItem = details[0] + ": " + details[1];
            // Add the item into the combobox
            cmbSupplier.addItem(comboItem);
            // Set selected Supplier
            if (details[0].equals(item.getItemSupplierId())) {
                cmbSupplier.setSelectedItem(comboItem);
            }
        }
    }

    // Create a method to resize the image and label
    private ImageIcon resizeImage(String imagePath){
        int x, y;
        
        // Get the imageicon and get the width & height of the image
        ImageIcon MyImage = new ImageIcon(imagePath);
        x = MyImage.getIconWidth();
        y = MyImage.getIconHeight();
        
        // To differentiate the dimension of image (horizontal,vertical or square)
        // To resize the label based on the dimension
        if (x > y) {
            // If the width longer than height, then it is a horizontal image
            lblInsertImage.setSize(160,128);
        } else if (y > x){
            // If the height longer than width, then it is a vertical image
            lblInsertImage.setSize(102, 128);
        } else {
            // The width is equal to the height, then it is a square image
            lblInsertImage.setSize(128, 128);
        }
        
        // Resize the image to the size of the label
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(lblInsertImage.getWidth(),lblInsertImage.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    // Validation
    private boolean validateName(String itemName) {
        boolean validated = true;

        if (itemName.length() <= 0 || itemName.equalsIgnoreCase("Name")) {
            lblNameError.setText("Item Name cannot be empty");
            validated = false;
        } else if (!itemName.matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")) {
            lblNameError.setText("Please enter a valid name");
            validated = false;
        }

        if (validated) {
            lblNameError.setText(" ");
        }
        return validated;
    }

    private boolean validateBrand(String itemBrand) {
        boolean validated = true;

        if (itemBrand.length() <= 0 || itemBrand.equalsIgnoreCase("Brand")) {
            lblBrandError.setText("Item Brand cannot be empty");
            validated = false;
        } else if (itemBrand.contains(";")) {
            lblBrandError.setText("Item Brand cannot contain semi-colons");
            validated = false;
        }
        
        if (validated) {
            lblBrandError.setText(" ");
        }
        return validated;
    }

    private boolean validatePrice(String itemPriceString) {
        boolean validated = true;

        try {
            if (itemPriceString.length() <= 0) {
                lblSellingPriceError.setText("Item Price cannot be empty");
                validated = false;
            } else {
                Integer.valueOf(itemPriceString);
            }
        } catch (NumberFormatException e) {
            lblSellingPriceError.setText("Please enter a valid number");
            validated = false;
        }

        if (validated) {
            lblSellingPriceError.setText(" ");
        }
        return validated;
    }

    private boolean validateQuantity(String itemQuantityString) {
        boolean validated = true;

        try {
            if (itemQuantityString.length() <= 0) {
                lblQuantityError.setText("Item Quantity cannot be empty");
                validated = false;
            } else {
                Integer.valueOf(itemQuantityString);
            }
        } catch (NumberFormatException e) {
            lblQuantityError.setText("Please enter a valid number");
            validated = false;
        }

        if (validated) {
            lblQuantityError.setText(" ");
        }
        return validated;
    }

    private boolean validateDescription(String itemDescription) {
        boolean validated = true;
        
        if (itemDescription.length() <= 0 || itemDescription.equalsIgnoreCase("Description")) {
            lblDescriptionError.setText("Category Description cannot be empty");
            validated = false;
        }else if (itemDescription.contains(";")) {
            lblDescriptionError.setText("Item Description cannot contain semi-colons");
            validated = false;
        }

        if (validated) {
            lblDescriptionError.setText(" ");
        }
        return validated;
    }

    private boolean validateImagePath(String itemImageTempPath) {
        boolean validated = true;

        if (itemImageTempPath.length() <= 0) {
            lblImageError.setText("Item Image cannot be empty");
            validated = false;
        }

        if (validated) {
            lblImageError.setText(" ");
        }
        return validated;
    }

    private boolean validateSupplierId(String itemSupplierId) {
        boolean validated = true;

        if (itemSupplierId.length() <= 0) {
            lblSupplierError.setText("Please select a supplier");
            validated = false;
        }

        if (validated) {
            lblSupplierError.setText(" ");
        }
        return validated;
    }

    private boolean validateCategoryId(String itemCategoryId) {
        boolean validated = true;

        if (itemCategoryId.length() <= 0) {
            lblCategoryError.setText("Please select a category");
            validated = false;
        }

        if (validated) {
            lblCategoryError.setText(" ");
        }
        return validated;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new javax.swing.JPanel();
        lblNum = new javax.swing.JLabel();
        lblInsertImage = new javax.swing.JLabel();
        lblImageError = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblNameError = new javax.swing.JLabel();
        cmbSupplier = new javax.swing.JComboBox<>();
        lblSupplierError = new javax.swing.JLabel();
        cmbCategory = new javax.swing.JComboBox<>();
        lblCategoryError = new javax.swing.JLabel();
        scrDescription = new javax.swing.JScrollPane();
        txaDescription = new javax.swing.JTextArea();
        lblDescriptionError = new javax.swing.JLabel();
        txtBrand = new javax.swing.JTextField();
        lblBrandError = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        lblQuantityError = new javax.swing.JLabel();
        txtSellingPrice = new javax.swing.JTextField();
        lblSellingPriceError = new javax.swing.JLabel();
        btnStatus = new javax.swing.JButton();
        lblEdit = new javax.swing.JLabel();

        setBackground(new java.awt.Color(46, 52, 66));

        pnlBackground.setBackground(new java.awt.Color(255, 255, 255));
        pnlBackground.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblNum.setBackground(new java.awt.Color(0, 0, 0));
        lblNum.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNum.setText("1.");
        lblNum.setPreferredSize(new java.awt.Dimension(40, 30));

        lblInsertImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblInsertImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblInsertImage.setEnabled(false);
        lblInsertImage.setPreferredSize(new java.awt.Dimension(160, 128));
        lblInsertImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblInsertImageMouseClicked(evt);
            }
        });

        lblImageError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblImageError.setForeground(new java.awt.Color(255, 0, 0));
        lblImageError.setText(" ");

        txtName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtName.setText("Name");
        txtName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtName.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtName.setEnabled(false);
        txtName.setMaximumSize(new java.awt.Dimension(225, 30));
        txtName.setMinimumSize(new java.awt.Dimension(225, 30));
        txtName.setPreferredSize(new java.awt.Dimension(225, 30));
        txtName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNameFocusLost(evt);
            }
        });
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNameKeyReleased(evt);
            }
        });

        lblNameError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblNameError.setForeground(new java.awt.Color(255, 0, 0));
        lblNameError.setText(" ");

        cmbSupplier.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        cmbSupplier.setEnabled(false);
        cmbSupplier.setMaximumSize(new java.awt.Dimension(225, 30));
        cmbSupplier.setMinimumSize(new java.awt.Dimension(225, 30));
        cmbSupplier.setPreferredSize(new java.awt.Dimension(225, 30));

        lblSupplierError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblSupplierError.setForeground(new java.awt.Color(255, 0, 0));
        lblSupplierError.setText(" ");

        cmbCategory.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        cmbCategory.setEnabled(false);
        cmbCategory.setMaximumSize(new java.awt.Dimension(225, 30));
        cmbCategory.setMinimumSize(new java.awt.Dimension(225, 30));
        cmbCategory.setPreferredSize(new java.awt.Dimension(225, 30));

        lblCategoryError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblCategoryError.setForeground(new java.awt.Color(255, 0, 0));
        lblCategoryError.setText(" ");

        scrDescription.setMaximumSize(new java.awt.Dimension(225, 30));
        scrDescription.setMinimumSize(new java.awt.Dimension(225, 30));
        scrDescription.setPreferredSize(new java.awt.Dimension(225, 30));

        txaDescription.setColumns(15);
        txaDescription.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txaDescription.setRows(2);
        txaDescription.setText("Description\n");
        txaDescription.setEnabled(false);
        txaDescription.setMaximumSize(new java.awt.Dimension(225, 30));
        txaDescription.setMinimumSize(new java.awt.Dimension(225, 30));
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

        txtBrand.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtBrand.setText("Brand");
        txtBrand.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtBrand.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtBrand.setEnabled(false);
        txtBrand.setPreferredSize(new java.awt.Dimension(160, 30));
        txtBrand.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBrandFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBrandFocusLost(evt);
            }
        });
        txtBrand.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBrandKeyReleased(evt);
            }
        });

        lblBrandError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblBrandError.setForeground(new java.awt.Color(255, 0, 0));
        lblBrandError.setText(" ");

        txtQuantity.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtQuantity.setText("Quantity");
        txtQuantity.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtQuantity.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtQuantity.setEnabled(false);
        txtQuantity.setMaximumSize(new java.awt.Dimension(225, 30));
        txtQuantity.setMinimumSize(new java.awt.Dimension(225, 30));
        txtQuantity.setPreferredSize(new java.awt.Dimension(225, 30));
        txtQuantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtQuantityFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQuantityFocusLost(evt);
            }
        });
        txtQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQuantityKeyReleased(evt);
            }
        });

        lblQuantityError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblQuantityError.setForeground(new java.awt.Color(255, 0, 0));
        lblQuantityError.setText(" ");

        txtSellingPrice.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtSellingPrice.setText("Selling Price");
        txtSellingPrice.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtSellingPrice.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtSellingPrice.setEnabled(false);
        txtSellingPrice.setMaximumSize(new java.awt.Dimension(225, 30));
        txtSellingPrice.setMinimumSize(new java.awt.Dimension(225, 30));
        txtSellingPrice.setPreferredSize(new java.awt.Dimension(225, 30));
        txtSellingPrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSellingPriceFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSellingPriceFocusLost(evt);
            }
        });
        txtSellingPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSellingPriceKeyReleased(evt);
            }
        });

        lblSellingPriceError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblSellingPriceError.setForeground(new java.awt.Color(255, 0, 0));
        lblSellingPriceError.setText(" ");

        btnStatus.setBackground(new java.awt.Color(255, 255, 255));
        btnStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productmanagement/img/switch-on.png"))); // NOI18N
        btnStatus.setBorder(null);
        btnStatus.setMaximumSize(new java.awt.Dimension(30, 30));
        btnStatus.setMinimumSize(new java.awt.Dimension(30, 30));
        btnStatus.setPreferredSize(new java.awt.Dimension(30, 30));
        btnStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStatusMouseClicked(evt);
            }
        });

        lblEdit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productmanagement/img/Edit.png"))); // NOI18N
        lblEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEdit.setMaximumSize(new java.awt.Dimension(30, 30));
        lblEdit.setMinimumSize(new java.awt.Dimension(30, 30));
        lblEdit.setPreferredSize(new java.awt.Dimension(30, 30));
        lblEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEditMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBrandError, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(lblNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblImageError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblInsertImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cmbSupplier, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNameError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDescriptionError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scrDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSupplierError, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategoryError, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnlBackgroundLayout.createSequentialGroup()
                            .addComponent(btnStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblQuantityError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSellingPrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSellingPriceError, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lblNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(lblInsertImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblImageError)
                                .addGap(18, 18, 18)
                                .addComponent(txtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblBrandError))
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                                        .addComponent(lblNameError)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(scrDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblDescriptionError))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(lblQuantityError)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSellingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3)
                                        .addComponent(lblSellingPriceError)))
                                .addGap(18, 18, 18)
                                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                        .addComponent(cmbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblSupplierError))
                                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                        .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblCategoryError)))))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnStatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStatusMouseClicked
        if (isEditing) {
            String itemStatus = ProductItem.ACTIVE;
            // Set new Product Item status as active or inactive
            switch (item.getItemStatus()) {
                case ProductItem.ACTIVE:
                    itemStatus = ProductItem.INACTIVE;
                    break;
            
                case ProductItem.INACTIVE:
                    itemStatus = ProductItem.ACTIVE;
                    break;
            }

            // Update the Product Item information
            ProductItem modifiedItem = new ProductItem(item.getItemId(), item.getItemName(), item.getItemBrand(), item.getItemPrice(), item.getItemDescription(), item.getItemImagePath(), item.getItemSupplierId(), item.getItemCategoryId(), itemStatus);
            if (ProductItem.modify(modifiedItem, itemQuantity)) {
                item = modifiedItem;
                resetFields();
                resetCategory();
                resetSupplier();
            }
        }
    }//GEN-LAST:event_btnStatusMouseClicked

    private void lblEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditMouseClicked
        if (!isEditing) {
            // Enable editing of fields
            txtName.setEnabled(true);
            txtBrand.setEnabled(true);
            txtQuantity.setEnabled(true);
            txtSellingPrice.setEnabled(true);
            cmbSupplier.setEnabled(true);
            cmbCategory.setEnabled(true);
            txaDescription.setEnabled(true);
            lblInsertImage.setEnabled(true);
            btnStatus.setEnabled(true);
            btnStatus.setCursor(new Cursor(Cursor.HAND_CURSOR));

            // Change the icon from edit icon to save icon
            lblEdit.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/Save.png")));

            // When the textbox is enabled, set the boolean variable to true.
            isEditing = true;
        } else {
            boolean validated = true;

            String itemName = txtName.getText().trim();
            String itemBrand = txtBrand.getText().trim();
            String itemPriceString = txtSellingPrice.getText().trim();
            String itemQuantityString = txtQuantity.getText().trim();
            String itemDescription = txaDescription.getText().trim();
            String itemImageTempPath = imageFilePath;
            String itemSupplierId = String.valueOf(cmbSupplier.getSelectedItem()).substring(0, 9);
            String itemCategoryId = String.valueOf(cmbCategory.getSelectedItem()).substring(0, 10);

            try {
                // Validation
                if (!validateName(itemName)) {
                    validated = false;
                }

                if (!validateBrand(itemBrand)) {
                    validated = false;
                }

                if (!validatePrice(itemPriceString)) {
                    validated = false;
                }

                if (!validateQuantity(itemQuantityString)) {
                    validated = false;
                }

                if (!validateDescription(itemDescription)) {
                    validated = false;
                }

                if (!validateImagePath(itemImageTempPath)) {
                    validated = false;
                }

                if (!validateSupplierId(itemSupplierId)) {
                    validated = false;
                }

                if (!validateCategoryId(itemCategoryId)) {
                    validated = false;
                }
                
                if (validated) {
                    // Convert String to int
                    int itemPrice = Integer.valueOf(itemPriceString);
                    int itemQuantity = Integer.valueOf(itemQuantityString);

                    // Generate item id
                    String itemId = ProductItem.generateItemId();

                    // Copy image file to system
                    Path currentRelativePath = Paths.get("");
                    String itemImagePath = currentRelativePath.toAbsolutePath().toString() + "/src/productmanagement/img/productitem/" + itemId;
                    Path tempFilePath = Path.of(itemImageTempPath);
                    Path newFilePath = Path.of(itemImagePath);
                    Files.copy(tempFilePath, newFilePath);
                    
                    ProductItem modifiedItem = new ProductItem(itemId, itemName, itemBrand, itemPrice, itemDescription, itemImagePath, itemSupplierId, itemCategoryId, ProductItem.ACTIVE);
                    if (ProductItem.modify(modifiedItem, itemQuantity)) {
                        item = modifiedItem;
                        this.itemQuantity = itemQuantity;
                        resetFields();

                        // Disable the editing of fields
                        txtName.setEnabled(false);
                        txtBrand.setEnabled(false);
                        txtQuantity.setEnabled(false);
                        txtSellingPrice.setEnabled(false);
                        cmbSupplier.setEnabled(false);
                        cmbCategory.setEnabled(false);
                        txaDescription.setEnabled(false);
                        lblInsertImage.setEnabled(false);
                        btnStatus.setEnabled(false);
                        btnStatus.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

                        // Change the icon from save icon to edit icon
                        lblEdit.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/Edit.png")));
                        
                        // When the textbox is enabled, set the boolean variable to true.
                        isEditing = false;
                    }
                }
            } catch (Exception e) {
                // Display the error message
                JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_lblEditMouseClicked

    private void lblInsertImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInsertImageMouseClicked
        if (isEditing) {
            // To let the user insert the image after pressed the label
            JFileChooser file = new JFileChooser();
            
            // Set the home directory of the filechooser to user
            file.setCurrentDirectory(new File(System.getProperty("user.home")));
            
            // Create a new file name extension which including .jpg and .png file
            FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","png");
            file.addChoosableFileFilter(filter);
            int result = file.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION){
                File selectedFile = file.getSelectedFile();
                String path = selectedFile.getAbsolutePath();
                lblInsertImage.setIcon(resizeImage(path));
                imageFilePath = path;
            } else if (result == JFileChooser.CANCEL_OPTION){
                lblInsertImage.setIcon(new ImageIcon(getClass().getResource(item.getItemImagePath())));
                imageFilePath = item.getItemImagePath();
            }
        }
    }//GEN-LAST:event_lblInsertImageMouseClicked

    private void txtNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusGained
        if (txtName.getText().trim().equalsIgnoreCase("Name")) {
            txtName.setText("");
        }
    }//GEN-LAST:event_txtNameFocusGained

    private void txtNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusLost
        String itemName = txtName.getText().trim();
        validateName(itemName);
        
        if (txtName.getText().trim().equalsIgnoreCase("")) {
            txtName.setText("Name");
        }
    }//GEN-LAST:event_txtNameFocusLost

    private void txtQuantityFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantityFocusGained
        if (txtQuantity.getText().trim().equalsIgnoreCase("Quantity")) {
            txtQuantity.setText("");
        }
    }//GEN-LAST:event_txtQuantityFocusGained

    private void txtQuantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantityFocusLost
        String itemQuantityString = txtQuantity.getText().trim();
        validateQuantity(itemQuantityString);
        
        if (txtQuantity.getText().trim().equalsIgnoreCase("")) {
            txtQuantity.setText("Quantity");
        }
    }//GEN-LAST:event_txtQuantityFocusLost

    private void txtSellingPriceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSellingPriceFocusGained
        if (txtSellingPrice.getText().trim().equalsIgnoreCase("Selling Price")) {
            txtSellingPrice.setText("");
        }
    }//GEN-LAST:event_txtSellingPriceFocusGained

    private void txtSellingPriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSellingPriceFocusLost
        String itemPriceString = txtSellingPrice.getText().trim();
        validatePrice(itemPriceString);
        
        if (txtSellingPrice.getText().trim().equalsIgnoreCase("")) {
            txtSellingPrice.setText("Selling Price");
        }
    }//GEN-LAST:event_txtSellingPriceFocusLost

    private void txtBrandFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBrandFocusGained
        if (txtBrand.getText().trim().equalsIgnoreCase("Brand")) {
            txtBrand.setText("");
        }
    }//GEN-LAST:event_txtBrandFocusGained

    private void txtBrandFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBrandFocusLost
        String itemBrand = txtBrand.getText().trim();
        validateBrand(itemBrand);
        
        if (txtBrand.getText().trim().equalsIgnoreCase("")) {
            txtBrand.setText("Brand");
        }
    }//GEN-LAST:event_txtBrandFocusLost

    private void txaDescriptionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txaDescriptionFocusGained
        if (txaDescription.getText().trim().equalsIgnoreCase("Description")) {
            txaDescription.setText("");
        }
    }//GEN-LAST:event_txaDescriptionFocusGained

    private void txaDescriptionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txaDescriptionFocusLost
        String itemDescription = txaDescription.getText().trim();
        validateDescription(itemDescription);
        
        if (txaDescription.getText().trim().equalsIgnoreCase("")) {
            txaDescription.setText("Description");
        }
    }//GEN-LAST:event_txaDescriptionFocusLost

    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased
        String itemName = txtName.getText().trim();
        validateName(itemName);
    }//GEN-LAST:event_txtNameKeyReleased

    private void txtQuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyReleased
        String itemQuantityString = txtQuantity.getText().trim();
        validateQuantity(itemQuantityString);
    }//GEN-LAST:event_txtQuantityKeyReleased

    private void txtSellingPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSellingPriceKeyReleased
        String itemPriceString = txtSellingPrice.getText().trim();
        validatePrice(itemPriceString);
    }//GEN-LAST:event_txtSellingPriceKeyReleased

    private void txaDescriptionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaDescriptionKeyReleased
        String itemDescription = txaDescription.getText().trim();
        validateDescription(itemDescription);
    }//GEN-LAST:event_txaDescriptionKeyReleased

    private void txtBrandKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBrandKeyReleased
        String itemBrand = txtBrand.getText().trim();
        validateBrand(itemBrand);
    }//GEN-LAST:event_txtBrandKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStatus;
    private javax.swing.JComboBox<String> cmbCategory;
    private javax.swing.JComboBox<String> cmbSupplier;
    private javax.swing.JLabel lblBrandError;
    private javax.swing.JLabel lblCategoryError;
    private javax.swing.JLabel lblDescriptionError;
    private javax.swing.JLabel lblEdit;
    private javax.swing.JLabel lblImageError;
    private javax.swing.JLabel lblInsertImage;
    private javax.swing.JLabel lblNameError;
    private javax.swing.JLabel lblNum;
    private javax.swing.JLabel lblQuantityError;
    private javax.swing.JLabel lblSellingPriceError;
    private javax.swing.JLabel lblSupplierError;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JScrollPane scrDescription;
    private javax.swing.JTextArea txaDescription;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSellingPrice;
    // End of variables declaration//GEN-END:variables
}
