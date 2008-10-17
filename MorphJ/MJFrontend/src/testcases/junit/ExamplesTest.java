package testcases.junit;

import org.junit.Test;
import java.util.*;

import AST.*;
import main.*;
import java.io.File;

public class ExamplesTest extends MJTestCase {
    /*
     * @Test public void testDefaultImpelmentation() { Collection<Problem>
     * actualProblems = checkExample( "DefaultImplementation.java", new
     * String[]{"-verbose"}, true); Collection<Problem> expectedProblems = new
     * ArrayList<Problem>(); compareProblems(expectedProblems, actualProblems); }
     * 
     * @Test public void testSychronizeMe() { Collection<Problem>
     * actualProblems = checkExample( "SynchronizeMe.java", new
     * String[]{"-verbose"}, true); Collection<Problem> expectedProblems = new
     * ArrayList<Problem>(); compareProblems(expectedProblems, actualProblems); }
     * 
     * @Test public void testGetterSetter() { Collection<Problem>
     * actualProblems = checkExample( "GetterSetter.java", new
     * String[]{"-verbose"}, true); Collection<Problem> expectedProblems = new
     * ArrayList<Problem>(); compareProblems(expectedProblems, actualProblems); }
     */
    @Test
    public void testDstm2() {
	java.util.List<Collection<Problem>> actualProblems = checkExample(
		new String[] { "dstm2fromClass/AtomicBase.java"
			,"dstm2fromClass/shadow/Recoverable.java"
			/*,"dstm2fromClass/shadow/ShadowGetterSetter.java"*/
			},
		new String[] { /* "-verbose" */ }, true);
	Collection<Problem> expectedProblems = new ArrayList<Problem>();

	for (Collection<Problem> p : actualProblems)
	    compareProblems(expectedProblems, p);
    }

}
