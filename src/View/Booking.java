
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Controller.BookingManager;
import Model.DBUtil;
import Model.MenuDB;


public class Booking extends javax.swing.JPanel {

	    
	    private javax.swing.JLabel Room_details_label;
	    private javax.swing.JLabel Room_type;
	    
	    private javax.swing.JButton Availabilty;
	    private javax.swing.JButton allot;
	    private javax.swing.JButton cancel;
	    
	    private javax.swing.JLabel no_occupants_label;
	    private javax.swing.JLabel room_requred;
	    
	    private javax.swing.JSpinner no_rooms;
	    private javax.swing.JSpinner occupants;
	   
	    
	    private javax.swing.JComboBox room_type_list;
	    private Integer number=0;
	    private boolean flag;
	    private String value;
	    private static JFrame frame; 
	    
    public Booking() {
    	
        initComponents();
        addListeners();
    }

    private void addListeners()
    {
    	Availabilty.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent e) {
				
				if(new BookingManager().checkAvailability(number, value))
				{
				
				flag = true;
				JOptionPane.showMessageDialog(null, "Rooms are available");
				allot.setEnabled(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Rooms are not available");
					allot.setEnabled(false);
				}
				
			}
		});
    	
    	allot.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(flag)
				{
				pullThePlug(frame);
				frame = new JFrame("bill");
		    	frame.setVisible(true);
		    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    	frame.setSize(500,400);
		    	frame.add(new Booking_CustomerDetails(value,number));
				}
			}
		});
    	
    	cancel.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
    	
    	no_rooms.addChangeListener(new ChangeListener() {
	         public void stateChanged(ChangeEvent e) {
	            
	        	String s =  "" + ((JSpinner)e.getSource()).getValue();
	        	number = Integer.parseInt(String.valueOf(s));
	        	
	        	
	        	           
	         }
	      });
    	 
    	 
    	
	   room_type_list.addItemListener(new ItemListener() {
		
		
		public void itemStateChanged(ItemEvent event) {
			
			if(event.getStateChange() == ItemEvent.SELECTED)
			{
				value = String.valueOf(room_type_list.getSelectedItem());
				
			}
			
		}
	});
    	
    }
    
    
    public void pullThePlug(JFrame frame) {
        
 	   frame.setVisible(false);
        frame.dispose();
        return;
   }
    
    public static void main(String args[])
    {
    	
    	frame = new JFrame("bill");
    	frame.setVisible(true);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(500,400);
    	frame.add(new Booking());
    	
    }
    
    
    private void initComponents() {

        Room_details_label = new javax.swing.JLabel();
        room_requred = new javax.swing.JLabel();
        no_rooms = new javax.swing.JSpinner();
        no_occupants_label = new javax.swing.JLabel();
        occupants = new javax.swing.JSpinner();
        Room_type = new javax.swing.JLabel();
        room_type_list = new javax.swing.JComboBox(new String[] {"SINGLE BED AC", "SINGLE BED NON AC", "REGULAR AC","REGULAR NON AC" });
        Availabilty = new javax.swing.JButton();
        allot = new javax.swing.JButton();
        cancel = new javax.swing.JButton();

        Room_details_label.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Room_details_label.setText("Room Details :");

        room_requred.setText("Number of Rooms required : ");

        no_rooms.setModel(new javax.swing.SpinnerNumberModel(0, 0, 4, 1));

        no_occupants_label.setText("Number of occupants : ");

        occupants.setModel(new javax.swing.SpinnerNumberModel());

        Room_type.setText("Room Type: ");

       Availabilty.setText("Check Availability");

        allot.setText("Allot Room");

        cancel.setText("Cancel");
        

        room_type_list.setSelectedIndex(0);
       
        
        value = (String) room_type_list.getSelectedItem();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(Availabilty, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(allot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Room_details_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(197, 197, 197))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(room_requred, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(no_occupants_label)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Room_type, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(77, 77, 77)))
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(no_rooms)
                                    .addComponent(occupants)
                                    .addComponent(room_type_list, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(117, 117, 117))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(Room_details_label)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(room_requred)
                    .addComponent(no_rooms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(no_occupants_label)
                    .addComponent(occupants, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Room_type)
                    .addComponent(room_type_list, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Availabilty)
                    .addComponent(allot)
                    .addComponent(cancel))
                .addGap(29, 29, 29))
        );
    }
    
}
