import java.util.Objects;

/**
 * Representa a una persona con nombre y edad.
 * La clase {@link Persona} sobrescribe los métodos {@link Object#equals(Object)} y 
 * {@link Object#hashCode()} para garantizar que las personas con el mismo nombre y edad sean consideradas iguales.
 */
public class Persona {
    private String nombre;
    private int edad;

    /**
     * Constructor para crear una nueva persona.
     *
     * @param nombre Nombre de la persona.
     * @param edad Edad de la persona.
     */
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    /**
     * Compara dos objetos {@link Persona} para verificar si son iguales.
     * Dos personas son iguales si tienen el mismo nombre y la misma edad.
     *
     * @param o Objeto con el que se va a comparar.
     * @return {@code true} si las personas son iguales, {@code false} de lo contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false; // Si las clases no son iguales, devuelve false
        Persona persona = (Persona) o;
        return edad == persona.edad && Objects.equals(nombre, persona.nombre);
    }

    /**
     * Calcula el código hash de la persona basado en su nombre y edad.
     * Este método es utilizado por la tabla hash para indexar las personas.
     *
     * @return El código hash de la persona.
     */
    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad); // Genera un código hash basado en nombre y edad
    }

    /**
     * Representa la persona como una cadena de texto.
     *
     * @return Una cadena que describe a la persona.
     */
    @Override
    public String toString() {
        return "Persona{" + "nombre='" + nombre + '\'' + ", edad=" + edad + '}';
    }
}
