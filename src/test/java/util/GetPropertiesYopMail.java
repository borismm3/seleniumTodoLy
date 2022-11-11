package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetPropertiesYopMail {
    private static GetPropertiesYopMail getPropertiesYopMail = null;
    private String host;
    private String user;

    private GetPropertiesYopMail() {
        Properties properties = new Properties();
        String nameFile = "yopmail.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(nameFile);
        if (inputStream != null) {
            try {
                properties.load(inputStream);
                host = properties.getProperty("host");
                user = properties.getProperty("user");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static GetPropertiesYopMail getInstance() {
        if (getPropertiesYopMail == null)
            getPropertiesYopMail = new GetPropertiesYopMail();
        return getPropertiesYopMail;
    }

    public String getHost() {
        return host;
    }

    public String getUser() {
        return user;
    }
}
