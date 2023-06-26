public class ListaDePartidas {
    private Partida[] lista;
    private int partidas;
    private int max;
    ListaDePartidas(int rodadas){
        lista = new Partida[rodadas];
        partidas = 0;
        max = rodadas;
    }
    public int getPartidas() {
        return partidas;
    }
    public int getMax() {
        return max;
    }
    public void setMax(ListaDeTimes t){
        int aux = t.getTimesCadastrados();
        max = aux*aux;
    }
    public String getJogos(int id) {
        for(int i = 0; i < lista.length; i++){
            if(lista[i] != null){
                if(lista[i].getId() == id) return lista[i].toString();
            }
        }
        return "Partida não encontrada";
    }
    public void setPartida(Partida jogo){
        lista[partidas] = jogo;
        partidas++;
    }
    public void ordenaPartidas(){
        for (int i = 0; i < lista.length - 1; i++) {
            for (int j = 0; j < lista.length - i - 1; j++) {
                if (lista[j] != null && lista[j + 1] != null && lista[j].getDate() > lista[j + 1].getDate()) {
                    Partida aux = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = aux;
                }
            }
        }
    }
}
