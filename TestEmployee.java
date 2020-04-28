abstract class Employee
{
private String name;
private double salary;
private String function;

public Employee(String name,String function,double salary)
{
	this.name=name;
	this.function=function;
	this.salary=salary;
}

public void print ()
{
	System.out.println("Name: " + this.name + " Function: "+this.function+ " Salary: "+this.salary);
}

public abstract void setSalary(double s);

public void setSal(double s)
{
	this.salary=this.salary+s;
}
}

class Directory extends Employee
{
	public Directory (String name,String function,double salary)
	{
		super (name,function,salary);
	}
	public void setSalary(double s)
	{
		setSal(s+1000);
	}
}

class Maturatory extends Employee
{
	public Maturatory (String name,String function,double salary)
	{
		super (name,function,salary);
	}
	public void setSalary(double s)
	{
		setSal(s-100);
	}
}

class Engineer extends Employee
{
	public Engineer (String name,String function,double salary)
	{
		super (name,function,salary);
	}
	public void setSalary(double s)
	{
		setSal(s);
	}
}


public class TestEmployee
{
	public static void main (String[] args)
	{
		Employee d = new Directory("Ion", "Director", 80000);
		Employee m = new Maturatory("Vasia", "maturator", 100000);
		Employee e = new Engineer("Pekea", "injiner", 20000);
		
		d.setSalary(1000);
		m.setSalary(1000);
		e.setSalary(1000);
		
		d.print();
		m.print();
		e.print();
	}
}