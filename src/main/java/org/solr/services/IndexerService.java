package org.solr.services;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;

public class IndexerService {
	
	private static HttpSolrClient solrClient = null;
	
	private IndexerService() {
		solrClient = new HttpSolrClient.Builder("http://localhost:8983/solr/vgalla").build(); 
	}
	
	private static class IndexerServiceHelper {
		private static final IndexerService INSTANCE = new IndexerService();
	}
	
	public static IndexerService getInstance() {
		return IndexerServiceHelper.INSTANCE;
	}
	
	public UpdateResponse addDocument(SolrInputDocument d) {
		UpdateResponse response = null;
		try {
			 response = solrClient.add(d);
			solrClient.commit();
		} catch (SolrServerException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return response;
	}

}
