import java.util.Scanner;

public class TabelaApp {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Bem vindo! \n Qual o campeonato você deseja simular?");
        String campeonato = in.next();
        System.out.println("Perfeito, e quantos times irão jogar?");
        int quantidade = in.nextInt();
        ListaDeTimes listaTimes = new ListaDeTimes(campeonato, quantidade);

        for(int i = 0; i < quantidade; i++){
            System.out.print("Informe o nome do time a ser cadastrado no campeonato: ");
            String aux = in.next();
            listaTimes.adicionaTime(aux);
        }
        TabelaDePontuacao tabela = new TabelaDePontuacao(listaTimes);
        System.out.print("Informe o número de rodadas: ");
        int rodadas = in.nextInt();
        ListaDePartidas partidas = new ListaDePartidas(listaTimes.getTimesCadastrados(), rodadas);

        int choice = 0;
        do{
            System.out.println("""
                    O que deseja fazer?
                    
                    ###MENU###
                    0 - Encerrar o programa
                    1 - Consultar um time cadastrado
                    2 - Consultar a lista de times cadastrados
                    3 - Consultar a pontuação de um time
                    4 - Consultar a tabela de pontuação
                    5 - Cadastrar uma partida
                    6 - Consultar a lista de partidas
                    
                    """);

            choice = in.nextInt();
            String time, timeA, timeB, date;
            String r;
            int golsA, golsB;

            switch (choice){
                case 1:
                    System.out.print("Informe o nome do time: ");
                    time = in.next();
                    r = (listaTimes.consultaTime(time))? "Time cadastrado":"Time não cadastrado";
                    System.out.println(r);
                    break;
                case 2:
                    r = listaTimes.toString();
                    System.out.println(r);
                    break;
                case 3:
                    System.out.print("Informe o nome do time: ");
                    time = in.next();
                    r = tabela.getPontos(time);
                    System.out.println(r);
                    break;
                case 4:
                    r = tabela.toString(listaTimes.getCampeonato());
                    System.out.println(r);
                    break;
                case 5:
                    System.out.print("Informe a data da partida: ");
                    date = in.next();
                    System.out.print("Informe o time A: ");
                    timeA = in.next();
                    System.out.print("Informe o time B: ");
                    timeB = in.next();
                    System.out.print("Quantos Gols o time A fez? ");
                    golsA = in.nextInt();
                    System.out.print("Quantos Gols o time B fez? ");
                    golsB = in.nextInt();
                    Partida jogo = new Partida(timeA, timeB, date, golsA, golsB);
                    partidas.setPartida(jogo);
                    calculaPartida(tabela, jogo);
                    break;
                case 6:
                    System.out.print("Informe a data da partida: ");
                    date = in.next();
                    System.out.print("Informe o time A: ");
                    timeA = in.next();
                    System.out.print("Informe o time B: ");
                    timeB = in.next();
                    System.out.println(partidas.getPartida(timeA,timeB,date));
            }

        }while(choice != 0);
    }
    public static void calculaPartida(TabelaDePontuacao tabela, Partida jogo){
        String casa = jogo.getTimeA();
        String visitante = jogo.getTimeB();
        Pontuacao timeCasa = tabela.getTime(casa);
        Pontuacao timeVisitante = tabela.getTime(visitante);

        if((jogo.getGolsA()) > (jogo.getGolsB())) {
            timeCasa.setVitorias(1);
            timeVisitante.setDerrotas(1);
        };
        if((jogo.getGolsA()) < (jogo.getGolsB())) {
            timeVisitante.setVitorias(1);
            timeCasa.setDerrotas(1);
        };
        if((jogo.getGolsA()) == (jogo.getGolsB())) {
            timeCasa.setEmpates(1);
            timeVisitante.setEmpates(1);
        }
        timeCasa.setGolsPros(jogo.getGolsA());
        timeCasa.setGolsContra(jogo.getGolsB());
        timeVisitante.setGolsPros(jogo.getGolsB());
        timeVisitante.setGolsContra(jogo.getGolsA());

        timeCasa.setJogos(1);
        timeVisitante.setJogos(1);
        timeCasa.setPontos();
        timeVisitante.setPontos();
        timeCasa.setPontosPossiveis();
        timeVisitante.setPontosPossiveis();
        timeCasa.setAproveitamento();
        timeVisitante.setAproveitamento();

        tabela.setPontos(timeCasa);
        tabela.setPontos(timeVisitante);

    }

}
