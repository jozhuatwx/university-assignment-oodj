package productmanagement;

public class ProductManagement {
  public static void main(String[] args) {
    
  }

  public static void testLogin() {
    String userLoginName = "admin";
    String userPasswordString = "adminpassword";
    char[] userPassword = userPasswordString.toCharArray();
    
    User.login(userLoginName, userPassword);
  }

  public static void testUserRegistration() {
    try {
      String adminPasswordString = "adminpassword";
      Administrator administrator = new Administrator(User.generateUserId(), "Admin", "AdminHome", "admin@mail.com", "admin", Encryption.encryptPassword(adminPasswordString.toCharArray()));
      User.register(administrator);

      String productManPasswordString = "productmanpassword";
      ProductManager productManager = new ProductManager(User.generateUserId(), "ProductMan", "ProductManHome", "productman@mail.com", "productman", Encryption.encryptPassword(productManPasswordString.toCharArray()), ProductManager.ACTIVE);
      User.register(productManager);
    } catch (Exception e) {
      // Display the error message
      System.out.println(e);
    }
  }

  public static void testUserUpdate() {
    try {
      String productManPasswordString = "uproductmanpassword";
      ProductManager productManager = new ProductManager("U00000002", "UProductMan", "UProductManHome", "uproductman@mail.com", "uproductman", Encryption.encryptPassword(productManPasswordString.toCharArray()), ProductManager.INACTIVE);
      User.update(productManager);
    } catch (Exception e) {
      // Display the error message
      System.out.println(e);
    }
  }

  public static void testSupplierRegistration() {
    Supplier supplier = new Supplier(Supplier.generateSupplierId(), "IKEA", "Cheras", "ikea@gmail.com", "012-3456789", Supplier.ACTIVE);
    Supplier.register(supplier);
  }

  public static void testSupplierUpdate() {
    Supplier supplier = new Supplier("S00000001", "UIKEA", "UCheras", "uikea@gmail.com", "012-3456789", Supplier.INACTIVE);
    Supplier.update(supplier);
  }

  public static void testCategoryRegistration() {
    ProductCategory category = new ProductCategory(ProductCategory.generateCategoryId(), "Table", "A collection of tables");
    ProductCategory.register(category);
  }

  public static void testCategoryUpdate() {
    ProductCategory category = new ProductCategory("CT00000001", "UTable", "A collection of tables");
    ProductCategory.update(category);
  }

  public static void testCategorySearch() {
    System.out.println(ProductCategory.search("Table"));
  }

  public static void testCategoryDelete() {
    ProductCategory.delete("CT00000001");
  }
}
