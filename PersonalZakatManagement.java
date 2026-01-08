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
                    case 1: result = ZakatType.zakatPendapatan();
                            zakat="Zakat Pendapatan";
                            break;
                    case 2: result = ZakatType.zakatPerniagaan();
                            zakat="Zakat Perniagaan";
                            break;
                    case 3: result = ZakatType.zakatEmas();
                            zakat="Zakat Emas";
                            break;
                    case 4: result = ZakatType.zakatSimpanan();
                            zakat="Zakat Simpanan";
                            break;
                    case 5: result = ZakatType.zakatPelaburan();        
                            zakat="Zakat Pelaburan";
                            break;
                    case 6: result = ZakatType.zakatASB();
                            zakat="Zakat ASB";
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
        double resultRounded=Math.round(result);
        System.out.print("The total " + zakat + " you have to pay is RM");
        //Rounding the numbers to 2 decimal places.
        System.out.format("%.2f", result);
    }
}
