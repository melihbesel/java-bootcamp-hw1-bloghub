<!-- ABOUT THE PROJECT -->
## Project Description

### Question 1

Java dünyasindaki framework’ler ve çözdükleri problemler nedir? Kod Örneklendirini de içermelidir.

### Answer

# Java dünyasındaki framework’ler ve çözdükleri problemler nelerdir?

Java dünyasında birçok framework bulunmaktadır ve her biri farklı problemleri çözmek için tasarlanmıştır. İşte en popüler Java framework’leri ve onların çözdüğü bazı problemler, beraberinde bazı basit kod örnekleri ile:

## 1. Spring Framework

Kurumsal alanda en çok kullanılan Java Framework’ü olarak Spring’i örnek verebiliriz. Spring Framework’ü hem .net hem de Java için geliştirilmiş Java EE uygulamaları yapmamızı kolaylaştıran harika bir Framework’tür. Bu framework model-view-controller katmanlarını kontrol ederek ihtiyacımız olan paket ve sınıfları ekleyebildiğimiz ve bu paketleri kullanabilmemizi sağlayan bir Framework’tür. Spring ile çok karmaşık uygulamaların yanında oldukça basit uygulamalar yapmak da mümkündür.
Problem Çözümü: Spring, genel amaçlı bir framework olarak, Java uygulamalarının geliştirilmesini kolaylaştırır. Dependency injection, modülerlik, ve çoklu konfigürasyon seçenekleri gibi özellikleri ile uygulama geliştirme sürecini basitleştirir ve esneklik sağlar.

Kod Örneği:

```
import org.springframework.stereotype.Component;

@Component
public class MyComponent {
    public void performTask() {
        System.out.println("Task performed.");
    }
}

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("your.package");
        MyComponent myComponent = context.getBean(MyComponent.class);
        myComponent.performTask();
    }
}
```

## 2. Hibernate

Problem Çözümü: Hibernate, bir ORM (Object-Relational Mapping) framework’üdür. Veritabanı işlemlerini daha basit ve nesne odaklı hale getirerek, SQL yazım gereksinimini azaltır.

Kod Örneği:

```
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import your.package.entities.YourEntity;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        YourEntity entity = new YourEntity();
        entity.setName("Sample Name");
        session.save(entity);
        
        session.getTransaction().commit();
        session.close();
    }
}
```

## 3. Apache Struts

Problem Çözümü: Apache Struts, web uygulamaları için bir MVC (Model-View-Controller) framework’üdür. Geliştiricilerin web uygulamalarını daha düzenli bir yapıda geliştirmesine olanak tanır.

Kod Örneği:

```
<!-- struts.xml -->
<action name="sampleAction" class="your.package.SampleAction">
    <result name="success">/success.jsp</result>
    <result name="error">/error.jsp</result>
</action>
import com.opensymphony.xwork2.ActionSupport;

public class SampleAction extends ActionSupport {
    public String execute() {
        return SUCCESS;
    }
}
```

## 4. Spring Boot

Problem Çözümü: Spring Boot, Spring uygulamalarını kolaylıkla yapılandırmanıza ve çalıştırmanıza olanak tanır. Özellikle mikroservisler ve bağımsız uygulamalar için idealdir.

Kod Örneği:

```
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

## 5. JSF (JavaServer Faces)

Bir web sitesini Java ile yapmak mümkündür. Ancak Java Server Faces Framework’ü dinamik web sayfaları oluşturmamıza yaramaktadır. JSP kodları HTML dilinin içine yazılır ve kendine özel etiket sistemi vardır. Bu sayede HTML ile karışmadan kendi içinde güzel ve düzenli bir performans sunarak kaliteli siteler yapma konusunda yazılımcıya yardımcı olmaktadır.
Problem Çözümü: JSF, kullanıcı arayüzlerinin yönetilmesi için bir framework sağlar. Bileşen tabanlı yaklaşımı, web uygulamaları geliştirirken tekrar kullanılabilir UI bileşenlerinin oluşturulmasına yardımcı olur.

Kod Örneği:

```
<!-- index.xhtml -->
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html">
<h:form>
    <h:outputLabel value="Enter your name:" for="name"/>
    <h:inputText id="name" value="#{user.name}"/>
    <h:commandButton value="Submit" action="#{user.submit}"/>
</h:form>
javax'ı içe aktar yüzler . fasulye . YönetilenBean ; 

@ManagedBean 
genel  sınıf  Kullanıcı { 
    özel  Dize adı; 
    
    public  String  getName () { 
        dönüş adı; 
    } 
    
    public  void  setName ( Dize adı ) { 
        this . isim = isim; 
    } 
    
    public  String  gönderimi () { 
        return  "yanıt.xhtml" ; 
    } 
}
```

## 6. GWT (Google Web Toolkit)

Problem Çözümü: GWT, Java’da yazılan kodun JavaScript’e derlenmesini sağlayarak, zengin internet uygulamaları geliştirmenizi sağlar. Bu sayede Java geliştiricileri, JavaScript ile uğraşmadan web uygulamaları geliştirebilir.

Kod Örneği:

```
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

public class MyGWTApp implements EntryPoint {
    public void onModuleLoad() {
        Button button = new Button("Click me");
        button.addClickHandler(event -> button.setText("Hello, GWT!"));
        RootPanel.get().add(button);
    }
}
```

## 7. Vaadin

Problem Çözümü: Vaadin, zengin internet uygulamaları geliştirmek için kullanılan bir framework’tür. Sunucu tarafı programlama modeli sayesinde, tüm UI bileşenleri sunucu tarafında yönetilir ve otomatik olarak istemciye güncellenir.

Kod Örneği:

```
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {
    public MainView() {
        Button button = new Button("Click me", e -> button.setText("Hello, Vaadin!"));
        add(button);
    }
}
```

## 8. Grails

Problem Çözümü: Grails, hızlı web uygulamaları geliştirmek için kullanılan bir framework’tür. Ruby on Rails’ten esinlenmiştir ve Groovy dilini kullanır. Konfigürasyon gereksinimini azaltır ve geliştiricilere üretkenlik sağlar.

Kod Örneği:

```
class Book {
    String title
    String author
}

class BookController {
    def index() {
        [books: Book.list()]
    }
}
```

## 9. Apache Wicket

Problem Çözümü: Wicket, bileşen tabanlı bir web framework’tür. HTML tabanlı şablonlarla Java kodunu ayrıştırarak, güçlü ve sürdürülebilir web uygulamaları geliştirmenizi sağlar.

Kod Örneği:

```
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.protocol.http.WebApplication;

public class MyApp extends WebApplication {
    @Override
    public Class<? extends WebPage> getHomePage() {
        return HomePage.class;
    }
}

public class HomePage extends WebPage {
    public HomePage() {
        add(new Label("message", "Hello, Wicket!"));
    }
}
```

## 10. Blade

Problem Çözümü: Blade, hafif ve hızlı bir web framework’tür. Minimalist yapısı ve basit API’leri sayesinde, hızlı web uygulamaları geliştirmenizi sağlar.

Kod Örneği:

```
import com.blade.Blade;

public class Main {
    public static void main(String[] args) {
        Blade.of().get("/", ctx -> ctx.text("Hello, Blade!")).start();
    }
}
```

## 11. Dropwizard

Problem Çözümü: Dropwizard, RESTful web servisleri geliştirmek için kullanılan bir framework’tür. Hızlı ve üretime hazır uygulamalar geliştirmek için çeşitli araçlar sunar.

Kod Örneği:

```
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {
    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
    }

    @Override
    public void run(HelloWorldConfiguration configuration, Environment environment) {
        final HelloWorldResource resource = new HelloWorldResource();
        environment.jersey().register(resource);
    }
}

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello-world")
public class HelloWorldResource {
    @GET
    public String sayHello() {
        return "Hello, Dropwizard!";
    }
}
```

## 12. Play Framework

Problem Çözümü: Play Framework, ölçeklenebilir ve yüksek performanslı web uygulamaları geliştirmek için kullanılır. Asenkron programlama modeli sayesinde, özellikle yüksek trafikli uygulamalar için idealdir.

Kod Örneği:

```
import play.mvc.*;

public class HomeController extends Controller {
    public Result index() {
        return ok("Hello, Play Framework!");
    }
}
```

## 13. Spark Framework

Problem Çözümü: Spark, küçük ve bağımsız web uygulamaları geliştirmek için kullanılan bir mikro framework’tür. Basit ve minimal API’leri sayesinde, hızlı bir şekilde uygulama geliştirmenizi sağlar.

Kod Örneği:

```
import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello, Spark Framework!");
    }
}
```

Bu framework’lerin her biri, Java ekosistemine özgü yaygın problemleri çözer ve geliştiricilere daha hızlı ve etkili uygulama geliştirme imkanı sunar.



#### Kaynak : https://www.niobehosting.com/blog/java/

#### Kaynak : https://medium.com/@harunsefa.inan/java-d%C3%BCnyas%C4%B1ndaki-frameworkler-ve-%C3%A7%C3%B6zd%C3%BCkleri-problemler-nedir-43e2941743b9



<!-- TECHNOLOGIES -->
### Technologies

<a href="https://www.java.com/" target="_blank"><img src="/output/images/logos/java.svg" alt="Java" height="90" /></a>





<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.




<!-- CONTACT -->
## Contact

### Melih Beşel

<a href="https://github.com/melihbesel" target="_blank">
<img  src=https://img.shields.io/badge/github-%2324292e.svg?&style=for-the-badge&logo=github&logoColor=white alt=github style="margin-bottom: 20px;" />
</a>
<a href = "mailto:mbesel2005@gmail.com?subject = Feedback&body = Message">
<img src=https://img.shields.io/badge/send-email-email?&style=for-the-badge&logo=microsoftoutlook&color=CD5C5C alt=microsoftoutlook style="margin-bottom: 20px; margin-left:20px" />
</a>
<a href="https://linkedin.com/in/melihbesel" target="_blank">
<img src=https://img.shields.io/badge/linkedin-%231E77B5.svg?&style=for-the-badge&logo=linkedin&logoColor=white alt=linkedin style="margin-bottom: 20px; margin-left:20px" />
</a>  

<!-- PROJECT-BOOTCAMP-PRACTICUM PART -->
<br />

## FT Teknoloji Java Spring Boot Bootcamp

<div style="display: flex; justify-content: space-evenly">
  <div>
    <h3 align="left">Company: FT Teknoloji</h3>
    <a href="https://ftteknoloji.com.tr/">
    <img src="/output/images/logos/ft-teknoloji.png" alt="Logo" width="160" height="90">
    </a>
  </div>

  <div>
    <h3 align="left">Organizer: Patkia.dev</h3>
    <a href="https://www.patika.dev/">
    <img src="/output/images/logos/patika-dev.png" alt="Logo" width="160" height="90">
    </a>
  </div>
</div>
<br />
<br />
