package com.kodilla.rps;

import com.kodilla.rps.elements.Figure;
import com.kodilla.rps.elements.Game;
import com.kodilla.rps.elements.Player;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class rpsTestSuite {
    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Tests begin" + "\n");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @AfterEach
    public void afterEach() {System.out.println("Test #" + testCounter + " complete \n");}

    @AfterAll
    public static void afterAll() {
        System.out.println("Test finished");
    }

    @Nested
    @DisplayName("Tests for Player class")
    class PlayerFunctionTests {

        @Test
        void testForMoveIntepretation() {
            //Given
            Player player1 = new Player("User1");
            Player player2 = new Player("User2");
            Player player3 = new Player("User3");

            //When
            player1.choseActualMove(1);
            player2.choseActualMove(2);
            player3.choseActualMove(3);

            //Then
            assertEquals(Figure.stone, player1.getActualMove());
            assertEquals(Figure.paper, player2.getActualMove());
            assertEquals(Figure.scissors, player3.getActualMove());
        }

        @Test
        void testForPointsFunction() {
            //Given
            Player player1 = new Player("User1");

            //When
            player1.addPoint();
            player1.addPoint();
            player1.addPoint();
            int pointsAfterAdd = player1.getPoints();

            player1.cleanPoints();
            int pointsAfterClean = player1.getPoints();

            //Then
            assertEquals(3, pointsAfterAdd);
            assertEquals(0, pointsAfterClean);
        }
    }

    @Nested
    @DisplayName("Tests for Game class")
    class  GameRulesTest {

        @Test
        void testRoundsQuantity() {
            //Given
            Player player = new Player("Player1");
            Player computer1 = new Player("VirtualPlayer1");
            Player computer2 = new Player("VirtualPlayer2");
            Game game = new Game(player, computer1, computer2);

            //When
            game.setRoundsQuantity(5);
            int i = 0;
            while (!game.checkRoundsQuantity()) {
                game.makeRoundBattle(1, 1, 1);
                i++;
            }

            //Then
            assertEquals(5, i);
        }

        @Test
        void testForRoundResult() {
            //Given
            Player player = new Player("Player1");
            Player computer1 = new Player("VirtualPlayer1");
            Player computer2 = new Player("VirtualPlayer2");
            Game game = new Game(player, computer1, computer2);

            //When
            game.setRoundsQuantity(4);
            String drawFirstOption = game.makeRoundBattle(1, 1, 1);
            String drawSecondOption = game.makeRoundBattle(2, 1, 3);
            String player1Win = game.makeRoundBattle(1, 3, 3);
            String virtualPlayers1and2Win = game.makeRoundBattle(1, 2, 2);

            //Then
            assertEquals("There is no winners in this round", drawFirstOption);
            assertEquals("There is no winners in this round", drawSecondOption);
            assertEquals("Winners: Player1 ", player1Win);
            assertEquals("Winners: VirtualPlayer1 VirtualPlayer2 ", virtualPlayers1and2Win);
        }

        @Test
        void testForMatchResult() {
            //Given
            Player player = new Player("Player1");
            Player computer1 = new Player("VirtualPlayer1");
            Player computer2 = new Player("VirtualPlayer2");
            Game game = new Game(player, computer1, computer2);

            //When
            game.setRoundsQuantity(5);

            game.makeRoundBattle(1, 1, 1);
            String drawFirstOption = game.checkMatchWinner();

            game.makeRoundBattle(2, 1, 3);
            String drawSecondOption = game.checkMatchWinner();

            game.makeRoundBattle(3, 1, 3);
            String virtualPlayer1Win = game.checkMatchWinner();

            game.makeRoundBattle(1, 1, 2);
            String virtualPlayers1and2Win = game.checkMatchWinner();

            //Then
            assertEquals("Draw!", drawFirstOption);
            assertEquals("Draw!", drawSecondOption);
            assertEquals("Match winners: VirtualPlayer1 ", virtualPlayer1Win);
            assertEquals("Match winners: VirtualPlayer1 VirtualPlayer2 ", virtualPlayers1and2Win);
        }

        @Test
        void testCleanFunction() {
            //Given
            Player player = new Player("Player1");
            Player computer1 = new Player("VirtualPlayer1");
            Player computer2 = new Player("VirtualPlayer2");
            Game game = new Game(player, computer1, computer2);

            //When
            game.setRoundsQuantity(5);
            while (!game.checkRoundsQuantity()) {
                game.makeRoundBattle(1, 2, 2);
            }
            game.clean();

            //Then
            assertAll(
                    () -> assertEquals(0, player.getPoints()),
                    () -> assertEquals(0, computer1.getPoints()),
                    () -> assertEquals(0, computer2.getPoints()),
                    () -> assertEquals(0, game.getRoundsQuantity()),
                    () -> assertEquals(1, game.getActualRound()));
        }
    }
}
