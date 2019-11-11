package b1;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 */
public class B1Main {
    /**
     * Describes how VAT will be calculated
     */
    public enum VATMode {
        // VAT already included within price
        INCLUSIVE(true),

        // VAT will be added to the price
        EXCLUSIVE(true),

        // No VAT will be calculated
        NO_VAT(false);

        // whether VAT will be calculated
        private boolean vatEnabled;

        /**
         * @param vatEnabled whether VAT is will be calculated
         */
        VATMode(boolean vatEnabled) {
            this.vatEnabled = vatEnabled;
        }

        public boolean isVatEnabled() {
            return vatEnabled;
        }
    }

    public enum Country {
        // Quelle: https://www.frankfurt-main.ihk.de/recht/steuerrecht/umsatzsteuer_international/mehrwertsteuer_eu/
        BE(0.21),
        BG(0.20),
        CZ(0.21),
        DK(0.25),
        DE(0.19),
        EE(0.20),
        IE(0.23),
        EL(0.24),
        ES(0.21),
        FR(0.20),
        HR(0.25),
        IT(0.22),
        CY(0.19),
        LV(0.21),
        LT(0.21),
        LU(0.17),
        HU(0.27),
        MT(0.18),
        NL(0.21),
        AT(0.20),
        PL(0.23),
        PT(0.23),
        RO(0.19),
        SI(0.22),
        SK(0.20),
        FI(0.24),
        SE(0.25),
        UK(0.20);

        private double vatRate;

        Country(double vatRate) {
            this.vatRate = vatRate;
        }

        /**
         * Calculates the gross price based on a given net price
         * @param netPrice the net price from which the gross price will be calculated
         * @return gross price
         */
        public double calculateGross(double netPrice) {
            // https://www.papierkram.de/aktuelles/wie-berechnet-man-die-mehrwertsteuer/
            return netPrice * (1f + this.vatRate);
        }

        /**
         * Calculates the net price based on a given gross price
         * @param grossPrice the gross price from which the net price will be calculated
         * @return net price
         */
        public double calculateNet(double grossPrice) {
            // https://www.papierkram.de/aktuelles/wie-berechnet-man-die-mehrwertsteuer/
            return grossPrice / (1f + this.vatRate);
        }

        /**
         * Calculates the VAT based on a net price
         * @param netPrice the net price from which the VAT will be calculated
         * @return VAT
         */
        public double calculateVatFromNet(double netPrice) {
            return netPrice * this.vatRate;
        }

        /**
         * Calculates the VAT based on a gross price
         * @param grossPrice the gross price from which the VAT will be calculated
         * @return VAT
         */
        public double calculateVatFromGross(double grossPrice) {
            return this.calculateVatFromNet(this.calculateNet(grossPrice));
        }

        public double getVatRate() {
            return this.vatRate;
        }
    }

    public enum PaymentMethod {
        CASH(10000, 0, "cash"),
        CREDIT_CARD(2000, 0.02, "credit card"),
        DIRECT_DEBIT(1000, 0.01, "direct debit"), // Lastschrift
        GIFT_CODE(100, 0, "gift code"); // Geschenkgutschein

        // Maximaler erlaubter Betrag für Zahlungsmethode
        private int maxAllowedPrice;

        // Anfallende Gebühren für Zahlungsmethode (abhängig vom Preis)
        private double fee;

        private String name;

        PaymentMethod(int maxAllowedPrice, double fee, String name) {
            this.maxAllowedPrice = maxAllowedPrice;
            this.fee = fee;
            this.name = name;
        }

        public double calculateFee(double price) {
            return price * this.fee;
        }

        public boolean isMethodAllowed(double price) {
            return !(this.maxAllowedPrice < price);
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

    /**
     * Initiate a payment
     * If payment method is allowed, potentially a fee will be added to the price.
     * Based on the final price and the country, the VAT part of the final price will be calculated and printed out.
     * @param method Payment method to use
     * @param price Price which has to be paid
     * @param country Country used for VAT calculation
     */
    private static void makePayment(PaymentMethod method, double price, Country country, VATMode vatMode) {
        if (method.isMethodAllowed(price)) {
            double finalPrice = method.calculateFee(price) + price;
            double vatPart = 0;

            switch (vatMode) {
                case INCLUSIVE:
                    vatPart = country.calculateVatFromGross(finalPrice);
                    break;
                case EXCLUSIVE:
                    vatPart = country.calculateVatFromNet(finalPrice);
                    finalPrice += vatPart;
                    break;
                case NO_VAT:
                default:
                    break;
            }

            // TODO: do something

            System.out.printf("Payment of %.2f using %s succeeded!", finalPrice, method);
            System.out.println();
            if (vatMode.isVatEnabled()) {
                System.out.printf("Final price of %.2f includes %.2f VAT (%.2f%%).", finalPrice, vatPart, country.getVatRate());
                System.out.println();
            } else {
                System.out.println("No VAT has been calculated.");
            }
        } else {
            System.out.printf("Price is too high for payment method \"%s\"!", method.toString());
            System.out.println();

        }

        System.out.println();
    }

    public static void main(String[] args) {
        makePayment(PaymentMethod.CREDIT_CARD, 123.45, Country.DE, VATMode.INCLUSIVE);
        makePayment(PaymentMethod.CASH, 12356.67, Country.FR, VATMode.EXCLUSIVE);
        makePayment(PaymentMethod.CASH, 765.43, Country.FR, VATMode.EXCLUSIVE);
        makePayment(PaymentMethod.DIRECT_DEBIT, 555.55, Country.DK, VATMode.NO_VAT);
    }
}
