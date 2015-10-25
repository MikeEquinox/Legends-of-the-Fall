package tmv_insurance_package;

/**
 * @author teleginmv
 * Класс имущественного страхования реализует форму отрасли страховых обязательств
 */

public class InsuranceProperty implements BranchOfInsurance, InsuranceObligations {

	String insurer;		//страхователь
	String underwriter;	//страховщик
	String email;		//эл. почта страхователя
	String phone;		//телефон страхователя
	String beneficiary;	//выгодоприобретатель
	String address;		//адрес объекта
	String startDate;	//дата начала страхования
	String endDate;		//дата конца страхования
	double insurancePremium;	//страховая премия
	double excess;			//безусловная франшиза
	double insuredSum;		//страховая сумма
	
	public InsuranceProperty(String insurer, String underwriter, String email,
			String phone, String beneficiary, String address, String startDate,
			String endDate, double insurancePremium, double excess, double insuredSum) {
		super();
		this.insurer = insurer;
		this.underwriter = underwriter;
		this.email = email;
		this.phone = phone;
		this.beneficiary = beneficiary;
		this.address = address;
		this.startDate = startDate;
		this.endDate = endDate;
		this.insurancePremium = insurancePremium;
		this.excess = excess;
		this.insuredSum = insuredSum;
	}

	public double getInsuredSum() {
		return insuredSum;
	}

	public void setInsuredSum(double insuredSum) {
		this.insuredSum = insuredSum;
	}

	public double getExcess() {
		return excess;
	}

	public void setExcess(double excess) {
		this.excess = excess;
	}
	
}
