package edu.westga.cs3211.find_discount.view.codebehind;

import edu.westga.cs3211.find_discount.model.Discount;
import edu.westga.cs3211.find_discount.viewModel.MainWindowViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * CodeBehind To Handle Processing for the MainWindow
 *
 * @author	Steven Carriger
 * @version Fall 2021
 */
public class MainWindow {       
	
	@FXML
    private TextField searchText;

    @FXML
    private Label itemLabel;

    @FXML
    private Button clearFilterButton;

	@FXML
    private Button addFilterButton;

	@FXML
    private Button findDiscountsButton;

    @FXML
    private ListView<String> suggestionList;

    @FXML
    private ListView<Discount> displayList;
	
	private MainWindowViewModel viewModel;

	/**
	 * Handle initialization checks for the JavaFX components, and perform any
	 * necessary custom initialization.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 */
	@FXML
	public void initialize() {
		this.viewModel = new MainWindowViewModel();
		this.suggestionList.visibleProperty().set(false);
		this.bindProperties();
	}

	private void bindProperties() {
		this.itemLabel.textProperty().bind(this.viewModel.itemProperty());
		this.displayList.itemsProperty().bind(this.viewModel.discountListProperty());
		this.suggestionList.itemsProperty().bind(this.viewModel.suggestionListProperty());
		this.addFilterButton.disableProperty().bind(this.suggestionList.selectionModelProperty().get().selectedItemProperty().isNull());
	}

	@FXML
    public void handleSearchTextInput() {
		this.suggestionList.visibleProperty().set(true);
		this.viewModel.lookForSuggestions(this.searchText.textProperty().get());
    }

	@FXML
    public void addFilter() {
		this.viewModel.searchForDiscounts(this.suggestionList.selectionModelProperty().get().selectedItemProperty().get());
		this.suggestionList.visibleProperty().set(false);
    }

    @FXML
    public void handleClearFilter() {
		this.viewModel.searchForDiscounts();
		this.searchText.setText("");
		this.suggestionList.getSelectionModel().clearSelection();
		this.suggestionList.visibleProperty().set(false);
    }

    @FXML
    public void handleSearchForDiscounts() {
		this.viewModel.searchForDiscounts(this.searchText.textProperty().get());
		this.suggestionList.visibleProperty().set(false);
    }
}
