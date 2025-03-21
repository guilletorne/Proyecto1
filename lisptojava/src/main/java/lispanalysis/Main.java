package lispanalysis;

import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // Example LISP expression: (defun add (x y) (+ x y))
        String lispExpression = "(defun add (x y) (+ x y))";
        Tokenizer tokenizer = new Tokenizer(lispExpression);

        LispParser parser = new LispParser(tokenIterator);
        ASTNode ast = parser.parse();

        // Interpret the AST to Java code
        LispInterpreter interpreter = new LispInterpreter();
        String javaCode = interpreter.interpret(ast);

        // Write the generated Java code to a file
        String fileName = "Generated.java";
        JavaFileWriter.writeToFile(javaCode, fileName);

        // Compile and run the generated Java program
        JavaCompilerRunner.compileAndRun(fileName);
    }
}