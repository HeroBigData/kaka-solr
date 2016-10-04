/**   
* Copyright (c) 2009-2016 Founder Ltd. All Rights Reserved.   
*   
* This software is the confidential and proprietary information of   
* Founder. You shall not disclose such Confidential Information   
* and shall use it only in accordance with the terms of the agreements   
* you entered into with Founder.   
*   
*   Email: herobigdatacao@gmail.com
*/
     
/**   
* @Title: KakaHttpSolrClient.java 
* @Package xyz.taotao.search.solr.client.solrj.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @Company: kaka.bigdata
* @author HeroCao herobigdatacao@126.com  
* @date 2016年8月11日 下午1:20:01 
* @version V1.0   
*/    
package xyz.kaka.bigdata.solr.client.solrj.impl;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

import xyz.kaka.bigdata.solr.client.solrj.KakaSolrClient;


/** 
* @ClassName: KakaHttpSolrClient 
* @Description: Solr的单机版
* @Company: kaka.bigdata
* @author HeroCao herobigdatacao@126.com
* @date 2016年8月11日 下午1:20:01 
*  
*/
public class KakaHttpSolrClient implements KakaSolrClient {
	
	private String baseSolrUrl;
	
	public KakaHttpSolrClient(String baseSolrUrl) {
		super();
		this.baseSolrUrl = baseSolrUrl;
	}

	/**
	* (non-Javadoc) 
	*  
	*  
	* @return 
	* @see xyz.KakaSolrClient.search.solr.client.solrj.TTSolrClient#build() 
	*/
	@Override
	public SolrClient build() {
		return new HttpSolrClient.Builder(baseSolrUrl).build();
	}

}
