abstract class Animal{
	protected int weight;
	public Animal(){}
	public void setWeight (int weight) { this.weight=weight; }
	public int getWeight () { return weight; }
	abstract public String says();
}
