/**
 * @author Weiwei Qin
 * Main function.
 */

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextArea;

import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;

import java.io.File;
import java.io.BufferedWriter;

public class SpeechToText {
	/*
	 * //Translator holder class
	private Translator translator;
	
	//For sphinx speech recognation variables
	private Recognizer recognizer;
	private Microphone microphone;
	
	private boolean recording;
	
	private JTextArea textExpression;
	
	
	public SpeechToText(){//Engine Class Constructer
		
		
		//Do Setting Microphone and Sphinx
		recording =false;
		ConfigurationManager cm= new ConfigurationManager(Engine.class.getResource("calculator.config.xml"));
		
		recognizer =  (Recognizer) cm.lookup("recognizer");
		recognizer.allocate();
		
		microphone = (Microphone) cm.lookup("microphone");
		
		if(!microphone.startRecording()){
			System.out.println("cannot start mic");
			infoBox("Cannot Start the microphone, Program will be shutting down" ,"Error");
			recognizer.deallocate();
			System.exit(1);
		}
		
		translator = new Translator();//
	}
	 */
	
	public String speaktotext() {
		Speech speak2 = new Speech();
		speak2.speak("Please speak the calculation.");

        String resultText;
		ConfigurationManager cm;
		cm = new ConfigurationManager(SpeechToText.class.getResource("myword.config.xml"));
		Recognizer recognizer = (Recognizer)cm.lookup("recognizer");
		recognizer.allocate();

		// start the microphone or exit if the programm if this is not possible
		Microphone microphone = (Microphone)cm.lookup("microphone");
		if (!microphone.startRecording()) {
		    	System.out.println("Cannot start microphone.");
		    	recognizer.deallocate();
		    	System.exit(1);
		}

		//System.out.println("Waiting 5' and Say: ( one | two | three... )");
		Speech speak1 = new Speech();
		//speak1.speak("Please tell me the calculation");
		// loop the recognition until the programm exits.
		String str = "";
		for (int i = 0;i < 100;i ++){
			Result result = recognizer.recognize();
			resultText = result.getBestFinalResultNoFiller(); 
			if (result != null && resultText != "equal") {
		        //resultText = result.getBestFinalResultNoFiller(); 
				switch (resultText){
			  		case "zero":
			 			resultText = "0";
			 			str = str + resultText;
			  			break;
			  			
			  		case "one":
		        		resultText = "1";
		        		str = str + resultText;
		        		break;
		        		
			  		case "two":
		        		resultText = "2";
		        		str = str + resultText;
		        		break;
		        		
			 		case "three":
				        resultText = "3";
				        str = str + resultText;
				        break;
				        
					case "four":
				        resultText = "4";
				        str = str + resultText;
				        break;
				        
				    case "five":
				        resultText = "5";
				        str = str + resultText;
				        break;
				        
					case "six":
					    resultText = "6";
					    str = str + resultText;
					    break;
					    
					case "seven":
						resultText = "7";
						str = str + resultText;
						break;
						
				    case "eight":
				    	resultText = "8";
				    	str = str + resultText;
		        		break;
		        		
					case "nine":
		        		resultText = "9";
		        		str = str + resultText;
		        		break;
		        		
		        	case "add":
		        		resultText = "+";
		        		str = str + resultText;
		        		break;
		        		
		        	case "minus":
					     resultText = "-";
					     str = str + resultText;
					     //break;
					     
					case "multiply":
					     resultText = "*";
					     str = str + resultText;
					     break;
					     
					case "power":
		        		resultText = "^";
		        		str = str + resultText;
		        		break;
		        		
			 		case "left brace":
		        		resultText = "(";
		        		str = str + resultText;
		        		break;
		        		
	        		case "right brace":
	        			resultText = ")";
	        			str = str + resultText;
	        			break;
	        			
	        		case "backspace":
	        			int length = str.length();
	        			if (length == 1) {
	        				str = "";
	        				System.out.println("No Input!");
	        				speak1.speak("No Input");
	        			} else {
						str = str.substring(0,length - 1);
	        			}
	        			break;
	        			
	        		case "equal":
	        			resultText = "=";
	    				Operator myconvert = new Operator();
	    				long ans = myconvert.stringToArithmetic(str);	
	        			str = str + resultText + (ans + "");
	        			i = 99;
	        			break;
	        			
	        		case "clear":
	        			str = "";
	        			System.out.println("Cleared.");
	        			speak1.speak("Cleared");
	        			System.exit(1);
	        			break;
	        			
	        		case "close":
	        			System.exit(0);
	        			break;
		    		}
		    		System.out.println(str);
		        	//write into the file
		    		File file = new File("voice.txt");
		    		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
		        	 	bw.write(String.valueOf(str));
		    		} catch (IOException ex) {
		            		ex.printStackTrace();
				}    
			} 
		}
		return str;
	}
} 




