
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;

public abstract class Case extends Stmt implements Cloneable {
    public void flushCache() {
        super.flushCache();
        isDAbefore_Variable_values = null;
        isDAafter_Variable_values = null;
        isDUafter_Variable_values = null;
        bind_Case_values = null;
    }
    public Object clone() throws CloneNotSupportedException {
        Case node = (Case)super.clone();
        node.isDAbefore_Variable_values = null;
        node.isDAafter_Variable_values = null;
        node.isDUafter_Variable_values = null;
        node.bind_Case_values = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in java.ast at line 3
    // Declared in java.ast line 207

    public Case() {
        super();


    }

    // Declared in java.ast at line 9


  protected int numChildren() {
    return 0;
  }

    // Declared in java.ast at line 12

  public boolean mayHaveRewrite() { return false; }

    // Declared in NameCheck.jrag at line 421
    public abstract boolean constValue(Case c);
    protected java.util.Map isDAbefore_Variable_values;
    // Declared in DefiniteAssignment.jrag at line 564
    public boolean isDAbefore(Variable v) {
        Object _parameters = v;
if(isDAbefore_Variable_values == null) isDAbefore_Variable_values = new java.util.HashMap(4);
        if(isDAbefore_Variable_values.containsKey(_parameters))
            return ((Boolean)isDAbefore_Variable_values.get(_parameters)).booleanValue();
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        boolean isDAbefore_Variable_value = isDAbefore_compute(v);
        if(isFinal && num == boundariesCrossed)
            isDAbefore_Variable_values.put(_parameters, Boolean.valueOf(isDAbefore_Variable_value));
        return isDAbefore_Variable_value;
    }

    private boolean isDAbefore_compute(Variable v) {  return  
    getParent().getParent() instanceof Block && ((Block)getParent().getParent()).isDAbefore(v)
    && super.isDAbefore(v);  }

    // Declared in DefiniteAssignment.jrag at line 568
    public boolean isDAafter(Variable v) {
        Object _parameters = v;
if(isDAafter_Variable_values == null) isDAafter_Variable_values = new java.util.HashMap(4);
        if(isDAafter_Variable_values.containsKey(_parameters))
            return ((Boolean)isDAafter_Variable_values.get(_parameters)).booleanValue();
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        boolean isDAafter_Variable_value = isDAafter_compute(v);
        if(isFinal && num == boundariesCrossed)
            isDAafter_Variable_values.put(_parameters, Boolean.valueOf(isDAafter_Variable_value));
        return isDAafter_Variable_value;
    }

    private boolean isDAafter_compute(Variable v) {  return  isDAbefore(v);  }

    // Declared in DefiniteAssignment.jrag at line 1028
    public boolean isDUbefore(Variable v) {
        boolean isDUbefore_Variable_value = isDUbefore_compute(v);
        return isDUbefore_Variable_value;
    }

    private boolean isDUbefore_compute(Variable v) {  return 
    getParent().getParent() instanceof Block && ((Block)getParent().getParent()).isDUbefore(v)
    && super.isDUbefore(v);  }

    // Declared in DefiniteAssignment.jrag at line 1032
    public boolean isDUafter(Variable v) {
        Object _parameters = v;
if(isDUafter_Variable_values == null) isDUafter_Variable_values = new java.util.HashMap(4);
        if(isDUafter_Variable_values.containsKey(_parameters))
            return ((Boolean)isDUafter_Variable_values.get(_parameters)).booleanValue();
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        boolean isDUafter_Variable_value = isDUafter_compute(v);
        if(isFinal && num == boundariesCrossed)
            isDUafter_Variable_values.put(_parameters, Boolean.valueOf(isDUafter_Variable_value));
        return isDUafter_Variable_value;
    }

    private boolean isDUafter_compute(Variable v) {  return  isDUbefore(v);  }

    // Declared in UnreachableStatements.jrag at line 74
    public boolean reachable() {
        boolean reachable_value = reachable_compute();
        return reachable_value;
    }

    private boolean reachable_compute() {  return  getParent().getParent() instanceof Block && ((Block)getParent().getParent()).reachable();  }

    protected java.util.Map bind_Case_values;
    // Declared in NameCheck.jrag at line 407
    public Case bind(Case c) {
        Object _parameters = c;
if(bind_Case_values == null) bind_Case_values = new java.util.HashMap(4);
        if(bind_Case_values.containsKey(_parameters))
            return (Case)bind_Case_values.get(_parameters);
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        Case bind_Case_value = getParent().Define_Case_bind(this, null, c);
        if(isFinal && num == boundariesCrossed)
            bind_Case_values.put(_parameters, bind_Case_value);
        return bind_Case_value;
    }

    // Declared in TypeCheck.jrag at line 347
    public TypeDecl switchType() {
        TypeDecl switchType_value = getParent().Define_TypeDecl_switchType(this, null);
        return switchType_value;
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
