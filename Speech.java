import parsii.eval.Expression;
import parsii.eval.Parser;
import parsii.tokenizer.ParseException;

/**
 * @author Weiwei Qin & Jialan Zhong
 * Speech function.
 */

/*
 *  private String andSeparator = " and";
	private String decimalSeparator = "point";
	private String expSeparator = "exp";
	
	private String addSeparator = "plus";
	private String subSeparator = "minus";
	private String multSeparator = "times";
	private String dvdSeparator = "over";

	private String powerSeparator = "power";
	private String squaredSeparator = "squared";
	private String cubedSeparator = "cubed";
 */

/**
	 * Evaluate a mathematical expression and calculates its value
	 * 
	 * @param expression
	 *            the string to evaluate
	 * @return result of the calculation
	 */
	/*
	public void calculateExpression(String expression) throws ParseException {//Calculate the expression
		expression = numberFormat(expression);
		String[] terms = expression.split(String.format(WITH_DELIMITER,"-|\\+|\\*|\\/"));
		parsedExpression = termsParser(terms, NUMBER_BASES);
		Expression expr = Parser.parse(parsedExpression, scope);
		Result = expr.evaluate();
	}
	*/

public class Speech {
	public void speak(String string) {       
        final String VOICENAME = "Weiwei";
        Voice voice;
        VoiceManager vm = VoiceManager.getInstance();
        voice = vm.getVoice(VOICENAME);
        /*
        public String numberFormat(String expression) { 
		expression = expression.toLowerCase();
		expression = expression.replace(addSeparator, "+");
		expression = expression.replace(subSeparator, "-");
		expression = expression.replace(multSeparator, "*");
		expression = expression.replace(dvdSeparator, "/");
		expression = expression.replace(powerSeparator, "^");
		expression = expression.replace(squaredSeparator, "^2");
		expression = expression.replace(cubedSeparator, "^3");
		expression = expression.replace(decimalSeparator, ".");
		expression = expression.replaceAll(andSeparator, "");
		expression = expression.replaceAll("\\s+", "");
		return expression;
	}
         */
        voice.allocate();
        voice.speak(string);
    }
}