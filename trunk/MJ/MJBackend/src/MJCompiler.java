import AST.*;

class MJCompiler extends Frontend {
  public static void main(String args[]) {
    if(!compile(args))
      System.exit(1);
  }

  public static boolean compile(String args[]) {
    return new MJCompiler().process(
        args,
        new BytecodeParser(),
        new JavaParser() {
          public CompilationUnit parse(java.io.InputStream is, String fileName) throws java.io.IOException, beaver.Parser.Exception {
            return new parser.JavaParser().parse(is, fileName);
          }
        }
    );
  }
  protected void processNoErrors(CompilationUnit unit) {
    unit.java2Transformation();
    unit.generateClassfile();
  }

  protected String name() { return "MJCompiler"; }
  protected String version() { return "R20080124"; }
}
