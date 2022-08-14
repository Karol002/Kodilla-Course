package com.kodilla.testing.shape;


import com.kodilla.testing.shapes.Circle;
import com.kodilla.testing.shapes.ShapeCollector;
import com.kodilla.testing.shapes.Square;
import com.kodilla.testing.shapes.Triangle;
import org.junit.jupiter.api.*;


@DisplayName("TDD Test for Shape class")
public class ShapeCollectorTestSuite {

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Nested
    @DisplayName("Tests for adding and remove")
    class TestForSizeList {

        @Test
        void testAddFigure() {
            //Given
            ShapeCollector collector = new ShapeCollector();
            Circle circle = new Circle(1);

            //When
            collector.addFigure(circle);

            //Then
            Assertions.assertEquals(1, collector.getFigureQuantity());
        }

        @Test
        void testRemoveFigure() {
            //Given
            Triangle triangle = new Triangle(1, 2);
            ShapeCollector collector = new ShapeCollector();
            collector.addFigure(triangle);

            //When
            boolean result = collector.removeFigure(triangle);

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(null, collector.getFigure(0));
        }
    }

    @Nested
    @DisplayName("Tests for getting elements")
    class TestForGetting {

        @Test
        void testGetFigure() {
            //Given
            Square square = new Square(2);
            ShapeCollector collector = new ShapeCollector();
            collector.addFigure(square);

            //When
            Square squareData = (Square) collector.getFigure(0);

            //Then
            Assertions.assertEquals(square, squareData);
        }

        @Test
        void testShowFigures() {
            //Given
            Square square = new Square(2);
            Triangle triangle = new Triangle(1, 2);
            Circle circle = new Circle(1);
            ShapeCollector collector = new ShapeCollector();
            collector.addFigure(square);
            collector.addFigure(triangle);
            collector.addFigure(circle);

            //When
            String names = square.getShapeName() +  triangle.getShapeName() +  circle.getShapeName();

            //Then
            Assertions.assertEquals(names, collector.showFigures());
        }
    }
}
