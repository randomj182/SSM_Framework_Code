

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

public class GeneratorSqlmap {

	public void generator() throws Exception{

		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		//指定 逆向工程配置文件
		// 全路径 即绝对路径   1.带盘符,如D:/			2.以http开头	http://
		//File configFile = new File("D:/eclipse/eclipse_git_repo/SSM_Framework_Code/Mybatis/Mybatis_Generator/src/main/resources/generatorConfig.xml"); 
		
		// 相对路径:不带/ --->相对的是以项目名为根路径,所以在全路径的基础上去掉项目名
        //File configFile = new File("src/main/resources/generatorConfig.xml");
        
		// 相对路径:不带/ 
		String genCfg = "generatorConfig.xml";
        File configFile = new File(GeneratorSqlmap.class.getResource(genCfg).getFile());
		
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
				callback, warnings);
		myBatisGenerator.generate(null);

	} 
	public static void main(String[] args) throws Exception {
		try {
			GeneratorSqlmap generatorSqlmap = new GeneratorSqlmap();
			generatorSqlmap.generator();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
