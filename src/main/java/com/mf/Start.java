package com.mf;

import java.util.*;

public class Start {
	public static void main(String[] args) {
		//TODO: copy everything to test classes.

		Locale myLocaleEN = new Locale("en", "US");
		Locale myLocaleDE = new Locale("de", "AT");

		Currency currency = Currency.getInstance(myLocaleDE);

		UUID id = UUID.randomUUID();

		Client myClient = new Client(new BasicID(id), currency);

		ClientText myClientEN = new ClientText(new BasicIDLocalized(id, myLocaleEN), "Development Client", "This is the first development client");
		myClientEN.setClient(myClient);
		myClient.getClientTexts().put(myLocaleEN, myClientEN);

		ClientText myClientDE = new ClientText(new BasicIDLocalized(id, myLocaleDE), "Entwicklungsmandant", "Das ist der erste Entwicklungsmandant");
		myClientDE.setClient(myClient);
		myClient.getClientTexts().put(myLocaleDE, myClientDE);

		ClientDAO clientDAO = new ClientDAO();
		clientDAO.create(myClient);

		System.out.println("#####################");
		System.out.println("# ALL clients in DB #");
		System.out.println("#####################");

		List<Client> dbClients = clientDAO.readAll();
		dbClients.forEach(c -> {
			System.out.println("Deutsch");
			System.out.println("Client ID:          " + c.getBasicID().getId().toString());
			System.out.println("Client Name:        " + c.getName(myLocaleDE));
			System.out.println("Client Description: " + c.getDescription(myLocaleDE));
			System.out.println("Client Currency:    " + c.getClientCurrency().toString());
			System.out.println("=====================================================");
			System.out.println("English");
			System.out.println("Client ID:          " + c.getBasicID().getId().toString());
			System.out.println("Client Name:        " + c.getName(myLocaleEN));
			System.out.println("Client Description: " + c.getDescription(myLocaleEN));
			System.out.println("Client Currency:    " + c.getClientCurrency().toString());
			System.out.println("=====================================================");
		});

		System.out.println("#####################");
		System.out.println("# ONE client in DB #");
		System.out.println("#####################");

		Optional<Client> dbClient = clientDAO.read(new BasicID(UUID.fromString("ffa5ca2c-14bf-420b-951c-834fa8cde794")));
		if (dbClient.isPresent()) {
			System.out.println("Deutsch");
			System.out.println("Client ID:          " + dbClient.get().getBasicID().getId().toString());
			System.out.println("Client Name:        " + dbClient.get().getName(myLocaleDE));
			System.out.println("Client Description: " + dbClient.get().getDescription(myLocaleDE));
			System.out.println("Client Currency:    " + dbClient.get().getClientCurrency().toString());
			System.out.println("=====================================================");
			System.out.println("English");
			System.out.println("Client ID:          " + dbClient.get().getBasicID().getId().toString());
			System.out.println("Client Name:        " + dbClient.get().getName(myLocaleEN));
			System.out.println("Client Description: " + dbClient.get().getDescription(myLocaleEN));
			System.out.println("Client Currency:    " + dbClient.get().getClientCurrency().toString());
			System.out.println("=====================================================");
		} else {
			System.out.println("# No client found in DB #");
		}

	}
}
