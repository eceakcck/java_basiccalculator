import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Calculate extends JFrame implements ActionListener {
	
	// GUI items
	private JLabel lblFirstNumber,lblSecondNumber,lblResult;
	private JTextField txtOne,txtTwo,txtResult;
	private JButton btnCalculate,btnReset,btnExit;
	private JRadioButton rdAdd,rdSub,rdMul,rdDiv;
	private ButtonGroup btnGroup;
	private MyCalculation myCalculation;
	
	
	// constructor
	public Calculate() {
		// set Layout manager
		setLayout(null);
        init();		
				
		
		// set user interface
		//size of the window
		setSize(500, 400);
		setTitle("Calculate");
		setVisible(true);
	}

	//initialize GUI items
	private void init() {
		// initialize GUI items...Labels
				myCalculation= new MyCalculation();
				lblFirstNumber= new JLabel("First Number");
				lblFirstNumber.setSize(100, 20);
				lblFirstNumber.setLocation(10, 10);
				lblFirstNumber.setForeground(Color.red);
				getContentPane().add(lblFirstNumber);
				
				// initialize GUI items...txtOne
				txtOne= new JTextField();
				txtOne.setSize(50, 20);
				txtOne.setLocation(130, 10);
				getContentPane().add(txtOne);
				


				// initialize GUI items...lblSecond
				lblSecondNumber= new JLabel("Second Number");
				lblSecondNumber.setSize(120, 20);
				lblSecondNumber.setLocation(10, 50);
				lblSecondNumber.setForeground(Color.red);
				getContentPane().add(lblSecondNumber);
				
				// initialize GUI items...txtTwo
				txtTwo= new JTextField();
				txtTwo.setSize(50, 20);
				txtTwo.setLocation(130, 50);
				getContentPane().add(txtTwo);


				

				// initialize GUI items...lblResult
				lblResult= new JLabel("Result");
				lblResult.setSize(120, 20);
				lblResult.setLocation(10, 100);
				lblResult.setForeground(Color.red);
				getContentPane().add(lblResult);
				
				// initialize GUI items...txtTwo
				txtResult= new JTextField();
				txtResult.setSize(50, 20);
				txtResult.setLocation(130, 100);
				getContentPane().add(txtResult);
				txtResult.setEditable(false);

		         //initialize GUI items...buttons
				btnCalculate= new JButton("Calculate");
				btnCalculate.setSize(100, 50);
				btnCalculate.setLocation(50, 200);
				getContentPane().add(btnCalculate);
				//register this button to respond actions
				btnCalculate.addActionListener(this);
				
				 //initialize GUI items...buttons
				btnReset= new JButton("Reset");
				btnReset.setSize(100, 50);
				btnReset.setLocation(150, 200);
				getContentPane().add(btnReset);
				btnReset.addActionListener(this);
				
				

				 //initialize GUI items...buttons
				btnExit= new JButton("Exit");
				btnExit.setSize(100, 50);
				btnExit.setLocation(250, 200);
				btnExit.setForeground(Color.RED);
				btnExit.setBackground(Color.pink);
				getContentPane().add(btnExit);
				btnExit.addActionListener(this);
				
				// initialize Radio buttons....
				rdAdd= new JRadioButton("Add");
				rdAdd.setSize(80, 20);
				rdAdd.setLocation(50, 150);
				getContentPane().add(rdAdd);
				// this option is default...
				rdAdd.setSelected(true);
				
				rdSub= new JRadioButton("Sub");
				rdSub.setSize(80, 20);
				rdSub.setLocation(150, 150);
				getContentPane().add(rdSub);
				
				rdMul= new JRadioButton("Mul");
				rdMul.setSize(80, 20);
				rdMul.setLocation(250, 150);
				getContentPane().add(rdMul);
				
				rdDiv= new JRadioButton("Div");
				rdDiv.setSize(80, 20);
				rdDiv.setLocation(350, 150);
				getContentPane().add(rdDiv);
				
				// add these radio buttons into a groupe
				btnGroup= new ButtonGroup();
				btnGroup.add(rdSub);
				btnGroup.add(rdAdd);
				btnGroup.add(rdMul);
				btnGroup.add(rdDiv);
				
				
				
				

		
	}
	public static void main(String[] args) {
		new Calculate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(btnCalculate)) {
		   //JOptionPane.showMessageDialog(this, "Action is Calculate....");
		   calculate();
		
		}
		else if(e.getSource().equals(btnReset))
			//JOptionPane.showMessageDialog(this, "Action is Rest....");
			reset();
		else 
			//JOptionPane.showMessageDialog(this, "Action is Exit....");
			exit();
	}
	
	// helper method for calculate-general
	public void calculate() {
		           // Read data from text fields
					String strOne= txtOne.getText().trim();
					String strTwo= txtTwo.getText().trim();
				try {	
					//Convert strings into integer number
					int one= Integer.parseInt(strOne);
					int two= Integer.parseInt(strTwo);
					
					// calculate result...
					//int result= sum(one, two);
					int result= myCalculation(one, two);
					
					// send the result to the text result GUI item
					txtResult.setText(result+"");
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(this, "Input Integer Number","Input Numbers",JOptionPane.ERROR_MESSAGE);
					reset();
				}
	}
	
	//helper method mycalculation
	public int myCalculation(int a,int b) {
		
		int result=0;
		
		if(rdAdd.isSelected())
			result=myCalculation.sum(a, b);
		else if(rdSub.isSelected())
			result=myCalculation.sub(a, b);
		else if(rdMul.isSelected())
			result=myCalculation.mul(a, b);
		else
			result=myCalculation.div(a, b);
		return result;
	}
	
	// helper method to make calculation
	public int sum(int a,int b) {
		return a+b;
	}
	
	// helper method for reset
	public void reset() {
		txtOne.setText("");
		txtTwo.setText("");
		txtResult.setText("");
		rdAdd.setSelected(true);
	}
	
	
	// helper method for exit...{
	public void exit() {
		System.exit(1);
	}
}














