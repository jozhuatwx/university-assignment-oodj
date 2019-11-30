package productmanagement;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ProductItemPanel extends javax.swing.JPanel {
    String imageFilePath = "/productmanagement/img/InsertImage.png";

    public ProductItemPanel() {
        initComponents();
        hideAddPanel();
        resetCategory();
        resetSupplier();
        repopulateItemList();
    }
    
    private void showAddPanel() {
        // Resize the Panel and show the components inside
        pnlAddItem.setPreferredSize(new Dimension(755, 633));
        pnlAddItem.revalidate();
        pnlAddItem.repaint();
    }

    private void hideAddPanel() {
        // Resize the Panel and hide the components inside
        pnlAddItem.setPreferredSize(new Dimension(755, 61));
        pnlAddItem.revalidate();
        pnlAddItem.repaint();
    }
    
    private void resetFields() {
        // Clear all fields
        txtName.setText("");
        txtBrand.setText("");
        txtSellingPrice.setText("");
        txtQuantity.setText("");
        txaDescription.setText("");
        lblInsertImage.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/InsertImage.png")));
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
        }
    }

    private void repopulateItemList() {
        pnlItemList.removeAll();
        
        int i = 0;
        ArrayList<String> itemArray = ReadObject.readArray(ProductItem.FILE_NAME);
        for (; i < itemArray.size(); i++) {
            String[] details = itemArray.get(i).split(";");
            ProductItem item = new ProductItem(details);
            ProductItemUniversalPanel iup = new ProductItemUniversalPanel(item, i + 1);
            iup.setPreferredSize(new Dimension(755, 245));
            pnlItemList.add(iup);
        }
        if (i * 245 < 385) {
            pnlItemList.add(Box.createRigidArea(new Dimension(0, 385 - (245 * i))));
        }
        pnlItemList.revalidate();
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

        if (itemName.length() <= 0) {
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

        if (itemBrand.length() <= 0) {
            lblBrandError.setText("Item Brand cannot be empty");
            validated = false;
        } else if (!itemBrand.contains(";")) {
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

        if (itemDescription.contains(";")) {
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

        if (itemImageTempPath.equalsIgnoreCase("/productmanagement/img/InsertImage.png")) {
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

        pnlAddItem = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        pnlAddItemForm = new javax.swing.JPanel();
        lblAddItem = new javax.swing.JLabel();
        lblCategory = new javax.swing.JLabel();
        cmbCategory = new javax.swing.JComboBox<>();
        lblCategoryError = new javax.swing.JLabel();
        lblSupplier = new javax.swing.JLabel();
        cmbSupplier = new javax.swing.JComboBox<>();
        lblSupplierError = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblNameError = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        lblQuantityError = new javax.swing.JLabel();
        lblBrand = new javax.swing.JLabel();
        txtBrand = new javax.swing.JTextField();
        lblBrandError = new javax.swing.JLabel();
        lblSellingPrice = new javax.swing.JLabel();
        txtSellingPrice = new javax.swing.JTextField();
        lblSellingPriceError = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        scrDescription = new javax.swing.JScrollPane();
        txaDescription = new javax.swing.JTextArea();
        lblDescriptionError = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();
        lblInsertImage = new javax.swing.JLabel();
        lblImageError = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        scrItemList = new javax.swing.JScrollPane();
        pnlItemList = new javax.swing.JPanel();

        setBackground(new java.awt.Color(18, 22, 31));

        pnlAddItem.setBackground(new java.awt.Color(46, 52, 66));
        pnlAddItem.setMaximumSize(new java.awt.Dimension(755, 32767));

        txtSearch.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtSearch.setBorder(null);
        txtSearch.setPreferredSize(new java.awt.Dimension(407, 37));
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(46, 52, 66));
        btnSearch.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productmanagement/img/Search.png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.setPreferredSize(new java.awt.Dimension(150, 40));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(46, 52, 66));
        btnAdd.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productmanagement/img/add.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setPreferredSize(new java.awt.Dimension(150, 40));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        pnlAddItemForm.setBackground(new java.awt.Color(18, 22, 31));
        pnlAddItemForm.setPreferredSize(new java.awt.Dimension(735, 571));

        lblAddItem.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblAddItem.setForeground(new java.awt.Color(255, 255, 255));
        lblAddItem.setText("Add Item");
        lblAddItem.setPreferredSize(new java.awt.Dimension(110, 20));

        lblCategory.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblCategory.setForeground(new java.awt.Color(255, 255, 255));
        lblCategory.setText("Category :");

        cmbCategory.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        cmbCategory.setBorder(null);
        cmbCategory.setMinimumSize(new java.awt.Dimension(350, 30));
        cmbCategory.setPreferredSize(new java.awt.Dimension(350, 30));

        lblCategoryError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblCategoryError.setForeground(new java.awt.Color(255, 0, 0));
        lblCategoryError.setText(" ");

        lblSupplier.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblSupplier.setForeground(new java.awt.Color(255, 255, 255));
        lblSupplier.setText("Supplier :");

        cmbSupplier.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        cmbSupplier.setMaximumSize(new java.awt.Dimension(350, 30));
        cmbSupplier.setMinimumSize(new java.awt.Dimension(350, 30));
        cmbSupplier.setPreferredSize(new java.awt.Dimension(350, 30));

        lblSupplierError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblSupplierError.setForeground(new java.awt.Color(255, 0, 0));
        lblSupplierError.setText(" ");

        lblName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setText("Name :");

        txtName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        txtName.setBorder(null);
        txtName.setMinimumSize(new java.awt.Dimension(350, 30));
        txtName.setPreferredSize(new java.awt.Dimension(350, 30));
        txtName.addFocusListener(new java.awt.event.FocusAdapter() {
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

        lblQuantity.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblQuantity.setForeground(new java.awt.Color(255, 255, 255));
        lblQuantity.setText("Quantity :");

        txtQuantity.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        txtQuantity.setBorder(null);
        txtQuantity.setMaximumSize(new java.awt.Dimension(350, 30));
        txtQuantity.setMinimumSize(new java.awt.Dimension(350, 30));
        txtQuantity.setPreferredSize(new java.awt.Dimension(350, 30));
        txtQuantity.addFocusListener(new java.awt.event.FocusAdapter() {
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

        lblBrand.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblBrand.setForeground(new java.awt.Color(255, 255, 255));
        lblBrand.setText("Brand :");

        txtBrand.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        txtBrand.setBorder(null);
        txtBrand.setMinimumSize(new java.awt.Dimension(350, 30));
        txtBrand.setPreferredSize(new java.awt.Dimension(350, 30));
        txtBrand.addFocusListener(new java.awt.event.FocusAdapter() {
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

        lblSellingPrice.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblSellingPrice.setForeground(new java.awt.Color(255, 255, 255));
        lblSellingPrice.setText("Selling Price :");

        txtSellingPrice.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        txtSellingPrice.setBorder(null);
        txtSellingPrice.setMaximumSize(new java.awt.Dimension(350, 30));
        txtSellingPrice.setMinimumSize(new java.awt.Dimension(350, 30));
        txtSellingPrice.setPreferredSize(new java.awt.Dimension(350, 30));
        txtSellingPrice.addFocusListener(new java.awt.event.FocusAdapter() {
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

        lblDescription.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblDescription.setForeground(new java.awt.Color(255, 255, 255));
        lblDescription.setText("Description :");

        scrDescription.setToolTipText("");

        txaDescription.setColumns(20);
        txaDescription.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        txaDescription.setRows(8);
        txaDescription.setBorder(null);
        txaDescription.addFocusListener(new java.awt.event.FocusAdapter() {
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

        lblImage.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblImage.setForeground(new java.awt.Color(255, 255, 255));
        lblImage.setText("Image :");

        lblInsertImage.setBackground(new java.awt.Color(255, 255, 255));
        lblInsertImage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblInsertImage.setForeground(new java.awt.Color(255, 255, 255));
        lblInsertImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productmanagement/img/InsertImage.png"))); // NOI18N
        lblInsertImage.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblInsertImage.setPreferredSize(new java.awt.Dimension(156, 128));
        lblInsertImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblInsertImageMouseClicked(evt);
            }
        });

        lblImageError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblImageError.setForeground(new java.awt.Color(255, 0, 0));
        lblImageError.setText(" ");

        btnSubmit.setBackground(new java.awt.Color(46, 52, 66));
        btnSubmit.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("Add");
        btnSubmit.setPreferredSize(new java.awt.Dimension(150, 40));
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(46, 52, 66));
        btnCancel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancel");
        btnCancel.setPreferredSize(new java.awt.Dimension(150, 40));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAddItemFormLayout = new javax.swing.GroupLayout(pnlAddItemForm);
        pnlAddItemForm.setLayout(pnlAddItemFormLayout);
        pnlAddItemFormLayout.setHorizontalGroup(
            pnlAddItemFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddItemFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAddItemFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAddItemFormLayout.createSequentialGroup()
                        .addGroup(pnlAddItemFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlAddItemFormLayout.createSequentialGroup()
                                .addGroup(pnlAddItemFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCategoryError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(pnlAddItemFormLayout.createSequentialGroup()
                                        .addGroup(pnlAddItemFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lblNameError, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cmbCategory, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(scrDescription, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtBrand, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE))
                                    .addGroup(pnlAddItemFormLayout.createSequentialGroup()
                                        .addGroup(pnlAddItemFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblDescription)
                                            .addComponent(lblName)
                                            .addComponent(lblBrand)
                                            .addComponent(lblBrandError, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, Short.MAX_VALUE))
                            .addGroup(pnlAddItemFormLayout.createSequentialGroup()
                                .addComponent(lblDescriptionError, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(pnlAddItemFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAddItemFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblImage)
                                .addComponent(lblSellingPrice)
                                .addComponent(lblQuantity)
                                .addComponent(lblSupplier)
                                .addComponent(cmbSupplier, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblSupplierError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblQuantityError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSellingPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblSellingPriceError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblInsertImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblImageError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAddItemFormLayout.createSequentialGroup()
                                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlAddItemFormLayout.createSequentialGroup()
                        .addGroup(pnlAddItemFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAddItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCategory))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlAddItemFormLayout.setVerticalGroup(
            pnlAddItemFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddItemFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlAddItemFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAddItemFormLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblCategory)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCategoryError)
                        .addGap(18, 18, 18)
                        .addComponent(lblName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAddItemFormLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblSupplier)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSupplierError)
                        .addGap(18, 18, 18)
                        .addComponent(lblQuantity)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlAddItemFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAddItemFormLayout.createSequentialGroup()
                        .addComponent(lblQuantityError)
                        .addGap(18, 18, 18)
                        .addComponent(lblSellingPrice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSellingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSellingPriceError)
                        .addGap(18, 18, 18)
                        .addComponent(lblImage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblInsertImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAddItemFormLayout.createSequentialGroup()
                        .addComponent(lblNameError)
                        .addGap(18, 18, 18)
                        .addComponent(lblBrand)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblBrandError)
                        .addGap(18, 18, 18)
                        .addComponent(lblDescription)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlAddItemFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblImageError)
                    .addComponent(lblDescriptionError))
                .addGap(18, 18, 18)
                .addGroup(pnlAddItemFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlAddItemLayout = new javax.swing.GroupLayout(pnlAddItem);
        pnlAddItem.setLayout(pnlAddItemLayout);
        pnlAddItemLayout.setHorizontalGroup(
            pnlAddItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddItemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAddItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlAddItemForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlAddItemLayout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlAddItemLayout.setVerticalGroup(
            pnlAddItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAddItemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAddItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(pnlAddItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlAddItemForm, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        scrItemList.setBackground(new java.awt.Color(46, 52, 66));
        scrItemList.setBorder(null);
        scrItemList.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrItemList.setToolTipText("");
        scrItemList.setPreferredSize(new java.awt.Dimension(755, 385));
        scrItemList.getVerticalScrollBar().setUnitIncrement(16);

        pnlItemList.setBackground(new java.awt.Color(46, 52, 66));
        pnlItemList.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        pnlItemList.setLayout(new javax.swing.BoxLayout(pnlItemList, javax.swing.BoxLayout.Y_AXIS));
        scrItemList.setViewportView(pnlItemList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlAddItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrItemList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrItemList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblInsertImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInsertImageMouseClicked
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
            lblInsertImage.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/InsertImage.png")));
            imageFilePath = "/productmanagement/img/InsertImage.png";
        }
    }//GEN-LAST:event_lblInsertImageMouseClicked

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        hideAddPanel();
        resetFields();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String keyword = txtSearch.getText().trim();

        hideAddPanel();
        pnlItemList.removeAll();
        
        int i = 0;
        ArrayList<ProductItem> itemArray = ProductItem.search(keyword);
        for (; i < itemArray.size(); i++) {
            ProductItemUniversalPanel iup = new ProductItemUniversalPanel(itemArray.get(i), i + 1);
            iup.setPreferredSize(new Dimension(755, 245));
            pnlItemList.add(iup);
        }
        if (i * 245 < 385) {
            pnlItemList.add(Box.createRigidArea(new Dimension(0, 385 - (245 * i))));
        }
        pnlItemList.revalidate();
        pnlItemList.repaint();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        showAddPanel();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
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
                
                ProductItem item = new ProductItem(itemId, itemName, itemBrand, itemPrice, itemDescription, itemImagePath, itemSupplierId, itemCategoryId, ProductItem.ACTIVE);
                if (ProductItem.register(item, itemQuantity)) {
                    resetFields();
                }
            }
        } catch (Exception e) {
            // Display the error message
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased
        String itemName = txtName.getText().trim();
        validateName(itemName);
    }//GEN-LAST:event_txtNameKeyReleased

    private void txtNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusLost
        String itemName = txtName.getText().trim();
        validateName(itemName);
    }//GEN-LAST:event_txtNameFocusLost

    private void txtQuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyReleased
        String itemQuantityString = txtQuantity.getText().trim();
        validateQuantity(itemQuantityString);
    }//GEN-LAST:event_txtQuantityKeyReleased

    private void txtQuantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantityFocusLost
        String itemQuantityString = txtQuantity.getText().trim();
        validateQuantity(itemQuantityString);
    }//GEN-LAST:event_txtQuantityFocusLost

    private void txtBrandKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBrandKeyReleased
        String itemBrand = txtBrand.getText().trim();
        validateBrand(itemBrand);
    }//GEN-LAST:event_txtBrandKeyReleased

    private void txtBrandFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBrandFocusLost
        String itemBrand = txtBrand.getText().trim();
        validateBrand(itemBrand);
    }//GEN-LAST:event_txtBrandFocusLost

    private void txtSellingPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSellingPriceKeyReleased
        String itemPriceString = txtSellingPrice.getText().trim();
        validatePrice(itemPriceString);
    }//GEN-LAST:event_txtSellingPriceKeyReleased

    private void txtSellingPriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSellingPriceFocusLost
        String itemPriceString = txtSellingPrice.getText().trim();
        validatePrice(itemPriceString);
    }//GEN-LAST:event_txtSellingPriceFocusLost

    private void txaDescriptionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaDescriptionKeyReleased
        String itemDescription = txaDescription.getText().trim();
        validateDescription(itemDescription);
    }//GEN-LAST:event_txaDescriptionKeyReleased

    private void txaDescriptionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txaDescriptionFocusLost
        String itemDescription = txaDescription.getText().trim();
        validateDescription(itemDescription);
    }//GEN-LAST:event_txaDescriptionFocusLost

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String keyword = txtSearch.getText().trim();

        hideAddPanel();
        pnlItemList.removeAll();
        
        int i = 0;
        ArrayList<ProductItem> itemArray = ProductItem.search(keyword);
        for (; i < itemArray.size(); i++) {
            ProductItemUniversalPanel iup = new ProductItemUniversalPanel(itemArray.get(i), i + 1);
            iup.setPreferredSize(new Dimension(755, 245));
            pnlItemList.add(iup);
        }
        if (i * 245 < 385) {
            pnlItemList.add(Box.createRigidArea(new Dimension(0, 385 - (245 * i))));
        }
        pnlItemList.revalidate();
        pnlItemList.repaint();
    }//GEN-LAST:event_txtSearchKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> cmbCategory;
    private javax.swing.JComboBox<String> cmbSupplier;
    private javax.swing.JLabel lblAddItem;
    private javax.swing.JLabel lblBrand;
    private javax.swing.JLabel lblBrandError;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblCategoryError;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblDescriptionError;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblImageError;
    private javax.swing.JLabel lblInsertImage;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNameError;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblQuantityError;
    private javax.swing.JLabel lblSellingPrice;
    private javax.swing.JLabel lblSellingPriceError;
    private javax.swing.JLabel lblSupplier;
    private javax.swing.JLabel lblSupplierError;
    private javax.swing.JPanel pnlAddItem;
    private javax.swing.JPanel pnlAddItemForm;
    private javax.swing.JPanel pnlItemList;
    private javax.swing.JScrollPane scrDescription;
    private javax.swing.JScrollPane scrItemList;
    private javax.swing.JTextArea txaDescription;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSellingPrice;
    // End of variables declaration//GEN-END:variables
}