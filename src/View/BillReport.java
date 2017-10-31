package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Controller.ResortManager;
import Model.Bill;
import Model.BillDB;
import Model.Customer;
import Model.CustomerDB;


public class BillReport extends javax.swing.JPanel {
	
	
	    
	    private javax.swing.JButton cancel;
	    private javax.swing.JButton print;
        private javax.swing.JLabel Customer_ID;
	    private javax.swing.JLabel Customer_name;
	    private javax.swing.JLabel Rooms;
	    private javax.swing.JLabel SE_charges;
	    private javax.swing.JLabel T_anount;
	    private javax.swing.JLabel check_in_date;
	    private javax.swing.JLabel check_out_date;
	    private javax.swing.JLabel customerBill_label;
	    private javax.swing.JLabel room_charges;
	    private javax.swing.JLabel room_type;
	    private javax.swing.JLabel days_stayed;
	    private javax.swing.JLabel restaurant_charges;
	    
	  
	    private javax.swing.JTextField checkInDate;//
	    private javax.swing.JTextField checkOutDate;//
	    private javax.swing.JTextField customerID;//
	    private javax.swing.JTextField customerName;//
	    private javax.swing.JTextField daysStayed;//
	    private javax.swing.JTextField no_rooms;//
	    private javax.swing.JTextField roomType;//
	    private javax.swing.JTextField restaurantCharges;
	    private javax.swing.JTextField roomCharges;
	    private javax.swing.JTextField SE_Charges;
	    private javax.swing.JTextField Total_amount;
	   
	 
	   
	    public BillReport() {
        initComponents();
        
        print.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				new ResortManager().generateFinalBill("");
				Customer customer = CustomerDB.getCustomerDetails("99nueecr8o");
				Bill bill = BillDB.getBillDetails("99nueecr8o");
				
				customerID.setText(customer.getId());
				customerName.setText(customer.getFirstName());
				checkInDate.setText(toDate(customer.getCheckIn()));
				checkOutDate.setText(toDate(customer.getCheckOut()));
				restaurantCharges.setText(bill.getRestaurantCost().toString());
				roomCharges.setText(bill.getBookingCost().toString());
				SE_Charges.setText(bill.getSeCost().toString());
				Total_amount.setText(bill.getTotalCost().toString());
			}
		});
    }

    private String toDate(String date)
    {
    	return date.substring(0,4) + "/" + date.substring(4, 6) + "/" + date.substring(6, date.length());
    	
    
    }
    
    
 
    public static void main(String args[])
    {
    	
    	JFrame frame = new JFrame("Bill Report");
    	frame.setVisible(true);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(500,400);
    	frame.add(new BillReport());
    	
    }
    
    
    private void initComponents() {

        customerBill_label = new javax.swing.JLabel();
        Customer_ID = new javax.swing.JLabel();
        Customer_name = new javax.swing.JLabel();
        Rooms = new javax.swing.JLabel();
        days_stayed = new javax.swing.JLabel();
        room_type = new javax.swing.JLabel();
        check_in_date = new javax.swing.JLabel();
        check_out_date = new javax.swing.JLabel();
        room_charges = new javax.swing.JLabel();
        restaurant_charges = new javax.swing.JLabel();
        SE_charges = new javax.swing.JLabel();
        T_anount = new javax.swing.JLabel();
        customerID = new javax.swing.JTextField();
        customerName = new javax.swing.JTextField();
        no_rooms = new javax.swing.JTextField();
        daysStayed = new javax.swing.JTextField();
        roomType = new javax.swing.JTextField();
        checkInDate = new javax.swing.JTextField();
        checkOutDate = new javax.swing.JTextField();
        roomCharges = new javax.swing.JTextField();
        restaurantCharges = new javax.swing.JTextField();
        SE_Charges = new javax.swing.JTextField();
        Total_amount = new javax.swing.JTextField();
        print = new javax.swing.JButton();
        cancel = new javax.swing.JButton();

        customerBill_label.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        customerBill_label.setText("Customer Bill :");

        Customer_ID.setText("Customer ID :");

        Customer_name.setText("Customer Name :");

        Rooms.setText("Number of Rooms taken :");

        days_stayed.setText("Days stayed : ");

        room_type.setText("Type of Room taken : ");

        check_in_date.setText("Check-in date : ");

        check_out_date.setText("Check-out date :");

        room_charges.setText("Total Room charges :");

        restaurant_charges.setText("Total Restaurant charges :");

        SE_charges.setText("Total Sports & Entertainment charges: ");

        T_anount.setText("Total Amount :");

        customerID.setEnabled(false);

        customerName.setEnabled(false);

        no_rooms.setEnabled(false);

        daysStayed.setEnabled(false);

        roomType.setEnabled(false);

        checkInDate.setEnabled(false);

        checkOutDate.setEnabled(false);

        roomCharges.setEnabled(false);

        restaurantCharges.setEnabled(false);

        SE_Charges.setEnabled(false);

        Total_amount.setEnabled(false);

        print.setText("Print Bill");

        cancel.setText("Cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(T_anount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(SE_charges)
                        .addComponent(restaurant_charges)
                        .addComponent(room_charges)
                        .addComponent(check_out_date)
                        .addComponent(check_in_date)
                        .addComponent(room_type)
                        .addComponent(days_stayed)
                        .addComponent(Rooms)
                        .addComponent(Customer_name)
                        .addComponent(Customer_ID)
                        .addComponent(customerBill_label)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(customerID)
                            .addComponent(customerName)
                            .addComponent(no_rooms)
                            .addComponent(daysStayed)
                            .addComponent(roomType)
                            .addComponent(checkInDate)
                            .addComponent(checkOutDate)
                            .addComponent(roomCharges)
                            .addComponent(restaurantCharges)
                            .addComponent(SE_Charges, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Total_amount)
                        .addGap(37, 37, 37)))
                .addGap(125, 125, 125))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(316, 316, 316)
                .addComponent(print, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(56, 56, 56))
        );
        
        
        
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(customerBill_label)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Customer_ID)
                    .addComponent(customerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Customer_name)
                    .addComponent(customerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Rooms)
                    .addComponent(no_rooms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(days_stayed)
                    .addComponent(daysStayed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(room_type)
                    .addComponent(roomType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(check_in_date)
                    .addComponent(checkInDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(check_out_date)
                    .addComponent(checkOutDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(room_charges)
                    .addComponent(roomCharges, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(restaurant_charges)
                    .addComponent(restaurantCharges, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SE_charges)
                    .addComponent(SE_Charges, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(T_anount)
                    .addComponent(Total_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(print)
                    .addComponent(cancel))
                .addContainerGap())
        );
    }
    
}
