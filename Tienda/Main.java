package Tienda;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Scanner;


public class Main {

    public static Fecha f1 = new Fecha();
    public static Scanner in = new Scanner(System.in);
    
    public static void definirFecha(){
        f1.setDia(15);
        f1.setMes(7);
        f1.setAnio(2020);
    }
    
    public static void Adelantar(){
        int diaActual = f1.getDia();
        int mesActual = f1.getMes();
        int anioActual = f1.getAnio();
        
        Calendar oFecha = Calendar.getInstance();
        oFecha.set(anioActual, mesActual, diaActual);
        
       
        oFecha.add(Calendar.DAY_OF_MONTH, f1.getDia());
        oFecha.add(Calendar.MONTH, f1.getMes());
        oFecha.add(Calendar.YEAR, f1.getAnio());
        
        f1.setAnio(oFecha.get(Calendar.YEAR));
        f1.setMes(oFecha.get(Calendar.MONTH));
        f1.setDia(oFecha.get(Calendar.DAY_OF_MONTH)+5);
    }
    
    public static String imprimirFecha(){
        return "\nDia: "+f1.getDia()+
                "\nMes: "+f1.getMes()+
                "\nAnio: "+f1.getAnio();
    }
    
    public static void main(String[] args) {
        
        Producto p1 = new Producto();
        
        LocalDate date = LocalDate.of(2020, 8, 7);
        LocalDate newDate = date.plusDays(10);
        
        
        char opc = 0;
        String respuesta;
        p1.setIVA(0.09f);
        p1.setPrecio(5.0f);
        do{
            System.out.print("\nIngresar nombre del producto: "); p1.setNombreProducto(in.next());
            
            System.out.println("\n\nGenerando codigo del producto...");
            System.out.println("\nCodigo de "+p1.getNombreProducto()+" es: "+p1.codigoProducto());
            
            System.out.println("La fecha de elaboracion "+p1.getNombreProducto()+" es: ");
             
            if(opc == 's' || opc == 'S'){
                System.out.println(newDate);
            }
            else{
                System.out.println(date);
            }
            
            System.out.println("\n\n IVA implementado por el gobierno es: "+p1.getIVA());
            
            System.out.println("\n\nMuestra de precios: ");
            System.out.println("\nPrecio sin IVA de "+p1.getNombreProducto() +" es: "+p1.getPrecio());
            System.out.println("\nEl precio total con IVA de "+p1.getNombreProducto()+" es: "+p1.precioTotal());
            
            System.out.print("\n\nDesea comprar el producto: "+p1.getNombreProducto()+" ?(si/no)"); respuesta = in.next();
            
            if("si".equals(respuesta)){
                System.out.println("\nGracias por comprar su producto "+p1.getNombreProducto());
            }
            else{
                System.out.println("\nUsted ha decisido no comprar el producto "+p1.getNombreProducto());
            }
            
            System.out.print("\n\nLe interesa algún otro producto? (s/n): "); opc = in.next().charAt(0);
        }while(opc == 's' || opc == 'S');
        
        
    }
    
}
