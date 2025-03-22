package lispanalysis.ast;

public class ASTCond extends ASTNode {
    ASTNode condition;
    ASTNode thenBranch;
    ASTNode elseBranch;

    public ASTCond(ASTNode condition, ASTNode thenBranch, ASTNode elseBranch) {
        this.condition = condition;
        this.thenBranch = thenBranch;
        this.elseBranch = elseBranch;
    }

    public ASTNode getCondition() {
        return condition;
    }

    public void setCondition(ASTNode condition) {
        this.condition = condition;
    }

    public ASTNode getThenBranch() {
        return thenBranch;
    }

    public void setThenBranch(ASTNode thenBranch) {
        this.thenBranch = thenBranch;
    }

    public ASTNode getElseBranch() {
        return elseBranch;
    }

    public void setElseBranch(ASTNode elseBranch) {
        this.elseBranch = elseBranch;
    }

    @Override
    public String toString() {
        return "Cond(" + condition + ", " + thenBranch + ", " + elseBranch + ")";
    }
}