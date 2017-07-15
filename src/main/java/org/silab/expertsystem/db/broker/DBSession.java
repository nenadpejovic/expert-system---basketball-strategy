package org.silab.expertsystem.db.broker;

import java.util.List;

import org.silab.expertsystem.db.datasource.DataSource;
import org.silab.expertsystem.model.Player;

public interface DBSession {

	public List<Object> getAll(Object modelClass);
	
	public void setConnection(Object connection);
}
