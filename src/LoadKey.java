import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadKey {

	public Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream(
				"src/properties/key.properties");
		props.load(file);
		return props;
	}

}
