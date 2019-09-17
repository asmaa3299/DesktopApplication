/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortest.jop.first;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.Modality;
/**
 *
 * @author abdelrahman sobhy
 */
public class home extends Application {

    @Override
    public void start(Stage primaryStage) {
       
         Stage window=new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("");
        window.setMinWidth(450);
        window.setMinHeight(500);    
        
        Group root = new Group (); /*creating the group it self*/
        Scene  scene1 = new Scene(root,490,400,Color.WHITE); /*coloring the container*/
       
                Font Header =new Font("century",45);
        Font font = new Font("century",20);
        
        Label head = new Label("Shortest Jop First (Preemptive)");
        head.setLayoutX(60);
        head.setLayoutY(50);
        head.setFont(font);
        head.setTextFill(Color.DARKCYAN);
        head.setFont(new Font("Arial", 25));
        root.getChildren().add(head);
        
        
        
        Label txt = new Label("Enter Number Of Processes :");
        txt.setLayoutX(90);
        txt.setLayoutY(125);
        txt.setFont(font);
     
        root.getChildren().add(txt);
       
        //textFeild username
        TextField txtUser= new TextField();
        txtUser.setLayoutX(150);
        txtUser.setLayoutY(170);
        
        root.getChildren().add(txtUser);
        
        
        Button btn = new Button();
        btn.setText("Enter");
        btn.setLayoutX(170);
        btn.setLayoutY(240);
        btn.setPrefSize(100, 30);
        btn.setTextFill(Color.WHITE);
        btn.setStyle("-fx-font: 17 arial; -fx-base: DARKCYAN;");
        //btn.setOnAction(e -> get(txtUser,txtUser.getText()));
        
             
           //int x = Integer.parseInt(txtUser.getText());
             
        btn.setOnAction(e -> {
        if (txtUser.getText() == null || txtUser.getText().trim().isEmpty() || Integer.parseInt(txtUser.getText()) < 0){
        
        
        
        
        Label lbl=new Label("Please Input A Postive Numper");
        lbl.setLayoutX(100);
        lbl.setLayoutY(200);
        lbl.setFont(font);
        lbl.setTextFill(Color.RED);
        root.getChildren().add(lbl);
        }
        else
            processing.display("process",txtUser.getText());
         });
        
        
        root.getChildren().add(btn);
        
        
        primaryStage.setTitle("Shortest Jop First");
        primaryStage.setScene(scene1);
        primaryStage.show();
        
        
    }
      /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
    
}
