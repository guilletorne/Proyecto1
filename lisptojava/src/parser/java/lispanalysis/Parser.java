package lispanalysis;

import java.util.Iterator;
import java.util.List;

class Parser {
     /**
     * Parses a list of tokens into a nested list structure representing the Lisp expression.
     * 
     * @param tokens an iterator over the list of tokens to be parsed
     * @return a nested list structure representing the parsed Lisp expression
     * @throws IllegalArgumentException if the expression is invalid
     */
    public List<Object> parseExpression(List<String> input) {
        Iterator<String> tokens = new Tokenizer().tokenize(input).iterator();
        try {
            if (!tokens.hasNext()) {//no tokens or atoms
                throw new IllegalArgumentException("Expresión inválida: faltan elementos.");
            } else { //has tokens or atoms
                String token = tokens.next();
                if (token.equals("(")) {//nested expression
                    List<Object> expression = new ArrayList<>();
                    
                    while (tokens.hasNext()) {
                        String nextToken = tokens.next();
                        if (nextToken.equals(")") && !tokens.hasNext()) {
                            return expression;
                        } else {
                            expression.add(nextToken);
                            tokens.remove();
                        }
                    }
                    throw new IllegalArgumentException("Expresión inválida: falta un paréntesis de cierre.");
                } else if (token.equals(")")) {
                    throw new IllegalArgumentException("Expresión inválida: paréntesis de cierre inesperado.");
                } else {
                    return new AtomParser().parseAtom(token);
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Error en el parsing: " + e.getMessage());
        }
    }
}
