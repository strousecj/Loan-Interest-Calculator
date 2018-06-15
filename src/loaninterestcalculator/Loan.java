
package loaninterestcalculator;

public class Loan{
    private double principal;
    private double interestRate;
    private Long numDays;
    private double interest;
    
    public void setPrincipal(double p){
        this.principal = p;
    }
    
    public void setInterestRate(double r){
        this.interestRate = r;
    }
    
    public void setNumDays(Long d){
        this.numDays = d;
    }
    
    public void setInterest(double i){
        this.interest = i;
    }
    
    public double getPrincipal(){
        return this.principal;
    }
    
    public double getInterestRate(){
        return this.interestRate;
    }
    
    public Long getNumDays(){
        return this.numDays;
    }
    
    public double getInterest(){
        return this.interest;
    }
    
    public double calcLoanInterest(){
//        System.out.println("interest: " + interest);
//        System.out.println("Num days: " + numDays);
//        System.out.println("interestRate: " + interestRate);
//        System.out.println("principal: " + principal);
        double loanInterest;
        loanInterest = (((numDays / 365.00) * (interestRate / 100.00)) * principal);
        return loanInterest;
    }
}
