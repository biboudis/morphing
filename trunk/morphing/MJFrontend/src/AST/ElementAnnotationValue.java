
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;

public class ElementAnnotationValue extends ElementValue implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
    public Object clone() throws CloneNotSupportedException {
        ElementAnnotationValue node = (ElementAnnotationValue)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          ElementAnnotationValue node = (ElementAnnotationValue)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        ElementAnnotationValue res = (ElementAnnotationValue)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in Annotations.ast at line 3
    // Declared in Annotations.ast line 12

    public ElementAnnotationValue() {
        super();

        setChild(null, 0);

    }

    // Declared in Annotations.ast at line 11


    // Declared in Annotations.ast line 12
    public ElementAnnotationValue(Annotation p0) {
        setChild(p0, 0);
    }

    // Declared in Annotations.ast at line 15


  protected int numChildren() {
    return 1;
  }

    // Declared in Annotations.ast at line 18

  public boolean mayHaveRewrite() { return false; }

    // Declared in Annotations.ast at line 2
    // Declared in Annotations.ast line 12
    public void setAnnotation(Annotation node) {
        setChild(node, 0);
    }

    // Declared in Annotations.ast at line 5

    public Annotation getAnnotation() {
        return (Annotation)getChild(0);
    }

    // Declared in Annotations.ast at line 9


    public Annotation getAnnotationNoTransform() {
        return (Annotation)getChildNoTransform(0);
    }

    // Declared in Annotations.jrag at line 484
    public boolean commensurateWithTypeDecl(TypeDecl type) {
        boolean commensurateWithTypeDecl_TypeDecl_value = commensurateWithTypeDecl_compute(type);
        return commensurateWithTypeDecl_TypeDecl_value;
    }

    private boolean commensurateWithTypeDecl_compute(TypeDecl type)  {
    return type() == type;
  }

    // Declared in Annotations.jrag at line 504
    public TypeDecl type() {
        TypeDecl type_value = type_compute();
        return type_value;
    }

    private TypeDecl type_compute() {  return  getAnnotation().type();  }

    // Declared in Annotations.jrag at line 419
    public Annotation lookupAnnotation(TypeDecl typeDecl) {
        Annotation lookupAnnotation_TypeDecl_value = getParent().Define_Annotation_lookupAnnotation(this, null, typeDecl);
        return lookupAnnotation_TypeDecl_value;
    }

    // Declared in Annotations.jrag at line 423
    public Annotation Define_Annotation_lookupAnnotation(ASTNode caller, ASTNode child, TypeDecl typeDecl) {
        if(caller == getAnnotationNoTransform()) {
            return 
    getAnnotation().type() == typeDecl ? getAnnotation() : lookupAnnotation(typeDecl);
        }
        return getParent().Define_Annotation_lookupAnnotation(this, caller, typeDecl);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
