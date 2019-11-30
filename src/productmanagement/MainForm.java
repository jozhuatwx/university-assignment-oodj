package productmanagement;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainForm extends javax.swing.JFrame {
    int xMouse, yMouse;

    public MainForm() {
        initComponents();
        
        resetTabs();
        //Set the lblDashboard to white colour font and underlined. 
        lblDashboard.setForeground(new java.awt.Color(255, 255, 255));
        pnlUnderline.setVisible(true);
        
        // Open ProductManagerDashboardPanel initially
        //ProductManagerDashboardPanel dp = new ProductManagerDashboardPanel();
        ProductManagerDashboardPanel dp = new ProductManagerDashboardPanel();
        pnlContent.add(dp);
        pnlContent.revalidate();
    }

    public void resetTabs(){
        //Reset all the appearance of the tabs
        pnlUnderline.setVisible(false);
        pnlUnderline1.setVisible(false);
        pnlUnderline2.setVisible(false);
        pnlUnderline3.setVisible(false);
        pnlUnderline4.setVisible(false);
        pnlUnderline5.setVisible(false);
        
        lblDashboard.setForeground(new java.awt.Color(153,153,153));
        lblProfile.setForeground(new java.awt.Color(153,153,153));
        lblCategory.setForeground(new java.awt.Color(153,153,153));
        lblItem.setForeground(new java.awt.Color(153,153,153));
        lblSupplier.setForeground(new java.awt.Color(153,153,153));
        lblCatalogue.setForeground(new java.awt.Color(153,153,153));
        
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
        lblLogout = new javax.swing.JLabel();
        pnlTabs = new javax.swing.JPanel();
        lblDashboard = new javax.swing.JLabel();
        lblProfile = new javax.swing.JLabel();
        lblCategory = new javax.swing.JLabel();
        lblItem = new javax.swing.JLabel();
        lblSupplier = new javax.swing.JLabel();
        lblCatalogue = new javax.swing.JLabel();
        pnlUnderline = new javax.swing.JPanel();
        pnlUnderline1 = new javax.swing.JPanel();
        pnlUnderline2 = new javax.swing.JPanel();
        pnlUnderline3 = new javax.swing.JPanel();
        pnlUnderline4 = new javax.swing.JPanel();
        pnlUnderline5 = new javax.swing.JPanel();
        scrPanel = new javax.swing.JScrollPane();
        pnlContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard");
        setName("ProductManagerDashboardForm"); // NOI18N
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

        lblLogout.setBackground(new java.awt.Color(0, 0, 51));
        lblLogout.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        lblLogout.setForeground(new java.awt.Color(255, 255, 255));
        lblLogout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productmanagement/img/logout.png"))); // NOI18N
        lblLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLogout.setMaximumSize(new java.awt.Dimension(45, 25));
        lblLogout.setMinimumSize(new java.awt.Dimension(45, 25));
        lblLogout.setName("lblMinimize"); // NOI18N
        lblLogout.setOpaque(true);
        lblLogout.setPreferredSize(new java.awt.Dimension(45, 25));
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlFrameBarLayout = new javax.swing.GroupLayout(pnlFrameBar);
        pnlFrameBar.setLayout(pnlFrameBarLayout);
        pnlFrameBarLayout.setHorizontalGroup(
            pnlFrameBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFrameBarLayout.createSequentialGroup()
                .addComponent(lblLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlFrameBarLayout.setVerticalGroup(
            pnlFrameBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFrameBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFrameBarLayout.createSequentialGroup()
                .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlTabs.setBackground(new java.awt.Color(0, 0, 51));
        pnlTabs.setPreferredSize(new java.awt.Dimension(670, 65));
        pnlTabs.setRequestFocusEnabled(false);

        lblDashboard.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lblDashboard.setForeground(new java.awt.Color(255, 255, 255));
        lblDashboard.setText("Dashboard");
        lblDashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDashboardMouseClicked(evt);
            }
        });

        lblProfile.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lblProfile.setForeground(new java.awt.Color(153, 153, 153));
        lblProfile.setText("Profile");
        lblProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblProfileMouseClicked(evt);
            }
        });

        lblCategory.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lblCategory.setForeground(new java.awt.Color(153, 153, 153));
        lblCategory.setText("Category");
        lblCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCategoryMouseClicked(evt);
            }
        });

        lblItem.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lblItem.setForeground(new java.awt.Color(153, 153, 153));
        lblItem.setText("Item");
        lblItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblItemMouseClicked(evt);
            }
        });

        lblSupplier.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lblSupplier.setForeground(new java.awt.Color(153, 153, 153));
        lblSupplier.setText("Supplier");
        lblSupplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSupplierMouseClicked(evt);
            }
        });

        lblCatalogue.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lblCatalogue.setForeground(new java.awt.Color(153, 153, 153));
        lblCatalogue.setText("Catalogue");
        lblCatalogue.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCatalogue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCatalogueMouseClicked(evt);
            }
        });

        pnlUnderline.setBackground(new java.awt.Color(255, 255, 255));
        pnlUnderline.setPreferredSize(new java.awt.Dimension(100, 3));

        javax.swing.GroupLayout pnlUnderlineLayout = new javax.swing.GroupLayout(pnlUnderline);
        pnlUnderline.setLayout(pnlUnderlineLayout);
        pnlUnderlineLayout.setHorizontalGroup(
            pnlUnderlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        pnlUnderlineLayout.setVerticalGroup(
            pnlUnderlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        pnlUnderline1.setBackground(new java.awt.Color(255, 255, 255));
        pnlUnderline1.setPreferredSize(new java.awt.Dimension(100, 3));

        javax.swing.GroupLayout pnlUnderline1Layout = new javax.swing.GroupLayout(pnlUnderline1);
        pnlUnderline1.setLayout(pnlUnderline1Layout);
        pnlUnderline1Layout.setHorizontalGroup(
            pnlUnderline1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlUnderline1Layout.setVerticalGroup(
            pnlUnderline1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlUnderline2.setBackground(new java.awt.Color(255, 255, 255));
        pnlUnderline2.setPreferredSize(new java.awt.Dimension(100, 3));

        javax.swing.GroupLayout pnlUnderline2Layout = new javax.swing.GroupLayout(pnlUnderline2);
        pnlUnderline2.setLayout(pnlUnderline2Layout);
        pnlUnderline2Layout.setHorizontalGroup(
            pnlUnderline2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 83, Short.MAX_VALUE)
        );
        pnlUnderline2Layout.setVerticalGroup(
            pnlUnderline2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlUnderline3.setBackground(new java.awt.Color(255, 255, 255));
        pnlUnderline3.setPreferredSize(new java.awt.Dimension(100, 3));

        javax.swing.GroupLayout pnlUnderline3Layout = new javax.swing.GroupLayout(pnlUnderline3);
        pnlUnderline3.setLayout(pnlUnderline3Layout);
        pnlUnderline3Layout.setHorizontalGroup(
            pnlUnderline3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlUnderline3Layout.setVerticalGroup(
            pnlUnderline3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlUnderline4.setBackground(new java.awt.Color(255, 255, 255));
        pnlUnderline4.setPreferredSize(new java.awt.Dimension(100, 3));

        javax.swing.GroupLayout pnlUnderline4Layout = new javax.swing.GroupLayout(pnlUnderline4);
        pnlUnderline4.setLayout(pnlUnderline4Layout);
        pnlUnderline4Layout.setHorizontalGroup(
            pnlUnderline4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlUnderline4Layout.setVerticalGroup(
            pnlUnderline4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlUnderline5.setBackground(new java.awt.Color(255, 255, 255));
        pnlUnderline5.setPreferredSize(new java.awt.Dimension(100, 3));

        javax.swing.GroupLayout pnlUnderline5Layout = new javax.swing.GroupLayout(pnlUnderline5);
        pnlUnderline5.setLayout(pnlUnderline5Layout);
        pnlUnderline5Layout.setHorizontalGroup(
            pnlUnderline5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlUnderline5Layout.setVerticalGroup(
            pnlUnderline5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlTabsLayout = new javax.swing.GroupLayout(pnlTabs);
        pnlTabs.setLayout(pnlTabsLayout);
        pnlTabsLayout.setHorizontalGroup(
            pnlTabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTabsLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlTabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDashboard)
                    .addComponent(pnlUnderline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(pnlTabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlUnderline1, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addGroup(pnlTabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCategory)
                    .addComponent(pnlUnderline2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(pnlTabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlUnderline3, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(lblItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addGroup(pnlTabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlUnderline4, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addGroup(pnlTabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCatalogue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlUnderline5, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
                .addContainerGap(158, Short.MAX_VALUE))
        );
        pnlTabsLayout.setVerticalGroup(
            pnlTabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTabsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDashboard)
                    .addComponent(lblProfile)
                    .addComponent(lblItem)
                    .addComponent(lblSupplier)
                    .addComponent(lblCatalogue)
                    .addComponent(lblCategory))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlUnderline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlUnderline1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlUnderline3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlUnderline2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlUnderline4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlUnderline5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        scrPanel.setBackground(new java.awt.Color(18, 22, 31));
        scrPanel.setBorder(null);
        scrPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrPanel.getVerticalScrollBar().setUnitIncrement(16);

        pnlContent.setBackground(new java.awt.Color(18, 22, 31));
        pnlContent.setForeground(new java.awt.Color(255, 255, 255));
        pnlContent.setName(""); // NOI18N
        pnlContent.setLayout(new java.awt.BorderLayout());
        scrPanel.setViewportView(pnlContent);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTabs, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addComponent(pnlFrameBar, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addComponent(scrPanel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlFrameBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlTabs, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        setSize(new java.awt.Dimension(800, 550));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseExited
        // To change the background colour back to its original colour
        lblMinimize.setBackground(new Color(0,0,51));
    }//GEN-LAST:event_lblMinimizeMouseExited

    private void lblMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseEntered
        // To change the background colour to light gray colour
        lblMinimize.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_lblMinimizeMouseEntered

    private void lblMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseClicked
        // Minimize the form.
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
        System.exit(0);
    }//GEN-LAST:event_lblCloseMouseClicked

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

    private void lblProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProfileMouseClicked
        pnlContent.removeAll();
        ProfilePanel pp = new ProfilePanel();
        pnlContent.add(pp);
        pnlContent.revalidate();
        
        resetTabs();
        //Set the lblProfile to white colour font and underlined. 
        lblProfile.setForeground(new java.awt.Color(255, 255, 255));
        pnlUnderline1.setVisible(true);
    }//GEN-LAST:event_lblProfileMouseClicked

    private void lblDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDashboardMouseClicked
        pnlContent.removeAll();
        ProductManagerDashboardPanel dp = new ProductManagerDashboardPanel();
        pnlContent.add(dp);
        pnlContent.revalidate();
        
        resetTabs();
        //Set the lblDashboard to white colour font and underlined. 
        lblDashboard.setForeground(new java.awt.Color(255, 255, 255));
        pnlUnderline.setVisible(true);
    }//GEN-LAST:event_lblDashboardMouseClicked

    private void lblCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCategoryMouseClicked
        pnlContent.removeAll();
        ProductCategoryPanel cp = new ProductCategoryPanel();
        pnlContent.add(cp);
        pnlContent.revalidate();
        
        resetTabs();
        //Set the lblCategory to white colour font and underlined. 
        lblCategory.setForeground(new java.awt.Color(255, 255, 255));
        pnlUnderline2.setVisible(true);
    }//GEN-LAST:event_lblCategoryMouseClicked

    private void lblItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblItemMouseClicked
        pnlContent.removeAll();
        ProductItemPanel ip = new ProductItemPanel();
        pnlContent.add(ip);
        pnlContent.revalidate();
        
        resetTabs();
        //Set the lblItem to white colour font and underlined. 
        lblItem.setForeground(new java.awt.Color(255, 255, 255));
        pnlUnderline3.setVisible(true);
    }//GEN-LAST:event_lblItemMouseClicked

    private void lblSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSupplierMouseClicked
        pnlContent.removeAll();
        SupplierPanel sp = new SupplierPanel();
        //ProductManagerPanel sp = new ProductManagerPanel();
        pnlContent.add(sp);
        pnlContent.revalidate();
        
        resetTabs();
        //Set the lblSupplier to white colour font and underlined. 
        lblSupplier.setForeground(new java.awt.Color(255, 255, 255));
        pnlUnderline4.setVisible(true);
    }//GEN-LAST:event_lblSupplierMouseClicked

    private void lblCatalogueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCatalogueMouseClicked
        pnlContent.removeAll();
        ProductCataloguePanel pcp = new ProductCataloguePanel();
        pnlContent.add(pcp);
        pnlContent.revalidate();
        
        resetTabs();
        //Set the lblCatalogue to white colour font and underlined. 
        lblCatalogue.setForeground(new java.awt.Color(255, 255, 255));
        pnlUnderline5.setVisible(true);
    }//GEN-LAST:event_lblCatalogueMouseClicked

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
        int opt = JOptionPane.showConfirmDialog(null,"Are you sure want to log out? Your unsave information will be erased.","Log Out", JOptionPane.YES_NO_OPTION);
        
        if(opt == 0 ){
            LoginForm lf = new LoginForm();
            lf.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_lblLogoutMouseClicked

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblCatalogue;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblDashboard;
    private javax.swing.JLabel lblItem;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblMinimize;
    private javax.swing.JLabel lblProfile;
    private javax.swing.JLabel lblSupplier;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlFrameBar;
    private javax.swing.JPanel pnlTabs;
    private javax.swing.JPanel pnlUnderline;
    private javax.swing.JPanel pnlUnderline1;
    private javax.swing.JPanel pnlUnderline2;
    private javax.swing.JPanel pnlUnderline3;
    private javax.swing.JPanel pnlUnderline4;
    private javax.swing.JPanel pnlUnderline5;
    public javax.swing.JScrollPane scrPanel;
    // End of variables declaration//GEN-END:variables
}
