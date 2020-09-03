import com.google.common.base.CaseFormat;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.VerboseProgressCallback;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.GeneratedKey;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Test1 {

    @Test
    public void t1() {
        try {
            List<String> warnings = new ArrayList();

            File configFile = new File("src/main/resources/generatorConfiguration-tk.xml");

            Properties pros = new Properties();
            pros.setProperty("author", "GSean");


            String projectBase = "src/main/java";
//            String projectBase = "../mygenerator-example/src/main/java";
//            String projectResource = "../mygenerator-example/src/main/resources";
            String projectResource = "src/main/resources";
            //entity
            pros.setProperty("entity.Package", "com.gsean.entity");
            pros.setProperty("entity.Project", "../base-entity/src/main/java");

            //Mapper
            pros.setProperty("mapper.Package", "com.gsean.dao");
            pros.setProperty("mapper.Project", "../base-dao/src/main/java");

            //Mapper.xml
            pros.setProperty("mapperXml.Package", "mybatis");
            pros.setProperty("mapperXml.Project", "../base-dao/src/main/resources");

            //service interface
            pros.setProperty("service.Package", "com.gsean.service");
            pros.setProperty("service.Project", "../base-service/src/main/java");

            //service Implate
            pros.setProperty("serviceImpl.Package", "com.gsean.service.impl");
            pros.setProperty("serviceImpl.Project", "../base-service/src/main/java");

            //controller
//            pros.setProperty("controller.Package", "vip.corejava.controller");
//            pros.setProperty("controller.Project", projectBase);

            //DB
            pros.setProperty("jdbc.driver", "com.mysql.jdbc.Driver");
            pros.setProperty("jdbc.url", "jdbc:mysql://127.0.0.1:3306/db_base?tinyInt1isBit=false");
            pros.setProperty("jdbc.user", "root");
            pros.setProperty("jdbc.password", "123456");

            ConfigurationParser cp = new ConfigurationParser(pros, warnings);
            Configuration config = cp.parseConfiguration(configFile);
            Context context = config.getContext("AceContext");

            List<String> tables = Arrays.asList("role","user_role","permission","role_permission");
            tables.stream()
                    .forEach(tableName->{
                        TableConfiguration table = new TableConfiguration(context);
                        table.setTableName(tableName);
                        table.setDomainObjectName(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, tableName));
                        table.setGeneratedKey(new GeneratedKey("id","JDBC",true,""));
                        context.addTableConfiguration(table);
                    });


            DefaultShellCallback callback = new DefaultShellCallback(true);
            VerboseProgressCallback progressCallback = new VerboseProgressCallback();
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(progressCallback);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
