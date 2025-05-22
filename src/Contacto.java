import java.util.ArrayList;
import java.util.List;

public class Contacto {
    private String nombre;
    private String telefono;
    private String email;

    public Contacto(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Teléfono: " + telefono + ", Email: " + email;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Contacto)) return false;
        Contacto otro = (Contacto) obj;
        return nombre.equalsIgnoreCase(otro.nombre) &&
                telefono.equals(otro.telefono) &&
                email.equalsIgnoreCase(otro.email);
    }

    @Override
    public int hashCode() {
        return nombre.toLowerCase().hashCode() + telefono.hashCode() + email.toLowerCase().hashCode();
    }
}

class Agenda {
    private List<Contacto> contactos;

    public Agenda() {
        contactos = new ArrayList<>();
    }
    public boolean agregarContacto(Contacto c) {
        if (!contactos.contains(c)) {
            contactos.add(c);
            return true;
        }
        return false;
    }
    public List<Contacto> buscarPorNombre(String texto) {
        List<Contacto> encontrados = new ArrayList<>();
        String textoMinuscula = texto.toLowerCase();
        for (Contacto c : contactos) {
            if (c.getNombre().toLowerCase().contains(textoMinuscula)) {
                encontrados.add(c);
            }
        }
        return encontrados;
    }

    public void mostrarTodos() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.");
            return;
        }
        System.out.println("Contactos en la agenda:");
        for (Contacto c : contactos) {
            System.out.println(c);
        }
    }

    // Método para probar la agenda
    public void calling() {
        Contacto c1 = new Contacto("Mouna Abdelhamid", "123456789", "mouna@email.com");
        Contacto c2 = new Contacto("Ali Ben", "987654321", "ali@email.com");
        Contacto c3 = new Contacto("Sara Lopez", "555123456", "sara@mail.com");
        Contacto c4 = new Contacto("Mouna Abdelhamid", "123456789", "mouna@email.com"); // duplicado

        System.out.println("Agregando contactos:");
        System.out.println(agregarContacto(c1) ? "Agregado: " + c1.getNombre() : "Duplicado: " + c1.getNombre());
        System.out.println(agregarContacto(c2) ? "Agregado: " + c2.getNombre() : "Duplicado: " + c2.getNombre());
        System.out.println(agregarContacto(c3) ? "Agregado: " + c3.getNombre() : "Duplicado: " + c3.getNombre());
        System.out.println(agregarContacto(c4) ? "Agregado: " + c4.getNombre() : "Duplicado: " + c4.getNombre());

        System.out.println("\nMostrar todos:");
        mostrarTodos();

        System.out.println("\nBuscar contactos que contienen 'moun':");
        List<Contacto> encontrados = buscarPorNombre("moun");
        for (Contacto c : encontrados) {
            System.out.println(c);
        }
    }
}
