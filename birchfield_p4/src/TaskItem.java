public class TaskItem {
    private String title;
    private String description;
    private String dueDate;
    private boolean completed;

    public TaskItem(String title, String description, String dueDate) {
        if (isTitleValid(title)) {
            this.title = title;
        } else {
            throw new InvalidTitleException("WARNING: title must be at least 1 character long; task not created");
        }
        if (isDueDateValid(dueDate)) {
            this.dueDate = dueDate;
        } else {
            throw new InvalidDateException("WARNING: invalid due date; task not created");
        }
        this.description = description;
        this.completed = false;
    }

    private boolean isTitleValid(String title) {
        return title.length() > 0;
    }
    private boolean isDueDateValid(String dueDate) {
        try {
            int year = Integer.parseInt(dueDate.substring(0, 4));
            int month = Integer.parseInt(dueDate.substring(5, 7));
            int day = Integer.parseInt(dueDate.substring(8));
            if ((dueDate.length() == 10) && (dueDate.substring(4, 5).equals("-")) && (dueDate.substring(7, 8).equals("-"))
                    && (year > 0) && (year <= 3000) && (month > 0) && (month <= 12) && (day > 0) && (day <= 31) && (februaryDays(month, day, year))
                    && (thirtyDayMonths(month, day))) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("An error occurred.");
            return false;
        }
    }
    private boolean februaryDays(int month, int day, int year) {
        if(month == 2 && year % 400 == 0) {
            return day <= 29;
        } else if (month == 2 && year % 100 == 0) {
            return day <= 28;
        } else if (month == 2 && year % 4 == 0) {
            return day <= 29;
        } else if (month == 2) {
            return day <= 28;
        } else {
            return true;
        }
    }
    private boolean thirtyDayMonths(int month, int day) {
        if (month == 4 || month == 6 || month == 8 || month == 11) {
            return day <= 30;
        } else {
            return true;
        }
    }

    public void setTitle(String title) {
        if (isTitleValid(title)) {
            this.title = title;
        } else {
            throw new InvalidTitleException("WARNING: title must be at least 1 character long; task not edited");
        }
    }
    public String getTitle() {
        return this.title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }

    public void setDueDate(String dueDate) {
        if (isDueDateValid(dueDate)) {
            this.dueDate = dueDate;
        } else {
            throw new InvalidDateException("WARNING: invalid due date; task not created");
        }
    }
    public String getDueDate() {
        return this.dueDate;
    }

    public void setCompleted(boolean complete) {
        this.completed = complete;
    }
    public boolean getCompleted() {
        return this.completed;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s: %s", this.dueDate, this.title, this.description);
    }
}

class InvalidTitleException extends IllegalArgumentException {
    public InvalidTitleException(String message) {
        super(message);
    }
}
class InvalidDateException extends IllegalArgumentException {
    public InvalidDateException(String message) {
        super(message);
    }
}
