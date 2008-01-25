
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;

public class TypeAccess extends Access implements Cloneable {
    public void flushCache() {
        super.flushCache();
        decls_computed = false;
        decls_value = null;
        decl_computed = false;
        decl_value = null;
        type_computed = false;
        type_value = null;
    }
    public Object clone() throws CloneNotSupportedException {
        TypeAccess node = (TypeAccess)super.clone();
        node.decls_computed = false;
        node.decls_value = null;
        node.decl_computed = false;
        node.decl_value = null;
        node.type_computed = false;
        node.type_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    public ASTNode copy() {
      try {
          TypeAccess node = (TypeAccess)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
    public ASTNode fullCopy() {
        TypeAccess res = (TypeAccess)copy();
        for(int i = 0; i < getNumChild(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in AccessControl.jrag at line 119

  
  public void accessControl() {
    super.accessControl();
    TypeDecl hostType = hostType();
    if(hostType != null && !hostType.isUnknown() && !type().accessibleFrom(hostType)) {
      error("" + this + " in " + hostType().fullName() + " can not access type " + type().fullName());
    }
    else if((hostType == null || hostType.isUnknown())  && !type().accessibleFromPackage(hostPackage())) {
      error("" + this + " can not access type " + type().fullName());
    }
  }

    // Declared in NameCheck.jrag at line 143

  
  public void nameCheck() {
    if(isQualified() && !qualifier().isTypeAccess() && !qualifier().isPackageAccess())
      error("can not access the type named " + decl().typeName() + " in this context");
    if(decls().isEmpty())
      error("no visible type named " + typeName());
    if(decls().size() > 1) {
      StringBuffer s = new StringBuffer();
      s.append("several types named " + name() + ":");
      for(Iterator iter = decls().iterator(); iter.hasNext(); ) {
        TypeDecl t = (TypeDecl)iter.next();
        s.append(" " + t.typeName());
      }
      error(s.toString());
    }
  }

    // Declared in NodeConstructors.jrag at line 18

  public TypeAccess(String name, int start, int end) {
    this(name);
    this.start = start;
    this.end = end;
  }

    // Declared in NodeConstructors.jrag at line 39


  public TypeAccess(String typeName) {
    this("", typeName);
  }

    // Declared in PrettyPrint.jadd at line 610

  
  public void toString(StringBuffer s) {
    if(!isUnknown())
      s.append(isQualified() ? decl().name() : decl().typeName());
    else
      s.append(name());
  }

    // Declared in Annotations.jrag at line 324


  public void checkModifiers() {
    if(decl().isDeprecated() &&
       !withinDeprecatedAnnotation() &&
       (hostType() == null || hostType().topLevelType() != decl().topLevelType()) &&
       !withinSuppressWarnings("deprecation"))
      warning(decl().typeName() + " has been deprecated");
  }

    // Declared in Generics.jrag at line 192


  // this method assumes that the bound type is generic
  public boolean isRaw() {
    if(hasNextAccess())
      return false;
    ASTNode parent = getParent();
    while(parent instanceof AbstractDot)
      parent = parent.getParent();
    if(parent instanceof ParTypeAccess)
      return false;
    return true;
  }

    // Declared in java.ast at line 3
    // Declared in java.ast line 20

    public TypeAccess() {
        super();


    }

    // Declared in java.ast at line 10


    // Declared in java.ast line 20
    public TypeAccess(String p0, String p1) {
        setPackage(p0);
        setID(p1);
    }

    // Declared in java.ast at line 15


  protected int numChildren() {
    return 0;
  }

    // Declared in java.ast at line 18

  public boolean mayHaveRewrite() { return false; }

    // Declared in java.ast at line 2
    // Declared in java.ast line 20
    private String tokenString_Package;

    // Declared in java.ast at line 3

    public void setPackage(String value) {
        tokenString_Package = value;
    }

    // Declared in java.ast at line 6

    public String getPackage() {
        return tokenString_Package;
    }

    // Declared in java.ast at line 2
    // Declared in java.ast line 20
    private String tokenString_ID;

    // Declared in java.ast at line 3

    public void setID(String value) {
        tokenString_ID = value;
    }

    // Declared in java.ast at line 6

    public String getID() {
        return tokenString_ID;
    }

    // Declared in LookupType.jrag at line 140
private TypeDecl refined_LookupType_decl()
 {
    SimpleSet decls = decls();
    if(decls.size() == 1) {
      return (TypeDecl)decls.iterator().next();
    }
    return unknownType();
  }

    protected boolean decls_computed = false;
    protected SimpleSet decls_value;
    // Declared in LookupType.jrag at line 125
    public SimpleSet decls() {
        if(decls_computed)
            return decls_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        decls_value = decls_compute();
        if(isFinal && num == boundariesCrossed)
            decls_computed = true;
        return decls_value;
    }

    private SimpleSet decls_compute()  {
    if(packageName().equals(""))
      return lookupType(name());
    else {
      TypeDecl typeDecl = lookupType(packageName(), name());
      if(typeDecl != null)
        return SimpleSet.emptySet.add(typeDecl);
      return SimpleSet.emptySet;
    }
  }

    protected boolean decl_computed = false;
    protected TypeDecl decl_value;
    // Declared in Generics.jrag at line 184
    public TypeDecl decl() {
        if(decl_computed)
            return decl_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        decl_value = decl_compute();
        if(isFinal && num == boundariesCrossed)
            decl_computed = true;
        return decl_value;
    }

    private TypeDecl decl_compute()  {
    TypeDecl decl = refined_LookupType_decl();
    if(decl instanceof GenericTypeDecl && isRaw())
      return ((GenericTypeDecl)decl).lookupParTypeDecl(new ArrayList());
    return decl;
  }

    // Declared in LookupVariable.jrag at line 144
    public SimpleSet qualifiedLookupVariable(String name) {
        SimpleSet qualifiedLookupVariable_String_value = qualifiedLookupVariable_compute(name);
        return qualifiedLookupVariable_String_value;
    }

    private SimpleSet qualifiedLookupVariable_compute(String name)  {
    if(type().accessibleFrom(hostType())) {
      SimpleSet c = type().memberFields(name);
      c = keepAccessibleFields(c);
      if(type().isClassDecl() && c.size() == 1)
        c = removeInstanceVariables(c);
      return c;
    }
    return SimpleSet.emptySet;
  }

    // Declared in PrettyPrint.jadd at line 939
    public String dumpString() {
        String dumpString_value = dumpString_compute();
        return dumpString_value;
    }

    private String dumpString_compute() {  return  getClass().getName() + " [" + getPackage() + ", " + getID() + "]";  }

    // Declared in QualifiedNames.jrag at line 12
    public String name() {
        String name_value = name_compute();
        return name_value;
    }

    private String name_compute() {  return  getID();  }

    // Declared in QualifiedNames.jrag at line 17
    public String packageName() {
        String packageName_value = packageName_compute();
        return packageName_value;
    }

    private String packageName_compute() {  return  getPackage();  }

    // Declared in QualifiedNames.jrag at line 40
    public String nameWithPackage() {
        String nameWithPackage_value = nameWithPackage_compute();
        return nameWithPackage_value;
    }

    private String nameWithPackage_compute() {  return  getPackage().equals("") ? name() : (getPackage() + "." + name());  }

    // Declared in QualifiedNames.jrag at line 55
    public String typeName() {
        String typeName_value = typeName_compute();
        return typeName_value;
    }

    private String typeName_compute() {  return  isQualified() ? (qualifier().typeName() + "." + nameWithPackage()) : nameWithPackage();  }

    // Declared in ResolveAmbiguousNames.jrag at line 5
    public boolean isTypeAccess() {
        boolean isTypeAccess_value = isTypeAccess_compute();
        return isTypeAccess_value;
    }

    private boolean isTypeAccess_compute() {  return  true;  }

    // Declared in SyntacticClassification.jrag at line 96
    public NameType predNameType() {
        NameType predNameType_value = predNameType_compute();
        return predNameType_value;
    }

    private NameType predNameType_compute() {  return  NameType.PACKAGE_OR_TYPE_NAME;  }

    // Declared in TypeAnalysis.jrag at line 280
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

    private TypeDecl type_compute() {  return  decl();  }

    // Declared in TypeHierarchyCheck.jrag at line 145
    public boolean staticContextQualifier() {
        boolean staticContextQualifier_value = staticContextQualifier_compute();
        return staticContextQualifier_value;
    }

    private boolean staticContextQualifier_compute() {  return  true;  }

    // Declared in Generics.jrag at line 760
    public boolean usesTypeVariable() {
        boolean usesTypeVariable_value = usesTypeVariable_compute();
        return usesTypeVariable_value;
    }

    private boolean usesTypeVariable_compute() {  return  decl().usesTypeVariable() || super.usesTypeVariable();  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
