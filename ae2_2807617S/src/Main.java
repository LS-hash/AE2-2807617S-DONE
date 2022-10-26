import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(" ");
        System.out.println("INSTRUCTIONS:");
        System.out.println("There is only one board, you are both trying to get the most points by sinking as many ships as possible. There are 6 ships in the game.");
        System.out.println("Their coordinates are printed below, but please don't look at them :') ");
        System.out.println(" ");
        int allShipNum = LargeBattleship.getTotalNum()
                + MediumBattleship.getTotalNum()
                + SmallBattleship.getTotalNum();
        Scanner sc = new Scanner(System.in);
        Board board = new Board();
        Square[][] s = board.generateFixedBoard();
        board.generateRandomBattleShips(s);
        System.out.println("please print PLAYER 1 name:");
        Player player1 = new Player(board, sc.nextLine());
        System.out.println("please print PLAYER 2 name:");
        Player player2 = new Player(board, sc.nextLine());

        boolean finish1Flag = false;
        boolean finish2Flag = false;
        int round = 1;
        while (!finish1Flag && !finish2Flag) {
            System.out.println("==================================================");
            System.out.printf("round:%d \n", round++);
            board.printBoard(s);
            finish1Flag = player1.takeTurnMethod(board, s, player1);
            finish2Flag = player2.takeTurnMethod(board, s, player2);
            System.out.printf("%d ships have been sunk, %d left in the game \n", allShipNum - board.getShipNums(), board.getShipNums());
            System.out.println("==================================================");
        }
        System.out.printf("Game Over...  %s ", player1.getScore() >= player2.getScore() ?
                (player1.getScore() > player2.getScore() ? player1.getName() + "You win!" : " it is a draw.") : player2.getName() + " You win!");

    }
}