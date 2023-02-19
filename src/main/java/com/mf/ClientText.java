package com.mf;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "CLIENT_TEXT", schema = "MULTI")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class ClientText {
	// The localized ID of the client entity.
	@EmbeddedId
	private BasicIDLocalized basicIDLocalized;

	// The localized data fields of the client entity
	private String name;
	private String description;

	// n:1 relation to the client entity.
	@ManyToOne
	@MapsId("basicID.id")
	@JoinColumn(name = "ID")
	private Client client;

	/**
	 * Constructor
	 *
	 * @param basicIDLocalized The localized BasicID of the client entity.
	 * @param name The localized name of the client entity.
	 * @param description The localized description of the client entity.
	 */
	public ClientText(BasicIDLocalized basicIDLocalized, String name, String description) {
		this.basicIDLocalized = basicIDLocalized;
		this.name = name;
		this.description = description;
	}
}