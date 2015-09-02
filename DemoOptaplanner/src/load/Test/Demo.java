package load.Test;

import java.util.HashMap;
import java.util.List;

import load.Beans.Process;
import load.Problem.DemoProblem;
import load.Problem.ProcessGenerator;

import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
//import org.optaplanner.core.config.solver.XmlSolverFactory;
//import org.optaplanner.examples.nqueens.domain.NQueens;
//import org.optaplanner.examples.nqueens.persistence.NQueensGenerator;



//asdf
public class Demo {

	public static void main(String[] args) {
		
		String SOLVER_CONFIG="SolverConfig62.xml";
		
		System.out.println((double)3/2);
		SolverFactory solverFactory = SolverFactory.createFromXmlResource(SOLVER_CONFIG);
		// Build the SolverX
		//apply to 6.0.0
		/*SolverFactory solverFactory = new XmlSolverFactory(
				SOLVER_CONFIG);*/
		Solver solver = solverFactory.buildSolver();

		// Load a problem
		DemoProblem unsolvedProblems = ProcessGenerator.createProblem();

		// Solve the problem
		//solver.setPlanningProblem(unsolvedProblems);
		solver.solve(unsolvedProblems);
		DemoProblem solved = (DemoProblem) solver.getBestSolution();
		printSolution(solved);

		// Display the result
		// System.out.println("\nSolved 8 queens:\n"
		// + toDisplayString(solved8Queens));

	}

	private static Object printSolution(DemoProblem solved) {
		List<Process> ls = solved.getProcessList();
		HashMap map = new HashMap();
		HashMap map2 = new HashMap();
		System.out.println(solved.getScore());
		for (Process process : ls) {
			String key = process.getComputer().getCpId();
			String vlr = "";
			Integer vlrInt = 0;
			if (map.containsKey(key)) {
				vlr = (String) map.get(key);
				vlrInt = (Integer) map2.get(key);
			}
			//else {
				map.put(key, vlr + process.getRequiredCpu() + " + ");
				map2.put(key, vlrInt + process.getRequiredCpu());
			//}
		}
		System.out.println(map2);
		System.out.println(map);
		return map;
	}

}
