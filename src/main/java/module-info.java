module com.rwrw {
    requires javafx.controls;
	requires javafx.fxml;
	requires java.desktop;
	requires java.ws.rs;
	requires com.fasterxml.jackson.databind;
	requires com.fasterxml.jackson.core;
	requires com.fasterxml.jackson.annotation;
	opens com.rwrw to javafx.fxml;
	opens com.rwrw.controller to javafx.fxml;
	exports com.rwrw.api.model to com.fasterxml.jackson.databind;
    exports com.rwrw;
}