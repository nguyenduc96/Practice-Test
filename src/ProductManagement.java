import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManagement implements IGeneralManagement<Product> {
    List<Product> productList = new ArrayList<>();

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public void addNew(Product product) {
        productList.add(product);
    }

    @Override
    public void displayAll() {
        for (Product p : productList) {
            System.out.println(p);
        }
    }

    @Override
    public void delete(int index) {
        productList.remove(index);
    }

    @Override
    public void update(int index, Product product) {
        productList.set(index, product);
    }

    @Override
    public int findId(String id) {
        int index = -1;
        for (int i = 0; i < productList.size(); i++) {
            if (id.equals(productList.get(i).getId())) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public List<Product> readFile(String path) {
        try {
            InputStream is = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(is);
            productList = (List<Product>) ois.readObject();
            ois.close();
            is.close();
        }catch (EOFException e) {
            return null;
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public void writeFile(String path) {
        try {
            OutputStream os = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(productList);
            oos.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sortBigToSmall() {
        Product product;
        int position;
        for (int i = 1; i < productList.size(); i++) {
            product = productList.get(i);
            position = i;
            while (position > 0 && (product.getPrice() > productList.get(position - 1).getPrice())) {
                productList.set(position, productList.get(position - 1));
                position--;
            }
            productList.set(position, product);
        }
    }

    public void sortSmallToBig() {
        Product product;
        int position;
        for (int i = 1; i < productList.size(); i++) {
            product = productList.get(i);
            position = i;
            while (position > 0 && (product.getPrice() < productList.get(position - 1).getPrice())) {
                productList.set(position, productList.get(position - 1));
                position--;
            }
            productList.set(position, product);
        }
    }

    public void sortNameZToA() {
        Product product;
        int position;
        for (int i = 1; i < productList.size(); i++) {
            product = productList.get(i);
            position = i;
            while (position > 0 && (product.getName().compareTo(productList.get(position - 1).getName()) > 0)) {
                productList.set(position, productList.get(position - 1));
                position--;
            }
            productList.set(position, product);
        }
    }

    public void sortNameAToZ() {
        Product product;
        int position;
        for (int i = 1; i < productList.size(); i++) {
            product = productList.get(i);
            position = i;
            while (position > 0 && (product.getName().compareTo(productList.get(position - 1).getName()) < 0)) {
                productList.set(position, productList.get(position - 1));
                position--;
            }
            productList.set(position, product);
        }
    }
}
