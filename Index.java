import java.util.Scanner;
import java.util.Random;

public class Index {

    public static void main(String[] args) {
         TicTacToe();
    }

    private static void TicTacToe() {
    Scanner Scanner = new Scanner(System.in);
      
    // create a board TicTacToe;{
    char [][] board = {{' ' , ' ', ' '},
                       {' ' , ' ', ' '},
                       {' ' , ' ' , ' '}};

    printboard(board);
    while (true) {
        Playermove(Scanner , board);
        if (GameFinished(board)) {
            break;
        }
        GetAiplay(board);
        if (GameFinished(board)) {
            break;
        }

        printboard(board);
    }

    

    }

    private static Boolean GameFinished(char [][] board) {

    // condisi Player jika menang

      if ((board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X') ||
          (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X') ||
          (board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X') ||
          
          (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X') ||
          (board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X') ||
          (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X') ||
          
          (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') ||
          (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X')) {
          printboard(board);
          System.out.println("=========================");
          System.out.println("Player Winss ");
           System.out.println("=========================");
          return true;
      }

      // condisi komputer jika menang

       if((board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O') ||
          (board[1][0] == '0' && board[1][1] == 'O' && board[1][2] == 'O') ||
          (board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O') ||
          
          (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O') ||
          (board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O') ||
          (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O') ||
          
          (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') ||
          (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O')) {
          printboard(board);
          System.out.println("=========================");
          System.out.println("Computer Winss");
          System.out.println("=========================");
          return true;
      }


      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
            if (board[i][j] == ' ') {
                return false;
            }
        }
      }

      printboard(board);
      System.out.println("Game selesaii");
      return true;
    }

    // create AI / kecerdasan buatan

    private static void GetAiplay(char [][] board) {
      Random Bot = new Random();
      int Botplay;
      while (true) {
        Botplay = Bot.nextInt(9)+1;
         if (Spacebot(board, Botplay)) {
         break;
    }
   } 
      PlayerTurn(board, Integer.toString(Botplay) , 'O');
      
    }

    // bot turn

    private static Boolean Spacebot(char [][] board , int position) {
      switch (position) {
        case 1:
            return(board[0][0] == ' ');
        
        case 2:
            return(board[0][1] == ' ');
        
        case 3:
            return(board[0][2] == ' ');
        
        case 4:
          return(board[1][0] == ' ');

        case 5:
          return(board[1][1] == ' ');
          
        case 6:
           return(board[1][2] == ' ');

        case 7:
          return(board[2][0] == ' ');
        
        case 8:
          return(board[2][1] == ' ');
        
        case 9:
          return(board[2][2] == ' ');
        default:
          return false;
      }
    }

    private static void Playermove(Scanner Scanner , char [][] board) {
      System.out.println("Masukkan angka dari (1 - 9)");
      String PlayerInput = Scanner.nextLine();

     

      PlayerTurn(board, PlayerInput, 'X');

    }

    private static void PlayerTurn(char[][] board, String PlayerInput , char Symbol) {
         // create a situation to player tictactoe

        switch (PlayerInput) {
            case "1":
                board[0][0] = Symbol;
                break;
            
            case "2":
                board[0][1] = Symbol;
                break;

            case "3":
                board[0][2] = Symbol;
                break;

             case "4":
                board[1][0] = Symbol;
                break;

             case "5":
                board[1][1] = Symbol;
                break;

             case "6":
                board[1][2] = Symbol;
                break;

             case "7":
                board[2][0] = Symbol;
                break;
            
            case "8":
                board[2][1] = Symbol;
                break;
            
            case "9":
                board[2][2] = Symbol;
                break;
          
            default:
                System.out.println("Angka yang dimasukkan tidak sesuai");
                break;
          }
    }

    private static void printboard(char[][] board) {
        System.out.println(board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("_ + _ + _");
        System.out.println(board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("_ + _ + _");
        System.out.println(board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }
}