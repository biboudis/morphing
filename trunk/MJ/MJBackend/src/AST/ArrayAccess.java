
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;


public class ArrayAccess extends Access implements Cloneable {
    public void flushCache() {
        super.flushCache();
        type_computed = false;
        type_value = null;
    }
    public Object clone() throws CloneNotSupportedException {
        ArrayAccess node = (ArrayAccess)super.clone();
        node.type_computed = false;
        node.type_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          ArrayAccess node = (ArrayAccess)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        ArrayAccess res = (ArrayAccess)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in PrettyPrint.jadd at line 633


  public void toString(StringBuffer s) {
    s.append("[");
    getExpr().toString(s);
    s.append("]");
  }

    // Declared in TypeCheck.jrag at line 126

          
  // 15.13
  public void typeCheck() {
    if(isQualified() && !qualifier().type().isArrayDecl() && !qualifier().type().isUnknown())
      error("the type " + qualifier().type().name() + " of the indexed element is not an array");
    if(!getExpr().type().unaryNumericPromotion().isInt() || !getExpr().type().isIntegralType())
      error("array index must be int after unary numeric promotion which " + getExpr().type().typeName() + " is not");
  }

    // Declared in CodeGeneration.jrag at line 677

  
  public void emitStore(CodeGeneration gen) {
    gen.emit(type().arrayStore());
  }

    // Declared in CreateBCode.jrag at line 311

  public void createAssignSimpleLoadDest(CodeGeneration gen) {
    prevExpr().createBCode(gen);
    getExpr().createBCode(gen);
  }

    // Declared in CreateBCode.jrag at line 328

  public void createPushAssignmentResult(CodeGeneration gen) {
    type().emitDup_x2(gen);
  }

    // Declared in CreateBCode.jrag at line 359

  public void createAssignLoadDest(CodeGeneration gen) {
    prevExpr().createBCode(gen);
    gen.emitDup();
    getExpr().createBCode(gen);
    typeInt().emitDup_x1(gen);
    gen.emit(type().arrayLoad());
  }

    // Declared in CreateBCode.jrag at line 591

  
  public void createBCode(CodeGeneration gen) {
    prevExpr().createBCode(gen);
    getExpr().createBCode(gen);
    gen.emit(type().arrayLoad());
  }

    // Declared in java.ast at line 3
    // Declared in java.ast line 27

    public ArrayAccess() {
        super();

        setChild(null, 0);

    }

    // Declared in java.ast at line 11


    // Declared in java.ast line 27
    public ArrayAccess(Expr p0) {
        setChild(p0, 0);
    }

    // Declared in java.ast at line 15


  protected int numChildren() {
    return 1;
  }

    // Declared in java.ast at line 18

  public boolean mayHaveRewrite() { return false; }

    // Declared in java.ast at line 2
    // Declared in java.ast line 27
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

    // Declared in DefiniteAssignment.jrag at line 345
    public boolean isDAafter(Variable v) {
        boolean isDAafter_Variable_value = isDAafter_compute(v);
        return isDAafter_Variable_value;
    }

    private boolean isDAafter_compute(Variable v) {  return  getExpr().isDAafter(v);  }

    // Declared in DefiniteAssignment.jrag at line 833
    public boolean isDUafter(Variable v) {
        boolean isDUafter_Variable_value = isDUafter_compute(v);
        return isDUafter_Variable_value;
    }

    private boolean isDUafter_compute(Variable v) {  return  getExpr().isDUafter(v);  }

    // Declared in ResolveAmbiguousNames.jrag at line 34
    public boolean isArrayAccess() {
        boolean isArrayAccess_value = isArrayAccess_compute();
        return isArrayAccess_value;
    }

    private boolean isArrayAccess_compute() {  return  true;  }

    // Declared in SyntacticClassification.jrag at line 90
    public NameType predNameType() {
        NameType predNameType_value = predNameType_compute();
        return predNameType_value;
    }

    private NameType predNameType_compute() {  return  NameType.EXPRESSION_NAME;  }

    // Declared in TypeAnalysis.jrag at line 281
    public TypeDecl type() {
        if(type_computed)
            return type_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        type_value = type_compute();
        if(isFinal && num == boundariesCrossed)
            type_computed = true;
        return type_value;
    }

    private TypeDecl type_compute() {  return  isQualified() ? qualifier().type().componentType() : unknownType();  }

    // Declared in TypeCheck.jrag at line 9
    public boolean isVariable() {
        boolean isVariable_value = isVariable_compute();
        return isVariable_value;
    }

    private boolean isVariable_compute() {  return  true;  }

    // Declared in TypeAnalysis.jrag at line 282
    public TypeDecl unknownType() {
        TypeDecl unknownType_value = getParent().Define_TypeDecl_unknownType(this, null);
        return unknownType_value;
    }

    // Declared in DefiniteAssignment.jrag at line 26
    public boolean Define_boolean_isSource(ASTNode caller, ASTNode child) {
        if(caller == getExprNoTransform()) {
            return  true;
        }
        return getParent().Define_boolean_isSource(this, caller);
    }

    // Declared in LookupVariable.jrag at line 126
    public SimpleSet Define_SimpleSet_lookupVariable(ASTNode caller, ASTNode child, String name) {
        if(caller == getExprNoTransform()) {
            return  unqualifiedScope().lookupVariable(name);
        }
        return getParent().Define_SimpleSet_lookupVariable(this, caller, name);
    }

    // Declared in LookupMethod.jrag at line 19
    public Collection Define_Collection_lookupMethod(ASTNode caller, ASTNode child, String name) {
        if(caller == getExprNoTransform()) {
            return  unqualifiedScope().lookupMethod(name);
        }
        return getParent().Define_Collection_lookupMethod(this, caller, name);
    }

    // Declared in LookupType.jrag at line 81
    public boolean Define_boolean_hasPackage(ASTNode caller, ASTNode child, String packageName) {
        if(caller == getExprNoTransform()) {
            return  unqualifiedScope().hasPackage(packageName);
        }
        return getParent().Define_boolean_hasPackage(this, caller, packageName);
    }

    // Declared in DefiniteAssignment.jrag at line 25
    public boolean Define_boolean_isDest(ASTNode caller, ASTNode child) {
        if(caller == getExprNoTransform()) {
            return  false;
        }
        return getParent().Define_boolean_isDest(this, caller);
    }

    // Declared in SyntacticClassification.jrag at line 112
    public NameType Define_NameType_nameType(ASTNode caller, ASTNode child) {
        if(caller == getExprNoTransform()) {
            return  NameType.EXPRESSION_NAME;
        }
        return getParent().Define_NameType_nameType(this, caller);
    }

    // Declared in LookupType.jrag at line 170
    public SimpleSet Define_SimpleSet_lookupType(ASTNode caller, ASTNode child, String name) {
        if(caller == getExprNoTransform()) {
            return  unqualifiedScope().lookupType(name);
        }
        return getParent().Define_SimpleSet_lookupType(this, caller, name);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
