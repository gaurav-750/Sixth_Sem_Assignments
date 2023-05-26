public class CurrencyConv_Afternoon {
    public String currency1{get; set;}
    public String currency2{get; set;}
    
    public String value1{set; get;}
    public double result{set; get;}
    public String err{set; get;}
    
    public void convert(){
        if (!value1.isNumeric()){
            err = 'Value must be numeric!';
            result = 99999;
            return;
        }
        	
        Double n1 = Double.valueOf(value1); //convert string into double number
        if (currency1 == currency2){
            result = n1;
        }else if (currency1 == 'Rupee' && currency2 == 'Dollar'){
            result = n1/82.77;
        }else if (currency1 == 'Dollar' && currency2 == 'Rupee'){
            result = (n1)*82.77;
        }else if (currency1 == 'Pound' && currency2 == 'Rupee'){
            result = (n1)*102.22;
        }else if (currency1 == 'Rupee' && currency2 == 'Pound'){
 			result = (n1)/102.22;           
        }else if (currency1 == 'Dollar' && currency2 == 'Pound'){
            result = n1/1.24;
        }else if (currency1 == 'Pound' && currency2 == 'Dollar'){
            result = (n1)*1.24;
        }
        
        err = '';
    }
    

}