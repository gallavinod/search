package org.solr.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.solr.models.Document;

public class DocumentService {
	
	private static Map <Long, Document> documentMap = new HashMap <Long, Document> ();
	
	public DocumentService() {
		Document d1 = new Document(1L, "Document 1", new Date());
		Document d2 = new Document(2L, "Document 2", new Date());
		
		documentMap.put(d1.getId(), d1);
		documentMap.put(d2.getId(), d2);
	}
	
	public Document getDocument(long id) {
		return documentMap.get(id);
	}
	
	public List <Document> getAllDocuments() {
		List <Document> documents = new ArrayList <Document> (documentMap.values());
		
		return documents;
	}
	
	public Document addDocument(Document d) {
		long id = d.getId();
		documentMap.put(id, d);
		return documentMap.get(d.getId());
	}
	
	public void removeDocument(Document d) {
		documentMap.remove(d.getId());
	}
	
	public void updateDocument(Document d) {
		
	}

}
