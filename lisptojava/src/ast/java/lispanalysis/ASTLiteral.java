package lispanalysis;

class ASTLiteral extends ASTNode {
    String value;

    public ASTLiteral(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}