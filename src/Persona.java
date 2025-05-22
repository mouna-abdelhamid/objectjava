public class Persona {
    private String nombre;
    private int edad;
    private String correo;

    public Persona(String nombre, int edad, String correo) {
        this.nombre = nombre;
        this.edad = edad;
        setCorreo(correo); // Usamos el setter para validar
    }
    public Persona() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if (correo.contains("@")) {
            this.correo = correo;
        } else {
            this.correo = "Correo inválido";
        }
    }

    // Método para mostrar si es mayor de edad
    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    // Método toString
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad + ", Correo: " + correo +
                ", Mayor de edad: " + (esMayorDeEdad() ? "Sí" : "No");
    }

    public void calling(){
        Persona p1 = new Persona("Mouna", 25, "mouna@email.com");
        Persona p2 = new Persona("Aya", 15, "ayamail.com"); // Correo inválido
        Persona p3 = new Persona("Iyad", 30, "iyad@correo.org");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        p2.setEdad(18);
        p2.setCorreo("aya@nuevo.com");
        p1.setNombre("Mouna abdelhamid");

        System.out.println("\nDespués de actualizar:");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}
