package org.picstories.library.elasticsearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.reactive.ReactiveElasticsearchClient;
import org.springframework.data.elasticsearch.client.reactive.ReactiveRestClients;
import org.springframework.data.elasticsearch.config.AbstractReactiveElasticsearchConfiguration;

import java.net.InetSocketAddress;

/**
 * @author arman.shamenov
 */
@Configuration
public class ReactiveElasticsearchConfiguration extends AbstractReactiveElasticsearchConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(ReactiveElasticsearchConfiguration.class);

    @Value("${spring.elasticsearch.jest.proxy.host}")
    private String hostname;
    @Value("${spring.elasticsearch.jest.proxy.port}")
    private Integer port;

    @Override
    @Bean
    public ReactiveElasticsearchClient reactiveElasticsearchClient() {
        logger.info("Elasticsearch connect to host = {} and port = {}", hostname, port);
        InetSocketAddress address = new InetSocketAddress(hostname, port);
        ClientConfiguration clientConfiguration = ClientConfiguration
                .create(address);

        return ReactiveRestClients.create(clientConfiguration);
    }
}
