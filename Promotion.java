public class Promotion {
    private String promoCode;
    private double discount;

    public Promotion(String promoCode, double discount) {
        this.promoCode = promoCode;
        this.discount = discount;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public double getDiscount() {
        return discount;
    }
}