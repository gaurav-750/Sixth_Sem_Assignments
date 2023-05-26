public class Calculator_Afternoon {

    public String firstNum{get; set;}
    public String secondNum{get; set;}
    
    public double result{get; set;}
    public String err{get; set;}
    
    public void addition(){
        if (firstNum.isNumeric() && secondNum.isNumeric()){
            Double n1 = Double.valueOf(firstNum);
            Double n2 = Double.valueOf(secondNum);
            result = n1+n2;
            err = '';
        }else {
            result = 99999;
            err = 'Please enter numeric value!';
        }
    }
    
    public void subtraction(){
       if (firstNum.isNumeric() && secondNum.isNumeric()){
            Double n1 = Double.valueOf(firstNum);
            Double n2 = Double.valueOf(secondNum);
            result = n1 - n2;
            err = '';
        }else {
            result = 99999;
            err = 'Please enter numeric value!';
        }
    }
    
    public void multiplication(){
        if (firstNum.isNumeric() && secondNum.isNumeric()){
            Double n1 = Double.valueOf(firstNum);
            Double n2 = Double.valueOf(secondNum);
            result = n1*n2;
            err = '';
        }else {
            result = 99999;
            err = 'Please enter numeric value!';
        }
    }
    
    public void division(){
        if(firstNum.isNumeric() && secondNum.isNumeric()){
            Double n1 = Double.valueOf(firstNum);
            Double n2 = Double.valueOf(secondNum);
            if (n2 == 0){
                err = 'Denominator cannot be zero!';
                return;
            }
            
            result = n1/n2;
            err = '';
        }else {
           	result = 99999;
            err = 'Please enter numeric value!';
        }
    }
    
   	public void factorial(){
        if (firstNum.isNumeric()){
            Double n1 = Double.valueOf(firstNum);
            result = 1;
            for (integer i = 1; i <= n1; i++){
                result *= n1;
            }
            err = '';
        }else {
            result = 99999;
            err = 'Please enter numeric value!';
        }
    }
    
    public void log10(){
        if (firstNum.isNumeric()){
            Double n1 = Double.valueOf(firstNum);
            result = Math.log10(n1);
            err = '';
        }else {
            result = 99999;
            err = 'Please enter numeric value!';
        }
    }
    
    public void max(){
        if (firstNum.isNumeric() && secondNum.isNumeric()){
            Double n1 = Double.valueOf(firstNum);
            Double n2 = Double.valueOf(secondNum);
            result = Math.max(n1, n2);
            err = '';
        }else {
            result = 99999;
            err = 'Please enter numeric value!';
        }
    }
    
    public void min(){
        if (firstNum.isNumeric() && secondNum.isNumeric()){
            Double n1 = Double.valueOf(firstNum);
            Double n2 = Double.valueOf(secondNum);
            result = Math.min(n1, n2);
            err = '';
        }else {
            result = 99999;
            err = 'Please enter numeric value!';
        }
    }



}