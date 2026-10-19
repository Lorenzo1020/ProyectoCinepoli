package Implementacion;

import java.util.ArrayList;
import java.util.List;

import Interface.PeliculasMetodos;
import Modelo.Peliculas;

public class PeliculasImp implements PeliculasMetodos {

	private List<Peliculas> lista = new ArrayList<>();

	// Validar que el nombre no se repita
	@Override
	public void guardar(Peliculas pelicula) {
		// TODO Auto-generated method stub
		boolean bandera = false;

		for (Peliculas p : lista) {
			if (p.getNombre().equalsIgnoreCase(pelicula.getNombre())) {
				bandera = true;
				System.out.println("Ya existe esa pelicula");
				break;
			}
		}

		if (!bandera) {
			lista.add(pelicula);
			System.out.println("Se guardo correctamente");
		}
	}

	@Override
	public List<Peliculas> mostrar() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Peliculas buscar(String nombre) {
		// TODO Auto-generated method stub

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getNombre().equalsIgnoreCase(nombre)) {
				return lista.get(i);
			}
		}
		return null;
	}

	@Override
	public void eliminar(String nombre) {
		// TODO Auto-generated method stub
		
		Peliculas peliEnco = buscar(nombre);

		if (peliEnco != null) {
			lista.remove(peliEnco);
			System.out.println("Se elimino con exito");
		} else
			System.out.println("No existe esa pelicula para eliminar");
	}

}
