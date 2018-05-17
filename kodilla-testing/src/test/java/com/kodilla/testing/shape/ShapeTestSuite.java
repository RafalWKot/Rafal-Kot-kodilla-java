package com.kodilla.testing.shape;

import org.junit.*;

public class ShapeTestSuite {
    private static int testCounter = 0;
    private final ShapeCollector shapeCollector = new ShapeCollector();

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testAddFigure() {
        Shape shape = new Circle(2.0);

        shapeCollector.addFigure(shape);

        Assert.assertEquals(shape, shapeCollector.getFigure(0));
    }

    @Test
    public void testRemoveFigure() {

        Shape shape = new Circle(2.0);
        shapeCollector.addFigure(shape);

        boolean result = shapeCollector.removeFigure(shape);

        Assert.assertTrue(result);
        Assert.assertEquals(null, shapeCollector.getFigure(0));
    }

    @Test
    public void testGetFigure() {

        Shape shape = new Circle(2.0);
        shapeCollector.addFigure(shape);

        Shape retrievedShape;
        retrievedShape = shapeCollector.getFigure(0);

        Assert.assertEquals(shape,retrievedShape);
    }

    @Test
    public void showFigure() {

        Shape shape = new Circle(2.0);
        shapeCollector.addFigure(shape);

        Assert.assertEquals("Circle", shapeCollector.getFigure(0).getShapeName());
    }
}
