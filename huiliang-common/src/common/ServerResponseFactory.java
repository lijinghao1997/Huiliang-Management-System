package common;

public class ServerResponseFactory {
    public static ServerResponse createSuccessResponseByMsg(String msg){
        ServerResponse serverResponse=new ServerResponse();
        serverResponse.setMsg(msg);
        serverResponse.setStatus(ResponseCode.SUCCESS.getCode());
        return serverResponse;
    }


    public static <T> ServerResponse createSuccessResponseByData(T data){
        ServerResponse serverResponse=new ServerResponse();
        serverResponse.setData(data);
        serverResponse.setStatus(ResponseCode.SUCCESS.getCode());
        return serverResponse;
    }

    public static ServerResponse createNotFound(String msg){
        ServerResponse serverResponse=new ServerResponse();
        serverResponse.setMsg(msg);
        serverResponse.setStatus(ResponseCode.NOT_FOUND.getCode());
        return serverResponse;
    }


    public static ServerResponse createError(String msg){
        ServerResponse serverResponse=new ServerResponse();
        serverResponse.setMsg(msg);
        serverResponse.setStatus(ResponseCode.ERROR.getCode());
        return serverResponse;
    }


    public static ServerResponse createIllegalArgument(String msg){
        ServerResponse serverResponse=new ServerResponse();
        serverResponse.setMsg(msg);
        serverResponse.setStatus(ResponseCode.ILLEGAL_ARGUMENT.getCode());
        return serverResponse;
    }

}
