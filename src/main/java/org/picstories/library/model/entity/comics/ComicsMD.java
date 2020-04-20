package org.picstories.library.model.entity.comics;

import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author arman.shamenov
 */
@NoArgsConstructor
@Document(collation = "comics")
public class ComicsMD extends Comics {

    public ComicsMD(Comics comic) {
        this.id = comic.getId();
        this.comicId = comic.getComicId();
        this.title = comic.getTitle();
        this.description = comic.getDescription();
        this.author = comic.getAuthor();
        this.mainPage = comic.getMainPage();
        this.initUrl = comic.getInitUrl();
        this.logoUrl = comic.getLogoUrl();
        this.lang = comic.getLang();
        this.parserCode = comic.getParserCode();
        this.pageCount = comic.getPageCount();
        this.lastUpdate = comic.getLastUpdate();
        this.lastCheck = comic.getLastCheck();
    }
}
