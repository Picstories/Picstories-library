package org.picstories.library.model.entity.comics;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.picstories.library.jackson.deserializer.LocalDateTimeDeserializer;
import org.picstories.library.jackson.serializer.LocalDateTimeSerializer;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

/**
 * @author arman.shamenov
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Comics {
    @Id
    protected String id;
    protected String comicId;
    protected String title;
    protected String description;
    protected String author;
    protected String mainPage;
    protected String initUrl;
    protected String logoUrl;
    protected String lang;
    protected String parserCode;
    protected int pageCount;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    protected LocalDateTime lastUpdate;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    protected LocalDateTime lastCheck;
}
