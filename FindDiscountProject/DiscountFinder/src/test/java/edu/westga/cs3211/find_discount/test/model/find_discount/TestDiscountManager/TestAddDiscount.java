package edu.westga.cs3211.find_discount.test.model.find_discount.TestDiscountManager;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.find_discount.model.Category;
import edu.westga.cs3211.find_discount.model.Discount;
import edu.westga.cs3211.find_discount.model.DiscountManager;

public class TestAddDiscount {
    @Test
	public void testAddDiscount() {
        Discount test = new Discount(Category.FRUITS, 25, "Banana");
		DiscountManager manager = new DiscountManager();
        manager.addDiscount(test);
		
        assertAll(
           () -> assertEquals(1, manager.getDiscounts().size(), "checking if the discount manager added a discount to the collection."),
           () -> assertEquals(true, manager.getDiscounts().contains(test), "Checking if the discount manager added the specific discount to the collection.")
        );
	}

    @Test
    public void testWhenDiscountIsNull() {
        DiscountManager manager = new DiscountManager();
        assertThrows(IllegalArgumentException.class,() ->{
            manager.addDiscount(null);
		});
    }
}
