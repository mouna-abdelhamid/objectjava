import java.util.*;
class Pregunta {
    private String texto;
    private List<String> opciones;
    private Map<Integer, Integer> votos;
    public Pregunta(String texto, List<String> opciones) {
        this.texto = texto;
        this.opciones = opciones;
        this.votos = new HashMap<>();
        for (int i = 0; i < opciones.size(); i++) {
            votos.put(i, 0);
        }
    }
    public String getTexto() {
        return texto;
    }

    public List<String> getOpciones() {
        return opciones;
    }

    public void votar(int indiceOpcion) {
        votos.put(indiceOpcion, votos.get(indiceOpcion) + 1);
    }

    public void mostrarEstadisticas() {
        System.out.println("Pregunta: " + texto);
        for (int i = 0; i < opciones.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + opciones.get(i) + ": " + votos.get(i) + " votos");
        }
    }

    public String opcionMasVotada() {
        int maxVotos = -1;
        int indiceMax = -1;
        for (int i = 0; i < opciones.size(); i++) {
            if (votos.get(i) > maxVotos) {
                maxVotos = votos.get(i);
                indiceMax = i;
            }
        }
        if (indiceMax >= 0) {
            return opciones.get(indiceMax) + " (" + maxVotos + " votos)";
        } else {
            return "No hay votos";
        }
    }
}

class Encuesta {
    private List<Pregunta> preguntas;
    private Map<String, Map<Integer, Integer>> respuestasUsuarios; // usuario -> pregunta -> opción

    public Encuesta() {
        preguntas = new ArrayList<>();
        respuestasUsuarios = new HashMap<>();
    }

    public void agregarPregunta(Pregunta p) {
        preguntas.add(p);
    }

    // Método para hacer responder a un usuario, usando Scanner
    public void responderEncuesta(String usuario, Scanner sc) {
        if (respuestasUsuarios.containsKey(usuario)) {
            System.out.println("Este usuario ya ha respondido la encuesta.");
            return;
        }

        Map<Integer, Integer> respuestasUsuario = new HashMap<>();
        System.out.println("Respondiendo encuesta para usuario: " + usuario);

        for (int i = 0; i < preguntas.size(); i++) {
            Pregunta p = preguntas.get(i);
            System.out.println("\n" + (i + 1) + ". " + p.getTexto());
            List<String> ops = p.getOpciones();
            for (int j = 0; j < ops.size(); j++) {
                System.out.println("  " + (j + 1) + ") " + ops.get(j));
            }

            int opcion = -1;
            do {
                System.out.print("Selecciona una opción (1-" + ops.size() + "): ");
                if (sc.hasNextInt()) {
                    opcion = sc.nextInt();
                    if (opcion < 1 || opcion > ops.size()) {
                        System.out.println("Opción inválida, intenta de nuevo.");
                        opcion = -1;
                    }
                } else {
                    System.out.println("Entrada inválida, introduce un número.");
                    sc.next(); // consumir la entrada inválida
                }
            } while (opcion == -1);

            opcion--; // para índice base 0
            respuestasUsuario.put(i, opcion);
            preguntas.get(i).votar(opcion);
        }

        respuestasUsuarios.put(usuario, respuestasUsuario);
        System.out.println("Gracias por responder la encuesta, " + usuario + "!");
    }

    public void mostrarResultados() {
        System.out.println("\n--- Resultados de la Encuesta ---");
        for (Pregunta p : preguntas) {
            p.mostrarEstadisticas();
            System.out.println("Opción más votada: " + p.opcionMasVotada());
            System.out.println();
        }
    }

    // Método para exportar resumen (por simplicidad, solo imprimir)
    public void exportarResumen() {
        System.out.println("--- Resumen de respuestas por usuario ---");
        for (String usuario : respuestasUsuarios.keySet()) {
            System.out.println("Usuario: " + usuario);
            Map<Integer, Integer> respuestas = respuestasUsuarios.get(usuario);
            for (Map.Entry<Integer, Integer> entry : respuestas.entrySet()) {
                int preguntaIdx = entry.getKey();
                int opcionIdx = entry.getValue();
                Pregunta p = preguntas.get(preguntaIdx);
                System.out.println("  " + p.getTexto() + " -> " + p.getOpciones().get(opcionIdx));
            }
            System.out.println();
        }
    }
}

class GestorEncuestasApp {
    private static Map<String, String> usuarios = new HashMap<>(); // username -> password

    // Método simple para login
    public static boolean login(Scanner sc) {
        System.out.print("Usuario: ");
        String user = sc.nextLine();
        System.out.print("Contraseña: ");
        String pass = sc.nextLine();

        if (usuarios.containsKey(user) && usuarios.get(user).equals(pass)) {
            System.out.println("Login exitoso!");
            return true;
        } else {
            System.out.println("Usuario o contraseña incorrectos.");
            return false;
        }
    }

    // Registro simple de usuarios
    public static void registrarUsuario(Scanner sc) {
        System.out.print("Elige un nombre de usuario: ");
        String user = sc.nextLine();
        if (usuarios.containsKey(user)) {
            System.out.println("Usuario ya existe.");
            return;
        }
        System.out.print("Elige una contraseña: ");
        String pass = sc.nextLine();
        usuarios.put(user, pass);
        System.out.println("Usuario registrado exitosamente.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Encuesta encuesta = new Encuesta();

        // Crear preguntas y opciones
        encuesta.agregarPregunta(new Pregunta("¿Cuál es tu color favorito?",
                Arrays.asList("Rojo", "blanco", "negro", "azul")));

        encuesta.agregarPregunta(new Pregunta("¿Qué comida prefieres?",
                Arrays.asList("Pizza", "paella", "Ensalada", "Pasta")));

        System.out.println("Bienvenido al sistema de Encuestas.");

        while (true) {
            System.out.println("\n1. Registrar usuario");
            System.out.println("2. Iniciar sesión y responder encuesta");
            System.out.println("3. Mostrar resultados");
            System.out.println("4. Exportar resumen");
            System.out.println("5. Salir");
            System.out.print("Selecciona opción: ");
            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    registrarUsuario(sc);
                    break;
                case "2":
                    if (login(sc)) {
                        System.out.print("Introduce tu nombre de usuario para responder encuesta: ");
                        String usuario = sc.nextLine();
                        encuesta.responderEncuesta(usuario, sc);
                    }
                    break;
                case "3":
                    encuesta.mostrarResultados();
                    break;
                case "4":
                    encuesta.exportarResumen();
                    break;
                case "5":
                    System.out.println("Gracias por usar el sistema. ¡Adiós!");
                    sc.close();
                    return;
                default:
                    System.out.println("Opción inválida, intenta de nuevo.");
            }
        }
    }
}
