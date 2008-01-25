
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;

public abstract class IntegralType extends NumericType implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
    public Object clone() throws CloneNotSupportedException {
        IntegralType node = (IntegralType)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in Attributes.jrag at line 54
 
  public int addConstant(ConstantPool p, Constant c) { return p.addConstant(c.intValue()); }

    // Declared in CodeGeneration.jrag at line 460


  public void emitPushConstant(CodeGeneration gen, int value) {
    IntType.push(gen, value);
  }

    // Declared in CodeGeneration.jrag at line 950

  void byteToThis(CodeGeneration gen) { }

    // Declared in CodeGeneration.jrag at line 957

  void charToThis(CodeGeneration gen) { }

    // Declared in CodeGeneration.jrag at line 965

  void shortToThis(CodeGeneration gen) { }

    // Declared in CodeGeneration.jrag at line 998

  void neg(CodeGeneration gen) { gen.emit(Bytecode.INEG); }

    // Declared in CodeGeneration.jrag at line 1004

  void bitNot(CodeGeneration gen) { gen.emit(Bytecode.ICONST_M1).emit(Bytecode.IXOR); }

    // Declared in CodeGeneration.jrag at line 1014

  void add(CodeGeneration gen) {gen.emit(Bytecode.IADD);}

    // Declared in CodeGeneration.jrag at line 1020

  void sub(CodeGeneration gen) {gen.emit(Bytecode.ISUB);}

    // Declared in CodeGeneration.jrag at line 1026

  void mul(CodeGeneration gen) {gen.emit(Bytecode.IMUL);}

    // Declared in CodeGeneration.jrag at line 1032

  void div(CodeGeneration gen) {gen.emit(Bytecode.IDIV);}

    // Declared in CodeGeneration.jrag at line 1038

  void rem(CodeGeneration gen) {gen.emit(Bytecode.IREM);}

    // Declared in CodeGeneration.jrag at line 1042

  void shl(CodeGeneration gen) {gen.emit(Bytecode.ISHL);}

    // Declared in CodeGeneration.jrag at line 1046

  void shr(CodeGeneration gen) {gen.emit(Bytecode.ISHR);}

    // Declared in CodeGeneration.jrag at line 1050

  void ushr(CodeGeneration gen) {gen.emit(Bytecode.IUSHR);}

    // Declared in CodeGeneration.jrag at line 1054

  void bitand(CodeGeneration gen) {gen.emit(Bytecode.IAND);}

    // Declared in CodeGeneration.jrag at line 1059

  void bitor(CodeGeneration gen) {gen.emit(Bytecode.IOR);}

    // Declared in CodeGeneration.jrag at line 1064

  void bitxor(CodeGeneration gen) {gen.emit(Bytecode.IXOR);}

    // Declared in CodeGeneration.jrag at line 1073

  public void branchLT(CodeGeneration gen, int label) { gen.emitCompare(Bytecode.IF_ICMPLT, label); }

    // Declared in CodeGeneration.jrag at line 1079

  public void branchLE(CodeGeneration gen, int label) { gen.emitCompare(Bytecode.IF_ICMPLE, label); }

    // Declared in CodeGeneration.jrag at line 1085

  public void branchGE(CodeGeneration gen, int label) { gen.emitCompare(Bytecode.IF_ICMPGE, label); }

    // Declared in CodeGeneration.jrag at line 1091

  public void branchGT(CodeGeneration gen, int label) { gen.emitCompare(Bytecode.IF_ICMPGT, label); }

    // Declared in CodeGeneration.jrag at line 1097

  public void branchEQ(CodeGeneration gen, int label)  { gen.emitCompare(Bytecode.IF_ICMPEQ, label); }

    // Declared in CodeGeneration.jrag at line 1106

  public void branchNE(CodeGeneration gen, int label)  { gen.emitCompare(Bytecode.IF_ICMPNE, label); }

    // Declared in java.ast at line 3
    // Declared in java.ast line 51

    public IntegralType() {
        super();

        setChild(null, 0);
        setChild(new Opt(), 1);
        setChild(new List(), 2);

    }

    // Declared in java.ast at line 13


    // Declared in java.ast line 51
    public IntegralType(Modifiers p0, String p1, Opt p2, List p3) {
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

    // Declared in ConstantExpression.jrag at line 277
    public Constant cast(Constant c) {
        Constant cast_Constant_value = cast_compute(c);
        return cast_Constant_value;
    }

    private Constant cast_compute(Constant c) {  return  Constant.create(c.intValue());  }

    // Declared in ConstantExpression.jrag at line 291
    public Constant plus(Constant c) {
        Constant plus_Constant_value = plus_compute(c);
        return plus_Constant_value;
    }

    private Constant plus_compute(Constant c) {  return  c;  }

    // Declared in ConstantExpression.jrag at line 300
    public Constant minus(Constant c) {
        Constant minus_Constant_value = minus_compute(c);
        return minus_Constant_value;
    }

    private Constant minus_compute(Constant c) {  return  Constant.create(-c.intValue());  }

    // Declared in ConstantExpression.jrag at line 309
    public Constant bitNot(Constant c) {
        Constant bitNot_Constant_value = bitNot_compute(c);
        return bitNot_Constant_value;
    }

    private Constant bitNot_compute(Constant c) {  return  Constant.create(~c.intValue());  }

    // Declared in ConstantExpression.jrag at line 316
    public Constant mul(Constant c1, Constant c2) {
        Constant mul_Constant_Constant_value = mul_compute(c1, c2);
        return mul_Constant_Constant_value;
    }

    private Constant mul_compute(Constant c1, Constant c2) {  return  Constant.create(c1.intValue() * c2.intValue());  }

    // Declared in ConstantExpression.jrag at line 325
    public Constant div(Constant c1, Constant c2) {
        Constant div_Constant_Constant_value = div_compute(c1, c2);
        return div_Constant_Constant_value;
    }

    private Constant div_compute(Constant c1, Constant c2) {  return  Constant.create(c1.intValue() / c2.intValue());  }

    // Declared in ConstantExpression.jrag at line 334
    public Constant mod(Constant c1, Constant c2) {
        Constant mod_Constant_Constant_value = mod_compute(c1, c2);
        return mod_Constant_Constant_value;
    }

    private Constant mod_compute(Constant c1, Constant c2) {  return  Constant.create(c1.intValue() % c2.intValue());  }

    // Declared in ConstantExpression.jrag at line 343
    public Constant add(Constant c1, Constant c2) {
        Constant add_Constant_Constant_value = add_compute(c1, c2);
        return add_Constant_Constant_value;
    }

    private Constant add_compute(Constant c1, Constant c2) {  return  Constant.create(c1.intValue() + c2.intValue());  }

    // Declared in ConstantExpression.jrag at line 353
    public Constant sub(Constant c1, Constant c2) {
        Constant sub_Constant_Constant_value = sub_compute(c1, c2);
        return sub_Constant_Constant_value;
    }

    private Constant sub_compute(Constant c1, Constant c2) {  return  Constant.create(c1.intValue() - c2.intValue());  }

    // Declared in ConstantExpression.jrag at line 362
    public Constant lshift(Constant c1, Constant c2) {
        Constant lshift_Constant_Constant_value = lshift_compute(c1, c2);
        return lshift_Constant_Constant_value;
    }

    private Constant lshift_compute(Constant c1, Constant c2) {  return  Constant.create(c1.intValue() << c2.intValue());  }

    // Declared in ConstantExpression.jrag at line 369
    public Constant rshift(Constant c1, Constant c2) {
        Constant rshift_Constant_Constant_value = rshift_compute(c1, c2);
        return rshift_Constant_Constant_value;
    }

    private Constant rshift_compute(Constant c1, Constant c2) {  return  Constant.create(c1.intValue() >> c2.intValue());  }

    // Declared in ConstantExpression.jrag at line 376
    public Constant urshift(Constant c1, Constant c2) {
        Constant urshift_Constant_Constant_value = urshift_compute(c1, c2);
        return urshift_Constant_Constant_value;
    }

    private Constant urshift_compute(Constant c1, Constant c2) {  return  Constant.create(c1.intValue() >>> c2.intValue());  }

    // Declared in ConstantExpression.jrag at line 383
    public Constant andBitwise(Constant c1, Constant c2) {
        Constant andBitwise_Constant_Constant_value = andBitwise_compute(c1, c2);
        return andBitwise_Constant_Constant_value;
    }

    private Constant andBitwise_compute(Constant c1, Constant c2) {  return  Constant.create(c1.intValue() & c2.intValue());  }

    // Declared in ConstantExpression.jrag at line 391
    public Constant xorBitwise(Constant c1, Constant c2) {
        Constant xorBitwise_Constant_Constant_value = xorBitwise_compute(c1, c2);
        return xorBitwise_Constant_Constant_value;
    }

    private Constant xorBitwise_compute(Constant c1, Constant c2) {  return  Constant.create(c1.intValue() ^ c2.intValue());  }

    // Declared in ConstantExpression.jrag at line 399
    public Constant orBitwise(Constant c1, Constant c2) {
        Constant orBitwise_Constant_Constant_value = orBitwise_compute(c1, c2);
        return orBitwise_Constant_Constant_value;
    }

    private Constant orBitwise_compute(Constant c1, Constant c2) {  return  Constant.create(c1.intValue() | c2.intValue());  }

    // Declared in ConstantExpression.jrag at line 407
    public Constant questionColon(Constant cond, Constant c1, Constant c2) {
        Constant questionColon_Constant_Constant_Constant_value = questionColon_compute(cond, c1, c2);
        return questionColon_Constant_Constant_Constant_value;
    }

    private Constant questionColon_compute(Constant cond, Constant c1, Constant c2) {  return  Constant.create(cond.booleanValue() ? c1.intValue() : c2.intValue());  }

    // Declared in ConstantExpression.jrag at line 511
    public boolean eqIsTrue(Expr left, Expr right) {
        boolean eqIsTrue_Expr_Expr_value = eqIsTrue_compute(left, right);
        return eqIsTrue_Expr_Expr_value;
    }

    private boolean eqIsTrue_compute(Expr left, Expr right) {  return  left.constant().intValue() == right.constant().intValue();  }

    // Declared in ConstantExpression.jrag at line 519
    public boolean ltIsTrue(Expr left, Expr right) {
        boolean ltIsTrue_Expr_Expr_value = ltIsTrue_compute(left, right);
        return ltIsTrue_Expr_Expr_value;
    }

    private boolean ltIsTrue_compute(Expr left, Expr right) {  return  left.constant().intValue() < right.constant().intValue();  }

    // Declared in ConstantExpression.jrag at line 525
    public boolean leIsTrue(Expr left, Expr right) {
        boolean leIsTrue_Expr_Expr_value = leIsTrue_compute(left, right);
        return leIsTrue_Expr_Expr_value;
    }

    private boolean leIsTrue_compute(Expr left, Expr right) {  return  left.constant().intValue() <= right.constant().intValue();  }

    // Declared in NameCheck.jrag at line 418
    public boolean assignableToInt() {
        boolean assignableToInt_value = assignableToInt_compute();
        return assignableToInt_value;
    }

    private boolean assignableToInt_compute() {  return  true;  }

    // Declared in TypeAnalysis.jrag at line 169
    public boolean isIntegralType() {
        boolean isIntegralType_value = isIntegralType_compute();
        return isIntegralType_value;
    }

    private boolean isIntegralType_compute() {  return  true;  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
