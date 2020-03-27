package mbourdin.TetrisGraphics;

import mbourdin.Drawable;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class JGraphicsPanel extends JPanel {
    private Drawable drawable;

    private int size_x;
    private int size_y;

    public JGraphicsPanel(int x, int y) {
        super();
        Dimension panelSize = new Dimension(x, y);
        setMinimumSize(panelSize);
        setPreferredSize(panelSize);
        size_x = x;
        size_y = y;
        drawable = null;


    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    //    public void addDrawable(Drawable d)
//    {   drawables.add(d);
//    }
//    public void removeDrawable(Drawable d)
//    {  drawables.remove(d);
//    }
    @Override
    public void paintComponent(@NotNull Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.clearRect(0, 0, size_x, size_y);
        drawable.draw(g);

    }
}
