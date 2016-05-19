package Printers;

public  class Machine implements IMachine {
	private String machineName;
	private boolean isOn;
	public Machine(String machineName, boolean isOn)
	{
		this.machineName = machineName;
		this.isOn = isOn;
	}
	@Override
	public  void turnOn(){
		
		isOn = true;
		System.out.println(machineName + " is now On");
	}
	
	@Override
	public void turnOff(){
		isOn = false;
		System.out.println(machineName + " is now Off");
	}
	
	@Override
	public boolean isOn(){
		return isOn;
	}
	
	public String getMachineName(){
		return machineName;
	}
	public void setMachineName(String machineName){
		this.machineName = machineName; 
	}
}
