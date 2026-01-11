package personalzakatmanagement;

public class ZakatType {
    public static double zakatPendapatan(){
        double result=0;
        
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
    
    public static double zakatASB(){
        double result=0;
        
        return result;
    }
}


