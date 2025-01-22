# Trabajo sobre Técnicas de Programación Segura: Funciones Hash
# Estructuras de datos basadas en hashes

## Estructura y explicación:

### 1. Estructura del proyecto
```
Proyecto/
├── Principal.java # Clase principal que ejecuta el programa
├── Persona.java   # Clase que representa una persona con métodos hashCode y equals
├── HashTable.java # Clase que implementa la tabla hash personalizada
├── TablaHash.jar  # Archivo JAR generado (ejecutable)
├── MANIFEST.MF    # Archivo que especifica la clase principal del JAR
└── README.MD      # Este mismo archivo
```

---

### 2. Explicación del proyecto
Este mini-proyecto implementa una tabla hash personalizada en Java como una demostración práctica de técnicas de programación segura. Algunos puntos a destacar de diseño e implementación:

1. **Diseño de la clase `HashTable`:**
   - Utiliza buckets (listas enlazadas) para manejar colisiones de manera eficiente.
   - El índice para cada clave se calcula con:
     ```java
     int index = Math.abs(key.hashCode()) % capacity;
     ```
     Esto garantiza que el índice esté en el rango del array y sea no negativo.

<br>

2. **Manejo de colisiones:**
   - Los pares clave-valor que generan el mismo índice se almacenan en la lista enlazada del bucket correspondiente.
   - Se recorre la lista enlazada solo cuando hay colisiones, minimizando la sobrecarga.

<br>

3. **Generalización (`HashTable<K, V>`):**
   - Permite usar cualquier tipo de datos como claves y valores, siempre que las claves sobrescriban los métodos `equals` y `hashCode`.

<br>

4. **Métodos críticos de `Persona`:**
   - `hashCode` combina los atributos `nombre` y `edad` para generar un código hash único.
   - `equals` compara estos atributos para determinar si dos objetos `Persona` son equivalentes.

<br>

5. **Optimización de seguridad:**
   - Validación de entradas nulas en las operaciones de la tabla hash para evitar excepciones inesperadas.
   - Uso de estructuras de datos estándar de Java que ya están probadas y optimizadas.

<br>

6. **Demostración en `Principal`:**
   - Muestra cómo trabajar con la tabla hash: insertar, recuperar, y eliminar elementos, manejando colisiones sin problemas.

---

### 3. Dependencias y bibliotecas usadas

#### · Bibliotecas usadas
| Nombre | Descripción | Fuente |
| --------------- | --------------- | --------------- |
| `java.util.LinkedList` | Implementa los buckets como listas enlazadas para manejar colisiones | Biblioteca estándar de Java (`java.util`) |
| `java.util.Objects` | Ayuda en la implementación de `equals` y `hashCode` para la clase de prueba `Persona` | Biblioteca estándar de Java ( `java.util` ) |

#### · Dependencias usadas
Ninguna: Este proyecto no utiliza bibliotecas o frameworks externos. Todo el código está basado en características integradas de Java.


### 4. Instrucciones para compilar y ejecutar el proyecto

#### **Paso 1: Compilar las clases**
Asegúrate de tener todos los archivos `.java` en el mismo directorio. Compila los archivos con el siguiente comando:

```bash
javac Principal.java Persona.java HashTable.java
```

Esto genera los archivos `.class` en el directorio actual.

#### **Paso 2: Crear el archivo JAR**

Crea un archivo MANIFEST.MF con el siguiente contenido, asegurándote de incluir un salto de línea al final:

```manifest
Main-Class: Principal
```

Luego, empaqueta los archivos .class en un archivo JAR con este comando:

```bash
jar cfm TablaHash.jar MANIFEST.MF *.class
```

#### **Paso 3: Verificar el contenido del JAR**

Para asegurarte de que el archivo JAR incluye las clases correctas y el manifiesto, utiliza:

```bash
jar tf TablaHash.jar
```

Deberías ver algo similar a:

```ls
META-INF/
META-INF/MANIFEST.MF
Principal.class
Persona.class
HashTable.class
HashTable$Entry.class
```

#### **Paso 4: Ejecutar el JAR**

Ejecuta el archivo JAR con este comando:

```bash
java -jar TablaHash.jar
```

Si todo está configurado correctamente, el programa mostrará la salida esperada.
> [!NOTE]
> Asegúrate de usar la misma versión de Java para compilar y ejecutar el programa.
> Si cambias el nombre de la clase principal, actualiza el archivo MANIFEST.MF para reflejar el nuevo nombre.
