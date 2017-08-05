package org.silab.expertsystem.config.gui;

import java.io.FileInputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

import org.silab.expertsystem.config.annotations.LabelId;
import org.silab.expertsystem.model.Game;
import org.silab.expertsystem.model.GameEvent;
import org.silab.expertsystem.model.Player;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainGUI extends Application {

	Stage stage;


	public static final CountDownLatch latch = new CountDownLatch(1);
	public static MainGUI gui = null;

	public static MainGUI waitStartUp() {
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return gui;
	}

	public static void setGui(MainGUI gui0) {
		gui = gui0;
	}

	public MainGUI() {
		setGui(this);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// creating a Group object

		Label lblCl = new Label("Current lineup:");
		lblCl.setTranslateX(50);
		lblCl.setTranslateY(50);
		lblCl.setFont(new Font("Arial", 18));

		Label lblPl = new Label("Proposed lineup:");
		lblPl.setTranslateX(500);
		lblPl.setTranslateY(50);
		lblPl.setFont(new Font("Arial", 18));

		Label lblCpg = new Label("");
		lblCpg.setId("cpg");
		lblCpg.setTranslateX(195);
		lblCpg.setTranslateY(155);
		lblCpg.setFont(new Font("Arial", 12));

		Label lblCsg = new Label("");
		lblCsg.setId("csg");
		lblCsg.setTranslateX(320);
		lblCsg.setTranslateY(190);
		lblCsg.setFont(new Font("Arial", 12));

		Label lblCsf = new Label("");
		lblCsf.setId("csf");
		lblCsf.setTranslateX(105);
		lblCsf.setTranslateY(255);
		lblCsf.setFont(new Font("Arial", 12));

		Label lblCpf = new Label("");
		lblCpf.setId("cpf");
		lblCpf.setTranslateX(250);
		lblCpf.setTranslateY(280);
		lblCpf.setFont(new Font("Arial", 12));

		Label lblCc = new Label("");
		lblCc.setId("cc");
		lblCc.setTranslateX(170);
		lblCc.setTranslateY(305);
		lblCc.setFont(new Font("Arial", 12));

		Label lblPpg = new Label("");
		lblPpg.setId("ppg");
		lblPpg.setTranslateX(645);
		lblPpg.setTranslateY(155);
		lblPpg.setFont(new Font("Arial", 12));

		Label lblPsg = new Label("");
		lblPsg.setId("psg");
		lblPsg.setTranslateX(770);
		lblPsg.setTranslateY(190);
		lblPsg.setFont(new Font("Arial", 12));

		Label lblPsf = new Label("");
		lblPsf.setId("psf");
		lblPsf.setTranslateX(555);
		lblPsf.setTranslateY(255);
		lblPsf.setFont(new Font("Arial", 12));

		Label lblPpf = new Label("");
		lblPpf.setId("ppf");
		lblPpf.setTranslateX(700);
		lblPpf.setTranslateY(280);
		lblPpf.setFont(new Font("Arial", 12));

		Label lblPc = new Label("");
		lblPc.setId("pc");
		lblPc.setTranslateX(620);
		lblPc.setTranslateY(305);
		lblPc.setFont(new Font("Arial", 12));

		Label lblEx = new Label("");
		lblEx.setId("ex");
		lblEx.setTranslateX(50);
		lblEx.setTranslateY(400);
		lblEx.setFont(new Font("Arial", 18));
		lblEx.setMaxWidth(825);
		lblEx.setWrapText(true);

		Image image = new Image(new FileInputStream(
				"C://Users/pc/Desktop/court.jpeg"));

		// Setting the image view 1
		ImageView startingLineup = new ImageView(image);

		// Setting the position of the image
		startingLineup.setX(50);
		startingLineup.setY(75);

		// setting the fit height and width of the image view
		startingLineup.setFitHeight(275);
		startingLineup.setFitWidth(400);

		// Setting the preserve ratio of the image view
		startingLineup.setPreserveRatio(true);

		// Setting the image view 2
		ImageView reserveLineup = new ImageView(image);

		// Setting the position of the image
		reserveLineup.setX(500);
		reserveLineup.setY(75);

		// setting the fit height and width of the image view
		reserveLineup.setFitHeight(275);
		reserveLineup.setFitWidth(400);

		// Setting the preserve ratio of the image view
		reserveLineup.setPreserveRatio(true);

		// Creating a Group object
		Group root = new Group(startingLineup, reserveLineup, lblCl, lblPl,
				lblCpg, lblCsg, lblCsf, lblCpf, lblCc, lblPpg, lblPsg, lblPsf,
				lblPpf, lblPc, lblEx);

		root.setId("root");

		Scene scene = new Scene(root, 915, 600);

		// setting color to the scene
		scene.setFill(Color.AZURE);

		// Setting the title to Stage.
		primaryStage.setTitle("Expert system");

		// Adding the scene to Stage
		primaryStage.setScene(scene);

		Scene scene1 = primaryStage.getScene();

		primaryStage.setResizable(false);

		// Displaying the contents of the stage
		primaryStage.show();

		this.stage = primaryStage;
		latch.countDown();

	}


	public void initLineup(Object object) {

		if (object instanceof GameEvent) {
			object = (GameEvent) object;
		} else {
			object = (Game) object;
		}

		Class modelClass = object.getClass();

		Scene scene = stage.getScene();

		Group group = (Group) scene.getRoot();

		Iterator<Node> elements = group.getChildren().iterator();

		try {

			while (elements.hasNext()) {

				Node current = elements.next();
				
				for (int i = 0; i < modelClass.getDeclaredFields().length; i++) {
					if (modelClass.getDeclaredFields()[i]
							.isAnnotationPresent(LabelId.class)) {
						Field field = modelClass.getDeclaredFields()[i];
						Annotation labelIdAnnotation = (Annotation) field
								.getAnnotation(LabelId.class);
						String labelId = ((LabelId) labelIdAnnotation).id();
						if (current.getId() != null) {
							if (current.getId().equals(labelId)) {
								Label lbl = (Label) current;
								field.setAccessible(true);
								if(field.get(object) instanceof StringBuffer){
									StringBuffer explanation = (StringBuffer) field.get(object);
									lbl.setText(explanation.toString());
								} else {
									Player player = (Player)field.get(object);
									lbl.setText(player.getName()+" "+player.getSurname());
								}
							}
						}
					}

				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
