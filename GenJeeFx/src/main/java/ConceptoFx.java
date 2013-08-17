import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class ConceptoFx extends Application{
	
	public void start(Stage primaryStage) {
	    final Rectangle r1 = new Rectangle(50, 50, Color.RED);
	    final Rectangle r2 = new Rectangle(50, 50, Color.BLUE);

	    // note I use translate to position rectangles
	    r1.setTranslateX(50);
	    r2.setTranslateX(250);

	    Button btn = new Button();
	    btn.setText("Move it");
	    btn.relocate(100, 100);
	    btn.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	            double x1 = r1.getTranslateX();
	            double x2 = r2.getTranslateX();

	            TranslateTransition translateTransition = new TranslateTransition();
	            translateTransition.setNode(r1);
	            translateTransition.setDuration(Duration.millis(1000));
	            translateTransition.setToX(x2);

	            TranslateTransition translateTransition2 = new TranslateTransition();
	            translateTransition2.setNode(r2);
	            translateTransition2.setDuration(Duration.millis(1000));
	            translateTransition2.setToX(x1);

	            translateTransition2.play();
	            translateTransition.play();
	        }
	    });

	    Pane root = new Pane();
	    root.getChildren().addAll(btn, r1, r2);

	    Scene scene = new Scene(root, 400, 350);

	    primaryStage.setTitle("Hello World!");
	    primaryStage.setScene(scene);
	    primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
