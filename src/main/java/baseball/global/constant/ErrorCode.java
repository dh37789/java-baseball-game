package baseball.global.constant;

public enum ErrorCode {
    NOT_INPUT("입력값이 없습니다."),
    INVALID_NUMBER("숫자만 입력해 주세요."),
    INPUT_ZERO("0외에 다른 숫자를 입력해 주세요."),
    INVALID_LENGTH("입력된 값의 숫자가 3자리가 아닙니다."),
    INPUT_DUPLICATE("중복된 값이 입력되었습니다.");

    private String message;

    public String getMessage() {
        return message;
    }

    ErrorCode (String message){
        this.message = message;
    }

}
