import java.util.Scanner;

//FORMA SİPARİŞİ UYGULAMASI
public class Main {
    public static void main(String[] args){
    	String formaSecimi="";
		FormaComponent forma=new IcSahaConcreteComponent();
		Scanner scanner=new Scanner(System.in);
		
    	while(!formaSecimi.equals("0")) {
    		//forma türü belirlenir
    		while(!formaSecimi.equals("1") && !formaSecimi.equals("2")) {
    			System.out.print("(1-İç Saha (1000₺), 2-Deplasman (750₺), 0-Çıkış) İstediğiniz forma türünü ya da çıkış yapmayı seçebilirsiniz: ");
        		formaSecimi=scanner.nextLine();
        		if(formaSecimi.equals("1")) { forma=new IcSahaConcreteComponent(); }
        		else if(formaSecimi.equals("2")) { forma=new DeplasmanConcreteComponent(); }
        		else if(formaSecimi.equals("0")) { break; }
        		else { System.out.println("Hatalı girdi!"); }
    		}
    		if(formaSecimi.equals("0")) { break; }
    		
    		//isim için sorulur
    		char[] isim=new char[1];
			int harf=0;
    		do {
    			System.out.print("(0-İsimsiz) Formanın arkasında yazmasını istediğiniz ismi yazabilirsiniz veya isimsiz olarak devam edebilirsiniz: ");
        		String isimSecimi=scanner.nextLine();
        		if(!isimSecimi.trim().equals("")){ if(!isimSecimi.trim().equals("0")){
	        			isim=isimSecimi.toCharArray();
	            		for(char hane : isim) {
	            			if(Character.isLetter(hane)) { harf++; }
	            		}
	            		if(harf==isim.length) { forma=new IsimConcreteDecorator(forma, isimSecimi.trim()); break; }
	            		else { System.out.println("İsim kısmı sadece harflerden oluşmalıdır!"); }
        			}
        			else { break; }
        		}
        		else { System.out.println("Bu alan boş bırakılamaz. İsim istemiyorsanız 0 yazınız."); }
    		}while(harf!=isim.length);
    		
    		//numara için sorulur
    		char[] numara=new char[3];
    		int sayi=0;
    		do {
    			System.out.print("(0-Numarasız) Formanın arkasında yazmasını istediğiniz numarayı yazabilirsiniz veya numarasız olarak devam edebilirsiniz: ");
        		String numaraSecimi=scanner.nextLine();
                if(!numaraSecimi.trim().equals("")) { if(!numaraSecimi.trim().equals("0")){ if(!(numaraSecimi.trim().length()>2)) {
    	            		numara=numaraSecimi.toCharArray();
    	            		for(char hane : numara) {
    	            			if(Character.isDigit(hane)) { sayi++; }
    	            		}
    	            		if(sayi==numara.length) { forma=new NumaraConcreteDecorator(forma, numaraSecimi.trim()); break; }
    	            		else { System.out.println("Numara kısmı sadece 1-99 aralığındaki sayılardan oluşabilir!"); }
                		}
                		else { System.out.println("Numara kısmı sadece 1-99 aralığındaki sayılardan oluşabilir!"); }
                	}
                	else { break; }
                }
        		else { System.out.println("Bu alan boş bırakılamaz. Numara istemiyorsanız 0 yazınız."); }
    		}while(sayi==numara.length || !(numara.length<3));
    		
            //kişiselleştirilen formanın bilgileri
            System.out.println(forma.getAciklama()+"; "+forma.fiyat()+" ₺");
            
            formaSecimi="";
    	}
    	//çıkış mesajı
    	System.out.println("Sistemden çıkış yapılıyor. Görüşürüz...");
    }
}