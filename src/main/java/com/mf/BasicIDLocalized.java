package com.mf;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class BasicIDLocalized implements Serializable {
	private UUID id;
	private Locale locale;

	/**
	 * Constructor
	 *
	 * @param id The UUID, which is used to create a BasicID.
	 * @param locale The Locale, which is used to identify the localization.
	 */
	public BasicIDLocalized(UUID id, Locale locale) {
		this.id = id;
		this.locale = locale;
	}

	/**
	 * Methode to check if an object is equal to this one.
	 *
	 * @param o The object to be checked.
	 * @return True if the objects are identical.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BasicIDLocalized that = (BasicIDLocalized) o;
		return Objects.equals(id, that.id) && Objects.equals(locale, that.locale);
	}

	/**
	 * Generate a hash code for this object.
	 *
	 * @return The hash code of the object.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id, locale);
	}
}
