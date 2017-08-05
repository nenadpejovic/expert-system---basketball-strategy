package org.silab.expertsystem.db.broker;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.silab.expertsystem.config.annotations.ModelTable;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoDBSession implements DBSession {

	MongoDatabase db;

	@Override
	public <T> List<T> all(Class<T> modelClass) {

		try {
			List<T> list = new LinkedList<>();

			if (modelClass.isAnnotationPresent(ModelTable.class)) {

				Annotation modelTable = modelClass.getAnnotation(ModelTable.class);
				String collectionName = ((ModelTable) modelTable).name();

				MongoCollection<Document> collection = db.getCollection(collectionName);

				MongoCursor<Document> cursor = collection.find().iterator();

				
				
				while (cursor.hasNext()) {

					

					Document doc = cursor.next();
					Field[] fields = modelClass.getDeclaredFields();
			
					T obj = modelClass.newInstance();
					
					for (int i = 0; i < fields.length; i++) {
						if(doc.get(fields[i].getName()) != null){
							
							Field field = fields[i];
							
							field.setAccessible(true);
							field.set(obj, doc.get(field.getName()));
						}
					}
					
					list.add(obj);

				}
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public <T> List<T> get(Class<T> modelClass, Map<String, String> condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setConnection(Object connection) {
		this.db = (MongoDatabase) connection;
	}

}
