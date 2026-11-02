//GENEL FORMA SINIFI   ->   Katılımcı Rol: Component
public abstract class FormaComponent{
    String aciklama="forması";
    public String getAciklama(){ return aciklama; }

    //her formanın fiyatı ayrı olacak
    public abstract double fiyat();
}

//AYRI AYRI FORMA ÇEŞİTLERİ   ->   Katılımcı Rol: ConcreteComponent
class IcSahaConcreteComponent extends FormaComponent{
    public IcSahaConcreteComponent(){ aciklama="iç saha "+aciklama; }

    //"soyut" fiyat metodu override edilir
    @Override
    public double fiyat(){ return 1000; }

}

class DeplasmanConcreteComponent extends FormaComponent{
    public DeplasmanConcreteComponent(){ aciklama="deplasman "+aciklama; }

    //"soyut" fiyat metodu override edilir
    @Override
    public double fiyat(){ return 750; }
}