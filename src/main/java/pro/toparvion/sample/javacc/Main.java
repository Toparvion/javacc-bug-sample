package pro.toparvion.sample.javacc;

import java.io.StringReader;

/**
 * @author Vladimir Plizga
 */
public class Main {
    
    public static void main(String[] args) {
        var input = args.length > 0 ? args[0] : "1+2;";
        System.out.println("Expression: " + input);
        System.out.println();

        var parser = new ExpressionParser(new StringReader(input));
        try {
            SimpleNode root = parser.Start();
            
            var visitor = new TestVisitor();
            root.jjtAccept(visitor, null);
            
        } catch (Exception e) {
            System.out.println("Parsing failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}