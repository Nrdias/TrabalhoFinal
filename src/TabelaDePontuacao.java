import java.util.Arrays;

public class TabelaDePontuacao {
    private Pontuacao[] lista;
    private int pontuacaoCadastrada;
    public TabelaDePontuacao(ListaDeTimes times){
        this.lista = new Pontuacao[times.getMAX()];
        pontuacaoCadastrada = 0;
        for(int i = 0; i < times.getTimesCadastrados();i++){
            lista[i] = new Pontuacao(times.getNome(i));
            pontuacaoCadastrada++;
        }
    }
    public String adicionaTime(String time){
        if(pontuacaoCadastrada == this.lista.length) return "Limite Atingido!";
        Pontuacao aux = new Pontuacao(time);
        lista[pontuacaoCadastrada] = aux;
        pontuacaoCadastrada++;
        return "Time Cadastrado na Tabela";
    }
    public void setPontos(Pontuacao time){
        String aux = time.getNome();
        for(int i = 0; i < pontuacaoCadastrada; i++){
            if(aux.equals(lista[i].getNome())) {
                lista[i] = time;
            }
        }
    }
    public Pontuacao getTime(String time){
        for(int i = 0; i < lista.length; i++){
        String aux = lista[i].getNome();
        if(time.equals(aux)) return lista[i];
        }
        return null;
    }
    public String getPontos(String time){

        for(int i = 0; i < pontuacaoCadastrada; i++){
            if(lista[i].getNome().equals(time)) return lista[i].toString();
        }
        return "Não encontrado";
    }
    public void ordenaTabela() {
        for (int i = 0; i < lista.length - 1; i++) {
            for (int j = 0; j < lista.length - i - 1; j++) {

                if (lista[j] != null && lista[j + 1] != null && lista[j].getPontos() < lista[j + 1].getPontos()) {
                    Pontuacao aux = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = aux;
                } else if (lista[j] != null && lista[j + 1] != null && lista[j].getVitorias() < lista[j + 1].getVitorias()) {
                    Pontuacao aux = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = aux;
                } else if (lista[j] != null && lista[j + 1] != null && lista[j].getSaldoGols() < lista[j + 1].getSaldoGols()) {
                    Pontuacao aux = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = aux;
                }
            }
        }
    }
    public String toString(String campeonato) {
        String aux = "Campeonato: "+ campeonato + "\nTimes cadastrados: \n";
        int position = 1;
        for(int i = 0; i < pontuacaoCadastrada; i++){
                aux += "\n" +
                        "[Posição " + position +
                        " |Time: " + lista[i].getNome() +
                        " |P: " + lista[i].getPontos() +
                        " |J: " + lista[i].getJogos() +
                        " |V: " + lista[i].getVitorias() +
                        " |E: " + lista[i].getEmpates() +
                        " |D: " + lista[i].getDerrotas() +
                        " |GP: " + lista[i].getGolsPros() +
                        " |GC: " + lista[i].getGolsContra() +
                        " |SG: " + lista[i].getSaldoGols() +
                        " |Aproveitamento: " + lista[i].getAproveitamento() +
                        "]";
                position++;
            }
        return aux;
    }
}
