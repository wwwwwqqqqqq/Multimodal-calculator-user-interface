/**
 * @author Weiwei Qin & Jialan Zhong
 * Main function.
 */

public class Text {
	public String totex(String expr) {
      		// Stack< Character> stack = new Stack< Character>();
        	String texexpr = "";
        
        	for (int i = 0; i < expr.length(); i++) {
           		char c = expr.charAt(i); 
           		if (expr.charAt(i) == '^' && Character.isDigit(expr.charAt(i + 1))) {
        			texexpr = texexpr + c + "{" + expr.charAt(i + 1) + "}";
        		   	i = i + 1;
           		} else {    
        		   texexpr = texexpr + c;
           		}
		}
		return texexpr;
	}
}
