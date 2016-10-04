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
* @Title: TTSolrClient.java 
* @Package xyz.taotao.search.solr.client.solrj 
* @Description: TODO(用一句话描述该文件做什么) 
* @Company: xyz.hero.cao
* @author HeroCao herobigdatacao@126.com  
* @date 2016年8月11日 下午1:09:45 
* @version V1.0   
*/    
package xyz.kaka.bigdata.solr.client.solrj;

import org.apache.solr.client.solrj.SolrClient;

/** 
* @ClassName: KakaSolrClient 
* @Description: KakaSolrClient封装Solr的单机版和集群版的接口 
* @Company: xyz.hero.cao
* @author HeroCao herobigdatacao@126.com
* @date 2016年8月11日 下午1:09:45 
*  
*/
public interface KakaSolrClient {
	
	/** 
	* @Title: build 
	* @Description: 创建 org.apache.solr.client.solrj.SolrClient 实例对象
	* @author HeroCao herobigdatacao@126.com
	* @date 2016年8月11日 下午1:22:45
	*
	* @return     
	*/
	SolrClient build();
	
}
