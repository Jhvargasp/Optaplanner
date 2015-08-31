/**
 * 
 */
package load.Beans;

import load.solver.ComputerStrengthComparator;
import load.solver.ProcessDifficultyComparator;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

/**
 * @author jorge.vargas
 * 
 */

@PlanningEntity(difficultyComparatorClass = ProcessDifficultyComparator.class)
public class Process {
	private int requiredCpu;

	public int getRequiredCpu() {
		return requiredCpu;
	}

	public void setRequiredCpu(int requiredCpu) {
		this.requiredCpu = requiredCpu;
	}

	private Computer computer;

	@PlanningVariable(valueRangeProviderRefs = { "computerRange" }, strengthComparatorClass = ComputerStrengthComparator.class)
	public Computer getComputer() {
		return computer;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	
	@Override
	public String toString() {
		return "REQCPU "+requiredCpu+" + computer.."+computer+"...";
	}
}
