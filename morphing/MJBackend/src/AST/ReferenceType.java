
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;


// 4.1 The Kinds of Types and Values
public abstract class ReferenceType extends TypeDecl implements Cloneable {
    public void flushCache() {
        super.flushCache();
        narrowingConversionTo_TypeDecl_values = null;
        bcFields_computed = false;
        bcFields_value = null;
        unboxed_computed = false;
        unboxed_value = null;
    }
    public Object clone() throws CloneNotSupportedException {
        ReferenceType node = (ReferenceType)super.clone();
        node.narrowingConversionTo_TypeDecl_values = null;
        node.bcFields_computed = false;
        node.bcFields_value = null;
        node.unboxed_computed = false;
        node.unboxed_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in CodeGeneration.jrag at line 575

  public void emitReturn(CodeGeneration gen) { gen.emit(Bytecode.ARETURN);}

    // Declared in CodeGeneration.jrag at line 628

  public void emitLoadLocal(CodeGeneration gen, int pos) {
    gen.emitLoadReference(pos);
  }

    // Declared in CodeGeneration.jrag at line 741

  public void emitStoreLocal(CodeGeneration gen, int pos) {
    gen.emitStoreReference(pos);
  }

    // Declared in CodeGeneration.jrag at line 902

  void refined_CodeGeneration_emitCastTo(CodeGeneration gen, TypeDecl type) { if(!instanceOf(type) && !type.isNull()) gen.emitCheckCast(type); }

    // Declared in CodeGeneration.jrag at line 1099

  public void branchEQ(CodeGeneration gen, int label) { gen.emitCompare(Bytecode.IF_ACMPEQ, label); }

    // Declared in CodeGeneration.jrag at line 1108

  public void branchNE(CodeGeneration gen, int label) { gen.emitCompare(Bytecode.IF_ACMPNE, label); }

    // Declared in AutoBoxingCodegen.jrag at line 7

  void byteToThis(CodeGeneration gen) {
    if(isUnknown()) throw new Error("Trying to cast to Unknown");
    if(!isNumericType())
      typeByte().boxed().byteToThis(gen);
    else {
      unboxed().byteToThis(gen);
      emitBoxingOperation(gen);
    }
  }

    // Declared in AutoBoxingCodegen.jrag at line 16

  void charToThis(CodeGeneration gen) {
    if(isUnknown()) throw new Error("Trying to cast to Unknown");
    if(!isNumericType())
      typeChar().boxed().charToThis(gen);
    else {
      unboxed().charToThis(gen);
      emitBoxingOperation(gen);
    }
  }

    // Declared in AutoBoxingCodegen.jrag at line 25

  void shortToThis(CodeGeneration gen) {
    if(isUnknown()) throw new Error("Trying to cast to Unknown");
    if(!isNumericType())
      typeShort().boxed().shortToThis(gen);
    else {
      unboxed().shortToThis(gen);
      emitBoxingOperation(gen);
    }
  }

    // Declared in AutoBoxingCodegen.jrag at line 34

  void intToThis(CodeGeneration gen) {
    if(isUnknown()) throw new Error("Trying to cast to Unknown");
    if(!isNumericType())
      typeInt().boxed().intToThis(gen);
    else {
      unboxed().intToThis(gen);
      emitBoxingOperation(gen);
    }
  }

    // Declared in AutoBoxingCodegen.jrag at line 43

  void longToThis(CodeGeneration gen) {
    if(isUnknown()) throw new Error("Trying to cast to Unknown");
    if(!isNumericType())
      typeLong().boxed().longToThis(gen);
    else {
      unboxed().longToThis(gen);
      emitBoxingOperation(gen);
    }
  }

    // Declared in AutoBoxingCodegen.jrag at line 52

  void floatToThis(CodeGeneration gen) {
    if(isUnknown()) throw new Error("Trying to cast to Unknown");
    if(!isNumericType())
      typeFloat().boxed().floatToThis(gen);
    else {
      unboxed().floatToThis(gen);
      emitBoxingOperation(gen);
    }
  }

    // Declared in AutoBoxingCodegen.jrag at line 61

  void doubleToThis(CodeGeneration gen) {
    if(isUnknown()) throw new Error("Trying to cast to Unknown");
    if(!isNumericType())
      typeDouble().boxed().doubleToThis(gen);
    else {
      unboxed().doubleToThis(gen);
      emitBoxingOperation(gen);
    }
  }

    // Declared in java.ast at line 3
    // Declared in java.ast line 40

    public ReferenceType() {
        super();

        setChild(null, 0);
        setChild(new List(), 1);

    }

    // Declared in java.ast at line 12


    // Declared in java.ast line 40
    public ReferenceType(Modifiers p0, String p1, List p2) {
        setChild(p0, 0);
        setID(p1);
        setChild(p2, 1);
    }

    // Declared in java.ast at line 18


  protected int numChildren() {
    return 2;
  }

    // Declared in java.ast at line 21

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

    // Declared in AutoBoxingCodegen.jrag at line 80


  // Code generation for Unboxing Conversion
    public void emitCastTo(CodeGeneration gen, TypeDecl type) {
    if(type instanceof PrimitiveType) {
      emitUnboxingOperation(gen);
      unboxed().emitCastTo(gen, type);
    }
    else 
      refined_CodeGeneration_emitCastTo(gen, type);
  }

    // Declared in TypeAnalysis.jrag at line 24
    public boolean wideningConversionTo(TypeDecl type) {
        boolean wideningConversionTo_TypeDecl_value = wideningConversionTo_compute(type);
        return wideningConversionTo_TypeDecl_value;
    }

    private boolean wideningConversionTo_compute(TypeDecl type) {  return  instanceOf(type);  }

    // Declared in TypeAnalysis.jrag at line 27
    public boolean narrowingConversionTo(TypeDecl type) {
        Object _parameters = type;
if(narrowingConversionTo_TypeDecl_values == null) narrowingConversionTo_TypeDecl_values = new java.util.HashMap(4);
        if(narrowingConversionTo_TypeDecl_values.containsKey(_parameters))
            return ((Boolean)narrowingConversionTo_TypeDecl_values.get(_parameters)).booleanValue();
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        boolean narrowingConversionTo_TypeDecl_value = narrowingConversionTo_compute(type);
        if(isFinal && num == boundariesCrossed)
            narrowingConversionTo_TypeDecl_values.put(_parameters, Boolean.valueOf(narrowingConversionTo_TypeDecl_value));
        return narrowingConversionTo_TypeDecl_value;
    }

    private boolean narrowingConversionTo_compute(TypeDecl type)  {
    if(type.instanceOf(this))
      return true;
    if(isClassDecl() && !getModifiers().isFinal() && type.isInterfaceDecl())
      return true;
    if(isInterfaceDecl() && type.isClassDecl() && !type.getModifiers().isFinal())
      return true;
    if(isInterfaceDecl() && type.instanceOf(this))
      return true;
    if(fullName().equals("java.lang.Object") && type.isInterfaceDecl())
      return true;
    // Dragons
    // TODO: Check if both are interfaces with compatible methods
    if(isArrayDecl() && type.isArrayDecl() && elementType().instanceOf(type.elementType()))
      return true;
    return false;
  }

    // Declared in TypeAnalysis.jrag at line 157
    public boolean isReferenceType() {
        boolean isReferenceType_value = isReferenceType_compute();
        return isReferenceType_value;
    }

    private boolean isReferenceType_compute() {  return  true;  }

    // Declared in TypeAnalysis.jrag at line 481
    public boolean isSupertypeOfNullType(NullType type) {
        boolean isSupertypeOfNullType_NullType_value = isSupertypeOfNullType_compute(type);
        return isSupertypeOfNullType_NullType_value;
    }

    private boolean isSupertypeOfNullType_compute(NullType type) {  return  true;  }

    // Declared in CodeGeneration.jrag at line 581
    public byte arrayLoad() {
        byte arrayLoad_value = arrayLoad_compute();
        return arrayLoad_value;
    }

    private byte arrayLoad_compute() {  return  Bytecode.AALOAD;  }

    // Declared in CodeGeneration.jrag at line 683
    public byte arrayStore() {
        byte arrayStore_value = arrayStore_compute();
        return arrayStore_value;
    }

    private byte arrayStore_compute() {  return  Bytecode.AASTORE;  }

    // Declared in CreateBCode.jrag at line 956
    public TypeDecl stringPromotion() {
        TypeDecl stringPromotion_value = stringPromotion_compute();
        return stringPromotion_value;
    }

    private TypeDecl stringPromotion_compute() {  return  typeObject();  }

    // Declared in GenerateClassfile.jrag at line 305
    public Collection bcFields() {
        if(bcFields_computed)
            return bcFields_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        bcFields_value = bcFields_compute();
        if(isFinal && num == boundariesCrossed)
            bcFields_computed = true;
        return bcFields_value;
    }

    private Collection bcFields_compute()  {
    ArrayList l = new ArrayList();
    for(int i = 0; i < getNumBodyDecl(); i++) 
      if(getBodyDecl(i).isBytecodeField())
        l.add(getBodyDecl(i));
    return l;
  }

    // Declared in GenerateClassfile.jrag at line 313
    public Collection bcMethods() {
        Collection bcMethods_value = bcMethods_compute();
        return bcMethods_value;
    }

    private Collection bcMethods_compute()  {
    ArrayList l = new ArrayList();
    constructors();
    for(int i = 0; i < getNumBodyDecl(); i++)
      if(getBodyDecl(i).isBytecodeMethod())
        l.add(getBodyDecl(i));
    return l;
  }

    // Declared in Java2Rewrites.jrag at line 22
    public String referenceClassName() {
        String referenceClassName_value = referenceClassName_compute();
        return referenceClassName_value;
    }

    private String referenceClassName_compute() {  return  constantPoolName().replace('/', '.');  }

    // Declared in Java2Rewrites.jrag at line 28
    public String referenceClassFieldName() {
        String referenceClassFieldName_value = referenceClassFieldName_compute();
        return referenceClassFieldName_value;
    }

    private String referenceClassFieldName_compute() {  return  "class$" + referenceClassName().replace('[', '$').replace('.', '$').replace(';', ' ').trim();  }

    // Declared in LocalNum.jrag at line 112
    public int variableSize() {
        int variableSize_value = variableSize_compute();
        return variableSize_value;
    }

    private int variableSize_compute() {  return  1;  }

    // Declared in Annotations.jrag at line 111
    public boolean isValidAnnotationMethodReturnType() {
        boolean isValidAnnotationMethodReturnType_value = isValidAnnotationMethodReturnType_compute();
        return isValidAnnotationMethodReturnType_value;
    }

    private boolean isValidAnnotationMethodReturnType_compute()  {
    if(isString()) return true;
    if(fullName().equals("java.lang.Class"))
      return true;
    // include generic versions of Class
    if(erasure().fullName().equals("java.lang.Class"))
      return true;
    return false;
  }

    // Declared in AutoBoxing.jrag at line 39
    public boolean unboxingConversionTo(TypeDecl typeDecl) {
        boolean unboxingConversionTo_TypeDecl_value = unboxingConversionTo_compute(typeDecl);
        return unboxingConversionTo_TypeDecl_value;
    }

    private boolean unboxingConversionTo_compute(TypeDecl typeDecl) {  return  unboxed() == typeDecl;  }

    // Declared in AutoBoxing.jrag at line 43
    public TypeDecl unboxed() {
        if(unboxed_computed)
            return unboxed_value;
        int num = boundariesCrossed;
        boolean isFinal = this.is$Final();
        unboxed_value = unboxed_compute();
        if(isFinal && num == boundariesCrossed)
            unboxed_computed = true;
        return unboxed_value;
    }

    private TypeDecl unboxed_compute()  {
    if(packageName().equals("java.lang") && isTopLevelType()) {
      String n = name();
      if(n.equals("Boolean")) return typeBoolean();
      if(n.equals("Byte")) return typeByte();
      if(n.equals("Character")) return typeChar();
      if(n.equals("Short")) return typeShort();
      if(n.equals("Integer")) return typeInt();
      if(n.equals("Long")) return typeLong();
      if(n.equals("Float")) return typeFloat();
      if(n.equals("Double")) return typeDouble();
    }
    return unknownType();
  }

    // Declared in AutoBoxing.jrag at line 106
    public TypeDecl unaryNumericPromotion() {
        TypeDecl unaryNumericPromotion_value = unaryNumericPromotion_compute();
        return unaryNumericPromotion_value;
    }

    private TypeDecl unaryNumericPromotion_compute() {  return  isUnknown() ? this : unboxed().unaryNumericPromotion();  }

    // Declared in AutoBoxing.jrag at line 109
    public TypeDecl binaryNumericPromotion(TypeDecl type) {
        TypeDecl binaryNumericPromotion_TypeDecl_value = binaryNumericPromotion_compute(type);
        return binaryNumericPromotion_TypeDecl_value;
    }

    private TypeDecl binaryNumericPromotion_compute(TypeDecl type) {  return 
    unboxed().binaryNumericPromotion(type);  }

    // Declared in AutoBoxing.jrag at line 117
    public boolean isNumericType() {
        boolean isNumericType_value = isNumericType_compute();
        return isNumericType_value;
    }

    private boolean isNumericType_compute() {  return  
    !unboxed().isUnknown() && unboxed().isNumericType();  }

    // Declared in AutoBoxing.jrag at line 120
    public boolean isPrimitive() {
        boolean isPrimitive_value = isPrimitive_compute();
        return isPrimitive_value;
    }

    private boolean isPrimitive_compute() {  return 
    !unboxed().isUnknown() && unboxed().isPrimitive();  }

    // Declared in AutoBoxing.jrag at line 124
    public boolean isBoolean() {
        boolean isBoolean_value = isBoolean_compute();
        return isBoolean_value;
    }

    private boolean isBoolean_compute() {  return  fullName().equals("java.lang.Boolean") && unboxed().isBoolean();  }

    // Declared in GenericsSubtype.jrag at line 301
    public boolean supertypeNullType(NullType type) {
        boolean supertypeNullType_NullType_value = supertypeNullType_compute(type);
        return supertypeNullType_NullType_value;
    }

    private boolean supertypeNullType_compute(NullType type) {  return  true;  }

    // Declared in AutoBoxing.jrag at line 57
    public TypeDecl typeBoolean() {
        TypeDecl typeBoolean_value = getParent().Define_TypeDecl_typeBoolean(this, null);
        return typeBoolean_value;
    }

    // Declared in AutoBoxing.jrag at line 58
    public TypeDecl typeByte() {
        TypeDecl typeByte_value = getParent().Define_TypeDecl_typeByte(this, null);
        return typeByte_value;
    }

    // Declared in AutoBoxing.jrag at line 59
    public TypeDecl typeChar() {
        TypeDecl typeChar_value = getParent().Define_TypeDecl_typeChar(this, null);
        return typeChar_value;
    }

    // Declared in AutoBoxing.jrag at line 60
    public TypeDecl typeShort() {
        TypeDecl typeShort_value = getParent().Define_TypeDecl_typeShort(this, null);
        return typeShort_value;
    }

    // Declared in AutoBoxing.jrag at line 61
    public TypeDecl typeInt() {
        TypeDecl typeInt_value = getParent().Define_TypeDecl_typeInt(this, null);
        return typeInt_value;
    }

    // Declared in AutoBoxing.jrag at line 62
    public TypeDecl typeLong() {
        TypeDecl typeLong_value = getParent().Define_TypeDecl_typeLong(this, null);
        return typeLong_value;
    }

    // Declared in AutoBoxing.jrag at line 63
    public TypeDecl typeFloat() {
        TypeDecl typeFloat_value = getParent().Define_TypeDecl_typeFloat(this, null);
        return typeFloat_value;
    }

    // Declared in AutoBoxing.jrag at line 64
    public TypeDecl typeDouble() {
        TypeDecl typeDouble_value = getParent().Define_TypeDecl_typeDouble(this, null);
        return typeDouble_value;
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
