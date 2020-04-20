package org.picstories.library.elasticsearch;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.reactive.ReactiveElasticsearchClient;
import org.springframework.data.elasticsearch.client.reactive.ReactiveRestClients;
import org.springframework.data.elasticsearch.config.AbstractReactiveElasticsearchConfiguration;

import java.util.List;

/**
 * @author arman.shamenov
 */
@Configuration
public class ReactiveElasticsearchConfiguration extends AbstractReactiveElasticsearchConfiguration {

    @Value("${spring.elasticsearch.rest.uris}")
    private List<String> elasticsearchUris;

    @Override
    @Bean
    public ReactiveElasticsearchClient reactiveElasticsearchClient() {
        ClientConfiguration clientConfiguration = ClientConfiguration
                .builder()
                .connectedTo(elasticsearchUris.toArray(String[]::new))
                .build();

        return ReactiveRestClients.create(clientConfiguration);
    }
}
