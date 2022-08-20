
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.LinkedHashSet;


public class Main extends Application {
	
	TextField txtIn = new TextField();
	TextArea txtOut = new TextArea();
	LinkedHashSet<String>set = new LinkedHashSet<String>();

	public static void main(String[] args) {
        launch(args);
    }
    
	
	//creating a pane view to return the layout
	protected BorderPane getPane() {
		
		HBox horiPane = new HBox(10);
		
		Button add = new Button("Add");
		Button remove = new Button("Remove");
		Button clear = new Button("Clear");
		
		add.setMinWidth(65);
		remove.setMinWidth(65);
		clear.setMinWidth(65);
		
		add.setStyle("-fx-background-color: #99ddff; -fx-text-fill: #fff ; -fx-font-size: 12");
		remove.setStyle("-fx-background-color: #ff6666; -fx-text-fill: #fff ; -fx-font-size: 12");
		clear.setStyle("-fx-background-color: #44cc00; -fx-text-fill: #fff ; -fx-font-size: 12");
		
		// the following are the actions when a button is pressed
		add.setOnAction(value ->  {
	          add();
	     });
		
		remove.setOnAction(value ->  {
	          remove();
	     });
		
		clear.setOnAction(value ->  {
	          clear();
	     });
		
		
		// this field houses all the first horizontal plane
		horiPane.getChildren().addAll(txtIn, add, remove, clear );
		horiPane.setAlignment(Pos.CENTER_LEFT);
		
		//creating a borderPane for the whole screen
		BorderPane pane = new BorderPane();
		pane.setTop(horiPane);
		
		//setting a pane to be added to the borderPane
		Pane paneForText = new Pane();
		paneForText.getChildren().add(txtOut);
		pane.setCenter(paneForText);
		
		
		txtOut.setFont(new Font("Serif", 14));
	    txtOut.setWrapText(true);
	    txtOut.setEditable(false);
	    
		return pane;
		
		
	}
	
	
    @Override
    public void start(Stage primaryStage) {
    	
        primaryStage.setTitle("Let's Add and Remove some Words");
        Scene scene = new Scene(getPane(), 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    //methods to do some actions
    public void add() {
    	set.add(txtIn.getText());
    	txtOut.setText(set.toString());
	}
    
    public void remove() {
    	set.remove(txtIn.getText());
    	txtOut.setText(set.toString());
    }
    
    public void clear() {
    	txtOut.setText("");
    }

}

