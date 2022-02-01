public class Consulta {
    
    private String cpf_paciente;
    private Data dataOcur;
    private boolean realizada;
    
    public Consulta(String cpf, Data dataOcur, boolean realizada){

        this.cpf_paciente = cpf;
        this.dataOcur = dataOcur;
        this.realizada = realizada;

    }

    

    public String getCpf_paciente() {
        return cpf_paciente;
    }

    public Data getDataOcur() {
        return dataOcur;
    }

    public Boolean getrealizada() {
        return realizada;
    }

    public void setRealizada(boolean realizada) {
        this.realizada = realizada;
    }

    public void setCpf_paciente(String cpf_paciente) {
        this.cpf_paciente = cpf_paciente;
    }
    
    public void setDataOcur(Data dataOcur) {
        this.dataOcur = dataOcur;
    }

    @Override
    public String toString() {
        return String.format("CPF: %s\n", this.cpf_paciente) + this.dataOcur.toString() + String.format("Realizada: %b\n", this.realizada);
    }

}
