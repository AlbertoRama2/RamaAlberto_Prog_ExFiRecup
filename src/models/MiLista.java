package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import exception.ElementNotAllowedException;
import exception.ListSizeOverflownException;

@SuppressWarnings("serial")
public class MiLista<E> extends ArrayList<E> {

	// Dlecaracion de constantes y variables
	private final byte MAX_SIZE = 100;
	private Comparator<E> comp;

	@SuppressWarnings("unchecked")
	public MiLista(Comparator<Pokemon> comp) {
		super();
		this.comp = (Comparator<E>) comp;
	}

	// Sobreescribimos los metodos necesarios para nuestro comportamiento
	/**
	 * A�adimos un elemento y ordenamos despues.
	 */
	@Override
	public boolean add(E element) {
		if (element != null) {
			if (this.size() < MAX_SIZE) {
				super.add(element);
				Collections.sort(this, comp);
				return true;
			} else {
				throw new ListSizeOverflownException("No capo");
			}
		} else {
			throw new ElementNotAllowedException("No acepto nulls");
		}
	}

	/**
	 * A�adimos una coleccion y ordenamos.
	 */
	@Override
	public boolean addAll(Collection<? extends E> collection) throws ListSizeOverflownException {

		if (collection.size() + this.size() < MAX_SIZE) {
			super.addAll(collection);
			Collections.sort(this, comp);
			return true;
		} else {
			throw new ListSizeOverflownException("No cabemos tantos");
		}
	}

	/**
	 * A�ade un objeto en un indice concreto y ordena la lista despues
	 */
	@Override
	public void add(int index, E element) {
		if (element != null) {
			if (this.size() != MAX_SIZE) {
				if (index < MAX_SIZE) {
					super.add(index, element);
					Collections.sort(this, comp);
				} else {
					throw new ListSizeOverflownException("No caben tantos indices en la cola");
				}
			} else {
				throw new ListSizeOverflownException("No capo en la cola");
			}
		} else {
			throw new ElementNotAllowedException("No acepto nulls");
		}
	}

	/**
	 * A�ade una coleccion a partir de un indice concreto y ordena despues
	 */
	@Override
	public boolean addAll(int index, Collection<? extends E> c) throws ListSizeOverflownException {
		if (index < MAX_SIZE) {
			if (c.size() + index < MAX_SIZE) {
				super.addAll(index, c);
				Collections.sort(this, comp);
				return true;
			} else {
				throw new ListSizeOverflownException("No capemos");
			}
		} else {
			throw new ListSizeOverflownException("No capemos");
		}
	}


	/**
	 * Metodo para averiguar el elemento mas alto de la lista
	 * 
	 * @return el elemento de maximo valor de la lista
	 */
	public E max() {
		return this.get(0);
	}

	/**
	 * Metodo para averiguar el elemento mas bajo de la lista
	 * 
	 * @return el elemento de menos valor de la lista
	 */
	public E min() {
		return this.get(this.size() - 1);
	}
}
