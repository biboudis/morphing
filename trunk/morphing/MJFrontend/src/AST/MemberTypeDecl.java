
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;


// 8.5 Member Type Declarations
public abstract class MemberTypeDecl extends MemberDecl implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
    public Object clone() throws CloneNotSupportedException {
        MemberTypeDecl node = (MemberTypeDecl)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in java.ast at line 3
    // Declared in java.ast line 92

    public MemberTypeDecl() {
        super();


    }

    // Declared in java.ast at line 9


  protected int numChildren() {
    return 0;
  }

    // Declared in java.ast at line 12

  public boolean mayHaveRewrite() { return false; }

    // Declared in LookupType.jrag at line 337
    public abstract TypeDecl typeDecl();
    // Declared in LookupType.jrag at line 333
    public boolean declaresType(String name) {
        boolean declaresType_String_value = declaresType_compute(name);
        return declaresType_String_value;
    }

    private boolean declaresType_compute(String name) {  return  typeDecl().name().equals(name);  }

    // Declared in LookupType.jrag at line 335
    public TypeDecl type(String name) {
        TypeDecl type_String_value = type_compute(name);
        return type_String_value;
    }

    private TypeDecl type_compute(String name) {  return  declaresType(name) ? typeDecl() : null;  }

    // Declared in Modifiers.jrag at line 233
    public boolean isStatic() {
        boolean isStatic_value = isStatic_compute();
        return isStatic_value;
    }

    private boolean isStatic_compute() {  return  typeDecl().isStatic();  }

    // Declared in Annotations.jrag at line 280
    public boolean hasAnnotationSuppressWarnings(String s) {
        boolean hasAnnotationSuppressWarnings_String_value = hasAnnotationSuppressWarnings_compute(s);
        return hasAnnotationSuppressWarnings_String_value;
    }

    private boolean hasAnnotationSuppressWarnings_compute(String s) {  return  typeDecl().hasAnnotationSuppressWarnings(s);  }

    // Declared in Annotations.jrag at line 318
    public boolean isDeprecated() {
        boolean isDeprecated_value = isDeprecated_compute();
        return isDeprecated_value;
    }

    private boolean isDeprecated_compute() {  return  typeDecl().isDeprecated();  }

    // Declared in GenericsParTypeDecl.jrag at line 59
    public boolean visibleTypeParameters() {
        boolean visibleTypeParameters_value = visibleTypeParameters_compute();
        return visibleTypeParameters_value;
    }

    private boolean visibleTypeParameters_compute() {  return  !isStatic();  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
