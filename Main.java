/**
 * @author Weiwei Qin & Jialan Zhong
 * Main function.
 */

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;

/*
 * private boolean buttonListenActive;

	public Frame(Engine e){
		//MainFrame constructer
		super("SpeechDrivenCalculator");//Gui Name
		
		elementsforgui();//Creation of Elements Function Call
		addlisteners();	//Declaration Listeners For Buttons Functions Call
		
		buttonListenActive=false;
		engine=e; //connection between MainFrame Class to Engine Class 
		engine.bridge(textExpression);//Sharing the textbox to Engine Class
		
		
		CreateGui(); //Create Gui Functions Call
		
	}
	private void CreateGui(){
		//Create ,Setting and Show The SpeechDriven Gui Function
		setBackground(Color.WHITE);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds(100, 100, 318, 318);
		setLayout( null);
		setResizable(false);
        setVisible( true );
	}
	private void addlisteners(){
		//ADD All Buttons Listeners to Gui
		addKeyListener(this);//Keyboard Listeners
		
		//Buttons
		buttonListening.addActionListener(this);		
		buttonDeleting.addActionListener(this);
		buttonRefresh.addActionListener(this);
		buttonOne.addActionListener(this);
		buttonTwo.addActionListener(this);
		buttonThree.addActionListener(this);
		buttonFour.addActionListener(this);
		buttonFive.addActionListener(this);
		buttonSix.addActionListener(this);
		buttonSeven.addActionListener(this);
		buttonEight.addActionListener(this);
		buttonNine.addActionListener(this);
		buttonZero.addActionListener(this);
		buttonPlus.addActionListener(this);
		buttonMinus.addActionListener(this);
		buttonX.addActionListener(this);
		buttonDiv.addActionListener(this);
		buttonEqual.addActionListener(this);
		buttonE.addActionListener(this);
		buttonSq.addActionListener(this);
		buttonPoint.addActionListener(this);
		
		//Set Keyboard and Action Listeners
		setFocusable(true);
	}
 */

class Foo implements Runnable {
    	private volatile String value;
	 @Override
	 public void run() {
    		SpeechToText voicetotext=new SpeechToText();
			value=voicetotext.speaktotext();
    	}

    	public String getValue() {
        	try {
            		Thread.sleep(4000);
          	} catch (InterruptedException e) {
        	 	e.printStackTrace();
             	}
        	return value;
      	}
}

public class Main extends JFrame {
    	public static void main(String[] args) {
        	final Frame jf = new Frame("Calculator");
        	jf.setSize(390,412); 
        	jf.setResizable(false);
        	jf.setLayout(null); 
        	final JTextField jt1 = new JTextField("");
        	jt1.setHorizontalAlignment(JTextField.RIGHT); 
        	jt1.setEditable(true); 
        	jt1.setBounds(15,55,360,60);
        	jf.add(jt1);
        
    		//0 button
        	final JButton b0 = new JButton("0");
        	b0.addActionListener(new ActionListener() {
            		public void actionPerformed(ActionEvent e) {
                		jt1.setText(jt1.getText() + "0");
            		}
        	});
        	
			//1 button
			final JButton b1 = new JButton("1");
			b1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jt1.setText(jt1.getText() + "1");
				}
			});
			
			//2 button
			final JButton b2 = new JButton("2");
			b2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jt1.setText(jt1.getText() + "2");
				}
			});
			
			//3 button
			final JButton b3 = new JButton("3");
			b3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jt1.setText(jt1.getText() + "3"); }
			});
			
			//4 button
			final JButton b4 = new JButton("4");
			b4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jt1.setText(jt1.getText() + "4");
				}
			});
			
			//5 button
			final JButton b5 = new JButton("5");
			b5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jt1.setText(jt1.getText() + "5");
				}
			});
			
			//6 button
			final JButton b6 = new JButton("6");
			b6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jt1.setText(jt1.getText() + "6");
				}
			});
			
			//7 button
			final JButton b7 = new JButton("7");
			b7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jt1.setText(jt1.getText() + "7");
				}
			});
			
			//8 button
			final JButton b8 = new JButton("8");
			b8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jt1.setText(jt1.getText() + "8");
				}
			});
			//9 button
			final JButton b9 = new JButton("9");
			b9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jt1.setText(jt1.getText() + "9");
				}
			});
			
			//+ button
			final JButton badd = new JButton("+");
			badd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jt1.setText(jt1.getText() + "+");
				}
			});
			
			//- button
			final JButton bminus = new JButton("-");
			bminus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jt1.setText(jt1.getText() + "-");
				}
			});
			
			//* button
			final JButton bmulti = new JButton("*");
			bmulti.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jt1.setText(jt1.getText() + "*");
				}
			});
			
			//^ button
			final JButton bpower = new JButton("<html>x<SUP>y</SUP></html>");
			bpower.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jt1.setText(jt1.getText() + "^");
				}
			});
			
			//= Speech button
			final JButton speech = new JButton("<html>= Speech</html>");
			speech.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) { 
					Operator convert = new Operator();
					String tf = Operator.infixToSuffix(jt1.getText());
					long jt2 = convert.stringToArithmetic(jt1.getText());
					Speech speech = new Speech();
					if (jt2 > 0) {
						speech.speak("Your answer is" + jt2);
					} else {
						speech.speak("Your answer is negative" + jt2);
					}
			 		jt1.setText(jt1.getText() + "=" + tf + "=" + jt2);
				}
			});
			
			//= Text button 
			final JButton text = new JButton("<html>= Text</html>");
			text.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { 
					Operator convert = new Operator();
					long jt2 = convert.stringToArithmetic(jt1.getText());
					Text texconvert = new Text();
					String tex = texconvert.totex(jt1.getText());
					//jt1.setText(jt1.getText() + "=" + tex + "=" + jt2);
					jt1.setText("=" + jt2);
				}
			});
			
			//( button
			final JButton left = new JButton("(");
			left.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jt1.setText(jt1.getText() + "(");
				}
			});
			
			//) button
			final JButton right = new JButton(")");
			right.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		  			jt1.setText(jt1.getText() + ")");
				}
			});
			
			//Voice input Button
			final JRadioButton voice = new JRadioButton("<html>VOICE</html>");
			voice.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) {
		      			if (voice.isSelected()) {
						String str = "VOICE ON";
						Foo foo = new Foo();
						new Thread(foo).start();
						String foovalue = foo.getValue();
						str += foovalue;
						}
		      		}
			});
			
			//Quit button
			final JRadioButton quit = new JRadioButton("QUIT");
			quit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
	 				System.exit(0);
				}
			});

			//Clear button
			final JButton ac = new JButton("AC");
			ac.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jt1.setText("");
				}
			});
			
			//Delete button
			final JButton delete = new JButton("Delete");
			delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String message;
					int length = jt1.getText().length();
					message = jt1.getText();
					if(length == 0) {
						JOptionPane.showMessageDialog(null, "There is no numbers, please try again."); 
					} else {
						jt1.setText(message.substring(0,length - 1)); 
					}
				}
			});

			//Voice button
			voice.addMouseListener(new MouseAdapter() {
	    		public void mouseReleased(MouseEvent e) {
	    			jt1.setText("Speak the calculation you want to calculate.");	
	    	
	    			//periodicTask, to update the voice.text file created by the voice recognition in real time.
	    			ScheduledThreadPoolExecutor sch = (ScheduledThreadPoolExecutor)
	    					Executors.newScheduledThreadPool(3);
	    			Runnable periodicTask = new Runnable() {
		        		private Scanner scnr;
		        		@Override
		        		public void run() {
		        			try{  //scan file
		        		 		File text = new File("voice.txt");
		        	        		scnr = new Scanner(text);
		                			 //Reading each line of file using Scanner class
		                		  	int lineNumber = 1;
		                     	
		                     			while(scnr.hasNextLine()) {
		                         			String line = scnr.nextLine();
		                         			System.out.println("line " + lineNumber + " :" + line);
		                         			lineNumber ++;
		                         			jt1.setText(line);
		                        		 }
		                    			Thread.sleep(3);
		        			 }catch(Exception e){
		        	 		 }
		            		}
			 	};
				ScheduledFuture<?> periodicFuture = sch.scheduleAtFixedRate(periodicTask, 1, 1, TimeUnit.SECONDS);
	        	}
		});

			/*
			 * private void elementsforgui(){
		//Creations and Settings for elements of gui
		//text box expreesion
		textExpression= new JTextArea();
		textExpression.setForeground(Color.WHITE);
		textExpression.setBackground(Color.BLACK);
		textExpression.setBounds(12, 12, 288, 30);
		textExpression.setEditable(false);
		
		add(textExpression);
		
		//button Listening
		buttonListening = new JButton("Listening");
		buttonListening.setBounds(12, 54, 288, 30);
		buttonListening.setBackground(Color.WHITE);
		
		add(buttonListening);
		
		//button deletion last expression
		buttonDeleting = new JButton("<---");
		buttonDeleting.setBounds(12, 96, 138, 25);
		buttonDeleting.setBackground(Color.WHITE);
		
		add(buttonDeleting);
		
		//button refreshing the expression
		buttonRefresh = new JButton("Refresh");
		buttonRefresh.setBounds(162, 96, 138, 25);
		buttonRefresh.setBackground(Color.WHITE);
		
		add(buttonRefresh);
		
		//button one
		buttonOne = new JButton("1");
		buttonOne.setBounds(12, 133, 48, 25);
		buttonOne.setBackground(Color.WHITE);
		
		add(buttonOne);
		//button two
		buttonTwo = new JButton("2");
		buttonTwo.setBounds(72, 133, 48, 25);
		buttonTwo.setBackground(Color.WHITE);
		
		add(buttonTwo);
		
		//button three
		buttonThree = new JButton("3");
		buttonThree.setBounds(132, 133, 48, 25);
		buttonThree.setBackground(Color.WHITE);
		
		add(buttonThree);
		
		//button four
		buttonFour = new JButton("4");
		buttonFour.setBounds(12, 170, 48, 25);
		buttonFour.setBackground(Color.WHITE);
		
		add(buttonFour);
		
		//button Five
		buttonFive = new JButton("5");
		buttonFive.setBounds(72, 170, 48, 25);
		buttonFive.setBackground(Color.WHITE);
		
		add(buttonFive);
		
		//button Six
		buttonSix = new JButton("6");
		buttonSix.setBounds(132, 170, 48, 25);
		buttonSix.setBackground(Color.WHITE);
		
		add(buttonSix);
		
		//button seven
		buttonSeven = new JButton("7");
		buttonSeven.setBounds(12, 207, 48, 25);
		buttonSeven.setBackground(Color.WHITE);
		
		add(buttonSeven);
		
		//button eight
		buttonEight = new JButton("8");
		buttonEight.setBounds(72, 207, 48, 25);
		buttonEight.setBackground(Color.WHITE);
		
		add(buttonEight);
		
		//button nine
		buttonNine= new JButton("9");
		buttonNine.setBounds(132, 207, 48, 25);
		buttonNine.setBackground(Color.WHITE);
		
		add(buttonNine);
		
		//button zero
		buttonZero = new JButton("0");
		buttonZero.setBounds(12, 244, 108, 25);
		buttonZero.setBackground(Color.WHITE);
		
		add(buttonZero);
		
		//button plus
		buttonPlus = new JButton("+");
		buttonPlus.setBounds(192, 133, 48, 25);
		buttonPlus.setBackground(Color.WHITE);
		
		add(buttonPlus);
		
		//button minus
		buttonMinus = new JButton("-");
		buttonMinus.setBounds(192, 170, 48, 25);
		buttonMinus.setBackground(Color.WHITE);
		
		add(buttonMinus);
		
		//button times
		buttonX = new JButton("X");
		buttonX.setBounds(252, 133, 48, 25);
		buttonX.setBackground(Color.WHITE);
		
		add(buttonX);
		
		//button divider(over)
		buttonDiv = new JButton("/");
		buttonDiv.setBounds(252, 170, 48, 25);
		buttonDiv.setBackground(Color.WHITE);
		
		add(buttonDiv);
		
		//button exponent
		buttonE = new JButton("e");
		buttonE.setBounds(192, 207, 48, 25);
		buttonE.setBackground(Color.WHITE);
		
		add(buttonE);
		
		//button .(point)
		buttonPoint = new JButton(".");
		buttonPoint.setBounds(132, 244, 48, 25);
		buttonPoint.setBackground(Color.WHITE);
		
		add(buttonPoint);
		
		//button Power
		buttonSq = new JButton("^");
		buttonSq.setBounds(192, 244, 48, 25);
		buttonSq.setBackground(Color.WHITE);
		
		add(buttonSq);
		
		//button equal
		buttonEqual = new JButton("=");
		buttonEqual.setBounds(252, 207, 48, 62);
		buttonEqual.setBackground(Color.WHITE);
		
		add(buttonEqual);
	}
			 */
		

		//layout
		b0.setBounds(15,343,67,52);
		b1.setBounds(15,285,67,52); 
		b2.setBounds(85,285,67,52);
		b3.setBounds(155,285,67,52);
		b4.setBounds(15,226,67,52);
		b5.setBounds(85,226,67,52);
		b6.setBounds(155,226,67,52);
		b7.setBounds(15,168,67,52);
		b8.setBounds(85,168,67,52);
		b9.setBounds(155,168,67,52);
		badd.setBounds(226,343,67,52);
		bminus.setBounds(226,285,67,52);
		bmulti.setBounds(226,226,67,52);
		bpower.setBounds(226,168,67,52);
		speech.setBounds(297,285,78,52);
		text.setBounds(297,343,78,52);
		left.setBounds(85,343,67,52);
		right.setBounds(155,343,67,52);
		ac.setBounds(297,226,78,52);
		voice.setBounds(15,124,139,37);
		voice.setBackground(Color.white);
		quit.setBounds(250,124,60,37);
		quit.setBackground(Color.white);
		delete.setBounds(297,168,78,52);
		
		//component
		jf.add(b0);
		jf.add(b1);
		jf.add(b2);
		jf.add(b3);
		jf.add(b4);
		jf.add(b5);
		jf.add(b6);
		jf.add(b7);
		jf.add(b8);
		jf.add(b9);
		jf.add(badd);
		jf.add(bminus);
		jf.add(bmulti);
		jf.add(bpower);
		jf.add(text);
		jf.add(left);
		jf.add(right);
		jf.add(ac);
		jf.add(delete);
		jf.add(speech);
		jf.add(voice);
		jf.add(quit);
	
		//Close
		jf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			} 
		}); 
		jf.show();
	}
}


