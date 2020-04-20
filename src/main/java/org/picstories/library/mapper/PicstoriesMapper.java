package org.picstories.library.mapper;

import org.modelmapper.ModelMapper;
import org.picstories.library.model.dto.ComicsDto;
import org.picstories.library.model.dto.PageDto;
import org.picstories.library.model.entity.comics.Comics;
import org.picstories.library.model.entity.page.Page;

import java.util.function.Supplier;

/**
 * @author arman.shamenov
 */
public class PicstoriesMapper {
    private final Supplier<ModelMapper> mapper;

    public PicstoriesMapper(Supplier<ModelMapper> mapper) {
        this.mapper = mapper;
    }

    public PicstoriesMapper() {
        this(ModelMapper::new);
    }

    public Comics toComicEntity(ComicsDto dto) {
        return mapper.get().map(dto, Comics.class);
    }

    public ComicsDto toComicDTO(Comics comic) {
        return mapper.get().map(comic, ComicsDto.class);
    }

    public PageDto toPageDTO(Page page) {
        return mapper.get().map(page, PageDto.class);
    }

    public Page toPageEntity(PageDto dto) {
        return mapper.get().map(dto, Page.class);
    }
}
