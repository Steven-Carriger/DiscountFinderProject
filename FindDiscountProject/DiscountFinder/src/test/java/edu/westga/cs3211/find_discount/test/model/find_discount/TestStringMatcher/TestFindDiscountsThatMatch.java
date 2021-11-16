package edu.westga.cs3211.find_discount.test.model.find_discount.TestStringMatcher;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collection;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.find_discount.model.Category;
import edu.westga.cs3211.find_discount.model.Discount;
import edu.westga.cs3211.find_discount.model.DiscountManager;
import edu.westga.cs3211.find_discount.model.StringMatcher;

public class TestFindDiscountsThatMatch {
    
    @Test
	public void testWhenOneDiscountMatchesTheName() {
        StringMatcher stringMatcher = new StringMatcher();
        DiscountManager manager = new DiscountManager();

        Discount test = new Discount(Category.FRUITS, 25, "Banana");
        Discount testDiscount = new Discount(Category.TOOLS, 50, "Power Drill");

        manager.addDiscount(test);
		manager.addDiscount(testDiscount);

        Collection<Discount> result = stringMatcher.findDiscountsThatMatch("Ban", manager.getDiscounts());

        assertAll(
           () -> assertEquals(1, result.size(), "checking if the String Matcher correctly matched a discount to the string provided."),
           () -> assertEquals(false, result.contains(testDiscount), "Checking if the String Matcher contains a discount that should not match"),
           () -> assertEquals(true, result.contains(test), "Checking if the String Matcher contains a discount that should match.")
        );
	}

    @Test
	public void testWhenNoDiscountMatchesTheName() {
        StringMatcher stringMatcher = new StringMatcher();
        DiscountManager manager = new DiscountManager();
        
        Discount test = new Discount(Category.FRUITS, 25, "Banana");
        Discount testDiscount = new Discount(Category.TOOLS, 50, "Power Drill");

        manager.addDiscount(test);
		manager.addDiscount(testDiscount);

        Collection<Discount> result = stringMatcher.findDiscountsThatMatch("Pea", manager.getDiscounts());

        assertAll(
           () -> assertEquals(0, result.size(), "checking if the String Matcher correctly matched a discount to the string provided."),
           () -> assertEquals(false, result.contains(testDiscount), "Checking if the String Matcher contains a discount that should not match"),
           () -> assertEquals(false, result.contains(test), "Checking if the String Matcher contains a discount that should not match.")
        );
	}

    @Test
    public void testWhenStringIsNull() {
        StringMatcher stringMatcher = new StringMatcher();
        DiscountManager manager = new DiscountManager();
        assertThrows(IllegalArgumentException.class,() ->{
            stringMatcher.findDiscountsThatMatch(null, manager.getDiscounts());
		});
    }

    @Test
    public void testWhenDiscountsIsNull() {
        StringMatcher stringMatcher = new StringMatcher();
        assertThrows(IllegalArgumentException.class,() ->{
            stringMatcher.findDiscountsThatMatch("Tools", null);
		});
    }
}
