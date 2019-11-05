package mysql.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Ӧ��ϵͳ��������
 * @author dc
 *
 */
public class SystemConfig {
    private static Properties defaultProperties;

    /**
     * ��ȡӦ��ȱʡ����������
     * @return
     */
    public static Properties getDefaultProperties(){
        if(defaultProperties==null){
            String filePath=SystemConfig.class.getResource("/").getPath();
            String filename = filePath+"config.properties";
            defaultProperties=getFileProperties(filename);
        }
        return defaultProperties;
    }

    /**
     * ����һ��Properties�ļ�
     * @param filename
     * @return
     */
    public static Properties getFileProperties(String filename){
        FileInputStream fis=null;
        Properties prop=null;
        try {
            fis = new FileInputStream(filename);
            prop = new Properties();
            //���ļ��м�������
            prop.load(fis);
            return prop;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }finally{
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

}
