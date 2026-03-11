import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        LocalDate dateBuy =  LocalDate.now();
        LocalDate dateFirstInstallment = LocalDate.of(2025, 5, 15);
        LocalDate dateSecondInstallment = dateFirstInstallment.plusDays(30);
        System.out.println(dateSecondInstallment.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        ZonedDateTime dateConclusionBuy = ZonedDateTime.now();
        System.out.println(dateConclusionBuy.withZoneSameInstant(ZoneId.of("America/New_York")));

        LocalTime init = LocalTime.of(15, 10);
        LocalTime end = LocalTime.of(12, 30);
        Duration duration = Duration.between(init, end);
        System.out.println(duration);
        LocalDate datePay = LocalDate.of(2025, 11, 10);
        Period period = Period.between(dateFirstInstallment, datePay);
        System.out.println("São " + period.getDays() +  " Dias e " + period.getMonths() + " Meses");

    }
}