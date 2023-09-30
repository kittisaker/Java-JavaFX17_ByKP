# Java : JavaFX 17

## Chapter 1 : Getting Start

### System Requirements
* ava Development Kit 17, from Oracle, or OpenJDK.
* Eclipse IDE 2021-06 or later.
* The JavaFX 17 SDK for your platform, downloaded and extracted in a folder of your choice. Go to https://openjfx.io/ for the documentation and download links.

### First JavaFX Application
* Add the JARs in the Modulepath section
* Setting Up a Module Info : <b>module-info.java</b>

```java
module JavaFXBook {
	requires javafx.graphics;
	requires javafx.controls;
	requires java.desktop;
	requires javafx.swing;
	requires javafx.media;
	requires javafx.web;
	requires javafx.fxml;
	requires jdk.jsobject;
	
	opens com.kope.intro to javafx.graphics, javafx.base;
}
```

#### Creating the Class

```java
package com.kope.intro;

import javafx.application.Application;

public class HelloFXApp extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
    // Application logic goes here
}
```

#### Overriding the start() Method

```java
package com.kope.intro;

import javafx.application.Application;
import javafx.stage.Stage;

public class HelloFXApp extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        // The logic for starting the application goes here
    }
```

#### Showing the Stage

```java
package com.kope.intro;

import javafx.application.Application;
import javafx.stage.Stage;

public class HelloFXApp extends Application{
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Hello JavaFX Application");
		stage.show();
	}
}
```

#### Launching the Application
* <b>Run</b> as -> <b>Java Applicatoin</b>

#### Adding a Scene to the Stage

```java
package com.kope.intro;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class HelloFXAppWithAScene extends Application{
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage){
		// Node L2 : declare
		Text msg = new Text("Hello JavaFX");
		
		// Node L1 : declare
		VBox root = new VBox();
		// Node L1 : operation
		root.getChildren().add(msg);
		
		// Node L0 : declare
		Scene scene = new Scene(root, 300, 50);
		
		stage.setScene(scene);
		stage.setTitle("Hello JavaFX Application");
		stage.show();
	}
}
```

### Improving the HelloFX Application

```java
package com.kope.intro;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ImprovedHelloFXApp extends Application{
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage){
		// Node L2 : declare
		Label nameLbl = new Label("Enter your name:");
		TextField nameFld = new TextField();
		Label msg = new Label();
		Button sayHelloBtn = new Button("Say Hello");
		Button exitBtn = new Button("Exit");
		
		// Node L2 : operation
		msg.setStyle("-fx-text-fill: blue;");
		sayHelloBtn.setOnAction(e -> {
			String name = nameFld.getText();
			if(name.trim().length() > 0) {
				msg.setText("Hello " + name);
			}else {
				msg.setText("Hello there");
			}
		});
		exitBtn.setOnAction(e -> Platform.exit());
		
		// Node L1 : declare
		VBox root = new VBox();
		
		// Node L1 : operation
		root.setSpacing(5);
		root.getChildren().addAll(nameLbl, nameFld, msg, sayHelloBtn, exitBtn);
		
		// Node : L0
		Scene scene = new Scene(root, 350, 150);
		
		stage.setScene(scene);
		stage.setTitle("Hello JavaFX Application");
		stage.show();
	}
}
```

### Passing Parameters to a JavaFX Application

<table>
  <tr>
    <th>JavaFX app divides parameter</th>
    <th>Methods of the Parameters class to access</th>
  </tr>
  <tr>
    <td>Named parameters</td>
    <td>Map<String, String> getNamed()</td>
  </tr>
  <tr>
    <td>Unnamed parameters</td>
    <td>List<String> getUnnamed()</td>
  </tr>
    <tr>
    <td>Raw parameters (a combination of named and unnamed parameters)</td>
    <td>List<String> getRaw()</td>
  </tr>
</table>

```java
package com.kope.intro;

import java.util.List;
import java.util.Map;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class FXParamApp extends Application{

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage){
		Parameters p = this.getParameters();
		Map<String, String> namedParams = p.getNamed();
		List<String> unnamedParams = p.getUnnamed();
		List<String> rawParams = p.getRaw();
		String paramStr = "Named Parameters: " + namedParams + "\n" +
				"Unnamed Parameters: " + unnamedParams + "\n" +
				"Raw Parameters: " + rawParams;

		TextArea ta = new TextArea(paramStr);
		Group root = new Group(ta);
		stage.setScene(new Scene(root));
		stage.setTitle("Application Parameters");
		stage.show();
	}
}
```

```
# Case 1
Arduments : Anna Lola
Result :
    Named Parameters: {}
    Unnamed Parameters: [Anna, Lola]
    Raw Parameters: [Anna, Lola]

# Case 2
Arduments : Anna Lola --width=200 --height=100
Result :
    Named Parameters: {width=200, height=100}
    Unnamed Parameters: [Anna, Lola]
    Raw Parameters: [Anna, Lola, --width=200, --height=100]
```

### The Life Cycle of a JavaFX Application

```java
package com.kope.intro;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXLifeCycleApp extends Application{
	
	public FXLifeCycleApp() {
		String name = Thread.currentThread().getName();
		System.out.println("FXLifeCycleApp() constructor : " + name);
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void init() {
		String name = Thread.currentThread().getName();
		System.out.println("init() method: " + name);
	}

	@Override
	public void start(Stage stage){
		String name = Thread.currentThread().getName();
		System.out.println("start() method: " + name);

		Scene scene = new Scene(new Group(), 200, 200);
		stage.setScene(scene);
		stage.setTitle("JavaFX Application Life Cycle");
		stage.show();
	}
	
	@Override
	public void stop() {
		String name = Thread.currentThread().getName();
		System.out.println("stop() method: " + name);
	}
}
```

The launch() method of the Application class creates these threads. During the lifetime of a JavaFX application, the JavaFX runtime calls the following methods of the specified JavaFX Application class in order:
* The no-args constructo
* The init() method
* The start() method
* The stop() method

---