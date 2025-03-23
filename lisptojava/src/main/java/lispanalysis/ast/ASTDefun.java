package lispanalysis.ast;

import java.util.List;

public class ASTDefun extends ASTNode {
    private String functionName;
    private List<String> parameters;
    private ASTNode body;

    public ASTDefun(String functionName, List<String> parameters, ASTNode body) {
        this.functionName = functionName;
        this.parameters = parameters;
        this.body = body;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }

    public ASTNode getBody() {
        return body;
    }

    public void setBody(ASTNode body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Defun " + functionName + "(" + parameters + ") " + body;
    }

    public String toStringName() {
        return functionName;
    }
}