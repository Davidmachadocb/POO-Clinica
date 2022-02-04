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

        String reg = consMark.getCrmDoc();

        if(!(this.consultas.containsKey(reg))){
            this.consultas.put(reg, new ArrayList<Consulta>());
        }

        ArrayList<Consulta> med_consultas = this.consultas.get(reg);

        for(Consulta aux : med_consultas){
            if(Integer.compare(consMark.getDataOcur().getAno(), aux.getDataOcur().getAno()) == 0){
                if(Integer.compare(consMark.getDataOcur().getMes(), aux.getDataOcur().getMes()) == 0){
                    if(Integer.compare(consMark.getDataOcur().getDia(), aux.getDataOcur().getDia()) == 0){
                        if(Integer.compare(consMark.getHoraCon().getHora(), aux.getHoraCon().getHora()) == 0 && 
                        Integer.compare(consMark.getHoraCon().getMin(), aux.getHoraCon().getMin()) == 0){
                            System.out.println("Horario já reservado!");
                            return false;
                        }
                    }
                }
            }
        }

        this.consultas.get(reg).add(consMark);

        return true;

    }

    public Paciente Pesqpaciente(String cpf){

        if(this.pacientes.containsKey(cpf)){
            return this.pacientes.get(cpf);
        }
        return null;
    }

    public Clinico pesqClinico(String registro){

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

    public boolean cancelarConsulta(String cpfPac, String reg_esp){
        ArrayList<Consulta> esp_consulta = this.consultas.get(reg_esp);

        for(Consulta aux : esp_consulta){
            if(aux.getCpf_paciente() == cpfPac){
                this.consultas.get(reg_esp).remove(aux);
                return true;
            }
        }

        System.out.println("Consullta não encontrada");
        return false;
    }

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

        if(this.clinicos.containsKey(reg)){
            this.clinicos.remove(reg);
            System.out.println("Clinico removido.");
            return true;
        }
        System.out.println("Clinico não encontrado");
        return false;
    }
    
    public boolean addProntuario(Prontuario p){

        String cpf = p.getCpf();

        if(!(this.consultas.containsKey(cpf))){
            this.consultas.put(cpf, new ArrayList<Consulta>());
        }

        this.prontuarios.get(cpf).add(p);

        return true;
    }

    public boolean delProntuario(String cpfPac){
        
        if(this.prontuarios.containsKey(cpfPac)){
            this.prontuarios.remove(cpfPac);
            return true;
        }

        System.out.println("Prontuario não encontrado");
        return false;
    }
}
