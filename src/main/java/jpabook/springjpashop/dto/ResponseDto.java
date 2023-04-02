package jpabook.springjpashop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto<D>{
    private  boolean result;
    private String message;
    private D data;

    public static <D> ResponseDto<D> setSuccess(String message, D data){
        return new ResponseDto<D>(true,message, data);
    }
    public static <D> ResponseDto<D> setFailed(String message){
        return new ResponseDto<D>(false, message, null);
    }
}
