package load.Beans;

public class Computer {

	private String cpId;

	public String getCpId() {
		return cpId;
	}
	//asdf

	public void setCpId(String cpId) {
		this.cpId = cpId;
	}

	private int cpuPower;
	private int memory;
	//asdf

	public int getCpuPower() {
		return cpuPower;
	}

	public void setCpuPower(int cpuPower) {
		this.cpuPower = cpuPower;
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

	@Override
	public String toString() {
		return cpId + " - "+cpuPower + " Mem " + memory;
	}

}
