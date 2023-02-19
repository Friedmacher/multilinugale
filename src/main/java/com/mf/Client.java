package com.mf;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "CLIENT", schema = "MULTI")
public class Client {
	// The ID of the client entity.
	@EmbeddedId
	private BasicID basicID;

	// The data fields of the client entity
	private Currency clientCurrency;

	// 1:n relation to the localized fields of the client entity.
	@OneToMany(mappedBy = "client", cascade = {CascadeType.ALL}, orphanRemoval = true)
	@MapKey(name = "basicIDLocalized.locale")
	@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
	private Map<Locale, ClientText> clientTexts = new HashMap<>();

	/**
	 * Constructor
	 *
	 * @param basicID The BasicID of the client entity.
	 * @param clientCurrency The standard currency for the client.
	 */
	public Client(BasicID basicID, Currency clientCurrency) {
		this.basicID = basicID;
		this.clientCurrency = clientCurrency;
	}

	/**
	 * Get the localized name of the client.
	 *
	 * @param locale The Locale for which the name of the client shall be returned.
	 * @return The localized name of the client.
	 */
	public String getName(Locale locale) {
		return clientTexts.get(locale).getName();
	}

	/**
	 * Get the localized description of the client.
	 *
	 * @param locale The Locale for which the description of the client shall be returned.
	 * @return The localized description of the client.
	 */
	public String getDescription(Locale locale) {
		return clientTexts.get(locale).getDescription();
	}
}