public class Consulta implements Comparable<Consulta> {
    
    private String cpf_paciente;
    private Data dataOcur;
    private Hora horaCon;
    private boolean realizada;
    private String crmDoc;
    
    public Consulta(String cpf, Data dataOcur, Hora horaCon, boolean realizada, String crmDoc){

        this.cpf_paciente = cpf;
        this.dataOcur = dataOcur;
        this.horaCon = horaCon;
        this.realizada = realizada;
        this.crmDoc = crmDoc;

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

    public String getCrmDoc() {
        return crmDoc;
    }

    public Hora getHoraCon() {
        return horaCon;
    }

    public void setRealizada(boolean realizada) {
        this.realizada = realizada;
    }

    public void setCpf_paciente(String cpf_paciente) {
        this.cpf_paciente = cpf_paciente;
    }

    public void setHoraCon(Hora horaCon) {
        this.horaCon = horaCon;
    }
    
    public void setDataOcur(Data dataOcur) {
        this.dataOcur = dataOcur;
    }

    public void setCrmDoc(String crmDoc) {
        this.crmDoc = crmDoc;
    }

    @Override public int compareTo(Consulta con){
        int ordering = Integer.compare(this.dataOcur.getAno(), con.dataOcur.getAno());
        if(ordering == 0){
            ordering = Integer.compare(this.dataOcur.getMes(), con.dataOcur.getMes());
            if(ordering == 0){
                ordering = Integer.compare(this.dataOcur.getDia(), con.dataOcur.getDia());
                if(ordering == 0){
                    ordering = Integer.compare(this.horaCon.getHora(), con.horaCon.getHora());
                    if(ordering == 0){
                        return Integer.compare(this.horaCon.getMin(), con.horaCon.getMin());
                    }else return ordering;
                }else return ordering;
            }else return ordering;
        }else return ordering;
    }

    @Override
    public String toString() {
    return String.format("CPF: %s\n", this.cpf_paciente) +
           "Data da consulta: " + this.dataOcur.toString() + "\n" + "Horário: " + this.horaCon.toString() + "\n" +
           String.format("Realizada? %s\nCRM médico: %s\n", this.realizada, this.crmDoc);
    }
}
