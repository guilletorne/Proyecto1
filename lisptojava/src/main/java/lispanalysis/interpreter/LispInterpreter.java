package lispanalysis.interpreter;

import lispanalysis.ast.ASTNode;
import lispanalysis.ast.ASTDefun;
import lispanalysis.ast.ASTFunction;
import lispanalysis.ast.ASTFunctionCall;
import lispanalysis.ast.ASTCond;
import lispanalysis.ast.ASTLiteral;

public class LispInterpreter {
    
    public String interpretToMain(ASTNode node) {
        StringBuilder sb = new StringBuilder();
        sb.append("public class Generated {\n");
        sb.append("    public static void main(String[] args) {\n");
        if (node instanceof ASTDefun) {
            sb.append("         return " + ((ASTDefun) node).getFunctionName() + "();\n");
            //cast to ASTDefun
            sb.append("    }\n");
            sb.append("}\n\n");
            sb.append(interpret(node));
            return sb.toString();
        }
        sb.append("        " + interpret(node) + ";\n");
        sb.append("    }\n");
        sb.append("}\n");
        return sb.toString();
    }

    public String interpret(ASTNode node) {
        if (node instanceof ASTFunction) {
            return interpretFunction((ASTFunction) node);
        } else if (node instanceof ASTLiteral) {
            return interpretLiteral((ASTLiteral) node);
        } else if (node instanceof ASTDefun) {
            return interpretDefun((ASTDefun) node);
        } else if (node instanceof ASTCond) {
            return interpretCond((ASTCond) node);
        } else if (node instanceof ASTFunctionCall) {
            return interpretFunctionCall((ASTFunctionCall) node);
        }
        throw new IllegalArgumentException("Unknown AST node type: " + node.getClass());
    }

    private String interpretFunction(ASTFunction node) {
        StringBuilder sb = new StringBuilder();
        sb.append("System.out.println(");
        sb.append(node.getValue1());
        sb.append(" ");
        sb.append(node.getOperand());
        sb.append(" ");
        sb.append(node.getValue2());
        sb.append(");");
        return sb.toString();
    }

    private String interpretLiteral(ASTLiteral node) {
        return node.getValue(); 
    }

    private String interpretDefun(ASTDefun node) {
        StringBuilder sb = new StringBuilder();
        sb.append("public ").append("int ").append(node.getFunctionName()).append("(");
        for (int i = 1; i < node.getParameters().size(); i++) {
            //add other data types
            sb.append("int ").append(node.getParameters().get(i)); 
            //Assuming all parameters are integers
            if (i < node.getParameters().size() - 1 && i > 0) {
                sb.append(", ");
            }
        }
        sb.append(" ) { ");
        sb.append(interpret(node.getBody()));//recursivity
        sb.append(" }\n");
        return sb.toString();
    }

    private String interpretCond(ASTCond node) {
        StringBuilder sb = new StringBuilder();
        sb.append("if ( ").append(interpret(node.getCondition())).append(" ) {\n");
        sb.append(interpret(node.getThenBranch())).append(";\n");
        sb.append("} else {\n");
        sb.append(interpret(node.getElseBranch())).append(";\n");
        sb.append("}");
        return sb.toString();
    }

    private String interpretFunctionCall(ASTFunctionCall node) {
        StringBuilder sb = new StringBuilder();
        sb.append(node.getFunctionName()).append("(");
        sb.append(interpret(node.getArgument1()));
        sb.append(", ");
        sb.append(interpret(node.getArgument1()));
        sb.append(")");
        return sb.toString();
    }
}