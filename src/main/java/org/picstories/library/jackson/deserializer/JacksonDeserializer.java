package org.picstories.library.jackson.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.jetbrains.annotations.Nullable;
import org.picstories.library.exceptions.SerializationException;
import org.picstories.library.jackson.PicstoriesSerializer;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author arman.shamenov
 */
public class JacksonDeserializer implements PicstoriesSerializer {
    private final ObjectMapper mapper;

    public JacksonDeserializer() {
        this(new ObjectMapper());
        this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.mapper.disable(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS);
    }

    public JacksonDeserializer(ObjectMapper mapper)  {
        this.mapper = mapper;
    }

    @Override
    public @Nullable byte[] serialize(@Nullable Object object) throws SerializationException {
        if (object == null) {
            return null;
        }

        try {
            return mapper.writer().writeValueAsBytes(object);
        } catch (JsonProcessingException e) {
            throw new SerializationException(e);
        }
    }

    @Override
    public @Nullable String serializeToString(@Nullable Object object) throws SerializationException {
        if (object == null) {
            return null;
        }

        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new SerializationException(e);
        }
    }

    @Override
    public <T> @Nullable T deserialize(@Nullable String data, Class<T> responseType) throws SerializationException {
        if (data == null || data.isEmpty()) {
            return null;
        }

        try {
            ObjectReader reader = mapper.reader();
            JsonNode json = reader.readTree(data);
            return reader.treeToValue(json, responseType);
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }

    @Override
    public <T> @Nullable T deserialize(@Nullable InputStream data, Class<T> responseType) throws SerializationException {
        if (data == null) {
            return null;
        }

        try {
            return mapper.readValue(data, responseType);
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }

    @Override
    public <T> @Nullable T deserialize(@Nullable byte[] data, Class<T> responseType) throws SerializationException {
        if (data == null || data.length == 0) {
            return null;
        }

        try {
            return mapper.readValue(data, responseType);
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }
}
