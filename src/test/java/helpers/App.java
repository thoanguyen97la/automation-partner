package helpers;

import io.appium.java_client.android.AndroidDriver;
import pages.*;
import pages.Orders.OrderPage;
import pages.Orders.pickup.PickUpSection;
import pages.Orders.pickup.PickupInTransitTab;
import pages.Orders.trip.TripSection;
import pages.components.BottomMenu;
import pages.components.homewidgets.TopSellProductModel;
import pages.components.homewidgets.TopSellWidget;
import pages.components.sheets.ProductShareBottomSheet;
import pages.components.sheets.QRCodeShareBottomSheet;
import pages.components.sheets.RewardBottomSheet;
import pages.components.sheets.TopSellInfoBottomSheet;
import tests.verifiers.AppStateVerifiers;
import tests.verifiers.SystemShareSheet;

public class App {
    private static AndroidDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private SearchPage searchPage;
    private Customer360 customer360Page;
    private NotificationPage notificationPage;
    private ShareStationPosterPage shareStationPosterPage;
    private PerformancePage performancePage;
    private ProductDetailPage  productDetailPage;
    private RewardStatisticsPage rewardStatisticsPage;
    private TopSellPage topSellPage;
    private TopSellWidget topSellWidget;
    private UserInfoPage userInfoPage;
    private UserManagementPage userManagementPage;
    private ProductShareBottomSheet productShareBottomSheet;
    private QRCodeShareBottomSheet qrCodeShareBottomSheet;
    private RewardBottomSheet rewardBottomSheet;
    private TopSellInfoBottomSheet topSellInfoBottomSheet;
    private BottomMenu bottomMenu;
    private OrderPage orderPage;
    private PickUpSection pickUpSection;
    private PickupInTransitTab pickupInTransitTab;
    private TripSection tripSection;
    private AppStateVerifiers appStateVerifiers;
    private SystemShareSheet systemShareSheet;

    public App(AndroidDriver driver) {
        App.driver = driver;
    }
    public LoginPage loginPage() {
        if(loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }
    public HomePage homePage() {
        if(homePage == null) {
            homePage = new HomePage(driver);
        }
        return homePage;
    }
    public SearchPage searchPage() {
        if (searchPage == null) {
            searchPage = new SearchPage(driver);
        }
        return searchPage;
    }
    public Customer360 customer360Page() {
        if (customer360Page == null) {
            customer360Page = new Customer360(driver);
        }
        return customer360Page;
    }
    public NotificationPage notificationPage() {
        if (notificationPage == null) {
            notificationPage = new NotificationPage(driver);
        }
        return notificationPage;
    }

    public ShareStationPosterPage shareStationPosterPage() {
        if (shareStationPosterPage == null) {
            shareStationPosterPage = new ShareStationPosterPage(driver);
        }
        return shareStationPosterPage;
    }

    public PerformancePage performancePage() {
        if (performancePage == null) {
            performancePage = new PerformancePage(driver);
        }
        return performancePage;
    }

    public ProductDetailPage productDetailPage() {
        if (productDetailPage == null) {
            productDetailPage = new ProductDetailPage(driver);
        }
        return productDetailPage;
    }

    public RewardStatisticsPage rewardStatisticsPage() {
        if (rewardStatisticsPage == null) {
            rewardStatisticsPage = new RewardStatisticsPage(driver);
        }
        return rewardStatisticsPage;
    }

    public TopSellPage topSellPage() {
        if (topSellPage == null) {
            topSellPage = new TopSellPage(driver);
        }
        return topSellPage;
    }

    public TopSellWidget topSellWidget() {
        if (topSellWidget == null) {
            topSellWidget = new TopSellWidget(driver);
        }
        return topSellWidget;
    }

    public UserInfoPage userInfoPage() {
        if (userInfoPage == null) {
            userInfoPage = new UserInfoPage(driver);
        }
        return userInfoPage;
    }

    public UserManagementPage userManagementPage() {
        if (userManagementPage == null) {
            userManagementPage = new UserManagementPage(driver);
        }
        return userManagementPage;
    }

    public ProductShareBottomSheet productShareBottomSheet() {
        if (productShareBottomSheet == null) {
            productShareBottomSheet = new ProductShareBottomSheet(driver);
        }
        return productShareBottomSheet;
    }

    public QRCodeShareBottomSheet qrCodeShareBottomSheet() {
        if (qrCodeShareBottomSheet == null) {
            qrCodeShareBottomSheet = new QRCodeShareBottomSheet(driver);
        }
        return qrCodeShareBottomSheet;
    }

    public RewardBottomSheet rewardBottomSheet() {
        if (rewardBottomSheet == null) {
            rewardBottomSheet = new RewardBottomSheet(driver);
        }
        return rewardBottomSheet;
    }

    public TopSellInfoBottomSheet topSellInfoBottomSheet() {
        if (topSellInfoBottomSheet == null) {
            topSellInfoBottomSheet = new TopSellInfoBottomSheet(driver);
        }
        return topSellInfoBottomSheet;
    }

    public BottomMenu bottomMenu() {
        if (bottomMenu == null) {
            bottomMenu = new BottomMenu(driver);
        }
        return bottomMenu;
    }

    public OrderPage orderPage() {
        if (orderPage == null) {
            orderPage = new OrderPage(driver);
        }
        return orderPage;
    }

    public PickUpSection pickUpSection() {
        if (pickUpSection == null) {
            pickUpSection = new PickUpSection(driver);
        }
        return pickUpSection;
    }

    public PickupInTransitTab pickupInTransitTab() {
        if (pickupInTransitTab == null) {
            pickupInTransitTab = new PickupInTransitTab(driver);
        }
        return pickupInTransitTab;
    }

    public AppStateVerifiers appStateVerifiers() {
        if (appStateVerifiers == null) {
            appStateVerifiers = new AppStateVerifiers(driver);
        }
        return appStateVerifiers;
    }
    public TripSection tripSection() {
        if (tripSection == null) {
            tripSection = new TripSection(driver);
        }
        return tripSection;
    }
    public SystemShareSheet systemShareSheet() {
        if (systemShareSheet == null) {
            systemShareSheet = new SystemShareSheet(driver);
        }
        return systemShareSheet;
    }
}
