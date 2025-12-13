package edu.kis.powp.jobs2d.events;

import edu.kis.powp.command.DriverCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.jobs2d.drivers.DriverManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SelectTestCommandTriangleOptionListener implements ActionListener {

    private DriverManager driverManager;

    public SelectTestCommandTriangleOptionListener(DriverManager driverManager) {
        this.driverManager = driverManager;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        List<DriverCommand> commands = new ArrayList<>();

        commands.add(new SetPositionCommand(0, -50));

        commands.add(new OperateToCommand(50, 50));

        commands.add(new OperateToCommand(-50, 50));

        commands.add(new OperateToCommand(0, -50));

        for (DriverCommand command : commands) {
            command.execute(driverManager.getCurrentDriver());
        }
    }
}