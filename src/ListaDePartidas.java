public class ListaDePartidas {
    private Partida[] lista;
    int partidas;

    ListaDePartidas(int rodadas, int cadastros){
        lista = new Partida[rodadas*cadastros];
    }

    public void setPartida(Partida jogo){
        lista[partidas] = jogo;
        partidas++;
    }
    public String getPartida(String timeA, String timeB, String date){
        Partida aux = null;
        for (Partida jogo: lista
             ) {
            if(timeA.equals(jogo.getTimeA()) && timeB.equals(jogo.getTimeB()) && date.equals(jogo.getDate())) aux = jogo;;
            return aux.toString();
        }
        return null;
    }
}
