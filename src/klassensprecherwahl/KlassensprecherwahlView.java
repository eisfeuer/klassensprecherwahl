/*
 * KlassensprecherwahlView.java
 */

package klassensprecherwahl;

import java.awt.GridLayout;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The application's main frame.
 */
public class KlassensprecherwahlView extends FrameView {

    public KlassensprecherwahlView(SingleFrameApplication app) {
        super(app);

        initComponents();
        //wahlPanel.setVisible(false);
        //wahlzettelPanel.setVisible(false);
        //kandidatPanel.setVisible(false);
        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = KlassensprecherwahlApp.getApplication().getMainFrame();
            aboutBox = new KlassensprecherwahlAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        KlassensprecherwahlApp.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        mainPanel = new javax.swing.JPanel();
        wahlzettelPanel = new javax.swing.JPanel();
        kandidatPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listShow = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        insertName1 = new javax.swing.JTextField();
        addName = new javax.swing.JButton();
        next1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        kandidatenListe = new javax.swing.JTextArea();
        wahlPanel = new javax.swing.JPanel();
        btnNext = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        taThesen = new javax.swing.JTextArea();
        lblKandidat = new javax.swing.JLabel();

        menuBar.setName("menuBar"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(klassensprecherwahl.KlassensprecherwahlApp.class).getContext().getResourceMap(KlassensprecherwahlView.class);
        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(klassensprecherwahl.KlassensprecherwahlApp.class).getContext().getActionMap(KlassensprecherwahlView.class, this);
        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addComponent(statusMessageLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(statusAnimationLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, statusPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusMessageLabel)
                    .addComponent(statusAnimationLabel))
                .addGap(3, 3, 3)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mainPanel.setName("mainPanel"); // NOI18N

        wahlzettelPanel.setName("wahlzettelPanel"); // NOI18N

        javax.swing.GroupLayout wahlzettelPanelLayout = new javax.swing.GroupLayout(wahlzettelPanel);
        wahlzettelPanel.setLayout(wahlzettelPanelLayout);
        wahlzettelPanelLayout.setHorizontalGroup(
            wahlzettelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        wahlzettelPanelLayout.setVerticalGroup(
            wahlzettelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        kandidatPanel.setName("kandidatPanel"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        listShow.setName("listAnzeige"); // NOI18N
        jScrollPane1.setViewportView(listShow);

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        insertName1.setText(resourceMap.getString("insertName.text")); // NOI18N
        insertName1.setName("insertName"); // NOI18N

        addName.setText(resourceMap.getString("addName.text")); // NOI18N
        addName.setName("addName"); // NOI18N
        addName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNameActionPerformed(evt);
            }
        });

        next1.setText(resourceMap.getString("next1.text")); // NOI18N
        next1.setName("next1"); // NOI18N
        next1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next1ActionPerformed(evt);
            }
        });

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        kandidatenListe.setColumns(20);
        kandidatenListe.setRows(5);
        kandidatenListe.setName("kandidatenListe"); // NOI18N
        jScrollPane3.setViewportView(kandidatenListe);

        javax.swing.GroupLayout kandidatPanelLayout = new javax.swing.GroupLayout(kandidatPanel);
        kandidatPanel.setLayout(kandidatPanelLayout);
        kandidatPanelLayout.setHorizontalGroup(
            kandidatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kandidatPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kandidatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kandidatPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(next1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kandidatPanelLayout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addGroup(kandidatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kandidatPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(insertName1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addName))
                            .addComponent(jScrollPane3))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kandidatPanelLayout.setVerticalGroup(
            kandidatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kandidatPanelLayout.createSequentialGroup()
                .addGroup(kandidatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kandidatPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(kandidatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(insertName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1))
                        .addGap(35, 35, 35)
                        .addComponent(next1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))
                    .addGroup(kandidatPanelLayout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jScrollPane1)))
                .addGap(174, 174, 174))
        );

        wahlPanel.setBackground(resourceMap.getColor("wahlPanel.background")); // NOI18N
        wahlPanel.setName("wahlPanel"); // NOI18N

        btnNext.setText(resourceMap.getString("btnNext.text")); // NOI18N
        btnNext.setName("btnNext"); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        taThesen.setColumns(20);
        taThesen.setRows(5);
        taThesen.setName("taThesen"); // NOI18N
        jScrollPane2.setViewportView(taThesen);

        lblKandidat.setText(resourceMap.getString("lblKandidat.text")); // NOI18N
        lblKandidat.setName("lblKandidat"); // NOI18N

        javax.swing.GroupLayout wahlPanelLayout = new javax.swing.GroupLayout(wahlPanel);
        wahlPanel.setLayout(wahlPanelLayout);
        wahlPanelLayout.setHorizontalGroup(
            wahlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wahlPanelLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(wahlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, wahlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblKandidat)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnNext, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        wahlPanelLayout.setVerticalGroup(
            wahlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, wahlPanelLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(lblKandidat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNext)
                .addContainerGap())
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(kandidatPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(wahlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(wahlzettelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 591, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(kandidatPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(wahlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(wahlzettelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setComponent(kandidatPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void addNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNameActionPerformed
        wahl.addKandidat(insertName1.getText());
        update();
    }//GEN-LAST:event_addNameActionPerformed

    private void next1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next1ActionPerformed
        kandidatPanel.setVisible(false);
        setComponent(wahlPanel);
        nextKandidat();
        wahlPanel.setVisible(true);
        mainPanel.revalidate();
        setComponent(wahlzettelPanel);
    }//GEN-LAST:event_next1ActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        wahl.setThesen(taThesen.getText());
        nextKandidat();
    }//GEN-LAST:event_btnNextActionPerformed

    private void initWahlzettelPanel(){
        String[][] stimmzettel = wahl.getStimmzettel();
        int anzahlZeilen = stimmzettel.length;
        wahlzettelPanel.setLayout(new GridLayout(3,1));
        // Wahlzettel
        JPanel stimmzettelPanel = new JPanel();
        stimmzettelPanel.setLayout(new GridLayout(anzahlZeilen,7));
        for(int i = 0; i < anzahlZeilen; i++){
            JLabel label1 = new JLabel(stimmzettel[i][0]);
            JLabel label2 = new JLabel(stimmzettel[i][1]);
            stimmzettelPanel.add(label1);
            stimmzettelPanel.add(label2);
            for(int j = 0; j < 5; j++){
                JCheckBox checkbox = new JCheckBox();
                checkbox.addItemListener(new WahlItemListener(label1, i, stimme,cbCleaner));
                cbCleaner.addObserver(new CleanableCheckbox(checkbox,i));
                stimmzettelPanel.add(checkbox);
            }
        }
        // Buttom zum Abschicken
        JButton button = new JButton("Abschicken");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                wahl.commitStimmzettel(stimme);
                cbCleaner.cleanRow(CheckboxCleaner.ALL);
            }
        });
        JButton button2 = new JButton("Wahl beenden");
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                wahl.commitStimmzettel(stimme);
            }
        });
        wahlzettelPanel.add(stimmzettelPanel);
        wahlzettelPanel.add(button);
        wahlzettelPanel.add(button2);
    }
    
    private class WahlItemListener implements ItemListener{
        
        private final JLabel label;
        private final int position;
        private final String[] stimme;
        private final CheckboxCleaner cbc;
        
        public WahlItemListener(JLabel label, int pos, String[] stimme, CheckboxCleaner cbc){
            this.label = label;
            this.position = pos;
            this.stimme = stimme;
            this.cbc = cbc;
        }
        
        @Override
        public void itemStateChanged(ItemEvent evt){
            if(evt.getStateChange() == ItemEvent.DESELECTED){
                stimme[position] = null;
            } else {
                stimme[position] = label.getText();
                JCheckBox checkbox = (JCheckBox)evt.getSource();
                cbc.cleanRow(position);
                checkbox.setSelected(true);
            }
        }
        
    }
    
    private void update(){
        kandidatenListe.setText(wahl.getKandidaten());
    }
    
    private void nextKandidat(){
        String kandidat = wahl.getNext();
        System.out.println(kandidat);
        if(kandidat != null){
            wahlPanel.setVisible(false);
            initWahlzettelPanel();
            wahlzettelPanel.setVisible(true);
            setComponent(wahlzettelPanel);
        } else {
            lblKandidat.setText(kandidat + " gibt seine Thesen ein");
            taThesen.setText("");
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addName;
    private javax.swing.JButton btnNext;
    private javax.swing.JTextField insertName1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel kandidatPanel;
    private javax.swing.JTextArea kandidatenListe;
    private javax.swing.JLabel lblKandidat;
    private javax.swing.JList listShow;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton next1;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JTextArea taThesen;
    private javax.swing.JPanel wahlPanel;
    private javax.swing.JPanel wahlzettelPanel;
    // End of variables declaration//GEN-END:variables

    
    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;

    private JDialog aboutBox;
    private final Wahlcontroller wahl = new Wahlcontroller();
    private final String[] stimme = new String[5];
    private final CheckboxCleaner cbCleaner = new CheckboxCleaner();
}
