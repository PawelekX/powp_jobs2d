package edu.kis.powp.jobs2d.events;

import edu.kis.powp.command.DriverCommand;
import edu.kis.powp.factory.CircleFactory;
import edu.kis.powp.factory.FigureFactory;
import edu.kis.powp.jobs2d.drivers.DriverManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectTestFactoryCircleOptionListener implements ActionListener {

    private DriverManager driverManager;

    public SelectTestFactoryCircleOptionListener(DriverManager driverManager) {
        this.driverManager = driverManager;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        FigureFactory circleFactory = new CircleFactory(50,40,25);

        DriverCommand command = circleFactory.drawFigureCommand();
        command.execute(driverManager.getCurrentDriver());
    }
}