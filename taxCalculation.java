package com.company;

import java.util.Scanner;
class taxCalculation{

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        double tax_slab1=0;
        double tax_slab2=0;
        double tax_slab3=0;
        // Enter annual income
        double income = scan.nextDouble();
        // Enter age
        int age = scan.nextInt();
        double tax = 0.0;

//income slab 1
        if(income>=250001 && income<=300000){
            if(age<60){
                tax_slab1 = 0.1*(income-250000);
            }else
                System.out.print("your income is not taxable !");
 //income slab 2
        }else if(income>=300001 && income<=500000){
            if(age<=60){
                tax_slab1 = 0.1*(300000-250000);
                tax_slab2 = 0.1*(income-300000);
                tax = tax_slab1 + tax_slab2;
            }else if(age>60 && age<80){
                tax_slab1 = 0;
                tax_slab2 = 0.1*(income-300000);
                tax = tax_slab1 + tax_slab2;
            }else
                System.out.print("your income is not taxable !");
//income in slab 3
        }else if(income>=500001 && income<=1000000){
            if(age<=60){
                tax_slab3 = 0.2*(income-500000);
                tax_slab2 = 0.1*(500000-300000);
                tax_slab1 = 0.1*(300000-250000);
                tax = tax_slab2+tax_slab3+tax_slab1;
            }else if(age>60 && age <80){
                tax_slab2 = 0.1*(income-500000-300000);
                tax_slab3 = 0.2*(income-500000);
                tax = tax_slab2 + tax_slab3;
            }
        }else if(income>1000000){
            tax = 0.3*income;
        }
        System.out.print(tax);
        scan.close();
    }
}
