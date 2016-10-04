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
* @Title: TTCloudSolrClient.java 
* @Package xyz.kaka.search.solr.client.solrj.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @Company: xyz.hero.cao
* @author HeroCao herobigdatacao@126.com  
* @date 2016年8月11日 下午1:22:32 
* @version V1.0   
*/    
package xyz.kaka.bigdata.solr.client.solrj.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.CloudSolrClient;

import xyz.kaka.bigdata.solr.client.solrj.KakaSolrClient;


/** 
* @ClassName: KakaCloudSolrClient 
* @Description: Solr的集群版
* @Company: xyz.hero.cao
* @author HeroCao herobigdatacao@126.com
* @date 2016年8月11日 下午1:22:32 
*  
*/
public class KakaCloudSolrClient implements KakaSolrClient {

	/** 
	* @Fields defaultCollection : 默认的Collection
	*/
	private String defaultCollection;
	
	/** 
	* @Fields zkHosts : Zookeeper集群主机集合 <br/>
	* 例如：IP地址:端口号
	* List<String> zkHosts = new ArrayList<String>();
		zkHosts.add("192.168.100.175:2181");
		zkHosts.add("192.168.100.176:2181");
		zkHosts.add("192.168.100.177:2181");
	*/
	private List<String> zkHosts;
	
	/** 
	* @Fields zkHost : Zookeeper集群主机 <br/>
	* 例如："192.168.100.175:2181,192.168.100.176:2181,192.168.100.177:2181"，<br/>
	* 注意：IP地址:端口号
	*/
	private String zkHost;
	
	/**
	 * @param zkHost Zookeeper集群主机
	 * @param defaultCollection 默认的Collection
	 */
	public KakaCloudSolrClient(String zkHost, String defaultCollection) {
		super();
		this.zkHost = zkHost;
		this.defaultCollection = defaultCollection;
	}
	
	/**
	 * @param zkHosts  Zookeeper集群主机集合
	 * @param defaultCollection 默认的Collection
	 */
	public KakaCloudSolrClient(List<String> zkHosts, String defaultCollection) {
		super();
		this.zkHosts = zkHosts;
		this.defaultCollection = defaultCollection;
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
		if (StringUtils.isBlank(defaultCollection)) {
			throw new IllegalArgumentException("非法参数，defaultCollection=" + defaultCollection);
		}
		if (StringUtils.isNoneBlank(this.zkHost)) {
			 CloudSolrClient cloudSolrClient = new CloudSolrClient.Builder().withZkHost(this.zkHost).build();
			 // 设置默认Collection
			 cloudSolrClient.setDefaultCollection(defaultCollection);
			 return cloudSolrClient;
		} else if (null != this.zkHosts && !this.zkHosts.isEmpty()) {
			 CloudSolrClient cloudSolrClient = new CloudSolrClient.Builder().withZkHost(this.zkHosts).build();
			 // 设置默认Collection
			 cloudSolrClient.setDefaultCollection(defaultCollection);
			 return cloudSolrClient;
		}
		throw new IllegalArgumentException(String.format("非法参数，请设置zkHost=%s 或者 zkHosts=%s, 其中一个值", this.zkHost, this.zkHosts));
	}

}
