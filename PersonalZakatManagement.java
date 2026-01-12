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
                            double yearlyProfit;
                            double nurseryCost;
                            double[] dependants = new double[6]; //array for easier input data access
                            System.out.print("Enter yearly net profit: ");
                            yearlyProfit = input.nextDouble();
                            System.out.print("Enter amount of dependants that are above 18 years old: ");
                            dependants[0] = input.nextDouble();
                            System.out.print("Enter amount of dependants that is studying in IPT: ");
                            dependants[1] = input.nextDouble();
                            System.out.print("Enter amount of dependants aged around 7-17 years old: ");
                            dependants[2] = input.nextDouble();
                            System.out.print("Enter amount of dependants aged below 6 years old: ");
                            dependants[3] = input.nextDouble();
                            System.out.print("Enter amount of disabled children: ");
                            dependants[4] = input.nextDouble();
                            System.out.print("Enter amount of dependant chronic patients: ");
                            dependants[5] = input.nextDouble();
                            System.out.print("Enter yearly cost of nursery & childcare center: ");
                            nurseryCost = input.nextDouble();
                            result = ZakatType.zakatPendapatan(yearlyProfit, dependants, nurseryCost);
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
                            
                            System.out.print("\nEnter ASB value you own (RM): ");
                            double invValue = input.nextDouble();
                            System.out.print("Enter ASB dividend (RM): ");
                            double profit = input.nextDouble();
                            
                            result = ZakatType.zakatPelaburan(invValue, profit);
                                               
                            break;
                    case 6: zakat="Zakat ASB";
                            
                            System.out.print("\nEnter ASB value you own (RM): ");
                            double asbValue = input.nextDouble();
                            System.out.print("Enter ASB dividend (RM): ");
                            double dividend = input.nextDouble();
                            
                            result = ZakatType.zakatASB(asbValue, dividend);
                            
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
