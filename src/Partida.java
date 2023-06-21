public class Partida {
    private String timeA, timeB;
    private String date;
    private int golsA,golsB;

    public Partida(String teamA, String teamB, String d, int golsA, int golsB){
        this.timeA = teamA;
        this.timeB = teamB;
        this.date = d;
        this.golsA = golsA;
        this.golsB = golsB;
    }

    public String getTimeA() {
        return timeA;
    }

    public String getTimeB() {
        return timeB;
    }

    public String getDate() {
        return date;
    }

    public int getGolsA() {
        return golsA;
    }

    public int getGolsB() {
        return golsB;
    }

    public String toString(){
        String aux = "Dados da Partida\n" +
                "Data: " + date +
                " |Casa: " + timeA +
                " Gols: " + golsA +
                " |Visitante: " + timeB +
                " Gols: " + golsB;
        return aux;
    }

}
