package org.solr.controllers;

import java.io.IOException;
import java.util.Properties;

import org.apache.solr.client.solrj.ResponseParser;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

public class SolrController {
	
	private HttpSolrClient solrClient;
	private Properties properties;
	
	public SolrController(Properties props) {
		properties = props;
		solrClient = new HttpSolrClient.Builder(properties.getProperty("solrURL")).build();
	}
	
	public void buildQuery() {
		SolrQuery query = new SolrQuery();
		query.setQuery(null);
	}
	
	public SolrDocumentList generateResponse(SolrQuery query) {
		SolrDocumentList documents = null;
		try {
			QueryResponse response = solrClient.query(query);
			documents = response.getResults();
		} catch (SolrServerException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return documents;
	}

}
