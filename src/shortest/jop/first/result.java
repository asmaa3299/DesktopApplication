/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortest.jop.first;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author abdelrahman sobhy
 */
public class result  {
    public static void display(TextField[] name,TextField[] burst,TextField[] arrival,int num)
    {
        
        int[] pn = new int[num];
           int[] bt = new int[num];
           int[] at = new int[num];
        
       for (int i = 0; i < num; i++) {
           
         pn[i]=Integer.parseInt(name[i].getText());
          bt[i] = Integer.parseInt(burst[i].getText());
       at[i] = Integer.parseInt(arrival[i].getText());
       }
       sjf_consol.Process proc[] = new sjf_consol.Process[num] ;
       
       for (int i = 0; i < num; i++) { 
       proc[i] = new sjf_consol.Process(pn[i], bt[i], at[i]) ;
       }
       sjf_consol.consol.CalculateAllavg(proc, proc.length);
      
   }
    

    
    
    
    
    
    }
     
    
    
    


