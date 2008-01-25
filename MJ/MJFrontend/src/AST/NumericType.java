
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;


// 4.2 Primitive Types and Values
public abstract class NumericType extends PrimitiveType implements Cloneable {
    public void flushCache() {
        super.flushCache();
        unaryNumericPromotion_computed = false;
        unaryNumericPromotion_value = null;
        binaryNumericPromotion_TypeDecl_values = null;
    }
    public Object clone() throws CloneNotSupportedException {
        NumericType node = (NumericType)super.clone();
        node.unaryNumericPromotion_computed = false;
        node.unaryNumericPromotion_value = null;
        node.binaryNumericPromotion_TypeDecl_values = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in java.ast at line 3
    // Declared in java.ast line 49

    public NumericType() {
        super();

        setChild(null, 0);
        setChild(new Opt(), 1);
        setChild(new List(), 2);

    }

    // Declared in java.ast at line 13


    // Declared in java.ast line 49
    public NumericType(Modifiers p0, String p1, Opt p2, List p3) {
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

    // Declared in TypeAnalysis.jrag at line 146
private TypeDecl refined_TypeAnalysis_binaryNumericPromotion_TypeDecl(TypeDecl type)
 {
    if(!type.isNumericType())
      return unknownType();
     return unaryNumericPromotion().instanceOf(type) ? type : unaryNumericPromotion();
  }

    protected boolean unaryNumericPromotion_computed = false;
    protected TypeDecl unaryNumericPromotion_value;
    // Declared in TypeAnalysis.jrag at line 139
    public TypeDecl unaryNumericPromotion() {
        if(unaryNumericPromotion_computed)
            return unaryNumericPromotion_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        unaryNumericPromotion_value = unaryNumericPromotion_compute();
        if(isFinal && num == boundariesCrossed)
            unaryNumericPromotion_computed = true;
        return unaryNumericPromotion_value;
    }

    private TypeDecl unaryNumericPromotion_compute() {  return  this;  }

    protected java.util.Map binaryNumericPromotion_TypeDecl_values;
    // Declared in AutoBoxing.jrag at line 111
    public TypeDecl binaryNumericPromotion(TypeDecl type) {
        Object _parameters = type;
if(binaryNumericPromotion_TypeDecl_values == null) binaryNumericPromotion_TypeDecl_values = new java.util.HashMap(4);
        if(binaryNumericPromotion_TypeDecl_values.containsKey(_parameters))
            return (TypeDecl)binaryNumericPromotion_TypeDecl_values.get(_parameters);
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        TypeDecl binaryNumericPromotion_TypeDecl_value = binaryNumericPromotion_compute(type);
        if(isFinal && num == boundariesCrossed)
            binaryNumericPromotion_TypeDecl_values.put(_parameters, binaryNumericPromotion_TypeDecl_value);
        return binaryNumericPromotion_TypeDecl_value;
    }

    private TypeDecl binaryNumericPromotion_compute(TypeDecl type)  {
    if(type.isReferenceType())
      type = type.unboxed();
    return refined_TypeAnalysis_binaryNumericPromotion_TypeDecl(type);
  }

    // Declared in TypeAnalysis.jrag at line 165
    public boolean isNumericType() {
        boolean isNumericType_value = isNumericType_compute();
        return isNumericType_value;
    }

    private boolean isNumericType_compute() {  return  true;  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
