package br.com.israel.ismotFlix.calculated;
import br.com.israel.ismotFlix.models.Title;

public class TimeCalculator {
    private int totalTime;

    public int getTotalTime() {
        return totalTime;
    }

    public void includes(Title t) {
        totalTime += t.getDurationMinutes();
    }
}
