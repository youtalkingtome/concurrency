package collectors.algorithms;

import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {

        String string= "{()}";
        Stack<Character> charStack=new Stack<>();
        for (char ch : string.toCharArray())
        {
            if (ch == '(' || ch == '{' || ch == '[') {

                charStack.push(ch);
            }
            else{
                    if (charStack.isEmpty()) {
                       System.out.println("NO Opening Parentesis");
                    }
                    char top=charStack.pop();
                if ((ch == ')' && top != '(') || (ch == '}' && top != '{') || (ch == ']' && top != '[')) {
                    System.out.println("NO Matching Parentesis");
                }
            }
        }
        if(charStack.isEmpty())
        {
            System.out.println(" Matching Parentesis");
        }
    }
}
