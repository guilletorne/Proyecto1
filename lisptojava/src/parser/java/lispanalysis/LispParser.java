package lispanalysis;

public class LispParser {

    public LispParser(Iterator<String> tokens) {
        this.tokens = tokens;
    }

    public ASTNode parse() {
        if (!tokens.hasNext()) {
            throw new IllegalArgumentException("No tokens to parse");
        }
        String token = tokens.next();
        return parseExpression(token);
    }

    private ASTNode parseExpression(String token) {
        if (token.equals("(")) {
            String functionName = tokens.next(); // Get the function name

            if (functionName.equals("defun")) {
                // Handle defun
                String funcName = tokens.next();
                List<String> parameters = new ArrayList<>();
                while (tokens.hasNext()) {
                    String param = tokens.next();
                    if (param.equals(")")) {
                        break; // End of parameters
                    }
                    parameters.add(param);
                }
                ASTNode body = parseExpression(tokens.next()); // Parse the body
                return new ASTDefun(funcName, parameters, body);
            } else if (functionName.equals("if")) {
                // Handle if
                ASTNode condition = parseExpression(tokens.next());
                ASTNode thenBranch = parseExpression(tokens.next());
                ASTNode elseBranch = parseExpression(tokens.next());
                return new ASTIf(condition, thenBranch, elseBranch);
            } else {
                // Handle function calls
                List<ASTNode> arguments = new ArrayList<>();
                while (tokens.hasNext()) {
                    String nextToken = tokens.next();
                    if (nextToken.equals(")")) {
                        break; // End of the function call
                    }
                    arguments.add(parseExpression(nextToken));
                }
                return new ASTFunctionCall(functionName, arguments);
            }
        } else {
            // It's a literal
            return new ASTLiteral(token);
        }
    }
}