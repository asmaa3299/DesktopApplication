package sjf_consol;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import shortest.jop.first.home;


/**
 *
 * @author abdelrahman sobhy
 */
public class consol {
   

   
    static void CalculateWaitingTime(Process proc[], int n, 
                                     int wt[],int ResponseTime[]) 
    { 
        int BurstTimeCopy[] = new int[n]; 
        int TotalBurstTime = 0;
       
        
        for (int i = 0; i < n; i++) 
            BurstTimeCopy[i] = proc[i].BurstTime; 
        for (int i = 0; i < n; i++) 
            TotalBurstTime = TotalBurstTime + proc[i].BurstTime; 
       
        int CompleteProcesses = 0, Time = 0, Minimum = 100000; 
        int ShortestProcess = 0, finish_time; 
        int flag=0; 
       
        
        while (CompleteProcesses != n) { 
       
            
            for (int j = 0; j < n; j++)  
            { 
                if ((proc[j].ArrivalTime <= Time) && 
                  (BurstTimeCopy[j] < Minimum) && BurstTimeCopy[j] > 0) { 
                    Minimum = BurstTimeCopy[j]; 
                    ShortestProcess = j; 
                    flag = 1; 
                } 
            } 
       
            if (flag == 0) { 
                Time++; 
                continue; 
            } 
       
            
            BurstTimeCopy[ShortestProcess]--; 
       
             
            Minimum = BurstTimeCopy[ShortestProcess]; 
            if (Minimum == 0) 
                Minimum = 100000; 
       
            
            if (BurstTimeCopy[ShortestProcess] == 0) { 
       
               
                CompleteProcesses++; 
                flag = 0; 
       
                
                finish_time = Time + 1; 
       
                
                wt[ShortestProcess] = finish_time - 
                             proc[ShortestProcess].BurstTime - 
                             proc[ShortestProcess].ArrivalTime; 
                ResponseTime[ShortestProcess] = finish_time - proc[ShortestProcess].ArrivalTime;
       
                if (wt[ShortestProcess] < 0) 
                    wt[ShortestProcess] = 0; 
            } 
        
            Time++; 
        } 
        /*for (int i = 0; i < n; i++) {
        Stage ganttchart=new Stage();
        
        ganttchart.initModality(Modality.APPLICATION_MODAL);
        ganttchart.setTitle("GanttChart");
        ganttchart.setMinWidth(700);
        ganttchart.setMinHeight(700);    
        
        HBox gant = new HBox(50);
        gant.setLayoutX(100);
        gant.setLayoutY(450);
        gant.setStyle("-fx-border-style:solid;-fx-border-width: 2;-fx-border-color: BLACK;");
        gant.prefHeight(80);
        Label label2 = new Label("P"+proc[i].ProcessId); 
         
        label2.setStyle("-fx-border-style:solid;-fx-border-width:30 ;-fx-border-color: BLACK;");
        label2.prefWidth(Time);    
            gant.getChildren().addAll(label2);
            //ganttchart.getChildren().addAll(gant);
        }*/ 
    } 
       
    
    static void CalculateTurnAroundTime(Process proc[], int n, 
                            int wt[], int TurnTime[]) 
    { 
        
        for (int i = 0; i < n; i++) 
            TurnTime[i] = proc[i].BurstTime + wt[i]; 
    } 
     
   
    
    
  public  static void CalculateAllavg(Process proc[], int n) 
    { 
        int wt[] = new int[n], TurnTime[] = new int[n],ResponseTime[]=new int[n]; 
        int  TotalWaitingTime = 0, TotalTurnTime = 0,TotalResponseTime=0;
       
        
       CalculateWaitingTime(proc, n, wt,ResponseTime);   
       CalculateTurnAroundTime(proc, n, wt, TurnTime); 
     
        
        System.out.println("Processes " + 
                           " Burst time " + 
                           " Waiting time " + 
                           " Turn around time"); 
       
         
        for (int i = 0; i < n; i++) { 
            TotalWaitingTime = TotalWaitingTime + wt[i]; 
            TotalTurnTime = TotalTurnTime + TurnTime[i]; 
            TotalResponseTime = TotalResponseTime + ResponseTime[i];
            System.out.println(" " + proc[i].ProcessId + "\t\t"
                             + proc[i].BurstTime + "\t\t " + wt[i] 
                             + "\t\t" + TurnTime[i]+ 
                              "\t\t" + ResponseTime[i]); 
        } 
        System.out.println("Average waiting time = " + 
                          (float)TotalWaitingTime / (float)n); 
        System.out.println("Average turn around time = " + 
                           (float)TotalTurnTime / (float)n);
        System.out.println("Average Response time = " + 
                           (float)TotalResponseTime / (float)n);
   
     Stage window=new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Proccess");
        window.setMinWidth(700);
        window.setMinHeight(700);    
        
        VBox root = new VBox(50);
        root.setLayoutX(200);
        root.setLayoutY(20);
        root.setStyle("-fx-background-color:darkcyan; -fx-color:white;");
        Label label = new Label("Processes " + 
                           " Burst time " + 
                           " Waiting time " + 
                           " Turn around time"+
                           " Response time");
        label.setTextFill(Color.WHITE);
        root.getChildren().addAll(label);
        
        for (int i = 0; i < n; i++) {
             
            
            Label label2 = new Label(" " + proc[i].ProcessId + "\t\t"
                             + proc[i].BurstTime + "\t\t " + wt[i] 
                             + "\t\t" + TurnTime[i]
                             + "\t\t" + ResponseTime[i]   ); 
            label2.setFont(new Font("Arial", 20));
            label2.setTextFill(Color.WHITE);
            root.getChildren().addAll(label2);
        }
        Label label3 = new Label("Average : " +"     "+"W.T = "+
                          (float)TotalWaitingTime / (float)n+"       "+"T.A.T = "+(float)TotalTurnTime / (float)n+"       "+"R.T = "+(float)TotalResponseTime / (float)n);
        label3.setLayoutX(50);
        label3.setLayoutY(400);
        label3.setFont(new Font("Arial", 20));
        
        Button btnclose = new Button();
        btnclose.setText("Back");
        btnclose.setLayoutX(400);
        btnclose.setLayoutY(650);
        btnclose.setPrefSize(100, 30);
        btnclose.setTextFill(Color.WHITE);
        btnclose.setStyle("-fx-font: 17 arial; -fx-base: GRAY;");
        btnclose.setOnAction(e -> window.close());
    
       root.getChildren().add(btnclose);
       
       
       
       
       
       
       Group layout=new Group();
        layout.getChildren().addAll(root,label3,btnclose);
        Scene scene2 =new Scene(layout,700,700,Color.WHITE);  
        
        window.setScene(scene2);
        window.showAndWait();
    } 
      
     
    public static void main(String[] args) 
    { 
    
    } 
} 

