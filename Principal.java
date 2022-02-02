public class Principal{

    public static void Second_option(Clinica clinica){
        int option_2;
        do{
            Menu.menu_paciente();
            option_2 = Integer.parseInt(System.console().readLine("Opção -> "));
            switch (option_2) {
                case 0:
                    break;
                case 1:
                    String cpf = System.console().readLine("CPF do paciente -> ");
                    System.out.println(clinica.Pesqpaciente(cpf).toString());
                    break;
                case 2:
                    break; 
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        }while(option_2 != 0);
    }

    public static void Third_option(Clinica clinica){
        int option_3;
        do{
            Menu.menu_especialista();
            option_3 = Integer.parseInt(System.console().readLine("Opção -> "));
            switch (option_3) {
                case 0:
                    break; 
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        }while(option_3 != 0);
    }

    public static void main(String[] args) {

        Clinica clinica = new Clinica(); 
        int option;
        do{
            Menu.menu_principal();

            option = Integer.parseInt(System.console().readLine("Opção -> "));

            switch(option){
                case 0:
                    System.out.println("Programa Finalizado!");
                    break;

                case 1:
                    Second_option(clinica);
                    break;
            
                case 2:
                    Third_option(clinica);
                    break;

                default:
                    System.out.println("Opção Inválida");
                    break;
            }

        }while(option != 0);

    }
}
