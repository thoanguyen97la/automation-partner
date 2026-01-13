package pages.components.homewidgets;
import org.openqa.selenium.WebElement;

public class TopSellProductModel {
    public String name;
    public String soldInfo;
    public String price;
    public WebElement element; // Lưu lại element để click khi cần

    public TopSellProductModel(String name, String soldInfo, String price, WebElement element) {
        this.name = name;
        this.soldInfo = soldInfo;
        this.price = price;
        this.element = element;
    }
}
