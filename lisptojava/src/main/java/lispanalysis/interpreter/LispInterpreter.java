package lispanalysis.interpreter;

import lispanalysis.ast.ASTNode;
import lispanalysis.ast.ASTDefun;
import lispanalysis.ast.ASTFunctionCall;
import lispanalysis.ast.ASTCond;
import lispanalysis.ast.ASTLiteral;

public class LispInterpreter {
    
    public String interpretToMain(ASTNode node) {
        StringBuilder sb = new StringBuilder();
        sb.append("public class Generated {\n");
        sb.append("    public static void main(String[] args) {\n");
        sb.append(interpret(node));
        sb.append("    }\n");
        sb.append("}\n");
        return sb.toString();
    }

    public String interpret(ASTNode node) {
        if (node instanceof ASTFunctionCall) {
            return interpretFunctionCall((ASTFunctionCall) node);
        } else if (node instanceof ASTLiteral) {
            return interpretLiteral((ASTLiteral) node);
        } else if (node instanceof ASTDefun) {
            return interpretDefun((ASTDefun) node);
        } else if (node instanceof ASTCond) {
            return interpretCond((ASTCond) node);
        } else {
            throw new IllegalArgumentException("Unknown AST node type: " + node.getClass());
        }
    }

    private String interpretFunctionCall(ASTFunctionCall node) {
        StringBuilder sb = new StringBuilder();
        sb.append(node.getFunctionName()).append("(");
        for (int i = 0; i < node.getArguments().size(); i++) {
            sb.append(interpret(node.getArguments().get(i)));
            if (i < node.getArguments().size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    private String interpretLiteral(ASTLiteral node) {
        return node.getValue(); // Assuming literals are already in a Java-compatible format
    }

    private String interpretDefun(ASTDefun node) {
        StringBuilder sb = new StringBuilder();
        sb.append("public static ").append("void ").append(node.getFunctionName()).append("(");
        for (int i = 0; i < node.getParameters().size(); i++) {
            sb.append("int ").append(node.getParameters().get(i)); // Assuming parameters are integers
            if (i < node.getParameters().size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(") {\n");
        sb.append(interpret(node.getBody())).append("\n");//recursivity
        sb.append("}\n");
        return sb.toString();
    }

    private String interpretCond(ASTCond node) {
        StringBuilder sb = new StringBuilder();
        sb.append("if (").append(interpret(node.getCondition())).append(") {\n");
        sb.append(interpret(node.getThenBranch())).append("\n");
        sb.append("} else {\n");
        sb.append(interpret(node.getElseBranch())).append("\n");
        sb.append("}");
        return sb.toString();
    }
}