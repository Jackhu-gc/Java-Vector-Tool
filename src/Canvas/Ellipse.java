package Canvas;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.io.BufferedWriter;
import java.io.IOException;


public class Ellipse implements ConnectorRecEllipsePoly {
    private Ellipse2D elip2d;
    private Color linecolor = null;
    private Color color = null;

    public Ellipse() {
    }

    public Ellipse(Ellipse2D e) {
        this.elip2d = e;
    }

    public Ellipse(Ellipse2D e, Color lc) {
        this.elip2d = e;
        this.linecolor = lc;
    }

    public Ellipse(Ellipse2D e, Color lc, Color c) {
        this.elip2d = e;
        this.linecolor = lc;
        this.color = c;
    }
    @Override
    public void makeObject(Point spoint, Point fpoint) {
        setLineColor(GUI.colour);
        Ellipse2D r = new Ellipse2D.Float(Math.min(spoint.x, fpoint.x), Math.min(spoint.y, fpoint.y), Math.abs(spoint.x - fpoint.x), Math.abs(spoint.y - fpoint.y));
        this.setElip2d(r);
    }

    public void makeEllipse(int x, int y, int w, int h) {
        Ellipse2D r = new Ellipse2D.Float(x, y, w, h);
        this.setElip2d(r);
    }

    @Override
    public void draw(GraphicsAdapter g) {
        if(getColor() == null){
            g.getGraphicAdapter().setColor(getLineColor());
            g.getGraphicAdapter().drawOval((int)getElip2d().getX(),(int)getElip2d().getY(), (int)getElip2d().getWidth(), (int)getElip2d().getHeight());
        }
        else{
            g.getGraphicAdapter().setColor(getColor());
            g.getGraphicAdapter().fillOval((int)getElip2d().getX(),(int)getElip2d().getY(), (int)getElip2d().getWidth(), (int)getElip2d().getHeight());
            g.getGraphicAdapter().setColor((this.getLineColor()));
            g.getGraphicAdapter().drawOval((int)getElip2d().getX(),(int)getElip2d().getY(), (int)getElip2d().getWidth(), (int)getElip2d().getHeight());
        }
    }
    @Override
    public void fill(Color c){
        this.setColor(c);
    }
    @Override
    public boolean contains(Point p) {
        return this.getElip2d().contains(p);
    }
    @Override
    public void move(Point startDrag, Point endDrag){
        this.getElip2d().setFrame(getElip2d().getX() + endDrag.x - startDrag.x,this.getElip2d().getY() + endDrag.y - startDrag.y,this.getElip2d().getWidth(), this.getElip2d().getHeight());
    }

    @Override
    public void writetoFile(BufferedWriter b){
        try {
            b.write(getClass().getSimpleName() + " ");
            b.write((int)getElip2d().getX() + " " + (int)getElip2d().getY() + " " + (int)getElip2d().getWidth() + " " + (int)getElip2d().getHeight() + " ");
            b.write(getLineColor().getRed() + " " +getLineColor().getGreen() + " " + getLineColor().getBlue() +" ");
            if(getColor()==null){
                b.write("null" + " " +"null" +" " + "null");
            }else{
                b.write(getColor().getRed() + " " + getColor().getGreen() + " " + getColor().getBlue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Ellipse2D getElip2d() {
        return elip2d;
    }
    public void setElip2d(Ellipse2D elip2d) {
        this.elip2d = elip2d;
    }
    public Color getLineColor() {
        return linecolor;
    }
    public void setLineColor(Color linecolor) {
        this.linecolor = linecolor;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }

}
