import logica.Cliente;
import logica.Ticket;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    static double sumarPrecios(List<Ticket> listaDeTickets){
        double total = 0;
        for (Ticket tick : listaDeTickets){
            total += tick.getPrecio();
        }
        return total;
    }

    public static void main(String[] args) {
        //vamos a usar collections para guardar la informacion, simular una DB
        //Creo la lista de tickets vacia
        List<Ticket> listaDeTickets = new ArrayList<Ticket>();



        //creo los tickets mediante constructor y encapsulamiento
        Ticket ticket1 = new Ticket(16, 3, 6, 2500, new Date(), new Date());
        Ticket ticket2 = new Ticket(17, 3, 7, 2500, new Date(), new Date());
        Ticket ticket3 = new Ticket();
        ticket3.setNumero(34);
        ticket3.setFila(4);
        ticket3.setAsiento(8);
        ticket3.setPrecio(4000);
        ticket3.setFechaCompra(new Date());
        ticket3.setFechaValidez(new Date());

        //agrego los tickets a la lista de tickets
        listaDeTickets.add(ticket1);
        listaDeTickets.add(ticket2);
        listaDeTickets.add(ticket3);

        //suma de precios
        double total = sumarPrecios(listaDeTickets);
        System.out.println("El total de precio de los tickets es: " + total);

        //mostrar informacion de una fila
        Scanner keyboard = new Scanner(System.in);
        int fila = 0;
        boolean flag = false;

        System.out.println("Para ver los tickets de una fila, ingrese el número de fila: ");
        fila = keyboard.nextInt();
        for (Ticket tick : listaDeTickets){
            if(tick.getFila() == fila){
                System.out.println(tick.toString());
                System.out.println("-------------------------------------------------");
                flag = true;
            }
        }
        if(!flag){
            System.out.println("No hay tickets para al fila solicitada");
        }

        //Añadiendo tickets a cliente
        Cliente cliente1 = new Cliente(3, "25151321", "juan", "lopez");
        Cliente cliente2 = new Cliente(4, "34541658", "pablo", "aguero");
        cliente1.getTicketList().add(ticket1);
        cliente1.getTicketList().add(ticket2);
        cliente2.getTicketList().add(ticket3);
        //System.out.println(cliente1);
        //System.out.println(cliente2);



    }
}