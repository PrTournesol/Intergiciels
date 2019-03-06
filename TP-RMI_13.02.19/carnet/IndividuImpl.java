package carnet;

public class IndividuImpl implements Individu {

	String nom;
	int age;
	
	public IndividuImpl(String nom, int age) {
		super();
		this.nom = nom;
		this.age = age;
	}

	@Override
	public String nom() {
		this.nom=nom;
		return null;
	}

	@Override
	public int age() {
		this.age=age;
		return 0;
	}

	@Override
	public void feter_anniversaire() {
		age++;
	}

}
