package gui;


import java.awt.Component;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.Document;
import javax.swing.text.BadLocationException;
import java.util.Random;

import edu.asu.se.group5.business.HealthCareManagementSystem;
import java.lang.reflect.Array;

import java.util.ArrayList;

import javax.swing.WindowConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

//Changes!
//1. Had to make HCMS.java's referenceNumberGenerator public and static to access it from InitialMenu.java
//2. Had to make HCMS.java's HashMap<> patientList public in order to access it from InitialMenu.java
//3. HCMS gets created in GUI InitialMenu file
//4.
//5.

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class InitialMenu extends javax.swing.JFrame 
{
    private HealthCareManagementSystem HCMS;
    private String memberType;
    private int userReferenceNumber;
    private String activeUserDetails;
    private JEditorPane pane = new JEditorPane();
    private String[] sliderParameters;
    private Random generator = new Random();
    
    public InitialMenu() { 
        initComponents();
    }

    public InitialMenu(HealthCareManagementSystem system) 
    {
		initComponents();// TODO Auto-generated constructor stub               
		this.HCMS = system;
    }

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoginDialogBox = new javax.swing.JDialog();
        LoginLabelUsername = new java.awt.Label();
        LoginBoxTextFieldUsername = new javax.swing.JTextField();
        LoginLabelPassword = new java.awt.Label();
        LoginBoxTextFieldPassword = new javax.swing.JPasswordField();
        LoginDialogBoxSubmit = new javax.swing.JButton();
        register_link = new javax.swing.JLabel();
        cancelLogin = new javax.swing.JButton();
        RegisterMenu = new javax.swing.JFrame();
        NewPatientRegistrationLabel = new javax.swing.JLabel();
        PatientRegistrationLabelFirstName = new javax.swing.JLabel();
        PatientRegistrationLabelPassword = new javax.swing.JLabel();
        PatientRegistrationLabelPhoneNumber = new javax.swing.JLabel();
        PatientRegistrationLabelEmail = new javax.swing.JLabel();
        PatientRegistrationLabelDoctorAssigned = new javax.swing.JLabel();
        PatientRegistrationTextFieldFirstName = new javax.swing.JTextField();
        PatientRegistrationTextFieldPhoneNumber = new javax.swing.JTextField();
        PatientRegistrationTextFieldEmail = new javax.swing.JTextField();
        PatientRegistrationButtonSubmit = new javax.swing.JButton();
        registrationComboBoxOne = new javax.swing.JComboBox();
        PatientRegistrationLabelUnderlyingCondition = new javax.swing.JLabel();
        registrationComboBoxTwo = new javax.swing.JComboBox();
        PatientRegistrationLabelConfirmPassword = new javax.swing.JLabel();
        PatientRegistrationLabelLastName = new javax.swing.JLabel();
        PatientRegistrationTextFieldLastName = new javax.swing.JTextField();
        PatientRegistrationPasswordFieldPassword = new javax.swing.JPasswordField();
        PatientRegistrationPasswordFieldConfirm = new javax.swing.JPasswordField();
        registrationClear = new javax.swing.JButton();
        MainUserInterface = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        MainUserInterfaceTextPaneHistory = new javax.swing.JTextPane();
        MainUserInterfaceSliderONE = new javax.swing.JSlider();
        MainUserInterfaceSliderTWO = new javax.swing.JSlider();
        MainUserInterfaceSliderTHREE = new javax.swing.JSlider();
        MainUserInterfaceSliderFOUR = new javax.swing.JSlider();
        MainUserInterfaceSliderFIVE = new javax.swing.JSlider();
        MainUserInterfaceLabelONE = new javax.swing.JLabel();
        MainUserInterfaceLabelTWO = new javax.swing.JLabel();
        MainUserInterfaceLabelTHREE = new javax.swing.JLabel();
        MainUserInterfaceLabelFOUR = new javax.swing.JLabel();
        MainUserInterfaceLabelFIVE = new javax.swing.JLabel();
        MainUserInterfaceGUISeparator = new javax.swing.JSeparator();
        MainUserInterfaceButtonSubmit = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        MainUserInterfaceTextAreaComments = new javax.swing.JTextArea();
        MainUserInterfaceLabelComments = new javax.swing.JLabel();
        main_UI_Cancel = new javax.swing.JButton();
        patientSelectComboBox = new javax.swing.JComboBox();
        viewButton = new javax.swing.JButton();
        LoginSuccessWindow = new javax.swing.JDialog();
        SuccessWindowLabelSuccess = new javax.swing.JLabel();
        SuccessWindowButtonSubmit = new javax.swing.JButton();
        LoginFailWindow = new javax.swing.JDialog();
        SuccessWindowLabelSuccess1 = new javax.swing.JLabel();
        SuccessWindowButtonSubmit1 = new javax.swing.JButton();
        PasswordUnsuccessfulWindow = new javax.swing.JDialog();
        PasswordUnsuccessfulLabelMessage = new javax.swing.JLabel();
        PasswordUnsuccessfulButtonOkay = new javax.swing.JButton();
        ChooseMember = new javax.swing.JFrame();
        selectPatient = new javax.swing.JButton();
        selectDoctor = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        greeting = new javax.swing.JLabel();
        InitialMenuButtonPatient = new javax.swing.JButton();
        InitialMenuButtonDoctor = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        LoginDialogBox.setAlwaysOnTop(true);
        LoginDialogBox.setBounds(new java.awt.Rectangle(0, 22, 400, 210));
        LoginDialogBox.setName(""); // NOI18N
        LoginDialogBox.setResizable(false);
        LoginDialogBox.setSize(new java.awt.Dimension(400, 210));

        LoginLabelUsername.setText("Email:");

        LoginLabelPassword.setName(""); // NOI18N
        LoginLabelPassword.setText("Password:");

        LoginDialogBoxSubmit.setText("Submit");
        LoginDialogBoxSubmit.setName(""); // NOI18N
        LoginDialogBoxSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginDialogBoxSubmitMouseClicked(evt);
            }
        });
        LoginDialogBoxSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginDialogBoxSubmitActionPerformed(evt);
            }
        });

        register_link.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        register_link.setForeground(java.awt.Color.blue);
        register_link.setLabelFor(RegisterMenu);
        register_link.setText("Register");
        register_link.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        register_link.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                register_linkMouseClicked(evt);
            }
        });

        cancelLogin.setText("Cancel");
        cancelLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LoginDialogBoxLayout = new javax.swing.GroupLayout(LoginDialogBox.getContentPane());
        LoginDialogBox.getContentPane().setLayout(LoginDialogBoxLayout);
        LoginDialogBoxLayout.setHorizontalGroup(
            LoginDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginDialogBoxLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(LoginDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LoginLabelPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LoginLabelUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(LoginDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginDialogBoxLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(LoginDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(register_link)
                            .addGroup(LoginDialogBoxLayout.createSequentialGroup()
                                .addComponent(LoginDialogBoxSubmit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelLogin))))
                    .addGroup(LoginDialogBoxLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(LoginDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LoginBoxTextFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LoginBoxTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        LoginDialogBoxLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {LoginBoxTextFieldPassword, LoginBoxTextFieldUsername});

        LoginDialogBoxLayout.setVerticalGroup(
            LoginDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginDialogBoxLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LoginDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LoginBoxTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LoginLabelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LoginDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LoginLabelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LoginBoxTextFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LoginDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoginDialogBoxSubmit)
                    .addComponent(cancelLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(register_link)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        LoginDialogBoxLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {LoginBoxTextFieldPassword, LoginBoxTextFieldUsername});

        LoginLabelUsername.getAccessibleContext().setAccessibleName("");

        RegisterMenu.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        RegisterMenu.setBounds(new java.awt.Rectangle(0, 22, 364, 370));
        RegisterMenu.setResizable(false);
        RegisterMenu.setSize(new java.awt.Dimension(364, 370));

        NewPatientRegistrationLabel.setText("Registration");

        PatientRegistrationLabelFirstName.setText("First Name");

        PatientRegistrationLabelPassword.setText("Password:");

        PatientRegistrationLabelPhoneNumber.setText("Phone Number:");

        PatientRegistrationLabelEmail.setText("Email:");

        PatientRegistrationLabelDoctorAssigned.setText("Doctor Assigned:");

        PatientRegistrationButtonSubmit.setText("Submit");
        PatientRegistrationButtonSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PatientRegistrationButtonSubmitMouseClicked(evt);
            }
        });
        PatientRegistrationButtonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PatientRegistrationButtonSubmitActionPerformed(evt);
            }
        });

        registrationComboBoxOne.setMaximumRowCount(100);
        registrationComboBoxOne.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Walter Bishop", "Henry Jekyll", "Dr. Dre", "Hannibal Lecter", "Dr. Evil" }));
        registrationComboBoxOne.setPreferredSize(new java.awt.Dimension(112, 28));
        registrationComboBoxOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrationComboBoxOneActionPerformed(evt);
            }
        });

        PatientRegistrationLabelUnderlyingCondition.setText("Underlying Condition:");

        registrationComboBoxTwo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Condition1", "Condition2", "Condition3", "Condition 4" }));

        PatientRegistrationLabelConfirmPassword.setText("Confirm Password:");

        PatientRegistrationLabelLastName.setText("Last Name");

        PatientRegistrationPasswordFieldPassword.setPreferredSize(new java.awt.Dimension(105, 28));

        PatientRegistrationPasswordFieldConfirm.setPreferredSize(new java.awt.Dimension(105, 28));

        registrationClear.setText("Clear");
        registrationClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrationClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RegisterMenuLayout = new javax.swing.GroupLayout(RegisterMenu.getContentPane());
        RegisterMenu.getContentPane().setLayout(RegisterMenuLayout);
        RegisterMenuLayout.setHorizontalGroup(
            RegisterMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegisterMenuLayout.createSequentialGroup()
                .addGroup(RegisterMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegisterMenuLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(RegisterMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(RegisterMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(PatientRegistrationTextFieldFirstName)
                                .addComponent(PatientRegistrationPasswordFieldPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(PatientRegistrationTextFieldPhoneNumber)
                                .addComponent(registrationComboBoxOne, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(PatientRegistrationLabelFirstName)))
                    .addGroup(RegisterMenuLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(PatientRegistrationLabelPassword))
                    .addGroup(RegisterMenuLayout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(NewPatientRegistrationLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisterMenuLayout.createSequentialGroup()
                .addGroup(RegisterMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(RegisterMenuLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(RegisterMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PatientRegistrationLabelDoctorAssigned, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                            .addComponent(PatientRegistrationLabelPhoneNumber))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(RegisterMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PatientRegistrationLabelLastName)
                            .addGroup(RegisterMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(PatientRegistrationTextFieldEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(PatientRegistrationPasswordFieldConfirm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(PatientRegistrationTextFieldLastName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(PatientRegistrationLabelConfirmPassword)
                            .addComponent(PatientRegistrationLabelEmail)
                            .addComponent(PatientRegistrationLabelUnderlyingCondition)))
                    .addGroup(RegisterMenuLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(RegisterMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(RegisterMenuLayout.createSequentialGroup()
                                .addComponent(PatientRegistrationButtonSubmit)
                                .addGap(20, 20, 20)
                                .addComponent(registrationClear))
                            .addComponent(registrationComboBoxTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );

        RegisterMenuLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {PatientRegistrationPasswordFieldConfirm, PatientRegistrationPasswordFieldPassword, PatientRegistrationTextFieldEmail, PatientRegistrationTextFieldFirstName, PatientRegistrationTextFieldLastName, PatientRegistrationTextFieldPhoneNumber, registrationComboBoxOne, registrationComboBoxTwo});

        RegisterMenuLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {PatientRegistrationButtonSubmit, registrationClear});

        RegisterMenuLayout.setVerticalGroup(
            RegisterMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegisterMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NewPatientRegistrationLabel)
                .addGap(27, 27, 27)
                .addGroup(RegisterMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PatientRegistrationLabelFirstName)
                    .addComponent(PatientRegistrationLabelLastName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RegisterMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PatientRegistrationTextFieldFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PatientRegistrationTextFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RegisterMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PatientRegistrationLabelPassword)
                    .addComponent(PatientRegistrationLabelConfirmPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RegisterMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PatientRegistrationPasswordFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PatientRegistrationPasswordFieldConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RegisterMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PatientRegistrationLabelPhoneNumber)
                    .addComponent(PatientRegistrationLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RegisterMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PatientRegistrationTextFieldPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PatientRegistrationTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RegisterMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PatientRegistrationLabelUnderlyingCondition)
                    .addComponent(PatientRegistrationLabelDoctorAssigned))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RegisterMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registrationComboBoxOne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registrationComboBoxTwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 51, Short.MAX_VALUE)
                .addGroup(RegisterMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PatientRegistrationButtonSubmit)
                    .addComponent(registrationClear))
                .addContainerGap())
        );

        RegisterMenuLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {PatientRegistrationPasswordFieldConfirm, PatientRegistrationPasswordFieldPassword, PatientRegistrationTextFieldEmail, PatientRegistrationTextFieldFirstName, PatientRegistrationTextFieldLastName, PatientRegistrationTextFieldPhoneNumber, registrationComboBoxOne, registrationComboBoxTwo});

        RegisterMenuLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {PatientRegistrationButtonSubmit, registrationClear});

        MainUserInterface.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        MainUserInterface.setAlwaysOnTop(true);
        MainUserInterface.setBounds(new java.awt.Rectangle(0, 22, 500, 750));
        MainUserInterface.setMaximumSize(new java.awt.Dimension(500, 740));
        MainUserInterface.setResizable(false);
        MainUserInterface.setSize(new java.awt.Dimension(500, 750));

        MainUserInterfaceTextPaneHistory.setEditable(false);
        MainUserInterfaceTextPaneHistory.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        jScrollPane1.setViewportView(MainUserInterfaceTextPaneHistory);

        MainUserInterfaceSliderONE.setMajorTickSpacing(1);
        MainUserInterfaceSliderONE.setMaximum(10);
        MainUserInterfaceSliderONE.setMinimum(1);
        MainUserInterfaceSliderONE.setPaintLabels(true);
        MainUserInterfaceSliderONE.setPaintTicks(true);
        MainUserInterfaceSliderONE.setSnapToTicks(true);
        MainUserInterfaceSliderONE.setValue(1);

        MainUserInterfaceSliderTWO.setMajorTickSpacing(1);
        MainUserInterfaceSliderTWO.setMaximum(10);
        MainUserInterfaceSliderTWO.setMinimum(1);
        MainUserInterfaceSliderTWO.setMinorTickSpacing(1);
        MainUserInterfaceSliderTWO.setPaintLabels(true);
        MainUserInterfaceSliderTWO.setPaintTicks(true);
        MainUserInterfaceSliderTWO.setSnapToTicks(true);
        MainUserInterfaceSliderTWO.setValue(1);

        MainUserInterfaceSliderTHREE.setMajorTickSpacing(1);
        MainUserInterfaceSliderTHREE.setMaximum(10);
        MainUserInterfaceSliderTHREE.setMinimum(1);
        MainUserInterfaceSliderTHREE.setPaintLabels(true);
        MainUserInterfaceSliderTHREE.setPaintTicks(true);
        MainUserInterfaceSliderTHREE.setSnapToTicks(true);
        MainUserInterfaceSliderTHREE.setValue(1);

        MainUserInterfaceSliderFOUR.setMajorTickSpacing(1);
        MainUserInterfaceSliderFOUR.setMaximum(10);
        MainUserInterfaceSliderFOUR.setMinimum(1);
        MainUserInterfaceSliderFOUR.setPaintLabels(true);
        MainUserInterfaceSliderFOUR.setPaintTicks(true);
        MainUserInterfaceSliderFOUR.setSnapToTicks(true);
        MainUserInterfaceSliderFOUR.setValue(1);

        MainUserInterfaceSliderFIVE.setMajorTickSpacing(1);
        MainUserInterfaceSliderFIVE.setMaximum(10);
        MainUserInterfaceSliderFIVE.setMinimum(1);
        MainUserInterfaceSliderFIVE.setPaintLabels(true);
        MainUserInterfaceSliderFIVE.setPaintTicks(true);
        MainUserInterfaceSliderFIVE.setSnapToTicks(true);
        MainUserInterfaceSliderFIVE.setValue(1);

        MainUserInterfaceLabelONE.setText("LabelONE");

        MainUserInterfaceLabelTWO.setText("LabelTWO");

        MainUserInterfaceLabelTHREE.setText("LabelTHREE");

        MainUserInterfaceLabelFOUR.setText("LabelFOUR");

        MainUserInterfaceLabelFIVE.setText("LabelFIVE");

        MainUserInterfaceButtonSubmit.setText("Submit");
        MainUserInterfaceButtonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainUserInterfaceButtonSubmitActionPerformed(evt);
            }
        });
        MainUserInterfaceButtonSubmit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                MainUserInterfaceButtonSubmitKeyPressed(evt);
            }
        });

        MainUserInterfaceTextAreaComments.setColumns(20);
        MainUserInterfaceTextAreaComments.setRows(5);
        jScrollPane2.setViewportView(MainUserInterfaceTextAreaComments);

        MainUserInterfaceLabelComments.setText("Comments:");

        main_UI_Cancel.setText("Clear");
        main_UI_Cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                main_UI_CancelMouseClicked(evt);
            }
        });
        main_UI_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                main_UI_CancelActionPerformed(evt);
            }
        });
        main_UI_Cancel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                main_UI_CancelKeyPressed(evt);
            }
        });

        patientSelectComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        patientSelectComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientSelectComboBoxActionPerformed(evt);
            }
        });

        viewButton.setText("View");
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MainUserInterfaceLayout = new javax.swing.GroupLayout(MainUserInterface.getContentPane());
        MainUserInterface.getContentPane().setLayout(MainUserInterfaceLayout);
        MainUserInterfaceLayout.setHorizontalGroup(
            MainUserInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainUserInterfaceLayout.createSequentialGroup()
                .addGroup(MainUserInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MainUserInterfaceGUISeparator)
                    .addGroup(MainUserInterfaceLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(MainUserInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MainUserInterfaceLayout.createSequentialGroup()
                                .addGroup(MainUserInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(MainUserInterfaceLabelONE)
                                    .addComponent(MainUserInterfaceLabelTWO)
                                    .addComponent(MainUserInterfaceLabelTHREE)
                                    .addComponent(MainUserInterfaceLabelFOUR)
                                    .addComponent(MainUserInterfaceLabelFIVE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
                                .addGroup(MainUserInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(MainUserInterfaceSliderONE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(MainUserInterfaceSliderTWO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(MainUserInterfaceSliderTHREE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(MainUserInterfaceSliderFOUR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(MainUserInterfaceSliderFIVE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainUserInterfaceLayout.createSequentialGroup()
                                .addComponent(patientSelectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(MainUserInterfaceButtonSubmit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(main_UI_Cancel))
                            .addComponent(jScrollPane2)
                            .addGroup(MainUserInterfaceLayout.createSequentialGroup()
                                .addGroup(MainUserInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(viewButton)
                                    .addComponent(MainUserInterfaceLabelComments))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(20, 20, 20))
        );

        MainUserInterfaceLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {MainUserInterfaceButtonSubmit, main_UI_Cancel, viewButton});

        MainUserInterfaceLayout.setVerticalGroup(
            MainUserInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainUserInterfaceLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(MainUserInterfaceGUISeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(MainUserInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(MainUserInterfaceLabelONE)
                    .addComponent(MainUserInterfaceSliderONE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainUserInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(MainUserInterfaceLabelTWO)
                    .addComponent(MainUserInterfaceSliderTWO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainUserInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(MainUserInterfaceLabelTHREE)
                    .addComponent(MainUserInterfaceSliderTHREE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainUserInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(MainUserInterfaceLabelFOUR)
                    .addComponent(MainUserInterfaceSliderFOUR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainUserInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(MainUserInterfaceLabelFIVE)
                    .addComponent(MainUserInterfaceSliderFIVE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(MainUserInterfaceLabelComments)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(MainUserInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(main_UI_Cancel)
                    .addComponent(MainUserInterfaceButtonSubmit)
                    .addComponent(patientSelectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewButton)
                .addContainerGap())
        );

        MainUserInterfaceLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {MainUserInterfaceButtonSubmit, main_UI_Cancel, patientSelectComboBox, viewButton});

        LoginSuccessWindow.setBounds(new java.awt.Rectangle(0, 22, 316, 130));
        LoginSuccessWindow.setResizable(false);

        SuccessWindowLabelSuccess.setText("YOU IN NIGGA!");

        SuccessWindowButtonSubmit.setText("Okay");
        SuccessWindowButtonSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SuccessWindowButtonSubmitMouseClicked(evt);
            }
        });
        SuccessWindowButtonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuccessWindowButtonSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LoginSuccessWindowLayout = new javax.swing.GroupLayout(LoginSuccessWindow.getContentPane());
        LoginSuccessWindow.getContentPane().setLayout(LoginSuccessWindowLayout);
        LoginSuccessWindowLayout.setHorizontalGroup(
            LoginSuccessWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginSuccessWindowLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SuccessWindowButtonSubmit)
                .addGap(51, 51, 51))
            .addGroup(LoginSuccessWindowLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(SuccessWindowLabelSuccess)
                .addContainerGap(117, Short.MAX_VALUE))
        );
        LoginSuccessWindowLayout.setVerticalGroup(
            LoginSuccessWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginSuccessWindowLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(SuccessWindowLabelSuccess)
                .addGap(18, 18, 18)
                .addComponent(SuccessWindowButtonSubmit)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        LoginFailWindow.setBounds(new java.awt.Rectangle(0, 22, 317, 109));
        LoginFailWindow.setResizable(false);

        SuccessWindowLabelSuccess1.setText("FAIL");

        SuccessWindowButtonSubmit1.setText("Okay");
        SuccessWindowButtonSubmit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SuccessWindowButtonSubmit1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout LoginFailWindowLayout = new javax.swing.GroupLayout(LoginFailWindow.getContentPane());
        LoginFailWindow.getContentPane().setLayout(LoginFailWindowLayout);
        LoginFailWindowLayout.setHorizontalGroup(
            LoginFailWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginFailWindowLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SuccessWindowButtonSubmit1)
                .addGap(52, 52, 52))
            .addGroup(LoginFailWindowLayout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(SuccessWindowLabelSuccess1)
                .addContainerGap(146, Short.MAX_VALUE))
        );
        LoginFailWindowLayout.setVerticalGroup(
            LoginFailWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginFailWindowLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(SuccessWindowLabelSuccess1)
                .addGap(26, 26, 26)
                .addComponent(SuccessWindowButtonSubmit1)
                .addContainerGap())
        );

        PasswordUnsuccessfulWindow.setBounds(new java.awt.Rectangle(0, 22, 328, 120));
        PasswordUnsuccessfulWindow.setResizable(false);

        PasswordUnsuccessfulLabelMessage.setText("<html><font color = \"red\">Passwords Do Not Match! </font><br>\nPlease Try Again.\n\n</html>");

        PasswordUnsuccessfulButtonOkay.setText("Okay");
        PasswordUnsuccessfulButtonOkay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PasswordUnsuccessfulButtonOkayMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PasswordUnsuccessfulWindowLayout = new javax.swing.GroupLayout(PasswordUnsuccessfulWindow.getContentPane());
        PasswordUnsuccessfulWindow.getContentPane().setLayout(PasswordUnsuccessfulWindowLayout);
        PasswordUnsuccessfulWindowLayout.setHorizontalGroup(
            PasswordUnsuccessfulWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PasswordUnsuccessfulWindowLayout.createSequentialGroup()
                .addGroup(PasswordUnsuccessfulWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PasswordUnsuccessfulWindowLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(PasswordUnsuccessfulLabelMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PasswordUnsuccessfulWindowLayout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(PasswordUnsuccessfulButtonOkay)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        PasswordUnsuccessfulWindowLayout.setVerticalGroup(
            PasswordUnsuccessfulWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PasswordUnsuccessfulWindowLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(PasswordUnsuccessfulLabelMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PasswordUnsuccessfulButtonOkay)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        ChooseMember.setName("InitialMenu"); // NOI18N
        ChooseMember.setResizable(false);

        selectPatient.setText("Patient");
        selectPatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectPatientMouseClicked(evt);
            }
        });
        selectPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectPatientActionPerformed(evt);
            }
        });

        selectDoctor.setText("Doctor");
        selectDoctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectDoctorMouseClicked(evt);
            }
        });
        selectDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectDoctorActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/stock-photo-21974050-doctor-using-smartphone.jpg"))); // NOI18N

        greeting.setText("Welcome");

        javax.swing.GroupLayout ChooseMemberLayout = new javax.swing.GroupLayout(ChooseMember.getContentPane());
        ChooseMember.getContentPane().setLayout(ChooseMemberLayout);
        ChooseMemberLayout.setHorizontalGroup(
            ChooseMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChooseMemberLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ChooseMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(ChooseMemberLayout.createSequentialGroup()
                        .addComponent(selectPatient)
                        .addGap(10, 10, 10)
                        .addComponent(selectDoctor))
                    .addComponent(jLabel1)
                    .addComponent(greeting))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ChooseMemberLayout.setVerticalGroup(
            ChooseMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChooseMemberLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(greeting)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ChooseMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectDoctor)
                    .addComponent(selectPatient))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("InitialMenu"); // NOI18N
        setResizable(false);

        InitialMenuButtonPatient.setText("Patient");
        InitialMenuButtonPatient.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                InitialMenuButtonPatientComponentAdded(evt);
            }
        });
        InitialMenuButtonPatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InitialMenuButtonPatientMouseClicked(evt);
            }
        });
        InitialMenuButtonPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InitialMenuButtonPatientActionPerformed(evt);
            }
        });

        InitialMenuButtonDoctor.setText("Doctor");
        InitialMenuButtonDoctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InitialMenuButtonDoctorMouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/stock-photo-21974050-doctor-using-smartphone.jpg"))); // NOI18N

        jLabel3.setText("Welcome");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(InitialMenuButtonPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(InitialMenuButtonDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InitialMenuButtonDoctor)
                    .addComponent(InitialMenuButtonPatient))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
	
	
	

    private void LoginDialogBoxSubmitMouseClicked(java.awt.event.MouseEvent evt){//GEN-FIRST:event_LoginDialogBoxSubmitMouseClicked
        String email = LoginBoxTextFieldUsername.getText();
        char[] password = LoginBoxTextFieldPassword.getPassword();
        
        String[] loginRequest = HCMS.login(this.memberType, email, password);
        
        
        if(loginRequest[0].equals("Logged In."))
        {	
        	getReferenceNumber(this.memberType, LoginBoxTextFieldUsername.getText());
        	setLabel(this.SuccessWindowLabelSuccess, loginRequest[0]);        	        	
	        closeDialog(this.LoginDialogBox);
	        openDialog(this.LoginSuccessWindow);
                setUserDetails(loginRequest[1]);
                clearLogin();
                
                
                loginRequest = new String[loginRequest.length];
                for(int i = 0; i < loginRequest.length; i++)
                    loginRequest[i] = String.valueOf(generator.nextBoolean());
        }
        else
        {
        	setLabel(this.SuccessWindowLabelSuccess1, loginRequest[0]);
                openDialog(this.LoginFailWindow);
                
                this.LoginFailWindow.setAlwaysOnTop(true);
                
                
                
                if(loginRequest[0].contains("Password."))
                {
                    this.LoginBoxTextFieldPassword.requestFocusInWindow();
                    this.LoginBoxTextFieldPassword.selectAll();
                }
                else
                {
                    this.LoginBoxTextFieldUsername.requestFocusInWindow();
                    this.LoginBoxTextFieldUsername.selectAll();
                    
                }
                    
        } 
   
    }//GEN-LAST:event_LoginDialogBoxSubmitMouseClicked

    
    private void setUserDetails(String userDetails)
    {
    	this.activeUserDetails = userDetails;
    }
    
    private void getReferenceNumber(String memberType, String emailId)
    {
    	this.userReferenceNumber = this.HCMS.emailToReferenceNumber(memberType, emailId);
    }
    
    private boolean isPatient()
    {
    	boolean result = false;
    	if(this.memberType.equals("Patient"))
    		result = true;
    	return result;
    }
    
    private void updateSliders(JSlider[] sliders, JLabel[] sliderLabels, String[] sliderParameters)
    {    	    	    	
    	if(sliders.length!=0)
	    	for(int index = 0; index < sliders.length; index++)
	            updateSlider(this.sliders[index], this.sliderLabels[index], this.sliderParameters[index]);           
    }
    
    private void updateSlider(JSlider slider, JLabel sliderLabel, String sliderParameter)
    {
    	setLabel(sliderLabel, String.format("%s: [%2s]", sliderParameter, slider.getValue()));        
    }
    
    private void formatSliders(JSlider[] sliders)
    {
    	for(int index = 0; index < sliders.length; index++)
    	{
            sliders[index].setMaximum(10);
            sliders[index].setMinimum(1);
            sliders[index].setLabelTable(sliders[index].createStandardLabels(1, 1));
            sliders[index].setMajorTickSpacing(1); 
            sliders[index].setMinorTickSpacing(0);
            sliders[index].setPaintTicks(false);
            sliders[index].setPaintLabels(true);
            
            if(!this.memberType.equalsIgnoreCase("Patient"))
            {
                sliders[index].setValue((index + 2)+index);
               
                if(index == sliders.length-1 || index == 0)
                {
                    sliders[index].setExtent(0);
                    sliders[sliders.length-1].setValue(sliders[sliders.length-1].getMaximum());
                    sliders[0].setValue(sliders[0].getMinimum());
                }
                else
                    sliders[(sliders.length-1)- index].setExtent(index);
            }
            else
            {
                sliders[index].setExtent(0);
                sliders[index].setValue(1);
            }
    	}
    }
    
    private void setupMainUI()
    {
        if(this.memberType.equals("Patient"))
        {
            this.patientSelectComboBox.setVisible(false);
            this.viewButton.setVisible(false);
            String msg = this.HCMS.getMessage(this.memberType, this.userReferenceNumber);
            
            this.appendUIDisplay(msg);
        }
        else
        {
            this.viewButton.setVisible(true);
            this.viewButton.setEnabled(true);
            this.patientSelectComboBox.setEnabled(true);
            this.patientSelectComboBox.setVisible(true);
            this.setupComboBox(patientSelectComboBox, this.HCMS.getPatientsAssigned(this.userReferenceNumber));
            
            if(this.HCMS.drHasPendingMessages(userReferenceNumber))
            {
                this.appendUIDisplay("\n You Have " +this.HCMS.drMessagesPendingCount(userReferenceNumber) +" New Message\n");
            }
        }
        
        setupSlider();
    }
    		
    
    private void setupSlider()
    {
    	createSliderArray();
    	createLabelArray();
    	formatSliders(this.sliders);
    	createSliderEventHandler();
    	
    	if(isPatient())
    		this.sliderParameters = this.HCMS.getConditionCategory();
    	else
    		this.sliderParameters = this.HCMS.getAction();
    	
    	updateSliders(this.sliders, this.sliderLabels, this.sliderParameters);
    }
    private void createSliderArray()
    {
    	this.sliders = new JSlider[]{
        		MainUserInterfaceSliderONE,
                MainUserInterfaceSliderTWO,
                MainUserInterfaceSliderTHREE,
                MainUserInterfaceSliderFOUR,
                MainUserInterfaceSliderFIVE
            		};                        
    }
    
    private void createLabelArray()
    {
    	this.sliderLabels = new JLabel[]{
    	        MainUserInterfaceLabelONE,
    	        MainUserInterfaceLabelTWO,
    	        MainUserInterfaceLabelTHREE,
    	        MainUserInterfaceLabelFOUR,
    	        MainUserInterfaceLabelFIVE
            };
    }
    
    private void createSliderEventHandler()
    {
    	this.MainUserInterfaceButtonSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	MainUserInterfaceButtonSubmitMouseClicked(evt);
            }
        });
        
		this.MainUserInterfaceSliderONE.addChangeListener(new javax.swing.event.ChangeListener() {
		public void stateChanged(javax.swing.event.ChangeEvent evt) {
			sliderChange(evt, sliders[0], sliderLabels[0],sliderParameters[0], 0);
		}
		});
		
		this.MainUserInterfaceSliderTWO.addChangeListener(new javax.swing.event.ChangeListener() {
		public void stateChanged(javax.swing.event.ChangeEvent evt) {
			sliderChange(evt, sliders[1], sliderLabels[1],sliderParameters[1], 1);
		}
		});
		
		this.MainUserInterfaceSliderTHREE.addChangeListener(new javax.swing.event.ChangeListener() {
		public void stateChanged(javax.swing.event.ChangeEvent evt) {
			sliderChange(evt, sliders[2], sliderLabels[2],sliderParameters[2], 2);
		}
		});
		
		this.MainUserInterfaceSliderFOUR.addChangeListener(new javax.swing.event.ChangeListener() {
		public void stateChanged(javax.swing.event.ChangeEvent evt) {
			sliderChange(evt, sliders[3], sliderLabels[3],sliderParameters[3], 3);
		}
		});
		
		this.MainUserInterfaceSliderFIVE.addChangeListener(new javax.swing.event.ChangeListener() {
		public void stateChanged(javax.swing.event.ChangeEvent evt) {
			sliderChange(evt, sliders[4], sliderLabels[4],sliderParameters[4], 4);
		}
		});
    }
    
     private void resetSliders(JSlider[] sliders)
    {
        for(int index = 0; index < sliders.length; index++)
        {
            sliders[index].setValue(1);
            sliders[index].setFocusable(true);
        }
    }

    //display current value of slider
    private void sliderChange(javax.swing.event.ChangeEvent evt, JSlider slider, JLabel sliderLabel, String sliderParameter, int index)
    {  
    	updateSlider(slider, sliderLabel, sliderParameter);
        slider.requestFocusInWindow();
        if(memberType.equalsIgnoreCase("Doctor"))
            updateSliderBoundary(this.sliders, index);
              
    }
    
    private void updateSliderBoundary(JSlider[] sliders, int index)
    {
        if(index != sliders.length - 1)
        {
            if(sliders[index].getValue() >= sliders[index+1].getValue())
            {
                sliders[index+1].setValue(sliders[index].getValue()+1);
                if(sliders[index+1].getValue() <= sliders[index].getValue())
                    sliders[index].setValue(sliders[index+1].getValue()- 1);

            }
        }
        if(index != 0)
        {
            if(sliders[index].getValue() <= sliders[index-1].getValue())
            {
                sliders[index-1].setValue(sliders[index].getValue()-1);
                if(sliders[index-1].getValue() >= sliders[index].getValue())
                    sliders[index].setValue(sliders[index-1].getValue() + 1);
            }
        }
   
    }
   
    //take slider values and submit conditions to HCMS
    private void MainUserInterfaceButtonSubmitMouseClicked(java.awt.event.MouseEvent evt){                                                            
    	
    	
    }                                                          
    
    private void PatientRegistrationButtonSubmitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PatientRegistrationButtonSubmitMouseClicked
        //Initialize Variables
        String additionalInfo_1 = this.registrationComboBoxOne.getSelectedItem().toString();
        String additionalInfo_2 = this.registrationComboBoxTwo.getSelectedItem().toString();
        
        String result = "";
        result = "Please Enter:";
        boolean done = false;
        
        while(!done)
        {
            if(isEmpty(this.PatientRegistrationTextFieldFirstName))
            {
                this.PatientRegistrationLabelFirstName.requestFocusInWindow();
                result += "  First Name\n";
                break;
            }
            if(isEmpty(this.PatientRegistrationTextFieldLastName))
            {
                this.PatientRegistrationTextFieldLastName.requestFocusInWindow();
                result += "  Last Name\n";
                break;
            }

            if(isEmpty(this.PatientRegistrationPasswordFieldPassword))
            {
                this.PatientRegistrationPasswordFieldPassword.requestFocusInWindow();
                result += "  Password\n";
                break;
            }

            if(isEmpty(this.PatientRegistrationPasswordFieldConfirm))
            {
                result += "  Password Confirmation\n";
                this.PatientRegistrationLabelConfirmPassword.requestFocusInWindow();
                break;
            }
            
            if(isEmpty(this.PatientRegistrationTextFieldPhoneNumber))
            {
                result += "  Phone\n";
                this.PatientRegistrationLabelPhoneNumber.requestFocusInWindow();
                break;
            }

            if(isEmpty(this.PatientRegistrationTextFieldEmail))
            {
                result += "  Email\n";
                this.PatientRegistrationTextFieldEmail.requestFocusInWindow();
                break;
            }
            result = "";
            done = true;
        }
       
        
        
        
        if(this.registrationComboBoxOne.getSelectedIndex()==0)
        {
            if(this.memberType.equalsIgnoreCase("Patient"))
                result = "Please Select a Doctor";
            else
                result = "Please Select a Medical Field";
        }
       
        
        
        
        if(this.registrationComboBoxOne.getSelectedIndex()!=0 && !result.contains("Please"))
        {
            result = HCMS.register
                            (
                            this.memberType,
                            String.format("%s, %s", PatientRegistrationTextFieldLastName.getText(), PatientRegistrationTextFieldFirstName.getText()), 
                            PatientRegistrationPasswordFieldPassword.getPassword(), 
                            PatientRegistrationPasswordFieldConfirm.getPassword(), 
                            String.valueOf(this.registrationComboBoxOne.getSelectedIndex()),
                            this.registrationComboBoxTwo.getSelectedItem().toString(),
                            PatientRegistrationTextFieldEmail.getText(), 
                            PatientRegistrationTextFieldPhoneNumber.getText()

                            ); 
        }
   
        if(result.equals("Registration Complete!"))
        {		    
        	closeWindow(this.RegisterMenu);
        	openDialog(this.LoginDialogBox);			
                System.out.format("%s, %s", result, this.HCMS.toString());
                clearRegistration();
        }
        else
        {
        	setLabel(this.PasswordUnsuccessfulLabelMessage,result);        	
        	openDialog(PasswordUnsuccessfulWindow);
                
                if(result.contains("Password"))
                {
                   this.PatientRegistrationPasswordFieldConfirm.requestFocusInWindow();
                   this.PatientRegistrationPasswordFieldConfirm.selectAll();
                }
                else if(this.registrationComboBoxOne.getSelectedIndex()==0)
                {  
                    this.registrationComboBoxOne.requestFocus();
                    this.registrationComboBoxOne.getEditor().getEditorComponent().requestFocusInWindow();
                    this.registrationComboBoxOne.setSelectedIndex(0);
                    
                }
                else
                {
                this.PatientRegistrationTextFieldEmail.requestFocusInWindow();
                this.PatientRegistrationTextFieldEmail.selectAll();
                }
        }
        
        
	        	   
    }//GEN-LAST:event_PatientRegistrationButtonSubmitMouseClicked

    private boolean isEmpty(JTextField field)
    {
        boolean result = false;
        
        if(field.getText().isEmpty())
            result = true;
        
        return result;
    }
    
    private boolean allEmpty(JTextField[] fields)
    {
        return false;
    }
    
    
    
    private void appendUIDisplay(String input)
    {
    	try
    	{
    		Document doc = this.MainUserInterfaceTextPaneHistory.getDocument();
    		doc.insertString(doc.getLength(), String.format("%s%n", input), null);
    	}
    	catch(BadLocationException e)
    	{
    		e.printStackTrace();
    	}
    }
    
    private void openDialog(JDialog dialog)
    {
    	dialog.setVisible(true);
        dialog.repaint();
    }
    
    private void closeDialog(JDialog dialog)
    {
    	dialog.setVisible(false);
    	dialog.dispose();
    }
    
    private void closeWindow(JFrame window)
    {
    	window.setVisible(false);
    	window.dispose();
    }    
    
    private void openWindow(JFrame window)
    {
    	window.setVisible(true);
    }
    private void setLabel(JLabel label, String text)
    {
    	label.setText(text);
    }
    
    private void setMemberType(String memberType)
    {
    	this.memberType = memberType;
    }

    private void PatientRegistrationButtonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PatientRegistrationButtonSubmitActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_PatientRegistrationButtonSubmitActionPerformed

    private void jDrLoginActionPerformed(java.awt.event.ActionEvent evt) 
    {                                         
        // TODO add your handling code here:
    	//this.memberType = "Doctor";
    }                                        

    private void jPatientLoginMouseClicked(java.awt.event.MouseEvent evt) 
{                                           
                                           
        // TODO add your handling code here:
    	setMemberType("Patient");
    	openDialog(this.LoginDialogBox);        
    }                                          
    
    private void jDrLoginMouseClicked(java.awt.event.MouseEvent evt){//GEN-FIRST:event_jPatientLoginMouseClicked

    	setMemberType("Doctor");
    	openDialog(this.LoginDialogBox);    	
    }//GEN-LAST:event_jPatientLoginMouseClicked


    private void SuccessWindowButtonSubmitMouseClicked(java.awt.event.MouseEvent evt){//GEN-FIRST:event_SuccessWindowButtonSubmitMouseClicked
        
        LoginSuccessWindow.dispose();
        this.setVisible(false);
        clearLogin();
        this.MainUserInterfaceTextPaneHistory.setText(String.format("Welcome, %s", this.activeUserDetails));
        
        setupMainUI();
        MainUserInterface.setVisible(true);
    }//GEN-LAST:event_SuccessWindowButtonSubmitMouseClicked


    private void SuccessWindowButtonSubmit1MouseClicked(java.awt.event.MouseEvent evt){//GEN-FIRST:event_SuccessWindowButtonSubmit1MouseClicked
        
    	closeDialog(this.LoginFailWindow);
        openDialog(this.LoginDialogBox);        
    }//GEN-LAST:event_SuccessWindowButtonSubmit1MouseClicked


    private void PasswordUnsuccessfulButtonOkayMouseClicked(java.awt.event.MouseEvent evt)    {//GEN-FIRST:event_PasswordUnsuccessfulButtonOkayMouseClicked

        closeDialog(PasswordUnsuccessfulWindow);
    }//GEN-LAST:event_PasswordUnsuccessfulButtonOkayMouseClicked


    private void InitialMenuButtonPatientMouseClicked(java.awt.event.MouseEvent evt){//GEN-FIRST:event_InitialMenuButtonPatientMouseClicked
    	setMemberType("Patient");
        openDialog(this.LoginDialogBox);
    }//GEN-LAST:event_InitialMenuButtonPatientMouseClicked


    private void InitialMenuButtonDoctorMouseClicked(java.awt.event.MouseEvent evt){//GEN-FIRST:event_InitialMenuButtonDoctorMouseClicked

        setMemberType("Doctor");
        openDialog(this.LoginDialogBox);
    }//GEN-LAST:event_InitialMenuButtonDoctorMouseClicked


    private void selectDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectDoctorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectDoctorActionPerformed

    private void selectPatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectPatientMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_selectPatientMouseClicked

    private void selectDoctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectDoctorMouseClicked

    	setMemberType("Doctor");        
    	closeWindow(this.ChooseMember);
        openDialog(this.LoginDialogBox);       
    }//GEN-LAST:event_selectDoctorMouseClicked


    private void selectPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectPatientActionPerformed

    	setMemberType("Patient");
    	closeWindow(this.ChooseMember);
        openDialog(this.LoginDialogBox);
    }//GEN-LAST:event_selectPatientActionPerformed


    private void InitialMenuButtonPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InitialMenuButtonPatientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InitialMenuButtonPatientActionPerformed

    private void InitialMenuButtonPatientComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_InitialMenuButtonPatientComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_InitialMenuButtonPatientComponentAdded

    private void register_linkMouseClicked(java.awt.event.MouseEvent evt) 
    {       	
        closeDialog(this.LoginDialogBox);
        initializeRegistration();
        clearRegistration();
        clearLogin();
        openWindow(this.RegisterMenu);
    }
    
    private void initializeRegistration()
    {
    	if (this.memberType.equals("Patient"))
    	{
    		setLabel(this.PatientRegistrationLabelUnderlyingCondition,"Underlying Condition");            
        	setLabel(this.PatientRegistrationLabelDoctorAssigned,"Doctor Assigned");        	
    	}
    	else
    	{
    		setLabel(this.PatientRegistrationLabelDoctorAssigned,"Medical Field");            
            setLabel(this.PatientRegistrationLabelUnderlyingCondition, "Number of Patients");       	
    	}
        
    	initializeComboBox();
    }
    
    private void initializeComboBox()
    {
    	String[] comboOneData, comboTwoData;
    	
    	if (this.memberType.equals("Patient"))
    	{       
    		comboOneData = this.HCMS.getDoctorList();
                System.out.println(comboOneData.length);
    		comboTwoData = this.HCMS.getUnderlyingConditions();
    	}
        
    	else
    	{  
               // String[] temp = this
    		comboOneData = this.HCMS.getMedicalField(); 
    		comboTwoData = new String[25];
    		
            for(int count = 0; count < comboTwoData.length; count++)
                comboTwoData[count]=String.valueOf(count+1);
        } 
    	
    	setupComboBox(this.registrationComboBoxOne, comboOneData);
        setupComboBox(this.registrationComboBoxTwo, comboTwoData);
	}
    
    private void setupComboBox(JComboBox<Object> comboBox, String[] elements)
    {
//    	
        comboBox.removeAllItems();
    	for(int index = 0; index < elements.length; index++)
        {
            comboBox.addItem(elements[index]);
            
            
            comboBox.repaint();
        }
    }
    private void clearTextField(JTextField field)
    {
        field.setText("");
    }
    
    private void clearTextPane(JTextPane pane)
    {
        pane.setText("");
    }
    
    private void clearTextArea(JTextArea area)
    {
        area.setText("");
    }

    private void LoginDialogBoxSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginDialogBoxSubmitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginDialogBoxSubmitActionPerformed

    private void SuccessWindowButtonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuccessWindowButtonSubmitActionPerformed

        //this.MainUserInterface.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_SuccessWindowButtonSubmitActionPerformed

   
    private void registrationComboBoxOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrationComboBoxOneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registrationComboBoxOneActionPerformed

    private void MainUserInterfaceButtonSubmitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MainUserInterfaceButtonSubmitKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_MainUserInterfaceButtonSubmitKeyPressed

    private void main_UI_CancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_main_UI_CancelMouseClicked
        clearTextArea(this.MainUserInterfaceTextAreaComments);       
        resetSliders(this.sliders);
        if(this.buttonState.equals("Logout"))
        {
            clearTextPane(this.MainUserInterfaceTextPaneHistory);
            this.activeUserDetails = "";
            this.userReferenceNumber = 0;
            this.memberType = "";
            this.buttonState = "";
            trashDocument();
            this.MainUserInterfaceButtonSubmit.setEnabled(true);           
            this.main_UI_Cancel.setText("Clear");
            this.MainUserInterfaceButtonSubmit.setText("Submit");
            closeWindow(this.MainUserInterface);
            openWindow(this);            
        }
        
    }//GEN-LAST:event_main_UI_CancelMouseClicked

    private void trashDocument()
    {
        try
        {
            this.MainUserInterfaceTextPaneHistory.getDocument().remove(0, this.MainUserInterfaceTextPaneHistory.getDocument().getLength());
        }
        catch(BadLocationException ble)
        {
            
        }
    }
    
    private void main_UI_CancelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_main_UI_CancelKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_main_UI_CancelKeyPressed

    private void MainUserInterfaceButtonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainUserInterfaceButtonSubmitActionPerformed
        
        if(!this.MainUserInterfaceButtonSubmit.getText().equalsIgnoreCase("Continue"))
        {
            updateStatus();
            if(this.memberType.equals("Patient"))
                this.MainUserInterfaceButtonSubmit.setEnabled(false);
            else
                this.MainUserInterfaceButtonSubmit.setText("Continue");
            
            this.viewButton.setEnabled(false);
            this.patientSelectComboBox.setEnabled(false);
            this.main_UI_Cancel.setText("Exit");
            this.buttonState = "Logout";
            this.main_UI_Cancel.requestFocusInWindow();
        }
        else
        {
            this.MainUserInterfaceButtonSubmit.setText("Submit");
            this.main_UI_Cancel.setText("Clear");
            this.viewButton.setEnabled(true);
            this.patientSelectComboBox.setEnabled(true);
        }
    }//GEN-LAST:event_MainUserInterfaceButtonSubmitActionPerformed

    private void updateStatus()
    {
        if(isPatient())
    	{
            this.appendUIDisplay(    	
                    this.HCMS.updatePatientStatus(
                                    this.userReferenceNumber, 
                                    new int[]{  this.MainUserInterfaceSliderONE.getValue(), 
                                                this.MainUserInterfaceSliderTWO.getValue(),
                                                this.MainUserInterfaceSliderTHREE.getValue(),
                                                this.MainUserInterfaceSliderFOUR.getValue(),
                                                this.MainUserInterfaceSliderFIVE.getValue()})    	
                    );
            this.appendUIDisplay(this.HCMS.sendMessage(memberType, userReferenceNumber, this.MainUserInterfaceTextAreaComments.getText()));
    	}
    	else
    	{
            this.appendUIDisplay(    	
                    this.HCMS.updateThreshold(
                                    this.userReferenceNumber,
                                    this.patientSelectComboBox.getSelectedIndex()+1,
                                    new int[]{this.MainUserInterfaceSliderONE.getValue(), 
                                                    this.MainUserInterfaceSliderTWO.getValue(),
                                                    this.MainUserInterfaceSliderTHREE.getValue(),
                                                    this.MainUserInterfaceSliderFOUR.getValue(),
                                                    this.MainUserInterfaceSliderFIVE.getValue()})    	
                    );
            this.appendUIDisplay(this.HCMS.sendPatientResponse(userReferenceNumber, this.patientSelectComboBox.getSelectedIndex()+1, this.MainUserInterfaceTextAreaComments.getText()));
    	}
        
    }
    
    private void main_UI_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_main_UI_CancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_main_UI_CancelActionPerformed

    private void cancelLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelLoginActionPerformed
        clearLogin();
        closeDialog(this.LoginDialogBox);
        openWindow(this);
    }//GEN-LAST:event_cancelLoginActionPerformed

    private void clearLogin()
    {
        clearTextField(this.LoginBoxTextFieldPassword);
        clearTextField(this.LoginBoxTextFieldUsername);
    }
    private void registrationClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrationClearActionPerformed
        clearRegistration();
    }//GEN-LAST:event_registrationClearActionPerformed

    private void patientSelectComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientSelectComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patientSelectComboBoxActionPerformed

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed
        this.appendUIDisplay(this.HCMS.getPatientHistory(this.userReferenceNumber, this.patientSelectComboBox.getSelectedIndex()+1));
        this.appendUIDisplay(this.HCMS.getPatientMessage(this.userReferenceNumber, this.patientSelectComboBox.getSelectedIndex()+1));
        
    }//GEN-LAST:event_viewButtonActionPerformed

    private void clearRegistration()
    {
        clearTextField(this.PatientRegistrationTextFieldPhoneNumber);
        clearTextField(this.PatientRegistrationTextFieldLastName);
        clearTextField(this.PatientRegistrationTextFieldFirstName);
        clearTextField(this.PatientRegistrationTextFieldEmail);
        clearTextField(this.PatientRegistrationPasswordFieldPassword);
        clearTextField(this.PatientRegistrationPasswordFieldConfirm);
        this.registrationComboBoxOne.setSelectedIndex(0);
        this.registrationComboBoxTwo.setSelectedIndex(0);
    }
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame ChooseMember;
    private javax.swing.JButton InitialMenuButtonDoctor;
    private javax.swing.JButton InitialMenuButtonPatient;
    private javax.swing.JPasswordField LoginBoxTextFieldPassword;
    private javax.swing.JTextField LoginBoxTextFieldUsername;
    private javax.swing.JDialog LoginDialogBox;
    private javax.swing.JButton LoginDialogBoxSubmit;
    private javax.swing.JDialog LoginFailWindow;
    private java.awt.Label LoginLabelPassword;
    private java.awt.Label LoginLabelUsername;
    private javax.swing.JDialog LoginSuccessWindow;
    private javax.swing.JFrame MainUserInterface;
    private javax.swing.JButton MainUserInterfaceButtonSubmit;
    private javax.swing.JSeparator MainUserInterfaceGUISeparator;
    private javax.swing.JLabel MainUserInterfaceLabelComments;
    private javax.swing.JLabel MainUserInterfaceLabelFIVE;
    private javax.swing.JLabel MainUserInterfaceLabelFOUR;
    private javax.swing.JLabel MainUserInterfaceLabelONE;
    private javax.swing.JLabel MainUserInterfaceLabelTHREE;
    private javax.swing.JLabel MainUserInterfaceLabelTWO;
    private javax.swing.JSlider MainUserInterfaceSliderFIVE;
    private javax.swing.JSlider MainUserInterfaceSliderFOUR;
    private javax.swing.JSlider MainUserInterfaceSliderONE;
    private javax.swing.JSlider MainUserInterfaceSliderTHREE;
    private javax.swing.JSlider MainUserInterfaceSliderTWO;
    private javax.swing.JTextArea MainUserInterfaceTextAreaComments;
    private javax.swing.JTextPane MainUserInterfaceTextPaneHistory;
    private javax.swing.JLabel NewPatientRegistrationLabel;
    private javax.swing.JButton PasswordUnsuccessfulButtonOkay;
    private javax.swing.JLabel PasswordUnsuccessfulLabelMessage;
    private javax.swing.JDialog PasswordUnsuccessfulWindow;
    private static javax.swing.JButton PatientRegistrationButtonSubmit;
    private javax.swing.JLabel PatientRegistrationLabelConfirmPassword;
    private javax.swing.JLabel PatientRegistrationLabelDoctorAssigned;
    private javax.swing.JLabel PatientRegistrationLabelEmail;
    private javax.swing.JLabel PatientRegistrationLabelFirstName;
    private javax.swing.JLabel PatientRegistrationLabelLastName;
    private javax.swing.JLabel PatientRegistrationLabelPassword;
    private javax.swing.JLabel PatientRegistrationLabelPhoneNumber;
    private javax.swing.JLabel PatientRegistrationLabelUnderlyingCondition;
    private javax.swing.JPasswordField PatientRegistrationPasswordFieldConfirm;
    private javax.swing.JPasswordField PatientRegistrationPasswordFieldPassword;
    private javax.swing.JTextField PatientRegistrationTextFieldEmail;
    private javax.swing.JTextField PatientRegistrationTextFieldFirstName;
    private javax.swing.JTextField PatientRegistrationTextFieldLastName;
    private javax.swing.JTextField PatientRegistrationTextFieldPhoneNumber;
    private javax.swing.JFrame RegisterMenu;
    private javax.swing.JButton SuccessWindowButtonSubmit;
    private javax.swing.JButton SuccessWindowButtonSubmit1;
    private javax.swing.JLabel SuccessWindowLabelSuccess;
    private javax.swing.JLabel SuccessWindowLabelSuccess1;
    private javax.swing.JButton cancelLogin;
    private javax.swing.JLabel greeting;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton main_UI_Cancel;
    private javax.swing.JComboBox patientSelectComboBox;
    private javax.swing.JLabel register_link;
    private javax.swing.JButton registrationClear;
    private javax.swing.JComboBox registrationComboBoxOne;
    private javax.swing.JComboBox registrationComboBoxTwo;
    private javax.swing.JButton selectDoctor;
    private javax.swing.JButton selectPatient;
    private javax.swing.JButton viewButton;
    // End of variables declaration//GEN-END:variables
    
    //Variable Declarations
//    private javax.swing.JComboBox<Object> registrationComboBoxOne = new JComboBox();
//    private javax.swing.JComboBox<Object> registrationComboBoxTwo = new JComboBox();
    private JLabel[] sliderLabels;
    private JSlider[] sliders;
    private Component frame;
    private Component component;
    private String buttonState = "", buttonsStateSubmit = "";
    private String doctors[][];
    ArrayList<Object> vals = new ArrayList<Object>();
}

