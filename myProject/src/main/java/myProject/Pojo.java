package myProject;

public class Pojo{
    public Pojo() {
		super();
	}
	public Pojo(String name, int totalSales, double salesPeriod, double experienceMultiplier) {
		super();
		this.name = name;
		this.totalSales = totalSales;
		this.salesPeriod = salesPeriod;
		this.experienceMultiplier = experienceMultiplier;
	}
	private String name;
    private int totalSales;
    private double salesPeriod;
    private double experienceMultiplier;

    public int getTotalSales() {
		return totalSales;
	}
	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}
	public double getSalesPeriod() {
		return salesPeriod;
	}
	public void setSalesPeriod(int salesPeriod) {
		this.salesPeriod = salesPeriod;
	}
	public double getExperienceMultiplier() {
		return experienceMultiplier;
	}
	public void setExperienceMultiplier(double experienceMultiplier) {
		this.experienceMultiplier = experienceMultiplier;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
