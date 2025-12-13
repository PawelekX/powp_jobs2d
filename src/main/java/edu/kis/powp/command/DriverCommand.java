package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

/**
 * Interface for implementing Command Pattern.
 */
public interface DriverCommand {
    void execute(Job2dDriver driver);
}