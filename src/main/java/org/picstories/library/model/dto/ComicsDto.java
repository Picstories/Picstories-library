package org.picstories.library.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ComicsDto {
    private String id;

    private String title;
    private String description;
    private String author;
    private String mainPage;
    private String logoUrl;
    private String lang;

    private int pageCount;
}
