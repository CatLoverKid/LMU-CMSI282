class MyTuple {
	private int[] values = new int[2];
	
	public MyTuple(int cost, int gain) {
		values[0] = cost;
		values[1] = gain;
	}
	
	public int getCost() {
		return values[0];
	}
	
	public int getGain() {
		return values[1];
	}
	
	public void setCost(int Cost) {
		values[0] = Cost;
	}
	
	public void setGain(int Gain) {
		values[1] = Gain;
	}
}