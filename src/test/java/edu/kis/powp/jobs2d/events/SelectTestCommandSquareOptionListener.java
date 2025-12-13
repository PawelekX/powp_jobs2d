package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import edu.kis.powp.command.DriverCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.jobs2d.drivers.DriverManager;

public class SelectTestCommandSquareOptionListener implements ActionListener {

    private DriverManager driverManager;

    public SelectTestCommandSquareOptionListener(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List<DriverCommand> commands = new ArrayList<>();

        commands.add(new SetPositionCommand(0, 0));
        commands.add(new OperateToCommand(100, 0));
        commands.add(new OperateToCommand(100, 100));
        commands.add(new OperateToCommand(0, 100));
        commands.add(new OperateToCommand(0, 0));

        for (DriverCommand command : commands) {
            command.execute(driverManager.getCurrentDriver());
        }
    }
}