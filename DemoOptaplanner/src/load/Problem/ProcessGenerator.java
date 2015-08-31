package load.Problem;

import java.util.ArrayList;
import java.util.List;

import load.Beans.Computer;
import load.Beans.Process;

public class ProcessGenerator {

	public static DemoProblem createProblem() {
		DemoProblem pr = new DemoProblem();
		pr.setComputerList(createComputerList());
		pr.setProcessList(createProcessList());
		return pr;
	}

	private static List<Process> createProcessList() {
		List<Process> ls = new ArrayList<Process>();
		for (int i = 0; i < 10; i++) {
			Process comp = new Process();
			comp.setRequiredCpu(200);
			ls.add(comp);

			comp = new Process();
			comp.setRequiredCpu(150);
			ls.add(comp);

			comp = new Process();
			comp.setRequiredCpu(150);
			ls.add(comp);
			
			comp = new Process();
			comp.setRequiredCpu(150);
			ls.add(comp);

			comp = new Process();
			comp.setRequiredCpu(100);
			ls.add(comp);

			comp = new Process();
			comp.setRequiredCpu(280);
			ls.add(comp);
			
			comp = new Process();
			comp.setRequiredCpu(600);
			ls.add(comp);

		}

		return ls;
	}

	private static List<Computer> createComputerList() {
		List<Computer> ls = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			Computer comp = new Computer();
			comp.setCpuPower(2000);
			comp.setMemory(300);
			comp.setCpId("CP" + i);
			ls.add(comp);
		}
		return ls;
	}

}
