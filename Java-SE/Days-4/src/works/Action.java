package works;

public class Action {

    protected int age = 30; // Default Erişim Belirteci -> sadece kendi paketindeki classlar tarafından görün.
    public String name = "Ali Bilmem"; // public -> her yerden görün
    private String tcNo = "12345623451"; // private -> sadece kendi sınıfının içinde görün

    public int count() {
        call();
        return tcNo.length();
    }

    private void call() {
        System.out.println("This Line Call");
    }

}
