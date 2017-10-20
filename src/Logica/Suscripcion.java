/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.DBUsuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Suscripcion {
    private int id;
    private TipoSuscripcion tp;
    private Date fecha;
    private String Estado;
    private int idTipo;
    private String nickcliente;

    public Suscripcion(int id, Date fecha, String Estado, int tipo, String nick) {
        this.id = id;
        this.fecha = fecha;
        this.Estado = Estado;
        this.idTipo = tipo;
        this.nickcliente = nick;
    }

    public int getId() {
        return id;
    }

    public String getNickcliente() {
        return nickcliente;
    }

    public void setNickcliente(String nickcliente) {
        this.nickcliente = nickcliente;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public TipoSuscripcion getTp() {
        return tp;
    }

    public void setTp(TipoSuscripcion tp) {
        this.tp = tp;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public DtSuscripcion getDatos(){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return new DtSuscripcion(id, nickcliente, formato.format(fecha), Estado, tp.getCuota(), tp.getMonto());
    }
    
    public String getFechaString() {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        return formato.format(this.fecha);
    }
    
    public void actualizarVigencia(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        formatter = formatter.withLocale( Locale.getDefault() );  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
        
        LocalDateTime fechaAnt = LocalDateTime.parse(this.getFechaString()+" 00:00", formatter);
        LocalDateTime fechaActual = LocalDateTime.now();
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        
        Date nuevaFecha;
        
        //Solo interesa actualizar el esta si esta vigente
        if(this.Estado.equals("Vigente")){
            System.out.println("\n");
            System.out.println("- Fecha inicio: "+fechaAnt.toString());
            DBUsuario db = new DBUsuario();
            switch (this.tp.getCuota()){
                case "Semanal":
                    // Si la fecha actual es mayor a la fecha de vencimiento de la suscripcion
                    if(fechaAnt.plusWeeks(1).isBefore(fechaActual)){
                        try {
                            nuevaFecha = formato.parse(fechaAnt.plusWeeks(1).format(formatter));
                            fecha = nuevaFecha;
                            db.actualizarEstadoSuscripcion(this.id, this.getFechaString(), "Vencida");
                            this.Estado = "Vencida";
                            System.out.println("- Fecha fin: "+fechaAnt.plusWeeks(1).toString());
                            System.out.println("- Fecha actual: "+fechaActual.toString());
                            System.out.println("Vencida");
                        } catch (ParseException ex) {
                            Logger.getLogger(Suscripcion.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                case "Mensual":
                    if(fechaAnt.plusMonths(1).isBefore(fechaActual)){
                        try {
                            nuevaFecha = formato.parse(fechaAnt.plusMonths(1).format(formatter));
                            fecha = nuevaFecha;
                            db.actualizarEstadoSuscripcion(this.id, this.getFechaString(), "Vencida");
                            this.Estado = "Vencida";
                            System.out.println("- Fecha fin: "+fechaAnt.plusMonths(1).toString());
                            System.out.println("- Fecha actual: "+fechaActual.toString());
                            System.out.println("Vencida");
                        } catch (ParseException ex) {
                            Logger.getLogger(Suscripcion.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                case "Anual":
                    if(fechaAnt.plusYears(1).isBefore(fechaActual)){
                        try {
                            nuevaFecha = formato.parse(fechaAnt.plusYears(1).format(formatter));
                            fecha = nuevaFecha;
                            db.actualizarEstadoSuscripcion(this.id, this.getFechaString(), "Vencida");
                            this.Estado = "Vencida";
                            System.out.println("- Fecha fin: "+fechaAnt.plusYears(1).toString());
                            System.out.println("- Fecha actual: "+fechaActual.toString());
                            System.out.println("Vencida");
                        } catch (ParseException ex) {
                            Logger.getLogger(Suscripcion.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
            }
        }                
    }
    
}
