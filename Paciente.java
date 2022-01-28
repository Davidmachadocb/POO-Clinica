import javax.xml.crypto.Data;

public class Paciente extends Pessoa{
 
    private String cpf;
    private Data dataNasc;
    private char sexo;
    private String naturalidade;

    public String getCpf() {
        return cpf;
    }

    public Data getDataNasc() {
        return dataNasc;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNasc(Data dataNasc) {
        this.dataNasc = dataNasc;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

}