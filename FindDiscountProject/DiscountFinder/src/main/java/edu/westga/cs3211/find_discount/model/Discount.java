package edu.westga.cs3211.find_discount.model;

/** The Discount Class.
 * 
 * @author	Steven Carriger
 * @version Fall 2021
 */
public class Discount {
    private int percentage;
    private Category category;
    private String itemName;

    /**
     * Creates a new Discount object
     * precondition: newPercentage > 0 && <= 100, name.isEmpty() = false, 
     *               name != null, newCategory != null.
     * postcondition: this.category = newCategory, this.percentage = newPercentage, 
     *                this.itemName = name
     * @param newCategory the category of the discount to make
     * @param newPercentage the percentage off the discount provides
     * @param name the name of the item the discount is provided to.
     */
    public Discount(Category newCategory, int newPercentage, String name) {
        this.checkString(name);
        this.checkPercentage(newPercentage);
        this.checkCategory(newCategory);

        this.category = newCategory;
        this.percentage = newPercentage;
        this.itemName = name;
    }

    /**
     * gets the percentage of the discount.
     * @return the percentage.
     */
    public int getPercentage() {
        return this.percentage;
    }

    /**
     * gets the category of the discount.
     * @return the category.
     */
    public Category getCategory() {
        return this.category;
    }

    /**
     * gets the item name of the discount.
     * @return the item name.
     */
    public String getItemName() {
        return this.itemName;
    }

    @Override
    public String toString() {
        String string = "Category: " + this.getCategory().toString() + " Item name: " + this.getItemName() + " Percent Off: " + this.getPercentage() + "%";
        return string;
    }

    private void checkCategory(Category newCategory) {
        if (newCategory == null) {
            throw new IllegalArgumentException("the discount cannot have a null category.");
        }
    }

    private void checkPercentage(int newPercentage) {
        if (newPercentage <= 0) {
            throw new IllegalArgumentException("the discount percentage must be greater than 0.");
        }
        if (newPercentage > 100) {
            throw new IllegalArgumentException("the discount percentage must be less than or equal to 100.");
        }
    }

    private void checkString(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null.");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("name cannot be empty.");
        }
    }
}
