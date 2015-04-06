package gui;


import java.awt.Component;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import edu.asu.se.group5.business.HealthCareManagementSystem;
import java.util.ArrayList;
import javax.swing.WindowConstants;

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
        PatientLoginLabelUsername = new java.awt.Label();
        PatientLoginBoxTextFieldUsername = new javax.swing.JTextField();
        PatientLoginLabelPassword = new java.awt.Label();
        PatientLoginTextFieldPassword = new javax.swing.JPasswordField();
        LoginDialogBoxSubmit = new javax.swing.JButton();
        PatientLoginLabelMemberType = new java.awt.Label();
        PatientLoginComboBoxMemberType = new javax.swing.JComboBox();
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
        PatientRegistrationComboBoxDoctorAssigned = new javax.swing.JComboBox();
        PatientRegistrationLabelUnderlyingCondition = new javax.swing.JLabel();
        PatientRegistrationComboBoxUnderlyingCondition = new javax.swing.JComboBox();
        PatientRegistrationLabelConfirmPassword = new javax.swing.JLabel();
        PatientRegistrationLabelLastName = new javax.swing.JLabel();
        PatientRegistrationTextFieldLastName = new javax.swing.JTextField();
        PatientRegistrationPasswordFieldPassword = new javax.swing.JPasswordField();
        PatientRegistrationPasswordFieldConfirm = new javax.swing.JPasswordField();
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
        LoginSuccessWindow = new javax.swing.JDialog();
        SuccessWindowLabelSuccess = new javax.swing.JLabel();
        SuccessWindowButtonSubmit = new javax.swing.JButton();
        LoginFailWindow = new javax.swing.JDialog();
        SuccessWindowLabelSuccess1 = new javax.swing.JLabel();
        SuccessWindowButtonSubmit1 = new javax.swing.JButton();
        PasswordUnsuccessfulWindow = new javax.swing.JDialog();
        PasswordUnsuccessfulLabelMessage = new javax.swing.JLabel();
        PasswordUnsuccessfulButtonOkay = new javax.swing.JButton();
        jPatientLogin = new javax.swing.JButton();
        jDrLogin = new javax.swing.JButton();
        jRegisterPatient = new javax.swing.JButton();

        LoginDialogBox.setAlwaysOnTop(true);
        LoginDialogBox.setBounds(new java.awt.Rectangle(0, 22, 330, 183));
        LoginDialogBox.setName(""); // NOI18N
        LoginDialogBox.setPreferredSize(new java.awt.Dimension(330, 183));
        LoginDialogBox.setResizable(false);

        PatientLoginLabelUsername.setText("Email:");

        PatientLoginBoxTextFieldUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PatientLoginBoxTextFieldUsernameActionPerformed(evt);
            }
        });

        PatientLoginLabelPassword.setName(""); // NOI18N
        PatientLoginLabelPassword.setText("Password:");

        PatientLoginTextFieldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PatientLoginTextFieldPasswordActionPerformed(evt);
            }
        });

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

        //PatientLoginLabelMemberType.setText("Member Type:");

        //PatientLoginComboBoxMemberType.setEditable(true);
        //PatientLoginComboBoxMemberType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Patient", "Doctor" }));

        javax.swing.GroupLayout LoginDialogBoxLayout = new javax.swing.GroupLayout(LoginDialogBox.getContentPane());
        LoginDialogBox.getContentPane().setLayout(LoginDialogBoxLayout);
        LoginDialogBoxLayout.setHorizontalGroup(
            LoginDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginDialogBoxLayout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addGroup(LoginDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   
            		// .addComponent(PatientLoginComboBoxMemberType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    
            		.addGroup(LoginDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(LoginDialogBoxLayout.createSequentialGroup()
                            
                    		//.addComponent(PatientLoginLabelMemberType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            
                    		.addGap(141, 141, 141))
                        .addGroup(LoginDialogBoxLayout.createSequentialGroup()
                            .addGroup(LoginDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(PatientLoginLabelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(PatientLoginLabelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(PatientLoginTextFieldPassword)
                                .addComponent(PatientLoginBoxTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LoginDialogBoxSubmit)
                            .addGap(21, 21, 21)))))
        );
        
        
        LoginDialogBoxLayout.setVerticalGroup(
            LoginDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginDialogBoxLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                
                //.addComponent(PatientLoginLabelMemberType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                //.addGap(1, 1, 1)
                //.addComponent(PatientLoginComboBoxMemberType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                //.addGap(1, 1, 1)
                
                
                .addComponent(PatientLoginLabelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(PatientLoginBoxTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(PatientLoginLabelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(LoginDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PatientLoginTextFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LoginDialogBoxSubmit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PatientLoginLabelUsername.getAccessibleContext().setAccessibleName("");

        RegisterMenu.setBounds(new java.awt.Rectangle(0, 22, 300, 450));
        RegisterMenu.setPreferredSize(new java.awt.Dimension(300, 450));
        RegisterMenu.setResizable(false);

        NewPatientRegistrationLabel.setText("New Patient Registration");

        PatientRegistrationLabelFirstName.setText("First Name");

        PatientRegistrationLabelPassword.setText("Password:");

        PatientRegistrationLabelPhoneNumber.setText("Phone Number:");

        PatientRegistrationLabelEmail.setText("Email:");

        PatientRegistrationLabelDoctorAssigned.setText("Doctor Assigned:");

        PatientRegistrationTextFieldFirstName.setSize(new java.awt.Dimension(105, 28));

        PatientRegistrationTextFieldPhoneNumber.setSize(new java.awt.Dimension(105, 28));

        PatientRegistrationTextFieldEmail.setSize(new java.awt.Dimension(105, 28));

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

        PatientRegistrationComboBoxDoctorAssigned.setEditable(true);
        PatientRegistrationComboBoxDoctorAssigned.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Walter Bishop", "Henry Jekyll", "Dr. Dre", "Hannibal Lecter", "Dr. Evil" }));
        PatientRegistrationComboBoxDoctorAssigned.setPreferredSize(new java.awt.Dimension(112, 28));
        PatientRegistrationComboBoxDoctorAssigned.setSize(new java.awt.Dimension(98, 28));

        PatientRegistrationLabelUnderlyingCondition.setText("Underlying Condition:");

        PatientRegistrationComboBoxUnderlyingCondition.setEditable(true);
        PatientRegistrationComboBoxUnderlyingCondition.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Condition1", "Condition2", "Condition3", "Condition 4" }));
        PatientRegistrationComboBoxUnderlyingCondition.setPreferredSize(new java.awt.Dimension(112, 28));
        PatientRegistrationComboBoxUnderlyingCondition.setSize(new java.awt.Dimension(98, 28));

        PatientRegistrationLabelConfirmPassword.setText("Confirm Password:");

        PatientRegistrationLabelLastName.setText("Last Name");

        PatientRegistrationPasswordFieldPassword.setPreferredSize(new java.awt.Dimension(105, 28));
        PatientRegistrationPasswordFieldPassword.setSize(new java.awt.Dimension(105, 28));

        PatientRegistrationPasswordFieldConfirm.setPreferredSize(new java.awt.Dimension(105, 28));
        PatientRegistrationPasswordFieldConfirm.setSize(new java.awt.Dimension(105, 28));

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
                    .addComponent(PatientRegistrationComboBoxDoctorAssigned, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addGroup(RegisterMenuLayout.createSequentialGroup()
                                .addComponent(PatientRegistrationLabelConfirmPassword)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(RegisterMenuLayout.createSequentialGroup()
                                .addGroup(RegisterMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(RegisterMenuLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(PatientRegistrationLabelUnderlyingCondition))
                                    .addComponent(PatientRegistrationComboBoxUnderlyingCondition, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(RegisterMenuLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(PatientRegistrationLabelEmail))
                                    .addComponent(PatientRegistrationTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PatientRegistrationLabelLastName)
                                    .addComponent(PatientRegistrationTextFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PatientRegistrationPasswordFieldConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                        .addComponent(PatientRegistrationComboBoxDoctorAssigned, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RegisterMenuLayout.createSequentialGroup()
                        .addComponent(PatientRegistrationLabelUnderlyingCondition)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PatientRegistrationComboBoxUnderlyingCondition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(PatientRegistrationButtonSubmit)
                .addGap(28, 28, 28))
        );

        MainUserInterface.setBounds(new java.awt.Rectangle(0, 22, 406, 585));
        MainUserInterface.setPreferredSize(new java.awt.Dimension(406, 585));
        MainUserInterface.setResizable(false);

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

        MainUserInterfaceLabelONE.setText("LabelONE");

        MainUserInterfaceLabelTWO.setText("LabelTWO");

        MainUserInterfaceLabelTHREE.setText("LabelTHREE");

        MainUserInterfaceLabelFOUR.setText("LabelFOUR");

        MainUserInterfaceLabelFIVE.setText("LabelFIVE");

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("InitialMenu"); // NOI18N
        setResizable(false);

        jPatientLogin.setText("Patient Login");
        jPatientLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPatientLoginMouseClicked(evt);
            }
        });
        jPatientLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPatientLoginActionPerformed(evt);
            }
        });

        jDrLogin.setText("Dr. Login");
        
        jDrLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDrLoginMouseClicked(evt);
            }
        });
        
        jDrLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDrLoginActionPerformed(evt);
            }
        });

        jRegisterPatient.setText("Register Patient");
        jRegisterPatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRegisterPatientMouseClicked(evt);
            }
        });
        jRegisterPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRegisterPatientActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPatientLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRegisterPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDrLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jPatientLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRegisterPatient)
                .addGap(12, 12, 12)
                .addComponent(jDrLogin)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }
    
    
    
    
    // </editor-fold>//GEN-END:initComponents

    private void PatientLoginTextFieldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PatientLoginTextFieldPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PatientLoginTextFieldPasswordActionPerformed

    private void PatientLoginBoxTextFieldUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PatientLoginBoxTextFieldUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PatientLoginBoxTextFieldUsernameActionPerformed

    private void LoginDialogBoxSubmitMouseClicked(java.awt.event.MouseEvent evt) 
    {//GEN-FIRST:event_LoginDialogBoxSubmitMouseClicked
        // TODO add your handling code here:
        String email = PatientLoginBoxTextFieldUsername.getText();
        char[] password = PatientLoginTextFieldPassword.getPassword();
        //String memberType = PatientLoginComboBoxMemberType.getSelectedItem().toString();
        String loginRequest = HCMS.login(this.memberType, email, password);
        
        if(loginRequest.equals("Logged In."))
        {	
        	SuccessWindowLabelSuccess.setText(loginRequest);
	        LoginDialogBox.dispose();
	        LoginSuccessWindow.setVisible(true);
        }
        else
        {
        	SuccessWindowLabelSuccess1.setText(loginRequest);
            LoginDialogBox.dispose();
            LoginFailWindow.setVisible(true);                        
        } 
   
    }//GEN-LAST:event_LoginDialogBoxSubmitMouseClicked

    
    private void LoginDialogBoxSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginDialogBoxSubmitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginDialogBoxSubmitActionPerformed

    private void PatientRegistrationButtonSubmitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PatientRegistrationButtonSubmitMouseClicked
        //Initialize Variables
        String doctorAssigned = PatientRegistrationComboBoxDoctorAssigned.getSelectedItem().toString();
        
        if(doctorAssigned == "Walter Bishop") {doctorAssigned = "1001";}
        else if (doctorAssigned == "Henry Jekyll") {doctorAssigned = "1002";}
        else if (doctorAssigned == "Dr. Dre") {doctorAssigned = "1003";}
        else if (doctorAssigned == "Hannibal Lecter") {doctorAssigned = "1004";}
        else if (doctorAssigned == "Dr. Evil") {doctorAssigned = "1005";}
        
        String result = HCMS.registerPatient
        		(
        		String.format("%s, %s", PatientRegistrationTextFieldLastName.getText(), PatientRegistrationTextFieldFirstName.getText()), 
        		PatientRegistrationPasswordFieldPassword.getPassword(), 
        		PatientRegistrationPasswordFieldConfirm.getPassword(), 
        		doctorAssigned, 
        		PatientRegistrationTextFieldEmail.getText(), 
        		PatientRegistrationTextFieldPhoneNumber.getText()
        		); 
        
   
        if(result.equals("Registration Complete!"))
        {
		    RegisterMenu.dispose();
			RegisterMenu.setVisible(false);          
			setVisible(true);	
        }
        else
        {
        	PasswordUnsuccessfulLabelMessage.setText(result);
        	PasswordUnsuccessfulWindow.setVisible(true); 
        }
	        	   
    }//GEN-LAST:event_PatientRegistrationButtonSubmitMouseClicked

    private void PatientRegistrationButtonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PatientRegistrationButtonSubmitActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_PatientRegistrationButtonSubmitActionPerformed

    private void jRegisterPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRegisterPatientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRegisterPatientActionPerformed

    private void jRegisterPatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRegisterPatientMouseClicked
        // TODO add your handling code here:
        hide();
        RegisterMenu.show();
    }//GEN-LAST:event_jRegisterPatientMouseClicked

    private void jDrLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDrLoginActionPerformed
        // TODO add your handling code here:
    	//this.memberType = "Doctor";
    }//GEN-LAST:event_jDrLoginActionPerformed

    private void jPatientLoginActionPerformed(java.awt.event.ActionEvent evt) 
    {//GEN-FIRST:event_jPatientLoginActionPerformed
        
    }//GEN-LAST:event_jPatientLoginActionPerformed

    private void jPatientLoginMouseClicked(java.awt.event.MouseEvent evt) 
    {//GEN-FIRST:event_jPatientLoginMouseClicked
        // TODO add your handling code here:
    	this.memberType = "Patient";
        LoginDialogBox.setVisible(true);
    }//GEN-LAST:event_jPatientLoginMouseClicked
    
    private void jDrLoginMouseClicked(java.awt.event.MouseEvent evt) 
    {//GEN-FIRST:event_jPatientLoginMouseClicked
        // TODO add your handling code here:
    	this.memberType = "Doctor";
        LoginDialogBox.setVisible(true);
    }//GEN-LAST:event_jPatientLoginMouseClicked

    private void SuccessWindowButtonSubmitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SuccessWindowButtonSubmitMouseClicked
        // TODO add your handling code here:
        LoginSuccessWindow.dispose();
        setVisible(false);
        MainUserInterface.setVisible(true);
    }//GEN-LAST:event_SuccessWindowButtonSubmitMouseClicked

    private void SuccessWindowButtonSubmit1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SuccessWindowButtonSubmit1MouseClicked
        // TODO add your handling code here:
        LoginFailWindow.dispose();
        LoginDialogBox.setVisible(true);
    }//GEN-LAST:event_SuccessWindowButtonSubmit1MouseClicked

    private void PasswordUnsuccessfulButtonOkayMouseClicked(java.awt.event.MouseEvent evt) 
    {//GEN-FIRST:event_PasswordUnsuccessfulButtonOkayMouseClicked
        // TODO add your handling code here:
        PasswordUnsuccessfulWindow.dispose();
        

    }//GEN-LAST:event_PasswordUnsuccessfulButtonOkayMouseClicked

    
    
    
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(InitialMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(InitialMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(InitialMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(InitialMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new InitialMenu().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog LoginDialogBox;
    private javax.swing.JButton LoginDialogBoxSubmit;
    private javax.swing.JDialog LoginFailWindow;
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
    private javax.swing.JTextField PatientLoginBoxTextFieldUsername;
    private javax.swing.JComboBox PatientLoginComboBoxMemberType;
    private java.awt.Label PatientLoginLabelMemberType;
    private java.awt.Label PatientLoginLabelPassword;
    private java.awt.Label PatientLoginLabelUsername;
    private javax.swing.JPasswordField PatientLoginTextFieldPassword;
    private static javax.swing.JButton PatientRegistrationButtonSubmit;
    private javax.swing.JComboBox PatientRegistrationComboBoxDoctorAssigned;
    private javax.swing.JComboBox PatientRegistrationComboBoxUnderlyingCondition;
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
    private javax.swing.JButton jDrLogin;
    private javax.swing.JButton jPatientLogin;
    private javax.swing.JButton jRegisterPatient;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
    
    //Variable Declarations
    private Component frame;
    private Component component;
    ArrayList<Object> vals = new ArrayList<Object>();
}

