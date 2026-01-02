package Reportes;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class Grafico {

    public static void Graficar(String fecha) {
        Connection con = null;
        Conexion cn = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // Se agrega 'id' a la consulta para diferenciar las ventas en el gráfico
            String sql = "SELECT id, total FROM ventas WHERE fecha = ?";
            con = cn.getConnection();
            
            // Verificamos que la conexión no sea nula antes de continuar
            if (con == null) {
                System.out.println("Error: No se pudo establecer la conexión con la base de datos.");
                return;
            }
            
            ps = con.prepareStatement(sql);
            ps.setString(1, fecha);
            rs = ps.executeQuery();
            
            DefaultPieDataset dateset = new DefaultPieDataset();
            
            while (rs.next()) {
                // CORRECCIÓN LÍNEA 30: 
                // Usamos el ID de la venta junto al total para que la etiqueta sea única.
                // Si dos ventas tienen el mismo valor, ya no dará error ni se sobrescribirán.
                String etiqueta = "Venta ID: " + rs.getInt("id") + " ($" + rs.getDouble("total") + ")";
                dateset.setValue(etiqueta, rs.getDouble("total"));
            }

            // Crear el gráfico circular
            JFreeChart jf = ChartFactory.createPieChart("Reporte de Venta - " + fecha, dateset);
            
            // Mostrar el gráfico en una ventana
            ChartFrame f = new ChartFrame("Total de Ventas por día", jf);
            f.setSize(1000, 500);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
            
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.toString());
        } finally {
            // CIERRE DE RECURSOS: Muy importante para que no falle después de varios usos
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.toString());
            }
        }
    }
}