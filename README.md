# 🍦 SISTEMA DE HELADERÍA - ARIANA OYOLA

Este es un sistema de gestión de ventas y stock desarrollado en Java para una heladería. Permite el control de clientes, proveedores, productos y generación de reportes de ventas en formato PDF.

## 🚀 Funcionalidades
- **Gestión de Ventas:** Registro de pedidos y cálculo automático de totales.
- **Inventario:** Control de productos (sabores, tamaños, stock).
- **Clientes y Proveedores:** Módulos para registro y edición de datos.
- **Reportes:** Generación de facturas/comprobantes en PDF (usando iText).
- **Gráficos:** Visualización de estadísticas de ventas.

## 🛠️ Tecnologías utilizadas
- **Lenguaje:** Java (JDK 8 o superior).
- **IDE:** NetBeans.
- **Base de Datos:** MySQL.
- **Librerías:** - `mysql-connector-java` (Conexión BD).
  - `iText` (Reportes PDF).
  - `JFreeChart` (Gráficos).
  - `JCalendar` (Manejo de fechas).

## 📋 Requisitos para ejecución
1. Tener instalado un servidor local como **XAMPP** o **WampServer**.
2. Importar la base de datos `venta` desde el archivo SQL correspondiente (no incluido en el repo por seguridad).
3. Configurar el usuario y contraseña en la clase `Conexion.java`.

## 📂 Estructura del Proyecto
- `src/Modelo`: Clases de datos y DAOs para la lógica de negocio.
- `src/Vista`: Interfaces gráficas de usuario (JFrame).
- `src/Img`: Recursos visuales e iconos del sistema.
- `librerias`: Archivos JAR necesarios para el funcionamiento.

