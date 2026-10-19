package Main;

import java.util.Scanner;

import Implementacion.PeliculasImp;
import Modelo.Peliculas;

public class Principal {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner lectura = null;
		
		System.out.println("Hola mundo agregando cambios");
		System.out.println("Cambios en la nueva rama");

		String nombre;
		String categoria;
		float precio;
		int estreno, menuPrinc;

		Peliculas pelicula = null;

		PeliculasImp imp = new PeliculasImp();

		do {
			System.out.println("BIENVENIDO AL SISTEMA CINEPOLIS");
			System.out.println("1---ALTA");
			System.out.println("2---MOSTRAR");
			System.out.println("3---BUSCAR POR NOMBRE");
			System.out.println("4---EDITAR PRECIO BUSCANDO POR NOMBRE");
			System.out.println("5---ELIMINAR");
			System.out.println("6---BUSCAR POR CATEGORIA");
			System.out.println("7---CALCULAR EL TOTAL DE DINERO INVERTIDO");
			System.out.println("8---SALIR");

			lectura = new Scanner(System.in);
			menuPrinc = lectura.nextInt();

			switch (menuPrinc) {
			case 1:
				try {
					System.out.println("Ingresa el nombre");
					lectura = new Scanner(System.in);
					nombre = lectura.nextLine();

					System.out.println("Ingresa la categoria");
					lectura = new Scanner(System.in);
					categoria = lectura.nextLine();

					System.out.println("Ingresa el precio");
					lectura = new Scanner(System.in);
					precio = lectura.nextFloat();

					System.out.println("Año de estreno");
					lectura = new Scanner(System.in);
					estreno = lectura.nextInt();

					// crear objeto
					pelicula = new Peliculas(nombre, categoria, precio, estreno);

					// agregar a la lista
					imp.guardar(pelicula);

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error al guardar");
				}
				break;
			case 2:
				if (imp.mostrar().size() > 0)
					System.out.println(imp.mostrar());
				else
					System.out.println("No hay registros");
				break;
			case 3:
				if (imp.mostrar().size() > 0) {

					System.out.println("Ingrese el nombre a buscar");
					lectura = new Scanner(System.in);
					nombre = lectura.nextLine();

					// buscar
					pelicula = imp.buscar(nombre);

					if (pelicula != null)
						System.out.println(pelicula);
					else
						System.out.println("No existe esa pelicula");

				} else
					System.out.println("No hay registros");
				break;
			case 4:
				if (imp.mostrar().size() > 0) {

					System.out.println("Ingrese el nombre a buscar");
					lectura = new Scanner(System.in);
					nombre = lectura.nextLine();

					// buscar
					pelicula = imp.buscar(nombre);

					if (pelicula != null) {
						System.out
								.println("Se encontro la pelicula " + pelicula.getNombre() + " para editar el precio");

						System.out.println("Ingrese el nuevo precio");
						lectura = new Scanner(System.in);
						precio = lectura.nextFloat();

						// actualizacion
						pelicula.setPrecio(precio);
						System.out.println("Se edito");
					} else
						System.out.println("No existe esa pelicula");

				} else
					System.out.println("No hay registros");
				break;
			case 5:
				if (imp.mostrar().size() > 0) {
					System.out.println("Ingresa el nombre del registro a eliminar");
					lectura = new Scanner(System.in);
					nombre = lectura.nextLine();

					// aliminar
					imp.eliminar(nombre);
				}else
					System.out.println("No ahy registros para eliminar");
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			}

		} while (menuPrinc < 8);

	}

}