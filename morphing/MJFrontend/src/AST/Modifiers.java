
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;


public class Modifiers extends ASTNode implements Cloneable {
    public void flushCache() {
        super.flushCache();
        isPublic_computed = false;
        isPrivate_computed = false;
        isProtected_computed = false;
        isStatic_computed = false;
        isFinal_computed = false;
        isAbstract_computed = false;
        isVolatile_computed = false;
        isTransient_computed = false;
        isStrictfp_computed = false;
        isSynchronized_computed = false;
        isNative_computed = false;
        isSynthetic_computed = false;
        numModifier_String_values = null;
    }
    public Object clone() throws CloneNotSupportedException {
        Modifiers node = (Modifiers)super.clone();
        node.isPublic_computed = false;
        node.isPrivate_computed = false;
        node.isProtected_computed = false;
        node.isStatic_computed = false;
        node.isFinal_computed = false;
        node.isAbstract_computed = false;
        node.isVolatile_computed = false;
        node.isTransient_computed = false;
        node.isStrictfp_computed = false;
        node.isSynchronized_computed = false;
        node.isNative_computed = false;
        node.isSynthetic_computed = false;
        node.numModifier_String_values = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          Modifiers node = (Modifiers)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        Modifiers res = (Modifiers)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in Modifiers.jrag at line 299


  // 8.4.3
  public void checkModifiers() {
    super.checkModifiers();
    if(numProtectionModifiers() > 1)
      error("only one public, protected, private allowed");
    if(numModifier("static") > 1)
      error("only one static allowed");
    // 8.4.3.1
    // 8.4.3.2
    // 8.1.1.2
    if(numCompletenessModifiers() > 1)
      error("only one of final, abstract, volatile allowed");
    if(numModifier("synchronized") > 1)
      error("only one synchronized allowed");
    if(numModifier("transient") > 1)
      error("only one transient allowed");
    if(numModifier("native") > 1)
      error("only one native allowed");
    if(numModifier("strictfp") > 1)
      error("only one strictfp allowed");

    if(isPublic() && !mayBePublic())
      error("modifier public not allowed in this context");
    if(isPrivate() && !mayBePrivate())
      error("modifier private not allowed in this context");
    if(isProtected() && !mayBeProtected())
      error("modifier protected not allowed in this context");
    if(isStatic() && !mayBeStatic())
      error("modifier static not allowed in this context");
    if(isFinal() && !mayBeFinal())
      error("modifier final not allowed in this context");
    if(isAbstract() && !mayBeAbstract())
      error("modifier abstract not allowed in this context");
    if(isVolatile() && !mayBeVolatile())
      error("modifier volatile not allowed in this context");
    if(isTransient() && !mayBeTransient())
      error("modifier transient not allowed in this context");
    if(isStrictfp() && !mayBeStrictfp())
      error("modifier strictfp not allowed in this context");
    if(isSynchronized() && !mayBeSynchronized())
      error("modifier synchronized not allowed in this context");
    if(isNative() && !mayBeNative())
      error("modifier native not allowed in this context");
  }

    // Declared in PrettyPrint.jadd at line 592


  public void toString(StringBuffer s) {
    for(int i = 0; i < getNumModifier(); i++) {
      getModifier(i).toString(s);
      s.append(" ");
    }
  }

    // Declared in java.ast at line 3
    // Declared in java.ast line 194

    public Modifiers() {
        super();

        setChild(new List(), 0);

    }

    // Declared in java.ast at line 11


    // Declared in java.ast line 194
    public Modifiers(List p0) {
        setChild(p0, 0);
    }

    // Declared in java.ast at line 15


  protected int numChildren() {
    return 1;
  }

    // Declared in java.ast at line 18

  public boolean mayHaveRewrite() { return false; }

    // Declared in java.ast at line 2
    // Declared in java.ast line 194
    public void setModifierList(List list) {
        setChild(list, 0);
    }

    // Declared in java.ast at line 6


    public int getNumModifier() {
        return getModifierList().getNumChild();
    }

    // Declared in java.ast at line 10


    public Modifier getModifier(int i) {
        return (Modifier)getModifierList().getChild(i);
    }

    // Declared in java.ast at line 14


    public void addModifier(Modifier node) {
        List list = getModifierList();
        list.setChild(node, list.getNumChild());
    }

    // Declared in java.ast at line 19


    public void setModifier(Modifier node, int i) {
        List list = getModifierList();
        list.setChild(node, i);
    }

    // Declared in java.ast at line 23

    public List getModifierList() {
        return (List)getChild(0);
    }

    // Declared in java.ast at line 27


    public List getModifierListNoTransform() {
        return (List)getChildNoTransform(0);
    }

    protected boolean isPublic_computed = false;
    protected boolean isPublic_value;
    // Declared in Modifiers.jrag at line 355
    public boolean isPublic() {
        if(isPublic_computed)
            return isPublic_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        isPublic_value = isPublic_compute();
        if(isFinal && num == boundariesCrossed)
            isPublic_computed = true;
        return isPublic_value;
    }

    private boolean isPublic_compute() {  return  numModifier("public") != 0;  }

    protected boolean isPrivate_computed = false;
    protected boolean isPrivate_value;
    // Declared in Modifiers.jrag at line 356
    public boolean isPrivate() {
        if(isPrivate_computed)
            return isPrivate_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        isPrivate_value = isPrivate_compute();
        if(isFinal && num == boundariesCrossed)
            isPrivate_computed = true;
        return isPrivate_value;
    }

    private boolean isPrivate_compute() {  return  numModifier("private") != 0;  }

    protected boolean isProtected_computed = false;
    protected boolean isProtected_value;
    // Declared in Modifiers.jrag at line 357
    public boolean isProtected() {
        if(isProtected_computed)
            return isProtected_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        isProtected_value = isProtected_compute();
        if(isFinal && num == boundariesCrossed)
            isProtected_computed = true;
        return isProtected_value;
    }

    private boolean isProtected_compute() {  return  numModifier("protected") != 0;  }

    protected boolean isStatic_computed = false;
    protected boolean isStatic_value;
    // Declared in Modifiers.jrag at line 358
    public boolean isStatic() {
        if(isStatic_computed)
            return isStatic_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        isStatic_value = isStatic_compute();
        if(isFinal && num == boundariesCrossed)
            isStatic_computed = true;
        return isStatic_value;
    }

    private boolean isStatic_compute() {  return  numModifier("static") != 0;  }

    protected boolean isFinal_computed = false;
    protected boolean isFinal_value;
    // Declared in Modifiers.jrag at line 359
    public boolean isFinal() {
        if(isFinal_computed)
            return isFinal_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        isFinal_value = isFinal_compute();
        if(isFinal && num == boundariesCrossed)
            isFinal_computed = true;
        return isFinal_value;
    }

    private boolean isFinal_compute() {  return  numModifier("final") != 0;  }

    protected boolean isAbstract_computed = false;
    protected boolean isAbstract_value;
    // Declared in Modifiers.jrag at line 360
    public boolean isAbstract() {
        if(isAbstract_computed)
            return isAbstract_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        isAbstract_value = isAbstract_compute();
        if(isFinal && num == boundariesCrossed)
            isAbstract_computed = true;
        return isAbstract_value;
    }

    private boolean isAbstract_compute() {  return  numModifier("abstract") != 0;  }

    protected boolean isVolatile_computed = false;
    protected boolean isVolatile_value;
    // Declared in Modifiers.jrag at line 361
    public boolean isVolatile() {
        if(isVolatile_computed)
            return isVolatile_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        isVolatile_value = isVolatile_compute();
        if(isFinal && num == boundariesCrossed)
            isVolatile_computed = true;
        return isVolatile_value;
    }

    private boolean isVolatile_compute() {  return  numModifier("volatile") != 0;  }

    protected boolean isTransient_computed = false;
    protected boolean isTransient_value;
    // Declared in Modifiers.jrag at line 362
    public boolean isTransient() {
        if(isTransient_computed)
            return isTransient_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        isTransient_value = isTransient_compute();
        if(isFinal && num == boundariesCrossed)
            isTransient_computed = true;
        return isTransient_value;
    }

    private boolean isTransient_compute() {  return  numModifier("transient") != 0;  }

    protected boolean isStrictfp_computed = false;
    protected boolean isStrictfp_value;
    // Declared in Modifiers.jrag at line 363
    public boolean isStrictfp() {
        if(isStrictfp_computed)
            return isStrictfp_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        isStrictfp_value = isStrictfp_compute();
        if(isFinal && num == boundariesCrossed)
            isStrictfp_computed = true;
        return isStrictfp_value;
    }

    private boolean isStrictfp_compute() {  return  numModifier("strictfp") != 0;  }

    protected boolean isSynchronized_computed = false;
    protected boolean isSynchronized_value;
    // Declared in Modifiers.jrag at line 364
    public boolean isSynchronized() {
        if(isSynchronized_computed)
            return isSynchronized_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        isSynchronized_value = isSynchronized_compute();
        if(isFinal && num == boundariesCrossed)
            isSynchronized_computed = true;
        return isSynchronized_value;
    }

    private boolean isSynchronized_compute() {  return  numModifier("synchronized") != 0;  }

    protected boolean isNative_computed = false;
    protected boolean isNative_value;
    // Declared in Modifiers.jrag at line 365
    public boolean isNative() {
        if(isNative_computed)
            return isNative_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        isNative_value = isNative_compute();
        if(isFinal && num == boundariesCrossed)
            isNative_computed = true;
        return isNative_value;
    }

    private boolean isNative_compute() {  return  numModifier("native") != 0;  }

    protected boolean isSynthetic_computed = false;
    protected boolean isSynthetic_value;
    // Declared in Modifiers.jrag at line 367
    public boolean isSynthetic() {
        if(isSynthetic_computed)
            return isSynthetic_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        isSynthetic_value = isSynthetic_compute();
        if(isFinal && num == boundariesCrossed)
            isSynthetic_computed = true;
        return isSynthetic_value;
    }

    private boolean isSynthetic_compute() {  return  numModifier("synthetic") != 0;  }

    // Declared in Modifiers.jrag at line 369
    public int numProtectionModifiers() {
        int numProtectionModifiers_value = numProtectionModifiers_compute();
        return numProtectionModifiers_value;
    }

    private int numProtectionModifiers_compute() {  return  
    numModifier("public") + numModifier("protected") + numModifier("private");  }

    // Declared in Modifiers.jrag at line 372
    public int numCompletenessModifiers() {
        int numCompletenessModifiers_value = numCompletenessModifiers_compute();
        return numCompletenessModifiers_value;
    }

    private int numCompletenessModifiers_compute() {  return 
    numModifier("abstract") + numModifier("final") + numModifier("volatile");  }

    protected java.util.Map numModifier_String_values;
    // Declared in Modifiers.jrag at line 375
    public int numModifier(String name) {
        Object _parameters = name;
if(numModifier_String_values == null) numModifier_String_values = new java.util.HashMap(4);
        if(numModifier_String_values.containsKey(_parameters))
            return ((Integer)numModifier_String_values.get(_parameters)).intValue();
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        int numModifier_String_value = numModifier_compute(name);
        if(isFinal && num == boundariesCrossed)
            numModifier_String_values.put(_parameters, new Integer(numModifier_String_value));
        return numModifier_String_value;
    }

    private int numModifier_compute(String name)  {
    int n = 0;
    for(int i = 0; i < getNumModifier(); i++) {
      String s = getModifier(i).getID();
      if(s.equals(name))
        n++;
    }
    return n;
  }

    // Declared in Annotations.jrag at line 202
    public Annotation annotation(String packageName, String annotationName) {
        Annotation annotation_String_String_value = annotation_compute(packageName, annotationName);
        return annotation_String_String_value;
    }

    private Annotation annotation_compute(String packageName, String annotationName)  {
    String qualifiedName = packageName.equals("") ? annotationName : (packageName + "." + annotationName);
    return searchAnnotation(qualifiedName);
  }

    // Declared in Annotations.jrag at line 285
    public boolean hasAnnotationSuppressWarnings(String s) {
        boolean hasAnnotationSuppressWarnings_String_value = hasAnnotationSuppressWarnings_compute(s);
        return hasAnnotationSuppressWarnings_String_value;
    }

    private boolean hasAnnotationSuppressWarnings_compute(String s)  {
    Annotation a = annotation("java.lang", "SuppressWarnings");
    if(a != null && a.getNumElementValuePair() == 1 && a.getElementValuePair(0).getName().equals("value"))
      return a.getElementValuePair(0).getElementValue().hasValue(s);
    return false;
  }

    // Declared in Annotations.jrag at line 315
    public boolean hasDeprecatedAnnotation() {
        boolean hasDeprecatedAnnotation_value = hasDeprecatedAnnotation_compute();
        return hasDeprecatedAnnotation_value;
    }

    private boolean hasDeprecatedAnnotation_compute() {  return  annotation("java.lang", "Deprecated") != null;  }

    // Declared in Modifiers.jrag at line 343
    public boolean mayBePublic() {
        boolean mayBePublic_value = getParent().Define_boolean_mayBePublic(this, null);
        return mayBePublic_value;
    }

    // Declared in Modifiers.jrag at line 344
    public boolean mayBePrivate() {
        boolean mayBePrivate_value = getParent().Define_boolean_mayBePrivate(this, null);
        return mayBePrivate_value;
    }

    // Declared in Modifiers.jrag at line 345
    public boolean mayBeProtected() {
        boolean mayBeProtected_value = getParent().Define_boolean_mayBeProtected(this, null);
        return mayBeProtected_value;
    }

    // Declared in Modifiers.jrag at line 346
    public boolean mayBeStatic() {
        boolean mayBeStatic_value = getParent().Define_boolean_mayBeStatic(this, null);
        return mayBeStatic_value;
    }

    // Declared in Modifiers.jrag at line 347
    public boolean mayBeFinal() {
        boolean mayBeFinal_value = getParent().Define_boolean_mayBeFinal(this, null);
        return mayBeFinal_value;
    }

    // Declared in Modifiers.jrag at line 348
    public boolean mayBeAbstract() {
        boolean mayBeAbstract_value = getParent().Define_boolean_mayBeAbstract(this, null);
        return mayBeAbstract_value;
    }

    // Declared in Modifiers.jrag at line 349
    public boolean mayBeVolatile() {
        boolean mayBeVolatile_value = getParent().Define_boolean_mayBeVolatile(this, null);
        return mayBeVolatile_value;
    }

    // Declared in Modifiers.jrag at line 350
    public boolean mayBeTransient() {
        boolean mayBeTransient_value = getParent().Define_boolean_mayBeTransient(this, null);
        return mayBeTransient_value;
    }

    // Declared in Modifiers.jrag at line 351
    public boolean mayBeStrictfp() {
        boolean mayBeStrictfp_value = getParent().Define_boolean_mayBeStrictfp(this, null);
        return mayBeStrictfp_value;
    }

    // Declared in Modifiers.jrag at line 352
    public boolean mayBeSynchronized() {
        boolean mayBeSynchronized_value = getParent().Define_boolean_mayBeSynchronized(this, null);
        return mayBeSynchronized_value;
    }

    // Declared in Modifiers.jrag at line 353
    public boolean mayBeNative() {
        boolean mayBeNative_value = getParent().Define_boolean_mayBeNative(this, null);
        return mayBeNative_value;
    }

    // Declared in Annotations.jrag at line 420
    public Annotation Define_Annotation_lookupAnnotation(ASTNode caller, ASTNode child, TypeDecl typeDecl) {
        if(caller == getModifierListNoTransform()) { 
   int index = caller.getIndexOfChild(child);
 {
    return annotation(typeDecl.packageName(), typeDecl.fullName().substring(typeDecl.packageName().length() + 1, typeDecl.fullName().length()));
  }
}
        return getParent().Define_Annotation_lookupAnnotation(this, caller, typeDecl);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
