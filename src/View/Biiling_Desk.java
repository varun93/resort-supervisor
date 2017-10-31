package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Controller.BookingManager;
import Model.BillDB;
import Model.CustomerDB;
import Model.MenuDB;



public class Biiling_Desk extends javax.swing.JPanel {
	
	    private javax.swing.JButton cancel;
	    private javax.swing.JTextField customerID;
	    private javax.swing.JLabel customer_id;
	    private javax.swing.JButton checkout;
	    private javax.swing.JLabel welcome;

    public Biiling_Desk() {
        initComponents();
        addListeners();
    }
  
    
    private boolean isLeapYear(int year)
    {
    	if(year%4==0)
    	{
    		if(year%100==0)
    		{
    		return false;	
    		}
    		else
    		{
    			return true;
    		}
    	}
    	return false;
    }
    
        
    
    private int difference(String checkin,String checkout)
    {
    	 
    	int diff=0;
    	if(Integer.parseInt(checkout.substring(4, 6)) == Integer.parseInt(checkin.substring(4, 6)) )
    	diff = Integer.parseInt(checkout.substring(6)) -  Integer.parseInt(checkin.substring(6));
    	else
    	{
    		switch(Integer.parseInt(checkout.substring(4, 6)))
    		{
    		case 1 :diff = Integer.parseInt(checkout.substring(6)) + (31- Integer.parseInt(checkin.substring(6)));
    		break;
    		case 2:if(isLeapYear(Integer.parseInt(checkout.substring(0,4))))
    		{
    			diff = Integer.parseInt(checkout.substring(6)) + (29- Integer.parseInt(checkin.substring(6)));
    		}
    		else
    		{
    			diff = Integer.parseInt(checkout.substring(6)) + (28- Integer.parseInt(checkin.substring(6)));	
    		}
    		break;
    		case 3 :diff = Integer.parseInt(checkout.substring(6)) + (31 - Integer.parseInt(checkin.substring(6)));
    		break;
    		case 4:diff = Integer.parseInt(checkout.substring(6)) + (30- Integer.parseInt(checkin.substring(6)));
    		break;
    		case 5 :diff = Integer.parseInt(checkout.substring(6)) + (31- Integer.parseInt(checkin.substring(6)));
    		break;
    		case 6:diff = Integer.parseInt(checkout.substring(6)) + (30- Integer.parseInt(checkin.substring(6)));
    		break;
    		case 7 :diff = Integer.parseInt(checkout.substring(6)) + (31- Integer.parseInt(checkin.substring(6)));
    		break;
    		case 8:diff = Integer.parseInt(checkout.substring(6)) + (31- Integer.parseInt(checkin.substring(6)));
    		break;
    		case 9 :diff = Integer.parseInt(checkout.substring(6)) + (30- Integer.parseInt(checkin.substring(6)));
    		break;
    		case 10:diff = Integer.parseInt(checkout.substring(6)) + (31- Integer.parseInt(checkin.substring(6)));
    		break;
    		case 11:diff = Integer.parseInt(checkout.substring(6)) + (30- Integer.parseInt(checkin.substring(6)));
    		break;
    		case 12:diff = Integer.parseInt(checkout.substring(6)) + (31- Integer.parseInt(checkin.substring(6)));
    		break;
    		
    			
    		
    		}
    		
    	}
    	return diff;
    }
          
    
   private void addListeners()
    {
    	
     checkout.addActionListener(new ActionListener() {
		
    	 public void actionPerformed(ActionEvent e) {
			
    		 BookingManager manager = new BookingManager();
    	 	manager.calculateFacilityBill(customerID.getText());
    	 	//manager.checkOutCustomer(customerID.getText());
    		 
		}
	});
 
   }
    
     public static void main(String args[])
    {
    	 
    	JFrame frame = new JFrame("Billing Center");
    	frame.setVisible(true);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(500,400);
    	frame.add(new Biiling_Desk());
    	
    }
    
    private void initComponents() {

        welcome = new javax.swing.JLabel();
        customer_id = new javax.swing.JLabel();
        customerID = new javax.swing.JTextField();
        checkout = new javax.swing.JButton();
        cancel = new javax.swing.JButton();

        welcome.setFont(new java.awt.Font("Times New Roman", 1, 14));
        welcome.setText("Welcome to Billing Desk");

        customer_id.setText("Customer ID :");

        checkout.setText("Checkout");

        cancel.setText("Cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(welcome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(119, 119, 119))
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(customer_id)
                .addGap(31, 31, 31)
                .addComponent(customerID, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
            .addGroup(layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(checkout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addComponent(cancel)
                .addGap(53, 53, 53))
        );
        
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcome)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customer_id)
                    .addComponent(customerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkout)
                    .addComponent(cancel))
                .addGap(30, 30, 30))
        );
        
    }
  
    
}
