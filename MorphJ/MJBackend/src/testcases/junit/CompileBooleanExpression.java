package testcases.junit;

import java.io.File;

import org.junit.Test;


public class CompileBooleanExpression extends MJTestCase {

    @Test
    public void testBooleanExpr() {
	assertTrue(compileMJTest("BooleanExprTest.java"));
    }
}
