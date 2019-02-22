class SimpleCalculator {
    private double firstNumber;
    private double secondNumber;

    public double getFirstNumber() {
        return this.firstNumber;
    }
    public double getSecondNumber() {
        return this.secondNumber;
    }
    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }
    public double getAdditionResult() {
        return firstNumber+secondNumber;
    }
    public double getSubtractionResult() {
        return firstNumber-secondNumber;
    }
    public double getMultiplicationResult() {
        return secondNumber*firstNumber;
    }
    public double getDivisionResult() {
        if (secondNumber==0){
            return 0;
        }else{
            return firstNumber/secondNumber;
        }


    }


}