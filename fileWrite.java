import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Locale;

class fileWrite{
    public static void writeFilePaciente(HashMap<String, Paciente> pacientes){
        Locale.setDefault(Locale.US);
        String filePaciente = "/home/itsfrancisco/Área de Trabalho/Pacientes.txt";

        try(FileWriter fstream = new FileWriter(filePaciente, StandardCharsets.UTF_8, true);
            PrintWriter outFile = new PrintWriter(fstream, true);)
        {    
            for(String key : pacientes.keySet()){    
                String nomePac = pacientes.get(key).getNomeCompleto();

                String endPac = pacientes.get(key).getEndereco();

                String numeroTelefonePac = pacientes.get(key).getNumTelefone();

                String cpf = pacientes.get(key).getCpf();

                byte dia = pacientes.get(key).getDataNasc().getDia();
                byte mes = pacientes.get(key).getDataNasc().getMes();
                int ano = pacientes.get(key).getDataNasc().getAno();

                char sexo = pacientes.get(key).getSexo();

                String natu = pacientes.get(key).getNaturalidade();

                outFile.printf("%s%n%s%n%s%n%s%n%d %d %d%n%s%n%s%n",
                nomePac, endPac, numeroTelefonePac, cpf, dia, mes, ano, sexo, natu);
            }
        }catch(InputMismatchException e){
            System.err.println("Entrada inválida: " + e.getMessage());
        }catch(IOException e){
            System.out.println("Um erro foi detectado ao tentar abrir o arquivo: " + e.getMessage());
        }
    }

    public static void writeFileClinico(HashMap<String, Clinico> clinicos){
        Locale.setDefault(Locale.US);
        String fileClinico = "/home/itsfrancisco/Área de Trabalho/Medicos.txt";

        try(FileWriter fstream = new FileWriter(fileClinico, StandardCharsets.UTF_8, true);
            PrintWriter outFile = new PrintWriter(fstream, true);)
        {
            for(String key : clinicos.keySet()){
                
                String nomeMed = clinicos.get(key).getNomeCompleto();
                
                String endMed = clinicos.get(key).getEndereco();
                
                String numeroTelefoneMed = clinicos.get(key).getNumTelefone();
                
                String reg = clinicos.get(key).getRegistro();
                
                String spec = clinicos.get(key).getEspecialidade();

                outFile.printf("%s%n%s%n%s%n%s%n%s%n", nomeMed, endMed, numeroTelefoneMed, reg, spec);
            }
        }catch(InputMismatchException e){
            System.err.println("Entrada inválida: " + e.getMessage());
        }catch(IOException e){
            System.out.println("Um erro foi detectado ao tentar abrir o arquivo: " + e.getMessage());
        }   
    }

    public static void writeFileConsulta(HashMap<String, ArrayList<Consulta>> consultas){
        Locale.setDefault(Locale.US);
        String fileConsulta = "/home/itsfrancisco/Área de Trabalho/Consultas.txt";

        try(FileWriter fstream = new FileWriter(fileConsulta, StandardCharsets.UTF_8, true);
            PrintWriter outFile = new PrintWriter(fstream, true);)
        {
            for(String key : consultas.keySet()){
                for(int i = 0; i < consultas.get(key).size(); i++){
                    String cpfPacConsulta = consultas.get(key).get(i).getCpf_paciente();
                    
                    byte diaConsulta = consultas.get(key).get(i).getDataOcur().getDia();
                    byte mesConsulta = consultas.get(key).get(i).getDataOcur().getMes();
                    int anoConsulta = consultas.get(key).get(i).getDataOcur().getAno();
                    
                    Boolean f = consultas.get(key).get(i).getrealizada();
                    String consultaRealizada = "";
                    if(f) consultaRealizada = "Sim";
                    else consultaRealizada = "Não";

                    String crmDoc = consultas.get(key).get(i).getCrmDoc();
    
                    outFile.printf("%s%n%d %d %d%n%s%n%s%n",
                    cpfPacConsulta, diaConsulta, mesConsulta, anoConsulta, consultaRealizada, crmDoc);
                }
            }
        }catch(InputMismatchException e){
            System.err.println("Entrada inválida: " + e.getMessage());
        }catch(IOException e){
            System.out.println("Um erro foi detectado ao tentar abrir o arquivo: " + e.getMessage());
        }
    }

   public static void writeFilePront(HashMap<String, ArrayList<Prontuario>> prontuarios){
        Locale.setDefault(Locale.US);
        String fileProntuario = "/home/itsfrancisco/Área de Trabalho/Prontuarios.txt";

        try(FileWriter fstream = new FileWriter(fileProntuario, StandardCharsets.UTF_8, true);
            PrintWriter outFile = new PrintWriter(fstream, true);)
        {
            for(String key : prontuarios.keySet()){
                for(int i = 0; i < prontuarios.get(key).size(); i++){
                    String cpfPront = prontuarios.get(key).get(i).getCpf();
                    
                    String sintomas = prontuarios.get(key).get(i).getSintomas();
                    
                    String diag = prontuarios.get(key).get(i).getDiagnostico();
    
                    outFile.printf("%s%n%s%n%s%n", cpfPront, sintomas, diag);
                }
            }
        }catch(InputMismatchException e){
            System.err.println("Entrada inválida: " + e.getMessage());
        }catch(IOException e){
            System.out.println("Um erro foi detectado ao tentar abrir o arquivo: " + e.getMessage());
        }
    }
}
