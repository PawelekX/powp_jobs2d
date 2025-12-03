package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DrawerFeature;

/**
 * Driver adapter to drawer that allows client to choose line type.
 */
public class LineDrawerAdapter implements Job2dDriver {
    private int startX = 0, startY = 0;
    private DrawPanelController drawPanelController;
    private LineType lineType;

    public enum LineType {
        BASIC,
        SPECIAL,
        DOTTED
    }

    public LineDrawerAdapter(LineType lineType) {
        this.drawPanelController = DrawerFeature.getDrawerController();
        this.lineType = lineType;
    }

    public LineDrawerAdapter() {
        this(LineType.BASIC);
    }

    @Override
    public void setPosition(int x, int y) {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void operateTo(int x, int y) {
        ILine line = createLine();
        line.setStartCoordinates(this.startX, this.startY);
        line.setEndCoordinates(x, y);

        this.drawPanelController.drawLine(line);
        setPosition(x, y);
    }

    private ILine createLine() {
        switch (lineType) {
            case SPECIAL:
                return LineFactory.getSpecialLine();
            case DOTTED:
                return LineFactory.getDottedLine();
            case BASIC:
            default:
                return LineFactory.getBasicLine();
        }
    }
    
    @Override
    public String toString() {
        return "LineDrawerAdapter using " + lineType + " line";
    }
}