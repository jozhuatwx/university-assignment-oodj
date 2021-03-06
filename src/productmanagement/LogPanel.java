package productmanagement;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.Box;

public class LogPanel extends javax.swing.JPanel {

    public LogPanel() {
        initComponents();
        // Populate the list with Logs
        repopulateLogList();
    }

    private void repopulateLogList() {
        // Remove all existing Logs
        pnlLogList.removeAll();

        int x = 0;
        ArrayList<String> logArray = ReadObject.readArray(Log.FILE_NAME);
        // Iterate through the Log array
        for (int i = logArray.size() - 1; i >= 0; i--, x++) {
            // Split the line into an array
            String[] details = logArray.get(i).split(";");
            // Create a Log object with the details
            Log log = new Log(details);
            // Create a Universal Panel object with the formatted log
            LogUniversalPanel lup = new LogUniversalPanel(log, x + 1);
            // Set the size of the Universal Panel
            lup.setPreferredSize(new Dimension(LogUniversalPanel.MAIN_WIDTH, LogUniversalPanel.MAIN_HEIGHT));
            // Add the Panel into the list
            pnlLogList.add(lup);
        }
        // Fill remaining space with an empty box
        if (x * LogUniversalPanel.MAIN_HEIGHT < 385) {
            pnlLogList.add(Box.createRigidArea(new Dimension(0, 385 - (LogUniversalPanel.MAIN_HEIGHT * x))));
        }
        pnlLogList.revalidate();
        pnlLogList.repaint();
    }

    private void search() {
        String keyword = txtSearch.getText().trim();

        // Remove all existing Logs
        pnlLogList.removeAll();
        
        int x = 0;
        // Get an array list of the Logs matching the keyword
        ArrayList<Log> logArray = Log.search(keyword);
        for (int i = logArray.size() - 1; i >= 0; i--, x++) {
            // Create a Universal Panel object with the formatted log
            LogUniversalPanel lup = new LogUniversalPanel(logArray.get(i), x + 1);
            // Set the size of the Universal Panel
            lup.setPreferredSize(new Dimension(LogUniversalPanel.MAIN_WIDTH, LogUniversalPanel.MAIN_HEIGHT));
            // Add the Panel into the list
            pnlLogList.add(lup);
        }
        // Fill remaining space with an empty box
        if (x * LogUniversalPanel.MAIN_HEIGHT < 385) {
            pnlLogList.add(Box.createRigidArea(new Dimension(0, 385 - (LogUniversalPanel.MAIN_HEIGHT * x))));
        }
        pnlLogList.revalidate();
        pnlLogList.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSearchItem = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        scrLogList = new javax.swing.JScrollPane();
        pnlLogList = new javax.swing.JPanel();

        setBackground(new java.awt.Color(18, 22, 31));

        pnlSearchItem.setBackground(new java.awt.Color(46, 52, 66));
        pnlSearchItem.setMaximumSize(new java.awt.Dimension(755, 32767));
        pnlSearchItem.setPreferredSize(new java.awt.Dimension(755, 61));

        txtSearch.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtSearch.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSearch.setText("Search");
        txtSearch.setBorder(null);
        txtSearch.setPreferredSize(new java.awt.Dimension(407, 40));
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchFocusLost(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout pnlSearchItemLayout = new javax.swing.GroupLayout(pnlSearchItem);
        pnlSearchItem.setLayout(pnlSearchItemLayout);
        pnlSearchItemLayout.setHorizontalGroup(
            pnlSearchItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchItemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSearchItemLayout.setVerticalGroup(
            pnlSearchItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchItemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        scrLogList.setBackground(new java.awt.Color(46, 52, 66));
        scrLogList.setBorder(null);
        scrLogList.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrLogList.setToolTipText("");
        scrLogList.setPreferredSize(new java.awt.Dimension(755, 385));
        scrLogList.getVerticalScrollBar().setUnitIncrement(16);

        pnlLogList.setBackground(new java.awt.Color(46, 52, 66));
        pnlLogList.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        pnlLogList.setLayout(new javax.swing.BoxLayout(pnlLogList, javax.swing.BoxLayout.Y_AXIS));
        scrLogList.setViewportView(pnlLogList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlSearchItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrLogList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSearchItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrLogList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        search();
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        if (txtSearch.getText().trim().equalsIgnoreCase("")) {
            txtSearch.setText("Search");
        }
    }//GEN-LAST:event_txtSearchFocusLost

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        if (txtSearch.getText().trim().equalsIgnoreCase("Search")) {
            txtSearch.setText("");
        }
    }//GEN-LAST:event_txtSearchFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlLogList;
    private javax.swing.JPanel pnlSearchItem;
    private javax.swing.JScrollPane scrLogList;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
