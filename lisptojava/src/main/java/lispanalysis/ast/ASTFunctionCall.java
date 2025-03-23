package lispanalysis.ast;

public class ASTFunctionCall extends ASTNode {
    private String functionName;
    private ASTNode argument1;
    private ASTNode argument2;

    public ASTFunctionCall(String functionName, ASTNode argument1, ASTNode argument2) {
        this.functionName = functionName;
        this.argument1 = argument1;
        this.argument2 = argument2;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public ASTNode getArgument1() {
        return argument1;
    }

    public void setArgument1(ASTNode argument1) {
        this.argument1 = argument1;
    }

    public ASTNode getArgument2() {
        return argument2;
    }

    public void setArgument2(ASTNode argument2) {
        this.argument2 = argument2;
    }

    @Override
    public String toString() {
    return "FunctionCall(" + functionName + ", " + argument1 + ", " + argument2 + ")";
    }
    
}