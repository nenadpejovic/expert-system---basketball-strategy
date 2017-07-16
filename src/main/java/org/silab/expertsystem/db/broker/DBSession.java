package org.silab.expertsystem.db.broker;

import java.util.List;
import java.util.Map;

import org.silab.expertsystem.db.datasource.DataSource;
import org.silab.expertsystem.model.Player;

public interface DBSession {

	public <T> List<T> all(Class<T> modelClass);
	
	public <T> List<T> get(Class<T> modelClass, Map<String,String> condition);
	
	public void setConnection(Object connection);
}
