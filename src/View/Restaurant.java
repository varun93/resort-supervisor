/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Restaurant.java
 *
 * Created on Mar 3, 2014, 3:46:53 PM
 */

package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Controller.RestaurantManager;
import Model.BillDB;
import Model.MenuDB;
import Model.RestaurantFacility;


public class Restaurant extends javax.swing.JPanel {

    
    private javax.swing.JButton Cancel_rest;
    private javax.swing.JTextField CustomerID_TextField;
    private javax.swing.JLabel Customer_Label;
    public javax.swing.JTable priceTable;
    private javax.swing.JLabel T_amount;
    private javax.swing.JTextField T_amountTextField;
    private javax.swing.JButton Update_rest_bill;
    private javax.swing.JLabel Welcometext;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel select_item_label;
    private static Object [][] data = null;
    private static String[] columnName = new String [] {
            "Items", "Item Code", "Price", ""
        };
    
   public static DefaultTableModel model = new DefaultTableModel(data,columnName)
	{

		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int col)
		{
			if(col==columnName.length-1) 
				return true;
			else
				return false;

		}

		

		
		
		public Class getColumnClass(int column)
		{
			Class retValue=null;

			Object value=this.getValueAt(0,column);  
			return (value==null?Object.class:value.getClass());  

		}
	};
    
    
	
    public Restaurant() {
        initComponents();
        addListeners();
    }

    
   
    private void addListeners()
    {
    	
    	

    	    Update_rest_bill.addActionListener(new ActionListener() {
			
    		
    		int[] arr = new int[20];
			int k=0,sum;
			public void actionPerformed(ActionEvent e) {
			
				for(int i=0;i<model.getRowCount();i++)
				{
					if(priceTable.getValueAt(i, 3).toString().equals("true"))
					{
						Integer  itemCost =  Integer.parseInt(String.valueOf(priceTable.getValueAt(i, 2).toString()));
					    arr[k++]=itemCost;
						
					}

				}
				
				int i,sum=0;
				
				for(i=0;i<k;i++)
					sum+=arr[i];
				
				String customerID = CustomerID_TextField.getText();
				
				 T_amountTextField.setText(sum + "");
				
				
				new RestaurantManager().calculateFacilityBill(sum, customerID);
				}
		});
    	
     }
   
    public javax.swing.JTable getTable()
    {
    
    	return this.priceTable;
    }
    
    
    public void  addData()
	{

    Object[] tempRow;
		ArrayList<RestaurantFacility> getAll = MenuDB.getRestaurantItems();

        for(int i=0;i<getAll.size();i++)
		{
			RestaurantFacility facility = getAll.get(i);

			tempRow = new Object[]{facility.getItemCode(),facility.getItemName(),facility.getItemCost(),false};

			
			model.addRow(tempRow);
         }
		priceTable.repaint();

	}
    
    
    public static void main(String args[])
    {
    	BillReport report = new BillReport();
    	JFrame frame = new JFrame("bill");
    	frame.setVisible(true);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(500,400);
    	frame.add(new Restaurant());
    	
    	
   }
    
    
    private void init()
    {
  	  
  	  javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(select_item_label)
                            .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                            .addComponent(Customer_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(CustomerID_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(153, 153, 153)))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(T_amount)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(Update_rest_bill)
                                .addGap(29, 29, 29)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Cancel_rest)
                            .addComponent(T_amountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Welcometext, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(204, 204, 204))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Welcometext)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Customer_Label)
                    .addComponent(CustomerID_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(select_item_label)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(T_amount)
                    .addComponent(T_amountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Update_rest_bill)
                    .addComponent(Cancel_rest))
                .addContainerGap(53, Short.MAX_VALUE))
        );
  	  
  	  
    }
    
    private void initComponents() {

        Welcometext = new javax.swing.JLabel();
        Customer_Label = new javax.swing.JLabel();
        CustomerID_TextField = new javax.swing.JTextField();
        select_item_label = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        priceTable = new javax.swing.JTable();
        T_amount = new javax.swing.JLabel();
        T_amountTextField = new javax.swing.JTextField();
        Update_rest_bill = new javax.swing.JButton();
        Cancel_rest = new javax.swing.JButton();

        
        Welcometext.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Welcometext.setText("Welcome to Restaurant");

        Customer_Label.setText("Customer ID: ");

        select_item_label.setText("Select the Items purchased by customer:");

        priceTable.setModel(model);
            
        jScrollPane1.setViewportView(priceTable);

        T_amount.setText("Total Amount :");

        T_amountTextField.setEnabled(false);

        Update_rest_bill.setText("Update Bill");

        Cancel_rest.setText("Cancel");
        
        init();

        addData();
        
    }

 
    
    

}
