import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Logger {

    protected int num = 1;
    protected List<String> logList = new ArrayList<>();
    // В этом поле храним ссылку на тот
    // единственный объект этого класса
    // который будем отдавать пользователям
    private static Logger logger;

    // Запрещаем пользователям пользоваться
    // конструктором нашего класса
    private Logger() {

    }

    // Пользователи которым нужен объект
    // нашего класса получают всегда один
    // и тот же объект, который мы храним
    // в приватном статичном поле, которое
    // мы заполняем в этом методе если оно
    // до того не было заполнено
    public static Logger getInstance() {
        //...

        if (logger == null) logger = new Logger();
        return logger;
    }

    public void log(String msg) {
        String timeStamp = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        logList.add("[" + timeStamp + " " + num++ + "] " + msg);
    }

    public void showLog() {
        logList.forEach(System.out::println);
    }
}