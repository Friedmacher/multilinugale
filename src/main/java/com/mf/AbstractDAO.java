package com.mf;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public abstract class AbstractDAO<T> implements DAO<T> {
	protected static final EntityManagerFactory EM_FACTORY = Persistence.createEntityManagerFactory("multilingual");
	protected static final EntityManager EM = EM_FACTORY.createEntityManager();

	/**
	 * Read a specific entity from the database.
	 *
	 * @param id The BasicID of the entity to be read from the database.
	 *
	 * @return A specific entity.
	 */
	@Override
	public Optional<T> read(BasicID id) {
		return Optional.empty();
	}

	/**
	 * Read all entities from the database.
	 *
	 * @return A list of all available entities.
	 */
	@Override
	public List<T> readAll() {
		return null;
	}

	/**
	 * Create a new entity in the database.
	 *
	 * @param t The new entity to be created in the database.
	 */
	@Override
	public void create(T t) {

	}

	/**
	 * Update a specific entity in the database.
	 *
	 * @param t The entity which shall be updated in the database.
	 */
	@Override
	public void update(T t) {

	}

	/**
	 * Delete a specific entity from the database.
	 *
	 * @param t The entity which shall be deleted from the database.
	 */
	@Override
	public void delete(T t) {

	}

	/**
	 * Helper methode to execute a JPA statement within a database transaction.
	 *
	 * @param action The JPA statement to be executed.
	 */
	protected void executeInsideTransaction(Consumer<EntityManager> action) {
		EntityTransaction transaction = EM.getTransaction();
		try {
			transaction.begin();
			action.accept(EM);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}


	}
}
