package org.solr.resources.index;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.solr.models.Document;
import org.solr.services.IndexerService;

@Path("/index")
public class IndexerResource {
	
	private IndexerService indexerService = IndexerService.getInstance();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UpdateResponse addDocument(Document d) {
		SolrInputDocument solrDocument = new SolrInputDocument();
		solrDocument.addField("id", d.getId());
		solrDocument.addField("title", d.getTitle());
		return indexerService.addDocument(solrDocument);
	}
	
	
}
