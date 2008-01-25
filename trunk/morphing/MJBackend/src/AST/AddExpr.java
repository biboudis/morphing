
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;

public class AddExpr extends AdditiveExpr implements Cloneable {
    public void flushCache() {
        super.flushCache();
        type_computed = false;
        type_value = null;
    }
    public Object clone() throws CloneNotSupportedException {
        AddExpr node = (AddExpr)super.clone();
        node.type_computed = false;
        node.type_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          AddExpr node = (AddExpr)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        AddExpr res = (AddExpr)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in PrettyPrint.jadd at line 510


  public void printOp(StringBuffer s) {
    s.append(" + ");
  }

    // Declared in TypeCheck.jrag at line 161

  
  // 15.18
  public void typeCheck() {
    TypeDecl left = getLeftOperand().type();
    TypeDecl right = getRightOperand().type();
    if(!left.isString() && !right.isString())
      super.typeCheck();
    else if(left.isVoid())
      error("The type void of the left hand side is not numeric");
    else if(right.isVoid())
      error("The type void of the right hand side is not numeric");
  }

    // Declared in CodeGeneration.jrag at line 984


  // binary
  void emitOperation(CodeGeneration gen) { type().add(gen); }

    // Declared in CreateBCode.jrag at line 967


  public void createBCode(CodeGeneration gen) {
    if(!type().isString())
      super.createBCode(gen);
    else {
      TypeDecl stringBuffer = lookupType("java.lang", "StringBuffer");
      String classname = stringBuffer.constantPoolName();
      String desc;
      int index;
      TypeDecl argumentType;
      if(firstStringAddPart()) {
        stringBuffer.emitNew(gen); // new StringBuffer
        gen.emitDup();             // dup
        desc = "()V";
        index = gen.constantPool().addMethodref(classname, "<init>", desc);
        gen.emit(Bytecode.INVOKESPECIAL, -1).add2(index); // invokespecial StringBuffer()
        getLeftOperand().createBCode(gen); // left
        argumentType = getLeftOperand().type().stringPromotion();
        desc = "(" + argumentType.typeDescriptor() + ")" + stringBuffer.typeDescriptor();
        index = gen.constantPool().addMethodref(classname, "append", desc);
        gen.emit(Bytecode.INVOKEVIRTUAL, -argumentType.variableSize()).add2(index); // StringBuffer.append
      }
      else {
        getLeftOperand().createBCode(gen);
      }
      getRightOperand().createBCode(gen); // right
      argumentType = getRightOperand().type().stringPromotion();
      desc = "(" + argumentType.typeDescriptor() + ")" + stringBuffer.typeDescriptor();
      index = gen.constantPool().addMethodref(classname, "append", desc);
      gen.emit(Bytecode.INVOKEVIRTUAL, -argumentType.variableSize()).add2(index); // StringBuffer.append
      if(lastStringAddPart()) {
        desc = "()" + type().typeDescriptor();
        index = gen.constantPool().addMethodref(classname, "toString", desc);
        gen.emit(Bytecode.INVOKEVIRTUAL, 0).add2(index); // StringBuffer.toString
      }
    }
  }

    // Declared in java.ast at line 3
    // Declared in java.ast line 162

    public AddExpr() {
        super();

        setChild(null, 0);
        setChild(null, 1);

    }

    // Declared in java.ast at line 12


    // Declared in java.ast line 162
    public AddExpr(Expr p0, Expr p1) {
        setChild(p0, 0);
        setChild(p1, 1);
    }

    // Declared in java.ast at line 17


  protected int numChildren() {
    return 2;
  }

    // Declared in java.ast at line 20

  public boolean mayHaveRewrite() { return false; }

    // Declared in java.ast at line 2
    // Declared in java.ast line 154
    public void setLeftOperand(Expr node) {
        setChild(node, 0);
    }

    // Declared in java.ast at line 5

    public Expr getLeftOperand() {
        return (Expr)getChild(0);
    }

    // Declared in java.ast at line 9


    public Expr getLeftOperandNoTransform() {
        return (Expr)getChildNoTransform(0);
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 154
    public void setRightOperand(Expr node) {
        setChild(node, 1);
    }

    // Declared in java.ast at line 5

    public Expr getRightOperand() {
        return (Expr)getChild(1);
    }

    // Declared in java.ast at line 9


    public Expr getRightOperandNoTransform() {
        return (Expr)getChildNoTransform(1);
    }

    // Declared in ConstantExpression.jrag at line 104
    public Constant constant() {
        Constant constant_value = constant_compute();
        return constant_value;
    }

    private Constant constant_compute() {  return  type().add(getLeftOperand().constant(), getRightOperand().constant());  }

    // Declared in TypeAnalysis.jrag at line 325
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

    private TypeDecl type_compute()  {
    TypeDecl left = getLeftOperand().type();
    TypeDecl right = getRightOperand().type();
    if(!left.isString() && !right.isString())
      return super.type();
    else {
      if(left.isVoid() || right.isVoid())
        return unknownType();
      // pick the string type
      return left.isString() ? left : right;
    }
  }

    // Declared in CreateBCode.jrag at line 962
    public boolean isStringAdd() {
        boolean isStringAdd_value = isStringAdd_compute();
        return isStringAdd_value;
    }

    private boolean isStringAdd_compute() {  return  type().isString();  }

    // Declared in CreateBCode.jrag at line 964
    public boolean firstStringAddPart() {
        boolean firstStringAddPart_value = firstStringAddPart_compute();
        return firstStringAddPart_value;
    }

    private boolean firstStringAddPart_compute() {  return  !getLeftOperand().isStringAdd() && type().isString();  }

    // Declared in CreateBCode.jrag at line 965
    public boolean lastStringAddPart() {
        boolean lastStringAddPart_value = lastStringAddPart_compute();
        return lastStringAddPart_value;
    }

    private boolean lastStringAddPart_compute() {  return  !getParent().isStringAdd();  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
