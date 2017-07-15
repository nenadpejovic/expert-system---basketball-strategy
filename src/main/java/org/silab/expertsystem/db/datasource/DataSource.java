package org.silab.expertsystem.db.datasource;

import java.util.Map;
import java.util.Properties;

public interface DataSource {
	
	public Object connect(Map<String,String> dbProperties);

}
