package com.techmeskills.figuresfx.controller;

import com.techmeskills.figuresfx.drawutils.Drawer;
import com.techmeskills.figuresfx.exeptions.LineWidthException;
import com.techmeskills.figuresfx.exeptions.TypeException;
import com.techmeskills.figuresfx.figures.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class MainScreenViewController implements Initializable {
    private ArrayList<Figure> figures;
    private Random random;
    Logger logger;

    @FXML
    private Canvas canvas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        figures = new ArrayList<>();
        random = new Random(System.currentTimeMillis());

    }

    private void addFigure(Figure figure) {
        figures.add(figure);

    }

    private Figure createFigure(double x, double y) throws TypeException, LineWidthException {
        Figure figure = null;

        switch (random.nextInt(5)) {
            case Figure.FIGURE_TYPE_CIRCLE:
                figure = new Circle(x, y, Math.max(random.nextInt(3), 5), Color.BLUE, random.nextInt(50));
                break;
            case Figure.FIGURE_TYPE_RECTANGLE:
                figure = new Rectangle(x, y, Math.max(random.nextInt(3), 5), Color.GREEN, random.nextInt(50), random.nextInt(100));
                break;
            case Figure.FIGURE_TYPE_HEART:
                figure = new Heart(x, y, 3, Color.RED);
                break;
            case Figure.FIGURE_TYPE_TRIANGLE:
                figure = new Triangle(x, y, 5, Color.YELLOWGREEN, random.nextInt(100));
                break;
            case Figure.FIGURE_TYPE_FLAG:
                figure = new Flag(x, y, 3, Color.RED, Color.BLACK, random.nextInt(50) + 100, random.nextInt(50) + 50);
                break;


        }
        if (figure.getLineWidth() <= 0) {
            throw new LineWidthException("Incorrect linewidth");
        }
        if (!(figure instanceof Figure)) {
            throw new TypeException("Unknown Type of Figure");
        }


        return figure;
    }

    private void repaint() {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        Drawer<Figure> drawer = new Drawer<>(figures);
        drawer.draw(canvas.getGraphicsContext2D());
//
    }

    @FXML
    private void onMouseClicked(MouseEvent mouseEvent) {
        try {
            addFigure(createFigure(mouseEvent.getX(), mouseEvent.getY()));
        } catch (TypeException | ArrayStoreException | LineWidthException te) {
            logger.error(te.getMessage());
        }
        repaint();
    }
}
