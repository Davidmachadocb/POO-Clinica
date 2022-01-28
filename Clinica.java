import java.util.List;
import java.util.ArrayList;

class Clinica {
    private List<Pessoa> listPessoa;
    private List<Prontuario> prontuarios;
    private List<Consulta> consultas;

    Clinica(){
        listPessoa = new ArrayList<Pessoa>();
        prontuarios = new ArrayList<Prontuario>();
        consultas = new ArrayList<Contulta>();
    }

    public boolean addPaciente(Paciente newp){}

    public boolean addClinico(Clinico newc){}

    public boolean addConsulta(Consulta consMark){}

    public void getPessoas(){
        return this.listPessoa;
    }

    public void getConsultas(){
        return this.consultas;
    }

    public void getProntuarios(){
        return this.prontuarios;
    }

    public Pessoa setPessoa(){}

    public Prontuario setPront(){}

    public Consulta setConsulta(){}

    public boolean cancelarConsulta(String cpfPac){}

    public boolean delPaciente(String cpfPac){}

    public boolean delClinico(String reg){}
    
    public boolean delProntuario(String cpfPac){}
}
