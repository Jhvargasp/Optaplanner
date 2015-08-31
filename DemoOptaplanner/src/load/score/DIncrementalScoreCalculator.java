package load.score;

import java.util.HashMap;
import java.util.Set;

import load.Beans.Computer;
import load.Beans.Process;
import load.Problem.DemoProblem;

import org.optaplanner.core.api.score.Score;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.buildin.hardsoftlong.HardSoftLongScore;
import org.optaplanner.core.impl.score.director.incremental.IncrementalScoreCalculator;

public class DIncrementalScoreCalculator implements
		IncrementalScoreCalculator<DemoProblem> {

	@Override
	public void afterEntityAdded(Object arg0) {
		insert((Process) arg0);
	}

	@Override
	public void afterEntityRemoved(Object arg0) {
		//System.out.println("try...");

	}

	@Override
	public void afterVariableChanged(Object arg0, String arg1) {
		insert((Process) arg0);
	}

	@Override
	public void beforeEntityAdded(Object arg0) {
		//System.out.println("try...");
	}

	@Override
	public void beforeEntityRemoved(Object arg0) {
		retract((Process) arg0);
	}

	@Override
	public void beforeVariableChanged(Object arg0, String arg1) {
		//System.out.println("try...");
		retract((Process) arg0);
	}

	@Override
	public String buildScoreCorruptionAnalysis(IncrementalScoreCalculator arg0) {
		//System.out.println("try...");
		return null;
	}

	private int hardScore;

	// private HashMap<Computer, Integer> cpuPowerUsageMap;

	@Override
	public Score calculateScore() {
		//System.out.println("calculate...");
		int softScore = 0;

		String[] keys = (String[]) uso.keySet().toArray(
				new String[uso.keySet().size()]);
		softScore = keys.length;
		for (String k : keys) {
			if (uso.get(k) > 0)
				softScore--;
		}
		
		if(hardScore>700){
			System.out.println();
		}
		
		System.out.println(HardSoftLongScore.valueOf(hardScore, softScore));
		return HardSoftLongScore.valueOf(hardScore, softScore);
	}

	HashMap<String, Integer> uso = new HashMap<String, Integer>();

	@Override
	public void resetWorkingSolution(DemoProblem dp) {
		System.out.println("reset");
		for (Computer computer : dp.getComputerList()) {
			uso.put(computer.getCpId(), 0);
		}
		hardScore = 0;
		// softScore = 0;
		for (load.Beans.Process process : dp.getProcessList()) {
			insert(process);
		}

	}

	private void insert(Process process) {
		Computer computer = process.getComputer();
		if (computer != null) {
			int uso1 = uso.get(computer.getCpId());
			uso.put(computer.getCpId(), uso1 + process.getRequiredCpu());
			if (uso.get(computer.getCpId()) <= computer.getCpuPower()) {
				 //hardScore += process.getRequiredCpu();
				
				System.out.println(uso.get(computer.getCpId()) +">>"+computer.getCpuPower());
			} else {
				// hardScore += process.getRequiredCpu();
				hardScore += computer.getCpuPower()
						- uso.get(computer.getCpId());
			}

		}

	}

	private void retract(Process process) {
		//System.out.println("retract..");
		Computer computer = process.getComputer();
		if (computer != null) {
			uso.put(computer.getCpId(),
					uso.get(computer.getCpId()) - process.getRequiredCpu());
			if (uso.get(computer.getCpId()) <= computer.getCpuPower()) {
				hardScore = 0;
			}

		}
	}
}
