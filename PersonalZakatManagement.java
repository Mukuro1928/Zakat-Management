package personalzakatmanagement;

import java.util.*;

public class PersonalZakatManagement {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double result=0;
        int choice=0;
        String zakat="";
        do{                
            try{
                //Print Utils
                System.out.println("-----Welcome to Zakat Calculator-----");
                System.out.println("1. Zakat Pendapatan");
                System.out.println("2. Zakat Perniagaan");
                System.out.println("3. Zakat Emas");
                System.out.println("4. Zakat Simpanan");
                System.out.println("5. Zakat Pelaburan");
                System.out.println("6. Zakat ASB");
                System.out.println("Which Zakat you want to calculate:");
                //Getting Input from user
                choice= input.nextInt();    
                switch(choice){
                    case 1: zakat="Zakat Pendapatan";
                            double yearlyProfit = 0, adultDependant = 0, studentDependant = 0, teenDependant = 0, toddlerDependant = 0, disabledDependant = 0, chronicDependant = 0, nurseryCost = 0;
                            System.out.print("Enter yearly net profit: ");
                            yearlyProfit = input.nextDouble();
                            System.out.print("Enter amount of dependants that are above 18 years old: ");
                            adultDependant = input.nextDouble();
                            System.out.print("Enter amount of dependants that is studying in IPT: ");
                            studentDependant = input.nextDouble();
                            System.out.print("Enter amount of dependants aged around 7-17 years old: ");
                            teenDependant = input.nextDouble();
                            System.out.print("Enter amount of dependants aged below 6 years old: ");
                            toddlerDependant = input.nextDouble();
                            System.out.print("Enter amount of disabled children: ");
                            disabledDependant = input.nextDouble();
                            System.out.print("Enter amount of dependant chronic patients: ");
                            chronicDependant = input.nextDouble();
                            System.out.print("Enter yearly cost of nursery & childcare center: ");
                            nurseryCost = input.nextDouble();
                            result = ZakatType.zakatPendapatan(yearlyProfit, adultDependant, studentDependant, teenDependant, toddlerDependant, disabledDependant, chronicDependant, nurseryCost);
                            break;
                    case 2: zakat="Zakat Perniagaan";
                            double[] asset = new double[4];
                            double[] liability = new double[3];
                            //Getting input from user
                            System.out.print("Enter net profit: ");
                            asset[0]= input.nextDouble();
                            System.out.print("Enter business bank balance: ");
                            asset[1]= input.nextDouble();
                            System.out.print("Enter the pending amount of debt given: ");
                            asset[2]= input.nextDouble();
                            System.out.print("Enter the overall value of stocks: ");
                            asset[3]= input.nextDouble();
                            System.out.print("Any unpaid debts? ");
                            liability[0]=input.nextDouble();
                            System.out.print("Any unpaid tax? ");
                            liability[1]=input.nextDouble();
                            System.out.print("Any Outstanding Operations? ");
                            liability[2]=input.nextDouble();
                            //calling zakatPerniagaan method to calculate zakat
                            result = ZakatType.zakatPerniagaan(asset, liability);
                            
                            break;
                    case 3: zakat="Zakat Emas"; 
                            double weightGold=0, priceGold=554, nisab=85, payrate=0.025;
                            System.out.print("Gold Zakat calculation for the year: ");
                            int year = input.nextInt();
                            System.out.print("Total Weight(g) of Gold at the End of the Year "+year+": ");
                            weightGold = input.nextDouble();
                            System.out.print("The Value of Gold Nisab for Zakat (Selangor 2025): "+nisab+"g");
                            System.out.print("Current Gold Price (1g): RM"+priceGold);
                            result = ZakatType.zakatEmas(weightGold, priceGold, nisab, payrate);
                            break;
                    case 4: zakat="Zakat Simpanan";
                            double saving=0, payrate=0.025;
                            System.out.print("Calculation of Zakat on Savings for the haul year: ");
                            int year = input.nextInt();
                            System.out.print("Enter estimated Total Savings for the year "+year+": ");
                            saving= input.nextDouble();
                            result = ZakatType.zakatSimpanan(saving, payrate);
                            break;
                    case 5: zakat="Zakat Pelaburan";
                            double invNisab = 35449.00;
                            
                            System.out.println("\nEnter current investment value (RM): ");
                            double invValue = input.nextDouble();
                            System.out.print("Enter investment profit/divident (RM): ");
                            double profit = input.nextDouble(); 
                            
                            double invTotal = invValue+profit;
                            
                            if(invTotal>invNisab){
                                result = ZakatType.zakatPelaburan(invTotal);
                            }else{
                                 System.out.println("\nYou does not meet the nisab to pay " + zakat);
                            }
                                               
                            break;
                    case 6: zakat="Zakat ASB";
                            double asbNisab = 35449.00;
                            
                            System.out.print("\nEnter ASB value you own (RM): ");
                            double asbValue = input.nextDouble();
                            System.out.print("Enter ASB dividend (RM): ");
                            double dividend = input.nextDouble();
                            
                            double asbTotal = asbValue+dividend;
                            
                            if(asbTotal>=asbNisab){
                                result = ZakatType.zakatASB(asbTotal);
                            }else{
                                System.out.println("\nYou does not meet the nisab to pay " + zakat);
                            }
                        
                            break;
                    default: System.out.println("Invalid Input, Please enter only number 1 to 6 only");                
                }
            }
            //Checking for Error Input
            catch(InputMismatchException e){
                System.out.println("Invalid input, please enter an integer");
                input.next();//important, youw ant to clear the buffer
                choice = 0;
            }
            catch(ArithmeticException e){
                System.out.println("Math Error: " + e.toString());
            }
            catch(Exception e){
                System.out.println("An unexpected error has occured: " + e.getMessage());
            }      
        }while(choice!=1 && choice!=2 && choice!=3 && choice!=4 && choice!=5 && choice!=6);
        if( result!=-1){
            System.out.print("The total " + zakat + " you have to pay is RM");
            //Rounding the numbers to 2 decimal places.
            System.out.format("%.2f", result);
        }
        else{
            System.out.println("You does not meet the nisab to pay " + zakat);
        }
    }
}
