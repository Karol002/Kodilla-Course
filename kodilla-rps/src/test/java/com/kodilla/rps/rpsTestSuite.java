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
            Player player1 = new Player();
            Player player2 = new Player();
            Player player3 = new Player();
            Player player4 = new Player();
            Player player5 = new Player();

            //When
            player1.choseActualMove(1);
            player2.choseActualMove(2);
            player3.choseActualMove(3);
            player4.choseActualMove(4);
            player5.choseActualMove(5);

            //Then
            assertEquals(Figure.stone, player1.getActualMove());
            assertEquals(Figure.paper, player2.getActualMove());
            assertEquals(Figure.scissors, player3.getActualMove());
            assertEquals(Figure.spock, player4.getActualMove());
            assertEquals(Figure.lizard, player5.getActualMove());
        }

        @Test
        void testForPointsFunction() {
            //Given
            Player player1 = new Player();

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
        void testRoundsCounter() {
            //Given
            Game game = new Game(new Player(), new Player(), new Player());
            game.setPlayerNames("Player1", "VirtualPlayer1", "VirtualPlayer2");

            //When
            game.setRoundsQuantity(5);
            int i = 0;
            while (!game.checkRoundsQuantity()) {
                game.singleRoundBattle(1, 1, 1);
                i++;
            }

            //Then
            assertEquals(5, i);
        }

        @Test
        void testForDrawRoundResult() {
            //Given
            Game game = new Game(new Player(), new Player(), new Player());
            game.setPlayerNames("Player1", "VirtualPlayer1", "VirtualPlayer2");

            //When
            String draw = "There is no winners in this round";
            game.setRoundsQuantity(4);
            String firstOption = game.singleRoundBattle(1, 1, 1);
            String secondOption = game.singleRoundBattle(2, 1, 3);
            String thirdOption = game.singleRoundBattle(5, 1, 4);
            String fourthOption = game.singleRoundBattle(4, 3, 2);

            //Then
            assertEquals(draw, firstOption);
            assertEquals(draw, secondOption);
            assertEquals(draw, thirdOption);
            assertEquals(draw, fourthOption);
        }
        @Test
        void testForOneRoundWinner() {
            //Given
            Game game = new Game(new Player(), new Player(), new Player());
            game.setPlayerNames("Player1", "VirtualPlayer1", "VirtualPlayer2");

            //When
            game.setRoundsQuantity(4);
            String winner = "Winners: Player1 ";
            String firstOption = game.singleRoundBattle(1, 5, 3);
            String secondOption = game.singleRoundBattle(2, 1, 4);
            String thirdOption = game.singleRoundBattle(3, 2, 5);
            String fourthOption = game.singleRoundBattle(4, 1, 3);
            String fifthOption = game.singleRoundBattle(5, 2, 4);

            //Then
            assertEquals(winner, firstOption);
            assertEquals(winner, secondOption);
            assertEquals(winner, thirdOption);
            assertEquals(winner, fourthOption);
            assertEquals(winner, fifthOption);
        }

        @Test
        void testForFewRoundWinner() {
            //Given
            Game game = new Game(new Player(), new Player(), new Player());
            game.setPlayerNames("Player1", "VirtualPlayer1", "VirtualPlayer2");

            //When
            game.setRoundsQuantity(4);
            String winner = "Winners: Player1 VirtualPlayer1 ";
            String firstOption = game.singleRoundBattle(1, 1, 3);
            String secondOption = game.singleRoundBattle(2, 2, 4);
            String thirdOption = game.singleRoundBattle(3, 3, 5);
            String fourthOption = game.singleRoundBattle(4, 4, 3);
            String fifthOption = game.singleRoundBattle(5, 5, 4);

            //Then
            assertEquals(winner, firstOption);
            assertEquals(winner, secondOption);
            assertEquals(winner, thirdOption);
            assertEquals(winner, fourthOption);
            assertEquals(winner, fifthOption);
        }

        @Test
        void testForMatchResult() {
            //Given
            Game game = new Game(new Player(), new Player(), new Player());
            game.setPlayerNames("Player1", "VirtualPlayer1", "VirtualPlayer2");

            //When
            game.setRoundsQuantity(5);

            game.singleRoundBattle(1, 1, 1);
            String drawFirstOption = game.checkMatchWinner();

            game.singleRoundBattle(2, 1, 3);
            String drawSecondOption = game.checkMatchWinner();

            game.singleRoundBattle(3, 1, 3);
            String virtualPlayer1Win = game.checkMatchWinner();

            game.singleRoundBattle(1, 1, 2);
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
            Player player = new Player();
            Player computer1 = new Player();
            Player computer2 = new Player();
            Game game = new Game(player, computer1, computer2);

            //When
            game.setRoundsQuantity(5);
            while (!game.checkRoundsQuantity()) {
                game.singleRoundBattle(1, 2, 2);
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