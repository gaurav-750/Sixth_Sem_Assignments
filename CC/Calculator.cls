public class Calculator {
    public double firstNum{get; set;} 
    public double secondNum{get; set;}
    public double result{get; set;}
    
    
    public void addition(){
 		result = firstNum + secondNum;       
    }
    
    public void subtraction(){
 		result = firstNum - secondNum;       
    }
    
    public void multiplication(){
 		result = firstNum * secondNum;       
    }
    
    public void division(){
 		result = firstNum / secondNum;       
    }
    
    public void factorial(){
 		result = 1;
        for(integer i = 1; i <= firstNum; i++){
            result *= i;
        }       
    }
    
    public void squareRoot(){
        result = Math.sqrt(firstNum);
    }
    
    public void power(){
        result = Math.pow(firstNum, secondNum);
    }
    

    
    
}