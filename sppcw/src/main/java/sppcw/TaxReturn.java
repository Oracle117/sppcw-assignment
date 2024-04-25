package sppcw;

public class TaxReturn {
    private Income income;
    private Deductions deductions;

    private static final double PERSONAL_ALLOWANCE = 12000;

    private static final double BASIC_PERSONAL_SAVINGS_ALLOWANCE = 1200;

    private static final double HIGHER_PERSONAL_SAVINGS_ALLOWANCE = 500;
    private static final double BASIC_RATE_LIMIT = 50000;
    private static final double HIGHER_RATE_LIMIT = 150000;
    private static final double BASIC_RATE = 0.20;
    private static final double HIGHER_RATE = 0.40;
    private static final double ADDITIONAL_RATE = 0.45;

    public TaxReturn(Income income, Deductions deductions) {
        this.income = income;
        this.deductions = deductions;
    }

    public double calculateTaxableSavingsIncome(){
        if (income.taxBand() == Rate.BASIC){
            return (income.getSavingsIncome() - BASIC_PERSONAL_SAVINGS_ALLOWANCE);
        } else if ((income.taxBand() == Rate.HIGHER)){
            return (income.getSavingsIncome() - HIGHER_PERSONAL_SAVINGS_ALLOWANCE);
        } else {
            return income.getSavingsIncome();
        }
    }

    public double calculateTax() {
        double taxableIncome = income.getWorkIncome()
                + income.getSavingsIncome()
                - deductions.totalDeductions()
                - PERSONAL_ALLOWANCE;

        if (taxableIncome <= BASIC_RATE_LIMIT) {
            taxableIncome=taxableIncome-BASIC_PERSONAL_SAVINGS_ALLOWANCE;
            return taxableIncome * BASIC_RATE;
        } else if (taxableIncome <= HIGHER_RATE_LIMIT) {
            taxableIncome= taxableIncome - HIGHER_PERSONAL_SAVINGS_ALLOWANCE +50000;
            return ((taxableIncome * HIGHER_RATE)+10000);
        } else {
            taxableIncome=taxableIncome-150000;
            return ((taxableIncome* ADDITIONAL_RATE)+50000);
        }
    }

}

