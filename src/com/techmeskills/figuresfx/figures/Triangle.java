package com.techmeskills.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Figure {
    int x;

    public Triangle(double cx, double cy, double lineWidth, Color color, int x) {
        this(cx, cy, lineWidth, color);
        this.x = x;
    }

    private Triangle(double cx, double cy, double lineWidth, Color color) {
        super(FIGURE_TYPE_TRIANGLE, cx, cy, lineWidth, color);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.beginPath();
        gc.moveTo(cx, cy);
        gc.lineTo(cx + x, cy + x);
        gc.lineTo(cx - x, cy + x);
        gc.closePath();
        gc.stroke();

    }
}
