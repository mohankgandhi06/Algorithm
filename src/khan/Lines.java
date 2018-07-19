package khan;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class Lines {

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            public void run() {
                LineComponent lineComponent = new LineComponent(500, 500);
                lineComponent.square(480);
                lineComponent.addLine(0, 0, 480);
                JOptionPane.showMessageDialog(null, lineComponent);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}

class LineComponent extends JComponent {

    ArrayList<Line2D.Double> lines;

    LineComponent(int width, int height) {
        super();
        setPreferredSize(new Dimension(width, height));
        lines = new ArrayList<Line2D.Double>();
    }

    public void addLine(int x1, int y1, int size) {
        if (size > 10) {
            //diagonal(x1, y1, size);
            splitIntoFour(x1, y1, size);
            size = size / 2;
            addLine(x1, y1, size);//upperLeft
            addLine(x1 + size, y1, size);//upperRight
            addLine(x1 + size, y1 + size, size);//lowerRight

        } else {
            //draw x mark or fill it with color
            diagonal(x1, y1, size);
            paintLineByLine(x1, y1, size);
        }
    }

    public void paintLineByLine(int x1, int y1, int size) {
        for (int m = y1; m <= y1+size; m++) {
            Line2D.Double line = new Line2D.Double(x1, m, x1 + size, m);//Left Vertical
            lines.add(line);
        }
    }

    public void square(int side) {
        Line2D.Double line = new Line2D.Double(0, 0, 0, side);//Left Vertical
        lines.add(line);
        line = new Line2D.Double(0, 0, side, 0);//Top Horizontal
        lines.add(line);
        line = new Line2D.Double(0, side, side, side);//Bottom Horizontal
        lines.add(line);
        line = new Line2D.Double(side, 0, side, side);//Right Vertical
        lines.add(line);
        repaint();
    }

    /*public void diagonal(int x1, int y1, int size) {
        Line2D.Double line = new Line2D.Double(x1,y1,x1+size,y1+size);//Left Vertical
        lines.add(line);
        line = new Line2D.Double(x1+size,y1,(x1+size)/2,(x1+size)/2);//Top Horizontal
        lines.add(line);
        repaint();
    }*/

    public void diagonal(int x1, int y1, int size) {
        Line2D.Double line = new Line2D.Double(x1, y1, x1 + size, y1 + size);//Left Vertical
        lines.add(line);
        line = new Line2D.Double(x1 + size, y1, x1, y1 + size);//Top Horizontal
        lines.add(line);
        repaint();
    }

    public void splitIntoFour(int x1, int y1, int size) {
        //Line2D.Double line = new Line2D.Double(x1+(size/2),y1,x1+(size/2),x1+size);//Left Vertical
        Line2D.Double line = new Line2D.Double(x1 + (size / 2), y1, x1 + (size / 2), x1 + size);//Left Vertical
        lines.add(line);
        line = new Line2D.Double(x1, y1 + (size / 2), x1 + size, y1 + (size / 2));//Top Horizontal
        lines.add(line);
        repaint();
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        //Dimension d = getPreferredSize();
        g.setColor(Color.blue);
        for (Line2D.Double line : lines) {
            g.drawLine(
                    (int) line.getX1(),
                    (int) line.getY1(),
                    (int) line.getX2(),
                    (int) line.getY2()
            );
        }
    }
}
