module LaWeAppFX {
	requires javafx.controls;
	requires javafx.graphics;
	requires java.desktop;
	requires AnimatonClass;
	requires javafx.fxml;
	requires javafx.media;
	requires java.logging;
	
	opens application to javafx.graphics, javafx.fxml;
	opens modelo to javafx.graphics, javafx.fxml;
	opens logica to javafx.graphics, javafx.fxml;
}
