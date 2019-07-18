/*
Nested Parens
Donovan Griego
*/


public class NestedParens{
    public static boolean nestParen(String str)
    {
	    int len = str.length();
	    if(len == 0)
		    return true;
	    if(str.charAt(0) == '(' && str.charAt(len - 1) == ')')
			return nestParen(str.substring(1, len - 1));
    	return false;
    }

    public static void main(String args[]){
        boolean status;
        if (args.length != 1) {
            System.err.println("Incorrect argument count: " + args.length);
            System.err.println("Usage: java NestedParens ______");
            System.exit(1);
        }
        status = nestParen(args[0]);
        System.out.println("Nested Parentheses: " + status);
    }

}