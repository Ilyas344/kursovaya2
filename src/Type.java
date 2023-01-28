public enum Type {
    WORK("Рабочий"),
    PERSONAL("Личный");
    private String type;

    Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }


}
