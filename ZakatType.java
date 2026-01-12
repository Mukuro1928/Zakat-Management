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
    
    public static double zakatPerniagaan(double income,double profit, double debtGiven, double stock,double  unpaidDebt,double  tax, double outstandingOp){
        double result=0;
        double liability, asset, totalWealth;
        asset=profit+debtGiven+stock;
        liability=unpaidDebt + tax + outstandingOp;
        totalWealth= asset - liability;
        if(totalWealth>=49300){
            result=totalWealth*(2.5/100);
        }
        else {
            result=-1;
        }
        
        
        return result;
    }
    
    public static double zakatEmas(){
        double result=0;
        
        return result;
    }
    
    public static double zakatSimpanan(){
        double result=0;
        
        return result;
    }
    
    public static double zakatPelaburan(){
        double result=0;
        
        return result;
    }
    
    public static double zakatASB(double asbValue, double dividend){
        double result=0;
        
            result = (asbValue+dividend)*0.025;
        
        return result;
    }
}




