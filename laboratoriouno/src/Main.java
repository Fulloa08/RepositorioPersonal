import java.util.Scanner;

public class Main {
    private static final int MAX_PISTOLAS = 100;
    private static String[][] pistolas = new String[MAX_PISTOLAS][2]; // [ID, NombreSoldado]
    private static int totalPistolas = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
        
    }

    /**
     * Ejecuta el menú principal del programa y gestiona la interacción con el usuario.
     */
    public static void menu() {
        int opcion;
        do {
            mostrarOpciones();
            opcion = obtenerOpcion(scanner);
            ejecutarOpcion(opcion);
        } while (opcion != 0);

        // TODO: Implementar el código para gestionar la interacción con el usuario.
    }

    /**
     * Muestra el menú principal con las opciones disponibles.
     */
    private static void mostrarOpciones() {
        System.out.println("\n--- Menú de gestion de pistolas del Imperio. ---");
        System.out.println("1. Agregar pistola");
        System.out.println("2. Eliminar pistola");
        System.out.println("3. Listar pistolas");
        System.out.println("0. Salir");
        System.out.println("Seleccione una opción: ");
        // TODO: Implementar el código para mostrar las opciones del menú en pantalla.
    }

    /**
     * Obtiene y valida la opción ingresada por el usuario.
     * @return La opción seleccionada.
     */
    private static int obtenerOpcion(Scanner scanner) {
        String opcion = scanner.nextLine();
        if (opcion.matches("\\d")){
            return Integer.parseInt(opcion);
        }
        return -1;

        // TODO: Implementar la lectura y validación de la opción ingresada.
    }

    /**
     * Ejecuta la acción correspondiente según la opción seleccionada.
     * @param opcion Opción ingresada por el usuario.
     */
    private static void ejecutarOpcion( int opcion) {
        if (opcion == 1) {
            agregarPistola(pistolas);
        }
        if(opcion == 2) {
            eliminarPistola();
        }
        if(opcion == 3){
            listarPistolas(pistolas);
        }
        if(opcion == 0){
            System.out.println("Saliendo del programa...");

        }

    }
        // TODO: Implementar la lógica para ejecutar la opción seleccionada.

    /**
     * Agrega una nueva pistola al inventario, registrando su ID y el nombre del soldado.
     */
    private static void agregarPistola(String[][] pistolas) {
        if (totalPistolas >= MAX_PISTOLAS) {
            System.out.println("El inventario está lleno.");
            return;
        }

        System.out.print("Ingrese el ID de la pistola: ");
        String id = scanner.nextLine();

        System.out.print("Ingrese el nombre del soldado: ");
        String nombre = scanner.nextLine();

        pistolas[totalPistolas][0] = id;
        pistolas[totalPistolas][1] = nombre;
        totalPistolas++;

        System.out.println("Pistola agregada correctamente.");
    }





        // TODO: Implementar la lógica para agregar una pistola al inventario.

    /**
     * Elimina una pistola del inventario según su ID.
     */
    private static void eliminarPistola() {
        System.out.println("Ingrese el ID de la pistola a eliminar: ");
        String idEliminar = scanner.nextLine();

        for (int i = 0; i < totalPistolas; i++) {
            if(pistolas[i][0].equals(idEliminar)){
                reordenarInventario(i);
                totalPistolas--;
                System.out.println("Pistola eliminada correctamente.");
                return;
            }

        }
        System.out.println("Pistola no encontrada.");
    }

        // TODO: Implementar la lógica para eliminar una pistola del inventario.


    /**
     * Reorganiza el inventario después de eliminar una pistola, evitando espacios vacíos.
     * @param indice Índice de la pistola eliminada.
     */
    private static void reordenarInventario(int indice) {
        for (int i = indice; i <totalPistolas - 1; i++){
            pistolas[i][0] = pistolas[i + 1][0];
            pistolas[i][1] = pistolas[i + 1][1];
        }
        pistolas[totalPistolas - 1][0] = null;
        pistolas[totalPistolas - 1][1] = null;

        // TODO: Implementar la lógica para reorganizar el inventario después de una eliminación.
    }

    /**
     * Muestra en pantalla todas las pistolas registradas en el inventario.
     */
    private static void listarPistolas(String[][] pistolas) {
        if (totalPistolas == 0 ){
            System.out.println("No hay pistolas registradas.");
            return;
        }

        System.out.println("\nListado de pistolas registradas:");
        for (int i = 0; i < totalPistolas; i++){
            System.out.println((i+1) + ". ID: " + pistolas[i][0] + " - soldado: " + pistolas[i][1]);
        }
        // TODO: Implementar la lógica para listar todas las pistolas registradas.
    }
}