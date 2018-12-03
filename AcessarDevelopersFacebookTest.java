package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import suporte.Generator;
import suporte.Screenshot;
import java.util.concurrent.TimeUnit;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesLogin.csv")

public class AcessarDevelopersFacebookTest {
    private WebDriver navegador;

    @Rule
    public TestName test = new TestName();
    @Before
    public void setUp() {
        //Apontando para o chorme driver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\U6023702.TEN\\Documents\\driver\\chromedriver.EXE");
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //navegando para a pagina
        navegador.get("https://developers.facebook.com");

    }

    @Test
    public void testAdicionarUsuarioValido(@Param(name="email")String email, @Param(name="password")String password) {
        // Validação de Acesso a pagina com dados válidos

        //Clicar no link que possua o texto "Entrar"
        navegador.get("https://www.facebook.com/login/?next=https%3A%2F%2Fdevelopers.facebook.com%2F");
        // navegador.findElement(By.linkText("Login in")).click();

        //Digitar o email no campo que tenha tenha o id = "email"
        navegador.findElement(By.id("email")).sendKeys(email);

        //Digitar o email no campo que tenha tenha o id = "pass"
        navegador.findElement(By.id("pass")).sendKeys(password);

        //Clicar no botão que tenha o id="loginbutton"
        navegador.findElement(By.id("loginbutton")).click();

        //  WebElement  LoginValido =  navegador.findElement(By.className("_3els"));
        // String TxtoLoginValido = LoginValido.getText();
        //  assertEquals("Meus Aplicativos.", TxtoLoginValido);

        Screenshot.print(navegador, "C:\\Users\\U6023702.TEN\\Documents\\Screenshot\\Print" + Generator.dataHoraParaArquivo()+ test.getMethodName() + ".png");
    }


    @Test
    public void testAdicionarUsuarioNulo(@Param(name="email")String email, @Param(name="password")String password) {

        // Validação de Acesso a pagina com dados nulos

        //Clicar no link que possua o texto "Entrar"
        navegador.get("https://www.facebook.com/login/?next=https%3A%2F%2Fdevelopers.facebook.com%2F");
        //  navegador.findElement(By.linkText("Login in")).click();

        //Digitar o email no campo que tenha tenha o id = "email"
        navegador.findElement(By.id("email")).sendKeys(email);

        //Digitar o email no campo que tenha tenha o id = "pass"
        navegador.findElement(By.id("pass")).sendKeys(password);

        //Clicar no botão que tenha o id="loginbutton"
        navegador.findElement(By.id("loginbutton")).click();

        Screenshot.print(navegador, "C:\\Users\\U6023702.TEN\\Documents\\Screenshot\\Print" + Generator.dataHoraParaArquivo()+ test.getMethodName() + ".png");
    }

    // @After
    public void TearDown (){
        // Fechar o navegador
        navegador.quit();

}

    }
