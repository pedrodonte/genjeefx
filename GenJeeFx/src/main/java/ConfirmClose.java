import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ConfirmClose extends Application {

  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(final Stage primaryStage) throws Exception {
    primaryStage.setOnHiding(new EventHandler<WindowEvent>() {

      @Override
      public void handle(WindowEvent event) {
        Platform.runLater(new Runnable() {

          @Override
          public void run() {
//            primaryStage.setVisible(true);
          }
        });

        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        Label label = new Label("Really exit?");
        Button okButton = new Button("OK");
        okButton.setOnAction(new EventHandler<ActionEvent>() {

          @Override
          public void handle(ActionEvent event) {
            dialog.hide();
            Platform.runLater(new Runnable() {

              @Override
              public void run() {
                primaryStage.setOnHiding(null);
                primaryStage.hide();
              }
            });

          }
        });
        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {

          @Override
          public void handle(ActionEvent event) {
            dialog.hide();
          }
        });
        FlowPane pane = new FlowPane(10, 10);
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(okButton, cancelButton);
        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(label, pane);
        Scene scene1 = new Scene(vBox);
        dialog.setScene(scene1);
        Platform.runLater(new Runnable() {

          @Override
          public void run() {
            dialog.initOwner(primaryStage);
//            dialog.set
          }
        });
      }
    });
//    primaryStage.setVisible(true);
  }
}