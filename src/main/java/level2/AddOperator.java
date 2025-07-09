package level2;

class AddOperator implements Operator{

    public boolean isAvailable(char operator) {
        return operator == '+';
    }

    public double operate(double num1, double num2){
        return num1 + num2;
    }
}
