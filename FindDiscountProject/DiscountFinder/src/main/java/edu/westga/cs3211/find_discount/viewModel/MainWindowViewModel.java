package edu.westga.cs3211.find_discount.viewModel;

import edu.westga.cs3211.find_discount.model.Category;
import edu.westga.cs3211.find_discount.model.Discount;
import edu.westga.cs3211.find_discount.model.DiscountManager;
import edu.westga.cs3211.find_discount.model.StringMatcher;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

/**
 * Main Window View Model
 * @author Steven Carriger
 * @version Fall 2021
 */
public class MainWindowViewModel {
    private StringProperty itemProperty;

    private ListProperty<Discount> discountListProperty;
    private ListProperty<String> suggestionListProperty;

    private ObjectProperty<Discount> selectedDiscountProperty;
    private ObjectProperty<String> selectedSuggestionProperty;

    private DiscountManager discountManager;
    private StringMatcher stringMatcher;

    /**
     * Instantiates a new Main Window View Model
     * precondition: none
     * postcondition: properties are instantiated.
     */
    public MainWindowViewModel() {
        this.discountManager = new DiscountManager();
        this.populateDiscountManager();
        this.stringMatcher = new StringMatcher();
        this.itemProperty = new SimpleStringProperty("Please Enter an Item Name.");

        this.selectedDiscountProperty = new SimpleObjectProperty<Discount>();
        this.selectedSuggestionProperty = new SimpleObjectProperty<String>();

        this.suggestionListProperty = new SimpleListProperty<String>(FXCollections.observableArrayList(this.discountManager.getAllItemNamesFrom(this.stringMatcher.findDiscountsThatMatch("", this.discountManager.getDiscounts()))));
        this.discountListProperty = new SimpleListProperty<Discount>(FXCollections.observableArrayList(this.discountManager.getDiscounts()));
    }

    /**
     * the item property
     * @return the item 
     */
    public StringProperty itemProperty() {
        return this.itemProperty;
    }

    /**
     * the discount list property
     * @return the discount list
     */
    public ListProperty<Discount> discountListProperty() {
        return this.discountListProperty;
    }

    /**
     * the suggestion list property
     * @return the suggested list
     */
    public ListProperty<String> suggestionListProperty() {
        return this.suggestionListProperty;
    }

    /**
     * the selected discount property
     * @return the selected discount
     */
    public ObjectProperty<Discount> selectedDiscountProperty() {
        return this.selectedDiscountProperty;
    }

    /**
     * the selected suggestion property
     * @return the suggestion property selected.
     */
    public ObjectProperty<String> selectedSuggestionProperty() {
        return this.selectedSuggestionProperty;
    }

    /**
     * search for discounts
     */
    public void searchForDiscounts() {
        this.searchForDiscounts("");
    }

    /**
     * search for discounts with the specified discounts
     * precondition: filter != null
     * postcondition: matching discounts are put into the discount list property and item property is updated appropriately.
     * @param filter the specific word or phrase to find the matching discounts.
     */
    public void searchForDiscounts(String filter) {

        this.discountListProperty.clear();
        this.discountListProperty.addAll(this.stringMatcher.findDiscountsThatMatch(filter, this.discountManager.getDiscounts()));
        if (this.discountListProperty.size() == 0) {
            this.itemProperty.set("No Discounts Match With That Name");
        } else {
            this.itemProperty.set("Please Enter an Item Name.");
        }
    }

    /**
     * Searches the collection of discounts and adds any that match to the suggestions.
     * precondition: string != null.
     * postcondition: all of the names that match are now suggestions.
     * @param string the string or word to look for in the discounts
     */
    public void lookForSuggestions(String string) {
        if (string == null) {
            throw new IllegalArgumentException("String cannot be null when trying to compare to possible suggestions.");
        }
        this.suggestionListProperty.clear();
        this.suggestionListProperty.addAll(this.discountManager.getAllItemNamesFrom(this.stringMatcher.findDiscountsThatMatch(string, this.discountManager.getDiscounts())));
    }

    private void populateDiscountManager() {
        Discount banana = new Discount(Category.FRUITS, 20, "Banana");
        Discount peach = new Discount(Category.FRUITS, 20, "Peach");
        Discount pear = new Discount(Category.FRUITS, 50, "Pear");
        Discount powerSaw = new Discount(Category.TOOLS, 20, "Power Saw");

        this.discountManager.addDiscount(banana);
        this.discountManager.addDiscount(peach);
        this.discountManager.addDiscount(pear);
        this.discountManager.addDiscount(powerSaw);
    }
}