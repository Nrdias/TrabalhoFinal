public class TabelaDePontuacao {
    private Pontuacao[] times;

    public TabelaDePontuacao(ListaDeTimes lista){

        times = new Pontuacao[lista.getTimesCadastrados()];

        for(int i = 0; i < lista.getTimesCadastrados(); i++){
            times[i] = new Pontuacao(lista.getNome(i));
        }
    }

    public void setPontos(Pontuacao time){
        String aux = time.getNome();
        for(int i = 0; i < times.length; i++){
            if(times[i].getNome().equals(aux)) {
                times[i] = time;
            }
        }
    }

    public Pontuacao getTime(String time){
        for(int i = 0; i < times.length; i++){
        String aux = times[i].getNome();
        if(time.equals(aux)) return times[i];
        }
        return null;
    }




    public String getPontos(String time){
        for (Pontuacao t:times
             ) {
            if(t.getNome().equals(time)) return t.toString();
        }
        return "Não encontrado";
    }
    public String toString(String campeonato){
        String aux = "Campeonato: "+ campeonato + "\nTimes cadastrados: \n";
        int position = 1;
        for (Pontuacao time: times
             ) {

            aux += "\n" +

                    "[Posição " + position +
                    " |Time: " + time.getNome() +
                    " |P: " + time.getPontos() +
                    " |J: " + time.getPontos() +
                    " |V: " + time.getVitorias() +
                    " |E: " + time.getEmpates() +
                    " |D: "+ time.getDerrotas() +
                    " |GP: " + time.getGolsPros() +
                    " |GC: " + time.getGolsContra() +
                    " |SG: " + time.getSaldoGols() +
                    " |Aproveitamento: " + time.getAproveitamento() +
                    "]";
            position++;
        }
        return aux;
    }

}
