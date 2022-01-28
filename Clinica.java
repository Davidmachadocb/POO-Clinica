import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Clinica {
    private HashMap<String, Clinico> clinicos;
    private HashMap<String, Paciente> pacientes;

    public Clinica(){
        this.clinicos = new HashMap<>();
        this.pacientes = new HashMap<>();
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
        return true;
    }

    public boolean addConsulta(Consulta consMark){

    }

    public HashMap<String, Clinico> getClinicos() {
        return clinicos;
    }

    public HashMap<String, Paciente> getPacientes() {
        return pacientes;
    }

    public void setClinicos(HashMap<String, Clinico> clinicos) {
        this.clinicos = clinicos;
    }

    public void setPacientes(HashMap<String, Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public boolean cancelarConsulta(String cpfPac){}

    public boolean delPaciente(String cpfPac){}

    public boolean delClinico(String reg){}
    
    public boolean delProntuario(String cpfPac){}
}
