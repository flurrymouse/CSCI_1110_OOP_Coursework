import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.*;
/*
 Name:Jason
 Date:02/05/2021
 This is an example to show baby's rank.
 */
public class Exercise21_11 extends Application {
  private Map<String, Integer>[] mapForBoy = new HashMap[10];
  private Map<String, Integer>[] mapForGirl = new HashMap[10];
  
  private Button btFindRanking = new Button("Find Ranking");
  private ComboBox<Integer> cboYear = new ComboBox<>();
  private ComboBox<String> cboGender = new ComboBox<>();
  private TextField tfName = new TextField();
  private Label lblResult = new Label();
  private URL url;
  private Scanner sc;
  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    GridPane gridPane = new GridPane();
    gridPane.add(new Label("Select a year:"), 0, 0);
    gridPane.add(new Label("Boy or girl?"), 0, 1);
    gridPane.add(new Label("Enter a name:"), 0, 2);
    gridPane.add(cboYear, 1, 0);
    gridPane.add(cboGender, 1, 1);
    gridPane.add(tfName, 1, 2);
    gridPane.add(btFindRanking, 1, 3);
    gridPane.setAlignment(Pos.CENTER);
    gridPane.setHgap(5);
    gridPane.setVgap(5);
  
    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(gridPane);
    borderPane.setBottom(lblResult);
    BorderPane.setAlignment(lblResult, Pos.CENTER);

    // Create a scene and place it in the stage
    Scene scene = new Scene(borderPane, 370, 160);
    primaryStage.setTitle("Exercise21_11"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage

    for (int year = 2001; year <= 2010; year++) {
      cboYear.getItems().add(year);
    }
    cboYear.setValue(2001);
        
    cboGender.getItems().addAll("Male", "Female");
    cboGender.setValue("Male");
    
  
  
  try {
      for (int i = 0; i <= 9; i++) {
          url = new URL("http://liveexample.pearsoncmg.com/data/babynamesranking" + (2001 + i) + ".txt");
          sc = new Scanner(url.openStream());
          
          mapForBoy[i] = new HashMap<>();
          mapForGirl[i] = new HashMap<>();
          while (sc.hasNext()) {
              int rank = sc.nextInt();
              String Boyname = sc.next();
              sc.nextInt();
              String Girlname = sc.next();
              sc.nextInt();
              
              mapForBoy[i].put(Boyname, rank);
              mapForGirl[i].put(Girlname, rank);
          }
      }   
      } catch (MalformedURLException ex) {
          System.out.println("Error with URL");
      } catch (IOException e) {
          System.out.println("Error with the input/output");
      }
  btFindRanking.setOnAction(e -> {
      int year = cboYear.getValue();
      String gender;
      if (cboGender.getValue().equals("Male")) {
          gender = "boy";
      }
      else {
          gender = "girl";
      }
      String name = tfName.getText().trim();
      if (gender.equals("boy")) {
          if (mapForBoy[year - 2001].containsKey(name)) {
              lblResult.setText("The " + gender + " name " + name + " is rank #" + mapForBoy[year - 2001].get(name) + " in the year " + year);
          }
          else {
              lblResult.setText("The " + gender + " name " + name + " is not ranked in the year " + year);
          }
      }
      else {
          if (mapForGirl[year - 2001].containsKey(name)) {
              lblResult.setText("The " + gender + " name " + name + " is rank #" + mapForGirl[year - 2001].get(name) + " in the year " + year);
          }
          else {
              lblResult.setText("The " + gender + " name " + name + " is not ranked in the year " + year);
          }
      }
  });
  
  tfName.setOnAction(e -> {
      int year = cboYear.getValue();
      String gender;
      if (cboGender.getValue().equals("Male")) {
          gender = "boy";
      }
      else {
          gender = "girl";
      }
      String name = tfName.getText().trim();
      if (gender.equals("boy")) {
          if (mapForBoy[year - 2001].containsKey(name)) {
              lblResult.setText("The " + gender + " name " + name + " is rank #" + mapForBoy[year - 2001].get(name) + " in the year " + year);
          }
          else {
              lblResult.setText("The " + gender + " name " + name + " is not ranked in the year " + year);
          }
      }
      else {
          if (mapForGirl[year - 2001].containsKey(name)) {
              lblResult.setText("The " + gender + " name " + name + " is rank #" + mapForGirl[year - 2001].get(name) + " in the year " + year);
          }
          else {
              lblResult.setText("The " + gender + " name " + name + " is not ranked in the year " + year);
          }
      }
  });
  }
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
