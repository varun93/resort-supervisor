/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * sportsAndEntertainment.java
 *
 * Created on Mar 3, 2014, 3:17:07 PM
 */

package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Controller.SEManager;
import Model.BillDB;
import Model.DBUtil;
import Model.MenuDB;

public class sportsAndEntertainment extends javax.swing.JFrame {

	
	 // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CustomerID_label;
    private javax.swing.JLabel Entertainment_type_label;
    private javax.swing.JLabel No_times_label;
    private javax.swing.JLabel Sports_type_label;
    private javax.swing.JLabel T_amount;
    private javax.swing.JLabel times_used_sports;
    private javax.swing.JLabel T_amount_sports;
    private javax.swing.JLabel Welcome_text;
    
    private javax.swing.JTextField CustomerID_textfield;
    private javax.swing.JTextField Sports_amount;
    private javax.swing.JTextField T_amount_field;
    
    
    private javax.swing.JButton cancel_se;
    private javax.swing.JButton update_se_bill;
    
    
    
    private javax.swing.JComboBox Sports_type;
    private javax.swing.JComboBox Enter_type;
  
    
    private javax.swing.JTabbedPane Sports_panel;
 
   
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel sportsPanel;
    private javax.swing.JPanel entertainmentPanel;
    
    //-----spinners one 
    private javax.swing.JSpinner sports_no_times;
    private javax.swing.JSpinner enter_times_used;
   
   private boolean sportFlag=true,enterFlag=false;
   private static JFrame frame; 
   private int s_times,e_times,s_cost,e_cost;
   private 	String sports_value,enter_value;
    
    public sportsAndEntertainment() {
        initComponents();
        setListeners();
    }

   
    
   private void setListeners()
   {
	  
	   sports_no_times.addChangeListener(new ChangeListener() {
	         public void stateChanged(ChangeEvent e) {
	            
	        	String s =  "" + ((JSpinner)e.getSource()).getValue();
	        	s_times = Integer.parseInt(String.valueOf(s));
	        	
	        	
	        	
	         }
	      });
	   
	   
	   
	   
	   enter_times_used.addChangeListener(new ChangeListener() {
	         public void stateChanged(ChangeEvent e) {
	            
	        	String s =  "" + ((JSpinner)e.getSource()).getValue();
	        	e_times = Integer.parseInt(String.valueOf(s));
	        	            
	         }
	      });
	   
	   
	   Sports_type.addItemListener(new ItemListener() {
		
		
		public void itemStateChanged(ItemEvent event) {
			
			if(event.getStateChange() == ItemEvent.SELECTED)
			{
				
			    sports_value = String.valueOf(Sports_type.getSelectedItem());
				s_cost = MenuDB.getSportsCost(sports_value);
				
			}
			
		}
	});
	   
	   
	   
	   Enter_type.addItemListener(new ItemListener() {
			
			
			public void itemStateChanged(ItemEvent event) {
				
				if(event.getStateChange() == ItemEvent.SELECTED)
				{
					
					enter_value = String.valueOf(Enter_type.getSelectedItem());
					
				}
				
			}
		});
	   
	   update_se_bill.addActionListener(new ActionListener() {
		
		
		public void actionPerformed(ActionEvent e) 
		{
			
	    String customerID = CustomerID_textfield.getText();
		int secost = MenuDB.getEntertainmentCost(enter_value)*e_times + MenuDB.getSportsCost(sports_value)*s_times;
		new SEManager().calculateFacilityBill(secost, customerID);
		
		}
	});
	   
   }
    
   public void pullThePlug(JFrame frame) {
       
	   frame.setVisible(false);
       frame.dispose();
       return;
  }
   
   
   public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sportsAndEntertainment().setVisible(true);
            }
        });
    }

    
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Sports_panel = new javax.swing.JTabbedPane();
        sportsPanel = new javax.swing.JPanel();
        Sports_type_label = new javax.swing.JLabel();
        Sports_type = new javax.swing.JComboBox(new String[] { "Pool", "Cards", "Archery", "Swimming" });
        times_used_sports = new javax.swing.JLabel();
        sports_no_times = new javax.swing.JSpinner();
        T_amount_sports = new javax.swing.JLabel();
        Sports_amount = new javax.swing.JTextField();
        entertainmentPanel = new javax.swing.JPanel();
        Entertainment_type_label = new javax.swing.JLabel();
        Enter_type = new javax.swing.JComboBox();
        No_times_label = new javax.swing.JLabel();
        enter_times_used = new javax.swing.JSpinner();
        T_amount = new javax.swing.JLabel();
        T_amount_field = new javax.swing.JTextField();
        Welcome_text = new javax.swing.JLabel();
        CustomerID_label = new javax.swing.JLabel();
        CustomerID_textfield = new javax.swing.JTextField();
        update_se_bill = new javax.swing.JButton();
        cancel_se = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Sports_type_label.setText("Sports Type :");
        Sports_type_label.setFocusable(false);
        Sports_type.setMaximumRowCount(4);
        
       
        times_used_sports.setText("Number of Times Used :");

        sports_no_times.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));

        T_amount_sports.setText("Total Amount :");

        Sports_amount.setEnabled(false);
        
     
         
        
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(sportsPanel);
        sportsPanel.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(times_used_sports, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(Sports_type_label, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(T_amount_sports, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Sports_amount, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(Sports_type, 0, 137, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(sports_no_times, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                        .addGap(72, 72, 72)))
                .addGap(220, 220, 220))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Sports_type, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sports_type_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sports_no_times, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(times_used_sports))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(T_amount_sports)
                    .addComponent(Sports_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        Sports_panel.addTab("Sports", sportsPanel);

        Entertainment_type_label.setText("Entertainment Type :");

        Enter_type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Movies", "Party", "Disco", "Cultural Event" }));

        No_times_label.setText("Number of Times Used :");

        enter_times_used.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));

        T_amount.setText("Total Amount :");

        T_amount_field.setEnabled(false);

        Sports_type.setSelectedIndex(0);
        Enter_type.setSelectedIndex(0);
        
        sports_value = (String) Sports_type.getSelectedItem();
        enter_value = (String) Enter_type.getSelectedItem();
        
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(entertainmentPanel);
        entertainmentPanel.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(No_times_label)
                    .addComponent(Entertainment_type_label, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                    .addComponent(T_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(enter_times_used, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Enter_type, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(T_amount_field))
                        .addGap(172, 172, 172))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Enter_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Entertainment_type_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enter_times_used, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(No_times_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(T_amount_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T_amount))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        Sports_panel.addTab("Entertainment", entertainmentPanel);

        Welcome_text.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Welcome_text.setText("Welcome to Sports And Entertainment");

        CustomerID_label.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CustomerID_label.setText("Customer ID :");

        update_se_bill.setText("Update Bill");

        cancel_se.setText("Cancel");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Sports_panel)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CustomerID_label, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CustomerID_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Welcome_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(74, 74, 74))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(update_se_bill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(cancel_se, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(54, 54, 54))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Welcome_text)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CustomerID_label)
                    .addComponent(CustomerID_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(Sports_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel_se)
                    .addComponent(update_se_bill))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

   
    

}
