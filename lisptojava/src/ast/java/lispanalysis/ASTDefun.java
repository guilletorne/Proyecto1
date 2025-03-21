package lispanalysis;

class ASTDefun extends ASTNode {
    String functionName;
    List<String> parameters;
    ASTNode body;

    public ASTDefun(String functionName, List<String> parameters, ASTNode body) {
        this.functionName = functionName;
        this.parameters = parameters;
        this.body = body;
    }

    @Override
    public String toString() {
        return "Defun " + functionName + "(" + parameters + ") " + body;
    }
}