package com.techmeskills.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Heart extends Figure {


    public Heart(double cx, double cy, double lineWidth, Color color) {
        super(FIGURE_TYPE_HEART, cx, cy, lineWidth, color);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.beginPath();
        gc.moveTo(cx, cy);
        gc.bezierCurveTo(cx, cy - 3, cx - 5, cy - 15, cx - 15, cy - 15);
        gc.bezierCurveTo(cx - 55, cy - 15, cx - 55, cy + 22.5, cx - 55, cy + 22.5);
        gc.bezierCurveTo(cx - 55, cy + 40, cx - 35, cy + 62, cx, cy + 80);
        gc.bezierCurveTo(cx + 35, cy + 62, cx + 55, cy + 40, cx + 55, cy + 22.5);
        gc.bezierCurveTo(cx + 55, cy + 22.5, cx + 55, cy - 15, cx + 25, cy - 15);
        gc.bezierCurveTo(cx + 10, cy - 15, cx, cy - 3, cx, cy);
        gc.stroke();


    }


}
