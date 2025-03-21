package lispanalysis;

class ASTFunctionCall extends ASTNode {
    String functionName;
    List<ASTNode> arguments;

    public ASTFunctionCall(String functionName, List<ASTNode> arguments) {
        this.functionName = functionName;
        this.arguments = arguments;
    }

    @Override
    public String toString() {
        return functionName + "(" + arguments + ")";

    }

}