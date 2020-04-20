package org.picstories.library.model.entity.page;

import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Document(collection = "pages")
public class PageMD extends Page {
    public PageMD(Page page) {
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
