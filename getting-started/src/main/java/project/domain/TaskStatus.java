package project.domain;

public enum TaskStatus {
    NOT_STARTED("0","未着手"),
    IN_PROGRESS("1","着手"),
    COMPLETED("2","完了");

    private final String code;
    private final String name;

    TaskStatus(String code, String japaneseName) {
        this.code = code;
        this.name = japaneseName;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public static TaskStatus fromCode(String code) {
        for (TaskStatus status : TaskStatus.values()) {
            if (status.code.equals(code)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }

    @Override
    public String toString() {
        return name;
    }


}
