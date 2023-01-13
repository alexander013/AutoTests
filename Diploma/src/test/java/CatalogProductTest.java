import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class CatalogProductTest {

    private static WebDriver driver;

    private static WebDriverWait wait;

//    Необходимо сделать так, чтобы браузер открывался один раз

    @BeforeClass
    public static void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
//    Открытие браузера во весь экран
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);
    }

    @AfterClass
    public static void tearDown() throws IOException{
        var sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File("..\\Diploma\\tmp_catalog\\screenshot.png"));
        driver.quit();
    }
//----------------------------------------------------------------------------------------------------------------------
//    Тест на  переход в раздел КАТАЛОГ
    @Test
    public void GoingToCatalogTest()
    {
//        Открытие  страницы сайта
        driver.navigate().to("http://intershop5.skillbox.ru/");
//        Элемент для перехода в раздел КАТАЛОГ
        var CatalogElement = By.id("menu-item-46");
//        Элемент названия раздела КАТАЛОГ
        var TitleCatalogElementLocator = By.xpath("//h1[@class='entry-title ak-container']");
//        Клик для перехода в раздел КАТАЛОГ
        driver.findElement(CatalogElement).click();
//        Проверка на наличие элемента названия раздела КАТАЛОГ
        Assert.assertTrue("Элемент не найден", driver.findElement(TitleCatalogElementLocator).isDisplayed());
    }
//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
//    Тест на переход в раздел ХОЛОДИЛЬНИКИ после наведения на КАТАЛОГ и на БЫТОВАЯ ТЕХНИКА
    @Test
    public void RefrigeratorsTest()
    {
//        Открытие  страницы сайта
        driver.navigate().to("http://intershop5.skillbox.ru/");
//        Элемент для перехода в раздел КАТАЛОГ
        var CatalogElement = By.id("menu-item-46");
//        Элемент БЫТОВАЯ ТЕХНИКА, который появляется при наведении на раздел КАТАЛОГ
        var HomeAppliancesElementLocator = By.id("menu-item-119");
//        Элемент ХОЛОДИЛЬНИКИ в под меню БЫТОВАЯ ТЕХНИКА
        var RefrigeratorsElementLocator = By.id("menu-item-120");
//        Элемент заголовка раздела ХОЛОДИЛЬНИКИ
        var TitleRefrigeratorsElementLocator = By.xpath("//h1[@class='entry-title ak-container']");
//        Наведение курсора мыши на КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(CatalogElement))
                .perform();
//        Наведение курсора мыши на БЫТОВАЯ ТЕХНИКА в под меню КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(HomeAppliancesElementLocator))
                .perform();
//        Наведение курсора мыши на раздел ХОЛОДИЛЬНИКИ в под меню БЫТОВАЯ ТЕХНИКА
        new Actions(driver)
                .moveToElement(driver.findElement(RefrigeratorsElementLocator))
                .perform();
//        Клик по элементу ХОЛОДИЛЬНИКИ в под меню БЫТОВАЯ ТЕХНИКА
        driver.findElement(RefrigeratorsElementLocator).click();
//        Проверка на наличие заголовка ХОЛОДИЛЬНИКИ
        Assert.assertTrue("Элемент не найден", driver.findElement(TitleRefrigeratorsElementLocator).isDisplayed());
    }
//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
//    Тест на переход в раздел БЫТОВАЯ ТЕХНИКА при наведении на раздел КАТАЛОГ
    @Test
    public void HomeAppliancesTest()
    {
//        Открытие  страницы сайта
        driver.navigate().to("http://intershop5.skillbox.ru/");
//        Элемент для перехода в раздел КАТАЛОГ
        var CatalogElement = By.id("menu-item-46");
//        Элемент БЫТОВАЯ ТЕХНИКА, который появляется при наведении на раздел КАТАЛОГ
        var HomeAppliancesElementLocator = By.id("menu-item-119");
//        Заголовок раздела БЫТОВАЯ ТЕХНИКА
        var TitleHomeAppliancesElementLocator = By.xpath("//h1[@class='entry-title ak-container']");
//        Наведение курсора мыши на КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(CatalogElement))
                .perform();
//        Наведение курсора мыши на БЫТОВАЯ ТЕХНИКА в под меню КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(HomeAppliancesElementLocator))
                .perform();
//        Клик по разделу БЫТОВАЯ ТЕХНИКА в под меню КАТАЛОГ
        driver.findElement(HomeAppliancesElementLocator).click();

//        Проверка на наличие заголовка БЫТОВАЯ ТЕХНИКА
        Assert.assertTrue("Элемент не найден", driver.findElement(TitleHomeAppliancesElementLocator).isDisplayed());
    }
//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
//    Тест на переход в раздел СТИРАЛЬНЫЕ МАШИНЫ после наведения на КАТАЛОГ и на БЫТОВАЯ ТЕХНИКА
    @Test
    public void WashingMachinesTest()
    {
//        Открытие  страницы сайта
        driver.navigate().to("http://intershop5.skillbox.ru/");
//        Элемент для перехода в раздел КАТАЛОГ
        var CatalogElement = By.id("menu-item-46");
//        Элемент БЫТОВАЯ ТЕХНИКА, который появляется при наведении на раздел КАТАЛОГ
        var HomeAppliancesElementLocator = By.id("menu-item-119");
//        Элемент СТИРАЛЬНЫЕ МАШИНЫ в под меню БЫТОВАЯ ТЕХНИКА
        var WashingMachinesElementLocator = By.id("menu-item-121");
//        Элемент заголовка раздела СТИРАЛЬНЫЕ МАШИНЫ
        var TitleWashingMachinesElementLocator = By.xpath("//h1[@class='entry-title ak-container']");
//        Наведение курсора мыши на КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(CatalogElement))
                .perform();
//        Наведение курсора мыши на БЫТОВАЯ ТЕХНИКА в под меню КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(HomeAppliancesElementLocator))
                .perform();
//        Наведение курсора мыши на раздел СТИРАЛЬНЫЕ МАШИНЫ в под меню БЫТОВАЯ ТЕХНИКА
        new Actions(driver)
                .moveToElement(driver.findElement(WashingMachinesElementLocator))
                .perform();
//        Клик по элементу СТИРАЛЬНЫЕ МАШИНЫ в под меню БЫТОВАЯ ТЕХНИКА
        driver.findElement(WashingMachinesElementLocator).click();
//        Проверка на наличие заголовка ХОЛОДИЛЬНИКИ
        Assert.assertTrue("Элемент не найден", driver.findElement(TitleWashingMachinesElementLocator).isDisplayed());
    }
//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
//    Тест на переход в раздел ЭЛЕКТРОНИКА при наведении на раздел КАТАЛОГ
    @Test
    public void ElectronicsTest()
    {
//        Открытие  страницы сайта
        driver.navigate().to("http://intershop5.skillbox.ru/");
//        Элемент для перехода в раздел КАТАЛОГ
        var CatalogElement = By.id("menu-item-46");
//        Элемент ЭЛЕКТРОНИКА, который появляется при наведении на раздел КАТАЛОГ
        var ElectronicsElementLocator = By.id("menu-item-47");
//        Заголовок раздела ЭЛЕКТРОНИКА
        var TitleElectronicsElementLocator = By.xpath("//h1[@class='entry-title ak-container']");
//        Наведение курсора мыши на КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(CatalogElement))
                .perform();
//        Наведение курсора мыши на раздел ЭЛЕКТРОНИКА в под меню КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(ElectronicsElementLocator))
                .perform();
//        Клик по разделу ЭЛЕКТРОНИКА в под меню КАТАЛОГ
        driver.findElement(ElectronicsElementLocator).click();
//        Проверка на наличие заголовка ЭЛЕКТРОНИКА
        Assert.assertTrue("Элемент не найден", driver.findElement(TitleElectronicsElementLocator).isDisplayed());
    }
//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
//    Тест на переход в разделы ТЕЛЕФОНЫ, ПЛАНШЕТЫ, ТЕЛЕВИЗОРЫ, ФОТО/ВИДЕО, ЧАСЫ после наведения на КАТАЛОГ
//    и с последующим наведением на раздел ЭЛЕКТРОНИКА в под меню раздела КАТАЛОГ
    @Test
    public void SubMenuElectronicsTest() {
//        Открытие  страницы сайта
        driver.navigate().to("http://intershop5.skillbox.ru/");
//        Элемент для перехода в раздел КАТАЛОГ
        var CatalogElement = By.id("menu-item-46");
//        Элемент ЭЛЕКТРОНИКА, который появляется при наведении на раздел КАТАЛОГ
        var ElectronicsElementLocator = By.id("menu-item-47");
//        Элемент ТЕЛЕФОНЫ
        var PhonesElement = By.id("menu-item-114");
//        Элемент ПЛАНШЕТЫ
        var TabletsElement = By.id("menu-item-116");
//        Элемент ТЕЛЕВИЗОРЫ
        var TelevisionsElement = By.id("menu-item-118");
//        Элемент ФОТО/ВИДЕО
        var PhotosVideosElement = By.id("menu-item-117");
//        Элемент ЧАСЫ
        var WatchesElement = By.id("menu-item-115");
//        Заголовок раздела ТЕЛЕФОНЫ
        var TitlePhoneElementLocator = By.xpath("//h1[@class='entry-title ak-container'][text() = 'Телефоны']");
//        Заголовок раздела ПЛАНШЕТЫ
        var TitleTabletsElementLocator = By.xpath("//h1[@class='entry-title ak-container'][text() = 'Планшеты']");
//        Заголовок раздела ТЕЛЕВИЗОРЫ
        var TitleTelevisionsElementLocator = By.xpath("//h1[@class='entry-title ak-container'][text() = 'Телевизоры']");
//        Заголовок раздела ФОТО/ВИДЕО
        var TitlePhotosVideosElementLocator = By.xpath("//h1[@class='entry-title ak-container'][text() = 'Фото/видео']");
//        Заголовок раздела ЧАСЫ
        var TitleWatchesElementLocator = By.xpath("//h1[@class='entry-title ak-container'][text() = 'Часы']");
//        Наведение курсора мыши на КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(CatalogElement))
                .perform();
//        Наведение курсора мыши на раздел ЭЛЕКТРОНИКА в под меню КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(ElectronicsElementLocator))
                .perform();
//        Наведение курсора на раздел ТЕЛЕФОНЫ в под меню ЭЛЕКТРОНИКА
        new Actions(driver)
                .moveToElement(driver.findElement(PhonesElement))
                .perform();
//        Клик по разделу ТЕЛЕФОНЫ
        driver.findElement(PhonesElement).click();
//        Проверка на наличие заголовка ТЕЛЕФОНЫ
        Assert.assertTrue("Элемент не найден", driver.findElement(TitlePhoneElementLocator).isDisplayed());
//        Наведение курсора мыши на КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(CatalogElement))
                .perform();
//        Наведение курсора мыши на раздел ЭЛЕКТРОНИКА в под меню КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(ElectronicsElementLocator))
                .perform();
//        Наведение курсора на раздел ПЛАНШЕТЫ в под меню ЭЛЕКТРОНИКА
        new Actions(driver)
                .moveToElement(driver.findElement(TabletsElement))
                .perform();
//        Клик по разделу ПЛАНШЕТЫ
        driver.findElement(TabletsElement).click();
//        Проверка на наличие заголовка ПЛАНШЕТЫ
        Assert.assertTrue("Элемент не найден", driver.findElement(TitleTabletsElementLocator).isDisplayed());
//        Наведение курсора мыши на КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(CatalogElement))
                .perform();
//        Наведение курсора мыши на раздел ЭЛЕКТРОНИКА в под меню КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(ElectronicsElementLocator))
                .perform();
//        Наведение курсора на раздел ТЕЛЕВИЗОРЫ в под меню ЭЛЕКТРОНИКА
        new Actions(driver)
                .moveToElement(driver.findElement(TelevisionsElement))
                .perform();
//        Клик по разделу ТЕЛЕВИЗОРЫ
        driver.findElement(TelevisionsElement).click();
//        Проверка на наличие заголовка ТЕЛЕВИЗОРЫ
        Assert.assertTrue("Элемент не найден", driver.findElement(TitleTelevisionsElementLocator).isDisplayed());
//        Наведение курсора мыши на КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(CatalogElement))
                .perform();
//        Наведение курсора мыши на раздел ЭЛЕКТРОНИКА в под меню КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(ElectronicsElementLocator))
                .perform();
//        Наведение курсора на раздел ФОТО/ВИДЕО в под меню ЭЛЕКТРОНИКА
        new Actions(driver)
                .moveToElement(driver.findElement(PhotosVideosElement))
                .perform();
//        Клик по разделу ФОТО/ВИДЕО
        driver.findElement(PhotosVideosElement).click();
//        Проверка на наличие заголовка ФОТО/ВИДЕО
        Assert.assertTrue("Элемент не найден", driver.findElement(TitlePhotosVideosElementLocator).isDisplayed());
//        Наведение курсора мыши на КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(CatalogElement))
                .perform();
//        Наведение курсора мыши на раздел ЭЛЕКТРОНИКА в под меню КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(ElectronicsElementLocator))
                .perform();
//        Наведение курсора на раздел ЧАСЫ в под меню ЭЛЕКТРОНИКА
        new Actions(driver)
                .moveToElement(driver.findElement(WatchesElement))
                .perform();
//        Клик по разделу ЧАСЫ
        driver.findElement(WatchesElement).click();
//        Проверка на наличие заголовка ЧАСЫ
        Assert.assertTrue("Элемент не найден", driver.findElement(TitleWatchesElementLocator).isDisplayed());
    }
//----------------------------------------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------------------------------------
//    Тест на переход в раздел КНИГИ при наведении на раздел КАТАЛОГ
    @Test
    public void BooksTest()
    {
//        Открытие  страницы сайта
        driver.navigate().to("http://intershop5.skillbox.ru/");
//        Элемент для перехода в раздел КАТАЛОГ
        var CatalogElement = By.id("menu-item-46");
//        Элемент КНИГИ, который появляется при наведении на раздел КАТАЛОГ
        var BooksElementLocator = By.id("menu-item-180");
//        Заголовок раздела КНИГИ
        var TitleBooksElementLocator = By.xpath("//h1[@class='entry-title ak-container'][text() = 'Книги']");
//        Наведение курсора мыши на КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(CatalogElement))
                .perform();
//        Наведение курсора мыши на КНИГИ в под меню КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(BooksElementLocator))
                .perform();
//        Клик по разделу КНИГИ в под меню КАТАЛОГ
        driver.findElement(BooksElementLocator).click();
//        Проверка на наличие заголовка БЫТОВАЯ ТЕХНИКА
        Assert.assertTrue("Элемент не найден", driver.findElement(TitleBooksElementLocator).isDisplayed());
    }
//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
//    Тест на переход в раздел ОДЕЖДА при наведении на раздел КАТАЛОГ
    @Test
    public void ClothesTest()
    {
//        Открытие  страницы сайта
        driver.navigate().to("http://intershop5.skillbox.ru/");
//        Элемент для перехода в раздел КАТАЛОГ
        var CatalogElement = By.id("menu-item-46");
//        Элемент ОДЕЖДА, который появляется при наведении на раздел КАТАЛОГ
        var ClothesElementLocator = By.id("menu-item-48");
//        Заголовок раздела КНИГИ
        var TitleClothesElementLocator = By.xpath("//h1[@class='entry-title ak-container'][text() = 'Одежда']");
//        Наведение курсора мыши на КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(CatalogElement))
                .perform();
//        Наведение курсора мыши на КНИГИ в под меню КАТАЛОГ
        new Actions(driver)
                .moveToElement(driver.findElement(ClothesElementLocator))
                .perform();
//        Клик по разделу КНИГИ в под меню КАТАЛОГ
        driver.findElement(ClothesElementLocator).click();
//        Проверка на наличие заголовка БЫТОВАЯ ТЕХНИКА
        Assert.assertTrue("Элемент не найден", driver.findElement(TitleClothesElementLocator).isDisplayed());
    }
//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
//    Тест на поиск товара через поисковое поле
    @Test
    public void ProductSearchTest()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/");
//        Элемент поля поиска
        var SearchFieldElement = By.name("s");
//        Элемент кнопки поиска
        var ButtonSearSubmitElement = By.className("searchsubmit");
//        Элемент заголовка искомого товара (в данном случае "iPad Air 2020 64gb wi-fi")
        var TitleProductElementLocator = By.xpath("//h1[text() = 'iPad Air 2020 64gb wi-fi']");
//        Ввод "iPad Air 2020 64gb wi-fi" в поле поиска
        driver.findElement(SearchFieldElement).sendKeys("ipad air 2020 64gb wi-fi");
//        Клик по кнопке поиска
        driver.findElement(ButtonSearSubmitElement).click();
//        Проверка на наличие заголовка искомого элемента ("iPad Air 2020 64gb wi-fi")
        Assert.assertTrue("Элемент не найден", driver.findElement(TitleProductElementLocator).isDisplayed());
    }
//----------------------------------------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------------------------------------
//    Тест на проведение сортировки в разделе КАТАЛОГ - по популярности, по отзывам, последние,
//    по возрастанию цены, по убыванию цены
//    @Test
//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
//    Тест на переходы по КАТЕГОРИЯМ ТОВАРОВ в разделе КАТАЛОГ
//    @Test
//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
//    Тест на применение ФИЛЬТРА в разделе КАТАЛОГ
//    @Test
//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
//    Тест на добавление товара в корзину в разделе КАТАЛОГ
//    @Test
//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
//    Тест на использование ПОСТРАНИЧНОЙ НАВИГАЦИИ
//    @Test
//----------------------------------------------------------------------------------------------------------------------

}
