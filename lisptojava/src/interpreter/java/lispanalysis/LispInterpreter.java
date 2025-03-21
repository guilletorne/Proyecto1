package lispanalysis;

import java.util.List;

public class LispInterpreter {
    
    public String interpret(ASTNode node) {
        if (node instanceof ASTFunctionCall) {
            return interpretFunctionCall((ASTFunctionCall) node);
        } else if (node instanceof ASTLiteral) {
            return interpretLiteral((ASTLiteral) node);
        } else if (node instanceof ASTDefun) {
            return interpretDefun((ASTDefun) node);
        } else if (node instanceof ASTIf) {
            return interpretIf((ASTIf) node);
        } else {
            throw new IllegalArgumentException("Unknown AST node type: " + node.getClass());
        }
    }

    private String interpretFunctionCall(ASTFunctionCall node) {
        StringBuilder sb = new StringBuilder();
        sb.append(node.functionName).append("(");
        for (int i = 0; i < node.arguments.size(); i++) {
            sb.append(interpret(node.arguments.get(i)));
            if (i < node.arguments.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    private String interpretLiteral(ASTLiteral node) {
        return node.value; // Assuming literals are already in a Java-compatible format
    }

    private String interpretDefun(ASTDefun node) {
        StringBuilder sb = new StringBuilder();
        sb.append("public static ").append("void ").append(node.functionName).append("(");
        for (int i = 0; i < node.parameters.size(); i++) {
            sb.append("int ").append(node.parameters.get(i)); // Assuming parameters are integers
            if (i < node.parameters.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(") {\n");
        sb.append(interpret(node.body)).append("\n");//recursivity
        sb.append("}\n");
        return sb.toString();
    }

    private String interpretIf(ASTIf node) {
        StringBuilder sb = new StringBuilder();
        sb.append("if (").append(interpret(node.condition)).append(") {\n");
        sb.append(interpret(node.thenBranch)).append("\n");
        sb.append("} else {\n");
        sb.append(interpret(node.elseBranch)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}