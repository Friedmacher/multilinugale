package com.mf;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class BasicID implements Serializable {
	private UUID id;

	/**
	 * Constructor
	 *
	 * @param id The UUID, which is used to create a BasicID.
	 */
	public BasicID(UUID id) {
		this.id = id;
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
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		BasicID entity = (BasicID) o;
		return Objects.equals(this.id, entity.id);
	}

	/**
	 * Generate a hash code for this object.
	 *
	 * @return The hash code of the object.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
