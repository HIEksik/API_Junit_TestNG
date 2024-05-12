package pojos;

public class PojoHerOkuAppBookingdates {

    //1- Tum variableler Private olarak oluşturulur
    /*
                                 "checkin" : "2021-06-01",
    	                         "checkout" : "2021-06-10"
     */

    private String checkin;
    private String checkout;

    //2-Tüm variable'lar için getter and setter metodları oluşturulur
    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    //3-Tüm variable'ları kullanarak bir parametreli constructor oluşturalım

    public PojoHerOkuAppBookingdates(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }



    //4-Ölen default olan parametresiz constructor yeniden oluşturlım
    public PojoHerOkuAppBookingdates() {
    }


    //Information(Bilgi) için toStringmetodu oluşturulur

    @Override
    public String toString() {
        return "PojoHerOkuAppBookingdates{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
