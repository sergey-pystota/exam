package com.techmeskills.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Flag extends Figure {
    double height;
    double width;
    Color color1;

    public Flag(double cx, double cy, double lineWidth, Color color, Color color1, double height, double width) {
        this(cx, cy, lineWidth, color);
        this.color1 = color;
        this.height = height < 10 ? 10 : width;
        this.width = width < 10 ? 10 : height;
    }


    private Flag(double cx, double cy, double lineWidth, Color color) {
        super(FIGURE_TYPE_FLAG, cx, cy, lineWidth, color);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.setFill(color1);
        gc.strokeRect(cx - width / 2, cy - height / 2, width, height);
        gc.fillRect(cx - width / 2, cy - height / 5.5, width, height / 3);


    }
}
