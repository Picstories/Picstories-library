package org.picstories.library.repository;

import org.picstories.library.model.entity.comics.ComicsMD;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * @author arman.shamenov
 */
@Repository
public interface ComicsMongoRepository extends ReactiveMongoRepository<ComicsMD, String> {
    @Override
    <S extends ComicsMD> Mono<S> save(S entity);
}
