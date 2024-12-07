public class SurplusFrame {
    private String itemName;
    private int quantity;
    private String expirationDate;

    // Constructor
    public SurplusFrame(String itemName, int quantity, String expirationDate) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
    }

    // Getters and Setters
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Surplus{" +
                "itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", expirationDate='" + expirationDate + '\'' +
                '}';
    }
}
