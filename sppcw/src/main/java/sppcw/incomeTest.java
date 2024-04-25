package sppcw;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import sppcw.Income;
import sppcw.Rate;



public class incomeTest {


@Test
    public void testGetWorkIncome (){
    Income accounts = new Income(20000, 10000);

    assertEquals (20000, accounts.getWorkIncome(), "Test get work income");}

@Test
   public void testGetSavingsIncome (){
    Income accounts = new Income(20000, 10000);
    assertEquals (10000, accounts.getSavingsIncome(), "Test get savings income");}

@Test
    public void testTaxBandBasic (){
    Income accounts = new Income(20000, 10000);
    assertEquals (Rate.BASIC, accounts.taxBand(), "Test tax band basic");}

@Test
    public void testTaxBandHigher (){
    Income accounts = new Income(140000, 10000);
    assertEquals (Rate.HIGHER, accounts.taxBand(), "Test tax band higher");}


    @Test
    public void testTaxBandAdditional (){
    Income accounts = new Income(190000, 25000);
    assertEquals (Rate.ADDITIONAL, accounts.taxBand(), "Test tax band additional");}
}