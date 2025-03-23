package lispanalysis.ast;

public class ASTFunction extends ASTNode {
    private String operand;
    private String value1;
    private String value2;

    public ASTFunction(String operand, String value1, String value2) {
        this.operand = operand;
        this.value1 = value1;
        this.value2 = value2;
    }

    public String getOperand() {
        return operand;
    }

    public void setOperand(String operand) {
        this.operand = operand;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    @Override
    public String toString() {
        return "ASTFunction [operand=" + operand + ", value1=" + value1 + ", value2=" + value2 + "]";
    }
}