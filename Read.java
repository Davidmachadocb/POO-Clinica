import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

class Read {
    public static void readWichFile(byte id){
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

        File file = new File(fileSelected);

        try(Scanner inFile = new Scanner(file, StandardCharsets.UTF_8);){
            switch(id){
                case 1:
                    while(inFile.hasNext()){
                        String name = inFile.nextLine();
                        String endereco = inFile.nextLine();
                        String numeroTel = inFile.next();
                        String cpf = inFile.next();
                        byte dia = inFile.nextByte(); byte mes = inFile.nextByte(); int ano = inFile.nextInt();
                        String sexo = inFile.next();
                        String natu = inFile.next();
                    
                        System.out.printf("Nome completo: %s%nEndereço: %s%nTelefone: %s%nCPF: %s%nData de nascimento: %d/%d/%d%nSexo: %s%nNaturalidade: %s%n",
                        name, endereco, numeroTel, cpf, dia, mes, ano, sexo, natu);
                    }
                break;
                case 2:
                    while(inFile.hasNext()){
                        String name = inFile.nextLine();
                        String endereco = inFile.nextLine();
                        String numeroTel = inFile.next();
                        String reg = inFile.next();
                        String spec = inFile.next();
                    
                        System.out.printf("Nome completo: %s%nEndereço: %s%nTelefone: %s%nCRM: %s%nEspecialidade: %s%n",
                        name, endereco, numeroTel, reg, spec);
                    }
                break;
                case 3:
                    while(inFile.hasNext()){
                        String cpfPac = inFile.next();
                        byte dia = inFile.nextByte(); byte mes = inFile.nextByte(); int ano = inFile.nextInt();
                        String consultaRealizada = inFile.next();
                    
                        System.out.printf("CPF do paciente: %s%nData da consulta: %d/%d/%d%nConsulta realizada? ",
                        cpfPac, dia, mes, ano, consultaRealizada);
                    }
                break;
                case 4:
                    while(inFile.hasNext()){
                        String cpfPront = inFile.next();
                        String sintomas = inFile.nextLine();
                        String diag = inFile.nextLine();
                    
                        System.out.printf("CPF do paciente: %s%nSintomas: %s%nDagnóstico: %s%n",
                        cpfPront, sintomas, diag);
                    }
                break;
            }
        }catch(InputMismatchException e) {
            System.out.println("Entrada inválida.");
        }catch(FileNotFoundException e) {
            System.err.println("Arquivo não encontrado.");
        }catch(IOException e) {
            System.err.println("Exceção de E/S");
        }
    }
}
