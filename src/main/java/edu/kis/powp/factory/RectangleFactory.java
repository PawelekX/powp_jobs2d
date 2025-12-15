package edu.kis.powp.factory;

import edu.kis.powp.command.DriverCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.composite.ComplexCommand;

import java.util.ArrayList;
import java.util.List;

public class RectangleFactory implements FigureFactory {
    private int x,y,width,height;

    public RectangleFactory(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public DriverCommand drawFigureCommand() {
        List<DriverCommand> commands = new ArrayList<DriverCommand>();

        commands.add(new SetPositionCommand(x, y));
        commands.add(new OperateToCommand(x + width, y));
        commands.add(new OperateToCommand(x + width, y + height));
        commands.add(new OperateToCommand(x, y + height));
        commands.add(new OperateToCommand(x, y));

        return new ComplexCommand(commands);
    }
}
