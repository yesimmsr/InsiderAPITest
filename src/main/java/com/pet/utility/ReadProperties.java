package com.pet.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
    static Properties userProperties;

    static {
        userProperties = new Properties();
        try {
            InputStream propertiesStream = BaseTest.class.getClassLoader().getResourceAsStream("user.properties");
            userProperties.load(propertiesStream);
            propertiesStream.close();
            propertiesStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getID() {
        String id = userProperties.getProperty("_ID");
        return id;
    }

    public static String getPetId() {
        String petId = userProperties.getProperty("_PETID");
        return petId;
    }

    public static String getQuantity() {
        String quantity = userProperties.getProperty("_QUANTITY");
        return quantity;
    }

    public static String getshipDate() {
        String shipDate = userProperties.getProperty("_SHIPDATE");
        return shipDate;
    }


    public static String getStatus() {
        String status = userProperties.getProperty("_STATUS");
        return status;
    }

    public static String getCompleteStatus() {
        String complateStatus = userProperties.getProperty("_COMPLATESTATUS");
        return complateStatus;
    }

}
