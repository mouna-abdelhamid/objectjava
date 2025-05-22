import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private String nombre;
    private List<Double> notas;

    public Alumno() { }
    public Alumno(String nombre) {
        this.nombre = nombre;
        this.notas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarNota(double nota) {
        if (nota >= 0 && nota <= 10) {
            notas.add(nota);
        } else {
            System.out.println("Nota inválida: " + nota);
        }
    }

    public double calcularPromedio() {
        if (notas.isEmpty()) return 0;
        double suma = 0;
        for (double n : notas) {
            suma += n;
        }
        return suma / notas.size();
    }

    public boolean aprueba() {
        return calcularPromedio() >= 5;
    }

    @Override
    public String toString() {
        return "Alumno: " + nombre + ", Promedio: " + String.format("%.2f", calcularPromedio()) +
                ", Estado: " + (aprueba() ? "Aprobado" : "Reprobado");
    }

    // Método para probar
    public  void calling() {
        List<Alumno> listaAlumnos = new ArrayList<>();

        Alumno a1 = new Alumno("Mouna");
        a1.agregarNota(6);
        a1.agregarNota(8);
        a1.agregarNota(7);

        Alumno a2 = new Alumno("Ali");
        a2.agregarNota(4);
        a2.agregarNota(5);
        a2.agregarNota(3);

        Alumno a3 = new Alumno("Sara");
        a3.agregarNota(9);
        a3.agregarNota(10);
        a3.agregarNota(8);

        listaAlumnos.add(a1);
        listaAlumnos.add(a2);
        listaAlumnos.add(a3);

        System.out.println("Lista de alumnos y sus promedios:");
        for (Alumno a : listaAlumnos) {
            System.out.println(a);
        }

        Alumno mejor = null;
        double mejorPromedio = 0;
        for (Alumno a : listaAlumnos) {
            double promedio = a.calcularPromedio();
            if (promedio > mejorPromedio) {
                mejorPromedio = promedio;
                mejor = a;
            }
        }

        System.out.println("\nMejor alumno:");
        if (mejor != null) {
            System.out.println(mejor);
        }
    }
}
