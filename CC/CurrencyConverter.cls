public class CurrencyConverter {
    
    public String currency1{get; set;}
    public String currency2{get; set;}
    public double value1{get; set;}
    public double result{get; set;}
    
    public void convert(){
        if (currency1 == currency2){
 			result = value1;           
        }else if (currency1 == 'Rupee' && currency2 == 'Dollar'){
            result = value1/82.77;
        }else if (currency1 == 'Dollar' && currency2 == 'Rupee'){
            result = (value1)*82.77;
        }else if (currency1 == 'Pound' && currency2 == 'Rupee'){
            result = (value1)*102.22;
        }else if (currency1 == 'Rupee' && currency2 == 'Pound'){
 			result = (value1)/102.22;           
        }else if (currency1 == 'Dollar' && currency2 == 'Pound'){
            result = value1/1.24;
        }else if (currency1 == 'Pound' && currency2 == 'Dollar'){
            result = (value1)*1.24;
        }
    }   
    
    
    

}