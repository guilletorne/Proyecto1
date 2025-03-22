package lispanalysis.execution;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class JavaFileWriter {

    private JavaFileWriter() {
        // private constructor to hide the implicit public one
        //good practice to prevent instantiation
    }

    public static void writeToFile(String javaCode, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(javaCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}