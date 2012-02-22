package ita23.managerframework.contract;

import ita23.managerframework.time.Duration;

import java.util.List;

/**
 * This represents a {@code Job} on a project, which uses only
 *  {@code ProjectRequirement}-objects for it's requirements.
 * @author Lukas Knuth
 * @version 1.0
 */
public class ProjectJob implements Job {



    @Override
    public Duration getDuration() {
        return null;
    }

    @Override
    public int getPayment() {
        return 0;
    }

    @Override
    public List<Requirement> getRequirements() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
