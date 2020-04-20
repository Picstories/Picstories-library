package org.picstories.library.model.entity.page;

import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author arman.shamenov
 */
@NoArgsConstructor
@Document(indexName = "picstories_pages", type = "pages")
public class PageED extends Page {
    public PageED(Page page) {
        id = page.id;
        comicId = page.comicId;
        number = page.number;
        title = page.title;
        description = page.description;
        nextUrl = page.nextUrl;
        pageUrl = page.pageUrl;
        images = page.images;
    }
}
