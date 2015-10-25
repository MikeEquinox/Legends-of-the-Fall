package tmv_insurance_package;

/**
 * @author teleginmv
 * Класс страхования загородных строений наследует имущественное страхование
 * и реализует форму отрасли страховых обязательств
 * 
 * Основные риски: пожар, удар молнии, взрыв, воздействие третьих лиц,
 * стихийные бедствия, залив жидкостью, механические воздействия
 * Дополнительные риски: бой стекол, загрязнение участка, повреждение электронных
 * устройств, террористический акт
 */

public class PoliceCountryBuilding extends InsuranceProperty implements BranchOfInsurance, InsuranceObligations{
	
	final double FIRE = 0.7;
	final double LIGHTNING_STRIKE = 0.1;
	final double EXPLOSION = 0.2;
	final double THIRD_PARTIES = 0.2;
	final double NATURAL_DISASTERS = 0.15;
	final double LIQUID_FILLING = 0.1;
	final double MECHANICAL_INFLUENCE = 0.05;
	
	final double FIGHT_GLASS = 0.1;
	final double POLLUTION = 0.4;
	final double DAMAGE_DEVICES = 0.5;
	final double TERRORISM = 1.5;

	public PoliceCountryBuilding(String insurer, String underwriter,
			String email, String phone, String beneficiary, String address,
			String startDate, String endDate, double insurancePremium, double excess,
			double insuredSum) {
		super(insurer, underwriter, email, phone, beneficiary, address, startDate,
				endDate, insurancePremium, excess, insuredSum);
		
	}

	void drawPolice(double insurancePremium) {
		System.out.println("Drawing police on the monitor");
		System.out.println("Страхователь: " + insurer);
		System.out.println("Страховщик: " + underwriter); 
		System.out.println("Электронная почта: " + email);
		System.out.println("Телефон: " + phone); 
		System.out.println("Дата начала страхования: " + startDate); 
		System.out.println("Дата конца страхования: " + endDate); 
		System.out.println("Страховая премия: " + insurancePremium);
		System.out.println("Страховая сумма:" + insuredSum);
		System.out.println("Безусловная франшиза: " + excess); 
		System.out.println();
	}
	
	
	void printPolice() {
		System.out.println("Printing police to a printer");
		System.out.println();
	}
	
	
	double calculateDerivative(double insuredSum, double excess) {
		System.out.println("Calculating derivative");
		System.out.println("Insurance sum = " + insuredSum);
		System.out.println("Безусловная франшиза: " + excess); 
		if(excess < insuredSum/ 1000) insurancePremium = insuredSum * FIRE / 100;
		else insurancePremium = insuredSum * FIRE / 100 /2;
		
		
		
		System.out.println("Insurance premium = " + insurancePremium);
		System.out.println();
		return insurancePremium;
	}
	
	
}
