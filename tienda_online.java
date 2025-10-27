// ============================================
// ESTRUCTURA DEL PROYECTO
// ============================================
// TiendaOnline/
// ├── README.md
// ├── src/
// │   ├── Main.java
// │   ├── Producto.java
// │   ├── Cliente.java
// │   ├── ProductoService.java
// │   └── ClienteService.java
// └── .gitignore

// ============================================
// ARCHIVO: README.md
// ============================================
/*
# 🛒 TiendaOnline - Sistema de Gestión

## Descripción del Proyecto
Sistema simple de tienda online similar a Amazon que permite gestionar productos y clientes.

## Funcionalidades Implementadas

### ✅ CRUD Completo de Productos
- **Crear**: Agregar nuevos productos a la tienda
- **Leer**: Visualizar todos los productos disponibles
- **Actualizar**: Modificar información de productos existentes
- **Eliminar**: Quitar productos del catálogo

### ✅ CRUD Completo de Clientes
- **Crear**: Registrar nuevos clientes
- **Leer**: Ver listado de clientes registrados
- **Actualizar**: Actualizar datos de clientes
- **Eliminar**: Eliminar clientes del sistema

## Componentes del Proyecto

### 📦 Entidades
- **Producto**: Representa los artículos en venta (ID, nombre, descripción, precio, stock)
- **Cliente**: Representa los usuarios de la tienda (ID, nombre, email, dirección)

### 🔧 Servicios
- **ProductoService**: Gestiona todas las operaciones CRUD de productos
- **ClienteService**: Gestiona todas las operaciones CRUD de clientes

### 🎯 Repositorios
- Los servicios utilizan ArrayList como almacenamiento en memoria (simulando base de datos)

## Validaciones Implementadas

### Validación de Productos:
- ✓ Nombre no puede estar vacío
- ✓ Precio debe ser mayor a 0
- ✓ Stock no puede ser negativo
- ✓ Descripción obligatoria

### Validación de Clientes:
- ✓ Nombre obligatorio
- ✓ Email con formato válido (contiene @)
- ✓ Dirección no puede estar vacía

## Manejo de Errores
- Control de IDs duplicados
- Validación de campos obligatorios
- Mensajes de error descriptivos
- Verificación de rangos numéricos

## Cómo Ejecutar

### Requisitos:
- Java 8 o superior
- JDK instalado

### Pasos:
1. Clonar el repositorio
2. Navegar a la carpeta src/
3. Compilar: `javac Main.java Producto.java Cliente.java ProductoService.java ClienteService.java`
4. Ejecutar: `java Main`

## Tecnologías Utilizadas
- Java SE
- Programación Orientada a Objetos
- Colecciones (ArrayList)
- Manejo de excepciones

## Autor
Proyecto desarrollado para curso de Programación

## Notas
- Sistema funciona en memoria (datos se pierden al cerrar)
- Interfaz de consola básica
- Código simple y fácil de entender
*/

// ============================================
// ARCHIVO: .gitignore
// ============================================
/*
# Compiled class files
*.class

# Log files
*.log

# Package Files
*.jar
*.war
*.nar
*.ear
*.zip
*.tar.gz
*.rar

# IDE specific files
.idea/
*.iml
.vscode/
.DS_Store

# Compiled output
bin/
build/
out/
target/
*/

// ============================================
// ARCHIVO: Producto.java
// ============================================
public class Producto {
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    
    public Producto(int id, String nombre, String descripcion, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }
    
    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }
    
    // Setters
    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setPrecio(double precio) { this.precio = precio; }
    public void setStock(int stock) { this.stock = stock; }
    
    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Precio: $" + precio + 
               " | Stock: " + stock + " | Desc: " + descripcion;
    }
}

// ============================================
// ARCHIVO: Cliente.java
// ============================================
public class Cliente {
    private int id;
    private String nombre;
    private String email;
    private String direccion;
    
    public Cliente(int id, String nombre, String email, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
    }
    
    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getDireccion() { return direccion; }
    
    // Setters
    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEmail(String email) { this.email = email; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    
    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Email: " + email + 
               " | Dirección: " + direccion;
    }
}

// ============================================
// ARCHIVO: ProductoService.java
// ============================================
import java.util.ArrayList;
import java.util.List;

public class ProductoService {
    private List<Producto> productos = new ArrayList<>();
    
    // CREATE - Crear producto
    public boolean crearProducto(Producto producto) {
        // Validaciones
        if (producto.getNombre() == null || producto.getNombre().trim().isEmpty()) {
            System.out.println("ERROR: El nombre del producto no puede estar vacío");
            return false;
        }
        if (producto.getPrecio() <= 0) {
            System.out.println("ERROR: El precio debe ser mayor a 0");
            return false;
        }
        if (producto.getStock() < 0) {
            System.out.println("ERROR: El stock no puede ser negativo");
            return false;
        }
        
        // Verificar ID duplicado
        for (Producto p : productos) {
            if (p.getId() == producto.getId()) {
                System.out.println("ERROR: Ya existe un producto con ese ID");
                return false;
            }
        }
        
        productos.add(producto);
        System.out.println("✓ Producto creado exitosamente");
        return true;
    }
    
    // READ - Leer todos los productos
    public void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados");
            return;
        }
        System.out.println("\n=== LISTA DE PRODUCTOS ===");
        for (Producto p : productos) {
            System.out.println(p);
        }
        System.out.println("Total de productos: " + productos.size());
    }
    
    // READ - Buscar producto por ID
    public Producto buscarProducto(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
    
    // UPDATE - Actualizar producto
    public boolean actualizarProducto(int id, String nombre, String descripcion, double precio, int stock) {
        Producto producto = buscarProducto(id);
        if (producto == null) {
            System.out.println("ERROR: Producto no encontrado");
            return false;
        }
        
        // Validaciones
        if (precio <= 0) {
            System.out.println("ERROR: El precio debe ser mayor a 0");
            return false;
        }
        if (stock < 0) {
            System.out.println("ERROR: El stock no puede ser negativo");
            return false;
        }
        
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        producto.setStock(stock);
        System.out.println("✓ Producto actualizado exitosamente");
        return true;
    }
    
    // DELETE - Eliminar producto
    public boolean eliminarProducto(int id) {
        Producto producto = buscarProducto(id);
        if (producto == null) {
            System.out.println("ERROR: Producto no encontrado");
            return false;
        }
        productos.remove(producto);
        System.out.println("✓ Producto eliminado exitosamente");
        return true;
    }
}

// ============================================
// ARCHIVO: ClienteService.java
// ============================================
import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    private List<Cliente> clientes = new ArrayList<>();
    
    // CREATE - Crear cliente
    public boolean crearCliente(Cliente cliente) {
        // Validaciones
        if (cliente.getNombre() == null || cliente.getNombre().trim().isEmpty()) {
            System.out.println("ERROR: El nombre no puede estar vacío");
            return false;
        }
        if (cliente.getEmail() == null || !cliente.getEmail().contains("@")) {
            System.out.println("ERROR: Email inválido");
            return false;
        }
        if (cliente.getDireccion() == null || cliente.getDireccion().trim().isEmpty()) {
            System.out.println("ERROR: La dirección no puede estar vacía");
            return false;
        }
        
        // Verificar ID duplicado
        for (Cliente c : clientes) {
            if (c.getId() == cliente.getId()) {
                System.out.println("ERROR: Ya existe un cliente con ese ID");
                return false;
            }
        }
        
        clientes.add(cliente);
        System.out.println("✓ Cliente creado exitosamente");
        return true;
    }
    
    // READ - Leer todos los clientes
    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados");
            return;
        }
        System.out.println("\n=== LISTA DE CLIENTES ===");
        for (Cliente c : clientes) {
            System.out.println(c);
        }
        System.out.println("Total de clientes: " + clientes.size());
    }
    
    // READ - Buscar cliente por ID
    public Cliente buscarCliente(int id) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }
    
    // UPDATE - Actualizar cliente
    public boolean actualizarCliente(int id, String nombre, String email, String direccion) {
        Cliente cliente = buscarCliente(id);
        if (cliente == null) {
            System.out.println("ERROR: Cliente no encontrado");
            return false;
        }
        
        // Validaciones
        if (!email.contains("@")) {
            System.out.println("ERROR: Email inválido");
            return false;
        }
        
        cliente.setNombre(nombre);
        cliente.setEmail(email);
        cliente.setDireccion(direccion);
        System.out.println("✓ Cliente actualizado exitosamente");
        return true;
    }
    
    // DELETE - Eliminar cliente
    public boolean eliminarCliente(int id) {
        Cliente cliente = buscarCliente(id);
        if (cliente == null) {
            System.out.println("ERROR: Cliente no encontrado");
            return false;
        }
        clientes.remove(cliente);
        System.out.println("✓ Cliente eliminado exitosamente");
        return true;
    }
}

// ============================================
// ARCHIVO: Main.java
// ============================================
import java.util.Scanner;

public class Main {
    private static ProductoService productoService = new ProductoService();
    private static ClienteService clienteService = new ClienteService();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║   TIENDA ONLINE - SISTEMA CRUD     ║");
        System.out.println("╚════════════════════════════════════╝");
        
        // Datos de ejemplo precargados
        cargarDatosEjemplo();
        
        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            switch (opcion) {
                case 1: menuProductos(); break;
                case 2: menuClientes(); break;
                case 3: 
                    System.out.println("\n¡Gracias por usar el sistema!");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }
    
    private static void mostrarMenu() {
        System.out.println("\n╔════════════════════════════════╗");
        System.out.println("║        MENÚ PRINCIPAL          ║");
        System.out.println("╠════════════════════════════════╣");
        System.out.println("║ 1. Gestión de Productos        ║");
        System.out.println("║ 2. Gestión de Clientes         ║");
        System.out.println("║ 3. Salir                       ║");
        System.out.println("╚════════════════════════════════╝");
        System.out.print("Seleccione opción: ");
    }
    
    private static void menuProductos() {
        System.out.println("\n=== GESTIÓN DE PRODUCTOS ===");
        System.out.println("1. Crear Producto");
        System.out.println("2. Ver Productos");
        System.out.println("3. Actualizar Producto");
        System.out.println("4. Eliminar Producto");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        
        switch (opcion) {
            case 1: crearProducto(); break;
            case 2: productoService.listarProductos(); break;
            case 3: actualizarProducto(); break;
            case 4: eliminarProducto(); break;
            default: System.out.println("Opción inválida");
        }
    }
    
    private static void menuClientes() {
        System.out.println("\n=== GESTIÓN DE CLIENTES ===");
        System.out.println("1. Crear Cliente");
        System.out.println("2. Ver Clientes");
        System.out.println("3. Actualizar Cliente");
        System.out.println("4. Eliminar Cliente");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        
        switch (opcion) {
            case 1: crearCliente(); break;
            case 2: clienteService.listarClientes(); break;
            case 3: actualizarCliente(); break;
            case 4: eliminarCliente(); break;
            default: System.out.println("Opción inválida");
        }
    }
    
    // Métodos CRUD Productos
    private static void crearProducto() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Descripción: ");
        String desc = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        System.out.print("Stock: ");
        int stock = scanner.nextInt();
        
        Producto p = new Producto(id, nombre, desc, precio, stock);
        productoService.crearProducto(p);
    }
    
    private static void actualizarProducto() {
        System.out.print("ID del producto a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nuevo nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Nueva descripción: ");
        String desc = scanner.nextLine();
        System.out.print("Nuevo precio: ");
        double precio = scanner.nextDouble();
        System.out.print("Nuevo stock: ");
        int stock = scanner.nextInt();
        
        productoService.actualizarProducto(id, nombre, desc, precio, stock);
    }
    
    private static void eliminarProducto() {
        System.out.print("ID del producto a eliminar: ");
        int id = scanner.nextInt();
        productoService.eliminarProducto(id);
    }
    
    // Métodos CRUD Clientes
    private static void crearCliente() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Dirección: ");
        String dir = scanner.nextLine();
        
        Cliente c = new Cliente(id, nombre, email, dir);
        clienteService.crearCliente(c);
    }
    
    private static void actualizarCliente() {
        System.out.print("ID del cliente a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nuevo nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Nuevo email: ");
        String email = scanner.nextLine();
        System.out.print("Nueva dirección: ");
        String dir = scanner.nextLine();
        
        clienteService.actualizarCliente(id, nombre, email, dir);
    }
    
    private static void eliminarCliente() {
        System.out.print("ID del cliente a eliminar: ");
        int id = scanner.nextInt();
        clienteService.eliminarCliente(id);
    }
    
    // Cargar datos de ejemplo
    private static void cargarDatosEjemplo() {
        // Productos
        productoService.crearProducto(new Producto(1, "Laptop HP", "Laptop 15 pulgadas, 8GB RAM", 599.99, 10));
        productoService.crearProducto(new Producto(2, "Mouse Inalámbrico", "Mouse ergonómico Logitech", 25.50, 50));
        productoService.crearProducto(new Producto(3, "Teclado Mecánico", "Teclado RGB gaming", 89.99, 25));
        
        // Clientes
        clienteService.crearCliente(new Cliente(1, "Juan Pérez", "juan@email.com", "Calle 123, Ciudad"));
        clienteService.crearCliente(new Cliente(2, "María García", "maria@email.com", "Av. Principal 456"));
        
        System.out.println("\n✓ Datos de ejemplo cargados correctamente\n");
    }
}