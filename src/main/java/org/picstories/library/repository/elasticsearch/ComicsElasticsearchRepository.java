package org.picstories.library.repository.elasticsearch;

import org.jetbrains.annotations.NotNull;
import org.picstories.library.model.entity.comics.ComicsED;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

/**
 * @author arman.shamenov
 */
@Repository
public interface ComicsElasticsearchRepository extends ReactiveElasticsearchRepository<ComicsED, String> {
    Flux<ComicsED> findComicEDByLastCheckIsLessThanOrderByLastCheckAsc(LocalDateTime time);

    Flux<ComicsED> findAllBy(Pageable pageable);

    @Override
    Mono<ComicsED> findById(@NotNull String id);
}
