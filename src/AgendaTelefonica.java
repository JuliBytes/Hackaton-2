import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AgendaTelefonica {

    public static void main(String[] args) {
        Map<String, String> agenda = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("   -----------------------------   ");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Mostrar todos los contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Salir");
            System.out.print("Ingrese la opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Esto es para que nos deje ingresar el nombre

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del contacto: ");
                    String nombre = scanner.nextLine();

                    if (existeContacto(agenda, nombre)) {
                        System.out.println("Ya existe un contacto con ese nombre. Intente nuevamente.");
                    } else if (agendaLlena(agenda)) {
                        System.out.println("Agenda llena, elimina un contacto e intanta nuevamente.");
                    } else {
                        System.out.print("Ingrese el número de teléfono: ");
                        String telefono = scanner.nextLine();
                        agregarContacto(agenda, nombre, telefono);
                        espaciosLibres(agenda);
                    }
                    break;

                case 2:
                    listarContactos(agenda);
                    espaciosLibres(agenda);
                    break;

                case 3:
                    System.out.print("Ingrese el nombre del contacto a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    buscarContacto(agenda, nombreBuscar);
                    break;

                case 4:
                    System.out.print("Ingrese el nombre del contacto a eliminar: ");
                    String nombreBorrar = scanner.nextLine();
                    eliminarContacto(agenda, nombreBorrar);
                    espaciosLibres(agenda);
                    break;

                case 5:
                    System.out.println("Saliendo de la agenda telefónica. ¡Hasta luego!");
                    System.exit(0);

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    private static void agregarContacto(Map<String, String> agenda, String nombre, String telefono) {
        agenda.put(nombre, telefono);
        System.out.println("Contacto agregado correctamente.");
    }
    private static boolean existeContacto(Map<String, String> agenda, String nombre) {
        return agenda.containsKey(nombre);
    }
    private static void listarContactos(Map<String, String> agenda) {
        if (agenda.isEmpty()) {
            System.out.println("La agenda está vacía.");
        } else {
            System.out.println("Lista de contactos:");
            int numeroLista = 1;
            for (Map.Entry<String, String> entry : agenda.entrySet()) {
                System.out.println(numeroLista + ". " + entry.getKey() + ": " + entry.getValue());
                numeroLista++;
            }
        }
    }
    private static void buscarContacto(Map<String, String> agenda, String nombre) {
        if (agenda.containsKey(nombre)) {
            System.out.println("Número de teléfono de " + nombre + ": " + agenda.get(nombre));
        } else {
            System.out.println("El contacto no se encuentra en la agenda.");
        }
    }
    private static void eliminarContacto(Map<String, String> agenda, String nombre){
        if (agenda.containsKey(nombre)) {
            agenda.remove(nombre);
            System.out.println("El contacto se eliminó de manera satisfactoria.");
        } else {
            System.out.println("No se encontró el contacto en la agenda, intente nuevamente.");
        }
    }
    private static boolean agendaLlena(Map<String, String> agenda){
        return agenda.size() == 10;
    }
    private static void espaciosLibres(Map<String, String> agenda){
        int espaciosAgenda = 10-agenda.size();
        if (espaciosAgenda==10){
            System.out.println("Agenda llena.");
        } else {
            System.out.println("La agenda tiene " + espaciosAgenda + " espacios disponibles.");
        }
    }
}