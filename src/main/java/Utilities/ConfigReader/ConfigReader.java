package Utilities.ConfigReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

 //Cette classe a pour but de lire les données des fichiers
// .properties pour les données concernant le navigateurs, type de machines, etc...

public class ConfigReader {

    //On déclare une instance de la classe Properties qui permet d'acceder aux instances
    //de la classe Properties
    private Properties properties;

    //cette fonction permet de localiser le ficher de type properties
    //de le loader avec les données dans le fichier
    public Properties init_props(){
        properties=new Properties();
        try{
            FileInputStream ip= new FileInputStream("src/main/resources/propertiesData/utilData.properties");
            properties.load(ip);
        }catch (FileNotFoundException exception){
            exception.fillInStackTrace();
            exception.printStackTrace();
        }catch (IOException exception){
            exception.fillInStackTrace();
        }
        return properties;
    }

}
