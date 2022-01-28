/**
 * A classe abstrata Pessoa encapsula os dados comuns das classes clínico e paciente
 * @author Ítalo Moraes
 * @version 1.0
 */
abstract class Pessoa{
    private String nomeCompleto;
    private String endereco;
    private String numTelefone;

    /**
     * Construtor da classe Pessoa. Inicializa os atributos com as strings passadas pelo usuário
     * @param nome o nome completo a ser encapsulado por essa instância
     * @param endereco o nome endereço a ser encapsulado por essa instância
     * @param numTelefone o número para contato a ser encapsulado por essa instância
     */
    Pessoa(String nome, String endereco, String numTelefone){
        this.nomeCompleto = nome;
        this.endereco = endereco;
        this.numTelefone = numTelefone;
    }

    /**
     * Getter do atributo nomeCompleto
     * @return o nome completo que consta para a instância do objeto
     */
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    /**
     * Getter do atributo endereco
     * @return o endereço passado para a instância do objeto
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Getter do atributo numTelefone
     * @return o número de telefone passado para a instância do objeto
     */
    public String getNumTelefone() {
        return numTelefone;
    }

    /**
     * Setter do atributo nomeCompleto
     * @param nomeCompleto o novo nome completo a ser passado para o atributo nomeCompleto da instância
     */
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    /**
     * Setter do atributo endereco
     * @param endereco o novo endereco a ser passado para o atributo endereco da instância
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Setter do atributo numTelefone
     * @param numTelefone o novo número de telefone a ser passado para o atributo numTelefone da instância
     */
    public void setNumTelefone(String numTelefone) {
        this.numTelefone = numTelefone;
    }

    /**
     * Método que sobrepõe o toString() da classe Object. Fornece os dados da instância de forma organizada
     * @return Uma string com os dados organizados da instância
     */
    @Override
    public String toString() {
        String str = "Nome Completo: " + this.nomeCompleto + "\nEndereço: " + this.endereco +
                     "\nNúmero para contato: " + this.numTelefone;
        return str;
    }
}