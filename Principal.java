import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.HashMap;

public class Principal{

    static Scanner kb = new Scanner(System.in);
    public static void Second_option(Clinica clinica){

        int option_2;
        String cpf, nome, telefone, endereço, naturalidade;
        char sex;
        Byte dia, mes;
        short ano;
        Data nasc;
        do{
        
            System.out.print("\033[H\033[2J");

            Menu.menu_paciente();
            option_2 = Integer.parseInt(System.console().readLine("Opção -> "));
            switch (option_2) {
                
                case 0:
                    break;
                
                case 1:
                    cpf = System.console().readLine("CPF do paciente: ");
                    
                    if(clinica.Pesqpaciente(cpf) == null) System.out.println("Paciente não foi cadastrado.");
                    else System.out.println(clinica.Pesqpaciente(cpf).toString());
                    
                    System.console().readLine("Digite qualquer tecla pra continuar: ");
                    break;
                
                case 2:
					System.out.print("Insira o CPF da paciente: ");
					String cpfPac = kb.nextLine();

					System.out.print("Data para consulta (dd mm aaaa): ");
					dia = kb.nextByte(); mes = kb.nextByte(); ano = kb.nextShort();

					System.out.print("Horário para consulta: ");
					byte hora = kb.nextByte(); byte min = kb.nextByte();

					System.out.print("Médico responsável: ");
					String crmDoc = kb.nextLine();
					
					Consulta consMark = new Consulta(cpfPac, new Data(dia, mes, ano), new Hora(hora, min), false, crmDoc);

					//clinica.addConsulta(consMark);
				    break;

                case 3:

                    nome = System.console().readLine("Nome completo: ");
                    cpf = System.console().readLine("CPF: ");
                    dia = Byte.parseByte(System.console().readLine("Dia de nascimento: "));
                    mes = Byte.parseByte(System.console().readLine("mês de nascimento: "));
                    ano = Short.parseShort(System.console().readLine("Ano de nascimento: "));
                    nasc = new Data(dia, mes, ano);
                    sex = System.console().readLine("Sexo: ").charAt(0);
                    endereço = System.console().readLine("Endereço: ");
                    telefone = System.console().readLine("Número de Telefone: ");
                    naturalidade = System.console().readLine("Naturalidade: ");

                    Paciente newp = new Paciente(nome, endereço, telefone, cpf, nasc, sex, naturalidade);

                    clinica.addPaciente(newp);

                    break;

                case 4:
                    cpf = System.console().readLine("CPF do paciente: ");
                    clinica.delPaciente(cpf);
                    System.console().readLine("Digite qualquer tecla pra continuar: ");
                    System.out.print("\033[H\033[2J");
                    break;

                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        }while(option_2 != 0);
        

    }

    public static void Third_option(Clinica clinica){
        int option_3;
        String registro, nome, telefone, endereço, espec;

        do{

            System.out.print("\033[H\033[2J");

            Menu.menu_especialista();
            option_3 = Integer.parseInt(System.console().readLine("Opção -> "));
            switch (option_3) {
                case 0:
                    break;
                
                case 1:
                    registro = System.console().readLine("Registro do especialista: ");
                    
                    if(clinica.pesqClinico(registro) == null) System.out.println("Clínico não cadastrado");
                    else System.out.println(clinica.pesqClinico(registro).toString());
                    
                    System.console().readLine("Digite qualquer tecla pra continuar: ");
                    break;

                case 2:
                    nome = System.console().readLine("Nome completo: ");
                    registro = System.console().readLine("Registro: ");
                    endereço = System.console().readLine("Endereço: ");
                    telefone = System.console().readLine("Número de Telefone: ");
                    espec = System.console().readLine("Especialidade: ");


                    Clinico newc = new Clinico(nome, endereço, telefone, registro, espec);

                    clinica.addClinico(newc);

                    break;

                case 3:
                    registro = System.console().readLine("Registro do especialista: ");
                    clinica.delClinico(registro);
                    System.console().readLine("Digite qualquer tecla pra continuar: ");
                    break;

                case 4:
                    String crmResp = System.console().readLine("CRM do médico responsável: ");

                    List<Consulta> consulta = new ArrayList<>(); 
                    consulta = clinica.getConsultas().get(crmResp);

                    Collections.sort(consulta);

                    for(Consulta aux : consulta){
                        System.out.println(aux.toString());
                    }
                    System.console().readLine("Digite qualquer tecla pra continuar: ");

                    break;

                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        }while(option_3 != 0);
    }

    public static void main(String[] args) {

        Clinica clinica = new Clinica();

        HashMap<String, Paciente> pacientes = fileRead.readFilePaciente();
        HashMap<String, Clinico> clinicos = fileRead.readFileClinico();
        /*HashMap<String, ArrayList<Consulta>> consultas;
        HashMap<String, ArrayList<Prontuario>> prontuarios;*/

        clinica.setPacientes(pacientes);
        clinica.setClinicos(clinicos);
    
        int option;
        do{
            System.out.print("\033[H\033[2J");
            
            Menu.menu_principal();

            option = Integer.parseInt(System.console().readLine("Opção -> "));

            switch(option){
                case 0:
                    System.out.println("Programa Finalizado!");
                    break;

                case 1:
                    System.out.print("\033[H\033[2J");
                    Second_option(clinica);
                    break;
            
                case 2:
                    System.out.print("\033[H\033[2J");
                    Third_option(clinica);
                    break;

                default:
                    System.out.println("Opção Inválida");
                    break;
            }

        }while(option != 0);

        fileWrite.writeFilePaciente(clinica.getPacientes());
        fileWrite.writeFileClinico(clinica.getClinicos());
        //fileWrite.writeFileConsulta(clinica.getConsultas());
        //fileWrite.writeFilePront(clinica.getProntuarios());

        kb.close();
    }
}
