package org.picstories.library.model.kafka.parsers;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.picstories.library.model.entity.comics.Comics;
import org.picstories.library.model.entity.page.Page;

/**
 * @author arman.shamenov
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class ParseTask extends AbstractTask {
    private Comics comic;
    private Page page;
}
