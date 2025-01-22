/**
 * Clase principal que contiene el método main para demostrar el uso de la tabla hash personalizada.
 * Aquí se crean instancias de la clase {@link Persona} y se insertan en una tabla hash de tipo {@link HashTable}.
 */
public class Principal {
    
    /**
     * Método principal que ejecuta el ejemplo de la tabla hash personalizada.
     * Crea varias instancias de {@link Persona}, las inserta en la tabla hash, y muestra los resultados
     * de las operaciones {@code put}, {@code get} y {@code remove}.
     *
     * @param args Argumentos de la línea de comandos (no utilizados en este ejemplo).
     */
    public static void main(String[] args) {
        // Crear una tabla hash personalizada para almacenar personas con sus ocupaciones
        HashTable<Persona, String> tablaHashes = new HashTable<>();

        // Crear instancias de Persona
        Persona p1 = new Persona("Alice", 30);
        Persona p2 = new Persona("Bob", 25);
        Persona p3 = new Persona("Alice", 30); // Igual que p1, para probar las colisiones
        Persona p4 = new Persona("Charlie", 40);

        // Insertar personas en la tabla hash
        tablaHashes.put(p1, "Ingeniera");
        tablaHashes.put(p2, "Diseñador");
        tablaHashes.put(p3, "Doctora"); // Sobrescribe el valor de p1
        tablaHashes.put(p4, "Arquitecto");

        // Mostramos los hashes sacados para cada uno de los elementos almacenados
        System.out.println("Hashes de las personas:");
        System.out.println(p1 + " -> " + p1.hashCode());
        System.out.println(p2 + " -> " + p2.hashCode());
        System.out.println(p3 + " -> " + p3.hashCode());
        System.out.println(p4 + " -> " + p4.hashCode());

        System.out.println();

        // Obtener valores
        System.out.println("Sacamos los valores:");
        System.out.println(p1 + " -> " + tablaHashes.get(p1)); // Doctora
        System.out.println(p2 + " -> " + tablaHashes.get(p2)); // Diseñador
        System.out.println(p4 + " -> " + tablaHashes.get(p4)); // Arquitecto

        System.out.println();

        // Eliminar un valor
        System.out.println("Probamos a quitar un valor y intentar sacarlo de la tabla de elementos HASHEADOS");
        tablaHashes.remove(p2);
        System.out.println(p2 + " -> " + tablaHashes.get(p2)); // null

        // Mostrar toda la tabla hash
        System.out.println("\nContenido completo de la tabla hash:");
        tablaHashes.printTable();
    }
}
