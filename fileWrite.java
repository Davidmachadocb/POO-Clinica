import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

class fileWrite{
    public static void writeWichFile(byte id){
        Locale.setDefault(Locale.US);
        String filePaciente = "/home/itsfrancisco/Área de Trabalho/Pacientes.txt";
        String fileClinico = "/home/itsfrancisco/Área de Trabalho/Medicos.txt";
        String fileConsulta = "/home/itsfrancisco/Área de Trabalho/Consultas.txt";
        String fileProntuario = "/home/itsfrancisco/Área de Trabalho/Prontuarios.txt";
        
        String fileSelected = "";
        switch(id){
            case 1: fileSelected = filePaciente; break;
            case 2: fileSelected = fileClinico; break;
            case 3: fileSelected = fileConsulta; break;
            case 4: fileSelected = fileProntuario; break;
            default: System.err.println("ID inválido."); return;
        }

        try(FileWriter fstream = new FileWriter(fileSelected, StandardCharsets.UTF_8, true);
            PrintWriter outFile = new PrintWriter(fstream, true);)
        {
            Scanner kb = new Scanner(System.in);
            do{
                switch(id){
                    case 1:
                        System.out.print("Nome: ");
                        String nomePac = kb.nextLine();

                        System.out.print("Endereço: ");
                        String endPac = kb.nextLine();

                        System.out.print("Telefone: ");
                        String numeroTelefonePac = kb.next(); kb.nextLine();

                        System.out.print("CPF: ");
                        String cpf = kb.next(); kb.nextLine();

                        System.out.print("Data de nascimento (dd mm aaaa): ");
                        byte dia = kb.nextByte(); byte mes = kb.nextByte(); int ano = kb.nextInt();

                        System.out.print("Sexo: ");
                        String sexo = kb.next(); kb.nextLine();

                        System.out.print("Naturalidade: ");
                        String natu = kb.next(); kb.nextLine();
                        
                        outFile.printf("%s%n%s%n%s%n%s%n%d %d %d%n%s%n%s%n",
                        nomePac, endPac, numeroTelefonePac, cpf, dia, mes, ano, sexo, natu);
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

                        outFile.printf("%s%n%s%n%s%n%s%n%s%n", nomeMed, endMed, numeroTelefoneMed, reg, spec);
                    break;
                    case 3:
                        System.out.print("CPF do paciente: ");
                        String cpfPacConsulta = kb.next(); kb.nextLine();
                        
                        System.out.print("Data da consulta: ");
                        byte diaConsulta = kb.nextByte(); byte mesConsulta = kb.nextByte();
                        int anoConsulta = kb.nextInt();
                        
                        System.out.print("Realizada? (s/n): ");
                        String consultaRealizada = kb.next(); kb.nextLine();

                        outFile.printf("%s%n%d %d %d%n%s%n",
                        cpfPacConsulta, diaConsulta, mesConsulta, anoConsulta, consultaRealizada);
                    break;
                    case 4:
                        System.out.print("CPF do paciente: ");
                        String cpfPront = kb.next(); kb.nextLine();
                        
                        System.out.print("Insira os sintomas: ");
                        String sintomas = kb.nextLine();
                        
                        System.out.print("Insira o diagnóstico: ");
                        String diag = kb.nextLine();

                        outFile.printf("%s%n%s%n%s%n", cpfPront, sintomas, diag);
                    break;
                }
                
                System.out.println("Continuar? (s/n)");
                String option = kb.next(); kb.nextLine();
                if(option.equals("n"))break;
            
                System.out.println();
            }while(true);
            kb.close();
        }catch(InputMismatchException e){
            System.err.println("Entrada inválida: " + e.getMessage());
        }catch(IOException e){
            System.out.println("Um erro foi detectado ao tentar abrir o arquivo: " + e.getMessage());
        }
    }
}
