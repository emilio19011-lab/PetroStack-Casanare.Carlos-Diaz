import java.util.Scanner;
import java.time.LocalDateTime;

public class MenuConsola {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GestorInspecciones gestor = new GestorInspecciones();
        int opcion;

        do {
            System.out.println("\n--- PETROSTACK ---");
            System.out.println("1. Registrar evento");
            System.out.println("2. Ver último");
            System.out.println("3. Retirar evento");
            System.out.println("4. Deshacer");
            System.out.println("5. Listar");
            System.out.println("6. Tamaño");
            System.out.println("7. Salir");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Código pozo: ");
                    String cod = sc.nextLine();

                    System.out.print("Municipio: ");
                    String mun = sc.nextLine();

                    System.out.print("Descripción: ");
                    String desc = sc.nextLine();

                    TipoEvento tipo = null;
                    boolean valido = false;

                    do {
                        try {
                            System.out.print("Tipo (FUGA, MANTENIMIENTO, LECTURA_PRESION, CIERRE_TURNO): ");
                            String tipoStr = sc.nextLine();
                            tipo = TipoEvento.valueOf(tipoStr.toUpperCase());
                            valido = true;
                        } catch (Exception e) {
                            System.out.println("Tipo inválido");
                        }
                    } while (!valido);

                    Pozo p = new Pozo(cod, mun, "OperadorX");

                    EventoInspeccion e = new EventoInspeccion(
                            (int)(Math.random()*1000),
                            p,
                            tipo,
                            desc,
                            LocalDateTime.now()
                    );

                    gestor.registrarEvento(e);
                    break;

                case 2:
                    gestor.revisarUltimo();
                    break;

                case 3:
                    gestor.retirarUltimo();
                    break;

                case 4:
                    gestor.deshacerUltimaAccion();
                    break;

                case 5:
                    gestor.listarEventos();
                    break;

                case 6:
                    gestor.tamaño();
                    break;

                case 7:
                    System.out.println("Cierre del sistema...");
                    break;
            }

        } while (opcion != 7);
    }
}