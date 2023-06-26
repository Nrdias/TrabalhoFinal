public class Partida {
    private int id;
    private String timeA, timeB;
    private String date;
    private int golsA,golsB;
    public Partida(int id, String teamA, String teamB, String d, int golsA, int golsB){
        this.id = id;
        this.timeA = teamA;
        this.timeB = teamB;
        this.date = d;
        this.golsA = golsA;
        this.golsB = golsB;
    }
    public int getId() {
        return id;
    }
    public String getTimeA() {
        return timeA;
    }
    public String getTimeB() {
        return timeB;
    }
    public int getDate(){
                String data = date;
                data.replace("/","");
                int aux = Integer.parseInt(data);
                return aux;
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
