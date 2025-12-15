package edu.kis.powp.factory;

import edu.kis.powp.command.DriverCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.composite.ComplexCommand;

import java.util.ArrayList;
import java.util.List;

public class CircleFactory implements FigureFactory {
    private int x, y, radius;

    public CircleFactory(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public DriverCommand drawFigureCommand() {
        List<DriverCommand> commands = new ArrayList<>();
        int steps = 36;

        commands.add(new SetPositionCommand(x + radius, y));

        for (int i = 1; i <= steps; i++) {
            double angle = 2 * Math.PI * i / steps;
            int nextX = (int) (x + radius * Math.cos(angle));
            int nextY = (int) (y + radius * Math.sin(angle));
            commands.add(new OperateToCommand(nextX, nextY));
        }

        return new ComplexCommand(commands);
    }
}
