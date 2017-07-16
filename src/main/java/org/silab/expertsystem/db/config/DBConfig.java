package org.silab.expertsystem.db.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.activemq.store.jdbc.DataSourceServiceSupport;
import org.silab.expertsystem.db.broker.DBSession;
import org.silab.expertsystem.db.broker.MongoDBSession;
import org.silab.expertsystem.db.datasource.DataSource;
import org.silab.expertsystem.db.datasource.MongoDataSource;

public class DBConfig {

	Map<String, String> dbProperties;
	DataSource dataSource;
	DBSession dbSession;
	
	public void setDBProperties(Properties properties) {
		
		Map<String, String> propertiesMap = new HashMap<>();
		propertiesMap.put("type", properties.getProperty("type"));
		propertiesMap.put("url", properties.getProperty("url"));
        propertiesMap.put("port", properties.getProperty("port"));
        propertiesMap.put("username", properties.getProperty("user"));
        propertiesMap.put("password", properties.getProperty("password"));
        propertiesMap.put("dbName", properties.getProperty("dbName"));
        
        dbProperties = propertiesMap;
        
  	}

	public void setSession(){
		if(dbProperties.get("type").equals("MongoDB")){
			dataSource = new MongoDataSource();
			dbSession = new MongoDBSession();
			dbSession.setConnection(dataSource.connect(dbProperties));
		}
	}
	
	public DBSession getSession(){
		return dbSession;
	}


}
