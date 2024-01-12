// Interfaz ArticuloDAO.java
package RNG.modelo;

import java.util.List;

public interface ArticuloDAO {
    void agregarArticulo(Articulo articulo);
    void eliminarArticulo(String codigoArticulo);
    Articulo buscarArticuloPorCodigo(String codigoArticulo);
    List<Articulo> obtenerTodosLosArticulos();

    // Nuevo método para establecer la sesión
    void setSession(org.hibernate.Session session);
}