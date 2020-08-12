package com.daxue.bootelasticsearch;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class ElasticServiceUtils {
    private final static Logger logger = LoggerFactory.getLogger(ElasticServiceUtils.class);

    private RestHighLevelClient restHighLevelClient;

    @PostConstruct
    private void init() {
        try {
            if (restHighLevelClient != null) {
                restHighLevelClient.close();
            }
            //节点1和2
            HttpHost node1 = new HttpHost("127.0.0.1", 9200, "http");
//            HttpHost node2 = new HttpHost("127.0.0.1", 9200, "http");
//            RestClientBuilder builder = RestClient.builder(node1,node2);
            RestClientBuilder builder = RestClient.builder(node1);
            restHighLevelClient = new RestHighLevelClient(builder);
            logger.info("ElasticServiceUtils init RestHighLevelClient: {}", restHighLevelClient.toString());
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }

}
