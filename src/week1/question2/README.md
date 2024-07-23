<!-- ABOUT THE PROJECT -->
## Project Description

### Question 2

SOA - Web Service - Restful Service - HTTP methods kavramlarını örneklerle açıklayınız.

### Answer

# SOA — Web Service — Restful Service — HTTP Methods Kavramları

## 1. SOA (Service-Oriented Architecture)
Tanım: SOA, bir uygulamanın veya sistemin, ağ üzerinden erişilebilen, birbirinden bağımsız işlevler şeklinde yapılandırıldığı bir mimari stilidir. Bu işlevler “servis” olarak adlandırılır ve birbirleriyle ağ üzerinden haberleşir.
 
#### Hizmet odaklı mimari nasıl çalışır?
Hizmet odaklı mimaride, hizmetler bağımsız olarak çalışır ve tüketicilerine işlevsellik ya da veri alışverişi sunar. Tüketici, bilgi talep eder ve girdi verilerini hizmete gönderir. Hizmet, verileri işler, görevi yerine getirir ve bir yanıt gönderir. Örneğin, bir uygulama kimlik doğrulaması hizmeti kullanıyorsa hizmete kullanıcı adını ve parolayı sunar. Hizmet, kullanıcı adını ve parolayı doğrulayarak uygun bir yanıt döndürür.

#### İletişim protokolleri
Hizmetler, bir ağ üzerinden veri iletimini belirleyen kuralları kullanarak iletişim kurar. Bu kurallara, iletişim protokolleri denir. Hizmet odaklı mimariyi uygulamaya ilişkin standart protokollerden bazıları şunlardır:

- Basit Nesne Erişimi Protokolü (SOAP)
- RESTful HTTP
- Apache Thrift
- Apache ActiveMQ
- Java Mesaj Hizmeti (JMS)

Hizmet odaklı mimari uygulamanızda birden fazla protokol de kullanabilirsiniz.

#### Hizmet odaklı mimaride kurum veri yolu (ESB) nedir?
Kurum veri yolu, birden fazla hizmete sahip bir sistemle iletişime geçerken kullanabileceğiniz bir yazılımdır. Teknoloji ne olursa olsun hizmetler ile hizmet tüketicileri arasında iletişim kurar.  

• Kurum veri yolunun avantajları

Bir kurum veri yolu, yeniden kullanılabilir bir hizmet arabirimi aracılığıyla iletişim ve dönüşüm özellikleri sunar. Bir kurum veri yolunu, hizmet isteklerini uygun hizmete yönlendiren merkezi bir hizmet olarak düşünebilirsiniz. Bu yol ayrıca isteği, hizmetin temel aldığı platform ve programlama dili için kabul edilebilir bir biçime dönüştürür.
  
#### Hizmet odaklı mimarinin avantajları nelerdir?
• 	Pazara daha hızlı ulaşma

Geliştiriciler, zamandan ve maliyetten tasarruf etmek için hizmetleri farklı iş süreçlerinde yeniden kullanır. Hizmet odaklı mimari sayesinde, uygulamaları kod yazmaktan ve entegrasyonları sıfırdan yapmaktan daha hızlı şekilde bir araya getirebilirler.

•	Verimli bakım

Monolitik uygulamalarda küçük hizmetleri oluşturmak, güncellemek ve hatalarını ayıklamak, büyük kod bloklarına kıyasla daha kolaydır. Hizmet odaklı mimarideki herhangi bir hizmeti değiştirmek, iş sürecinin genel işlevselliğini etkilemez.

•	Daha fazla uyum

Hizmet odaklı mimari, teknolojideki gelişmelere daha uyumludur. Uygulamalarınızı verimli ve uygun maliyetli şekilde modernize edebilirsiniz. Örneğin, sağlık kuruluşları daha yeni bulut tabanlı uygulamalarda eski elektronik sağlık kayıt sistemlerinin işlevselliğini kullanabilir.

#### Hizmet odaklı mimarinin temel ilkeleri nelerdir?
Hizmet odaklı mimariyi uygulamak için iyi tanımlanmış standart yönergeler yoktur. Bununla birlikte, tüm hizmet odaklı mimari uygulamalarında ortak olan bazı temel ilkeler vardır.

•	Birlikte çalışabilirlik

Hizmet odaklı mimarideki her bir hizmet, hizmetin işlevselliğini ve ilgili koşul ve şartları belirten açıklama belgeleri içerir. Herhangi bir istemci sistemi, bir hizmeti temel alınan platform veya programlama dilinden bağımsız olarak çalıştırabilir. Örneğin, iş süreçleri hem C# hem de Python dilinde yazılmış hizmetleri kullanabilir. Doğrudan etkileşim olmadığından, bir hizmetteki değişiklikler hizmeti kullanan diğer bileşenleri etkilemez.

•	Gevşek ilişkilendirme

Hizmet odaklı mimarideki hizmetler, veri modelleri veya bilgi sistemleri gibi dış kaynaklara mümkün olduğunca az bağımlı olacak şekilde gevşek ilişkilendirilmelidir. Ayrıca geçmiş oturumlardan veya işlemlerden herhangi bir bilgiyi saklamadan durum bilgisine sahip olmamaları gerekir. Böylece, bir hizmeti değiştirirseniz bu, istemci uygulamalarını ve hizmeti kullanan diğer hizmetleri önemli ölçüde etkilemez.

•	Soyutlama

Hizmet odaklı mimarideki istemcilerin veya hizmet kullanıcılarının, hizmetin kod mantığını veya uygulama ayrıntılarını bilmesine gerek yoktur. Bu kişiler için hizmetler, bir kara kutu gibi görünmelidir. İstemciler, hizmetin ne işe yaradığı ve nasıl kullanılacağı hakkında gerekli bilgileri hizmet sözleşmeleri ve diğer hizmet açıklama belgeleri aracılığıyla alır.

•	Ayrıntı düzeyi

Hizmet odaklı mimarideki hizmetler, ideal olarak hizmet başına ayrı bir işletme işlevini
paketleyecek şekilde uygun bir boyut ve kapsama sahip olmalıdır. Geliştiriciler daha sonra birden fazla hizmeti kullanarak karmaşık işlemleri gerçekleştirmek üzere bir bileşik hizmet oluşturabilir.

#### Hizmet odaklı mimarinin bileşenleri nelerdir?

Hizmet odaklı mimaride dört ana bileşen vardır.

•	Hizmet

Hizmetler, hizmet odaklı mimarinin temel yapı taşlarıdır. Bu hizmetler, özel (yalnızca bir kuruluşun dahili kullanıcılarına açık) veya genel (internet üzerinden herkesin erişilebileceği) olabilir. Her bir hizmet ayrı olarak üç ana özelliğe sahiptir.

•	Hizmet uygulaması

Hizmet uygulaması, kullanıcı kimlik doğrulaması veya fatura hesaplama gibi belirli bir hizmet işlevini gerçekleştirmek için mantık oluşturan koddur.

•	Hizmet sözleşmesi

Hizmet sözleşmesi, hizmetin niteliğini ve hizmetin kullanımına ilişkin ön koşullar, hizmet maliyeti ve sağlanan hizmetin kalitesi gibi ilgili şart ve koşulları tanımlar.
 
•	Hizmet arabirimi

Hizmet odaklı mimaride, diğer hizmetler veya sistemler bir hizmetle hizmet arabirimi üzerinden iletişim kurar. Arabirim, etkinlikleri gerçekleştirmek veya veri alışverişi yapmak için hizmeti nasıl çağırabileceğinizi tanımlar. Bu arabirim, hizmetler ile hizmet için talepte bulunanlar arasındaki bağımlılıkları azaltır. Örneğin, temelde yatan kod mantığını çok az anlayan ya da hiç anlamayan kullanıcılar bile hizmeti arabirimi üzerinden kullanabilir.

•	Hizmet sağlayıcısı

Hizmet sağlayıcısı, başkalarının kullanabileceği bir veya daha fazla hizmeti oluşturur, bakımını yapar ve sunar. Kuruluşlar, kendi hizmetlerini oluşturabilir veya üçüncü taraf hizmet sağlayıcılarından satın alabilir.

•	Hizmeti tüketicisi

Hizmet tüketicisi, hizmet sağlayıcısının belirli bir hizmeti çalıştırmasını talep eder. Bu, bütün bir sistem, uygulama veya başka bir hizmet olabilir. Hizmet sözleşmesi, hizmet sağlayıcısı ile tüketicinin birbirleriyle iletişim kurarken uyması gereken kuralları belirtir. Hizmet sağlayıcıları ve tüketiciler; farklı departman, kuruluş ve hatta sektörlerde yer alabilir.

•	Hizmet kaydı

Bir hizmet kaydı veya hizmet deposu, kullanılabilir hizmetlerin yer aldığı ve bir ağ üzerinden erişilebilen bir dizindir. Bu dizin, hizmet sağlayıcılarının hizmet açıklaması belgelerini depolar. Açıklama belgeleri, hizmet ve hizmetle nasıl iletişim kurulacağına ilişkin bilgileri içerir. Hizmet tüketicileri, hizmet kayıt defterini kullanarak ihtiyaç duydukları hizmetleri kolayca keşfedebilir.

#### Hizmet odaklı mimariyi uygulamadaki sınırlamalar nelerdir?
•	Sınırlı ölçeklenebilirlik

Hizmetler birçok kaynağı paylaştığında ve işlevlerini yerine getirmek için koordinasyona ihtiyaç duyduğunda, sistem ölçeklenebilirliği önemli ölçüde etkilenir. 

•	Artan bağımlılıklar

Hizmet odaklı mimari sistemleri, zaman içinde daha karmaşık hale gelebilir ve hizmetler arasında çeşitli bağımlılıklar geliştirebilir. Bir döngüde çeşitli hizmetler birbirini çağırıyorsa bunları değiştirmek veya hataları ayıklamak zor olabilir. Merkezi veritabanları gibi ortak kaynaklar da sistemi yavaşlatabilir.

•	Tek hata noktası

Kurum veri yoluna sahip hizmet odaklı mimari uygulamalarında, kurum veri yolu tek bir hata noktası oluşturur. Bu, hizmet odaklı mimarinin savunduğu merkeziyetsizlik fikrine aykırı olan merkezi bir hizmettir. Kurum veri yolu çökerse istemciler ve hizmetler birbirleriyle hiç iletişim kuramaz.
#### Örnek: Bir e-ticaret sistemi düşünün. Sipariş işleme, ödeme işleme, müşteri yönetimi ve envanter yönetimi gibi farklı işlevler, bağımsız servisler olarak ayrılabilir. Sipariş servisi, ödeme servisi ile ağ üzerinden iletişim kurarak ödeme işlemini başlatır.

## 2. Web Service
Tanım: Web servisleri, farklı makineler veya platformlar arasında iletişim kurmak için kullanılan, standardize edilmiş bir yol sunar. SOAP (Simple Object Access Protocol) ve XML gibi teknolojileri kullanarak ağ üzerinden veri alışverişi yapar.

#### Örnek: Bir hava durumu bilgisi sağlayan web servisi. Bu servis, SOAP protokolünü kullanarak, istemcilere XML formatında hava durumu verileri sağlar.

```
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
  <soap:Body>
    <GetWeather xmlns="http://www.example.org/weather">
      <City>Istanbul</City>
    </GetWeather>
  </soap:Body>
</soap:Envelope>
```

## 3. Restful Service
Tanım: RESTful servisler, web servislerinin bir alt kümesidir ve REST (Representational State Transfer) mimari stilini kullanır. Genellikle HTTP protokolü üzerinden çalışır ve verileri JSON veya XML formatında sunar.

#### Örnek: Bir kullanıcı bilgilerini yöneten RESTful API.

- GET /users — Tüm kullanıcıları listeler.
- POST /users — Yeni bir kullanıcı oluşturur.
- GET /users/{id} — Belirli bir kullanıcıyı getirir.
- PUT /users/{id} — Belirli bir kullanıcıyı günceller.
- DELETE /users/{id} — Belirli bir kullanıcıyı siler.

```
@GetMapping("/users")
public List<User> getAllUsers() {
    return userService.findAllUsers();
}
@PostMapping("/users")
public User createUser(@RequestBody User user) {
    return userService.saveUser(user);
}
@GetMapping("/users/{id}")
public User getUserById(@PathVariable Long id) {
    return userService.findUserById(id);
}
@PutMapping("/users/{id}")
public User updateUser(@PathVariable Long id, @RequestBody User user) {
    user.setId(id);
    return userService.updateUser(user);
}
@DeleteMapping("/users/{id}")
public void deleteUser(@PathVariable Long id) {
    userService.deleteUser(id);
}
```

## 4. HTTP Methods
Tanım: HTTP protokolü, web üzerindeki veri alışverişini düzenleyen metotlar setini tanımlar. RESTful servisler genellikle bu HTTP metodlarını kullanarak kaynaklara erişim sağlar.

- GET : Kaynakları almak için kullanılır.
- POST : Yeni bir kaynak oluşturmak için kullanılır.
- PUT : Mevcut bir kaynağı güncellemek için kullanılır.
- DELETE : Bir kaynağı silmek için kullanılır.

#### Örnek: Bir blog sistemine ait CRUD (Create, Read, Update, Delete) işlemleri.

```
@GetMapping("/blogs")
public List<Blog> getAllBlogs() {
    return blogService.getAllBlogs();
}
@PostMapping("/blogs")
public Blog createBlog(@RequestBody Blog blog) {
    return blogService.saveBlog(blog);
}
@PutMapping("/blogs/{id}")
public Blog updateBlog(@PathVariable Long id, @RequestBody Blog blogDetails) {
    Blog blog = blogService.getBlogById(id);
    blog.setTitle(blogDetails.getTitle());
    blog.setContent(blogDetails.getContent());
    return blogService.updateBlog(blog);
}
@DeleteMapping("/blogs/{id}")
public ResponseEntity<Void> deleteBlog(@PathVariable Long id) {
    blogService.deleteBlogById(id);
    return ResponseEntity.noContent().build();
}
```
Bu kavramlar ve metodlar, modern web ve uygulama geliştirme süreçlerinin temelini oluşturur ve geniş ölçekli sistemlerin etkili bir şekilde işlemesini sağlar.


#### Kaynak :https://aws.amazon.com/tr/what-is/service-oriented-architecture/

#### Kaynak : https://medium.com/@harunsefa.inan/soa-web-service-restful-service-http-methods-kavramlar%C4%B1-c9c66ff576b8




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
