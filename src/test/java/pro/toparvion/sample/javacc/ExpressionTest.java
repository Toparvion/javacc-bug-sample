package pro.toparvion.sample.javacc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.ThrowingSupplier;

import java.io.StringReader;

class ExpressionTest {

    @Test
    @DisplayName("First token of AddNode corresponds to the actual character")
    void testAddNodeChildTokens() throws ParseException {
        // given 
        var expression = "1 + 2;";
        var parser = new ExpressionParser(new StringReader(expression));

        // when
        ASTStart root = parser.Start();
        SimpleNode addNode = (SimpleNode) root.jjtGetChild(0);
        Token firstToken = addNode.jjtGetFirstToken();
        Token lastToken = addNode.jjtGetLastToken();

        //then
        assertAll(
                () -> assertEquals("1", firstToken.image,
                        "First token of AddNode must be 1 but is " + firstToken.image),
                () -> assertNotSame(lastToken, firstToken, 
                        "First token of AddNode must differ from the last one")
                );
    }

    @Test
    @DisplayName("Combination of addition and subtraction gets parsed OK")
    void testAddAndSubtractCombination() {
        // given
        var expression = "1 + 2 - 3;";
        var parser = new ExpressionParser(new StringReader(expression));
        
        // when
        ThrowingSupplier<ASTStart> parsing = parser::Start;

        //then
        assertDoesNotThrow(parsing);
    }
}