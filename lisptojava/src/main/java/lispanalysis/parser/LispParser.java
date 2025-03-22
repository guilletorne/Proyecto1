package lispanalysis.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lispanalysis.ast.ASTNode;
import lispanalysis.ast.ASTDefun;
import lispanalysis.ast.ASTCond;
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

    //reduce cognitive complexity = more modular & readable code (later)
    private ASTNode parseExpression(String token) {
        if (token.equals("(")) {
            String functionName = tokens.next(); // Get the function name

            if (functionName.equals("defun")) {
                // Handle defun
                return handleDefun();
            } else if (functionName.equals("cond")) {
                // Handle cond
                return handleCond();
            } else {
                // Handle function calls
                return handleFunctionCall(functionName);
            }
        } else {
            // It's a literal
            return new ASTLiteral(token);
        }
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

    public ASTNode handleFunctionCall(String functionName) {
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
}