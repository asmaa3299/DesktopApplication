/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortest.jop.first;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
/**
 *
 * @author abdelrahman sobhy
 */
public class processing  {
    public static void display(String title,String input){
     Stage window=new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Proccess");
        window.setMinWidth(700);
        window.setMinHeight(700);    
        Label label = new Label("Enter Your Process :");
        label.setFont(new Font("Arial", 20));
        label.setLayoutX(60);
        label.setLayoutY(30);
        int num=Integer.parseInt(input);
        TextField[] tname = new TextField[num];
        VBox root = new VBox(20);
        root.setLayoutX(50);
        root.setLayoutY(100);
        ArrayList<String> a1=new ArrayList<String>();
        for (int i = 0; i < num; i++) {
            Label lbl=new Label("Process Name :");
            TextField tf = new TextField();
            root.getChildren().addAll(lbl,tf);
            tname[i] = tf ;
          }
        TextField[] tburst = new TextField[num];
        VBox root2 = new VBox(20);
        root2.setLayoutX(250);
        root2.setLayoutY(100);
        for (int i = 0; i < num; i++) {
            Label lbl=new Label("Burst Time :");
            TextField tf = new TextField();
            root2.getChildren().addAll(lbl,tf);
            tburst[i] = tf ;
            
        }
        TextField[] tarrival = new TextField[num];
        VBox root3 = new VBox(20);
        root3.setLayoutX(450);
        root3.setLayoutY(100);
        for (int i = 0; i < num; i++) {
            Label lbl=new Label("Arrival Time :");
            TextField tf = new TextField();
            root3.getChildren().addAll(lbl,tf);
            tarrival[i] = tf ;
            
        }
        Button btn = new Button();
        btn.setText("Enter");
        btn.setLayoutX(250);
        btn.setLayoutY(600);
        btn.setPrefSize(100, 30);
        btn.setTextFill(Color.WHITE);
        btn.setStyle("-fx-font: 17 arial; -fx-base: DARKCYAN;");
        btn.setOnAction(e -> 
        {  int flag = 0;  
        for (int i = 0; i < num; i++){
          
        if (tname[i].getText() == null || tname[i].getText().trim().isEmpty() || Integer.parseInt(tname[i].getText()) < 0 ||
        tburst[i].getText() == null || tburst[i].getText().trim().isEmpty() || Integer.parseInt(tburst[i].getText()) <= 0 ||
        tarrival[i].getText() == null || tarrival[i].getText().trim().isEmpty() || Integer.parseInt(tarrival[i].getText()) < 0 ) {
        flag = 1;
        }}
        if(flag == 1){
            Label lbl=new Label("Please Input A Postive Numper");
        lbl.setLayoutX(100);
        lbl.setLayoutY(200);
        
        lbl.setTextFill(Color.RED);
        root.getChildren().add(lbl);
        }else
        result.display(tname,tburst,tarrival,num);
        });
       root.getChildren().add(btn);
       
       Button btnclose = new Button();
        btnclose.setText("Back");
        btnclose.setLayoutX(400);
        btnclose.setLayoutY(600);
        btnclose.setPrefSize(100, 30);
        btnclose.setTextFill(Color.WHITE);
        btnclose.setStyle("-fx-font: 17 arial; -fx-base: GRAY;");
        btnclose.setOnAction(e -> window.close());
       root.getChildren().add(btnclose);

       Group layout=new Group();
        layout.getChildren().addAll(root,root2,root3,label,btn,btnclose);
        Scene scene2 =new  Scene(layout,700,700,Color.WHITE);  
        
        window.setScene(scene2);
        window.showAndWait();}
    

    
}
