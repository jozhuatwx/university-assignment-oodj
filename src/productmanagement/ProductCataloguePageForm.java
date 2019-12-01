package productmanagement;

import java.awt.Color;
import javax.swing.JFrame;

public class ProductCataloguePageForm extends javax.swing.JFrame {
    public ProductCatalogue catalogue;
    private static ProductCataloguePage page;

    private int xMouse, yMouse;

    public ProductCataloguePageForm() {
        initComponents();
        update();
    }

    // TODO: THIS IS TEMPORARY
    private void update() {
        int numOfItem = cmbNumOfItem.getSelectedIndex() + 1;
        
        switch (numOfItem) {
            case 4:
                lblItem4.setVisible(true);
                cmbItem4.setVisible(true);
            case 3:
                lblItem3.setVisible(true);
                cmbItem3.setVisible(true);
            case 2:
                lblItem2.setVisible(true);
                cmbItem2.setVisible(true);
            default:
                lblItem1.setVisible(true);
                cmbItem1.setVisible(true);
                break;
        }

        switch (numOfItem) {
            case 1:
                lblItem2.setVisible(false);
                cmbItem2.setVisible(false);
            case 2:
                lblItem3.setVisible(false);
                cmbItem3.setVisible(false);
            case 4:
                break;
            default:
                lblItem4.setVisible(false);
                cmbItem4.setVisible(false);
                break;
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
        lblItem2 = new javax.swing.JLabel();
        cmbItem2 = new javax.swing.JComboBox<>();
        lblItem3 = new javax.swing.JLabel();
        cmbItem3 = new javax.swing.JComboBox<>();
        lblItem4 = new javax.swing.JLabel();
        cmbItem4 = new javax.swing.JComboBox<>();
        btnSubmit = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblPrint = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AddProductCatalogueForm");
        setName("AddProductCatalogueForm"); // NOI18N
        setUndecorated(true);

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

        pnlBackground.setBackground(new java.awt.Color(0, 0, 51));

        pnlCatalogue.setBackground(new java.awt.Color(255, 255, 255));
        pnlCatalogue.setPreferredSize(new java.awt.Dimension(425, 600));

        javax.swing.GroupLayout pnlCatalogueLayout = new javax.swing.GroupLayout(pnlCatalogue);
        pnlCatalogue.setLayout(pnlCatalogueLayout);
        pnlCatalogueLayout.setHorizontalGroup(
            pnlCatalogueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
        );
        pnlCatalogueLayout.setVerticalGroup(
            pnlCatalogueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlOption.setBackground(new java.awt.Color(46, 52, 66));

        lblCatalogueTitle.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblCatalogueTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblCatalogueTitle.setText("Catalogue Title");
        lblCatalogueTitle.setPreferredSize(new java.awt.Dimension(130, 30));

        lblPageNum.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblPageNum.setForeground(new java.awt.Color(255, 255, 255));
        lblPageNum.setText("Page Number :");
        lblPageNum.setPreferredSize(new java.awt.Dimension(130, 30));

        cmbPageNum.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        cmbPageNum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbPageNum.setPreferredSize(new java.awt.Dimension(100, 30));
        cmbPageNum.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPageNumItemStateChanged(evt);
            }
        });

        lblTotalPages.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblTotalPages.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalPages.setText("/ 1000");
        lblTotalPages.setPreferredSize(new java.awt.Dimension(42, 30));

        lblAddPages.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddPages.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productmanagement/img/InsertImage.png"))); // NOI18N
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

        cmbNumOfItem.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        cmbNumOfItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        cmbNumOfItem.setPreferredSize(new java.awt.Dimension(200, 30));
        cmbNumOfItem.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbNumOfItemItemStateChanged(evt);
            }
        });

        lblItem1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblItem1.setForeground(new java.awt.Color(255, 255, 255));
        lblItem1.setText("Item 1 :");
        lblItem1.setPreferredSize(new java.awt.Dimension(130, 30));

        cmbItem1.setEditable(true);
        cmbItem1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        cmbItem1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbItem1.setPreferredSize(new java.awt.Dimension(200, 30));
        cmbItem1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbItem1ItemStateChanged(evt);
            }
        });

        lblItem2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblItem2.setForeground(new java.awt.Color(255, 255, 255));
        lblItem2.setText("Item 2 :");
        lblItem2.setPreferredSize(new java.awt.Dimension(130, 30));

        cmbItem2.setEditable(true);
        cmbItem2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        cmbItem2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbItem2.setPreferredSize(new java.awt.Dimension(200, 30));
        cmbItem2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbItem2ItemStateChanged(evt);
            }
        });

        lblItem3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblItem3.setForeground(new java.awt.Color(255, 255, 255));
        lblItem3.setText("Item 3 :");
        lblItem3.setPreferredSize(new java.awt.Dimension(130, 30));

        cmbItem3.setEditable(true);
        cmbItem3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        cmbItem3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbItem3.setPreferredSize(new java.awt.Dimension(200, 30));
        cmbItem3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbItem3ItemStateChanged(evt);
            }
        });

        lblItem4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblItem4.setForeground(new java.awt.Color(255, 255, 255));
        lblItem4.setText("Item 4 :");
        lblItem4.setPreferredSize(new java.awt.Dimension(130, 30));

        cmbItem4.setEditable(true);
        cmbItem4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        cmbItem4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbItem4.setPreferredSize(new java.awt.Dimension(200, 30));
        cmbItem4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbItem4ItemStateChanged(evt);
            }
        });

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
        lblPrint.setText("Print");
        lblPrint.setPreferredSize(new java.awt.Dimension(30, 30));
        lblPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPrintMouseClicked(evt);
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
                        .addComponent(lblNumOfItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbNumOfItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlOptionLayout.createSequentialGroup()
                                .addComponent(cmbPageNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblTotalPages, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblAddPages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlOptionLayout.createSequentialGroup()
                        .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCatalogueTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblItem4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPageNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblItem1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblItem2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblItem3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlOptionLayout.createSequentialGroup()
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(lblPrint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlOptionLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbItem4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbItem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbItem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbItem3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        pnlOptionLayout.setVerticalGroup(
            pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOptionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCatalogueTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlOptionLayout.createSequentialGroup()
                        .addComponent(lblItem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblItem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblItem3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblItem4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlOptionLayout.createSequentialGroup()
                        .addComponent(cmbItem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbItem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbItem3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbItem4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
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
                .addGap(12, 12, 12)
                .addComponent(pnlOption, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlCatalogue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlOption, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlFrameBar, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnlFrameBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(835, 647));
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
        // Close the form
        this.dispose();
    }//GEN-LAST:event_lblCloseMouseClicked

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void lblPrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPrintMouseClicked
        // TODO add your handling code here:
        Print.printPanel(pnlCatalogue); // DOES NOT PRINT THE WHOLE CATALOGUE YET
    }//GEN-LAST:event_lblPrintMouseClicked

    private void lblAddPagesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddPagesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblAddPagesMouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNextActionPerformed

    private void cmbPageNumItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPageNumItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPageNumItemStateChanged

    private void cmbNumOfItemItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbNumOfItemItemStateChanged
        update();
    }//GEN-LAST:event_cmbNumOfItemItemStateChanged

    private void cmbItem1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbItem1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbItem1ItemStateChanged

    private void cmbItem2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbItem2ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbItem2ItemStateChanged

    private void cmbItem3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbItem3ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbItem3ItemStateChanged

    private void cmbItem4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbItem4ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbItem4ItemStateChanged

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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductCataloguePageForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNext;
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
    private javax.swing.JLabel lblItem2;
    private javax.swing.JLabel lblItem3;
    private javax.swing.JLabel lblItem4;
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