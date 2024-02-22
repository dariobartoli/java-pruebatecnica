import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        char asientos[][] = new char[10][10];
        boolean flag = false;
        //Para permitir ingresos de datos en java usamos Scanner
        Scanner keyboard = new Scanner(System.in);
        int fila = 0,columna = 0;
        String respuesta;
        String verAsientos;

        for(int f=0; f<10; f++){
            for(int c=0; c<10; c++){
                asientos[f][c]= 'L';
            }
        }

        System.out.println("Sistema de reservas de asientos");

        while(!flag){
            System.out.println("¿Desea ver los asientos disponibles? S:si, Cualquier otra letra: no");
            verAsientos = keyboard.next();
            if(verAsientos.equalsIgnoreCase("S")){
                dibujarMapa(asientos);
            }

            boolean flagEleccion = false;
            while(!flagEleccion){
                System.out.println("Ingresar fila y asiento a reservar");
                System.out.print("Elegir fila entre 0 y 9: ");
                fila = keyboard.nextInt();
                System.out.print("Elegir asiento entre 0 y 9: ");
                columna = keyboard.nextInt();

                if(fila <=9 && fila >= 0){
                    if(columna <= 9 && columna >= 0){
                        flagEleccion = true;
                    }else {
                        System.out.println("Numero de columna no válido");
                    }
                }else{
                    System.out.println("Numero de fila no válido");
                }
            }
            //Si fuera String usamos .equals, con char usamos ==
            if(asientos[fila][columna] == 'X'){
                System.out.println("El asiento está ocupado");
            }else if(asientos[fila][columna] == 'L'){
                asientos[fila][columna] = 'X';
                System.out.println("El asiento fue reservado correctamente");
            }
            System.out.println("¿Quiere seguir reservando? N: no, Cualquier otra letra: si");
            respuesta = keyboard.next();
            if(respuesta.equalsIgnoreCase("N")){
                flag = true;
            }
        }
    }


    //Usamos static para que la funcion sea estatica y podamos usarla dentro del main, de toda la clase
    //No podemos declarar la funcion dentro del main, no funcionaria
    static void dibujarMapa(char asientos[][]){
        for(int f=0; f<10; f++){
            System.out.print(f);
            for(int c=0; c<10; c++){
                System.out.print("[" + asientos[f][c] + "]");
            }
            System.out.println("");
        }
    }
}