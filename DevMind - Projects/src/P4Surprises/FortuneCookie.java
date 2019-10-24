package P4Surprises;

import java.util.ArrayList;
import java.util.Random;

public class FortuneCookie implements ISurprise{
	private static ArrayList<String> messagesList = null;
	private String message;
	private static Random random = new Random();
	
	public static FortuneCookie generate() {
		FortuneCookie.generateMessageList();
		int n = random.nextInt(FortuneCookie.messagesList.size());
		return new FortuneCookie(FortuneCookie.messagesList.get(n));
	}
	
	public FortuneCookie(String message) {
		this.message = message;
	}
		
	private static void generateMessageList() {
		if(FortuneCookie.messagesList == null) {
			FortuneCookie.messagesList = new ArrayList<String>();
			messagesList.add("Ca să-ţi pierzi capul, trebuie să-l ai. - Albert Einstein");
			messagesList.add("Lumea pe care am creat-o este un proces al gândirii noastre. "
							+ "Nu poate fi schimbată fără a ne schimba gândirea. - Albert Einstein");
			messagesList.add("Idealurile care mi-au luminat calea şi mi-au redat din timp în timp curajul "
							+ "de a înfrunta viaţa cu bucurie, au fost: bunătatea, frumuseţea şi adevărul. - Albert Einstein");
			messagesList.add("Cel ce spune că e imposibil nu ar trebui să-l împiedice pe cel ce nu crede aşa ceva. - Albert Einstein");
			messagesList.add("Nu tot ceea ce poate fi numărat contează şi nu tot ceea ce contează poate fi numărat. - Albert Einstein");
			messagesList.add("Conduita morală nu înseamnă pur şi simplu exigenţa de a renunţa anume la plăcerile vieţii, ci mai degrabă "
							+ "interesul plin de solicitudine pe care-l depune cineva ca să făurească o soartă mai bună pentru toţi oamenii. - Albert Einstein");
			messagesList.add("Doar două lucruri sunt infinite, universul şi prostia umană, însă nu sunt sigur despre primul. - Albert Einstein");
			messagesList.add("Ce faci pentru tine, dispare odată cu tine, ce faci pentru alţii, rămâne pentru eternitate. - Albert Einstein");
			messagesList.add("Un intelectual rezolvă problemele, un geniu le evită. - Albert Einstein");
			messagesList.add("Uneori plătim mult mai mult pentru lucrurile pe care le primim pe gratis. - Albert Einstein");
			messagesList.add("Viaţa însăşi este magie, iar dacă nu crezi asta, măcar încearcă să o trăieşti ca pe ceva magic. - Albert Einstein");
			messagesList.add("Cel ce mărşăluieşte vesel în rând cu trupa, deja şi-a câştigat dispreţul meu. I s-a dat ditamai creierul din greşeală, "
							+ "din moment ce măduva spinării i-ar fi ajuns. - Albert Einstein");
			messagesList.add("Nebunia înseamnă să faci acelaşi lucru în mod repetat şi să te aştepţi să obţii alt rezultat. - Albert Einstein");
			messagesList.add("Orice prost poate să ştie. Scopul este să înţelegi. - Albert Einstein");
			messagesList.add("Încearcă să fii un om de valoare și nu neapărat un om de succes.  - Albert Einstein");
			messagesList.add("Există lucruri care ştim că sunt imposibil de realizat, până când vine cineva care nu ştie acest lucru şi "
							+ "le realizează. - Albert Einstein");
			messagesList.add("vertical - John gray live in Romania bilete conferintaViaţa este o tapiserie minunată. Individul nu e "
							+ "decât un detaliu neînsemnat dintr-un desen uriaş şi sublim. - Albert Einstein");
			messagesList.add("Viata este piatra de incercare a cuvintelor. - Alessandro Francesco Tommaso Manzoni");
			messagesList.add("Averea cea mai de pret e viata, si viata noastra, va rog sa ma credeti, nu atarna decat de un fir de par. - Alexandre Dumas");
			messagesList.add("Viata este ultima obisnuinta pe care trebuie s-o pierdem, pentru ca este prima pe care am capatat-o. - Alexandre Dumas fiul");
			messagesList.add("Viata isi are farmecul ei, depinde numai cu ce ochi o privesti. - Alexandre Dumas fiul");
			messagesList.add("Viata este o ciudata comedie care amesteca impreuna si dureri si bucurii, punand lacrimi langa zambet, punand zambet "
							+ "langa plans. - Alexandru Macedonski");
			messagesList.add("Întotdeauna între oamenii inteligenţi există un limbaj comun. - Alexandru Paleologu");
			messagesList.add("Ce este o viata frumoasa, prieteni, daca nu un gand din tinerete realizat in anii barbatiei. - Alfred de Vigny");
			messagesList.add("O viata frumoasa e un gand al tineretii infaptuit la maturitate. - Alfred de Vigny");
			messagesList.add("Viata este o ofensiva orientata impotriva mecanismului repetitiv al Universului. - Alfred North Whitehead");
			messagesList.add("Intotdeuna voi inventa viata. - Anais Nin");
			messagesList.add("Viata este un proces de devenire, o combinatie de stari prin care trebuie sa trecem. Oamenii esueaza cand doresc sa "
							+ "aleaga o stare si sa ramana in ea. Asta este un fel de moarte. - Anais Nin");
			messagesList.add("Viata e felul in care un ins pare a se fi invoit cu inacceptabila conditie umana. - Andre Breton");
			messagesList.add("Adevarul e ca, de indata ce nu mai suntem nevoiti sa ne ingrijim de viata noastra, nu mai stim ce sa facem cu ea si "
							+ "o irosim cu totul. - Andre Gide");
		}
	}
	
	public void enjoy() {
		System.out.println("\t Surpriza \"FortuneCookie\" a fost deschisa, cu mesajul: \n"
						+ "\t \"" + this.message + "\". \n");
	}
}
