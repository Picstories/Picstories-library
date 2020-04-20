package org.picstories.library.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.picstories.library.model.entity.page.Page;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PageDto {
    private String id;

    private String comicId;
    private int number;
    private String title;
    private String description;
    private String pageUrl;
    private String nextUrl;
    private List<ImageDto> images;

    @NoArgsConstructor
    public static class ImageDto extends Page.Image {

        public ImageDto(String url) {
            super(url);
        }

        public ImageDto(String url, String previewUrl, String largeUrl) {
            super(url, previewUrl, largeUrl);
        }

        public String getPreview() {
            return previewUrl != null ? previewUrl : url;
        }

        public String getLarge() {
            return largeUrl != null ? largeUrl : url;
        }
    }
}
