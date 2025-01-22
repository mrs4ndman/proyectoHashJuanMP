import java.util.LinkedList;

/**
 * Implementación personalizada de una tabla hash que usa encadenamiento para manejar colisiones.
 * La tabla hash almacena pares clave-valor en un array de {@link LinkedList} (buckets).
 *
 * @param <K> Tipo de las claves.
 * @param <V> Tipo de los valores.
 */
public class HashTable<K, V> {
    
    /**
     * Clase interna que representa un par clave-valor almacenado en la tabla hash.
     *
     * @param <K> Tipo de la clave.
     * @param <V> Tipo del valor.
     */
    private static class Entry<K, V> {
        K key;
        V value;

        /**
         * Constructor de la clase Entry.
         *
         * @param key Clave asociada al valor.
         * @param value Valor asociado a la clave.
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Representación de la entrada como una cadena de texto.
         *
         * @return Una cadena que representa el par clave-valor.
         */
        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

    private static final int INITIAL_CAPACITY = 10; // Tamaño inicial de la tabla
    private LinkedList<Entry<K, V>>[] buckets; // Array de listas enlazadas para los buckets

    /**
     * Constructor que inicializa la tabla hash con una capacidad predeterminada.
     */
    @SuppressWarnings("unchecked")
    public HashTable() {
        buckets = new LinkedList[INITIAL_CAPACITY];
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    /**
     * Calcula el índice de un bucket en función del código hash de la clave.
     *
     * @param key Clave cuya posición queremos calcular.
     * @return El índice del bucket donde se almacenará la clave.
     */
    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode() % buckets.length); // Cálculo del índice con módulo
    }

    /**
     * Inserta un par clave-valor en la tabla hash.
     * Si la clave ya existe, se actualiza el valor.
     *
     * @param key   Clave que se va a insertar.
     * @param value Valor asociado a la clave.
     */
    public void put(K key, V value) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        // Buscar si ya existe la clave en el bucket
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value; // Actualizar el valor si la clave ya existe
                return;
            }
        }

        // Si no existe, agregar un nuevo par clave-valor
        bucket.add(new Entry<>(key, value));
    }

    /**
     * Obtiene el valor asociado a una clave en la tabla hash.
     *
     * @param key Clave cuyo valor queremos obtener.
     * @return El valor asociado a la clave, o {@code null} si la clave no existe.
     */
    public V get(K key) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value; // Retorna el valor si se encuentra la clave
            }
        }
        return null; // Si la clave no se encuentra
    }

    /**
     * Elimina un par clave-valor de la tabla hash.
     *
     * @param key Clave del elemento que se quiere eliminar.
     */
    public void remove(K key) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        bucket.removeIf(entry -> entry.key.equals(key)); // Elimina la entrada si la clave coincide
    }

    /**
     * Imprime el contenido completo de la tabla hash.
     */
    public void printTable() {
        for (LinkedList<Entry<K, V>> bucket : buckets) {
            for (Entry<K, V> entry : bucket) {
                System.out.println(entry); // Imprime cada entrada en cada bucket
            }
        }
    }
}
