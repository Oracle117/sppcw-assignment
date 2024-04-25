package sppcw;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import sppcw.Deductions;



public class deductionsTest {
    Deductions accounts = new Deductions();

@Test
    public void testInitialDeductions (){
    assertEquals (0, accounts.totalDeductions(), "Test initial total deductions is = 0 ");}

@Test
    public void testAddDeduction (){
    accounts.addDeduction("donation", 1000);
    assertEquals (1000, accounts.totalDeductions(), "Test add deduction");}

@Test
    public void testTotalDeductions (){
    accounts.addDeduction("donation", 1000);
    accounts.addDeduction("rent", 500);
    assertEquals (1500, accounts.totalDeductions(), "Test total deductions");}

@Test
    public void testListOfDeductions (){
    accounts.addDeduction("donation", 1000);
    assertEquals ("deductions:donation", accounts.listOfDeductions(), "Test list of deductions");}
@Test
    public void testListOfDeductionsEmpty (){
    assertEquals ("no deductions", accounts.listOfDeductions(), "Test list of deductions empty");}
}
