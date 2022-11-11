package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetPropertiesTodoIst {
    private static GetPropertiesTodoIst getPropertiesTodoIst = null;
    private String host;
    private String user;
    private String pwd;

    private GetPropertiesTodoIst() {
        Properties properties = new Properties();
        String nameFile = "todoist.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(nameFile);
        if (inputStream != null) {
            try {
                properties.load(inputStream);
                host = properties.getProperty("host");
                user = properties.getProperty("user");
                pwd = properties.getProperty("pwd");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static GetPropertiesTodoIst getInstance() {
        if (getPropertiesTodoIst == null)
            getPropertiesTodoIst = new GetPropertiesTodoIst();
        return getPropertiesTodoIst;
    }

    public String getHost() {
        return host;
    }

    public String getUser() {
        return user;
    }

    public String getPwd() {
        return pwd;
    }
}
