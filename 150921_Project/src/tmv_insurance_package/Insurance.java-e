package tmv_insurance_package;

public class Insurance {

	
	public static void main(String[] args) {
		
		PoliceCountryBuilding pcb = new PoliceCountryBuilding("Телегин Михаил", "Ренессанс-страхование",
						"teleginmv@gmail.com", "+79219342034", "Телегин Михаил", "улица Ленина 77",
						"24 сентября 2015г.", "24 сентября 2016г.", 0, 0,
						4500000);
		
		PoliceCountryBuilding pcb2 = new PoliceCountryBuilding("Телегин Михаил", "Ренессанс-страхование",
				"teleginmv@gmail.com", "+79219342034", "Телегин Михаил", "улица Ленина 77",
				"24 сентября 2015г.", "24 сентября 2016г.", 0, 50000.0,
				4500000);
		
		double ip= pcb.calculateDerivative(pcb.getInsuredSum(), pcb.getExcess());
		pcb.drawPolice(ip);
		pcb.printPolice();
		
		double ip2= pcb2.calculateDerivative(pcb2.getInsuredSum(), pcb2.getExcess());
		pcb2.drawPolice(ip2);
		pcb2.printPolice();
		
	}
}
