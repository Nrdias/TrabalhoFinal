import java.util.Scanner;

public class TabelaApp {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ListaDeTimes times = inicializarCampeonato();
        TabelaDePontuacao tabela = new TabelaDePontuacao(times);
        ListaDePartidas partidas = inicalizarRodadas(times);

        int choice = 0;
        do{
            System.out.println("""
                    ###MENU###
                    
                    0 - Encerrar o programa
                    1 - Adicionar um time
                    2 - Consultar se o time está cadastrado
                    3 - Consultar a lista de times cadastrados
                    4 - Consultar a pontuação de um time
                    5 - Consultar a tabela de pontuação
                    6 - Cadastrar uma partida
                    7 - Consultar a lista de partidas
                    8 - Consultar tabela de partidas
                    9 - Encerra a tabela
                    """);

            choice = in.nextInt();
            String time, timeA, timeB, date, r;
            int id, golsA, golsB;

            switch (choice){
                case 1:
                    System.out.print("Informe o nome do time a ser cadastrado: ");
                    time = in.next();
                    if(times.consultaTime(time)){
                        System.out.println("Time já cadastro!");
                        break;
                    }
                    System.out.println(times.adicionaTime(time));
                    System.out.println(tabela.adicionaTime(time));
                    partidas.setMax(times);
                    break;

                case 2:
                    System.out.print("Informe o nome do time: ");
                    time = in.next();
                    r = (times.consultaTime(time))? "Time cadastrado" : "Time não cadastrado";
                    System.out.println(r);
                    break;
                case 3:
                    System.out.println(times.toString());
                    break;
                case 4:
                    System.out.print("Informe o nome do time: ");
                    time = in.next();
                    r = tabela.getPontos(time);
                    System.out.println(r);
                    break;
                case 5:
                    r = tabela.toString(times.getCampeonato());
                    System.out.println(r);
                    break;
                case 6:
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
                    Partida jogo = new Partida(partidas.getPartidas(),timeA, timeB, date, golsA, golsB);
                    partidas.setPartida(jogo);
                    System.out.println(calculaPartida(partidas, tabela, jogo));
                    if(partidas.getPartidas() == partidas.getMax()){
                        System.out.println(tabela.toString(times.getCampeonato()));
                        return;
                    }
                    break;
                case 7:
                    System.out.print("Informe o ID da partida: ");
                    id = in.nextInt();
                    r = partidas.getJogos(id);
                    System.out.println(r);
                    break;
                case 8:
                    partidas.ordenaPartidas();
                    System.out.println(partidas.toString());
                case 9:
                    System.out.println("Encerrando o Campeonato...");
                    System.out.println(tabela.toString(times.getCampeonato()));
                    return;
            }
            }while(choice != 0);
    }

    public static ListaDeTimes inicializarCampeonato(){
        Scanner in = new Scanner(System.in);

        System.out.println("Bem vindo! \n Qual o campeonato você deseja simular?");
        String campeonato = in.next();
        System.out.println("Perfeito, e quantos times irão jogar?");
        int quantidade = in.nextInt();
        ListaDeTimes listaTimes = new ListaDeTimes(campeonato, quantidade);
        for(int i = 0; i < 2; i++){
            System.out.print("Informe o nome do time a ser cadastrado no campeonato: ");
            String aux = in.next();
            listaTimes.adicionaTime(aux);
        }
        return listaTimes;
    }

    public static ListaDePartidas inicalizarRodadas(ListaDeTimes t){
        Scanner in = new Scanner(System.in);
        System.out.print("Informe o número de rodadas: ");
        int rodadas = in.nextInt();
        ListaDePartidas partidas = new ListaDePartidas(rodadas);
        return partidas;
    }

    public static String calculaPartida(ListaDePartidas partidas, TabelaDePontuacao tabela, Partida jogo){
        if(partidas.getPartidas() == partidas.getMax()) return "Limite Atingido!";
        String casa = jogo.getTimeA();
        String visitante = jogo.getTimeB();
        Pontuacao timeCasa = tabela.getTime(casa);
        Pontuacao timeVisitante = tabela.getTime(visitante);

        if((jogo.getGolsA()) > (jogo.getGolsB())) {
            timeCasa.setVitorias();
            timeVisitante.setDerrotas();
        };
        if((jogo.getGolsA()) < (jogo.getGolsB())) {
            timeVisitante.setVitorias();
            timeCasa.setDerrotas();
        };
        if((jogo.getGolsA()) == (jogo.getGolsB())) {
            timeCasa.setEmpates();
            timeVisitante.setEmpates();
        }
        timeCasa.setGolsPros(jogo.getGolsA());
        timeCasa.setGolsContra(jogo.getGolsB());
        timeVisitante.setGolsPros(jogo.getGolsB());
        timeVisitante.setGolsContra(jogo.getGolsA());

        timeCasa.setJogos();
        timeVisitante.setJogos();
        timeCasa.setPontos();
        timeVisitante.setPontos();
        timeCasa.setPontosPossiveis();
        timeVisitante.setPontosPossiveis();
        timeCasa.setAproveitamento();
        timeVisitante.setAproveitamento();
        timeCasa.setSaldoGols();
        timeVisitante.setSaldoGols();

        tabela.setPontos(timeCasa);
        tabela.setPontos(timeVisitante);
        tabela.ordenaTabela();
        return "Jogo Cadastrado!";
    }

}
