package productmanagement;

public class ProductManagement {
  public static void main(String[] args) {
    LoginForm lf = new LoginForm();
    lf.setVisible(true);
  }

  public static void testLogin() {
    String userLoginName = "ccw";
    String userPassword = "password123";
    
    User.login(userLoginName, userPassword);
  }

  public static void testUserRegistration() {
    Administrator administrator = new Administrator(User.generateUserId(), "Admin", "AdminHome", "admin@mail.com", "admin", "adminpassword");
    User.register(administrator);

    ProductManager productManager = new ProductManager(User.generateUserId(), "ProductMan", "ProductManHome", "productman@mail.com", "productman", "productmanpassword", ProductManager.ACTIVE);
    User.register(productManager);
  }

  public static void testSupplierRegistration() {
    Supplier supplier = new Supplier(Supplier.generateSupplierId(), "IKEA", "Cheras", "ikea@gmail.com", "012-3456789", Supplier.ACTIVE);
    Supplier.register(supplier);
  }
}
