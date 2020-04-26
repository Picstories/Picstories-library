package org.picstories.library.mongodb;

import com.mongodb.ConnectionString;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.convert.NoOpDbRefResolver;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author arman.shamenov
 */
@Configuration
public class ReactiveMongoDbConfiguration extends AbstractReactiveMongoConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(ReactiveMongoDbConfiguration.class);

    private final MongoClient client;
    private final String databaseName;

    public ReactiveMongoDbConfiguration(@Value("${spring.data.mongodb.database}") String databaseName,
                                        @Value("${spring.data.mongodb.uri}") String uri) {
        ConnectionString connectionString = new ConnectionString(uri);
        logger.info("Uri to connect to mongo = {}", uri);
        logger.info("Connection string to mongo  = {} ", connectionString);
        logger.info("Database name = {}", databaseName);
        client = MongoClients.create(connectionString);
        this.databaseName = databaseName;
    }

    @Override
    public @NotNull MongoClient reactiveMongoClient() {
        return client;
    }

    @Override
    protected @NotNull String getDatabaseName() {
        return databaseName;
    }

    @Override
    public @NotNull ReactiveMongoDatabaseFactory reactiveMongoDbFactory() {
        return new SimpleReactiveMongoDatabaseFactory(client, databaseName);
    }

    @Override
    public @NotNull MappingMongoConverter mappingMongoConverter() {
        List<Converter<?, ?>> converters = new ArrayList<>(Jsr310Converters.getConvertersToRegister());
        MongoCustomConversions mongoCustomConversions = new MongoCustomConversions(converters);

        MongoMappingContext mappingContext = new MongoMappingContext();
        MappingMongoConverter mongoConverter = new MappingMongoConverter(NoOpDbRefResolver.INSTANCE, mappingContext);
        mongoConverter.setCustomConversions(mongoCustomConversions);
        mongoConverter.afterPropertiesSet();
        return mongoConverter;
    }
}
