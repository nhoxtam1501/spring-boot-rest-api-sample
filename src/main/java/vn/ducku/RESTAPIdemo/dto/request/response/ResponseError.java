package vn.ducku.RESTAPIdemo.dto.request.response;

public class ResponseError extends ResponseData {

    public ResponseError(int status, String message) {
        super(status, message);
    }
}
