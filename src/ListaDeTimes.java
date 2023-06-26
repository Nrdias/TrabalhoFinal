public class ListaDeTimes {
    private Time[] lista;
    private String campeonato;
    private int timesCadastrados;
    private int MAX;
    public ListaDeTimes(String nome, int quantidade){
        campeonato = nome;
        lista = new Time[quantidade];
        timesCadastrados = 0;
        MAX = quantidade;
    }
    public String adicionaTime(String time){
        if(timesCadastrados == lista.length) return "Limite atingido!";
        Time aux = new Time(time);
        lista[timesCadastrados] = aux;
        timesCadastrados++;
        return "Time Cadastrado!";
    }
    public boolean consultaTime(String time){
        for (int i = 0; i < timesCadastrados; i++){
            if(lista[i].getNome().equals(time)) return true;
        }
        return false;
    }
    public String getNome(int posicao){
        return lista[posicao].getNome();
    }
    public int getTimesCadastrados(){
        return timesCadastrados;
    }
    public String getCampeonato(){
        return campeonato;
    }
    public int getMAX() {
        return MAX;
    }
    @Override
    public String toString() {
        String listagem = "Campeonato: " + campeonato;
        for(int i = 0; i < timesCadastrados; i++)
            listagem += "\ntime: " + lista[i].getNome();
        return listagem;
    }
}
