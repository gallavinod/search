package org.solr.resources.search;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.solr.models.Document;
import org.solr.services.DocumentService;

@Path("/documents")
public class SearchResource {
	
	DocumentService documentService = new DocumentService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List <Document> getDocuments() {
		List <Document> documents = documentService.getAllDocuments();
		return documents;
	}
	
	@GET
	@Path("/{documentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Document getDocument(@PathParam("documentId") long id) {
		return documentService.getDocument(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Document addDocument(Document d) {
		return documentService.addDocument(d);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Document updateDocument(Document d) {
		return documentService.addDocument(d);
	}
}
