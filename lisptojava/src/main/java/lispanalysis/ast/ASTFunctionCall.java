package lispanalysis.ast;

import java.util.List;

public class ASTFunctionCall extends ASTNode {
    private String functionName;
    private List<ASTNode> arguments;

    public ASTFunctionCall(String functionName, List<ASTNode> arguments) {
        this.functionName = functionName;
        this.arguments = arguments;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public List<ASTNode> getArguments() {
        return arguments;
    }

    public void setArguments(List<ASTNode> arguments) {
        this.arguments = arguments;
    }

    @Override
    public String toString() {
        return functionName + "(" + arguments + ")";

    }
}