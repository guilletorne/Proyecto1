package lispanalysis;

class ASTIf extends ASTNode {
    ASTNode condition;
    ASTNode thenBranch;
    ASTNode elseBranch;

    public ASTIf(ASTNode condition, ASTNode thenBranch, ASTNode elseBranch) {
        this.condition = condition;
        this.thenBranch = thenBranch;
        this.elseBranch = elseBranch;
    }

    @Override
    public String toString() {
        return "If(" + condition + ", " + thenBranch + ", " + elseBranch + ")";
    }
}