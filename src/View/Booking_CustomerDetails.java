package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Controller.BookingManager;
import Model.Customer;
import Model.CustomerDB;
import Model.MenuDB;
import ProjectUtils.ValidateInput;


public class Booking_CustomerDetails extends javax.swing.JPanel{
	
	
    private javax.swing.JLabel Address_Label;
    private javax.swing.JTextField adress;
    private javax.swing.JTextField Address_TextField2;
    private javax.swing.JLabel City_Label;
    private javax.swing.JTextField city;
    private javax.swing.JButton confirm;
    private javax.swing.JLabel F_Name_Label;
    private javax.swing.JTextField firstName;
    private javax.swing.JLabel L_Name_Label;
    private javax.swing.JTextField lastName;
    private javax.swing.JLabel M_name_Label;
    private javax.swing.JTextField middleName;
    private javax.swing.JTextField phoneNumber;
    private javax.swing.JLabel Ph_no_Label;
    private javax.swing.JLabel State_Label;
    private javax.swing.JComboBox State_list;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private String state,roomType;
    private int number;
    private final java.lang.String AB = "0123456789abcdefghijklmnopqrstuvwxyz";
	java.util.Random random = new java.util.Random();
    private static JFrame frame;
	
	
    String states[] = new String[] { "Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chhattisgarh","Goa","Gujarat","Haryana","Himachal Pradesh","Jammu and Kashmir","Jharkhand","Karnataka","Kerala","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram",
            "Nagaland","Orissa","Punjab","Rajasthan","Sikkim","Tamil Nadu","Tripura","Uttar Pradesh","Uttarakhand","West Bengal" };
   
 
    
 
    public Booking_CustomerDetails(String roomType,int number) {
        initComponents();
        addListeners();
        this.roomType = roomType;
        this.number = number;
    }

     private static int atoi(String str)
     {
    	 
    	 int number=0;
    	 str = str.trim();
    	 for(int i=0;i<str.length();i++)
    	 {
    		 
    		 int remainder = str.charAt(i)-48;
    		 number = number*10 + remainder;
    	 }
    	 
    	 return number;
     }
  
     

  private void addListeners()
  {
	  State_list.addItemListener(new ItemListener() {
			
			
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED)
				{
				
					state = String.valueOf(State_list.getSelectedItem());
					System.out.print(state);
				}
				
			}
		});
	  
	  
	  confirm.addActionListener(new ActionListener() {
		  
		  public void actionPerformed(ActionEvent e) {
				
				               
		        
			    String fname = firstName.getText();
				String mname = middleName.getText();
				String lname = lastName.getText();
				String str = phoneNumber.getText();
				Integer cnumber = atoi(phoneNumber.getText());
			    String adr =  adress.getText();
			    String cty = city.getText();
			    String id = generateRandom();
			   
			    
			    if(ValidateInput.validateFirstName(fname))
			    {
			    	
			    	 if(ValidateInput.validateMiddleName(mname))
			    	 {
			    		 
			    		 if(ValidateInput.validateLastName(lname))
			    		 {
			    			
			    			 if(ValidateInput.validateCity(cty))
			    			 {
			    				 
			    				 if(ValidateInput.validateAddress(adr))
			    				 {
			    					 
			    					 if(ValidateInput.validatephoneNumber(phoneNumber.getText()))
			    					 {
			    						 
			    					 }
			    					 else
			    					 {
			    						 JOptionPane.showMessageDialog(null, "Please enter a phone number"); 
			    					 }
			    					 
			    				 }
			    				 else
			    				 {
			    					 JOptionPane.showMessageDialog(null, "Please enter a valid adress");
			    				 }
			    				 
			    			 }
			    			 else
			    			 {
			    				 JOptionPane.showMessageDialog(null, "Please enter a valid city");
			    			 }
			    			 
			    		 }
			    		 else
			    		 {
			    			 JOptionPane.showMessageDialog(null, "Please enter a valid last name"); 
			    		 }
			    		 
			    	 }
			    	 else
			    	 {
			    		 JOptionPane.showMessageDialog(null, "Please enter a valid middle name");
			    	 }
			    }
			    else
			    {
			    	JOptionPane.showMessageDialog(null, "Please enter a valid first name");	
			    }
			    
			    BookingManager bm = new BookingManager();
			    bm.addCustomer(id,fname, mname, lname, state, cty, adr, cnumber);
		        bm.allotRoom(id,roomType,number);
				
			    //check out the contructor call
			    
			}
		
		});
	  
  }
  

    

    private String getStringFormat(CharSequence sq)
    {
    	StringBuilder sb = new StringBuilder(sq.length());
    	sb.append(sq);
    	return sb.toString().trim();
    }
   
      
    
    public static void main(String args[])
    {
    
    	
        frame = new JFrame("bill");
    	frame.setVisible(true);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(500,400);
    	frame.add(new Booking_CustomerDetails("",0));
    	
   }
    
 public void pullThePlug(JFrame frame) {
        
        
        frame.setVisible(false);
        frame.dispose();
        return;
   }

private String generateRandom()
{
	
	StringBuilder sb = new StringBuilder(20);
	for(int i=0;i<10;i++)
	{
		sb.append(AB.charAt(random.nextInt(AB.length()-1)));
	}
		
	return sb.toString();
}
    
    
	
	
	
	
	  private void initComponents() {
	    	
	        jScrollPane1 = new javax.swing.JScrollPane();
	        jTextArea1 = new javax.swing.JTextArea();
	        jLabel1 = new javax.swing.JLabel();
	        F_Name_Label = new javax.swing.JLabel();
	        firstName  = new javax.swing.JTextField();
	        L_Name_Label = new javax.swing.JLabel();
	        lastName = new javax.swing.JTextField();
	        Address_Label = new javax.swing.JLabel();
	        adress = new javax.swing.JTextField();
	        M_name_Label = new javax.swing.JLabel();
	        middleName  = new javax.swing.JTextField();
	        Address_TextField2 = new javax.swing.JTextField();
	        City_Label = new javax.swing.JLabel();
	        city = new javax.swing.JTextField();
	        State_Label = new javax.swing.JLabel();
	        State_list = new javax.swing.JComboBox(states);
	        Ph_no_Label = new javax.swing.JLabel();
	        phoneNumber = new javax.swing.JTextField();
	        confirm = new javax.swing.JButton();
	        cancel = new javax.swing.JButton();

	        jTextArea1.setColumns(20);
	        jTextArea1.setRows(5);
	        jScrollPane1.setViewportView(jTextArea1);

	        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
	        jLabel1.setText("Customer Details ");

	        F_Name_Label.setText("First Name :");

	        L_Name_Label.setText("Last Name :");

	        Address_Label.setText("Address :");

	        M_name_Label.setText("Middle Name :");

	        City_Label.setText("City :");

	        State_Label.setText("State :");

	        State_list.setMaximumRowCount(states.length);
	        
	  Ph_no_Label.setText("Phone Number :");

	 confirm.setText("Confirm");
	   
	 cancel.setText("Cancel");

	    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
	    this.setLayout(layout);
	    layout.setHorizontalGroup(
	        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	        .addGroup(layout.createSequentialGroup()
	            .addGap(27, 27, 27)
	            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                .addGroup(layout.createSequentialGroup()
	                    .addComponent(Ph_no_Label)
	                    .addGap(0, 0, Short.MAX_VALUE))
	                .addGroup(layout.createSequentialGroup()
	                    .addComponent(F_Name_Label)
	                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                    .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addGap(12, 12, 12)
	                    .addComponent(M_name_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                    .addComponent(middleName, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addGap(14, 14, 14)
	                    .addComponent(L_Name_Label)
	                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                    .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addGap(21, 21, 21))
	                .addGroup(layout.createSequentialGroup()
	                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                        .addComponent(jLabel1)
	                        .addGroup(layout.createSequentialGroup()
	                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                .addComponent(Address_Label)
	                                .addComponent(City_Label)
	                                .addComponent(State_Label))
	                            .addGap(51, 51, 51)
	                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                .addComponent(Address_TextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addComponent(adress, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
	                                    .addComponent(phoneNumber, javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addComponent(city, javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addComponent(State_list, javax.swing.GroupLayout.Alignment.LEADING, 0, 189, Short.MAX_VALUE)))))
	                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
	        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	            .addGap(378, 378, 378)
	            .addComponent(confirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	            .addGap(18, 18, 18)
	            .addComponent(cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	            .addGap(50, 50, 50))
	    );
	    layout.setVerticalGroup(
	        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	        .addGroup(layout.createSequentialGroup()
	            .addGap(41, 41, 41)
	            .addComponent(jLabel1)
	            .addGap(18, 18, 18)
	            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                .addComponent(F_Name_Label)
	                .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addComponent(L_Name_Label)
	                .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addComponent(M_name_Label)
	                .addComponent(middleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	            .addGap(18, 18, 18)
	            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                .addComponent(Address_Label)
	                .addComponent(adress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	            .addGap(18, 18, 18)
	            .addComponent(Address_TextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	            .addGap(24, 24, 24)
	            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                .addComponent(City_Label)
	                .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	            .addGap(27, 27, 27)
	            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                .addComponent(State_Label)
	                .addComponent(State_list, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	            .addGap(23, 23, 23)
	            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                .addComponent(Ph_no_Label)
	                .addComponent(phoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
	            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                .addComponent(confirm)
	                .addComponent(cancel))
	            .addGap(37, 37, 37))
	    );
	    }// </editor-fold>//GEN-END:initComponents

	

}
