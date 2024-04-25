package sppcw;
import lombok.Getter;
import lombok.Data;

public @Data class Income {

    private double workIncome;
    private double savingsIncome;

    private static final double BASIC_RATE_LIMIT = 50000;

    private static final double HIGHER_RATE_LIMIT = 150000;


    public Income(double workIncome, double savingsIncome){
        this.workIncome = workIncome;
        this.savingsIncome = savingsIncome;
    }

    public Rate taxBand(){
        if((workIncome + savingsIncome)<BASIC_RATE_LIMIT)
            return Rate.BASIC;
        else if((workIncome + savingsIncome)<=HIGHER_RATE_LIMIT)
            return Rate.HIGHER;
        else
            return Rate.ADDITIONAL;
    }


}
