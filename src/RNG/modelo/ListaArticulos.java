package RNG.modelo;

import java.util.ArrayList;

public class ListaArticulos extends Lista<Articulo> {

    public Articulo buscarPorCodigo(String codigoArticulo) {
        for (Articulo articulo : lista) {
            if (articulo.getCodigoArticulo().equals(codigoArticulo)) {
                return articulo;
            }
        }
        return null; // Devuelve null si no se encuentra el artículo con el código proporcionado
    }

    public void eliminar(String codigoArticulo) {
        Articulo articulo = buscarPorCodigo(codigoArticulo);
        if (articulo != null) {
            lista.remove(articulo);
        }
        // No hace nada si no se encuentra el artículo con el código proporcionado
    }
}
