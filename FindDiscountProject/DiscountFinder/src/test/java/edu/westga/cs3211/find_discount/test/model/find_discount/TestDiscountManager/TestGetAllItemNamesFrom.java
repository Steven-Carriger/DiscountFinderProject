package edu.westga.cs3211.find_discount.test.model.find_discount.TestDiscountManager;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collection;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.find_discount.model.Category;
import edu.westga.cs3211.find_discount.model.Discount;
import edu.westga.cs3211.find_discount.model.DiscountManager;

public class TestGetAllItemNamesFrom {
    @Test
	public void testWhenOneItemNameIsReturned() {
        Discount test = new Discount(Category.FRUITS, 25, "Banana");
        DiscountManager manager = new DiscountManager();

        manager.addDiscount(test);

        Collection<String> result = manager.getAllItemNamesFrom(manager.getDiscounts());

        assertAll(
           () -> assertEquals(1, result.size(), "Checking that the method has returned both of the values in the collection."),
           () -> assertEquals(true, result.contains(test.getItemName()), "Checking that the returned collection has the item name.")
        );
	}

    @Test
	public void testWhenMultipleItemNamesAreReturned() {
        Discount test = new Discount(Category.FRUITS, 25, "Banana");
        Discount testDiscount = new Discount(Category.TOOLS, 50, "Power Drill");
        DiscountManager manager = new DiscountManager();

        manager.addDiscount(test);
		manager.addDiscount(testDiscount);

        Collection<String> result = manager.getAllItemNamesFrom(manager.getDiscounts());

        assertAll(
           () -> assertEquals(2, result.size(), "Checking that the method has returned both of the values in the collection."),
           () -> assertEquals(true, result.contains(test.getItemName()), "Checking that the returned collection has the item name."),
           () -> assertEquals(true, result.contains(testDiscount.getItemName()), "Checking that the returned collection has the item name.")
        );
	}

    @Test
	public void testWhenMultipleDiscountsWithTheSameItemNameAreInTheCollection() {
        Discount test = new Discount(Category.FRUITS, 25, "Banana");
        Discount testDouble = new Discount(Category.FRUITS, 80, "Banana");
        Discount testTriplet = new Discount(Category.FRUITS, 10, "Banana");
        DiscountManager manager = new DiscountManager();

        manager.addDiscount(test);
        manager.addDiscount(testDouble);
        manager.addDiscount(testTriplet);

        Collection<String> result = manager.getAllItemNamesFrom(manager.getDiscounts());

        assertAll(
           () -> assertEquals(1, result.size(), "Checking that the method has returned only one value in the collection."),
           () -> assertEquals(true, result.contains(test.getItemName()), "Checking that the returned collection has the same item name."),
           () -> assertEquals(true, result.contains(testDouble.getItemName()), "Checking that the returned collection has the same item name."),
           () -> assertEquals(true, result.contains(testTriplet.getItemName()), "Checking that the returned collection has the same item name.")
        );
	}

    @Test
	public void testWhenThereAreNoDiscountsInTheCollection() {
        DiscountManager manager = new DiscountManager();
        Collection<String> result = manager.getAllItemNamesFrom(manager.getDiscounts());

        assertEquals(0, result.size(), "Checking that no values are added to the returned collection when there are no values in the manager.");
	}

    @Test
    public void testWhenDiscountsIsNull() {
        DiscountManager manager = new DiscountManager();
        assertThrows(IllegalArgumentException.class,() ->{
            manager.getAllItemNamesFrom(null);
		});
    }
}
