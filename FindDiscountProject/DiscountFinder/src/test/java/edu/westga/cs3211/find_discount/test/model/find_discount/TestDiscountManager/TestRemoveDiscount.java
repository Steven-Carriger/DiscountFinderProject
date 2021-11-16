package edu.westga.cs3211.find_discount.test.model.find_discount.TestDiscountManager;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.find_discount.model.Category;
import edu.westga.cs3211.find_discount.model.Discount;
import edu.westga.cs3211.find_discount.model.DiscountManager;

public class TestRemoveDiscount {
    @Test
	public void testRemoveDiscount() {
        Discount test = new Discount(Category.FRUITS, 25, "Banana");
        Discount testDiscount = new Discount(Category.TOOLS, 50, "Power Drill");
        DiscountManager manager = new DiscountManager();
        manager.addDiscount(test);
		manager.addDiscount(testDiscount);

        manager.removeDiscount(test);

        assertAll(
           () -> assertEquals(1, manager.getDiscounts().size(), "checking if the discount manager added a discount to the collection and then removed one."),
           () -> assertEquals(false, manager.getDiscounts().contains(test), "Checking if the discount manager removed the specific discount from the collection."),
           () -> assertEquals(true, manager.getDiscounts().contains(testDiscount), "Checking if the discount manager didn't affect the other discount added.")
        );
	}

    @Test
    public void testWhenDiscountIsNull() {
        DiscountManager manager = new DiscountManager();
        assertThrows(IllegalArgumentException.class,() ->{
            manager.removeDiscount(null);
		});
    }
}
