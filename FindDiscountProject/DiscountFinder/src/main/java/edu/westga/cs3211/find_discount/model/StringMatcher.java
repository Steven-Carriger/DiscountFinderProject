package edu.westga.cs3211.find_discount.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Name Matcher class
 * @author Steven Carriger
 * @version Fall 2021
 */
public class StringMatcher {

    /**
     * Finds the discount that match the string being implemented.
     * 
     * @param string the string to match.
     * @param discounts the discounts to compare them to.
     * @return the collection of discounts that match the string. Collection will be empty if none match.
     */
    public Collection<Discount> findDiscountsThatMatch(String string, Collection<Discount> discounts) {
        this.checkDiscounts(discounts);

        if (string == null) {
            throw new IllegalArgumentException("string cannot be null when looking for things to match.");
        }

        Collection<Discount> matchingDiscounts = new ArrayList<Discount>();

        for (Discount discount : discounts) {
            if (this.doesNameMatchItemName(string, discount.getItemName())) {
                matchingDiscounts.add(discount);
            }
        }

        return matchingDiscounts;
    }

    private boolean doesNameMatchItemName(String string, String itemName) {
        if (this.stringIsLargerThanNameToMatch(string, itemName)) {
            return false;
        }

        string.toLowerCase();
        itemName.toLowerCase();
        return itemName.startsWith(string);
    }

    private boolean stringIsLargerThanNameToMatch(String string, String itemName) {
        return string.length() > itemName.length();
    }

    private void checkDiscounts(Collection<Discount> discounts) {
        if (discounts == null) {
            throw new IllegalArgumentException("discounts cannot be null when looking for things to match.");
        }
    }

}
