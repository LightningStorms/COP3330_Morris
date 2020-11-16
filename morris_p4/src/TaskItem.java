public class TaskItem {
    private String title;
    private String description;
    private String dueDate;
    private boolean status;

    public TaskItem(String title, String description, String dueDate){
        if(isTitleValid(title)){
            this.title = title;
        } else {
            throw new InvalidTitleException("Title should be longer than 1 character long");
        }
        if(isDescriptionValid(description)){
            this.description = description;
        } else {
            throw new InvalidDescriptionException("Description should be longer than 0 characters");
        }
        if(isDateValid(dueDate)) {
            this.dueDate = dueDate;
        } else {
            throw new InvalidDateException("Date should be in YYYY-MM-DD format");
        }

        this.status = false;
    }

    public void setTitle(String title){
        if(isTitleValid(title)){
            this.title = title;
        } else {
            throw new InvalidTitleException("Title should be longer than 1 character long");
        }
    }

    public void setDescription(String description){
        if(isDescriptionValid(description)){
            this.description = description;
        } else {
            throw new InvalidDescriptionException("Description should be longer than 0 characters");
        }
    }

    public void setDueDate(String dueDate){
        if(isDateValid(dueDate)) {
            this.dueDate = dueDate;
        } else {
            throw new InvalidDateException("Date should be in YYYY-MM-DD format");
        }
    }

    public void setStatus(boolean status){
        this.status = status;
    }

    public boolean getStatus(){
        return status;
    }

    private boolean isTitleValid(String title){
        return title.length() > 1;
    }

    private boolean isDescriptionValid(String description){
        return description.length() > 0;
    }

    private  boolean isDateValid(String dueDate){
        if(dueDate.length()!=10){
            return false;
        }

        String[] dateBits = dueDate.split("-");

        if (dateBits[0].length()!=4) {
            return false;
        } else if(dateBits[1].length()!=2) {
            return false;
        } else if(dateBits[2].length()!=2){
            return false;
        } else {
            return true;
        }
    }

    public String getTitle(){
        return this.title;
    }

    public String getDescription(){
        return this.description;
    }

    public String getDueDate(){
        return this.dueDate;
    }

    @Override
    public String toString() {
        return "[" + dueDate + "] " + title + ": " + description;
    }

}

class InvalidTitleException extends IllegalArgumentException {
    public InvalidTitleException(String msg) {
        super(msg);
    }
}

class InvalidDescriptionException extends IllegalArgumentException {
    public InvalidDescriptionException(String msg) {
        super(msg);
    }
}

class InvalidDateException extends IllegalArgumentException {
    public InvalidDateException(String msg) {
        super(msg);
    }
}