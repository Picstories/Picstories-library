package org.picstories.library.repository.elasticsearch;

import org.jetbrains.annotations.NotNull;
import org.picstories.library.model.entity.page.PageED;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author arman.shamenov
 */
@Repository
public interface PageElasticsearchRepository extends ReactiveElasticsearchRepository<PageED, String> {
    Flux<PageED> findByComicId(String comicId, Pageable pageable);

    Mono<PageED> findByComicIdAndNumber(String comicId, int number);

    @Override
    Mono<PageED> findById(@NotNull String id);
}
