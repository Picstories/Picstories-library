package org.picstories.library.repository;

import org.picstories.library.model.entity.page.PageMD;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

/**
 * @author arman.shamenov
 */
public interface PageMongoRepository extends ReactiveMongoRepository<PageMD, String> {
    @Override
    <S extends PageMD> Mono<S> save(S entity);
}
