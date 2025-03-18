import java.util.*;

public class LispParser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese una expresión LISP: ");
        String input = scanner.nextLine();
        scanner.close();
        
        try {
            List<Object> parsedExpression = new Parser().parse(input);
            System.out.println("Estructura parseada: " + parsedExpression);
        } catch (Exception e) {
            System.out.println("Error en el parsing: " + e.getMessage());
        }
    }
}