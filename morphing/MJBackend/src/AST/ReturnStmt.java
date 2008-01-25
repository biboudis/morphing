
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;

public class ReturnStmt extends Stmt implements Cloneable {
    public void flushCache() {
        super.flushCache();
        finallyList_computed = false;
        finallyList_value = null;
        isDAafter_Variable_values = null;
        isDUafterReachedFinallyBlocks_Variable_values = null;
        isDAafterReachedFinallyBlocks_Variable_values = null;
        isDUafter_Variable_values = null;
        canCompleteNormally_computed = false;
        resultSaveLocalNum_computed = false;
    }
    public Object clone() throws CloneNotSupportedException {
        ReturnStmt node = (ReturnStmt)super.clone();
        node.finallyList_computed = false;
        node.finallyList_value = null;
        node.isDAafter_Variable_values = null;
        node.isDUafterReachedFinallyBlocks_Variable_values = null;
        node.isDAafterReachedFinallyBlocks_Variable_values = null;
        node.isDUafter_Variable_values = null;
        node.canCompleteNormally_computed = false;
        node.resultSaveLocalNum_computed = false;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          ReturnStmt node = (ReturnStmt)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        ReturnStmt res = (ReturnStmt)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in BranchTarget.jrag at line 46

  public void collectBranches(Collection c) {
    c.add(this);
  }

    // Declared in NodeConstructors.jrag at line 57


  public ReturnStmt(Expr expr) {
    this(new Opt(expr));
  }

    // Declared in PrettyPrint.jadd at line 826


  public void toString(StringBuffer s) {
    super.toString(s);
    s.append("return ");
    if(hasResult()) {
      getResult().toString(s);
    }
    s.append(";\n");
  }

    // Declared in TypeCheck.jrag at line 397


  public void typeCheck() {
    if(hasResult() && !returnType().isVoid()) {
      if(!getResult().type().assignConversionTo(returnType(), getResult()))
        error("return value must be an instance of " + returnType().typeName() + " which " + getResult().type().typeName() + " is not");
    }
    // 8.4.5 8.8.5
    if(returnType().isVoid() && hasResult())
      error("return stmt may not have an expression in void methods");
    // 8.4.5
    if(!returnType().isVoid() && !hasResult())
      error("return stmt must have an expression in non void methods");
    if(hostBodyDecl() instanceof InstanceInitializer || hostBodyDecl() instanceof StaticInitializer)
      error("Initializers may not return");

  }

    // Declared in CreateBCode.jrag at line 1499


  public void createBCode(CodeGeneration gen) {
    super.createBCode(gen);
    if(hasResult()) {
      TypeDecl type = null;
      BodyDecl b = hostBodyDecl();
      if(b instanceof MethodDecl) {
        type = ((MethodDecl)b).type();
      }
      else {
        throw new Error("Can not create code that returns value within non method");
      }
      getResult().createBCode(gen);
      getResult().type().emitCastTo(gen, type);
      if(!finallyList().isEmpty()) {
        type.emitStoreLocal(gen, resultSaveLocalNum());
      }
      for(Iterator iter = finallyList().iterator(); iter.hasNext(); ) {
        FinallyHost stmt = (FinallyHost)iter.next();
        gen.emitJsr(stmt.label_finally_block());
      }
      if(!finallyList().isEmpty()) {
        type.emitLoadLocal(gen, resultSaveLocalNum());
      }
      type.emitReturn(gen);
    }
    else {
      for(Iterator iter = finallyList().iterator(); iter.hasNext(); ) {
        FinallyHost stmt = (FinallyHost)iter.next();
        gen.emitJsr(stmt.label_finally_block());
      }
      gen.emitReturn();
    }
  }

    // Declared in java.ast at line 3
    // Declared in java.ast line 218

    public ReturnStmt() {
        super();

        setChild(new Opt(), 0);

    }

    // Declared in java.ast at line 11


    // Declared in java.ast line 218
    public ReturnStmt(Opt p0) {
        setChild(p0, 0);
    }

    // Declared in java.ast at line 15


  protected int numChildren() {
    return 1;
  }

    // Declared in java.ast at line 18

  public boolean mayHaveRewrite() { return false; }

    // Declared in java.ast at line 2
    // Declared in java.ast line 218
    public void setResultOpt(Opt opt) {
        setChild(opt, 0);
    }

    // Declared in java.ast at line 6


    public boolean hasResult() {
        return getResultOpt().getNumChild() != 0;
    }

    // Declared in java.ast at line 10


    public Expr getResult() {
        return (Expr)getResultOpt().getChild(0);
    }

    // Declared in java.ast at line 14


    public void setResult(Expr node) {
        getResultOpt().setChild(node, 0);
    }

    // Declared in java.ast at line 17

    public Opt getResultOpt() {
        return (Opt)getChild(0);
    }

    // Declared in java.ast at line 21


    public Opt getResultOptNoTransform() {
        return (Opt)getChildNoTransform(0);
    }

    protected boolean finallyList_computed = false;
    protected ArrayList finallyList_value;
    // Declared in BranchTarget.jrag at line 177
    public ArrayList finallyList() {
        if(finallyList_computed)
            return finallyList_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        finallyList_value = finallyList_compute();
        if(isFinal && num == boundariesCrossed)
            finallyList_computed = true;
        return finallyList_value;
    }

    private ArrayList finallyList_compute()  {
    ArrayList list = new ArrayList();
    collectFinally(this, list);
    return list;
  }

    // Declared in DefiniteAssignment.jrag at line 643
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

    protected java.util.Map isDUafterReachedFinallyBlocks_Variable_values;
    // Declared in DefiniteAssignment.jrag at line 945
    public boolean isDUafterReachedFinallyBlocks(Variable v) {
        Object _parameters = v;
if(isDUafterReachedFinallyBlocks_Variable_values == null) isDUafterReachedFinallyBlocks_Variable_values = new java.util.HashMap(4);
        if(isDUafterReachedFinallyBlocks_Variable_values.containsKey(_parameters))
            return ((Boolean)isDUafterReachedFinallyBlocks_Variable_values.get(_parameters)).booleanValue();
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        boolean isDUafterReachedFinallyBlocks_Variable_value = isDUafterReachedFinallyBlocks_compute(v);
        if(isFinal && num == boundariesCrossed)
            isDUafterReachedFinallyBlocks_Variable_values.put(_parameters, Boolean.valueOf(isDUafterReachedFinallyBlocks_Variable_value));
        return isDUafterReachedFinallyBlocks_Variable_value;
    }

    private boolean isDUafterReachedFinallyBlocks_compute(Variable v)  {
    if(!isDUbefore(v) && finallyList().isEmpty())
      return false;
    for(Iterator iter = finallyList().iterator(); iter.hasNext(); ) {
      FinallyHost f = (FinallyHost)iter.next();
      if(!f.isDUafterFinally(v))
        return false;
    }
    return true;
  }

    protected java.util.Map isDAafterReachedFinallyBlocks_Variable_values;
    // Declared in DefiniteAssignment.jrag at line 981
    public boolean isDAafterReachedFinallyBlocks(Variable v) {
        Object _parameters = v;
if(isDAafterReachedFinallyBlocks_Variable_values == null) isDAafterReachedFinallyBlocks_Variable_values = new java.util.HashMap(4);
        if(isDAafterReachedFinallyBlocks_Variable_values.containsKey(_parameters))
            return ((Boolean)isDAafterReachedFinallyBlocks_Variable_values.get(_parameters)).booleanValue();
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        boolean isDAafterReachedFinallyBlocks_Variable_value = isDAafterReachedFinallyBlocks_compute(v);
        if(isFinal && num == boundariesCrossed)
            isDAafterReachedFinallyBlocks_Variable_values.put(_parameters, Boolean.valueOf(isDAafterReachedFinallyBlocks_Variable_value));
        return isDAafterReachedFinallyBlocks_Variable_value;
    }

    private boolean isDAafterReachedFinallyBlocks_compute(Variable v)  {
    if(hasResult() ? getResult().isDAafter(v) : isDAbefore(v))
      return true;
    if(finallyList().isEmpty())
      return false;
    for(Iterator iter = finallyList().iterator(); iter.hasNext(); ) {
      FinallyHost f = (FinallyHost)iter.next();
      if(!f.isDAafterFinally(v))
        return false;
    }
    return true;
  }

    // Declared in DefiniteAssignment.jrag at line 1184
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

    // Declared in UnreachableStatements.jrag at line 98
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

    // Declared in CodeGeneration.jrag at line 7
    public int sourceLineNumber() {
        int sourceLineNumber_value = sourceLineNumber_compute();
        return sourceLineNumber_value;
    }

    private int sourceLineNumber_compute()  {
    int num = super.sourceLineNumber();
    if(num != -1)
      return num;
    if(hasResult()) {
      num = getResult().findFirstSourceLineNumber();
      if(num != -1)
        return num;
    }
    return getLine(getParent().getParent().getEnd());
  }

    // Declared in TypeCheck.jrag at line 392
    public TypeDecl returnType() {
        TypeDecl returnType_value = getParent().Define_TypeDecl_returnType(this, null);
        return returnType_value;
    }

    protected boolean resultSaveLocalNum_computed = false;
    protected int resultSaveLocalNum_value;
    // Declared in LocalNum.jrag at line 25
    public int resultSaveLocalNum() {
        if(resultSaveLocalNum_computed)
            return resultSaveLocalNum_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        resultSaveLocalNum_value = getParent().Define_int_resultSaveLocalNum(this, null);
        if(isFinal && num == boundariesCrossed)
            resultSaveLocalNum_computed = true;
        return resultSaveLocalNum_value;
    }

    // Declared in GenericMethodsInference.jrag at line 29
    public TypeDecl Define_TypeDecl_assignConvertedType(ASTNode caller, ASTNode child) {
        if(caller == getResultOptNoTransform()) {
            return  returnType();
        }
        return getParent().Define_TypeDecl_assignConvertedType(this, caller);
    }

    // Declared in DefiniteAssignment.jrag at line 646
    public boolean Define_boolean_isDAbefore(ASTNode caller, ASTNode child, Variable v) {
        if(caller == getResultOptNoTransform()) {
            return  isDAbefore(v);
        }
        return getParent().Define_boolean_isDAbefore(this, caller, v);
    }

    // Declared in DefiniteAssignment.jrag at line 1187
    public boolean Define_boolean_isDUbefore(ASTNode caller, ASTNode child, Variable v) {
        if(caller == getResultOptNoTransform()) {
            return  isDUbefore(v);
        }
        return getParent().Define_boolean_isDUbefore(this, caller, v);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}