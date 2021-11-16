package edu.westga.cs3211.find_discount.model;

/** The categories a discount can be applied to.
 * 
 * @author	Steven Carriger
 * @version Fall 2021
 */
public enum Category {
	FRUITS("Fruits"),
    VEGETABLES("Vegetables"),
    TOOLS("Tools");

    private final String category;

    /**
	 * creates a new Category
     * @param category the name of the category
     */
    Category(final String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return this.category;
    }
}
