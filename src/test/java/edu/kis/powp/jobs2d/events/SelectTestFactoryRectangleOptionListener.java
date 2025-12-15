package edu.kis.powp.jobs2d.events;

import edu.kis.powp.command.DriverCommand;
import edu.kis.powp.factory.FigureFactory;
import edu.kis.powp.factory.RectangleFactory;
import edu.kis.powp.jobs2d.drivers.DriverManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectTestFactoryRectangleOptionListener implements ActionListener {

    private DriverManager driverManager;

    public SelectTestFactoryRectangleOptionListener(DriverManager driverManager) {
        this.driverManager = driverManager;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        FigureFactory rectangleFactory = new RectangleFactory(0, 0, 100, 50);
        DriverCommand command = rectangleFactory.drawFigureCommand();
        command.execute(driverManager.getCurrentDriver());

    }
}