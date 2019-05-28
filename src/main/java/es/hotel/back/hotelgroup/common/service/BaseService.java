package es.hotel.back.hotelgroup.common.service;


public interface BaseService<K, I, O> extends QueryService<K, O> {

    /**
     * Insert an entity
     *
     * @param entity
     *            The entity
     *
     * @return The inserted entity
     */
    O insert(I entity);

    /**
     * Update an entity
     *
     * @param entity
     *            The entity
     *
     * @return The updated entity
     */
    O update(I entity);

    /**
     * Deletes an entity by id.
     *
     * @param id
     *            The entity id.
     */
    void delete(K id);

    /**
     * Deletes all entities.
     */
    default void deleteAll() {
        throw new UnsupportedOperationException();
    }
}