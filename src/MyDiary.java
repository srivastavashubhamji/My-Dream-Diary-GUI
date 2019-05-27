import java.awt.Color;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Base64;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.io.*;
import com.sun.speech.freetts.*;


public class MyDiary extends JFrame {
    private String uname,pass;
    private byte delCounter;
    private JButton[] parentButtons;
    private JPanel userSpecificButtonsPanel;
    
    private JFrame parentFrame;
    
    public MyDiary() {
        
        initComponents();        
        uname = "";
        pass = "";
// When User Logged in then, If 'Delete' clicked 1st time counter = 1( or odd) : Show Confirmation,
//                          else if counter = 2( or even) : Delete Notes
        delCounter = 0; 

        // this 'parentButtons' will help to hide these btns when user Logged In ...
        parentButtons = new JButton []{btnAbout,btnCreate,btnExit,btnLogin};
//        userSpecificButtonsPanel = specificButtonsPanel;

        setLayout(null);
        this.getContentPane().setBackground(new Color(120,0,120));
        this.setTitle("My Dream Diary - Shubham");
        this.setBounds(250,20,800,680);
        
        loginPanel.setVisible(false);
        loginPanel.setBounds(110,180,580,350);
        
        createPanel.setVisible(false);
        createPanel.setBounds(110,180,580,400);
        
        aboutUsPanel.setVisible(false);
        aboutUsPanel.setBounds(20,120,760,640);        
        
        lblLogErrMsg.setVisible(false);
        parentFrame = this;
//                      this.setBounds(250,20,800,680);
        specificButtonsPanel.setBounds(0,0,800,120);
        specificButtonsPanel.setVisible(false);
        
        specificPanel.setBounds(0,121,800,680);
        specificPanel.setVisible(false);
        
//        specificDelPanel.setBounds(210,180,580,250);
//        specificDelPanel.setVisible(false);
        specificDeletePanel.setBounds(110,200,580,200);
        specificDeletePanel.setVisible(false);
        
        btnSaveNotes.setVisible(false);
        btnSaveNotes.setText("Save");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        btnLogin = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnAbout = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        loginPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtLogUname = new javax.swing.JTextField();
        submitLogin = new javax.swing.JButton();
        txtLogPass = new javax.swing.JPasswordField();
        lblLogErrMsg = new javax.swing.JLabel();
        createPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCreUname = new javax.swing.JTextField();
        btnCreAcc = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtCrePass = new javax.swing.JPasswordField();
        txtCreRePass = new javax.swing.JPasswordField();
        lblCreErrMsg = new javax.swing.JLabel();
        aboutUsPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAboutUs = new javax.swing.JTextArea();
        specificButtonsPanel = new javax.swing.JPanel();
        btnShow = new javax.swing.JButton();
        btnWrite = new javax.swing.JButton();
        btnCally = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnCloseApp = new javax.swing.JButton();
        lblUname = new javax.swing.JLabel();
        btnSaveNotes = new javax.swing.JButton();
        specificPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaSpecificUser = new javax.swing.JTextArea();
        specificDeletePanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnSpecificConfirm = new javax.swing.JButton();
        btnSpecificCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(120, 0, 120));
        setName("parentFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(740, 680));
        setResizable(false);

        btnLogin.setBackground(new java.awt.Color(140, 0, 140));
        btnLogin.setFont(new java.awt.Font("Serif", 1, 22)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(250, 250, 250));
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnCreate.setBackground(new java.awt.Color(140, 0, 140));
        btnCreate.setFont(new java.awt.Font("Serif", 1, 22)); // NOI18N
        btnCreate.setForeground(new java.awt.Color(250, 250, 250));
        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(140, 0, 140));
        btnExit.setFont(new java.awt.Font("Serif", 1, 22)); // NOI18N
        btnExit.setForeground(new java.awt.Color(250, 250, 250));
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnAbout.setBackground(new java.awt.Color(140, 0, 140));
        btnAbout.setFont(new java.awt.Font("Serif", 1, 22)); // NOI18N
        btnAbout.setForeground(new java.awt.Color(250, 250, 250));
        btnAbout.setText("About Us");
        btnAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAboutActionPerformed(evt);
            }
        });

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/parentImage2.jpg"))); // NOI18N
        lblLogo.setToolTipText("The Developer - Shubham Srivastava");
        lblLogo.setPreferredSize(new java.awt.Dimension(500, 581));

        loginPanel.setBackground(new java.awt.Color(190, 190, 190));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 19)); // NOI18N
        jLabel1.setText("Username");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 19)); // NOI18N
        jLabel2.setText("Password");

        txtLogUname.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        txtLogUname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLogUnameActionPerformed(evt);
            }
        });

        submitLogin.setBackground(new java.awt.Color(120, 0, 120));
        submitLogin.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        submitLogin.setForeground(new java.awt.Color(255, 255, 255));
        submitLogin.setText("Login");
        submitLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitLoginActionPerformed(evt);
            }
        });

        txtLogPass.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N

        lblLogErrMsg.setBackground(new java.awt.Color(0, 0, 0));
        lblLogErrMsg.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N
        lblLogErrMsg.setForeground(new java.awt.Color(200, 0, 0));
        lblLogErrMsg.setText("OOPs !!! will Appear ....");

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(loginPanelLayout.createSequentialGroup()
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtLogUname)
                                    .addComponent(txtLogPass, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(loginPanelLayout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(submitLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(lblLogErrMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1051, Short.MAX_VALUE))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtLogUname)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtLogPass, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addComponent(submitLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLogErrMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        createPanel.setBackground(new java.awt.Color(190, 190, 190));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 19)); // NOI18N
        jLabel3.setText("Username");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 19)); // NOI18N
        jLabel4.setText("Password");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 19)); // NOI18N
        jLabel7.setText("Re-Password");

        txtCreUname.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N

        btnCreAcc.setBackground(new java.awt.Color(140, 0, 140));
        btnCreAcc.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        btnCreAcc.setForeground(new java.awt.Color(250, 250, 250));
        btnCreAcc.setText("Create Now");
        btnCreAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreAccActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Serif", 3, 19)); // NOI18N

        txtCrePass.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N

        txtCreRePass.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N

        lblCreErrMsg.setBackground(new java.awt.Color(0, 0, 0));
        lblCreErrMsg.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N
        lblCreErrMsg.setForeground(new java.awt.Color(200, 0, 0));
        lblCreErrMsg.setText("OOPs !!! will Appear ....");

        javax.swing.GroupLayout createPanelLayout = new javax.swing.GroupLayout(createPanel);
        createPanel.setLayout(createPanelLayout);
        createPanelLayout.setHorizontalGroup(
            createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createPanelLayout.createSequentialGroup()
                .addGroup(createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(createPanelLayout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(createPanelLayout.createSequentialGroup()
                                .addGroup(createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtCrePass, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCreUname, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCreRePass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblCreErrMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(createPanelLayout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(btnCreAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        createPanelLayout.setVerticalGroup(
            createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createPanelLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCreUname)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCrePass)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCreRePass, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCreAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(createPanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(createPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCreErrMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        txtAboutUs.setEditable(false);
        txtAboutUs.setBackground(new java.awt.Color(190, 190, 190));
        txtAboutUs.setColumns(20);
        txtAboutUs.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        txtAboutUs.setRows(25);
        txtAboutUs.setText("Here msg will set");
        jScrollPane1.setViewportView(txtAboutUs);

        javax.swing.GroupLayout aboutUsPanelLayout = new javax.swing.GroupLayout(aboutUsPanel);
        aboutUsPanel.setLayout(aboutUsPanelLayout);
        aboutUsPanelLayout.setHorizontalGroup(
            aboutUsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutUsPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );
        aboutUsPanelLayout.setVerticalGroup(
            aboutUsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutUsPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        specificButtonsPanel.setBackground(new java.awt.Color(120, 0, 120));

        btnShow.setBackground(new java.awt.Color(140, 0, 140));
        btnShow.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btnShow.setText("Show");
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });

        btnWrite.setBackground(new java.awt.Color(140, 0, 140));
        btnWrite.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btnWrite.setText("Edit");
        btnWrite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWriteActionPerformed(evt);
            }
        });

        btnCally.setBackground(new java.awt.Color(140, 0, 140));
        btnCally.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btnCally.setText("Shubhu :)");
        btnCally.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCallyActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(140, 0, 140));
        btnDelete.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnLogout.setBackground(new java.awt.Color(140, 0, 140));
        btnLogout.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnCloseApp.setBackground(new java.awt.Color(140, 0, 140));
        btnCloseApp.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btnCloseApp.setText("Close");
        btnCloseApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseAppActionPerformed(evt);
            }
        });

        lblUname.setForeground(new java.awt.Color(190, 190, 190));
        lblUname.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUname.setText("shubham");
        lblUname.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        btnSaveNotes.setBackground(new java.awt.Color(50, 170, 51));
        btnSaveNotes.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnSaveNotes.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveNotes.setText("Save");
        btnSaveNotes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveNotesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout specificButtonsPanelLayout = new javax.swing.GroupLayout(specificButtonsPanel);
        specificButtonsPanel.setLayout(specificButtonsPanelLayout);
        specificButtonsPanelLayout.setHorizontalGroup(
            specificButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, specificButtonsPanelLayout.createSequentialGroup()
                .addGroup(specificButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(specificButtonsPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblUname, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(specificButtonsPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnShow, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnWrite, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(specificButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(specificButtonsPanelLayout.createSequentialGroup()
                                .addComponent(btnCally, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSaveNotes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCloseApp, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );
        specificButtonsPanelLayout.setVerticalGroup(
            specificButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(specificButtonsPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblUname)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(specificButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(specificButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCloseApp, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(specificButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnCally, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                        .addComponent(btnWrite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnShow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSaveNotes, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addContainerGap())
        );

        specificPanel.setBackground(new java.awt.Color(120, 0, 120));

        txtAreaSpecificUser.setBackground(new java.awt.Color(215, 215, 215));
        txtAreaSpecificUser.setColumns(20);
        txtAreaSpecificUser.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtAreaSpecificUser.setRows(5);
        txtAreaSpecificUser.setText("Here Logged in user's Notes will Appear\n");
        jScrollPane2.setViewportView(txtAreaSpecificUser);

        javax.swing.GroupLayout specificPanelLayout = new javax.swing.GroupLayout(specificPanel);
        specificPanel.setLayout(specificPanelLayout);
        specificPanelLayout.setHorizontalGroup(
            specificPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1367, Short.MAX_VALUE)
        );
        specificPanelLayout.setVerticalGroup(
            specificPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(specificPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                .addContainerGap())
        );

        specificDeletePanel.setBackground(new java.awt.Color(190, 190, 190));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel9.setText(" Deleting Notes Completely, This Can Not be Undo");

        btnSpecificConfirm.setBackground(new java.awt.Color(140, 0, 140));
        btnSpecificConfirm.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnSpecificConfirm.setForeground(new java.awt.Color(250, 250, 250));
        btnSpecificConfirm.setText("Confirm");
        btnSpecificConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSpecificConfirmActionPerformed(evt);
            }
        });

        btnSpecificCancel.setBackground(new java.awt.Color(140, 0, 140));
        btnSpecificCancel.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnSpecificCancel.setForeground(new java.awt.Color(250, 250, 250));
        btnSpecificCancel.setText("Cancel");
        btnSpecificCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSpecificCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout specificDeletePanelLayout = new javax.swing.GroupLayout(specificDeletePanel);
        specificDeletePanel.setLayout(specificDeletePanelLayout);
        specificDeletePanelLayout.setHorizontalGroup(
            specificDeletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(specificDeletePanelLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(specificDeletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(specificDeletePanelLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(btnSpecificConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnSpecificCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(344, Short.MAX_VALUE))
        );
        specificDeletePanelLayout.setVerticalGroup(
            specificDeletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(specificDeletePanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(specificDeletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSpecificConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSpecificCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAbout))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(createPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(aboutUsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(specificButtonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(specificPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(specificDeletePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAbout, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                    .addComponent(loginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(44, 44, 44))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(createPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 223, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(aboutUsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(specificButtonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(specificPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(specificDeletePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>                        

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {                                        
        setUserNotesInDb();
        System.exit(1);
    }                                       

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {                                         
        aboutUsPanel.setVisible(false);
        lblLogo.setVisible(false);
        createPanel.setVisible(false);
        this.setTitle("My Dream Diary - Shubham :) Login Panel");
        
        loginPanel.setVisible(true);
    }                                        

    private void submitLoginActionPerformed(java.awt.event.ActionEvent evt) {                                            
        System.out.println("\nLogin Submitted\n");
        
        lblLogErrMsg.setText("");
        String uname = txtLogUname.getText();
        String pass = new String(txtLogPass.getPassword());
        
        if( (uname.length() == 0 || pass.length() == 0 ) )  // Something is wrong
        {
            showErrMsg("loginErr");
        }
        else
        {
            if( isValidUnamePass() == false )
            {   // Username / password is Incorrect 
                lblLogErrMsg.setForeground(Color.RED);
                lblLogErrMsg.setText("");
                showErrMsg("loginErr");
            }
            else
            {   // Correct Username and Password 
                // Display Logged In Users Panel with 'New Menu buttons '
                this.uname = uname;
                txtLogUname.setText("");
                txtLogPass.setText("");
                lblUname.setText(":) Welcome "+uname);
                
                loginPanel.setVisible(false);
                hideParentButtons();
                showUserSpecificButtonsPanel(); // Display all Specific Buttons But not 'Save' Button
                lblLogo.setVisible(true);
                specificPanel.setVisible(false);
            }
        }                
    }                                           

    public boolean isValidUnamePass(){
        
        
        /*          Steps 
            1) Take uname & pass from TxtField and Convert them into Enc form 
            2) Find it in Database and
            3) Return Status
        */
        boolean returnVal = false;
        String uname = txtLogUname.getText();
        String pass = new String(txtLogPass.getPassword());
        String encUname = getEncryptedStringOf(uname);
        String encPass = getEncryptedStringOf(pass);
        Connection con = null;
        try{
            con = getDbConnObj();
            Statement st = con.createStatement();
            String sql = "Select uname,pass from users";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
               String dbEncUname = rs.getString("uname");
               String dbEncPass = rs.getString("pass");
               if( ( encUname.equals(dbEncUname)== true) && ( encPass.equals(dbEncPass)== true)){
                   returnVal = true;
                   break;
               }
            }
        }catch(Exception e){
            return false;
        }finally{
            return returnVal;
        }
    }
            
    private void txtLogUnameActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {                                          
                
        loginPanel.setVisible(false);
        lblLogo.setVisible(false);
        aboutUsPanel.setVisible(false);
        this.setTitle("My Dream Diary - Shubham :) Create A/c Panel");
        
        lblCreErrMsg.setText("");
        createPanel.setVisible(true);
        
    }                                         

    private void btnCreAccActionPerformed(java.awt.event.ActionEvent evt) {                                          
        String uname = txtCreUname.getText();
        String pass = new String(txtCrePass.getPassword());
        String rePass = new String(txtCreRePass.getPassword());
        lblCreErrMsg.setText("");        
        lblCreErrMsg.setForeground(Color.RED);
        if( pass.equals(rePass) == false ){
            lblCreErrMsg.setText("Passwords didn't Match... Retry");
            return;
        }
        else if( isUnameAlreadyExists(uname) == true ){  // Did not Defined Yet
            lblCreErrMsg.setText("Invalid Username, Retry...");
            return;
        }
        else{            
            if( createUser( uname, pass ) ){
                lblCreErrMsg.setText( uname+ "'s account Created ...");
                lblCreErrMsg.setForeground(new Color(30,180,30));
                txtCreUname.setText("");
                txtCrePass.setText("");
                txtCreRePass.setText("");
            }
            else{                
                lblCreErrMsg.setText( "Something went Wrong, Retry...");
            }
        }
    }                                         

    private void btnAboutActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        loginPanel.setVisible(false);
        lblLogo.setVisible(false);        
        createPanel.setVisible(false);
        this.setTitle("My Dream Diary - Shubham :) About Us Panel");
        aboutUsPanel.setVisible(true);
        String msg= "\t       ===================================\n"+
                    "\t                            My Dream Diary : Security         \n"+
                    "\t       ===================================\n"+
                    "\t        Dear User, First of All Thanks for using this Application \n"+
                    "\t        This Application is Build to keep this in mind that \n"+
                    "\t        Any One who has Saved his Secret Notes & ToDo List  \n"+
                    "\t        has not need to think About that Whatif SomeOne has \n"+
                    "\t        Read his Notes Behind him/her.                      \n"+
                    "\t             That's Why our Team has worked More on Security \n"+
                    "\t        by using  *64-bit Encryption Policy*                \n"+
                    "\t        So no One Can Read his Secret Notes without knowing \n"+
                    "\t        the Password as the Notes are Fully Encrypted :)    \n"+
                    "\t       ====================================\n"+
                    "\t                                       Star Features \n"+
                    "\t       ====================================\n"+
                    "\t        1) Login - Logout Feature                           \n"+
                    "\t        2) Create new Account Feature                       \n"+
                    "\t        3) Secured ( 64-bit Encryption )                    \n"+
                    "\t        4) Cross-Platform Supportable                       \n"+                                        
                    "\t        5) Robust                                           \n"+
                    "\t       ====================================\n"+
                    "\t                                           Feedback \n"+
                    "\t       ====================================\n"+
                    "\t       Contact us :                                                 8601725056\n"+
                    "\t       shubhsrivastava271999@gmail.com         Shubham Sri.\n";                    
            txtAboutUs.setText(msg);        
    }                                        

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {                                          
        specificDeletePanel.setVisible(false);
        btnSaveNotes.setVisible(false);
        specificButtonsPanel.setVisible(false);
        specificPanel.setVisible(false);  
        showParentButtons();
        lblUname.setText("");
        lblLogo.setVisible(true);
    }                                         

    private void btnCallyActionPerformed(java.awt.event.ActionEvent evt) {                                         
        lblLogo.setVisible(false);
        specificPanel.setVisible(true);
        btnSaveNotes.setVisible(false);        
        btnSaveNotes.setText("Save");
        this.setTitle("My Dream Diary - Shubham :) Speaker Panel");
        
        String fullNotes = getUserNotesFromDb();
        txtAreaSpecificUser.setText(fullNotes);
        txtAreaSpecificUser.setEditable(false);

        // Voice Name ...
        String name = "kevin16";
        Voice voice;
        VoiceManager vm = VoiceManager.getInstance();
        voice = vm.getVoice(name);
        voice.setPitch(90.0f);// arg - float hrtz        
        voice.setRate(130.0f); // : arg - float  
//        voice.setVolume(2.0f);
        voice.allocate();        
        
        // Start Speaking....
        try{  
            voice.speak(txtAreaSpecificUser.getText());
        }catch(Exception e)
        {

        }
        /*
import java.io.*;
import com.sun.speech.freetts.*;
import javax.swing.JFrame;
private static final String name = "kevin16";
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        Voice voice;
        VoiceManager vm = VoiceManager.getInstance();
        voice = vm.getVoice(name);
        
        voice.allocate();
        try{  
            voice.speak(jTextArea1.getText());
        }catch(Exception e)
        {
            
        }
    } 
        */
        
    }                                        

    private void btnCloseAppActionPerformed(java.awt.event.ActionEvent evt) {                                            
        setUserNotesInDb();
        System.exit(1);
    }                                           

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {                                        
               
        lblLogo.setVisible(false);
        specificPanel.setVisible(true);
        btnSaveNotes.setVisible(false);
        this.setTitle("My Dream Diary - Shubham :) Show Panel");
        String fullNotes = getUserNotesFromDb();
        p("btnShow got Note ->"+fullNotes+"<-");
        txtAreaSpecificUser.setText(fullNotes);
        txtAreaSpecificUser.setEditable(false);
    }                                       

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                          
        delCounter++;
        lblLogo.setVisible(false);
        btnSaveNotes.setVisible(false);
        btnSaveNotes.setText("Save");
        this.setTitle("My Dream Diary - Shubham :) Delete Panel");
        if( delCounter%2 != 0){ // Show the Default Notes TextArea
//            specificDelPanel.setVisible(false);
            p("Show the Default Notes TextArea");
            specificDeletePanel.setVisible(false);
            specificPanel.setVisible(true);
            String fullNotes = getUserNotesFromDb();
            txtAreaSpecificUser.setText(fullNotes);
            txtAreaSpecificUser.setEditable(false);
            
        }else{          // Hide the TextArea and Display LoginForm Like Panel With 'Confirm' and 'Cancel' Buttons            
            p("Hide the TextArea and Display LoginForm Like Panel With 'Confirm' and 'Cancel' Buttons");            
            specificPanel.setVisible(false);
            specificDeletePanel.setVisible(true);
//            specificDelPanel.setVisible(true);
        }
    }                                         

    private void btnWriteActionPerformed(java.awt.event.ActionEvent evt) {                                         
        lblLogo.setVisible(false);
        specificPanel.setVisible(true);
        this.setTitle("My Dream Diary - Shubham :) Edit Panel");
        String fullNotes = getUserNotesFromDb();
        p("btnEdit got Note ->"+fullNotes+"<-");
        txtAreaSpecificUser.setText(fullNotes);
        btnSaveNotes.setText("Save");
        btnSaveNotes.setVisible(true);
        txtAreaSpecificUser.setEditable(true);
    }                                        

    private void btnSaveNotesActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if( setUserNotesInDb() == false){
            btnSaveNotes.setText("Retry...Save");
        }else{
            btnSaveNotes.setVisible(false);            
            specificPanel.setVisible(false);
            lblLogo.setVisible(true);
        }
    }                                            

    private void btnSpecificCancelActionPerformed(java.awt.event.ActionEvent evt) {                                                  
                       
        specificDeletePanel.setVisible(false);        
        specificPanel.setVisible(true);
        String fullNotes = getUserNotesFromDb();
        txtAreaSpecificUser.setText(fullNotes);
        txtAreaSpecificUser.setEditable(false);
    }                                                 

    private void btnSpecificConfirmActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        if(setUserNotesInDb("") == false){
            // Could Not Deleted
            p("Could Not Deleted");
        }else{
            // Deletion Successfull;            
            specificDeletePanel.setVisible(false);
            specificPanel.setVisible(true);
            String fullNotes = getUserNotesFromDb();
            txtAreaSpecificUser.setText(fullNotes);
            txtAreaSpecificUser.setEditable(false);
            p("Deletion Successfull;");
        }
    }                                                  
    
public String getUserNotesFromDb(){
    // Default Message , when user Logged in first time ever
    String msg = "Hello "+this.uname+", You Did Not Saved Anything yet ...";    
    String retMsg = "";
    try{
        Connection con = null;
        con = getDbConnObj();
        String encUname = getEncryptedStringOf(this.uname);
        
        // SQL query : to fetch all the Encrypted Notes from Database 
        String sql = "Select notes from users where uname = '"+encUname+"'";    
        Statement st = con.createStatement();
        
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            msg = rs.getString("notes");
            p("Date fetched Successfully ");
        }
        if(msg.equals("")){
            p("Fetched Data is EMPTY....");
            retMsg = "(OOPs...You Did Not Saved Anything yet ...)";
        }else{
            retMsg = getDecryptedStringOf(msg);
            p("Fetched Data returning");
        }
    }catch(Exception e){
        retMsg="\t OOPs !!!\nSomething Went Wrong , Retry ....";
    }finally{
        return retMsg;      // Returning the actual Notes...
    }
}        

public boolean setUserNotesInDb(){
    
        p("setUserNotesInDb() called");
        boolean returnVal=false;
        Connection con = null;
        String msg = txtAreaSpecificUser.getText();
        String encMsg = getEncryptedStringOf(msg);      // Encrypting before Storing to Database
        String encUname = getEncryptedStringOf(this.uname);
        try{
            con = getDbConnObj();
            String sql = "Update users set notes = ? where uname = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, encMsg);
            st.setString(2, encUname);
            int aff = st.executeUpdate();
            if(aff > 0){
                // Inserted Successfully
                p("Data Saved Successfully");
                returnVal = true;
            }
            else{
                p("Data Not Saved");
                returnVal = false;
            }
        }catch(Exception e){
            p("Data Not Saved");
            return false;
        }finally{
            return returnVal;
        }
}

public boolean setUserNotesInDb(String notes){
    
        p("setUserNotesInDb(notes) called");
        boolean returnVal=false;
        Connection con = null;
        String msg = notes;
        
        // Encrypting User's Notes before Saving to Database
        String encMsg = getEncryptedStringOf(msg);
        String encUname = getEncryptedStringOf(this.uname);
        try{
            
            //Getting the Connection Object 
            con = getDbConnObj();
            String sql = "Update users set notes = ? where uname = ?";
            PreparedStatement st = con.prepareStatement(sql);   // Preparing Statement 
            st.setString(1, encMsg);                            // binding Parameters
            st.setString(2, encUname);
            int aff = st.executeUpdate();                       // Executing
            if(aff > 0){
                // Inserted Successfully
//                p("Data '"+notes+"'Saved Successfully");
                returnVal = true;
            }
            else{
                p("Data Not Saved");
                returnVal = false;
            }
        }catch(Exception e){
            p("Data Not Saved");
            return false;
        }finally{
            return returnVal;
        }
}


public String getEncryptedStringOf( String normalStr)    
{
    // This 'Base64' class contains the   'getEncoder() and getDecoder()' STATIC Methods ...
    Base64.Encoder enc = Base64.getEncoder();
    String encUname = enc.encodeToString( normalStr.getBytes() );
    return encUname;
}
public String getDecryptedStringOf( String encStr)
{
    // This 'Base64' class contains the   'getEncoder() and getDecoder()' STATIC Methods ...
    Base64.Decoder dec = Base64.getDecoder();
    String decStr = new String(dec.decode( encStr ));
    return decStr;
}

    public boolean isUnameAlreadyExists(String uname)
    {
        boolean returnVal = false;
        /*     ... Steps ...
            1. Convert Normal String uname -> into Enc_uname
            2. Select All Enc_Unames from DB table 'users'
            3. Compare Each EncDbUname with EncUname
            4. Return Status
        */
        // Step 1.) uname -> into Enc_uname        
        String encUname = getEncryptedStringOf(uname);
        
        // Step 2) Select All Enc_Unames from DB table 'users'
        Connection con = null;
        ResultSet rs = null;
        con = getDbConnObj();
        if( con == null ){    return false;    }
        try{
            String sql = "Select uname from users";
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            
            boolean encUnamesMatched = false;
            while( rs.next() && encUnamesMatched == false){
                String dbEncUname = new String(rs.getString("uname"));                
                // Step 3) Comparing Each EncDbUname with EncUname
                if( dbEncUname.equals(encUname) == true ){   // Username Already Exists ...
                    return true;
                }
            }
            // Step 4) Returning Status
            return false;
        }catch( Exception e){
            returnVal = true;   // Matched and Exception both are not Allowed
            return returnVal;
        }
    }    

    public void hideParentButtons()
    {
        // This method'll hide the 4 Basic Buttons "Login,Create,Exit,AboutUs" stored in the JButton Array parentButtons
        for(int i=0; i < 4;i++)
        {
            parentButtons[i].setVisible(false);
        }
    }
    
    public void showParentButtons()
    {
        // This method'll UnHide the 4 Basic Buttons "Login,Create,Exit,AboutUs" stored in the JButton Array parentButtons
        for(int i=0; i < 4;i++)
        {
            parentButtons[i].setVisible(true);
        }
    }
    
    public void  showUserSpecificButtonsPanel()
    {
        // After user Login .....
        specificButtonsPanel.setVisible(true);
        specificPanel.setVisible(true);        
    }
    public boolean createUser(String uname,String pass) // These Are in Encrypted form
    {       // Insert the Uname and Pass to 'users' table in MySQL Database ...
        boolean returnVal=false;
        if( isUnameAlreadyExists(uname) == true )
            return false;
        try{
            Connection con = getDbConnObj();
            if( con == null )
                return false;
            
            String sql = "Insert into users (uname,pass,notes) values(?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            String encUname = getEncryptedStringOf( uname );
            String encPass = getEncryptedStringOf( pass );
            String encNotes = getEncryptedStringOf( "" );
            st.setString(1,encUname);
            st.setString(2,encPass);
            st.setString(3,encNotes);
            int rowAff=0;
            if( (rowAff = st.executeUpdate()) > 0)
            {
                // 1 row affected
                returnVal = true;
            }
            else
            {
                // No Row affected ...
                p("rowAff == 0 , returning false ....");
                returnVal = false;
            }
            st.close();
            con.close();
//            return returnVal;
        }catch(Exception e){
            p("Createuser() generated Exception ....");
            returnVal = false;
        }
        finally{
            return returnVal;
        }
    }
    
    public Connection getDbConnObj()
    {
        // Creating 'Connection' class' Reference Variable ...
        Connection con = null;
        String url="jdbc:mysql://localhost:3306/mydreamdiarydb";
        String phpUname="root";
        String phpPass="";
        try{
            // Calling a Static Method of class "Class" to Load the MySQL JDBC Driver ...
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,phpUname,phpPass);
        }catch(Exception e){
            con = null;
        }finally{
            return con;
        }
    }

    public void showErrMsg(String strPanelName)
    {
        lblLogErrMsg.setText("");
        if( strPanelName.equals("loginErr"))
        {
            lblLogErrMsg.setText("Username/Password Is Wrong !!!");
            lblLogErrMsg.setVisible(true);
        }
        else
        {
            lblLogErrMsg.setText("Correct Unme & Password");
            lblLogErrMsg.setVisible(true);
        }
    }

    public void p(String msgToPrint)
    {
        System.out.println(msgToPrint);
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
            java.util.logging.Logger.getLogger(MyDiary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyDiary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyDiary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyDiary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyDiary().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPanel aboutUsPanel;
    private javax.swing.JButton btnAbout;
    private javax.swing.JButton btnCally;
    private javax.swing.JButton btnCancelDel;
    private javax.swing.JButton btnCancelDel1;
    private javax.swing.JButton btnCloseApp;
    private javax.swing.JButton btnConfirmDel;
    private javax.swing.JButton btnConfirmDel1;
    private javax.swing.JButton btnCreAcc;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnSaveNotes;
    private javax.swing.JButton btnShow;
    private javax.swing.JButton btnSpecificCancel;
    private javax.swing.JButton btnSpecificConfirm;
    private javax.swing.JButton btnWrite;
    private javax.swing.JPanel createPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCreErrMsg;
    private javax.swing.JLabel lblLogErrMsg;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblUname;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPanel specificButtonsPanel;
    private javax.swing.JPanel specificDelPanel;
    private javax.swing.JPanel specificDelPanel1;
    private javax.swing.JPanel specificDeletePanel;
    private javax.swing.JPanel specificPanel;
    private javax.swing.JButton submitLogin;
    private javax.swing.JTextArea txtAboutUs;
    private javax.swing.JTextArea txtAreaSpecificUser;
    private javax.swing.JPasswordField txtCrePass;
    private javax.swing.JPasswordField txtCreRePass;
    private javax.swing.JTextField txtCreUname;
    private javax.swing.JPasswordField txtLogPass;
    private javax.swing.JTextField txtLogUname;
    // End of variables declaration                   
}
