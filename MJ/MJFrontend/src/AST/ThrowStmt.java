
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;

public class ThrowStmt extends Stmt implements Cloneable {
    public void flushCache() {
        super.flushCache();
        isDAafter_Variable_values = null;
        isDUafter_Variable_values = null;
        canCompleteNormally_computed = false;
        typeNullPointerException_computed = false;
        typeNullPointerException_value = null;
        handlesException_TypeDecl_values = null;
        typeThrowable_computed = false;
        typeThrowable_value = null;
        typeNull_computed = false;
        typeNull_value = null;
    }
    public Object clone() throws CloneNotSupportedException {
        ThrowStmt node = (ThrowStmt)super.clone();
        node.isDAafter_Variable_values = null;
        node.isDUafter_Variable_values = null;
        node.canCompleteNormally_computed = false;
        node.typeNullPointerException_computed = false;
        node.typeNullPointerException_value = null;
        node.handlesException_TypeDecl_values = null;
        node.typeThrowable_computed = false;
        node.typeThrowable_value = null;
        node.typeNull_computed = false;
        node.typeNull_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          ThrowStmt node = (ThrowStmt)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        ThrowStmt res = (ThrowStmt)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in AnonymousClasses.jrag at line 131


  protected void collectExceptions(Collection c, ASTNode target) {
    super.collectExceptions(c, target);
    TypeDecl exceptionType = getExpr().type();
    if(exceptionType == typeNull())
      exceptionType = typeNullPointerException();
    c.add(exceptionType);
  }

    // Declared in ExceptionHandling.jrag at line 96


  public void exceptionHandling() {
    TypeDecl exceptionType = getExpr().type();
    if(exceptionType == typeNull())
      exceptionType = typeNullPointerException();
    // 8.4.4
    if(!handlesException(exceptionType))
      error("" + this + " throws uncaught exception " + exceptionType.fullName());
  }

    // Declared in ExceptionHandling.jrag at line 224

  
  protected boolean reachedException(TypeDecl catchType) {
    TypeDecl exceptionType = getExpr().type();
    if(exceptionType == typeNull())
      exceptionType = typeNullPointerException();
    if(catchType.mayCatch(exceptionType))
      return true;
    return super.reachedException(catchType);
  }

    // Declared in PrettyPrint.jadd at line 835


  public void toString(StringBuffer s) {
    super.toString(s);
    s.append("throw ");
    getExpr().toString(s);
    s.append(";\n");
  }

    // Declared in TypeCheck.jrag at line 362


  public void typeCheck() {
    if(!getExpr().type().instanceOf(typeThrowable()))
      error("*** The thrown expression must extend Throwable");
  }

    // Declared in java.ast at line 3
    // Declared in java.ast line 219

    public ThrowStmt() {
        super();

        setChild(null, 0);

    }

    // Declared in java.ast at line 11


    // Declared in java.ast line 219
    public ThrowStmt(Expr p0) {
        setChild(p0, 0);
    }

    // Declared in java.ast at line 15


  protected int numChildren() {
    return 1;
  }

    // Declared in java.ast at line 18

  public boolean mayHaveRewrite() { return false; }

    // Declared in java.ast at line 2
    // Declared in java.ast line 219
    public void setExpr(Expr node) {
        setChild(node, 0);
    }

    // Declared in java.ast at line 5

    public Expr getExpr() {
        return (Expr)getChild(0);
    }

    // Declared in java.ast at line 9


    public Expr getExprNoTransform() {
        return (Expr)getChildNoTransform(0);
    }

    // Declared in DefiniteAssignment.jrag at line 644
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

    private boolean isDAafter_compute(Variable v) {  return  true;  }

    // Declared in DefiniteAssignment.jrag at line 1185
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

    private boolean isDUafter_compute(Variable v) {  return  true;  }

    // Declared in UnreachableStatements.jrag at line 99
    public boolean canCompleteNormally() {
        if(canCompleteNormally_computed)
            return canCompleteNormally_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        canCompleteNormally_value = canCompleteNormally_compute();
        if(isFinal && num == boundariesCrossed)
            canCompleteNormally_computed = true;
        return canCompleteNormally_value;
    }

    private boolean canCompleteNormally_compute() {  return  false;  }

    protected boolean typeNullPointerException_computed = false;
    protected TypeDecl typeNullPointerException_value;
    // Declared in ExceptionHandling.jrag at line 11
    public TypeDecl typeNullPointerException() {
        if(typeNullPointerException_computed)
            return typeNullPointerException_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        typeNullPointerException_value = getParent().Define_TypeDecl_typeNullPointerException(this, null);
        if(isFinal && num == boundariesCrossed)
            typeNullPointerException_computed = true;
        return typeNullPointerException_value;
    }

    protected java.util.Map handlesException_TypeDecl_values;
    // Declared in ExceptionHandling.jrag at line 22
    public boolean handlesException(TypeDecl exceptionType) {
        Object _parameters = exceptionType;
if(handlesException_TypeDecl_values == null) handlesException_TypeDecl_values = new java.util.HashMap(4);
        if(handlesException_TypeDecl_values.containsKey(_parameters))
            return ((Boolean)handlesException_TypeDecl_values.get(_parameters)).booleanValue();
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        boolean handlesException_TypeDecl_value = getParent().Define_boolean_handlesException(this, null, exceptionType);
        if(isFinal && num == boundariesCrossed)
            handlesException_TypeDecl_values.put(_parameters, Boolean.valueOf(handlesException_TypeDecl_value));
        return handlesException_TypeDecl_value;
    }

    protected boolean typeThrowable_computed = false;
    protected TypeDecl typeThrowable_value;
    // Declared in LookupType.jrag at line 58
    public TypeDecl typeThrowable() {
        if(typeThrowable_computed)
            return typeThrowable_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        typeThrowable_value = getParent().Define_TypeDecl_typeThrowable(this, null);
        if(isFinal && num == boundariesCrossed)
            typeThrowable_computed = true;
        return typeThrowable_value;
    }

    protected boolean typeNull_computed = false;
    protected TypeDecl typeNull_value;
    // Declared in LookupType.jrag at line 61
    public TypeDecl typeNull() {
        if(typeNull_computed)
            return typeNull_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        typeNull_value = getParent().Define_TypeDecl_typeNull(this, null);
        if(isFinal && num == boundariesCrossed)
            typeNull_computed = true;
        return typeNull_value;
    }

    // Declared in DefiniteAssignment.jrag at line 647
    public boolean Define_boolean_isDAbefore(ASTNode caller, ASTNode child, Variable v) {
        if(caller == getExprNoTransform()) {
            return  isDAbefore(v);
        }
        return getParent().Define_boolean_isDAbefore(this, caller, v);
    }

    // Declared in DefiniteAssignment.jrag at line 1188
    public boolean Define_boolean_isDUbefore(ASTNode caller, ASTNode child, Variable v) {
        if(caller == getExprNoTransform()) {
            return  isDUbefore(v);
        }
        return getParent().Define_boolean_isDUbefore(this, caller, v);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
