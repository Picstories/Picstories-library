package org.picstories.library.jackson.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

/**
 * @author arman.shamenov
 */
public class LocalDateTimeSerializer extends StdSerializer<LocalDateTime> {
    private final Supplier<DateTimeFormatter> formatter;

    // yyyy-MM-dd'T'HH:mm:ss.SSS default

    public LocalDateTimeSerializer(Class<LocalDateTime> t) {
        this(t, () -> DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS"));
    }

    public LocalDateTimeSerializer(Class<LocalDateTime> t, Supplier<DateTimeFormatter> formatter) {
        super(t);
        this.formatter = formatter;
    }

    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(value.format(formatter.get()));
    }
}
