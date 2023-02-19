package com.mf;

import jakarta.persistence.Query;

import java.util.List;
import java.util.Optional;

public class ClientDAO extends AbstractDAO<Client> {

	public ClientDAO() {}

	/**
	 * Read a specific client from the database.
	 *
	 * @param id The BasicID of the client to be read from the database.
	 *
	 * @return A specific client.
	 */
	@Override
	public Optional<Client> read(BasicID id) {
		return Optional.ofNullable(EM.find(Client.class, id));
	}

	/**
	 * Read all clients from the database.
	 *
	 * @return A list of all available clients.
	 */
	@Override
	public List<Client> readAll() {
		Query query = EM.createQuery("SELECT c FROM Client c");

		@SuppressWarnings("unchecked")
		List<Client> clientList = query.getResultList();

		return clientList;
	}

	/**
	 * Create a new client in the database.
	 *
	 * @param client The new client to be created in the database.
	 */
	@Override
	public void create(Client client) {
		executeInsideTransaction(EM -> EM.persist(client));
	}

	/**
	 * Update a specific client in the database.
	 *
	 * @param client The client which shall be updated in the database.
	 */
	@Override
	public void update(Client client) {
		executeInsideTransaction(EM -> EM.merge(client));
	}

	/**
	 * Delete a specific client from the database.
	 *
	 * @param client The client which shall be deleted from the database.
	 */
	@Override
	public void delete(Client client) {
		executeInsideTransaction(EM -> EM.remove(client));
	}


}
