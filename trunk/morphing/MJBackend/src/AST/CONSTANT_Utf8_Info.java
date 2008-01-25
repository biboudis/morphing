
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;


  public class CONSTANT_Utf8_Info extends CONSTANT_Info {
    // Declared in BytecodeCONSTANT.jrag at line 225
    public String string;

    // Declared in BytecodeCONSTANT.jrag at line 227

    public CONSTANT_Utf8_Info(BytecodeParser parser) {
      super(parser);
      string = p.readUTF();
    }

    // Declared in BytecodeCONSTANT.jrag at line 232

    public String toString() {
      return "Utf8Info: " + string;
    }

    // Declared in BytecodeCONSTANT.jrag at line 236

    public Expr expr() {
      return new StringLiteral(string);
    }

    // Declared in BytecodeCONSTANT.jrag at line 240

    public String string() {
      return string;
    }


}
