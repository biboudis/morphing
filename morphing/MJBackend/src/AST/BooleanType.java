
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;

public class BooleanType extends PrimitiveType implements Cloneable {
    public void flushCache() {
        super.flushCache();
        typeDescriptor_computed = false;
        typeDescriptor_value = null;
        boxed_computed = false;
        boxed_value = null;
    }
    public Object clone() throws CloneNotSupportedException {
        BooleanType node = (BooleanType)super.clone();
        node.typeDescriptor_computed = false;
        node.typeDescriptor_value = null;
        node.boxed_computed = false;
        node.boxed_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          BooleanType node = (BooleanType)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        BooleanType res = (BooleanType)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in Attributes.jrag at line 53

  public int addConstant(ConstantPool p, Constant c)  { return p.addConstant(c.booleanValue() ? 1 : 0); }

    // Declared in CodeGeneration.jrag at line 453


  public static void push(CodeGeneration gen, boolean value) {
    gen.emit(value ? Bytecode.ICONST_1 : Bytecode.ICONST_0);
  }

    // Declared in CodeGeneration.jrag at line 910

  void refined_CodeGeneration_emitCastTo(CodeGeneration gen, TypeDecl type)  { }

    // Declared in CodeGeneration.jrag at line 1008

  void logNot(CodeGeneration gen) { gen.emit(Bytecode.ICONST_1).emit(Bytecode.IXOR); }

    // Declared in CodeGeneration.jrag at line 1055

  void bitand(CodeGeneration gen) {gen.emit(Bytecode.IAND);}

    // Declared in CodeGeneration.jrag at line 1060

  void bitor(CodeGeneration gen) {gen.emit(Bytecode.IOR);}

    // Declared in CodeGeneration.jrag at line 1065

  void bitxor(CodeGeneration gen) {gen.emit(Bytecode.IXOR);}

    // Declared in CodeGeneration.jrag at line 1098

  public void branchEQ(CodeGeneration gen, int label)   { gen.emitCompare(Bytecode.IF_ICMPEQ, label); }

    // Declared in CodeGeneration.jrag at line 1107

  public void branchNE(CodeGeneration gen, int label)   { gen.emitCompare(Bytecode.IF_ICMPNE, label); }

    // Declared in java.ast at line 3
    // Declared in java.ast line 50

    public BooleanType() {
        super();

        setChild(null, 0);
        setChild(new Opt(), 1);
        setChild(new List(), 2);

    }

    // Declared in java.ast at line 13


    // Declared in java.ast line 50
    public BooleanType(Modifiers p0, String p1, Opt p2, List p3) {
        setChild(p0, 0);
        setID(p1);
        setChild(p2, 1);
        setChild(p3, 2);
    }

    // Declared in java.ast at line 20


  protected int numChildren() {
    return 3;
  }

    // Declared in java.ast at line 23

  public boolean mayHaveRewrite() { return false; }

    // Declared in java.ast at line 2
    // Declared in java.ast line 41
    public void setModifiers(Modifiers node) {
        setChild(node, 0);
    }

    // Declared in java.ast at line 5

    public Modifiers getModifiers() {
        return (Modifiers)getChild(0);
    }

    // Declared in java.ast at line 9


    public Modifiers getModifiersNoTransform() {
        return (Modifiers)getChildNoTransform(0);
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 41
    private String tokenString_ID;

    // Declared in java.ast at line 3

    public void setID(String value) {
        tokenString_ID = value;
    }

    // Declared in java.ast at line 6

    public String getID() {
        return tokenString_ID;
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 41
    public void setSuperClassAccessOpt(Opt opt) {
        setChild(opt, 1);
    }

    // Declared in java.ast at line 6


    public boolean hasSuperClassAccess() {
        return getSuperClassAccessOpt().getNumChild() != 0;
    }

    // Declared in java.ast at line 10


    public Access getSuperClassAccess() {
        return (Access)getSuperClassAccessOpt().getChild(0);
    }

    // Declared in java.ast at line 14


    public void setSuperClassAccess(Access node) {
        getSuperClassAccessOpt().setChild(node, 0);
    }

    // Declared in java.ast at line 17

    public Opt getSuperClassAccessOpt() {
        return (Opt)getChild(1);
    }

    // Declared in java.ast at line 21


    public Opt getSuperClassAccessOptNoTransform() {
        return (Opt)getChildNoTransform(1);
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 41
    public void setBodyDeclList(List list) {
        setChild(list, 2);
    }

    // Declared in java.ast at line 6


    public int getNumBodyDecl() {
        return getBodyDeclList().getNumChild();
    }

    // Declared in java.ast at line 10


    public BodyDecl getBodyDecl(int i) {
        return (BodyDecl)getBodyDeclList().getChild(i);
    }

    // Declared in java.ast at line 14


    public void addBodyDecl(BodyDecl node) {
        List list = getBodyDeclList();
        list.setChild(node, list.getNumChild());
    }

    // Declared in java.ast at line 19


    public void setBodyDecl(BodyDecl node, int i) {
        List list = getBodyDeclList();
        list.setChild(node, i);
    }

    // Declared in java.ast at line 23

    public List getBodyDeclList() {
        return (List)getChild(2);
    }

    // Declared in java.ast at line 27


    public List getBodyDeclListNoTransform() {
        return (List)getChildNoTransform(2);
    }

    // Declared in AutoBoxingCodegen.jrag at line 3

    // Code generation for Boxing Conversion
    void emitCastTo(CodeGeneration gen, TypeDecl type) {
    if(type.unboxed() == this || type.isObject())
      boxed().emitBoxingOperation(gen);
  }

    // Declared in ConstantExpression.jrag at line 284
    public Constant cast(Constant c) {
        Constant cast_Constant_value = cast_compute(c);
        return cast_Constant_value;
    }

    private Constant cast_compute(Constant c) {  return  Constant.create(c.booleanValue());  }

    // Declared in ConstantExpression.jrag at line 385
    public Constant andBitwise(Constant c1, Constant c2) {
        Constant andBitwise_Constant_Constant_value = andBitwise_compute(c1, c2);
        return andBitwise_Constant_Constant_value;
    }

    private Constant andBitwise_compute(Constant c1, Constant c2) {  return  Constant.create(c1.booleanValue() & c2.booleanValue());  }

    // Declared in ConstantExpression.jrag at line 393
    public Constant xorBitwise(Constant c1, Constant c2) {
        Constant xorBitwise_Constant_Constant_value = xorBitwise_compute(c1, c2);
        return xorBitwise_Constant_Constant_value;
    }

    private Constant xorBitwise_compute(Constant c1, Constant c2) {  return  Constant.create(c1.booleanValue() ^ c2.booleanValue());  }

    // Declared in ConstantExpression.jrag at line 401
    public Constant orBitwise(Constant c1, Constant c2) {
        Constant orBitwise_Constant_Constant_value = orBitwise_compute(c1, c2);
        return orBitwise_Constant_Constant_value;
    }

    private Constant orBitwise_compute(Constant c1, Constant c2) {  return  Constant.create(c1.booleanValue() | c2.booleanValue());  }

    // Declared in ConstantExpression.jrag at line 411
    public Constant questionColon(Constant cond, Constant c1, Constant c2) {
        Constant questionColon_Constant_Constant_Constant_value = questionColon_compute(cond, c1, c2);
        return questionColon_Constant_Constant_Constant_value;
    }

    private Constant questionColon_compute(Constant cond, Constant c1, Constant c2) {  return  Constant.create(cond.booleanValue() ? c1.booleanValue() : c2.booleanValue());  }

    // Declared in ConstantExpression.jrag at line 515
    public boolean eqIsTrue(Expr left, Expr right) {
        boolean eqIsTrue_Expr_Expr_value = eqIsTrue_compute(left, right);
        return eqIsTrue_Expr_Expr_value;
    }

    private boolean eqIsTrue_compute(Expr left, Expr right) {  return  left.isTrue() && right.isTrue() || left.isFalse() && right.isFalse();  }

    // Declared in TypeAnalysis.jrag at line 173
    public boolean isBoolean() {
        boolean isBoolean_value = isBoolean_compute();
        return isBoolean_value;
    }

    private boolean isBoolean_compute() {  return  true;  }

    // Declared in CodeGeneration.jrag at line 589
    public byte arrayLoad() {
        byte arrayLoad_value = arrayLoad_compute();
        return arrayLoad_value;
    }

    private byte arrayLoad_compute() {  return  Bytecode.BALOAD;  }

    // Declared in CodeGeneration.jrag at line 691
    public byte arrayStore() {
        byte arrayStore_value = arrayStore_compute();
        return arrayStore_value;
    }

    private byte arrayStore_compute() {  return  Bytecode.BASTORE;  }

    // Declared in ConstantPoolNames.jrag at line 8
    public String typeDescriptor() {
        if(typeDescriptor_computed)
            return typeDescriptor_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        typeDescriptor_value = typeDescriptor_compute();
        if(isFinal && num == boundariesCrossed)
            typeDescriptor_computed = true;
        return typeDescriptor_value;
    }

    private String typeDescriptor_compute() {  return  "Z";  }

    // Declared in CreateBCode.jrag at line 881
    public int arrayPrimitiveTypeDescriptor() {
        int arrayPrimitiveTypeDescriptor_value = arrayPrimitiveTypeDescriptor_compute();
        return arrayPrimitiveTypeDescriptor_value;
    }

    private int arrayPrimitiveTypeDescriptor_compute() {  return  4;  }

    // Declared in Java2Rewrites.jrag at line 15
    public String primitiveClassName() {
        String primitiveClassName_value = primitiveClassName_compute();
        return primitiveClassName_value;
    }

    private String primitiveClassName_compute() {  return  "Boolean";  }

    // Declared in AutoBoxing.jrag at line 27
    public TypeDecl boxed() {
        if(boxed_computed)
            return boxed_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        boxed_value = boxed_compute();
        if(isFinal && num == boundariesCrossed)
            boxed_computed = true;
        return boxed_value;
    }

    private TypeDecl boxed_compute() {  return  lookupType("java.lang", "Boolean");  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
