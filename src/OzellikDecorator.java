//GENEL ÖZELLİK (İSİM TERCİHİ GİBİ) SINIFI   ->   Katılımcı Rol: Decorator
public abstract class OzellikDecorator extends FormaComponent{
  //her özelliğin yazısı ayrı olacak
  public abstract String getAciklama();
}

//AYRI AYRI ÖZELLİK ÇEŞİTLERİ   ->   Katılımcı Rol: ConcreteDecorator
class IsimConcreteDecorator extends OzellikDecorator{
    FormaComponent forma;
    String isim;
    public IsimConcreteDecorator(FormaComponent forma, String isim){ this.forma=forma; this.isim=isim; }

    //"soyut" açıklama ve fiyat metodları override edilir
    @Override
    public String getAciklama(){ return isim+" isimli "+forma.getAciklama(); }
    @Override
    public double fiyat(){
        return forma.fiyat()+100;
    }
}

class NumaraConcreteDecorator extends OzellikDecorator{
    FormaComponent forma;
    String numara;
    public NumaraConcreteDecorator(FormaComponent forma, String numara){ this.forma=forma; this.numara=numara; }

    //"soyut" açıklama ve fiyat metodları override edilir
    @Override
    public String getAciklama(){ return numara+" numaralı "+forma.getAciklama(); }
    @Override
    public double fiyat(){
        return forma.fiyat()+50;
    }
}