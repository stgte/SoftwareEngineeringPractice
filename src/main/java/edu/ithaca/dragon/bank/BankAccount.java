package edu.ithaca.dragon.bank;

public class BankAccount {

    private String email;
    private double balance;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(String email, double startingBalance){
        if (isEmailValid(email) && isAmountValid(startingBalance)){
            this.email = email;
            this.balance = startingBalance;
        }
        else if(!isAmountValid(startingBalance)){
            throw new IllegalArgumentException("Balance: "+ startingBalance +"is invalid");
        }
        else {
            throw new IllegalArgumentException("Email address: " + email + " is invalid, cannot create account");
        }
    }

    public double getBalance(){
        return balance;
    }

    public String getEmail(){
        return email;
    }

    /**
     * @post reduces the balance by amount if amount is non-negative and smaller than balance
     */
    public void withdraw (double amount)  {
        if (amount>balance || !isAmountValid(amount)){
            throw new IllegalArgumentException("Invalid amount");
        }
        else {
            balance -= amount;
        }

    }
    /**
     * returns true is amount is valid, if it's positive and has less than 2 decimal points
     * args: double
     * o: bool
     */
    public static boolean isAmountValid(Double amount) {
        if (amount<0){
            return false;
        }
        String amountStr=Double.toString(amount);
        int count=0;
        for (int i=amountStr.indexOf('.'); i<amountStr.length();i++){
            count++;
        }
        if (count>3){
            return false;
        }
        else{
            return true;
        }
    }

    public static boolean isEmailValid(String email){
        if (email.indexOf('@') == -1 || email.indexOf('@')==0){
            return false;
        }
        if (email.indexOf('.')==-1){
            return false;
        }
        int count=0;
        for (int i=email.indexOf('@'); i<email.length(); i++){
            if (email.charAt(i)==('.')){
                count++;
            }
        }
        if (count!=1){
            return false;
        }
        if (email.length()<5){
            return false;
        }
        int count1=0;
        int count2=0;
        for (int i=0; i<email.length(); i++){
            if (email.charAt(i)==(' ')){
                count1++;
            }
            if (email.charAt(i)==('@')){
                count2++;
            }
        }
        if (count1!=0 || count2!=1){
            return false;
        }
        else {
            return true;
        }
    }
}
