package org.silab.expertsystem.db.broker;

import java.util.List;

import org.silab.expertsystem.db.datasource.DataSource;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongoDBSession implements DBSession {

	DB db;
	
	@Override
	public List<Object> getAll(Object modelClass) {
		return null;
	}

	@Override
	public void setConnection(Object db) {
		this.db = (DB)db;
	}

}
