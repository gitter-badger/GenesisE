package lt.petuska.genesise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SpringBootApplication
public class GenesisEApplication extends Application
{
	private ConfigurableApplicationContext springContext;
	private Parent root;

	public static void main(String[] args)
	{
		launch(GenesisEApplication.class, args);
	}

	@Override
	public void init() throws Exception
	{
		springContext = SpringApplication.run(GenesisEApplication.class);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/scenes/index.fxml"));
		fxmlLoader.setControllerFactory(springContext::getBean);
		root = fxmlLoader.load();
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		primaryStage.setTitle("Hello World");
		Scene scene = new Scene(root, 800, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void stop() throws Exception
	{
		springContext.stop();
	}
}
