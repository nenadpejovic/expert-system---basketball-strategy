package org.silab.expertsystem.db.datasource;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.mongodb.MongoClient;


public class MongoDataSource implements DataSource{

	
	@Override
	public Object connect(Map<String,String> dbProperties) {
		MongoClient client = new MongoClient(dbProperties.get("url"), Integer.parseInt(dbProperties.get("port")));
		return client.getDatabase(dbProperties.get("dbName"));
	}


}
