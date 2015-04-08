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

import edu.asu.se.group5.business.HealthCareManagementSystem;

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
        jButton1 = new javax.swing.JButton();
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
        MainUserInterface = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        MainUserInterfaceTextPaneHistory = new javax.swing.JTextPane();
        
        
        
       
        
        sliders = new JSlider[]{
    		MainUserInterfaceSliderONE = new javax.swing.JSlider(),
            MainUserInterfaceSliderTWO = new javax.swing.JSlider(),
            MainUserInterfaceSliderTHREE = new javax.swing.JSlider(),
            MainUserInterfaceSliderFOUR = new javax.swing.JSlider(),
            MainUserInterfaceSliderFIVE = new javax.swing.JSlider()
        		};
        
        sliderLabels = new JLabel[]{
	        MainUserInterfaceLabelONE = new javax.swing.JLabel(),
	        MainUserInterfaceLabelTWO = new javax.swing.JLabel(),
	        MainUserInterfaceLabelTHREE = new javax.swing.JLabel(),
	        MainUserInterfaceLabelFOUR = new javax.swing.JLabel(),
	        MainUserInterfaceLabelFIVE = new javax.swing.JLabel()
        };
        
        MainUserInterfaceGUISeparator = new javax.swing.JSeparator();
        MainUserInterfaceButtonSubmit = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        MainUserInterfaceTextAreaComments = new javax.swing.JTextArea();
        MainUserInterfaceLabelComments = new javax.swing.JLabel();
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

        jButton1.setText("Cancel");

        javax.swing.GroupLayout LoginDialogBoxLayout = new javax.swing.GroupLayout(LoginDialogBox.getContentPane());
        LoginDialogBox.getContentPane().setLayout(LoginDialogBoxLayout);
        LoginDialogBoxLayout.setHorizontalGroup(
            LoginDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginDialogBoxLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(LoginDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LoginLabelPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LoginLabelUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(LoginDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(register_link)
                    .addGroup(LoginDialogBoxLayout.createSequentialGroup()
                        .addComponent(LoginDialogBoxSubmit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(LoginBoxTextFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LoginBoxTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(register_link)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        LoginDialogBoxLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {LoginBoxTextFieldPassword, LoginBoxTextFieldUsername});

        LoginLabelUsername.getAccessibleContext().setAccessibleName("");

        RegisterMenu.setBounds(new java.awt.Rectangle(0, 22, 300, 450));
        RegisterMenu.setResizable(false);

        NewPatientRegistrationLabel.setText("New Patient Registration");

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

        registrationComboBoxOne.setEditable(true);
        registrationComboBoxOne.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Walter Bishop", "Henry Jekyll", "Dr. Dre", "Hannibal Lecter", "Dr. Evil" }));
        registrationComboBoxOne.setPreferredSize(new java.awt.Dimension(112, 28));
        registrationComboBoxOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PatientRegistrationComboBoxDoctorAssignedActionPerformed(evt);
            }
        });

        PatientRegistrationLabelUnderlyingCondition.setText("Underlying Condition:");

        registrationComboBoxTwo.setEditable(true);
        registrationComboBoxTwo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Condition1", "Condition2", "Condition3", "Condition 4" }));

        PatientRegistrationLabelConfirmPassword.setText("Confirm Password:");

        PatientRegistrationLabelLastName.setText("Last Name");

        PatientRegistrationPasswordFieldPassword.setPreferredSize(new java.awt.Dimension(105, 28));

        PatientRegistrationPasswordFieldConfirm.setPreferredSize(new java.awt.Dimension(105, 28));

        javax.swing.GroupLayout RegisterMenuLayout = new javax.swing.GroupLayout(RegisterMenu.getContentPane());
        RegisterMenu.getContentPane().setLayout(RegisterMenuLayout);
        RegisterMenuLayout.setHorizontalGroup(
            RegisterMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegisterMenuLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(NewPatientRegistrationLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(RegisterMenuLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(RegisterMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(registrationComboBoxOne, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(RegisterMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(PatientRegistrationLabelFirstName, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PatientRegistrationLabelPassword, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PatientRegistrationLabelPhoneNumber, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PatientRegistrationTextFieldPhoneNumber, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PatientRegistrationLabelDoctorAssigned, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                        .addComponent(PatientRegistrationTextFieldFirstName, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PatientRegistrationPasswordFieldPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(RegisterMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegisterMenuLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(RegisterMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PatientRegistrationLabelConfirmPassword)
                            .addGroup(RegisterMenuLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(PatientRegistrationLabelUnderlyingCondition))
                            .addComponent(registrationComboBoxTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(RegisterMenuLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(PatientRegistrationLabelEmail))
                            .addComponent(PatientRegistrationTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PatientRegistrationLabelLastName)
                            .addComponent(PatientRegistrationTextFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PatientRegistrationPasswordFieldConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(RegisterMenuLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PatientRegistrationButtonSubmit)
                        .addGap(49, 49, 49))))
        );
        RegisterMenuLayout.setVerticalGroup(
            RegisterMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegisterMenuLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(NewPatientRegistrationLabel)
                .addGap(35, 35, 35)
                .addGroup(RegisterMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PatientRegistrationLabelFirstName)
                    .addComponent(PatientRegistrationLabelLastName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RegisterMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PatientRegistrationTextFieldFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PatientRegistrationTextFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RegisterMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(RegisterMenuLayout.createSequentialGroup()
                        .addGroup(RegisterMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PatientRegistrationLabelPassword)
                            .addComponent(PatientRegistrationLabelConfirmPassword))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(RegisterMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PatientRegistrationPasswordFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PatientRegistrationPasswordFieldConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PatientRegistrationLabelPhoneNumber)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PatientRegistrationTextFieldPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RegisterMenuLayout.createSequentialGroup()
                        .addComponent(PatientRegistrationLabelEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PatientRegistrationTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RegisterMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(RegisterMenuLayout.createSequentialGroup()
                        .addComponent(PatientRegistrationLabelDoctorAssigned)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(registrationComboBoxOne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RegisterMenuLayout.createSequentialGroup()
                        .addComponent(PatientRegistrationLabelUnderlyingCondition)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(registrationComboBoxTwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PatientRegistrationButtonSubmit)
                .addGap(28, 28, 28))
        );

        MainUserInterface.setBounds(new java.awt.Rectangle(0, 22, 506, 800));
        MainUserInterface.setPreferredSize(new java.awt.Dimension(506, 800));
        MainUserInterface.setResizable(false);

        MainUserInterfaceTextPaneHistory.setEditable(false);
        jScrollPane1.setViewportView(MainUserInterfaceTextPaneHistory);

        MainUserInterfaceSliderONE.setMaximum(10);
        MainUserInterfaceSliderONE.setMinimum(1);

        MainUserInterfaceSliderTWO.setMaximum(10);
        MainUserInterfaceSliderTWO.setMinimum(1);

        MainUserInterfaceSliderTHREE.setMaximum(10);
        MainUserInterfaceSliderTHREE.setMinimum(1);

        MainUserInterfaceSliderFOUR.setMaximum(10);
        MainUserInterfaceSliderFOUR.setMinimum(1);

        MainUserInterfaceSliderFIVE.setMaximum(10);
        MainUserInterfaceSliderFIVE.setMinimum(1);
        
        		this.MainUserInterfaceSliderONE.setMajorTickSpacing(1);
                this.MainUserInterfaceSliderONE.setPaintTicks(true);
                this.MainUserInterfaceSliderONE.setPaintLabels(true);
                
                this.MainUserInterfaceSliderTWO.setMajorTickSpacing(1);
                this.MainUserInterfaceSliderTWO.setPaintTicks(true);
                this.MainUserInterfaceSliderTWO.setPaintLabels(true);
                
                this.MainUserInterfaceSliderTHREE.setMajorTickSpacing(1);
                this.MainUserInterfaceSliderTHREE.setPaintTicks(true);
                this.MainUserInterfaceSliderTHREE.setPaintLabels(true);
                
                this.MainUserInterfaceSliderFOUR.setMajorTickSpacing(1);
                this.MainUserInterfaceSliderFOUR.setPaintTicks(true);
                this.MainUserInterfaceSliderFOUR.setPaintLabels(true);
                
                this.MainUserInterfaceSliderFIVE.setMajorTickSpacing(1);
                this.MainUserInterfaceSliderFIVE.setPaintTicks(true);
                this.MainUserInterfaceSliderFIVE.setPaintLabels(true);
        
                this.MainUserInterfaceLabelONE.setText(String.format("Pain: [%2s]", this.MainUserInterfaceSliderONE.getValue()));
                this.MainUserInterfaceLabelTWO.setText(String.format("Anxiety: [%2s]", this.MainUserInterfaceSliderTWO.getValue()));
                this.MainUserInterfaceLabelTHREE.setText(String.format("Depression: [%2s]", this.MainUserInterfaceSliderTHREE.getValue()));
                this.MainUserInterfaceLabelFOUR.setText(String.format("Nausea: [%2s]", this.MainUserInterfaceSliderFOUR.getValue()));
                this.MainUserInterfaceLabelFIVE.setText(String.format("Other: [%2s]", this.MainUserInterfaceSliderFIVE.getValue()));
                
        

        MainUserInterfaceButtonSubmit.setText("Submit Update!");

        MainUserInterfaceTextAreaComments.setColumns(20);
        MainUserInterfaceTextAreaComments.setRows(5);
        jScrollPane2.setViewportView(MainUserInterfaceTextAreaComments);

        MainUserInterfaceLabelComments.setText("Comments:");

        javax.swing.GroupLayout MainUserInterfaceLayout = new javax.swing.GroupLayout(MainUserInterface.getContentPane());
        MainUserInterface.getContentPane().setLayout(MainUserInterfaceLayout);
        MainUserInterfaceLayout.setHorizontalGroup(
            MainUserInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainUserInterfaceLayout.createSequentialGroup()
                .addGroup(MainUserInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainUserInterfaceLayout.createSequentialGroup()
                        .addGroup(MainUserInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MainUserInterfaceLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(MainUserInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(MainUserInterfaceLabelONE)
                                    .addComponent(MainUserInterfaceLabelTWO)
                                    .addComponent(MainUserInterfaceLabelTHREE)
                                    .addComponent(MainUserInterfaceLabelFOUR)
                                    .addComponent(MainUserInterfaceLabelFIVE))
                                .addGap(52, 52, 52)
                                .addGroup(MainUserInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(MainUserInterfaceSliderFIVE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(MainUserInterfaceSliderFOUR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(MainUserInterfaceSliderTHREE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(MainUserInterfaceSliderTWO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(MainUserInterfaceSliderONE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(MainUserInterfaceLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addComponent(MainUserInterfaceGUISeparator)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainUserInterfaceLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(MainUserInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MainUserInterfaceButtonSubmit)
                            .addGroup(MainUserInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(MainUserInterfaceLabelComments)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        MainUserInterfaceLayout.setVerticalGroup(
            MainUserInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainUserInterfaceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainUserInterfaceGUISeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(MainUserInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MainUserInterfaceSliderONE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MainUserInterfaceLabelONE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainUserInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MainUserInterfaceSliderTWO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MainUserInterfaceLabelTWO))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainUserInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MainUserInterfaceSliderTHREE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MainUserInterfaceLabelTHREE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainUserInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MainUserInterfaceSliderFOUR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MainUserInterfaceLabelFOUR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainUserInterfaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MainUserInterfaceSliderFIVE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MainUserInterfaceLabelFIVE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MainUserInterfaceLabelComments)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(MainUserInterfaceButtonSubmit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
        
        this.MainUserInterfaceButtonSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
        	            public void mouseClicked(java.awt.event.MouseEvent evt) {
        	            	MainUserInterfaceButtonSubmitMouseClicked(evt);
        	            }
        	        });
        	        
        this.MainUserInterfaceSliderONE.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
            	sliderChange(evt, sliders[0], sliderLabels[0],sliderParameters[0]);
            }
        });
        
        this.MainUserInterfaceSliderTWO.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
            	sliderChange(evt, sliders[1], sliderLabels[1],sliderParameters[1]);
            }
        });
        
        this.MainUserInterfaceSliderTHREE.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
            	sliderChange(evt, sliders[2], sliderLabels[2],sliderParameters[2]);
            }
        });
        
        this.MainUserInterfaceSliderFOUR.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
            	sliderChange(evt, sliders[3], sliderLabels[3],sliderParameters[3]);
            }
        });
        
        this.MainUserInterfaceSliderFIVE.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
            	sliderChange(evt, sliders[4], sliderLabels[4],sliderParameters[4]);
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
    }
	
	
	

    private void LoginDialogBoxSubmitMouseClicked(java.awt.event.MouseEvent evt) 
    {
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
        }
        else
        {
        	setLabel(this.SuccessWindowLabelSuccess1, loginRequest[0]);
        	closeDialog(this.LoginDialogBox);           
        	openDialog(this.LoginFailWindow);                        
        } 
   
    }
    
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
    
    private void setupSliderParameters(JSlider[] sliders, JLabel[] sliderLabels, String[] sliderParameters)
    {    	    	    	
    	if(sliders.length!=0)
	    	for(int index = 0; index < sliders.length; index++)
	            setSliderLabel(sliders[index], sliderLabels[index], sliderParameters[index]);           
    }
    
    private void setSliderLabel(JSlider slider, JLabel sliderLabel, String sliderParameter)
    {
    	setLabel(sliderLabel, String.format("%s: [%2s]", sliderParameter, slider.getValue()));
        slider.setMaximum(10);
        slider.setMinimum(1);
        slider.setMajorTickSpacing(5); 
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
    }
    
    private void setupSlider()
    {
    	if(isPatient())
    		this.sliderParameters = new String[]{"Pain","Anxiety","Depression","Nausea","Dizziness"};
    	else
    		this.sliderParameters = new String[]{"Bed Rest","Take Medication","Call Doctor","Emergency Room","911"};
    	
    	setupSliderParameters(this.sliders, this.sliderLabels, this.sliderParameters);
    }

    //display current value of slider
    private void sliderChange(javax.swing.event.ChangeEvent evt, JSlider slider, JLabel sliderLabel, String sliderParameter)
    {  
    	setSliderLabel(slider, sliderLabel, sliderParameter);  		
    }
    
    //take slider values and submit conditions to HCMS
    private void MainUserInterfaceButtonSubmitMouseClicked(java.awt.event.MouseEvent evt)
    { 
    	
    	if(isPatient())
    	{
	    	this.appendUIDisplay(    	
		    	this.HCMS.updatePatientStatus(
		    			this.userReferenceNumber, 
		    			new int[]{this.MainUserInterfaceSliderONE.getValue(), 
		    					this.MainUserInterfaceSliderTWO.getValue(),
		    					this.MainUserInterfaceSliderTHREE.getValue(),
		    					this.MainUserInterfaceSliderFOUR.getValue(),
		    					this.MainUserInterfaceSliderFIVE.getValue()})    	
		    	);
    	}
    	else
    	{
    		this.appendUIDisplay(    	
    		    	this.HCMS.updatePatientStatus(
    		    			this.userReferenceNumber, 
    		    			new int[]{this.MainUserInterfaceSliderONE.getValue(), 
    		    					this.MainUserInterfaceSliderTWO.getValue(),
    		    					this.MainUserInterfaceSliderTHREE.getValue(),
    		    					this.MainUserInterfaceSliderFOUR.getValue(),
    		    					this.MainUserInterfaceSliderFIVE.getValue()})    	
    		    	);
    	}
    }

    
    
    private void PatientRegistrationButtonSubmitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PatientRegistrationButtonSubmitMouseClicked
        //Initialize Variables
        String additionalInfo_1 = this.registrationComboBoxOne.getSelectedItem().toString();
        String additionalInfo_2 = this.registrationComboBoxTwo.getSelectedItem().toString();

        //handle patient reg.
        if(this.memberType.equals("Patient"))
        {
	        if(additionalInfo_1 == "Walter Bishop") {additionalInfo_1 = "1001";}
	        else if (additionalInfo_1 == "Henry Jekyll") {additionalInfo_1 = "1002";}
	        else if (additionalInfo_1 == "Dr. Dre") {additionalInfo_1 = "1003";}
	        else if (additionalInfo_1 == "Hannibal Lecter") {additionalInfo_1 = "1004";}
	        else if (additionalInfo_1 == "Dr. Evil") {additionalInfo_1 = "1005";}
        }                	
        
        String result = HCMS.register
        		(
        		this.memberType,
        		String.format("%s, %s", PatientRegistrationTextFieldLastName.getText(), PatientRegistrationTextFieldFirstName.getText()), 
        		PatientRegistrationPasswordFieldPassword.getPassword(), 
        		PatientRegistrationPasswordFieldConfirm.getPassword(), 
        		additionalInfo_1,
                this.registrationComboBoxTwo.getSelectedItem().toString(),
        		PatientRegistrationTextFieldEmail.getText(), 
        		PatientRegistrationTextFieldPhoneNumber.getText()
        		); 
        
   
        if(result.equals("Registration Complete!"))
        {		    
        	closeWindow(this.RegisterMenu);
        	openWindow(this);			
			System.out.format("%s, %s", result, this.HCMS.toString());
        }
        else
        {
        	setLabel(this.PasswordUnsuccessfulLabelMessage,result);        	
        	openDialog(PasswordUnsuccessfulWindow);
        }
	        	   
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
    
    private void jDrLoginMouseClicked(java.awt.event.MouseEvent evt) 
    {
    	setMemberType("Doctor");
    	openDialog(this.LoginDialogBox);    	
    }

    private void SuccessWindowButtonSubmitMouseClicked(java.awt.event.MouseEvent evt) 
    {
        
        LoginSuccessWindow.dispose();
        setVisible(false);
        this.MainUserInterfaceTextPaneHistory.setText(String.format("Welcome!%n%s", this.activeUserDetails));
        this.setupSlider();
        MainUserInterface.setVisible(true);
    }

    private void SuccessWindowButtonSubmit1MouseClicked(java.awt.event.MouseEvent evt) 
    {        
    	closeDialog(this.LoginFailWindow);
        openDialog(this.LoginDialogBox);        
    }

    private void PasswordUnsuccessfulButtonOkayMouseClicked(java.awt.event.MouseEvent evt) 
    {
        closeDialog(PasswordUnsuccessfulWindow);
    }

    private void InitialMenuButtonPatientMouseClicked(java.awt.event.MouseEvent evt) 
    {
    	setMemberType("Patient");
        openDialog(this.LoginDialogBox);
    }

    private void InitialMenuButtonDoctorMouseClicked(java.awt.event.MouseEvent evt) 
    {
        setMemberType("Doctor");
        openDialog(this.LoginDialogBox);
    }

    private void selectDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectDoctorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectDoctorActionPerformed

    private void selectPatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectPatientMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_selectPatientMouseClicked

    private void selectDoctorMouseClicked(java.awt.event.MouseEvent evt) 
    {
    	setMemberType("Doctor");        
    	closeWindow(this.ChooseMember);
        openDialog(this.LoginDialogBox);       
    }

    private void selectPatientActionPerformed(java.awt.event.ActionEvent evt) 
    {
    	setMemberType("Patient");
    	closeWindow(this.ChooseMember);
        openDialog(this.LoginDialogBox);
    }

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
    		comboOneData = new String[]{"Select Doctor", "Walter Bishop", "Henry Jekyll", "Dr. Dre", "Hannibal Lecter", "Dr. Evil"};
    		comboTwoData = new String[]{"Condition1", "Condition2", "Condition3", "Condition 4"}; 
    	}
    	else
    	{  
    		comboOneData = new String[]{"Select Field","Cardiology","Neurology","Oncology","Pediatrics","Geriatics","Critical Care"}; 
    		comboTwoData = new String[100];
    		
            for(int count = 0; count < 100; count++)
                comboTwoData[count]=String.valueOf(count+1);
        } 
    	
    	setupComboBox(this.registrationComboBoxOne, comboOneData);
        setupComboBox(this.registrationComboBoxTwo, comboTwoData);
	}
    
    private void setupComboBox(JComboBox<Object> comboBox, String[] elements)
    {
    	comboBox.removeAllItems();
    	for(int index = 0; index < elements.length; index++)
            comboBox.addItem(elements[index]);    	    	
    }

    private void LoginDialogBoxSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginDialogBoxSubmitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginDialogBoxSubmitActionPerformed

    private void SuccessWindowButtonSubmitActionPerformed(java.awt.event.ActionEvent evt) 
    {
        this.MainUserInterface.setVisible(true);// TODO add your handling code here:
    }

    private void PatientRegistrationComboBoxDoctorAssignedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PatientRegistrationComboBoxDoctorAssignedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PatientRegistrationComboBoxDoctorAssignedActionPerformed

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
    
    private JLabel[] sliderLabels;
    private javax.swing.JLabel MainUserInterfaceLabelFIVE;
    private javax.swing.JLabel MainUserInterfaceLabelFOUR;
    private javax.swing.JLabel MainUserInterfaceLabelONE;
    private javax.swing.JLabel MainUserInterfaceLabelTHREE;
    private javax.swing.JLabel MainUserInterfaceLabelTWO;
    
    private JSlider[] sliders;
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
    private javax.swing.JComboBox<Object> registrationComboBoxOne;
    private javax.swing.JComboBox<Object> registrationComboBoxTwo;
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
    private javax.swing.JLabel greeting;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel register_link;
    private javax.swing.JButton selectDoctor;
    private javax.swing.JButton selectPatient;
    // End of variables declaration//GEN-END:variables
    
    //Variable Declarations
    private Component frame;
    private Component component;
    ArrayList<Object> vals = new ArrayList<Object>();
}

