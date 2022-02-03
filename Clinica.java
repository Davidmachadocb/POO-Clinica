import java.util.HashMap;
import java.util.ArrayList;

public class Clinica {
    private HashMap<String, Clinico> clinicos;
    private HashMap<String, Paciente> pacientes;
    private HashMap<String, ArrayList<Consulta>> consultas;
    private HashMap<String, ArrayList<Prontuario>> prontuarios;

    public Clinica(){
        
        this.clinicos = new HashMap<>();
        this.pacientes = new HashMap<>();
        this.consultas = new HashMap<>();
        this.prontuarios = new HashMap<>();

    }

    public boolean addPaciente(Paciente newp){

        String new_cpf = newp.getCpf();

        if(this.pacientes.containsKey(new_cpf)){
            System.out.println("Paciente já cadastrado.");
            return false;
        }
        this.pacientes.put(new_cpf, newp);
        return true;

    }

    public boolean addClinico(Clinico newc){
        String new_registro = newc.getRegistro();

        if(this.pacientes.containsKey(new_registro)){
            System.out.println("Clinico já cadastrado.");
            return false;
        }
        this.clinicos.put(new_registro, newc);
        ArrayList<Consulta> clinico_Consultas = new ArrayList<Consulta>();
        this.consultas.put(new_registro, clinico_Consultas);
        return true;
    }

    public boolean addConsulta(Consulta consMark){

        this.consultas.get(consMark.getCrmDoc()).add(consMark);
        return true;

    }

    public Paciente Pesqpaciente(String cpf){

        if(this.pacientes.containsKey(cpf)){
            return this.pacientes.get(cpf);
        }

        return null;
    }

    public Clinico Pesqclinico(String registro){

        if(this.clinicos.containsKey(registro)){
            return this.clinicos.get(registro);
        }

        return null;
    }

    public HashMap<String, Clinico> getClinicos() {
        return clinicos;
    }

    public HashMap<String, Paciente> getPacientes() {
        return pacientes;
    }

    public HashMap<String, ArrayList<Consulta>> getConsultas() {
        return consultas;
    }

    public void setClinicos(HashMap<String, Clinico> clinicos) {
        this.clinicos = clinicos;
    }

    public void setPacientes(HashMap<String, Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    /*public boolean cancelarConsulta(String cpfPac){

    }*/

    public boolean delPaciente(String cpfPac){

        if(this.pacientes.containsKey(cpfPac)){
            this.pacientes.remove(cpfPac);
            System.out.println("Paciente removido.");
            return true;
        }
        System.out.println("Paciente não encontrado");
        return false;
    }

    public boolean delClinico(String reg){

        if(this.pacientes.containsKey(reg)){
            this.clinicos.remove(reg);
            System.out.println("Clinico removido.");
            return true;
        }
        System.out.println("Clinico não encontrado");
        return false;
    }
    
    //public boolean delProntuario(String cpfPac){}
}
