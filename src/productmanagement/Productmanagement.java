package productmanagement;

public class ProductManagement {
  public static void main(String[] args) {

  }

  public static void testLogin() {
    String userLoginName = "admin";
    String userPassword = "adminpassword";
    
    User.login(userLoginName, userPassword);
  }

  public static void testUserRegistration() {
    Administrator administrator = new Administrator(User.generateUserId(), "Admin", "AdminHome", "admin@mail.com", "admin", "adminpassword");
    User.register(administrator);

    ProductManager productManager = new ProductManager(User.generateUserId(), "ProductMan", "ProductManHome", "productman@mail.com", "productman", "productmanpassword", ProductManager.ACTIVE);
    User.register(productManager);
  }

  public static void testUserUpdate() {
    ProductManager productManager = new ProductManager("U00000002", "UProductMan", "UProductManHome", "uproductman@mail.com", "uproductman", "uproductmanpassword", ProductManager.INACTIVE);
    User.update(productManager);
  }

  public static void testSupplierRegistration() {
    Supplier supplier = new Supplier(Supplier.generateSupplierId(), "IKEA", "Cheras", "ikea@gmail.com", "012-3456789", Supplier.ACTIVE);
    Supplier.register(supplier);
  }

  public static void testSupplierUpdate() {
    Supplier supplier = new Supplier("S00000002", "UIKEA", "UCheras", "uikea@gmail.com", "012-3456789", Supplier.INACTIVE);
    Supplier.update(supplier);
  }
}
