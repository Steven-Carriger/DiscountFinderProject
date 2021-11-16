package edu.westga.cs3211.find_discount.model;

import java.util.ArrayList;
import java.util.Collection;

/** Manage discounts with the DiscountManager.
 * 
 * @author	Steven Carriger
 * @version Fall 2021
 */
public class DiscountManager {
	private Collection<Discount> discounts;

	/**	Creates a new DiscountManager
	 * Precondition: none
	 * Postcondition: testNumber = 5
	 */
	public DiscountManager() {
		this.discounts = new ArrayList<Discount>();
	}

	/**
	 * Adds a discount to the manager.
	 * precondition: discount != null
	 * postcondition: this.discounts.size() @pre + 1 = this.discounts.size()
	 * @param discount the discount to add.
	 */
	public void addDiscount(Discount discount) {
		this.checkDiscount(discount);
		this.discounts.add(discount);
	}

	/**
	 * removes a discount from the manager.
	 * precondition: discount != null
	 * postcondition: this.discounts.size() @pre - 1 = this.discounts.size()
	 * @param discount the discount to remove.
	 */
	public void removeDiscount(Discount discount) {
		this.checkDiscount(discount);
		this.discounts.remove(discount);
	}

	/**
	 * gets the discounts currently in the discount manager.
	 * @return the discounts in the discount manager.
	 */
	public Collection<Discount> getDiscounts() {
		return this.discounts;
	}

	/**
	 * gets all of the itemNames from the provided discount list.
	 * precondition: discounts != null
     * postcondition: the item names for the discounts are returned in a list.
	 * @param discounts the discount list to get the names from.
	 * @return the collection of item names from the collection.
	 */
	public Collection<String> getAllItemNamesFrom(Collection<Discount> discounts) {
		if (discounts == null) {
			throw new IllegalArgumentException("discounts cannot be null.");
		}

		Collection<String> itemNames = new ArrayList<String>();
        for (Discount discount: discounts) {
            if (!itemNames.contains(discount.getItemName())) {
                itemNames.add(discount.getItemName());
            }            
        }
        return itemNames;
	}

	private void checkDiscount(Discount discount) {
		if (discount == null) {
			throw new IllegalArgumentException("discount cannot be null.");
		}
	}
}
