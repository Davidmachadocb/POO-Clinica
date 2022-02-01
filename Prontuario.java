public class Prontuario {
    
    private String cpf;
    private String sintomas;
    private String diagnostico;

    public String getCpf() {
        return cpf;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    @Override
    public String toString() {
        
        return String.format("CPF: %s\nSintomas: %s\ndiagnostico: %s\n", this.cpf, this.sintomas, this.diagnostico);
    }

}
