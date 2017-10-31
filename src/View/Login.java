package View;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import Model.ManagerDB;

public class Login extends javax.swing.JPanel {
	
	   private javax.swing.JButton cancel;
	    private javax.swing.JComboBox jComboBox1;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JSpinner jSpinner1;
	    private javax.swing.JButton login;
	    private javax.swing.JPasswordField password;
	    private javax.swing.JLabel password_label;
	    private javax.swing.JLabel uname;
	    private javax.swing.JTextField uname_text;
	    private javax.swing.JLabel welcome_label;
        private String designation;
        static JFrame frame;
        
    public Login() {
        initComponents();
        addListners();
    }
    
    private void addListners()
    {
    
    	login.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				char[] pass = password.getPassword();
				StringBuilder builder = new StringBuilder(pass.length);
				builder.append(pass);
				String pword = builder.toString();
				
				String username = uname_text.getText().toString();
			
				System.out.println(username.length());
				System.out.println(username);
				
				 jComboBox1.addItemListener(new ItemListener() {
			  			
			  			
			  			public void itemStateChanged(ItemEvent event) {
			  				
			  				if(event.getStateChange() == ItemEvent.SELECTED)
			  				{
			  					designation = String.valueOf(jComboBox1.getSelectedItem());
			  					
			  					
			  				}
			  				
			  			}
			  		});
			  	   
				 pullThePlug();
				if(ManagerDB.validateManager(pword, username, designation))
				{
					JFrame frame = new JFrame("bill");
			    	frame.setVisible(true);
			    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        frame.setSize(500,400);
			        frame.add(new Booking_CustomerDetails("",0));
					
					
				}
				
				 
			}
		});
    	
    	
    	cancel.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				pullThePlug();
			}
		});
    	
    	
    	
    }
    
    public void pullThePlug() {
        
        
        setVisible(false);
        frame.dispose();
        return;
   }

    
    
    
    public static void main(String args[])
    {
    	
    	frame = new JFrame("bill");
    	frame.setVisible(true);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,400);
        frame.add(new Login());
    	
    }
    

     private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        welcome_label = new javax.swing.JLabel();
        uname = new javax.swing.JLabel();
        uname_text = new javax.swing.JTextField();
        password_label = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        login = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();

        welcome_label.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        welcome_label.setText("Welcome to Resort");

        uname.setText("User Name :");

       

        password_label.setText("Password :");

        password.setText("passowrd");

        login.setText("Login");

        cancel.setText("Cancel");

        jLabel1.setText("Manager Type");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Booking Manager", "Restaurant Manager", "Sports & Entertainment Manager", "Resort Manager" }));
       

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(welcome_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(130, 130, 130))
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(uname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(42, 42, 42))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(57, 57, 57))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(password_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(uname_text)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(password))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(welcome_label)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uname)
                    .addComponent(uname_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(password_label)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login)
                    .addComponent(cancel))
                .addGap(31, 31, 31))
        );
    }
  
   
}
