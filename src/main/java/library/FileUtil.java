package library;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author Amit
 *
 */
public class FileUtil {

	public static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(FileUtil.class);
	public static final String ENV_PATH = "./src/test/resources/envconfig/";

	private FileUtil() {

	}

	public static Map<String, String> readProperties(final String path) {
		Properties prop = new Properties();
		Map<String, String> propMap = new HashMap<String, String>();
		InputStream input = null;
		try {
			input = new FileInputStream(path);
			prop.load(input);
		} catch (IOException e) {
			FileUtil.logger.error("Exception at readproperties:", e);
		}
		for (java.util.Map.Entry<Object, Object> entries : prop.entrySet()) {
			propMap.put((String) entries.getKey(), (String) entries.getValue());
		}
		return propMap;
	}
	
	public static Map<String, String> getConfigProperties(final String env) {
		return readProperties(FileUtil.ENV_PATH + env + ".properties");
	}
}
