import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TTT ttt = getPlayers(sc);
        Symbols winner = Symbols.Empty;

        while (winner==Symbols.Empty){
            ttt.drawBoard();
            System.out.println(ttt.turn.name+" diz X e Y, para jogar "+ttt.turn.playerSymbol);
            int x = Integer.parseInt(sc.nextLine());
            int y = Integer.parseInt(sc.nextLine());
            boolean result = ttt.makeMove(x,y);
            if(!result){
                System.out.println("Nao podes jogar ai");
            }
            winner = ttt.VictoryCondition();
            if(ttt.boardIsFull()){
                break;
            }
        }
        ttt.drawBoard();
        if(winner == Symbols.Empty){
            System.out.println("Foi um empate!!!!!");
        } else{
            System.out.println("Parabens jogador "+ ttt.turn.name+" ganhaste!!!!");
        }


    }
    public static TTT getPlayers(Scanner sc){
        System.out.println("Diz-me o teu nome player X");
        String player1 = sc.nextLine();

        System.out.println("Diz-me o teu nome player O");
        String player2 = sc.nextLine();

        return new TTT(player1,player2);
    }

}