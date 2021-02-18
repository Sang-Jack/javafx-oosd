/*
 * @author 44752
 * By Sang Tan Ngo 
 * Stu id: 19037878 
 */

/*
 * ***************************************************
 * JavaFX file to produce the data storage (database)*
 * ***************************************************
 */
package CWOOSD;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CWoosdFX extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override

    // Region [Description]
    // Set space to each Region 
    public void start(Stage primaryStage) {
        Region headerLeftSpring = new Region();
        Region headerRightSpring = new Region();
        Region footerCenterSpring = new Region();

        // Input logo and insert url of logo file             
        ImageView logo = new ImageView(
                new Image(getClass().getResourceAsStream("images/javafx-logo.png"))
        );

        // Import logo and input url of css file    
        Scene scene = SceneBuilder.create()
                .stylesheets("CWOOSD/myStyles.css")
                .width(900)
                .height(600)
                .root(
                        BorderPaneBuilder.create()
                        .top(
                                // Develop the top region
                                HBoxBuilder.create()
                                .children(
                                        logo,
                                        headerLeftSpring,
                                        LabelBuilder.create()
                                        // Set app title to a specific name 
                                        .id("app-title")
                                        .text("Association Secretary")
                                        .build(),
                                        headerRightSpring
                                )
                                .build()
                        )
                        // Develop the center region
                        .center(
                                TabPaneBuilder.create()
                                .tabs( // Create tabs 
                                        TabBuilder.create()
                                        // Remove the close button         
                                        .closable(false)
                                        // Set name to the tabs        
                                        .text("Admin page")
                                        .build(),
                                        TabBuilder.create()
                                        // Remove the close button
                                        .closable(false)
                                        // Set name to the tabs         
                                        .text("Viewer page")
                                        .build(),
                                        TabBuilder.create()
                                        // Remove the close button        
                                        .closable(false)
                                        // Set name to the tabs         
                                        .text("Score sheet")
                                        .build()
                                )
                                .build()
                        )
                        .bottom(
                                HBoxBuilder.create()
                                .id("footer")
                                .children(
                                        new Label("Footer Left"),
                                        footerCenterSpring,
                                        new Label("Footer Right")
                                )
                                .build()
                        )
                        .build()
                )
                .build();

        HBox.setHgrow(headerLeftSpring, Priority.ALWAYS);
        HBox.setHgrow(headerRightSpring, Priority.ALWAYS);
        HBox.setHgrow(footerCenterSpring, Priority.ALWAYS);

        // Set the top title of the page 
        primaryStage.setTitle("DATABASE: Data storage");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
