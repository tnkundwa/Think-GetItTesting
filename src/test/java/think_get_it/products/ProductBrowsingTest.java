package think_get_it.products;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import think_get_it.BaseTests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import static org.testng.Assert.assertEquals;

public class ProductBrowsingTest extends BaseTests {
    @BeforeClass
    public void beforeClass(){
        loginPage.navigate("baseUrl");
        loginPage.login("standard_user", "secret_sauce");
    }
    @Test
    public void testSortByNameAtoZ(){
        List<String> actualNamesBefore = productPage.getAllItemsNames();
        productPage.sortItems("az");
        List<String> expectedNames = actualNamesBefore.stream().sorted().toList();
        List<String> actualNamesAfter = productPage.getAllItemsNames();
        assertEquals(actualNamesAfter, expectedNames);
    }

    @Test
    public void testSortByNameZtoA(){
        List<String> actualNamesBefore = productPage.getAllItemsNames();
        productPage.sortItems("za");
        List<String> expectedNames = new ArrayList<>(actualNamesBefore.stream().sorted().toList());
        List<String> actualNamesAfter = productPage.getAllItemsNames();
        Collections.reverse(expectedNames);
        assertEquals(actualNamesAfter, expectedNames);
    }

    @Test
    public void testSortByPriceLowHigh(){
        List<Double> actualPricesBefore = productPage.getAllItemsPrices();
        productPage.sortItems("lohi");
        List<Double> expectedPrices = actualPricesBefore.stream().sorted().toList();
        List<Double> actualPricesAfter = productPage.getAllItemsPrices();
        assertEquals(actualPricesAfter, expectedPrices);
    }

    @Test
    public void testSortByPriceHighLow(){
        List<Double> actualPricesBefore = productPage.getAllItemsPrices();
        productPage.sortItems("hilo");
        List<Double> expectedPrices = new ArrayList<>(actualPricesBefore.stream().sorted().toList());
        List<Double> actualPricesAfter = productPage.getAllItemsPrices();
        Collections.reverse(expectedPrices);
        assertEquals(actualPricesAfter, expectedPrices);
    }
}