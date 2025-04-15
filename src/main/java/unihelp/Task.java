package unihelp;

public class Task {
	private String title;
    private boolean isComplete;

    public Task(String title) {
        this.title = title;
        this.isComplete = false;
    }

    public Task(String title, boolean isComplete) {
        this.title = title;
        this.isComplete = isComplete;
    }

    public String getTitle() {
        return title;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void markComplete() {
        this.isComplete = true;
    }

    @Override
    public String toString() {
        return (isComplete ? "[✓] " : "[x] ") + title;
    }

    public String toCSV() {
        return title + "," + isComplete;
    }

    public static Task fromCSV(String line) {
        String[] parts = line.split(",");
        if (parts.length == 2) {
            return new Task(parts[0], Boolean.parseBoolean(parts[1]));
        }
        return null;
    }
}
