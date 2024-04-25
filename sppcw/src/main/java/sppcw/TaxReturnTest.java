package sppcw;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import sppcw.TaxReturn;
import sppcw.Income;
import sppcw.Deductions;

public class TaxReturnTest {

Deductions deductions = new Deductions();
Income income = new Income(20000, 10000);


@Test
    public void testCalculateTaxableSavingsIncomeBasic (){
    Income income = new Income(20000, 10000);
    TaxReturn accounts = new TaxReturn(income, deductions);
    assertEquals (8800, accounts.calculateTaxableSavingsIncome(), "Test calculate taxable savings income basic");}

@Test
    public void testCalculateTaxableSavingsIncomeHigher (){
        Income income = new Income(140000, 10000);
        TaxReturn accounts = new TaxReturn(income, deductions);
        assertEquals (9500, accounts.calculateTaxableSavingsIncome(), "Test calculate taxable savings income higher");}

@Test
    public void testCalculateTaxableSavingsIncomeAdditional (){
        Income income = new Income(190000, 10000);
        TaxReturn accounts = new TaxReturn(income, deductions);
        assertEquals (10000, accounts.calculateTaxableSavingsIncome(), "Test calculate taxable savings income additional");}

@Test 
    public void testCalculateTax (){
    Income income = new Income(25000, 25000);
    TaxReturn accounts = new TaxReturn(income, deductions);
    assertEquals (7360, accounts.calculateTax(), "Test calculate tax");}

@Test
    public void testCalculateTaxHigher (){
        Income income = new Income(70000, 70000);
        TaxReturn accounts = new TaxReturn(income, deductions);
        assertEquals (81000, accounts.calculateTax(), "Test calculate tax higher");}

@Test
    public void testCalculateTaxAdditional (){
        Income income = new Income(100000, 100000);
        TaxReturn accounts = new TaxReturn(income, deductions);
        assertEquals (67100, accounts.calculateTax(), "Test calculate tax additional");}

}