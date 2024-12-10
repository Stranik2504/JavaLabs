// Определение пакета, к которому относится данный контроллер. Это помогает организовать код и структурировать его.
package dev.stranik.lab16.contorller;

// Импорт класса User, который используется для работы с данными пользователя.
import dev.stranik.lab16.model.User;

// Импорт аннотации @Controller. Она говорит Spring, что данный класс является контроллером.
import dev.stranik.lab16.utils.ExchangeRateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

// Импорт для работы с объектом Model, который позволяет передавать данные между контроллером и представлением.
import org.springframework.ui.Model;

// Импорты для работы с аннотациями, такими как @GetMapping, @PostMapping и другими, чтобы обрабатывать HTTP-запросы.
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


// Аннотация, которая сообщает Spring, что данный класс является контроллером.
@Controller
public class AuthController { // Определение класса-контроллера AuthController, который будет обрабатывать запросы авторизации и регистрации пользователей.
    // Переменная для хранения информации о зарегистрированном пользователе. По умолчанию равна null.
    private User registeredUser;

    // Переменная-флаг, показывающая, авторизован ли пользователь в данный момент.
    private boolean isAuthenticated = false;

    private final RestTemplate restTemplate;

    public AuthController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Аннотация для обработки GET-запроса по корневому URL("/").
    @GetMapping("/")
    public String showRegisterPage() { // Метод, который будет вызываться при GET-запросе по корневому URL.
        // Возвращает название представления (HTML-шаблона) "register", которое отображается пользователю.
        return "register";
    }

    // Аннотация для обработки POST-запроса по URL "/register".
    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password, Model model) { // Метод обработки данных из формы регистрации. 
        // Проверяем, не пустые ли значения имени пользователя и пароля.
        if (username.isEmpty() || password.isEmpty()) {
            // Если пустые, отправляем сообщение об ошибке в представление.
            model.addAttribute("error", "Имя пользователя и пароль не должны быть пустыми!");

            // Возвращаемся на страницу регистрации.
            return "register"; 
        }

        // Создаём нового пользователя с полученными данными и сохраняем в переменную registeredUser.
        registeredUser = new User(username, password);

        // Перенаправляем пользователя на страницу входа ("/login").
        return "redirect:/login";
    }

    // Аннотация для обработки GET-запроса по URL "/login". 
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Возвращает представление (HTML-шаблон) "login".
    }

    // Аннотация для обработки POST-запроса по URL "/login". 
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) { // Метод обработки данных из формы входа.
        // Проверяем, зарегистрирован ли пользователь и совпадают ли данные с формой.
        if (registeredUser == null ||
            !registeredUser.getUsername().equals(username) ||
            !registeredUser.getPassword().equals(password)
        ) {
            // Если данные некорректны, отправляем сообщение об ошибке.
            model.addAttribute("error", "Неверное имя пользователя или пароль!"); 
            
            // Возвращаемся на страницу входа. 
            return "login";
        }
        
        // Если данные корректны, устанавливаем флаг авторизации в true.
        isAuthenticated = true;
        
        // Перенаправляем пользователя на домашнюю страницу после успешного входа.
        return "redirect:/home";
    }

    // Аннотация для обработки GET-запроса по URL "/home". 
    @GetMapping("/home")
    public String showHomePage(Model model) {
        // Проверяем, авторизован ли пользователь. Если нет: 
        if (!isAuthenticated) {
            return "redirect:/login"; // Перенаправляем его на страницу входа.
        }
        
        // Если пользователь авторизован, передаём имя пользователя в представление.
        model.addAttribute("username", registeredUser.getUsername());
        
        // Возвращаем представление (HTML-шаблон) "home". 
        return "home";
    }
    
    @PostMapping("/home")
    public String convertCurrency(@RequestParam double amount, @RequestParam String fromCurrency, @RequestParam String toCurrency, Model model) {
        if (!isAuthenticated) {
            return "redirect:/login";
        }
        
        if (!fromCurrency.equalsIgnoreCase("usd") && !fromCurrency.equalsIgnoreCase("eur")) 
            model.addAttribute("error", "Неверные валюты!");

        if (!toCurrency.equalsIgnoreCase("usd") && !toCurrency.equalsIgnoreCase("rub"))
            model.addAttribute("error", "Неверные валюты!");
        
        // Запрос на биржевой курс валюты
        String apiUrl = String.format("https://api.exchangerate-api.com/v4/latest/%s", fromCurrency);
        ExchangeRateResponse response = restTemplate.getForObject(apiUrl, ExchangeRateResponse.class);

        if (response == null || !response.getRates().containsKey(toCurrency)) {
            model.addAttribute("error", "Ошибка при получении курса валют!");
            return "home";
        }

        double exchangeRate = response.getRates().get(toCurrency);
        double result = amount * exchangeRate;
        model.addAttribute("conversionResult", result);
        
        // Задание amount, fromCurrency, toCurrency в модель
        model.addAttribute("amount", amount);
        model.addAttribute("fromCurrency", fromCurrency);
        model.addAttribute("toCurrency", toCurrency);
        
        return "home";
    }
}
