package com.mf;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
	/**
	 * Read a specific entity from the database.
	 *
	 * @param id The BasicID of the entity to be read from the database.
	 * @return  A specific entity.
	 */
	Optional<T> read(BasicID id);

	/**
	 * Read all entities from the database.
	 *
	 * @return A list of all available entities.
	 */
	List<T> readAll();

	/**
	 * Create a new entity in the database.
	 *
	 * @param t The new entity to be created in the database.
	 */
	void create(T t);

	/**
	 * Update a specific entity in the database.
	 *
	 * @param t The entity which shall be updated in the database.
	 */
	void update(T t);

	/**
	 * Delete a specific entity from the database.
	 *
	 * @param t The entity which shall be deleted from the database.
	 */
	void delete(T t);
}
