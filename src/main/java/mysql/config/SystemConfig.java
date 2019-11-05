package mysql.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 应用系统的配置类
 * @author dc
 *
 */
public class SystemConfig {
    private static Properties defaultProperties;

    /**
     * 获取应用缺省的配置数据
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
     * 加载一个Properties文件
     * @param filename
     * @return
     */
    public static Properties getFileProperties(String filename){
        FileInputStream fis=null;
        Properties prop=null;
        try {
            fis = new FileInputStream(filename);
            prop = new Properties();
            //从文件中加载配置
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
