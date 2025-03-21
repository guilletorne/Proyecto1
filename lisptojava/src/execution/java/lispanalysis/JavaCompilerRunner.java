package lispanalysis;

import java.io.File;

public class JavaCompilerRunner {

    private JavaCompilerRunner() {
        //private constructor to hide the implicit public one
        //good practice to prevent instantiation
    }

    public static void compileAndRun(String fileName) {
        try {
            // Compile the Java file
            ProcessBuilder compileProcess = new ProcessBuilder("javac", fileName);
            compileProcess.inheritIO(); // Redirect output to console
            Process compile = compileProcess.start();
            compile.waitFor();

            // Run the compiled class
            String className = fileName.substring(0, fileName.lastIndexOf('.'));
            ProcessBuilder runProcess = new ProcessBuilder("java", className);
            runProcess.inheritIO(); // Redirect output to console
            Process run = runProcess.start();
            run.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}