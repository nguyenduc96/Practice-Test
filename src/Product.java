import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private String name;
    private long price;
    private int quantity;
    private String note;

    public Product() {
    }

    public Product(String id, String name, long price, int quantity, String note) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "THÔNG TIN SẢN PHẨM : " +
                "Mã sản phẩm : '" + id + '\'' +
                ", Tên sản phẩm : '" + name + '\'' +
                ", Giá sản phẩm : " + price +
                ", Số lượng : " + quantity +
                "\n- Mô tả : '" + note + '\'';
    }
}
