public class Main {
    public static void main(String[] args) {
        Persona persona= new Persona();
        persona.calling();
        Tarea tarea = new Tarea();
        tarea.calling();
        CuentaBancaria cuenta = new CuentaBancaria("Mouna Abdelhamid", 1000);
        cuenta.calling();
        Agenda agenda = new Agenda();
        agenda.calling();
        Alumno alumno = new Alumno();
        alumno.calling();
    }
}

