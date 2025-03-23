package lispanalysis.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lispanalysis.ast.ASTNode;
import lispanalysis.ast.ASTDefun;
import lispanalysis.ast.ASTCond;
import lispanalysis.ast.ASTFunction;
import lispanalysis.ast.ASTFunctionCall;
import lispanalysis.ast.ASTLiteral;

public class LispParser {
    private Iterator<String> tokens;

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
                return handleDefun();
            } else if (functionName.equals("cond")) {
                // Handle cond
                return handleCond();
            } else if (functionName.equals("+") || functionName.equals("-") || functionName.equals("*") || functionName.equals("/")) {
                // Handle functions
                return handleFunction(functionName);
            } else {
                // Handle function calls
                return handleFunctionCall(functionName);
            }
        } 
        // It's a literal
        return new ASTLiteral(token);
    }

    public ASTNode handleDefun() {
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
    }

    public ASTNode handleCond() {
        ASTNode condition = parseExpression(tokens.next());
        ASTNode thenBranch = parseExpression(tokens.next());
        ASTNode elseBranch = parseExpression(tokens.next());
        return new ASTCond(condition, thenBranch, elseBranch);
    }

    public ASTNode handleFunction(String functionName) {
        String value1 = tokens.next();
        String value2 = tokens.next();
        return new ASTFunction(functionName, value1, value2);
    }

    public ASTNode handleFunctionCall(String functionName) {
        ASTNode argument1 = parseExpression(tokens.next());
        ASTNode argument2 = parseExpression(tokens.next());
        return new ASTFunctionCall(functionName, argument1, argument2);
    }
}