package edu.westga.cs3211.find_discount.test.viewModel;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.find_discount.viewModel.MainWindowViewModel;

public class TestLookForSuggestions {

    @Test
	public void testWhenThereIsOnlyOneSuggestion() {
        MainWindowViewModel viewModel = new MainWindowViewModel();
        String test = "Bana";
        viewModel.lookForSuggestions(test);
        
        List<String> result = viewModel.suggestionListProperty();

        assertAll(
           () -> assertEquals(1, result.size(), "Checking that the method has returned the values that match in the collection."),
           () -> assertEquals(true, result.contains("Banana"), "Checking that the returned collection has the item name."),
           () -> assertEquals(false, result.contains("Peach"), "Checking that the returned collection does not contain the item name.")
        );
	}

    @Test
	public void testWhenThereAreMultipleSuggestions() {
        MainWindowViewModel viewModel = new MainWindowViewModel();
        String test = "Pe";
        viewModel.lookForSuggestions(test);
        
        List<String> result = viewModel.suggestionListProperty();

        assertAll(
           () -> assertEquals(2, result.size(), "Checking that the method has returned the values that match in the collection."),
           () -> assertEquals(true, result.contains("Pear"), "Checking that the returned collection has the item name."),
           () -> assertEquals(true, result.contains("Peach"), "Checking that the returned collection has the item name.")
        );
	}

    @Test
	public void testWhenThereAreNoMatchingSuggestions() {
        MainWindowViewModel viewModel = new MainWindowViewModel();
        String test = "Apple";
        viewModel.lookForSuggestions(test);
        
        List<String> result = viewModel.suggestionListProperty();

        assertAll(
           () -> assertEquals(0, result.size(), "Checking that the method has added no values in the collection."),
           () -> assertEquals(false, result.contains("Pear"), "Checking that the returned collection has the item name."),
           () -> assertEquals(false, result.contains("Peach"), "Checking that the returned collection has the item name.")
        );
	}

    @Test
    public void testWhenStringIsNull() {
        MainWindowViewModel viewModel = new MainWindowViewModel();
        assertThrows(IllegalArgumentException.class,() ->{
            viewModel.lookForSuggestions(null);
		});
    }
}
