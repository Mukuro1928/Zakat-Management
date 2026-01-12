package personalzakatmanagement;

public class ZakatType {
    public static double zakatPendapatan(double yearlyProfit, double adultDependant, double studentDependant, double teenDependant, double toddlerDependant, double disabledDependant, double chronicDependant, double nurseryCost ){
        double result=0;
        double EPF, totalDeduction, netIncome;
        adultDependant *= 4944;
        studentDependant *= 7356;
        teenDependant *= 4896;
        toddlerDependant *= 2100;
        disabledDependant *= 2964;
        chronicDependant *= 2916;
        nurseryCost *= 3960;
        EPF = yearlyProfit * 0.11;
        totalDeduction = adultDependant + studentDependant + teenDependant + toddlerDependant + disabledDependant + chronicDependant + nurseryCost + EPF;
        netIncome = yearlyProfit - totalDeduction;
        
        if(netIncome >= 35449){
            result = netIncome*(0.025);
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
    
    public static double zakatEmas(double weightGold, double priceGold, double nisab, double payrate){
        double result=0, gold=0;
        if(weightGold>=nisab){
            gold= weightGold*priceGold;
            result= gold*payrate;
        }else{
            result= -1;
        }
        
        return result;
    }
    
    public static double zakatSimpanan(double saving, double payrate){
        double result=0;
        result= saving*payrate;
        return result;
    }
    
    public static double zakatPelaburan(double invTotal){
        double result=0;
        
        result = invTotal*0.025;
        
        return result;
    }
    
    public static double zakatASB(double asbTotal){
        double result=0;
        
        result = asbTotal*0.025;
        
        return result;
    }
}









