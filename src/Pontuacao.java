public class Pontuacao {
    private final String nome;
    private int pontos, jogos, vitorias, empates, derrotas ,golsPros, golsContra, saldoGols, pontosPossiveis;
    private double aproveitamento;
    Pontuacao(String aux){
        nome = aux;
        pontos = 0;
        jogos = 0;
        vitorias = 0;
        empates = 0;
        derrotas = 0;
        golsPros = 0;
        golsContra = 0;
        saldoGols = 0;
        pontosPossiveis = 0;
        aproveitamento = 0.0;
    }
    public void setPontos() {
        this.pontos = vitorias*3 + empates;
    }
    public void setJogos() {
        this.jogos++ ;
    }
    public void setVitorias() {
        this.vitorias++;
    }
    public void setEmpates() {
        this.empates++;
    }
    public void setDerrotas() {
        this.derrotas++;
    }
    public void setGolsPros(int golsPros) {
        this.golsPros += golsPros;
    }
    public void setGolsContra(int golsContra) {
        this.golsContra += golsContra;
    }
    public void setSaldoGols() {

        if(golsPros - golsContra < 0){
            this.saldoGols = 0; return;
        }
        this.saldoGols = golsPros - golsContra;


    }
    public void setPontosPossiveis() {
        this.pontosPossiveis = jogos*3;
    }
    public void setAproveitamento() {
        if (pontosPossiveis == 0) this.aproveitamento = 0;
        else this.aproveitamento = (double)pontos/(double)pontosPossiveis*100;
    }
    public String getNome() {
        return nome;
    }
    public int getPontos() {
        return pontos;
    }
    public int getJogos() {
        return jogos;
    }
    public int getVitorias() {
        return vitorias;
    }
    public int getEmpates() {
        return empates;
    }
    public int getDerrotas() {
        return derrotas;
    }
    public int getGolsPros() {
        return golsPros;
    }
    public int getGolsContra() {
        return golsContra;
    }
    public int getSaldoGols() {
        return saldoGols;
    }
    public int getPontosPossiveis() {
        return pontosPossiveis;
    }
    public String getAproveitamento() {
        return aproveitamento + "%";
    }
    @Override
    public String toString() {
        return "Pontuação{" +
                "nome=" + nome +
                ", Pontos=" + pontos +
                ", Jogos=" + jogos +
                ", Vitórias=" + vitorias +
                ", Empates=" + empates +
                ", Derrotas=" + derrotas +
                ", Gols Pros=" + golsPros +
                ", Gols Contra=" + golsContra +
                ", Saldo de Gols=" + saldoGols +
                ", Pontos Possiveis=" + pontosPossiveis +
                ", Aproveitamento=" + aproveitamento + "%" +
                '}';
    }
}
