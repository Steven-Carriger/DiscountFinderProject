package edu.westga.cs3211.find_discount.test.viewModel;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.find_discount.model.Discount;
import edu.westga.cs3211.find_discount.viewModel.MainWindowViewModel;

public class TestSearchForDiscounts {
    @Test
	public void testDefaultSearchForDiscounts() {
        MainWindowViewModel viewModel = new MainWindowViewModel();
        viewModel.searchForDiscounts();
        
        List<Discount> result = viewModel.discountListProperty();

        assertAll(
           () -> assertEquals(4, result.size(), "Checking that the method has returned all of the discounts in the collection."),
           () -> assertEquals(true, result.get(0).getItemName().equals("Banana"), "Checking that the method found the matching discounts."),
           () -> assertEquals(true, result.get(1).getItemName().equals("Peach"), "Checking that the method found the matching discounts."),
           () -> assertEquals(true, result.get(2).getItemName().equals("Pear"), "Checking that the method found the matching discounts."),
           () -> assertEquals(true, result.get(3).getItemName().equals("Power Saw"), "Checking that the method found the matching discounts.")
        );
	}

    @Test
	public void testWhenThereIsOnlyOneDiscountFound() {
        MainWindowViewModel viewModel = new MainWindowViewModel();
        String test = "Bana";
        viewModel.searchForDiscounts(test);
        
        List<Discount> result = viewModel.discountListProperty();

        assertAll(
           () -> assertEquals(1, result.size(), "Checking that the method has returned the discounts that match in the collection."),
           () -> assertEquals(true, result.get(0).getItemName().equals("Banana"), "Checking that the correct Discount was found.")
        );
	}

    @Test
	public void testWhenThereAreMultipleDiscountsFound() {
        MainWindowViewModel viewModel = new MainWindowViewModel();
        String test = "P";
        viewModel.searchForDiscounts(test);
        
        List<Discount> result = viewModel.discountListProperty();

        assertAll(
           () -> assertEquals(3, result.size(), "Checking that the method has returned the discounts that match in the collection."),
           () -> assertEquals(true, result.get(0).getItemName().equals("Peach"), "Checking that the method found the matching discounts."),
           () -> assertEquals(true, result.get(1).getItemName().equals("Pear"), "Checking that the method found the matching discounts."),
           () -> assertEquals(true, result.get(2).getItemName().equals("Power Saw"), "Checking that the method found the matching discounts.")
        );
	}

    @Test
	public void testWhenThereAreNoMatchingDiscounts() {
        MainWindowViewModel viewModel = new MainWindowViewModel();
        String test = "Apple";
        viewModel.searchForDiscounts(test);
        
        List<Discount> result = viewModel.discountListProperty();
        
        assertEquals(0, result.size(), "Checking that the method has added no values in the collection.");
	}

    @Test
    public void testWhenStringIsNull() {
        MainWindowViewModel viewModel = new MainWindowViewModel();
        assertThrows(IllegalArgumentException.class,() ->{
            viewModel.searchForDiscounts(null);
		});
    }
}
