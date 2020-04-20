package org.picstories.library.model.entity.page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Page {
    @Id
    protected String id;

    protected String comicId;
    protected int number;
    protected String title;
    protected String description;
    protected String pageUrl;
    protected String nextUrl;
    protected List<Image> images;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Image {
        protected String url;
        protected String previewUrl;
        protected String largeUrl;

        protected Image(String url) {
            this.url = url;
        }
    }
}
