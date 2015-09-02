package load.Problem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import load.Beans.Computer;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.Solution;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
//for 6.0
//import org.optaplanner.core.api.domain.value.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoftdouble.HardSoftDoubleScore;
import org.optaplanner.core.api.score.buildin.hardsoftlong.HardSoftLongScore;
//for 6.0
//import org.optaplanner.core.impl.solution.Solution;

@PlanningSolution
public class DemoProblem implements Solution<HardSoftDoubleScore> {

	private HardSoftDoubleScore score;

	private List<load.Beans.Process> processList;

	@PlanningEntityCollectionProperty
	public List<load.Beans.Process> getProcessList() {
		return processList;
	}

	public void setProcessList(List<load.Beans.Process> processList) {
		this.processList = processList;
	}

	private List<Computer> computerList;

	@ValueRangeProvider(id = "computerRange")
	public List<Computer> getComputerList() {
		return computerList;
	}

	public void setComputerList(List<Computer> computerList) {
		this.computerList = computerList;
	}

	@Override
	public Collection<? extends Object> getProblemFacts() {
		List<Object> facts = new ArrayList<Object>();
		facts.addAll(computerList);
		// Do not add the planning entity's (processList) because that will be
		// done automatically
		return facts;
	}

	/*@Override
	public HardSoftScore getScore() {
		return score;
	}

	@Override
	public void setScore(HardSoftScore arg0) {
		this.score=arg0;
		
	}*/

	@Override
	public String toString() {
		return "CP "+computerList +" Score "+score +" process "+processList;
	}

	@Override
	public HardSoftDoubleScore getScore() {
		return score;
	}

	@Override
	public void setScore(HardSoftDoubleScore arg0) {
		this.score=arg0;
	}

}
