import java.util.Scanner;

public class ProductMenu {
    ProductManagement productManagement = new ProductManagement();
    Scanner scanner = new Scanner(System.in);

    public void runProductMenu() {
        int choice;
        do {
            readFileToProgram();
            menu();
            choice = getChoice();
            switch (choice) {
                case 1: {
                    addProductToList();
                    break;
                }
                case 2: {
                    deleteProduct();
                    break;
                }
                case 3: {
                    editProductInfo();
                    break;
                }
                case 4: {
                    displayAllProduct();
                    break;
                }
                case 5: {
                    sortProduct();
                    break;
                }
                case 6: {
                    findProductWithPrice();
                    break;
                }
                default: {
                    System.out.println("SỐ NHẬP VÀO KHÔNG HỢP LỆ MỜI NHẬP LẠI");
                }
            }
        } while (choice != 0);
    }

    private void findProductWithPrice() {
        int choice;
        do {
            menuFindProduct();
            choice = getChoice();
            switch (choice) {
                case 1: {
                    productManagement.sortBigToSmall();
                    System.out.println("SẢN PHẨM ĐẮT NHẤT");
                    System.out.println(productManagement.getProductList().get(0));
                    break;
                }
                case 2: {
                    productManagement.sortSmallToBig();
                    System.out.println("SẢN PHẨM RẺ NHẤT");
                    System.out.println(productManagement.getProductList().get(0));
                    break;
                }
                case 0: {
                    break;
                }
                default: {
                    System.out.println("SỐ NHẬP VÀO KHÔNG HỢP LỆ MỜI NHẬP LẠI");
                }
            }
        } while (choice != 0);
    }

    private void menuFindProduct() {
        System.out.println("TÌM SẢN PHẨM THEO GIÁ");
        System.out.println("1. Sản phẩm có giá đắt nhất");
        System.out.println("2. Sản phẩm có giá rẻ nhất");
        System.out.println("0. Thoát");
    }

    private void sortProduct() {
        int choice = -1;
        do {
            menuSort();
            choice = getChoice();
            switch (choice) {
                case 1: {
                    productManagement.sortSmallToBig();
                    break;
                }
                case 2: {
                    productManagement.sortBigToSmall();
                    break;
                }
                case 3: {
                    productManagement.sortNameAToZ();
                    break;
                }
                case 4: {
                    productManagement.sortNameZToA();
                    break;
                }
                case 0: {
                    break;
                }
                default: {
                    System.out.println("SỐ BẠN NHẬP KHÔNG ĐÚNG VỚI MEMU MỜI NHẬP LẠI");
                    choice = -1;
                    break;
                }
            }
            productManagement.displayAll();
            writeProgramTofile();
        } while (choice == -1);
    }

    private void menuSort() {
        System.out.println("SẮP XẾP SẢN PHẨM");
        System.out.println("1. Sắp xếp theo giá bé -> lớn ");
        System.out.println("2. Sắp xếp theo giá lớn -> bé ");
        System.out.println("3. Sắp xếp theo tên A -> Z ");
        System.out.println("4. Sắp xếp theo tên Z - A");
        System.out.println("0. Quay lại");
    }

    private void displayAllProduct() {
        productManagement.displayAll();
    }

    private void editProductInfo() {
        System.out.println("Nhập vào mã sản phẩm : ");
        String id = scanner.nextLine();
        int index = productManagement.findId(id);
        if (index == -1) {
            System.out.println("Không có mã sản phẩm này. Không thể xóa");
        } else {
            Product product = createProduct();
            productManagement.update(index, product);
            System.out.println("SỬA THÀNH CÔNG");
        }
        writeProgramTofile();
    }

    private void deleteProduct() {
        System.out.println("Nhập vào mã sản phẩm : ");
        String id = scanner.nextLine();
        int index = productManagement.findId(id);
        if (index == -1) {
            System.out.println("Không có mã sản phẩm này. Không thể xóa");
        } else {
            productManagement.delete(index);
            System.out.println("ĐÃ XÓA SẢN PHẨM");
        }
        writeProgramTofile();
    }

    private void addProductToList() {
        System.out.println("THÊM SẢN PHẨM MỚI");
        Product product = createProduct();
        productManagement.addNew(product);
        writeProgramTofile();
    }

    private Product createProduct() {
        String id;
        int index;
        do {
            System.out.println("Mã sản phẩm : ");
            id = scanner.nextLine();
            index = productManagement.findId(id);
            if (index != -1) {
                System.out.println("Mã sản phẩm đã tồn tại mời nhập lại");
            }
        } while (index != -1);
        System.out.println("Tên sản phẩm : ");
        String name = scanner.nextLine();
        long price = inputPriceProduct();
        int quantity = inputQuantityProduct();
        System.out.println("Mô tả  : ");
        String note = scanner.nextLine();
        return new Product(id, name, price, quantity, note);
    }

    private int inputQuantityProduct() {
        int quantity = -1;
        do {
            try {
                System.out.println("Số lượng : ");
                String inputQuantity = scanner.nextLine();
                quantity = Integer.parseInt(inputQuantity);
                if (quantity <= 0) {
                    System.out.println("CẦN NHẬP VÀO SỐ LỚN HƠN 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("BẠN PHẢI NHẬP VÀO DẠNG SỐ");
            }
        } while (quantity <= 0);
        return quantity;
    }

    private long inputPriceProduct() {
        long price = -1;
        do {
            try {
                System.out.println("Giá : ");
                String inputPrice = scanner.nextLine();
                price = Long.parseLong(inputPrice);
                if (price <= 0) {
                    System.out.println("CẦN NHẬP VÀO SỐ LỚN HƠN 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("BẠN PHẢI NHẬP VÀO DẠNG SỐ");
            }
        } while (price <= 0);
        return price;
    }

    private int getChoice() {
        int choice = -1;
        try {
            System.out.println("Mời bạn chọn : ");
            String inputChoice = scanner.nextLine();
            choice = Integer.parseInt(inputChoice);
        } catch (NumberFormatException e) {
            System.out.println("BẠN PHẢI NHẬP VÀO DẠNG SỐ");
        }
        return choice;
    }

    public void readFileToProgram() {
        productManagement.readFile("product.txt");
    }

    public void writeProgramTofile() {
        productManagement.writeFile("product.txt");
    }

    private void menu() {
        System.out.println("CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM");
        System.out.println("1. Thêm sản phẩm");
        System.out.println("2. Xóa một sản phẩm");
        System.out.println("3. Sửa thông tin sản phẩm");
        System.out.println("4. Xem danh sách sản phẩm");
        System.out.println("5. Sắp xếp sản phẩm");
        System.out.println("6. Tìm kiếm sản phẩm theo giá");
        System.out.println("0. Thoát chương trình");
    }
}
