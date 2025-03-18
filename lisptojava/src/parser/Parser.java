
class Parser {
    public List<Object> parse(String input) {
        List<String> tokens = new Tokenizer().tokenize(input);
        Iterator<String> iterator = tokens.iterator();
        return parseExpression(iterator);
    }

    private List<Object> parseExpression(Iterator<String> tokens) {
        if (!tokens.hasNext()) {
            throw new IllegalArgumentException("Expresión inválida: faltan elementos.");
        }

        String token = tokens.next();
        if (token.equals("(")) {
            List<Object> expression = new ArrayList<>();
            while (tokens.hasNext()) {
                if (tokens.hasNext() && tokens.next().equals(")")) {
                    return expression;
                }
                tokens.remove();
                expression.add(parseExpression(tokens));
            }
            throw new IllegalArgumentException("Expresión inválida: falta un paréntesis de cierre.");
        } else if (token.equals(")")) {
            throw new IllegalArgumentException("Expresión inválida: paréntesis de cierre inesperado.");
        } else {
            return new AtomParser().parseAtom(token);
        }
    }
}
