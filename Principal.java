public class Menu {

    public static void menu_principal(){


        System.out.println("\n\n         #### Clinica ####\n");
		System.out.println("=====================================");
		System.out.println("|     1 - Menu do Paciente          |");
		System.out.println("|     2 - Menu do Especialista      |");
		System.out.println("|     0 - Sair                      |");
		System.out.println("=====================================\n"); 
    }


    public static void menu_paciente(){

		System.out.println("\n");
        System.out.println("    #### Clinica - Menu Paciente ####\n");
		System.out.println("========================================");
		System.out.println("|     1 - Pesquisar Paciente           |");
		System.out.println("|     2 - Marcar Consulta              |");
		System.out.println("|     3 - Cadastrar Paciente           |");
		System.out.println("|     4 - Remover Paciente             |");
		System.out.println("|     0 - Voltar                       |");
		System.out.println("========================================\n");
    }

    public static void menu_especialista(){

		System.out.println("\n");
        System.out.println("     #### Clinica - Menu Especialista ####\n");
		System.out.println("============================================");
		System.out.println("|     1 - Pesquisar Especialista           |");
		System.out.println("|     2 - Cadastrar Especialista           |");
		System.out.println("|     3 - Remover Especialista             |");
		System.out.println("|     4 - Consultas                        |");
		System.out.println("|     0 - Voltar                           |");
		System.out.println("============================================\n");
    }

}
