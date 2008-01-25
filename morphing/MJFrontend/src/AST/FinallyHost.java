
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;


  public interface FinallyHost {
    // Declared in DefiniteAssignment.jrag at line 910

    //public Block getFinally();
    public boolean isDUafterFinally(Variable v);

    // Declared in DefiniteAssignment.jrag at line 911

    public boolean isDAafterFinally(Variable v);

}
