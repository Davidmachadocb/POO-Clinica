import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class Menu {

	public static Scanner kb = new Scanner(System.in);
	public static byte opt;
	static Clinica clinica = new Clinica();

    public static void menu_principal(){

        System.out.println("\n\n         #### Clinica ####\n");
		System.out.println("=====================================");
		System.out.println("|     1 - Menu do Paciente          |");
		System.out.println("|     2 - Menu do Especialista      |");
		System.out.println("|     0 - Sair                      |");
		System.out.println("=====================================\n");
		System.out.print("Selecione uma opção: ");
		opt = kb.nextByte();
		do{
			switch(opt){
				case 1: menu_paciente(); break;
				case 2: menu_especialista(); break;
				case 0: System.out.println("Programa encerrado."); System.exit(0);
				default: System.out.println("Opção inválida. Tente novamente."); break;
			} 
		}while(true);
    }

    public static void menu_paciente(){

		System.out.println("\n");
        System.out.println("    #### Clinica - Menu Paciente ####\n");
		System.out.println("========================================");
		System.out.println("|     1 - Pesquisar Paciente           |");
		System.out.println("|     2 - Marcar Consulta              |");
		System.out.println("|     3 - Cadastrar Paciente           |");
		System.out.println("|     4 - Remover Paciente             |");
		System.out.println("|     5 - Cancelar Consulta            |");
		System.out.println("|     0 - Voltar                       |");
		System.out.println("========================================\n");
		System.out.print("Selecione uma opção: ");
		opt = kb.nextByte();
		do{
			switch(opt){
				case 1: 
					System.out.print("Insira o CPF da paciente: ");
					String cpf = kb.nextLine();
					
					clinica.Pesqpaciente(cpf);
				break;
				case 2:
					System.out.print("Insira o CPF da paciente: ");
					String cpfPac = kb.nextLine();

					System.out.print("Data para consulta (dd mm aaaa): ");
					byte dia = kb.nextByte(); byte mes = kb.nextByte(); int ano = kb.nextInt();

					System.out.print("Horário para consulta: ");
					byte hora = kb.nextByte(); byte min = kb.nextByte();

					System.out.print("Médico responsável: ");
					String crmDoc = kb.nextLine();
					
					Consulta consMark = new Consulta(cpfPac, new Data(dia, mes, ano), new Hora(hora, min), false, crmDoc);

					clinica.addConsulta(consMark);
				break;
				case 3:
					System.out.print("Nome completo: ");
					String nomePac = kb.nextLine();

					System.out.print("Endereço: ");
					String endPac = kb.nextLine();

					System.out.print("Telefone de contato: ");
					String numeroTelefonePac = kb.next(); kb.nextLine();

					System.out.print("CPF: ");
					String cpfCad = kb.next(); kb.nextLine();

					System.out.print("Data de nascimento (dd mm aaaa): ");
					byte diaN = kb.nextByte(); byte mesN = kb.nextByte(); int anoN = kb.nextInt();

					System.out.print("Sexo: ");
					char sexo = kb.next().charAt(0); kb.nextLine();

					System.out.print("Naturalidade: ");
					String natu = kb.next(); kb.nextLine();

					Paciente newp = new Paciente(nomePac, endPac, numeroTelefonePac, cpfCad, new Data(diaN, mesN, anoN), sexo, natu);
				break;
				case 4:
					System.out.print("CPF do paciente: ");
					String cpfRm = kb.nextLine();

					clinica.delPaciente(cpfRm);
				break;
				case 5:
					System.out.print("CPF do paciente: ");
					String cpfRmCon = kb.nextLine();

					clinica.cancelarConsulta(cpfRmCon);
				break;
				case 0: menu_principal(); break;
				default: System.out.println("Opção inválida. Tente novamente."); break;
			}
		}while(true);
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
		System.out.print("Selecione uma opção: ");
		opt = kb.nextByte();
		do{
			switch(opt){
				case 1:
					System.out.print("Registro CRM: ");
					String crmPesq = kb.nextLine();
					
					clinica.PesqClinico(crmPesq);
				break;
				case 2: 
					System.out.print("Nome: ");
					String nomeMed = kb.nextLine();
					
					System.out.print("Endereço: ");
					String endMed = kb.nextLine();
					
					System.out.print("Telefone: ");
					String numeroTelefoneMed = kb.next(); kb.nextLine();
					
					System.out.print("Registro CRM: ");
					String reg = kb.next(); kb.nextLine();
					
					System.out.print("Especialidade: ");
					String spec = kb.nextLine();

					Clinico newc = new Clinico(nomeMed, endMed, numeroTelefoneMed, reg, spec);

					clinica.addClinico(newc);
				break;
				case 3:
					System.out.print("Registro CRM: ");
					String crmRm = kb.nextLine();
					
					clinica.PesqClinico(crmRm);
				break;
				case 4:
					System.out.print("CRM do médico responsável: ");
					String crmResp = kb.nextLine();

					clinica.catchConsByMed(crmResp);
				break;
				case 0: menu_principal(); break;
				default: System.out.println("Opção inválida. Tente novamente."); break;
			}
		}while(true);
    }
}
