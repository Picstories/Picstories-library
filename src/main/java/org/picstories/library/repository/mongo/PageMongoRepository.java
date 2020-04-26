package org.picstories.library.repository.mongo;

import org.picstories.library.model.entity.page.PageMD;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * @author arman.shamenov
 */
@Repository
public interface PageMongoRepository extends ReactiveMongoRepository<PageMD, String> {
    @Override
    <S extends PageMD> Mono<S> save(S entity);
}
