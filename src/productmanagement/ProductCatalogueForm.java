package productmanagement;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ProductCatalogueForm extends javax.swing.JFrame {
    int xMouse, yMouse;

    MainForm main;
    ProductCataloguePanel cataloguePanel;
    
    // Keeps track of temporary image file path
    String imageFilePath = "/productmanagement/img/InsertImage.png" , latestImageTempPath;

    public ProductCatalogueForm(MainForm main, ProductCataloguePanel cataloguePanel) {
        initComponents();
        this.main = main;
        this.cataloguePanel = cataloguePanel;
    }

    // Validation
    private boolean validateTitle(String catalogueTitle) {
        boolean validated = true;

        if (catalogueTitle.length() <= 0 || catalogueTitle.equalsIgnoreCase("Title")) {
            lblTitleError.setText("Title cannot be empty");
            validated = false;
        } else if (catalogueTitle.contains(";")) {
            lblTitleError.setText("Title cannot contain semi-colons");
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
            lblDescriptionError.setText("Description cannot be empty");
            validated = false;
        } else if (catalogueDescription.contains(";")) {
            lblDescriptionError.setText("Description cannot contain semi-colons");
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
                lblStartDateError.setText("Start Date cannot be empty");
                validated = false;
            } else {
                LocalDate startDate = LocalDate.parse(catalogueStartDateString, formatter);
                if (startDate.isBefore(LocalDate.now())) {
                    lblStartDateError.setText("Start Date cannot be before today");
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
                lblEndDateError.setText("End Date cannot be empty");
                validated = false;
            } else {
                LocalDate endDate = LocalDate.parse(catalogueEndDateString, formatter);
                if (validateStartDate(catalogueStartDateString)) {
                    LocalDate startDate = LocalDate.parse(catalogueStartDateString, formatter);
                    if (endDate.isBefore(startDate)) {
                        lblEndDateError.setText("End Date cannot be before the start date");
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

        if (catalogueImageTempPath.length() <= 0 || catalogueImageTempPath.equalsIgnoreCase("/productmanagement/img/InsertImage.png")) {
            lblImageError.setText("Image cannot be empty");
            validated = false;
        }

        if (validated) {
            lblImageError.setText(" ");
        }
        return validated;
    }
    
    private ImageIcon resizeImage(String imagePath) {
        // Get the imageicon
        ImageIcon MyImage = new ImageIcon(imagePath);
        
        // Resize the image to the size of the label
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance((int) lblImage.getPreferredSize().getWidth(),(int) lblImage.getPreferredSize().getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
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
        pnlFrameBar = new javax.swing.JPanel();
        lblClose = new javax.swing.JLabel();
        lblMinimize = new javax.swing.JLabel();
        pnlInformation = new javax.swing.JPanel();
        lblAddProductCatalogue = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        lblTitleError = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        scrDescription = new javax.swing.JScrollPane();
        txaDescription = new javax.swing.JTextArea();
        lblDescriptionError = new javax.swing.JLabel();
        lblStartDate = new javax.swing.JLabel();
        ftxStartDate = new javax.swing.JFormattedTextField();
        lblStartDateError = new javax.swing.JLabel();
        lblEndDate = new javax.swing.JLabel();
        ftxEndDate = new javax.swing.JFormattedTextField();
        lblEndDateError = new javax.swing.JLabel();
        lblBanner = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();
        lblImageError = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnlBackground.setBackground(new java.awt.Color(18, 22, 31));

        pnlFrameBar.setBackground(new java.awt.Color(0, 0, 51));
        pnlFrameBar.setPreferredSize(new java.awt.Dimension(670, 65));
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
                .addGap(0, 406, Short.MAX_VALUE)
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

        pnlInformation.setBackground(new java.awt.Color(46, 52, 66));

        lblAddProductCatalogue.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblAddProductCatalogue.setForeground(new java.awt.Color(255, 255, 255));
        lblAddProductCatalogue.setText("Add Product Catalogue");
        lblAddProductCatalogue.setPreferredSize(new java.awt.Dimension(110, 20));

        lblTitle.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Title :");
        lblTitle.setPreferredSize(new java.awt.Dimension(100, 30));

        txtTitle.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtTitle.setText("Title");
        txtTitle.setBorder(null);
        txtTitle.setPreferredSize(new java.awt.Dimension(250, 30));
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

        lblDescription.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblDescription.setForeground(new java.awt.Color(255, 255, 255));
        lblDescription.setText("Description :");
        lblDescription.setPreferredSize(new java.awt.Dimension(100, 30));

        txaDescription.setColumns(20);
        txaDescription.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txaDescription.setRows(5);
        txaDescription.setText("Description");
        txaDescription.setBorder(null);
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

        lblStartDate.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblStartDate.setForeground(new java.awt.Color(255, 255, 255));
        lblStartDate.setText("Start Date :");
        lblStartDate.setPreferredSize(new java.awt.Dimension(100, 30));

        ftxStartDate.setBorder(null);
        ftxStartDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        ftxStartDate.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        ftxStartDate.setPreferredSize(new java.awt.Dimension(250, 30));
        ftxStartDate.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void changedUpdate (javax.swing.event.DocumentEvent evt) {
                ftxStartDateUpdate(evt);
            }
            public void removeUpdate (javax.swing.event.DocumentEvent evt) {
                ftxStartDateUpdate(evt);
            }
            public void insertUpdate (javax.swing.event.DocumentEvent evt) {
                ftxStartDateUpdate(evt);
            }
        });
        ftxStartDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ftxStartDateFocusLost(evt);
            }
        });
        ftxStartDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ftxStartDateKeyReleased(evt);
            }
        });

        lblStartDateError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblStartDateError.setForeground(new java.awt.Color(255, 0, 0));
        lblStartDateError.setText(" ");

        lblEndDate.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblEndDate.setForeground(new java.awt.Color(255, 255, 255));
        lblEndDate.setText("End Date :");
        lblEndDate.setPreferredSize(new java.awt.Dimension(100, 30));

        ftxEndDate.setBorder(null);
        ftxEndDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        ftxEndDate.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        ftxEndDate.setPreferredSize(new java.awt.Dimension(250, 30));
        ftxStartDate.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void changedUpdate (javax.swing.event.DocumentEvent evt) {
                ftxEndDateUpdate(evt);
            }
            public void removeUpdate (javax.swing.event.DocumentEvent evt) {
                ftxEndDateUpdate(evt);
            }
            public void insertUpdate (javax.swing.event.DocumentEvent evt) {
                ftxEndDateUpdate(evt);
            }
        });
        ftxEndDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ftxEndDateFocusLost(evt);
            }
        });
        ftxEndDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ftxEndDateKeyReleased(evt);
            }
        });

        lblEndDateError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblEndDateError.setForeground(new java.awt.Color(255, 0, 0));
        lblEndDateError.setText(" ");

        lblBanner.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblBanner.setForeground(new java.awt.Color(255, 255, 255));
        lblBanner.setText("Banner :");
        lblBanner.setPreferredSize(new java.awt.Dimension(100, 30));

        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productmanagement/img/InsertImage.png"))); // NOI18N
        lblImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        lblImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblImage.setPreferredSize(new java.awt.Dimension(323, 60));
        lblImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImageMouseClicked(evt);
            }
        });

        lblImageError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblImageError.setForeground(new java.awt.Color(255, 0, 0));
        lblImageError.setText(" ");

        btnSubmit.setBackground(new java.awt.Color(46, 52, 66));
        btnSubmit.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("Add");
        btnSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel.setPreferredSize(new java.awt.Dimension(150, 40));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInformationLayout = new javax.swing.GroupLayout(pnlInformation);
        pnlInformation.setLayout(pnlInformationLayout);
        pnlInformationLayout.setHorizontalGroup(
            pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInformationLayout.createSequentialGroup()
                        .addComponent(lblAddProductCatalogue, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlInformationLayout.createSequentialGroup()
                        .addGroup(pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(pnlInformationLayout.createSequentialGroup()
                                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblTitleError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlInformationLayout.createSequentialGroup()
                                    .addGroup(pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ftxStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblDescriptionError, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(scrDescription)
                                        .addComponent(lblStartDateError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlInformationLayout.createSequentialGroup()
                                    .addComponent(lblEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblEndDateError, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ftxEndDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(pnlInformationLayout.createSequentialGroup()
                                .addComponent(lblBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlInformationLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlInformationLayout.createSequentialGroup()
                                        .addGroup(pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblImageError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlInformationLayout.setVerticalGroup(
            pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAddProductCatalogue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitleError)
                .addGap(18, 18, 18)
                .addGroup(pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInformationLayout.createSequentialGroup()
                        .addComponent(scrDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDescriptionError))
                    .addComponent(lblDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ftxStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStartDateError)
                .addGap(18, 18, 18)
                .addGroup(pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftxEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEndDateError)
                .addGap(18, 18, 18)
                .addGroup(pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblImageError)
                .addGap(18, 18, 18)
                .addGroup(pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFrameBar, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlFrameBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(pnlBackground, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(496, 572));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        int opt = 0;
        // Create a confirmation box
        opt = JOptionPane.showConfirmDialog(null, "You have unsaved work. Continue?", "Warning", JOptionPane.YES_NO_OPTION);
        
        if (opt == 0) {
            main.setVisible(true);
            main.isEditing = false;
            this.dispose();
        }
    }//GEN-LAST:event_lblCloseMouseClicked

    private void lblCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseEntered
        // To change the background colour to red colour
        lblClose.setBackground(Color.RED);
    }//GEN-LAST:event_lblCloseMouseEntered

    private void lblCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseExited
        // To change the background colour back to its original colour
        lblClose.setBackground(new Color(0,0,51));
    }//GEN-LAST:event_lblCloseMouseExited

    private void lblMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseClicked
        // Minimize the form.
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_lblMinimizeMouseClicked

    private void lblMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseEntered
        // To change the background colour to light gray colour
        lblMinimize.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_lblMinimizeMouseEntered

    private void lblMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseExited
        // To change the background colour back to its original colour
        lblMinimize.setBackground(new Color(0,0,51));
    }//GEN-LAST:event_lblMinimizeMouseExited

    private void pnlFrameBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlFrameBarMouseDragged
        // To get the absolute x,y on the screen when being dragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        // Set the form to the location of (x,y)
        this.setLocation(x - xMouse,y - yMouse);
    }//GEN-LAST:event_pnlFrameBarMouseDragged

    private void pnlFrameBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlFrameBarMousePressed
        // To get the x,y relative to the source component
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_pnlFrameBarMousePressed

    private void lblImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImageMouseClicked
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
            lblImageError.setText(" ");
        } else if (result == JFileChooser.CANCEL_OPTION){
            if (latestImageTempPath != null) {
                lblImage.setIcon(resizeImage(latestImageTempPath));
            } else {
                lblImage.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/InsertImage.png")));
                imageFilePath = "/productmanagement/img/InsertImage.png";
                lblImageError.setText("Catalogue Image cannot be empty");
            }
        }
    }//GEN-LAST:event_lblImageMouseClicked

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        int opt = 0;
        // Create a confirmation box
        opt = JOptionPane.showConfirmDialog(null, "You have unsaved work. Continue?", "Warning", JOptionPane.YES_NO_OPTION);
        
        if (opt == 0) {
            main.setVisible(true);
            main.isEditing = false;
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
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
                String catalogueId = ProductCatalogue.generateCatalogueId();

                // Copy image file to system
                Path tempPath = Path.of(catalogueImageTempPath);
                String newPathString = "/productmanagement/img/productcatalogue/";
                String fileName = catalogueId + catalogueImageTempPath.substring(catalogueImageTempPath.lastIndexOf("."));
                WriteObject.saveImage(tempPath, newPathString, fileName);
                String catalogueBannerPath = newPathString + fileName;

                ProductCatalogue catalogue = new ProductCatalogue(catalogueId, catalogueTitle, catalogueBannerPath, catalogueDescription, catalogueStartDate, catalogueEndDate, LocalDateTime.now(), User.myUser.getUserId(), ProductCatalogue.ACTIVE);
                if (ProductCatalogue.register(catalogue)) {
                    ProductCataloguePageForm pcpf = new ProductCataloguePageForm(main, cataloguePanel, catalogue);
                    pcpf.setVisible(true);
                    cataloguePanel.repopulateCatalogueList();
                    this.dispose();
                }
            }
        } catch (Exception e) {
            // Display the error message
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

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
        if (catalogueDescription.equalsIgnoreCase("")) {
            txaDescription.setText("Description");
        }
    }//GEN-LAST:event_txaDescriptionFocusLost

    private void txtTitleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTitleKeyReleased
        String catalogueTitle = txtTitle.getText().trim();
        validateTitle(catalogueTitle);
    }//GEN-LAST:event_txtTitleKeyReleased

    private void txaDescriptionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaDescriptionKeyReleased
        String catalogueDescription = txaDescription.getText().trim();
        validateDescription(catalogueDescription);
    }//GEN-LAST:event_txaDescriptionKeyReleased

    private void ftxEndDateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftxEndDateKeyReleased
        String catalogueStartDateString = ftxStartDate.getText().trim();
        String catalogueEndDateString = ftxEndDate.getText().trim();
        validateEndDate(catalogueStartDateString, catalogueEndDateString);
    }//GEN-LAST:event_ftxEndDateKeyReleased

    private void ftxStartDateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftxStartDateKeyReleased
        String catalogueStartDateString = ftxStartDate.getText().trim();
        validateStartDate(catalogueStartDateString);
    }//GEN-LAST:event_ftxStartDateKeyReleased

    private void ftxStartDateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ftxStartDateFocusLost
        String catalogueStartDateString = ftxStartDate.getText().trim();
        validateStartDate(catalogueStartDateString);
    }//GEN-LAST:event_ftxStartDateFocusLost

    private void ftxEndDateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ftxEndDateFocusLost
        String catalogueStartDateString = ftxStartDate.getText().trim();
        String catalogueEndDateString = ftxEndDate.getText().trim();
        validateEndDate(catalogueStartDateString, catalogueEndDateString);
    }//GEN-LAST:event_ftxEndDateFocusLost

    private void ftxStartDateUpdate(javax.swing.event.DocumentEvent evt) {
        String catalogueStartDateString = ftxStartDate.getText().trim();
        validateStartDate(catalogueStartDateString);
    }

    private void ftxEndDateUpdate(javax.swing.event.DocumentEvent evt) {
        String catalogueStartDateString = ftxStartDate.getText().trim();
        String catalogueEndDateString = ftxEndDate.getText().trim();
        validateEndDate(catalogueStartDateString, catalogueEndDateString);
    }


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
            java.util.logging.Logger.getLogger(ProductCatalogueForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductCatalogueForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductCatalogueForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductCatalogueForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        /*
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductCatalogueForm().setVisible(true);
            }
        });
        */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JFormattedTextField ftxEndDate;
    private javax.swing.JFormattedTextField ftxStartDate;
    private javax.swing.JLabel lblAddProductCatalogue;
    private javax.swing.JLabel lblBanner;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblDescriptionError;
    private javax.swing.JLabel lblEndDate;
    private javax.swing.JLabel lblEndDateError;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblImageError;
    private javax.swing.JLabel lblMinimize;
    private javax.swing.JLabel lblStartDate;
    private javax.swing.JLabel lblStartDateError;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitleError;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlFrameBar;
    private javax.swing.JPanel pnlInformation;
    private javax.swing.JScrollPane scrDescription;
    private javax.swing.JTextArea txaDescription;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
