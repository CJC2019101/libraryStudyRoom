package cn.cqucc.library.status;

/**
 * @author JianfeiChen
 * @date 2020/4/17 8:49
 * @Description 状态码实体类
 */
public enum StatusCode {
    Success(200,"成功"),
    Fail(502,"失败"),
    NotFound(404,"不存在"),
    Entity_Not_Exist(405,"实体信息不存在"),
    Invalid_Params(406,"请求参数不合法!");

    private Integer code;
    private String msg;

    StatusCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
