import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.lang.NumberFormatException;

public class Principal{

    private static boolean validLength(String str){
        if(str.length() == 11) return true;
        return false;
    }
    private static boolean onlyNumbers(String str){
        if(str.isEmpty()) return false;
        var aux = str.toCharArray();
        for(int i = 0; i < str.length(); i++){
            if(!(aux[i] == '0' ||  aux[i] == '1' || aux[i] == '2' || aux[i] == '3' || aux[i] == '4' ||
            aux[i] == '5' || aux[i] == '6' || aux[i] == '7' || aux[i] == '8' || aux[i] == '9')) return false;
        }
        return true;
    }

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
            boolean repeat;
            switch (option_2) {
                
                case 0:
                    break;
                
                case 1:
                repeat = true;
                    do{
                        try{
                            cpf = System.console().readLine("CPF do paciente: ");
                            if(!validLength(cpf)){
                                System.out.println("Tamanho inválido. Tente novamente.");
                                continue;
                            }
                            if(!onlyNumbers(cpf)){
                                System.out.println("Entrada inválida. Tente novamente.");
                                continue;
                            }

                            if(clinica.Pesqpaciente(cpf) == null) System.out.println("Paciente não foi cadastrado.");
                            else System.out.println(clinica.Pesqpaciente(cpf).toString());

                            repeat = false;
                        }catch(InputMismatchException ime){
                            System.err.printf("%nExceção: %s%n", ime);
                            System.out.println("Você escreveu um dígito incompatível com o tipo pedido. Por favor, tente novamente.");
                            System.out.println();
                            System.console().readLine("Digite qualquer tecla pra continuar: ");
                        }
                    }while(repeat);
                    System.console().readLine("Digite qualquer tecla pra continuar: ");
                    break;
                case 2:
                repeat = true;
                do{
                    try{
                        System.out.print("Insira o CPF do paciente: ");
                        String cpfPac = kb.nextLine();
                        if(!validLength(cpfPac)){
                            System.out.println("Tamanho inválido. Tente novamente.");
                            continue;
                        }
                        if(!onlyNumbers(cpfPac)){
                            System.out.println("Entrada inválida. Tente novamente.");
                            continue;
                        }
    
                        System.out.print("Data para consulta (dd mm aaaa): ");
                        dia = kb.nextByte(); mes = kb.nextByte(); ano = kb.nextShort();
    
                        System.out.print("Horário para consulta: ");
                        byte hora = kb.nextByte(); byte min = kb.nextByte(); kb.nextLine();
    
                        System.out.print("Médico responsável: ");
                        String crmDoc = kb.nextLine();
                        
                        Consulta consMark = new Consulta(cpfPac, new Data(dia, mes, ano), new Hora(hora, min), false, crmDoc);
    
                        clinica.addConsulta(consMark);

                        repeat = false;
                    }catch(InputMismatchException ime){
                        System.err.printf("%nExceção: %s%n", ime);
                        System.out.println("Você escreveu um dígito incompatível com o tipo pedido. Por favor, tente novamente.");
                        System.out.println();
                        System.console().readLine("Digite qualquer tecla pra continuar: ");
                    }catch(NumberFormatException nfe){
                        System.err.printf("%nExceção: %s%n", nfe);
                        System.out.println("Dígito inválido. Por favor, tente novamente.");
                        System.out.println();
                        System.console().readLine("Digite qualquer tecla pra continuar: ");
                    }
                }while(repeat);
				break;
                case 3:
                repeat = true;
                    do{
                        try{
                            nome = System.console().readLine("Nome completo: ");
                            cpf = System.console().readLine("CPF: ");
                            if(!validLength(cpf)){
                                System.out.println("Tamanho inválido. Tente novamente.");
                                continue;
                            }
                            if(!onlyNumbers(cpf)){
                                System.out.println("Entrada inválida. Tente novamente.");
                                continue;
                            }
                            dia = Byte.parseByte(System.console().readLine("Dia de nascimento: "));
                            mes = Byte.parseByte(System.console().readLine("mês de nascimento: "));
                            ano = Short.parseShort(System.console().readLine("Ano de nascimento: "));
                            nasc = new Data(dia, mes, ano);
                            sex = System.console().readLine("Sexo: ").charAt(0);
                            endereço = System.console().readLine("Endereço: ");
                            telefone = System.console().readLine("Número de Telefone: ");
                            if(!validLength(telefone)){
                                System.out.println("Tamanho inválido. Tente novamente.");
                                continue;
                            }if(!onlyNumbers(telefone)){
                                System.out.println("Entrada inválida. Tente novamente.");
                                continue;
                            }
                            naturalidade = System.console().readLine("Naturalidade: ");

                            Paciente newp = new Paciente(nome, endereço, telefone, cpf, nasc, sex, naturalidade);
                            clinica.addPaciente(newp);

                            repeat = false;
                        }catch(InputMismatchException ime){
                            System.err.printf("%nExceção: %s%n", ime);
                            System.out.println("Você escreveu um dígito incompatível com o tipo pedido. Por favor, tente novamente.");
                            System.out.println();
                            System.console().readLine("Digite qualquer tecla pra continuar: ");
                        }catch(NumberFormatException nfe){
                            System.err.printf("%nExceção: %s%n", nfe);
                            System.out.println("Dígito inválido. Por favor, tente novamente.");
                            System.out.println();
                            System.console().readLine("Digite qualquer tecla pra continuar: ");
                        }
                    }while(repeat);
                break;
                case 4:
                    repeat = true;
                    do{
                        try{
                            cpf = System.console().readLine("CPF do paciente: ");
                            if(!validLength(cpf)){
                                System.out.println("Tamanho inválido. Tente novamente.");
                                continue;
                            }
                            if(!onlyNumbers(cpf)){
                                System.out.println("Entrada inválida. Tente novamente.");
                                continue;
                            }
                            clinica.delPaciente(cpf);
                            repeat = false;
                        }catch(InputMismatchException ime){
                            System.err.printf("%nExceção: %s%n", ime);
                            System.out.println("Você escreveu um dígito incompatível com o tipo pedido. Por favor, tente novamente.");
                            System.out.println();
                            System.console().readLine("Digite qualquer tecla pra continuar: ");
                        }
                    }while(repeat);
                    System.console().readLine("Digite qualquer tecla pra continuar: ");
                    System.out.print("\033[H\033[2J");
                break;
                case 5:
                    repeat = true;
                    do{
                        try{
                            cpf = System.console().readLine("CPF do paciente: ");
                            if(!validLength(cpf)){
                                System.out.println("Tamanho inválido. Tente novamente.");
                                continue;
                            }
                            if(!onlyNumbers(cpf)){
                                System.out.println("Entrada inválida. Tente novamente.");
                                continue;
                            }
                            String crmResp = System.console().readLine("CRM do médico responsável: ");
                            if(crmResp.length() > 8){
                                System.out.println("Tamanho inválido. Tente novamente.");
                                continue;
                            }
                            if(!clinica.cancelarConsulta(cpf, crmResp)) System.out.println("Paciente não foi cadastrado.");
                            else System.out.println(clinica.cancelarConsulta(cpf, crmResp));

                            repeat = false;
                        }catch(InputMismatchException ime){
                            System.err.printf("%nExceção: %s%n", ime);
                            System.out.println("Você escreveu um dígito incompatível com o tipo pedido. Por favor, tente novamente.");
                            System.out.println();
                            System.console().readLine("Digite qualquer tecla pra continuar: ");
                        }
                    }while(repeat);
                    System.console().readLine("Digite qualquer tecla pra continuar: ");
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
            boolean repeat_2;
            switch (option_3) {
                case 0:
                    break;
                
                case 1:
                    repeat_2 = true;
                    do{
                        try{
                            registro = System.console().readLine("Registro do especialista: ");
                            if(registro.length() > 8){
                                System.out.println("Tamanho inválido. tente novamente.");
                                continue;
                            }
                            if(clinica.pesqClinico(registro) == null) System.out.println("Clínico não cadastrado");
                            else System.out.println(clinica.pesqClinico(registro).toString());

                            repeat_2 = false;
                        }catch(InputMismatchException ime){
                            System.err.printf("%nExceção: %s%n", ime);
                            System.out.println("Você escreveu um dígito incompatível com o tipo pedido. Por favor, tente novamente.");
                            System.out.println();    
                            System.console().readLine("Digite qualquer tecla pra continuar: ");
                        }
                    }while(repeat_2);
                    System.console().readLine("Digite qualquer tecla pra continuar: ");
                break;
                case 2:
                    repeat_2 = true;
                    do{
                        try{
                            nome = System.console().readLine("Nome completo: ");
                            registro = System.console().readLine("Registro: ");
                            if(registro.length() > 8){
                                System.out.println("Tamanho inválido. tente novamente.");
                                continue;
                            }
                            endereço = System.console().readLine("Endereço: ");
                            telefone = System.console().readLine("Número de Telefone: ");
                            if(!validLength(telefone)){
                                System.out.println("Tamanho inválido. Tente novamente.");
                                continue;
                            }
                            if(!onlyNumbers(telefone)){
                                System.out.println("Entrada inválida. Tente novamente.");
                                continue;
                            }
                            espec = System.console().readLine("Especialidade: ");

                            Clinico newc = new Clinico(nome, endereço, telefone, registro, espec);
                            clinica.addClinico(newc);

                            repeat_2 = false;
                        }catch(InputMismatchException ime){
                            System.err.printf("%nExceção: %s%n", ime);
                            System.out.println("Você escreveu um dígito incompatível com o tipo pedido. Por favor, tente novamente.");
                            System.out.println();    
                            System.console().readLine("Digite qualquer tecla pra continuar: ");
                        }catch(NumberFormatException nfe){
                            System.err.printf("%nExceção: %s%n", nfe);
                            System.out.println("Dígito inválido. Por favor, tente novamente.");
                            System.out.println();
                            System.console().readLine("Digite qualquer tecla pra continuar: ");
                        }
                    }while(repeat_2);
                break;
                case 3:
                    repeat_2 = true;
                    do{
                        try{
                            registro = System.console().readLine("Registro do especialista: ");
                            if(registro.length() > 8){
                                System.out.println("Tamanho inválido. tente novamente.");
                                continue;
                            }
                            clinica.delClinico(registro);

                            repeat_2 = false;
                        }catch(InputMismatchException ime){
                            System.err.printf("%nExceção: %s%n", ime);
                            System.out.println("Você escreveu um dígito incompatível com o tipo pedido. Por favor, tente novamente.");
                            System.out.println();    
                            System.console().readLine("Digite qualquer tecla pra continuar: ");
                        }
                    }while(repeat_2);
                    System.console().readLine("Digite qualquer tecla pra continuar: ");
                break;
                case 4:
                    repeat_2 = true;
                    do{
                        try{
                            String crmResp = System.console().readLine("CRM do médico responsável: ");
                            if(crmResp.length() > 8){
                                System.out.println("Tamanho inválido. Tente novamente.");
                                continue;
                            }

                            List<Consulta> consulta = new ArrayList<>(); 
                            consulta = clinica.getConsultas().get(crmResp);
                            
                            if(consulta == null){
                                System.out.println("Não há consultas agendadas para esse médico.");
                                repeat_2 = false;
                                continue;
                            }

                            Collections.sort(consulta);

                            for(Consulta aux : consulta){
                                System.out.println(aux.toString());
                            }
                            System.console().readLine("Digite qualquer tecla pra continuar: ");

                            repeat_2 = false;
                        }catch(InputMismatchException ime){
                            System.err.printf("%nExceção: %s%n", ime);
                            System.out.println("Você escreveu um dígito incompatível com o tipo pedido. Por favor, tente novamente.");
                            System.out.println();    
                            System.console().readLine("Digite qualquer tecla pra continuar: ");
                        }
                    }while(repeat_2);
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
        HashMap<String, ArrayList<Consulta>> consultas = fileRead.readFileConsulta();
        HashMap<String, ArrayList<Prontuario>> prontuarios = fileRead.readFileProntuario();

        clinica.setPacientes(pacientes);
        clinica.setClinicos(clinicos);
        clinica.setConsultas(consultas);
        clinica.setProntuarios(prontuarios);

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
        fileWrite.writeFileConsulta(clinica.getConsultas());
        fileWrite.writeFilePront(clinica.getProntuarios());

        kb.close();
    }
}
