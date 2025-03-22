package lispanalysis.ast;

public class ASTLiteral extends ASTNode {
    private String value;

    public ASTLiteral(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}