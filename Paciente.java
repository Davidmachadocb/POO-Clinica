//import javax.xml.crypto.Data;
/**
 * A classe Paciente encapsula os dados necessários para o cadastro de um paciente.
 * Pelo fato da classe Paciente extender a classe abstrata Pessoa, Paciente contém os atributos
 * e métodos desta última
 * @author David Machado
 * @version 1.0
 */
public class Paciente extends Pessoa{
 
    private String cpf;
    private Data dataNasc;
    private char sexo;
    private String naturalidade;

    /**
     * Construtor da classe Paciente. Inicializa os atributos com os dados passados pelo usuário
     * @param nome o nome passado pelo usuário
     * @param endereco o endereco passado pelo usuário
     * @param numTel o número de contato passado pelo usuário
     * @param cpf o CPF passado pelo usuário
     * @param dataNasc a data de nascimento passado pelo usuário
     * @param sexo o sexo passado pelo usuário
     * @param natu a naturalidade passado pelo usuário
     */
    Paciente(String nome, String endereco, String numTel, String cpf, Data dataNasc, char sexo, String natu){
        super(nome, endereco, numTel);
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.sexo = sexo;
        this.naturalidade = natu;
    }

    /**
     * Getter do atributo cpf
     * @return o dado do CPF da instância
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Getter do atributo dataNasc
     * @return a data de nascimento passada na instância
     */
    public Data getDataNasc() {
        return dataNasc;
    }

    /**
     * Getter do atributo naturalidade
     * @return o dado da naturalidade passado na instância
     */
    public String getNaturalidade() {
        return naturalidade;
    }

    /**
     * Getter do atributo CPF
     * @return o dado do cpf passado na instância
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * Setter do atributo cpf
     * @param cpf o novo dado do CPF
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Setter do atributo dataNasc
     * @param dataNasc a nova data de nascimento
     */
    public void setDataNasc(Data dataNasc) {
        this.dataNasc = dataNasc;
    }

    /**
     * Setter do atributo naturalidade
     * @param naturalidade a nova naturalidade
     */
    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    /**
     * Setter do atributo sexo
     * @param sexo o novo sexo
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    /**
     * Método que sobrepõe o toString() da superclasse. Fornece os dados formatados da instância de forma organizada
     * @return Uma string com os dados organizados da instância
     */
    @Override
    public String toString() {
        return super.toString() + "\nCPF: " + this.cpf + "\nData de nascimento: " + this.dataNasc.toString() +
                "\nSexo: " + this.sexo + "\nNaturalidade: " + this.naturalidade;
    }
}
