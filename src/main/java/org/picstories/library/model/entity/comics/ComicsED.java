package org.picstories.library.model.entity.comics;

import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author arman.shamenov
 */
@NoArgsConstructor
@Document(indexName = "picstories_comics", type = "comics")
public class ComicsED extends Comics {

    public ComicsED(Comics comic) {
        this.id = comic.id;
        this.comicId = comic.comicId;
        this.title = comic.title;
        this.description = comic.description;
        this.author = comic.author;
        this.mainPage = comic.mainPage;
        this.initUrl = comic.initUrl;
        this.logoUrl = comic.logoUrl;
        this.lang = comic.lang;
        this.parserCode = comic.parserCode;
        this.pageCount = comic.pageCount;
        this.lastUpdate = comic.lastUpdate;
        this.lastCheck = comic.lastCheck;
    }
}
