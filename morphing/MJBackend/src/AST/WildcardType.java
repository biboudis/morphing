
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;

public class WildcardType extends AbstractWildcardType implements Cloneable {
    public void flushCache() {
        super.flushCache();
        instanceOf_TypeDecl_values = null;
        fieldTypeSignature_computed = false;
        fieldTypeSignature_value = null;
    }
    public Object clone() throws CloneNotSupportedException {
        WildcardType node = (WildcardType)super.clone();
        node.instanceOf_TypeDecl_values = null;
        node.fieldTypeSignature_computed = false;
        node.fieldTypeSignature_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          WildcardType node = (WildcardType)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        WildcardType res = (WildcardType)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in Generics.ast at line 3
    // Declared in Generics.ast line 26

    public WildcardType() {
        super();

        setChild(null, 0);
        setChild(new List(), 1);

    }

    // Declared in Generics.ast at line 12


    // Declared in Generics.ast line 26
    public WildcardType(Modifiers p0, String p1, List p2) {
        setChild(p0, 0);
        setID(p1);
        setChild(p2, 1);
    }

    // Declared in Generics.ast at line 18


  protected int numChildren() {
    return 2;
  }

    // Declared in Generics.ast at line 21

  public boolean mayHaveRewrite() { return false; }

    // Declared in java.ast at line 2
    // Declared in java.ast line 37
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
    // Declared in java.ast line 37
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
    // Declared in java.ast line 37
    public void setBodyDeclList(List list) {
        setChild(list, 1);
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
        return (List)getChild(1);
    }

    // Declared in java.ast at line 27


    public List getBodyDeclListNoTransform() {
        return (List)getChildNoTransform(1);
    }

    // Declared in Generics.jrag at line 451
    public boolean sameSignature(Access a) {
        boolean sameSignature_Access_value = sameSignature_compute(a);
        return sameSignature_Access_value;
    }

    private boolean sameSignature_compute(Access a)  {
    if(a instanceof Wildcard)
      return true;
    return super.sameSignature(a);
  }

    protected java.util.Set subtype_TypeDecl_visited;
    protected java.util.Set subtype_TypeDecl_computed = new java.util.HashSet(4);
    protected java.util.Set subtype_TypeDecl_initialized = new java.util.HashSet(4);
    protected java.util.Map subtype_TypeDecl_values = new java.util.HashMap(4);
    public boolean subtype(TypeDecl type) {
        Object _parameters = type;
if(subtype_TypeDecl_visited == null) subtype_TypeDecl_visited = new java.util.HashSet(4);
if(subtype_TypeDecl_values == null) subtype_TypeDecl_values = new java.util.HashMap(4);
        if(subtype_TypeDecl_computed.contains(_parameters))
            return ((Boolean)subtype_TypeDecl_values.get(_parameters)).booleanValue();
        if (!subtype_TypeDecl_initialized.contains(_parameters)) {
            subtype_TypeDecl_initialized.add(_parameters);
            subtype_TypeDecl_values.put(_parameters, Boolean.valueOf(true));
        }
        if (!IN_CIRCLE) {
            IN_CIRCLE = true;
            subtype_TypeDecl_visited.add(_parameters);
            int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
            boolean new_subtype_TypeDecl_value;
            do {
                CHANGE = false;
                new_subtype_TypeDecl_value = subtype_compute(type);
                if (new_subtype_TypeDecl_value!=((Boolean)subtype_TypeDecl_values.get(_parameters)).booleanValue())
                    CHANGE = true;
                subtype_TypeDecl_values.put(_parameters, Boolean.valueOf(new_subtype_TypeDecl_value));
            } while (CHANGE);
            subtype_TypeDecl_visited.remove(_parameters);
            if(isFinal && num == boundariesCrossed)
{
            subtype_TypeDecl_computed.add(_parameters);
            }
            else {
            RESET_CYCLE = true;
            subtype_compute(type);
            RESET_CYCLE = false;
            subtype_TypeDecl_computed.remove(_parameters);
            subtype_TypeDecl_initialized.remove(_parameters);
            }
            IN_CIRCLE = false; 
            return new_subtype_TypeDecl_value;
        }
        if(!subtype_TypeDecl_visited.contains(_parameters)) {
            if (RESET_CYCLE) {
                subtype_TypeDecl_computed.remove(_parameters);
                subtype_TypeDecl_initialized.remove(_parameters);
                return ((Boolean)subtype_TypeDecl_values.get(_parameters)).booleanValue();
            }
            subtype_TypeDecl_visited.add(_parameters);
            boolean new_subtype_TypeDecl_value = subtype_compute(type);
            if (new_subtype_TypeDecl_value!=((Boolean)subtype_TypeDecl_values.get(_parameters)).booleanValue())
                CHANGE = true;
            subtype_TypeDecl_values.put(_parameters, Boolean.valueOf(new_subtype_TypeDecl_value));
            subtype_TypeDecl_visited.remove(_parameters);
            return new_subtype_TypeDecl_value;
        }
        return ((Boolean)subtype_TypeDecl_values.get(_parameters)).booleanValue();
    }

    private boolean subtype_compute(TypeDecl type) {  return  type.supertypeWildcard(this);  }

    // Declared in GenericsSubtype.jrag at line 38
    public boolean supertypeWildcard(WildcardType type) {
        boolean supertypeWildcard_WildcardType_value = supertypeWildcard_compute(type);
        return supertypeWildcard_WildcardType_value;
    }

    private boolean supertypeWildcard_compute(WildcardType type) {  return 
    true;  }

    // Declared in GenericsSubtype.jrag at line 49
    public boolean supertypeWildcardExtends(WildcardExtendsType type) {
        boolean supertypeWildcardExtends_WildcardExtendsType_value = supertypeWildcardExtends_compute(type);
        return supertypeWildcardExtends_WildcardExtendsType_value;
    }

    private boolean supertypeWildcardExtends_compute(WildcardExtendsType type) {  return  
    true;  }

    // Declared in GenericsSubtype.jrag at line 58
    public boolean supertypeWildcardSuper(WildcardSuperType type) {
        boolean supertypeWildcardSuper_WildcardSuperType_value = supertypeWildcardSuper_compute(type);
        return supertypeWildcardSuper_WildcardSuperType_value;
    }

    private boolean supertypeWildcardSuper_compute(WildcardSuperType type) {  return  
    true;  }

    // Declared in GenericsSubtype.jrag at line 66
    public boolean supertypeClassDecl(ClassDecl type) {
        boolean supertypeClassDecl_ClassDecl_value = supertypeClassDecl_compute(type);
        return supertypeClassDecl_ClassDecl_value;
    }

    private boolean supertypeClassDecl_compute(ClassDecl type) {  return  true;  }

    // Declared in GenericsSubtype.jrag at line 67
    public boolean supertypeInterfaceDecl(InterfaceDecl type) {
        boolean supertypeInterfaceDecl_InterfaceDecl_value = supertypeInterfaceDecl_compute(type);
        return supertypeInterfaceDecl_InterfaceDecl_value;
    }

    private boolean supertypeInterfaceDecl_compute(InterfaceDecl type) {  return  true;  }

    // Declared in GenericsSubtype.jrag at line 68
    public boolean supertypeParClassDecl(ParClassDecl type) {
        boolean supertypeParClassDecl_ParClassDecl_value = supertypeParClassDecl_compute(type);
        return supertypeParClassDecl_ParClassDecl_value;
    }

    private boolean supertypeParClassDecl_compute(ParClassDecl type) {  return  true;  }

    // Declared in GenericsSubtype.jrag at line 69
    public boolean supertypeParInterfaceDecl(ParInterfaceDecl type) {
        boolean supertypeParInterfaceDecl_ParInterfaceDecl_value = supertypeParInterfaceDecl_compute(type);
        return supertypeParInterfaceDecl_ParInterfaceDecl_value;
    }

    private boolean supertypeParInterfaceDecl_compute(ParInterfaceDecl type) {  return  true;  }

    // Declared in GenericsSubtype.jrag at line 70
    public boolean supertypeRawClassDecl(RawClassDecl type) {
        boolean supertypeRawClassDecl_RawClassDecl_value = supertypeRawClassDecl_compute(type);
        return supertypeRawClassDecl_RawClassDecl_value;
    }

    private boolean supertypeRawClassDecl_compute(RawClassDecl type) {  return  true;  }

    // Declared in GenericsSubtype.jrag at line 71
    public boolean supertypeRawInterfaceDecl(RawInterfaceDecl type) {
        boolean supertypeRawInterfaceDecl_RawInterfaceDecl_value = supertypeRawInterfaceDecl_compute(type);
        return supertypeRawInterfaceDecl_RawInterfaceDecl_value;
    }

    private boolean supertypeRawInterfaceDecl_compute(RawInterfaceDecl type) {  return  true;  }

    // Declared in GenericsSubtype.jrag at line 72
    public boolean supertypeTypeVariable(TypeVariable type) {
        boolean supertypeTypeVariable_TypeVariable_value = supertypeTypeVariable_compute(type);
        return supertypeTypeVariable_TypeVariable_value;
    }

    private boolean supertypeTypeVariable_compute(TypeVariable type) {  return  true;  }

    // Declared in GenericsSubtype.jrag at line 73
    public boolean supertypeArrayDecl(ArrayDecl type) {
        boolean supertypeArrayDecl_ArrayDecl_value = supertypeArrayDecl_compute(type);
        return supertypeArrayDecl_ArrayDecl_value;
    }

    private boolean supertypeArrayDecl_compute(ArrayDecl type) {  return  true;  }

    // Declared in GenericsSubtype.jrag at line 222
    public boolean instanceOf(TypeDecl type) {
        Object _parameters = type;
if(instanceOf_TypeDecl_values == null) instanceOf_TypeDecl_values = new java.util.HashMap(4);
        if(instanceOf_TypeDecl_values.containsKey(_parameters))
            return ((Boolean)instanceOf_TypeDecl_values.get(_parameters)).booleanValue();
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        boolean instanceOf_TypeDecl_value = instanceOf_compute(type);
        if(isFinal && num == boundariesCrossed)
            instanceOf_TypeDecl_values.put(_parameters, Boolean.valueOf(instanceOf_TypeDecl_value));
        return instanceOf_TypeDecl_value;
    }

    private boolean instanceOf_compute(TypeDecl type) {  return  subtype(type);  }

    // Declared in GenericsCodegen.jrag at line 407
    public String fieldTypeSignature() {
        if(fieldTypeSignature_computed)
            return fieldTypeSignature_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        fieldTypeSignature_value = fieldTypeSignature_compute();
        if(isFinal && num == boundariesCrossed)
            fieldTypeSignature_computed = true;
        return fieldTypeSignature_value;
    }

    private String fieldTypeSignature_compute() {  return  "*";  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}