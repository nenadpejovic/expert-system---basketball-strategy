package org.silab.expertsystem.db.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.silab.expertsystem.db.broker.DBSession;
import org.silab.expertsystem.db.broker.MongoDBSession;
import org.silab.expertsystem.db.datasource.DataSource;
import org.silab.expertsystem.model.Game;
import org.silab.expertsystem.model.Player;

public abstract class AbstractDao <T>{
	
    private final Class<T> persistentClass;
    
    private DBSession session;

    
    @SuppressWarnings("unchecked")
    public AbstractDao(DBSession session){
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.session = session;
    }
    
    
    public List<T> getAll(){
    	return session.all(persistentClass);
    }
    
}
