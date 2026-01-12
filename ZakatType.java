package personalzakatmanagement;

public class ZakatType {
    public static double zakatPendapatan(double yearlyProfit, double[] dependants, double nurseryCost){ //by Rizq
        double result = 0, totalDeduction = 0;
        double EPF, netIncome;
        double[] rates = {4944, 7356, 4896, 2100, 2964, 2916}; // assigning respective rate for each dependant category

        //calculating total deduction based on rates
        for (int i = 0; i < dependants.length; i++) {
        totalDeduction += dependants[i] * rates[i]; //calculating dependants based on their respective rate and summing them up in totalDeduction
        }
        
        totalDeduction += Math.min(nurseryCost, 3960);
        EPF = yearlyProfit * 0.11; //calculate the EPF contribution based on your yearly profit 
        totalDeduction += EPF; // adds EPF to totalDeduction as final
        netIncome = yearlyProfit - totalDeduction; // calculate net income
        
        if(netIncome >= 35449){ //checks if elligible for Zakat
            result = netIncome * (0.025); //calculate total Zakat Pendapatan
        }else{
            result = -1;
        }
        return result;
    }
    
    public static double zakatPerniagaan(double[] income,double[]  spending){
        double result=0;
        double liability=0, asset=0, totalWealth=0;
        for(int i=0;i<income.length;i++){
           asset+=income[i];
        }
        for(int i=0;i<spending.length;i++){
           asset+=spending[i];
        }
        totalWealth= asset - liability;
        if(totalWealth>=49300){
            result=totalWealth*(2.5/100);
        }
        else {
            result=-1;
        }
             
        return result;
    }
    
    public static double zakatEmas(double weightGold, double priceGold, double nisab, double payrate){ //by Aiman : Zakat Emas Calculation
        double result=0, gold=0;
        if(weightGold>=nisab){ //if-else statement for nisab
            gold= weightGold*priceGold;
            result= gold*payrate; //calculate zakat emas
        }else{
            result= -1; //don't need to pay zakat
        }
        
        return result;
    }
    
    public static double zakatSimpanan(double saving, double payrate){ //by Aiman : Zakat Simpanan Calculation
        double result=0;
        result= saving*payrate; //calculate zakat simpanan
        return result;
    }
    
    public static double zakatPelaburan(double invValue, double profit){
        double result=0;
        double nisab = 35449.00;

        //calculate total income from the investment
        double invTotal = invValue+profit;
        
        if(invTotal>=nisab){ //to ensure total income reach minimum value for zakat compulsion
            result = invTotal*0.025; //amount of zakat calculated
        }else{
            result = -1; //to signal no zakat payment is needed
        }
        
        return result;
    }
    
    public static double zakatASB(double asbValue, double dividend){
        double result=0;
        double nisab = 35449.00;

        //calculate total income from the ASB
        double asbTotal = asbValue+dividend;
        
        if(asbTotal>=nisab){ //to ensure total income reach minimum value for zakat compulsion
            result = asbTotal*0.025; //amount of zakat calculated
        }else{
            result = -1; //to signal no zakat payment is needed
        }
        
        return result;
    }
}

















