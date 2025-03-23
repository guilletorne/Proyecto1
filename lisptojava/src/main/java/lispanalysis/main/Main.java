//lisptojava.src.main.java.

package lispanalysis.main;

import lispanalysis.tokenizer.Tokenizer;
import lispanalysis.parser.LispParser;
import lispanalysis.ast.ASTNode;
import lispanalysis.interpreter.LispInterpreter;
import lispanalysis.execution.JavaFileWriter;
import lispanalysis.execution.JavaCompilerRunner;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // Example LISP expression: (defun add (x y) (+ x y)) (add 3 4)
        String lispExpression = "(defun add (x y) (+ x y)) (add 3 4)";
        Iterator<String> tokens = new Tokenizer().tokenize(lispExpression);

        LispParser parser = new LispParser(tokens);
        ASTNode ast = parser.parse();

        // Interpret the AST to Java code
        LispInterpreter interpreter = new LispInterpreter();
        String javaCode = interpreter.interpretToMain(ast);

        // Write the generated Java code to a file
        String fileName = "Generated.java";
        JavaFileWriter.writeToFile(javaCode, fileName);

        // Compile and run the generated Java program
        JavaCompilerRunner.compileAndRun(fileName);
    }
}