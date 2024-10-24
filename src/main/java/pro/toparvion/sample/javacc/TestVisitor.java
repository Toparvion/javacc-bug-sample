package pro.toparvion.sample.javacc;

public class TestVisitor extends ExpressionParserDefaultVisitor {
    private int indent = 0;

    @Override
    public Object defaultVisit(SimpleNode node, Object data) {
        String sb = String.format("%s%s: %s...%s",
                " ".repeat(indent),
                node,
                node.jjtGetFirstToken(),
                node.jjtGetLastToken().image);

        System.out.println(sb);

        indent++;
        node.childrenAccept(this, data);
        indent--;
        
        return data;
    }
}

