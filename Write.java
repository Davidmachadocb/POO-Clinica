import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

class Write{
    public static void writerWichFile(byte id){
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
                        System.out.println("Nome: ");
                        String nomePac = kb.nextLine();

                        System.out.println("Endereço: ");
                        String endPac = kb.nextLine();

                        System.out.println("Telefone: ");
                        String numeroTelefonePac = kb.nextLine();

                        System.out.println("CPF: ");
                        String cpf = kb.nextLine();

                        System.out.println("Data de nascimento (dd mm aa): ");
                        byte dia = kb.nextByte(); byte mes = kb.nextByte(); int ano = kb.nextInt();

                        System.out.println("Sexo: ");
                        String sexo = kb.next();

                        System.out.println("Naturalidade: ");
                        String natu = kb.nextLine();
                        
                        outFile.printf("%s%n%s%n%s%n%s%n%d/%d/%d%n%s%n%s%n",
                        nomePac, endPac, numeroTelefonePac, cpf, dia, mes, ano, sexo, natu);
                    break;
                    case 2:
                        System.out.println("Nome: ");
                        String nomeMed = kb.nextLine();
                        
                        System.out.println("Endereço: ");
                        String endMed = kb.nextLine();
                        
                        System.out.println("Telefone: ");
                        String numeroTelefoneMed = kb.nextLine();
                        
                        System.out.println("Registro CRM: ");
                        String reg = kb.nextLine();
                        
                        System.out.println("Especialidade: ");
                        String spec = kb.nextLine();

                        outFile.printf("%s%n%s%n%s%n%s%n%s%n", nomeMed, endMed, numeroTelefoneMed, reg, spec);
                    break;
                    case 3:
                        System.out.println("CPF do paciente: ");
                        String cpfPacConsulta = kb.nextLine();
                        
                        System.out.println("Data da consulta: ");
                        byte diaConsulta = kb.nextByte(); byte mesConsulta = kb.nextByte();
                        int anoConsulta = kb.nextInt();
                        
                        System.out.println("Realizada? (s/n): ");
                        String consultaRealizada = kb.next();

                        outFile.printf("%s%n%d/%d/%d%n%s%n",
                        cpfPacConsulta, diaConsulta, mesConsulta, anoConsulta, consultaRealizada);
                    break;
                    case 4:
                        System.out.println("CPF do paciente: ");
                        String cpfPront = kb.nextLine();
                        
                        System.out.println("Insira os sintomas: ");
                        String sintomas = kb.nextLine();
                        
                        System.out.println("Insira o diagnóstico: ");
                        String diag = kb.nextLine();

                        outFile.printf("%s%n%s%n%s%n", cpfPront, sintomas, diag);
                    break;
                }
                
                System.out.println("Continuar? (s/n)");
                String option = kb.next();
                if(option.equals("n")) break;
            
            }while(true);
            kb.close();
        }catch(InputMismatchException e){
            System.err.println("Entrada inválida: " + e.getMessage());
        }catch(IOException e){
            System.out.println("Um erro foi detectado ao tentar abrir o arquivo: " + e.getMessage());
        }
    }
}