public class ListaDeTimes {

    private Time[] lista;
    private String campeonato;
    private int timesCadastrados;

    public ListaDeTimes(String nome, int quantidade){
        campeonato = nome;
        lista = new Time[quantidade];
        timesCadastrados = 0;
    }
    public boolean adicionaTime(String time){
        if(timesCadastrados == lista.length) return false;
        Time aux = new Time(time);
        lista[timesCadastrados] = aux;
        timesCadastrados++;
        return true;
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

    @Override
    public String toString() {
        String listagem = "Campeonato: " + campeonato;
        for (Time time: lista
             ) {
            listagem += "\ntime: " + time.getNome();
        }
        return listagem;
    }
}
