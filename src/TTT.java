import java.util.ArrayList;

public class TTT {
    Symbols[][] board = new Symbols[][]{
            {Symbols.Empty,Symbols.Empty,Symbols.Empty},
            {Symbols.Empty,Symbols.Empty,Symbols.Empty},
            {Symbols.Empty,Symbols.Empty,Symbols.Empty},
    };

    ArrayList<Player> players = new ArrayList<>();
    Player turn;


    public TTT(String player1, String player2){
        players.add(new Player(player1,Symbols.X));
        players.add(new Player(player2,Symbols.O));
        turn = players.get(0);
    }

    private void swapTurn(){
        if(turn == players.get(0)){
            turn = players.get(1);
        }else{
            turn = players.get(0);
        }
    }


    public void drawBoard(){
        System.out.println(" |-0-|-1-|-2-|");
        System.out.println("0| " + board[0][0].label + " | " + board[0][1].label + " | " + board[0][2].label + " |");
        System.out.println(" |-----------|");
        System.out.println("1| " + board[1][0].label + " | " + board[1][1].label + " | " + board[1][2].label + " |");
        System.out.println(" |-----------|");
        System.out.println("2| " + board[2][0].label + " | " + board[2][1].label + " | " + board[2][2].label + " |");
        System.out.println(" |---|---|---|");
    }

    public Symbols VictoryCondition(){
        //Verticais (3)
        if(board[0][0]==board[1][0] && board[1][0]==board[2][0] && board[0][0]!=Symbols.Empty) return board[0][0];
        if(board[0][1]==board[1][1] && board[1][1]==board[2][1] && board[0][1]!=Symbols.Empty) return board[0][1];
        if(board[0][2]==board[1][2] && board[1][2]==board[2][2] && board[0][2]!=Symbols.Empty) return board[0][2];

        //Horizontais(3)
        if(board[0][0]==board[0][1] && board[0][1]==board[0][2] && board[0][0]!=Symbols.Empty) return board[0][0];
        if(board[1][0]==board[1][1] && board[1][1]==board[1][2] && board[1][0]!=Symbols.Empty) return board[1][0];
        if(board[2][0]==board[2][1] && board[2][1]==board[2][2] && board[2][0]!=Symbols.Empty) return board[2][0];

        //Diagonais(2)
        if(board[0][0]==board[1][1] && board[1][1]==board[2][2] && board[1][1]!=Symbols.Empty) return board[1][1];
        if(board[1][0]==board[1][1] && board[1][1]==board[1][2] && board[1][1]!=Symbols.Empty) return board[1][1];

        //No win
        return Symbols.Empty;
    }

    public boolean makeMove(int x, int y) {
        if(x<=2 && x>=0 && y<=2 && y>=0 && board[x][y] == Symbols.Empty){
            board[x][y] = turn.playerSymbol;
            swapTurn();
            return true;
        }else{
            return false;
        }
    }

    public boolean boardIsFull() {
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i][j]!=Symbols.Empty) counter++;
            }
        }
        return counter==9;
    }
}
