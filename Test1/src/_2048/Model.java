package _2048;

import java.util.ArrayList;


public class Model {
	
	int rijen, kolommen;
	ArrayList<Integer> waarden;
	Settings settings;
	boolean lost= false;

	public boolean isLost() {
		return lost;
	}

	public void setLost(boolean lost) {
		this.lost = lost;
	}

	public Model(Settings settings){
		this.settings = settings;
		rijen = settings.getRijen();
		kolommen = settings.getKolommen();
		ArrayList<Integer> waarden = new ArrayList<Integer>(rijen*kolommen);
		for (int i = 0 ; i < rijen*kolommen; i++)
		{
			waarden.add(0);
		}
		this.waarden = waarden;
		
	}
	/** Get the current line number.
	 * @return int - Current line number.
	 */
	public static int getLineNumber() {
	    return Thread.currentThread().getStackTrace()[2].getLineNumber();
	}
	
	public void links(){
		
		
//		this.rijen = rijen;
//		this.kolommen = kolommen;
//		this.waarden = waarden;
//		
//		
//		//  wordt aangeroepen als de gebruiker naar links wil
//		// 	rij voor rij wordt opgehaald
//		// 	eerst schuiven de getallen naar links (swipeLinks)
//		// 	vervolgens worden de waarden gecheckt op matches
//		
//		//maak nieuwe array aan voor alle rijen en kolommen
//		ArrayList<Integer> nieuw = new ArrayList<Integer>(rijen*kolommen);
//		
//		for (int j = 0; j < rijen; j++){
//			// haal rij op
//			ArrayList<Integer> rij1 = new ArrayList<Integer>(kolommen); 
//			for (int i = 0 ; i < kolommen; i++){
//				rij1.add(waarden.get(j*kolommen+i)) ;
//			}
//			//zet rij om in nieuwe waarden
//			//ArrayList<Integer> rij2 = checkmatches(swipeLinks(rij1));
//			//ArrayList<Integer> rij2 = swipeLinks(rij1);
//			// voeg de nieuwe rij-waarden toe aan nieuw
//			//for (int i=0; i<kolommen; i++){
//			//	nieuw.add(rij2.get(i));
//			//}
//		}
//		for (int i =0 ; i < rijen*kolommen; i++){
//			waarden.set(i, nieuw.get(i));
//		}
//		//this.repaint();
//		System.out.println(waarden);
//		//waarden = voegwaardetoe(waarden);
//		System.out.println(waarden);
		
//		Stap 1: Schuif alle niet-0 waarden naar links			
// 		Stap 2:	Tel alle aangrenzende waarden bij elkaar op
// 		Stap 3: Schuif nog een keer de niet-0 waarden naar links
//		stap 1-3 gecombineerd
		System.out.println("onbewerkte waarden: "+waarden);
		waarden = schuifNaarLinks(waarden);
		
//		Stap 4: Voeg een random waarde toe
		waarden = voegWaardeToe(waarden);
		
	}
	
	private ArrayList<Integer> schuifNaarLinks(ArrayList<Integer> waarden){
		
		//stap 1  Maak een returnarray aan
		ArrayList<Integer> returnArray = new ArrayList<Integer>(rijen*kolommen);
		
		// maak een boolean "checked", die bijhoudt of een waarde genegeerd moet worden, namelijk het getal dat 
		// verdubbeld werd
		boolean checked = false;
		
		//stap 2: Haal rij op, voor elke rij:
		
		for (int rijcount = 0; rijcount<rijen; rijcount++){
			ArrayList<Integer> rij = new ArrayList<Integer>(kolommen);
			//vul de rij met waarden (kolommen geeft het aantal aan)
			for (int kolomcount = 0; kolomcount< kolommen; kolomcount++) {
				rij.add(waarden.get(kolomcount + rijcount*kolommen));
				}
				System.out.println("---- rij: "+rij+" -----");
				//maak een counter aan, om het aantal posities bij te houden (gelijk aan kolommen)
				int counter = 0;
				//stel "checked" in op false, omdat de eerste waarde van een rij nooit genegeerd moet worden
				checked = false;
				
				//a. vergelijk positie 1 en 2
				
				//als gelijk en geen 0		
				if ((rij.get(0)==rij.get(1)) && ( rij.get(0)!= 0)){
					//vul de returnarray aan met de waarde (positie1 * 2)
					returnArray.add(rij.get(1)*2);
					System.out.println(getLineNumber()+": "+returnArray+"(gelijk en geen 0)");
					//stel "checked" in op true - de volgende waarde die we uitlezen moet genegeerd worden
					checked = true;
					// verhoog de counter met 1 om bij te houden hoeveel rijposities we gevuld hebben
					counter++;
				}	
				//als gelijk en 0, vul de rij niet aan
				else if (rij.get(0)==rij.get(1)){	
					System.out.println(getLineNumber()+": "+returnArray+"(gelijk en 0)");
				}
				//als niet gelijk (anders)
				else{
					//vul de doelarray aan met de waarde (positie 1)
					returnArray.add(rij.get(0));
					System.out.println(getLineNumber()+": "+returnArray+"(ongelijk)");
					// verhoog de counter met 1 om bij te houden hoeveel rijposities we gevuld hebben
					counter++;
				}
				
				//b. voor elk volgende getal (m.u.v. de laatste die we uitlezen)
				for (int i = 1; i < kolommen-1; i++){
					//als "checked" niets doen - de waarde was al opgeteld en dit resulteert in een 0 op het eind
					if (checked){
						// alleen checked weer op false zetten
						System.out.println(getLineNumber()+": "+returnArray+"(checked)");
						checked = false;
					}
					//anders:
					else{
						//als huidige positie en (huidige positie+1) gelijk zijn en niet gelijk aan 0
						if ((rij.get(i)==rij.get(i+1)) && ( rij.get(i)!= 0)){
							//vul de returnarray aan op met de waarde (positie1 * 2)
							returnArray.add(rij.get(i)*2);
							System.out.println(getLineNumber()+": "+returnArray+"(gelijk maar geen 0)");
							//stel "checked" in op true - de volgende waarde die we uitlezen moet genegeerd worden
							checked = true;
							// verhoog de counter met 1 om bij te houden hoeveel rijposities we gevuld hebben 
							counter++;
						}
						//als gelijk en 0, vul de rij niet aan
						else if (rij.get(i)==rij.get(i+1)){	
						}
						//als niet gelijk (anders)
						else{
							//vul de doelarray aan met de waarde (positie huidig)
							returnArray.add(rij.get(i));
							System.out.println(getLineNumber()+": "+returnArray+"(niet gelijk)");
							// verhoog de counter met 1 om bij te houden hoeveel rijposities we gevuld hebben
							counter++;
						}
					
				}
				
			}
					
			//c. voor het laatste getal dat we uitlezen)
			//als "checked" niets doen - de waarde was al opgeteld en dit resulteert in een 0 op het eind
			if (checked){
			}
			//anders als 0, vul de rij niet aan
			else if (rij.get(kolommen-1)==0){
			}
			//als niet 0
			else{
				//vul de doelarray aan met de waarde (positie huidig)
				returnArray.add(rij.get(kolommen-1));
				System.out.println(getLineNumber()+": "+returnArray);
				// verhoog de counter met 1 om bij te houden hoeveel rijposities we gevuld hebben
				counter++;
			}			
			//d.	voor alle lege posities: dit is het aantal kolommen minus de counter			
			for (int i=0 ; i <kolommen-counter; i++){
				// vul de doelarray aan met 0
				returnArray.add(0);
				System.out.println(getLineNumber()+": "+returnArray);
			}			
	}
	
	//Stap 3. return de doellarray
	System.out.println(returnArray);
	return returnArray;
	}
	



	
	
	public ArrayList<Integer> voegWaardeToe(ArrayList<Integer> waarden){
		
		
		//stel de counter in
		int telnullen = 0;
		//	boolean om bij te houden of er nog plekken leeg zijn
		boolean legeplekken = true;
		
		// tel hoeveel waarden er gelijk zijn aan 0 
		for (int i = 0; i< rijen*kolommen; i++){
			if (waarden.get(i)==0){
				telnullen++;
			}
		}
		// geef een random waarde voor de spawnplek
		double sp = (Math.random()*telnullen);
		//maak er een integer van
		int spawnpositie = (int) (sp);
		int teller = 0;
		
		// lees de waarden opnieuw uit
		for (int i = 0; i< rijen*kolommen; i++){
			// als de waarde niet gelijk is aan 0 gebeurt er niets
			if(waarden.get(i)!=0){
			}
			// als de teller gelijk staat aan de spawnpositie dan komt op die plek en de array een 2
			else if (teller == spawnpositie){
				waarden.set(i, 2);	
				// de teller wordt 1 opgehoogd zodat bij verder doorlopen van de loop de spawpositie niet meer gelijk is
				teller++;
			}	
			else {		
				//de teller wordt 1 opgehoogd
				teller++;
			}
			
		
		}
		//check of er nog mogelikheden zijn
		if (!legeplekken){
			lost = true;
		}
		return waarden;
		
	}
	
	public ArrayList<Integer> swipeLinks(ArrayList<Integer> rij1){
		
		//maak returnarray 
		ArrayList<Integer> rij2 = new ArrayList<Integer>(rijen*kolommen);
			
		// teller die bijhoudt hoeveel waarden in de returnarray geschreven zijn
		int rij2count = 0;
		
		// alle niet-0 waarden achterelkaar in de array wegschrijven
		// dus alle niet-0 waarden schuiven naar links
		for (int i= 0 ; i < kolommen; i++){
			if (rij1.get(i)!=0){
				rij2.add(rij1.get(i));
				rij2count++;	
			}
		}
		// de rest van de kolommen vullen met 0-waarden
		while (rij2count<kolommen){			
				rij2.add(0);
				rij2count++;
		}
		rijToString(rij2);
		return rij2;
	}

	public ArrayList<Integer> checkmatches(ArrayList<Integer> rij1){
		boolean checked = false;
		ArrayList<Integer> rij2 = new  ArrayList<Integer>(kolommen*rijen);
		
		//eerste getal
		if (rij1.get(0) == rij1.get(1)){
			rij2.add(rij1.get(0)*2);
			rij2.add(0);
			checked  = true;	
		}
		else {
			rij2.add(rij1.get(0));
		}
		
		//tweede  t/m voorlaatste getal
		for (int i = 1;i<kolommen-1;i++){
			if ((rij1.get(i) == rij1.get(i+1)) && !checked){
				rij2.add(rij1.get(i)*2);
				rij2.add(0);
				checked  = true;	
			}
			else if (checked){
				checked = false;
			}
			else {
				rij2.add(rij1.get(1));
			}
			
		}
	
		//laatste getal
		if (checked){
			checked = false;
		}
		else {
			rij2.add(rij1.get(kolommen-1));
		}
		return rij2;
	
		
	}
	
	public void rijToString(ArrayList<Integer> rij ){	
		for (int i = 0; i< kolommen; i++){
			System.out.print(rij.get(i)+" | ");
			
		}
		System.out.println("-----------");
		System.out.println();
	}

	public Settings getSettings() {
		// TODO Auto-generated method stub
		return settings;
	}
}
