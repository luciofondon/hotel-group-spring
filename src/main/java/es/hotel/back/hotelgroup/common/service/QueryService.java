package es.hotel.back.hotelgroup.common.service;

import java.util.List;
import java.util.Optional;

/**
 * Generic interface for services that provide query services
 */
public interface QueryService<K, E> {

    /**
     * Retrieves all entities.
     *
     * @return All entities.
     */
    List<E> findAll();

    /**
     * Retrieves one entity by id.
     *
     * @param id
     *            The entity id.
     *
     * @return The entity.
     */
    Optional<E> findOne(K id);
}
