package edu.westga.cs3211.find_discount.test.model.find_discount.TestDiscount;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import edu.westga.cs3211.find_discount.model.Category;
import edu.westga.cs3211.find_discount.model.Discount;

public class TestConstructor {
    @Test
	public void testValidConstructor() {
        Category category = Category.FRUITS;
        int percentage = 100;
        String itemName = "Banana";
        String categoryCheck = category.toString();
        Discount test = new Discount(category, percentage, itemName);
		
		assertAll(
           () -> assertEquals(category, test.getCategory(), "Making sure the Category is correctly assigned."),
           () -> assertEquals(percentage, test.getPercentage(), "Making sure the Percentage is correctly assigned."),
           () -> assertEquals(itemName, test.getItemName(), "Making sure the ItemName is correctly assigned."),
           () -> assertEquals(categoryCheck, test.getCategory().toString(), "Checking that the Category's string value is unaffected when instantiated.")
        );
	}

    @Test
    public void testWhenItemNameIsNull() {
        assertThrows(IllegalArgumentException.class,() ->{
            new Discount(Category.FRUITS, 50, null);
		});
    }

    @Test
    public void testWhenItemNameIsEmpty() {
        assertThrows(IllegalArgumentException.class,() ->{
            new Discount(Category.FRUITS, 50, "");
		});
    }

    @Test
    public void testWhenPercentageIsGreaterThanOneHundred() {
        assertThrows(IllegalArgumentException.class,() ->{
            new Discount(Category.TOOLS, 101, "Drills");
		});
    }

    @Test
    public void testWhenPercentageIsZero() {
        assertThrows(IllegalArgumentException.class,() ->{
            new Discount(Category.TOOLS, 0, "Drills");
		});
    }

    @Test
    public void testWhenCategoryIsNull() {
        assertThrows(IllegalArgumentException.class,() ->{
            new Discount(null, 1, "Banana");
		});
    }
}
